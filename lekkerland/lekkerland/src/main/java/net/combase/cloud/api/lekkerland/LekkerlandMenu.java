package net.combase.cloud.api.lekkerland;

import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class LekkerlandMenu extends Menu {

	private static final long serialVersionUID = 3147898780501005074L;
	private MenuItem stockOrderItem;
	private MenuItem orderConfirmationItem;
	private MenuItem stockReceiptItem;
	private MenuItem disptachNotificationItem;

	private String MESSAGE_HEADER = "Lekkerland Handler";
	private String dispatchNotificationsFolder;
	private final DispatchNotification dispatchNotification;

	public LekkerlandMenu(final TrayIcon trayIcon, String label) {
		super(label);

		try {

			InputStream file = new FileInputStream(new File(
					"lekkerland.properties"));
			Properties props = new Properties();
			props.load(file);
			dispatchNotificationsFolder = props
					.getProperty("dispatchNotifications");
		} catch (Exception e) {
			System.out.println("error" + e);
		}

		dispatchNotification = new DispatchNotification(trayIcon,
				dispatchNotificationsFolder);
		ActionListener listener = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				MenuItem item = (MenuItem) e.getSource();
				if ("Stock Orders".equals(item.getLabel())) {
					trayIcon.displayMessage(MESSAGE_HEADER, "This is an "
							+ item.getLabel() + " message",
							TrayIcon.MessageType.ERROR);
				} else if ("Order Confirmation".equals(item.getLabel())) {
					trayIcon.displayMessage(MESSAGE_HEADER,
							"This is a " + item.getLabel() + " message",
							TrayIcon.MessageType.WARNING);
				} else if ("Stock Receipt".equals(item.getLabel())) {
					trayIcon.displayMessage(MESSAGE_HEADER, "This is an "
							+ item.getLabel() + " message",
							TrayIcon.MessageType.INFO);
				} else if ("Dispatch Notification".equals(item.getLabel())) {
					trayIcon.displayMessage(MESSAGE_HEADER, "This is an "
							+ item.getLabel() + " message",
							TrayIcon.MessageType.NONE);
					dispatchNotification.showFolder();
				}
			}
		};

		stockOrderItem = new MenuItem("Stock Orders");
		orderConfirmationItem = new MenuItem("Order Confirmation");
		stockReceiptItem = new MenuItem("Stock Receipt");
		disptachNotificationItem = new MenuItem("Dispatch Notification");
		// Add listeners to Display menu items.
		stockOrderItem.addActionListener(listener);
		orderConfirmationItem.addActionListener(listener);
		stockReceiptItem.addActionListener(listener);
		disptachNotificationItem.addActionListener(listener);
		add(stockOrderItem);
		add(orderConfirmationItem);
		add(stockReceiptItem);
		add(disptachNotificationItem);
	}
}
