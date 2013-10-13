package net.combase.cloud.buttler.swoppen;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

import net.combase.cloud.buttler.db.DBController;

public class CashIn {

	public static boolean readFolder(File file) {
		final List<File> listFiles = listFilesForFolder(file);
		for (File f : listFiles) {

			try {
				String md5 = getMD5Checksum(f.getAbsolutePath());
				boolean isAllreadyInsert = DBController.get().checkFileWithDB(f.getAbsolutePath(), md5);
				System.out.print(md5);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	private static List<File> listFilesForFolder(final File folder) {
		List<File> ret = new ArrayList<File>();
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

}
