package net.combase.cloud.api.lekkerland;

import java.awt.TrayIcon;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import net.combase.cloud.api.lekkerland.reader.DispatchNotificationLineType;
import net.combase.cloud.api.lekkerland.reader.DispatchNotificationReaderImpl;
import net.combase.cloud.api.lekkerland.reader.Recordart;

public class DispatchNotification {
	private static JTextArea filesTextArea;
	private String folder;
	private TrayIcon processTrayIcon;
	private final DispatchNotificationReaderImpl dispatchNotificationReaderImpl;

	public DispatchNotification(final TrayIcon trayIcon, final String folder) {
		// TODO Auto-generated constructor stub
		this.folder = folder;
		this.processTrayIcon = trayIcon;
		dispatchNotificationReaderImpl = new DispatchNotificationReaderImpl();
		try {
			startProcess();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void startProcess() throws IOException {
		Thread thread = new Thread(new Runnable() {
			public void run() {

				while (true) {
					try {
						Thread.sleep(60000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread.start();
	}

	public void showFolder() {
		readFolder(new File(folder));
		final JFrame frame = new JFrame();
		frame.setSize(300, 300);
		frame.setLocation(500, 100);
		frame.add(getTextArea());
		frame.setVisible(true);
	}

	private List<File> listFilesForFolder(final File folder) {
		List<File> ret = new ArrayList<File>();
		if (folder.listFiles() == null) {
			if (processTrayIcon != null)
				processTrayIcon.displayMessage("Connection Error Message",
						"Could not find folder " + folder,
						TrayIcon.MessageType.ERROR);
			return ret;
		}
		for (final File fileEntry : folder.listFiles()) {
			if (!fileEntry.isDirectory())
				ret.add(fileEntry);
		}
		return ret;
	}

	public static JTextArea getTextArea() {
		if (filesTextArea == null)
			filesTextArea = new JTextArea();
		return filesTextArea;
	}

	public boolean readFolder(File file) {
		final List<File> listFiles = listFilesForFolder(file);
		for (File f : listFiles) {
			getTextArea().setText(getTextArea().getText() + "\n" + f.getName());

			BufferedReader br = null;
			try {
				String sCurrentLine;
				br = new BufferedReader(new FileReader(f));

				while ((sCurrentLine = br.readLine()) != null) {
					if (sCurrentLine.length() <= 3)
						continue;
					if (sCurrentLine.startsWith(Recordart.A10.name())) {
						dispatchNotificationReaderImpl.readA10(sCurrentLine);
					} else if (sCurrentLine.startsWith(Recordart.E01.name())) {
						final int[] fields = {
								DispatchNotificationLineType.E01_001_RECORDART
										.getCode(),
								DispatchNotificationLineType.E01_002_DATENART
										.getCode(),
								DispatchNotificationLineType.E01_003_VERSION
										.getCode(),
								DispatchNotificationLineType.E01_004_PARTNERNUMMER
										.getCode(),
								DispatchNotificationLineType.E01_005_ERSTELLUNGSDATUM
										.getCode(),
								DispatchNotificationLineType.E01_006_ERSTELLUNGSZEIT
										.getCode(),
								DispatchNotificationLineType.E01_007_ANZAHL_DATENSAETZE
										.getCode(),
								DispatchNotificationLineType.E01_008_LAUFNUMMER
										.getCode() };
						dispatchNotificationReaderImpl.readA10(sCurrentLine);
					} else if (sCurrentLine.startsWith(Recordart.L10.name())) {
						
						dispatchNotificationReaderImpl.readA10(sCurrentLine);
					} else if (sCurrentLine.startsWith(Recordart.L20.name())) {

						
						dispatchNotificationReaderImpl.readA10(sCurrentLine);
					} else if (sCurrentLine.startsWith(Recordart.L25.name())) {
						
						dispatchNotificationReaderImpl.readA10(sCurrentLine);
					} else if (sCurrentLine.startsWith(Recordart.S01.name())) {

						
						dispatchNotificationReaderImpl.readA10(sCurrentLine);
					} else if (sCurrentLine.startsWith(Recordart.Z90.name())) {
						final int[] fields = {
								DispatchNotificationLineType.Z90_001_RECORDART
										.getCode(),
								DispatchNotificationLineType.Z90_002_DATENART
										.getCode(),
								DispatchNotificationLineType.Z90_003_VERSION
										.getCode(),
								DispatchNotificationLineType.Z90_004_PARTNERART
										.getCode(),
								DispatchNotificationLineType.Z90_005_PARTNERNUMMER
										.getCode(),
								DispatchNotificationLineType.Z90_006_UEBERMITTLUNGSART
										.getCode(),
								DispatchNotificationLineType.Z90_007_PAKETNUMMER
										.getCode(),
								DispatchNotificationLineType.Z90_008_ZIP_FLAG
										.getCode(),
								DispatchNotificationLineType.Z90_009_RESTART_NUMMER
										.getCode(),
								DispatchNotificationLineType.Z90_010_ABSENDENDES_SYSTEM
										.getCode(),
								DispatchNotificationLineType.Z90_011_EMPFANGENDES_SYSTEM
										.getCode() };
						dispatchNotificationReaderImpl.readA10(sCurrentLine);
					}
				}

			} catch (IOException e) {
				if (processTrayIcon != null)
					processTrayIcon.displayMessage("Error Message", "" + e,
							TrayIcon.MessageType.ERROR);
			} finally {
				try {
					if (br != null)
						br.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
		return true;
	}
}
