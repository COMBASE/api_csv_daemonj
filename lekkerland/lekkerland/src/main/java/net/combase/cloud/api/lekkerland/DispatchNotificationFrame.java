package net.combase.cloud.api.lekkerland;

import java.awt.TrayIcon;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import net.combase.api.domain.DispatchContainer;
import net.combase.api.domain.DispatchItem;
import net.combase.api.domain.DispatchNotification;
import net.combase.api.domain.Supplier;
import net.combase.cloud.api.lekkerland.reader.DispatchNotificationReaderImpl;
import net.combase.cloud.api.lekkerland.reader.Recordart;

public class DispatchNotificationFrame
{
	private static JTextArea filesTextArea;
	private String folder;
	private TrayIcon processTrayIcon;
	private final DispatchNotificationReaderImpl dispatchNotificationReaderImpl;
	private final Supplier supplier;

	public DispatchNotificationFrame(final TrayIcon trayIcon, final Supplier supplier,
		final String folder)
	{
		// TODO Auto-generated constructor stub
		this.folder = folder;
		this.processTrayIcon = trayIcon;
		dispatchNotificationReaderImpl = new DispatchNotificationReaderImpl();
		this.supplier = supplier;
		try
		{
			startProcess();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void startProcess() throws IOException
	{
		Thread thread = new Thread(new Runnable()
		{
			public void run()
			{

				while (true)
				{
					try
					{
						Thread.sleep(60000);
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			}
		});
		thread.start();
	}

	public void showFolder()
	{
		readFolder(new File(folder));
		final JFrame frame = new JFrame();
		frame.setSize(300, 300);
		frame.setLocation(500, 100);
		frame.add(getTextArea());
		frame.setVisible(true);
	}

	private List<File> listFilesForFolder(final File folder)
	{
		List<File> ret = new ArrayList<File>();
		if (folder.listFiles() == null)
		{
			if (processTrayIcon != null)
				processTrayIcon.displayMessage("Connection Error Message",
					"Could not find folder " + folder, TrayIcon.MessageType.ERROR);
			return ret;
		}
		for (final File fileEntry : folder.listFiles())
		{
			if (!fileEntry.isDirectory())
				ret.add(fileEntry);
		}
		return ret;
	}

	public static JTextArea getTextArea()
	{
		if (filesTextArea == null)
			filesTextArea = new JTextArea();
		return filesTextArea;
	}

	public boolean readFolder(File file)
	{
		final List<File> listFiles = listFilesForFolder(file);
		for (File f : listFiles)
		{
			getTextArea().setText("");
			getTextArea().setText(getTextArea().getText() + "\n" + f.getName());
			final DispatchNotification readFolder = getDispatchNotificationFromFolder(file);
			readFolder.getBookedBy();
		}
		return false;

	}

	private DispatchNotification getDispatchNotificationFromFolder(File file)
	{
		final DispatchNotification ret = new DispatchNotification();
		BufferedReader br = null;
		try
		{
			String sCurrentLine;
			br = new BufferedReader(new FileReader(file));
			
			ret.setContainers(new ArrayList<DispatchContainer>());
			DispatchContainer container = null;
			while ((sCurrentLine = br.readLine()) != null)
			{
				if (sCurrentLine.length() <= 3)
					continue;
				if (sCurrentLine.startsWith(Recordart.A10.name()))
				{
					final String[] readA10 = dispatchNotificationReaderImpl.readA10(sCurrentLine);
					final String supplierCustomer = Integer.valueOf(readA10[4]).toString();

					if (supplierCustomer.equals(supplier.getCustomerNumber()))
						System.out.println(supplier.getCustomerNumber() + " " + supplier.getName());
				}
				else if (sCurrentLine.startsWith(Recordart.S01.name()))
				{
					final String[] readS01 = dispatchNotificationReaderImpl.readS01(sCurrentLine);
					final Date date = dispatchNotificationReaderImpl.getDate(readS01[4], readS01[5]);
					final String mail = readS01[8].trim();
				}
				else if (sCurrentLine.startsWith(Recordart.L10.name()))
				{
					final String[] readL10 = dispatchNotificationReaderImpl.readL10(sCurrentLine);
					final Integer dispatchNotificationNumber = Integer.valueOf(readL10[4]);
					final Date deliveryDate = dispatchNotificationReaderImpl.getDate(readL10[1],
						"000000");
				}
				else if (sCurrentLine.startsWith(Recordart.L20.name()))
				{
					if (container == null)
					{
						container = new DispatchContainer();
						container.setItems(new ArrayList<DispatchItem>());
					}
					final DispatchItem containerItem = new DispatchItem();
					final String[] readL20 = dispatchNotificationReaderImpl.readL20(sCurrentLine);
					containerItem.setOrderQuantity(new BigDecimal(readL20[4]));
					containerItem.setDeliveryQuantity(new BigDecimal(readL20[8]));
					final String orderedProductNumber = Integer.valueOf(readL20[2]).toString();
					final String orderedEan = Long.valueOf(readL20[3].trim()).toString();

					final String deliferedProductNumber = Long.valueOf(readL20[5].trim())
						.toString();
					final String deliferedEan = Long.valueOf(readL20[7].trim()).toString();

					final BigDecimal netPrice = new BigDecimal(readL20[17]).divide(new BigDecimal(
						100), 2, RoundingMode.HALF_UP);
					final BigDecimal sellPrice = new BigDecimal(readL20[19]).divide(new BigDecimal(
						10), 2, RoundingMode.HALF_UP);
					final BigDecimal grossPrice = new BigDecimal(readL20[20]).divide(
						new BigDecimal(100), 2, RoundingMode.HALF_UP);
					final String productDescription = readL20[23];
					final String pfand = readL20[36];
					final String customerNrLL = readL20[39];
					final String posCustLL = readL20[40];
					final String tax = readL20[42];

					if ("00000000".equals(readL20[46]))
						containerItem.setBestBeforeDate(dispatchNotificationReaderImpl.getDate(
							readL20[46], "000000"));
					container.getItems().add(containerItem);
					container = null;
				}
				else if (sCurrentLine.startsWith(Recordart.L25.name()))
				{
// String[] readL25 = dispatchNotificationReaderImpl.readL25(sCurrentLine);
					// System.out.println(Arrays.deepToString(readL25));
				}
				else if (sCurrentLine.startsWith(Recordart.E01.name()))
				{// lieferavis packet ist abgeschloßen
					final String[] readE01 = dispatchNotificationReaderImpl.readE01(sCurrentLine);
					final Integer amountItmes = Integer.valueOf(readE01[6]);
					final Integer supplierCustomerNumber = Integer.valueOf(readE01[6]);
					final Date date = dispatchNotificationReaderImpl.getDate(readE01[4], readE01[5]);

					ret.getContainers().add(container);
				}
				else if (sCurrentLine.startsWith(Recordart.Z90.name()))
				{// lieferavis ist zu ende
					final String[] readZ90 = dispatchNotificationReaderImpl.readZ90(sCurrentLine);
					System.out.println(Arrays.deepToString(readZ90));
				}
			}
		}
		catch (IOException e)
		{
			if (processTrayIcon != null)
				processTrayIcon.displayMessage("Error Message", "" + e, TrayIcon.MessageType.ERROR);
		}
		finally
		{
			try
			{
				if (br != null)
					br.close();
			}
			catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}

		return ret;
	}
}
