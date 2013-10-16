package net.combase.cloud.butler.ui;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumnModel;

import net.combase.cloud.api.swoppen.CashOut;
import net.combase.cloud.api.swoppen.CashOut.ReceiptSaleSummaryBean;

/**
 *
 * @author Mario Zieschang
 *
 */
public class ReceiptListPanel extends JFrame {

	private static final long serialVersionUID = 8734776832528678139L;

	private CashOut cashOut;
	protected static final Class<CurrencyTableModel> thisClass = CurrencyTableModel.class;

	public ReceiptListPanel() {
		super("Receipt List panel");
		List<ReceiptSaleSummaryBean> cashOutData = getCashOut().getCashOutData(Long.valueOf(123456), Long.valueOf(0));

		JTable tbl = new JTable(new CurrencyTableModel(cashOutData));
		tbl.setDefaultRenderer(java.lang.Number.class, new FractionCellRenderer(10, 3, SwingConstants.RIGHT));

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

}
