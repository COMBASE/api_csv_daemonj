package net.combase.cloud.buttler;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import net.combase.cloud.buttler.db.DBController;
import net.combase.cloud.buttler.db.DbReader;

/**
 *
 * @author mziescha
 *
 */

public class CloudButler {

	TrayIcon processTrayIcon = null;

	private static final String TOOL_TIP = "Mindfire Tool Tip";

	private static DBController dbc;
	public static void main(String[] args) {
		dbc = DBController.getInstance();
		dbc.initDBConnection();
//		dbc.handleDB();
		try {
			CloudButler systemTrayExample = new CloudButler();
			systemTrayExample.createAndAddApplicationToSystemTray();
			systemTrayExample.startProcess();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void createAndAddApplicationToSystemTray() throws IOException {
		// Check the SystemTray support
		if (!SystemTray.isSupported()) {
			System.out.println("SystemTray is not supported");
			return;
		}
		Image image = new ImageIcon("").getImage();
		final TrayIcon trayIcon = new TrayIcon(image, TOOL_TIP);
		this.processTrayIcon = trayIcon;
		final SystemTray tray = SystemTray.getSystemTray();
		final PopupMenu popup = new TrayMenu(tray, trayIcon);

		trayIcon.setPopupMenu(popup);
		trayIcon.setImageAutoSize(true);

		try {
			tray.add(trayIcon);
		} catch (AWTException e) {
			System.out.println("TrayIcon could not be added.");
			return;
		}

		// Add listener to trayIcon.
		trayIcon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "This dialog box is run from System Tray");
			}
		});

	}

	private void startProcess() throws IOException {

		Thread thread = new Thread(new Runnable() {

			public void run() {

				try {
					DbReader.getToken(processTrayIcon);
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				while (true) {
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					// processTrayIcon.displayMessage("Mindfire Process Message",
					// "This is message number ",
					// TrayIcon.MessageType.INFO);
				}

			}
		});

		thread.start();
	}
}
