package net.combase.cloud.buttler.ui;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import net.combase.cloud.buttler.swoppen.CashOut.ReceiptSaleSummaryBean;

public class CurrencyTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1847906714223390673L;
	protected Object[][] data;
	protected String[] columnNames = new String[] { "Customer Group", "Date", "Time",
			"Receipt Number", "Quantity", "Product Number", "Description", "Gross Item Price", "Base Item Price",
			"Currency Symbol", "Cashier Number", "Cashier Name" };

	// Constructor: calculate currency change to create the last column
	public CurrencyTableModel(List<ReceiptSaleSummaryBean> cashOutData) {
		data = new Object[cashOutData.size()][12];
		for (int i = 0; i < data.length; i++) {
			data[i][0] = "123456";
			final Date date = cashOutData.get(i).getSale().getBookingTime();

			if (date != null) {
				final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
				final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

				final String dateString = dateFormat.format(date);
				final String timeString = timeFormat.format(date);
				data[i][1] = dateString;// $_->{date}";
				data[i][2] = timeString;// $_->{time};
			}
			data[i][3] = cashOutData.get(i).getReceipt().getNumber();
			data[i][4] = cashOutData.get(i).getSale().getQuantity();
			data[i][5] = cashOutData.get(i).getSale().getArticle();
			data[i][6] = cashOutData.get(i).getSale().getDescription();
			data[i][7] = cashOutData.get(i).getSale().getGrossItemPrice();
			data[i][8] = cashOutData.get(i).getSale().getBaseItemPrice();
			data[i][9] = cashOutData.get(i).getCurrency().getSymbol();
			data[i][10] = cashOutData.get(i).getCashier().getNumber();
			data[i][11] = cashOutData.get(i).getCashier().getFirstname();
		}
	}

	// Implementation of TableModel interface
	public int getRowCount() {
		return data.length;
	}

	public int getColumnCount() {
		return 12;
	}

	public Object getValueAt(int row, int column) {
		Object object = data[row][column];
		if (object == null)
			return "";
		return object;
	}

	public Class<?> getColumnClass(int column) {
		Object object = data[0][column];
		if (object == null)
			return String.class;
		return object.getClass();
	}

	public String getColumnName(int column) {
		return columnNames[column];
	}
}