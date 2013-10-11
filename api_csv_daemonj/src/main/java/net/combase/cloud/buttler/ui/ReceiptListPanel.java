package net.combase.cloud.buttler.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

import org.json.JSONObject;

import net.combase.api.domain.Product;
import net.combase.api.domain.Receipt;
import net.combase.api.service.ProductApiService;
import net.combase.cloud.buttler.CloudButler;
import net.combase.cloud.buttler.api.ApiUtil;
import net.combase.cloud.buttler.db.DBController;
import net.combase.cloud.buttler.swoppen.CashIn;
import net.combase.cloud.buttler.swoppen.CashOut;
import net.combase.cloud.buttler.swoppen.CashOut.ReceiptSaleSummaryBean;
import net.combase.cloud.buttler.ui.ReceiptListPanel.CurrencyTableModel;

/**
 * 
 * @author Mario Zieschang
 * 
 */
public class ReceiptListPanel extends JFrame {

	private static final long serialVersionUID = 8734776832528678139L;

	protected static final NumberFormat formatter = NumberFormat.getInstance();
	private CashIn cashIn;
	private CashOut cashOut;
	protected static final Class<CurrencyTableModel> thisClass = CurrencyTableModel.class;
	protected Object[][] data;

	class CurrencyTableModel extends AbstractTableModel {
		private static final long serialVersionUID = 1847906714223390673L;

		protected String[] columnNames = { "Customer Group", "Date", "Time",
				"Receipt Number", "Quantity", "Product Number", "Description",
				"Gross Item Price", "Base Item Price", "Currency Symbol",
				"Cashier Number", "Cashier Name" };

		// Constructor: calculate currency change to create the last column
		public CurrencyTableModel(List<ReceiptSaleSummaryBean> cashOutData) {
			data = new Object[cashOutData.size()][12];
			for (int i = 0; i < data.length; i++) {
				data[i][0] = "123456";
				final Date date = cashOutData.get(i).getSale().getBookingTime();

				if (date != null) {
					final SimpleDateFormat dateFormat = new SimpleDateFormat(
							"dd.MM.yyyy");
					final SimpleDateFormat timeFormat = new SimpleDateFormat(
							"HH:mm:ss");

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

		public Class getColumnClass(int column) {
			Object object = data[0][column];
			if (object == null)
				return String.class;
			return object.getClass();
		}

		public String getColumnName(int column) {
			return columnNames[column];
		}
	}

	class FractionCellRenderer extends DefaultTableCellRenderer {
		public FractionCellRenderer(int integer, int fraction, int align) {
			this.integer = integer; // maximum integer digits
			this.fraction = fraction; // exact number of fraction digits
			this.align = align; // alignment (LEFT, CENTER, RIGHT)
		}

		protected void setValue(Object value) {
			if (value != null && value instanceof Number) {
				formatter.setMaximumIntegerDigits(integer);
				formatter.setMaximumFractionDigits(fraction);
				formatter.setMinimumFractionDigits(fraction);
				setText(formatter.format(((Number) value).doubleValue()));
			} else {
				super.setValue(value);
			}
			setHorizontalAlignment(align);
		}

		protected int integer;

		protected int fraction;

		protected int align;

	}

	public ReceiptListPanel() {
		super("Receipt List panel");
		List<ReceiptSaleSummaryBean> cashOutData = getCashOut().getCashOutData(
				Long.valueOf(123456), Long.valueOf(0));

		JTable tbl = new JTable(new CurrencyTableModel(cashOutData));
		tbl.setDefaultRenderer(java.lang.Number.class,
				new FractionCellRenderer(10, 3, SwingConstants.RIGHT));

		TableColumnModel tcm = tbl.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(300);
		tcm.getColumn(0).setMinWidth(300);

		tbl.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tbl.setPreferredScrollableViewportSize(tbl.getPreferredSize());

		JScrollPane sp = new JScrollPane(tbl);
		getContentPane().add(sp, "Center");
		pack();
		setVisible(true);
	}

	public CashOut getCashOut() {
		if (cashOut == null)
			cashOut = new CashOut();
		return cashOut;
	}

	public CashIn getCashIn() {
		if (cashIn == null)
			cashIn = new CashIn();
		return cashIn;
	}
}
