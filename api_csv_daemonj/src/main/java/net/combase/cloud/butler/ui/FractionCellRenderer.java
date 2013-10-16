package net.combase.cloud.butler.ui;

import java.text.NumberFormat;

import javax.swing.table.DefaultTableCellRenderer;

public class FractionCellRenderer extends DefaultTableCellRenderer {
	private static final long serialVersionUID = -9154181659865486307L;

	protected static final NumberFormat formatter = NumberFormat.getInstance();

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