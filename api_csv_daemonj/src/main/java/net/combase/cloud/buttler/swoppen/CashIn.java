package net.combase.cloud.buttler.swoppen;

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

import au.com.bytecode.opencsv.CSVReader;

import net.combase.api.ApiProperties;
import net.combase.cloud.buttler.db.DbReader;
import net.combase.cloud.buttler.db.domain.FilesParsed;

public class CashIn {

	private final TrayIcon processTrayIcon;

	public CashIn() {
		this(null);
	}

	public CashIn(TrayIcon processTrayIcon) {
		this.processTrayIcon = processTrayIcon;
	}

	public boolean readFolder(File file) {
		final List<File> listFiles = listFilesForFolder(file);
		for (File f : listFiles) {

			try {
				String md5 = getMD5Checksum(f.getAbsolutePath());
				if (!checkFileWithDB(f.getAbsolutePath(), md5)) {
					parseFile(f);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	private static void parseFile(File f) {
		try {
			CSVReader reader = new CSVReader(new FileReader(f), ';');

			try {

				String[] values = reader.readNext();
				while (values != null) {
					System.out.println(Arrays.asList(values));
					values = reader.readNext();
				}
			} finally {
				// we have to close reader manually
				reader.close();
			}
		} catch (IOException e) {
			// we have to process exceptions when it is not required
			e.printStackTrace();
		}

		System.out.print("parse\n");
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
}
