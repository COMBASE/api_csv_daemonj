package net.combase.cloud.butler;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.*;

import net.combase.api.ApiProperties;
import net.combase.cloud.api.swoppen.db.DBController;
import net.combase.cloud.api.swoppen.db.DbReader;
import net.combase.cloud.api.swoppen.db.DbWriter;

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
		dbc = DBController.get();
		dbc.initDBConnection();

		try {
			DbWriter.createTableFiles();
			DbWriter.createTableCustomer();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		// dbc.handleDB();
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

		ApiProperties.get().setToken(DbReader.getToken(processTrayIcon));
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
				JOptionPane.showMessageDialog(null,
						"This dialog box is run from System Tray");
			}
		});

	}

	private void startProcess() throws IOException {
		final Swoppen swoppen = new Swoppen(processTrayIcon);
		Thread thread = new Thread(new Runnable() {
			public void run() {

				try {
					DbReader.getToken(processTrayIcon);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				boolean runSwoppen = true;
				while (true) {
					try {
						Thread.sleep(ApiProperties.get().getTimeOut());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (runSwoppen)
						runSwoppen = swoppen.doRun(ApiProperties.get()
								.getCashin(), ApiProperties.get().getCashout());
				}
			}
		});
		thread.start();
	}
}
