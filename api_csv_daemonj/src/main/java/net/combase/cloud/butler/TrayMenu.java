package net.combase.cloud.butler;

import java.awt.CheckboxMenuItem;
import java.awt.Dimension;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JOptionPane;

import net.combase.cloud.api.lekkerland.LekkerlandMenu;
import net.combase.cloud.butler.ui.ProductListener;
import net.combase.cloud.butler.ui.ReceiptListPanel;

public class TrayMenu extends PopupMenu {

	private static final String MESSAGE_HEADER = "Mindfire SystemTray Example";
	private static final String TOOL_TIP = "Mindfire Tool Tip";
	private static final long serialVersionUID = -3117734596065069251L;
	private MenuItem aboutItem;
	private MenuItem exitItem;
	private MenuItem productUiItem;
	private final SystemTray tray;
	private final TrayIcon trayIcon;
	private CheckboxMenuItem autoSizeCheckBox;
	private CheckboxMenuItem toolTipCheckBox;
	private Menu displayMenu;
	private MenuItem errorItem;
	private MenuItem warningItem;
	private MenuItem infoItem;
	private MenuItem noneItem;
	private MenuItem receiptUiItem;
	private MenuItem llItem;
	private Menu llMenu;

	public TrayMenu(final SystemTray tray, final TrayIcon trayIcon) {
		super();
		this.tray = tray;
		this.trayIcon = trayIcon;
		this.add(getAboutItem());
		this.add(getProductUiItem());
		this.add(getReceiptUiItem());
		this.addSeparator();
		this.add(getAutoSizeCheckBox());
		this.add(getToolTipCheckBox());
		this.addSeparator();
		this.add(getllMenu());
		this.add(getDisplayMenu());
		this.addSeparator();
		this.add(getExitItem());
	}

	public MenuItem getProductUiItem() {
		if (productUiItem == null) {
			productUiItem = new MenuItem("Show Product UI");
			productUiItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Dimension dimension = Toolkit.getDefaultToolkit()
								.getScreenSize(); // Screensize
													// bestimmen
						ProductListener window = new ProductListener(); // MainWindow
																		// erstellen
						int x = (int) ((dimension.getWidth() - window
								.getFrmShowProduct().getWidth()) / 2);
						int y = (int) ((dimension.getHeight() - window
								.getFrmShowProduct().getHeight()) / 2);
						window.getFrmShowProduct().setVisible(true); // Fenster
						// sichtbar
						// machen
						window.getFrmShowProduct().setLocation(x, y); // Fenster
						// zentrieren
						// auf dem
						// Bildschirm
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			});
		}
		return productUiItem;
	}

	public MenuItem getReceiptUiItem() {
		if (receiptUiItem == null) {
			receiptUiItem = new MenuItem("Show Receipt Panel");
			receiptUiItem.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					try {
						new ReceiptListPanel();

					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			});
		}
		return receiptUiItem;
	}

	public MenuItem getLlItemItem() {
		if (llItem == null) {
			llItem = new MenuItem("Show Lekkerland Menu");
			llItem.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					try {
						new ReceiptListPanel();

					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			});
		}
		return llItem;
	}

	public CheckboxMenuItem getAutoSizeCheckBox() {
		if (autoSizeCheckBox == null) {
			autoSizeCheckBox = new CheckboxMenuItem("Set auto size");
			autoSizeCheckBox.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					int autoSizeCheckBoxId = e.getStateChange();
					if (autoSizeCheckBoxId == ItemEvent.SELECTED) {
						trayIcon.setImageAutoSize(true);
					} else {
						trayIcon.setImageAutoSize(false);
					}
				}
			});
			autoSizeCheckBox.setState(true);
		}
		return autoSizeCheckBox;
	}

	public CheckboxMenuItem getToolTipCheckBox() {
		if (toolTipCheckBox == null) {
			toolTipCheckBox = new CheckboxMenuItem("Set tooltip");
			toolTipCheckBox.setState(true);
			toolTipCheckBox.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					int toolTipCheckBoxId = e.getStateChange();
					if (toolTipCheckBoxId == ItemEvent.SELECTED) {
						trayIcon.setToolTip(TOOL_TIP);
					} else {
						trayIcon.setToolTip(null);
					}
				}
			});
		}
		return toolTipCheckBox;
	}

	public MenuItem getDisplayMenu() {
		if (displayMenu == null) {
			displayMenu = new Menu("Display");
			// Create listener for Display menu items.
			ActionListener listener = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MenuItem item = (MenuItem) e.getSource();
					if ("Error".equals(item.getLabel())) {
						trayIcon.displayMessage(MESSAGE_HEADER, "This is an "
								+ item.getLabel() + " message",
								TrayIcon.MessageType.ERROR);
					} else if ("Warning".equals(item.getLabel())) {
						trayIcon.displayMessage(MESSAGE_HEADER, "This is a "
								+ item.getLabel() + " message",
								TrayIcon.MessageType.WARNING);
					} else if ("Info".equals(item.getLabel())) {
						trayIcon.displayMessage(MESSAGE_HEADER, "This is an "
								+ item.getLabel() + " message",
								TrayIcon.MessageType.INFO);
					} else if ("None".equals(item.getLabel())) {
						trayIcon.displayMessage(MESSAGE_HEADER, "This is an "
								+ item.getLabel() + " message",
								TrayIcon.MessageType.NONE);
					}
				}
			};

			errorItem = new MenuItem("Error");
			warningItem = new MenuItem("Warning");
			infoItem = new MenuItem("Info");
			noneItem = new MenuItem("None");
			// Add listeners to Display menu items.
			errorItem.addActionListener(listener);
			warningItem.addActionListener(listener);
			infoItem.addActionListener(listener);
			noneItem.addActionListener(listener);
			displayMenu.add(errorItem);
			displayMenu.add(warningItem);
			displayMenu.add(infoItem);
			displayMenu.add(noneItem);
		}
		return displayMenu;
	}

	public MenuItem getllMenu() {
		if (llMenu == null) 
			llMenu = new LekkerlandMenu(trayIcon, "Show Lekkerland Menu");
		return llMenu;
	}

	public MenuItem getAboutItem() {
		if (aboutItem == null) {
			aboutItem = new MenuItem("Tray Info");
			aboutItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null,
							"This dialog is all about system tray program");
				}
			});
		}
		return aboutItem;
	}

	public MenuItem getExitItem() {
		if (exitItem == null) {
			exitItem = new MenuItem("Exit");
			exitItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tray.remove(trayIcon);
					System.exit(0);
				}
			});
		}
		return exitItem;
	}
}
