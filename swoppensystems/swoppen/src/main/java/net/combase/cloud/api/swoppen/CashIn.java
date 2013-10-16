package net.combase.cloud.api.swoppen;

import java.awt.TrayIcon;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONObject;

import au.com.bytecode.opencsv.CSVReader;

import net.combase.api.ApiProperties;
import net.combase.api.domain.Customer;
import net.combase.api.domain.CustomerGroup;
import net.combase.api.service.CustomerApiService;
import net.combase.cloud.api.swoppen.db.DbReader;
import net.combase.cloud.api.swoppen.db.DbWriter;
import net.combase.cloud.api.swoppen.db.domain.FilesParsed;
import net.combase.cloud.api.swoppen.db.domain.ImportedCustomer;

public class CashIn {

	private final TrayIcon processTrayIcon;
	private final CustomerGroup customerGroup;

	public CashIn(TrayIcon processTrayIcon, final CustomerGroup customerGroup) {
		this.processTrayIcon = processTrayIcon;
		this.customerGroup = customerGroup;
	}

	public boolean readFolder(File file) {
		final List<File> listFiles = listFilesForFolder(file);
		for (File f : listFiles) {

			try {
				String md5 = getMD5Checksum(f.getAbsolutePath());
				if (!checkFileWithDB(f.getAbsolutePath(), md5)) {
					final FilesParsed filesParsed = DbWriter.setFile(getCustomerGroup().getNumber(),
							f.getAbsolutePath());
					parseFile(f, filesParsed);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	private void parseFile(final File f, final FilesParsed filesParsed) {
		try {
			CSVReader reader = new CSVReader(new FileReader(f), ';');
			try {
				System.out.print("parse: " + f + "\n");
				String[] values = reader.readNext();
				while (values != null) {
					Customer customer = handleCashInLine(values, filesParsed);
					if(customer != null)
						System.out.println(new JSONObject(customer));
					else
						System.out.println(customer);
					values = reader.readNext();
				}
			} finally {
				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private List<File> listFilesForFolder(final File folder) {
		List<File> ret = new ArrayList<File>();
		if (folder.listFiles() == null) {
			if (processTrayIcon != null)
				processTrayIcon.displayMessage("Connection Error Message", "Could not find folder " + folder,
						TrayIcon.MessageType.ERROR);
			return ret;
		}
		for (final File fileEntry : folder.listFiles()) {
			if (!fileEntry.isDirectory())
				ret.add(fileEntry);
		}
		return ret;
	}

	public static byte[] createChecksum(String filename) throws Exception {
		InputStream fis = new FileInputStream(filename);

		byte[] buffer = new byte[1024];
		MessageDigest complete = MessageDigest.getInstance("MD5");
		int numRead;

		do {
			numRead = fis.read(buffer);
			if (numRead > 0) {
				complete.update(buffer, 0, numRead);
			}
		} while (numRead != -1);

		fis.close();
		return complete.digest();
	}

	public static String getMD5Checksum(String filename) throws Exception {
		byte[] b = createChecksum(filename);
		String result = "";
		for (int i = 0; i < b.length; i++)
			result += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
		return result;
	}

	public static boolean checkFileWithDB(String absolutePath, String md5) {
		try {
			FilesParsed fileByPath = DbReader.getFileByPath(ApiProperties.get().getCustomerGroupNumber(), absolutePath);
			if (fileByPath != null) {
				if (md5.equals(fileByPath.getMd5Hash()))
					return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	private Customer handleCashInLine(final String[] fields, final FilesParsed filesParsed) {
		final String customerNumber = fields[0];
		ImportedCustomer existingClienCustomer = DbReader.getCustomer(customerNumber);
		final Customer existingCloudCustomer = CustomerApiService.getByNumber(Long.valueOf(customerNumber));
		if (existingClienCustomer != null && existingCloudCustomer != null) {
			existingClienCustomer.setStatus(2);
			DbWriter.updateCustomer(existingClienCustomer);
			return existingCloudCustomer;
		}

		Customer newCloudCustomer = new Customer();
		newCloudCustomer.setNumber(customerNumber);
		newCloudCustomer.setName(fields[1] + " " + fields[2]);
		newCloudCustomer.setFirstName(fields[1]);
		newCloudCustomer.setLastName(fields[2]);
		newCloudCustomer.setCustomerGroup(getCustomerGroup().getNumber());
		newCloudCustomer = CustomerApiService.saveCustomer(newCloudCustomer);

		if (newCloudCustomer != null) {
			existingClienCustomer = new ImportedCustomer();
			existingClienCustomer.setStatus(2);
			existingClienCustomer.setCustomerGroupNumber(Long.valueOf(getCustomerGroup().getNumber()));
			existingClienCustomer.setCustomerNumber(Long.valueOf(newCloudCustomer.getNumber()));
			existingClienCustomer.setCustomerName(newCloudCustomer.getName());
			existingClienCustomer.setCustomerGroupNumber(Long.valueOf(getCustomerGroup().getNumber()));
			DbWriter.setCustomer(existingClienCustomer);
			return newCloudCustomer;
		}
		return null;
	}

	public CustomerGroup getCustomerGroup() {
		return customerGroup;
	}
}
