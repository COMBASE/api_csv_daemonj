package net.combase.api.domain;

import java.math.BigDecimal;

/**
 *
 * @author mziescha
 *
 */
public class Sale extends AbstractDomainRootAndNumberObject {

	private static final long serialVersionUID = -8680318861084147600L;

	private String cashier;
	private BigDecimal grossItemPrice;
	private BigDecimal netItemPrice;
	private BigDecimal quantity;

	public String getCashier() {
		return cashier;
	}

	public void setCashier(String cashier) {
		this.cashier = cashier;
	}

	public BigDecimal getGrossItemPrice() {
		return grossItemPrice;
	}

	public void setGrossItemPrice(BigDecimal grossItemPrice) {
		this.grossItemPrice = grossItemPrice;
	}

	public BigDecimal getNetItemPrice() {
		return netItemPrice;
	}

	public void setNetItemPrice(BigDecimal netItemPrice) {
		this.netItemPrice = netItemPrice;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
}
