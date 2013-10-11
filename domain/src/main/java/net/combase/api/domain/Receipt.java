package net.combase.api.domain;


import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @author Mario Zieschang
 *
 */
public class Receipt extends AbstractRootAndNumberDataObject
{
	private static final long serialVersionUID = 6057100596239554222L;

	private String cashier;

	private Date createTime;

	private String currency;

	private String customerGroup;

	private Date finishTime;

// private final Map<Integer, String> infoTexts = new TreeMap<Integer, String>();

	private Date modifiedTime;

	private String orderNumber;

	private String pos;

	private String priceGroup;

	private BigDecimal grossTotalAmount;

	private BigDecimal netTotalAmount;

	private BigDecimal taxAmount;

	private long zCount;

// private final Set<TaxPaymentReadable> taxPayments = new TreeSet<TaxPaymentReadable>();

	private final boolean voided = false;

	private String customer;

	/**
	 * @return the cashier
	 */
	public String getCashier()
	{
		return cashier;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime()
	{
		return createTime;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency()
	{
		return currency;
	}

	/**
	 * @return the customer
	 */
	public String getCustomer()
	{
		return customer;
	}

	/**
	 * @return the customerGroup
	 */
	public String getCustomerGroup()
	{
		return customerGroup;
	}

	/**
	 * @return the finishTime
	 */
	public Date getFinishTime()
	{
		return finishTime;
	}

	/**
	 * @return the grossTotalAmount
	 */
	public BigDecimal getGrossTotalAmount()
	{
		return grossTotalAmount;
	}

	/**
	 * @return the modifiedTime
	 */
	public Date getModifiedTime()
	{
		return modifiedTime;
	}

	/**
	 * @return the netTotalAmount
	 */
	public BigDecimal getNetTotalAmount()
	{
		return netTotalAmount;
	}

	/**
	 * @return the orderNumber
	 */
	public String getOrderNumber()
	{
		return orderNumber;
	}

	/**
	 * @return the pos
	 */
	public String getPos()
	{
		return pos;
	}

	/**
	 * @return the priceGroup
	 */
	public String getPriceGroup()
	{
		return priceGroup;
	}

	/**
	 * @return the taxAmount
	 */
	public BigDecimal getTaxAmount()
	{
		return taxAmount;
	}

	/**
	 * @return the zCount
	 */
	public long getzCount()
	{
		return zCount;
	}

	/**
	 * @return the voided
	 */
	public boolean isVoided()
	{
		return voided;
	}

	/**
	 * @param cashier
	 *            the cashier to set
	 */
	public void setCashier(String cashier)
	{
		this.cashier = cashier;
	}

	/**
	 * @param createTime
	 *            the createTime to set
	 */
	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}

	/**
	 * @param currency
	 *            the currency to set
	 */
	public void setCurrency(String currency)
	{
		this.currency = currency;
	}

	/**
	 * @param customer
	 *            the customer to set
	 */
	public void setCustomer(String customer)
	{
		this.customer = customer;
	}

	/**
	 * @param customerGroup
	 *            the customerGroup to set
	 */
	public void setCustomerGroup(String customerGroup)
	{
		this.customerGroup = customerGroup;
	}

	/**
	 * @param finishTime
	 *            the finishTime to set
	 */
	public void setFinishTime(Date finishTime)
	{
		this.finishTime = finishTime;
	}

	/**
	 * @param grossTotalAmount
	 *            the grossTotalAmount to set
	 */
	public void setGrossTotalAmount(BigDecimal grossTotalAmount)
	{
		this.grossTotalAmount = grossTotalAmount;
	}

	/**
	 * @param modifiedTime
	 *            the modifiedTime to set
	 */
	public void setModifiedTime(Date modifiedTime)
	{
		this.modifiedTime = modifiedTime;
	}

	/**
	 * @param netTotalAmount
	 *            the netTotalAmount to set
	 */
	public void setNetTotalAmount(BigDecimal netTotalAmount)
	{
		this.netTotalAmount = netTotalAmount;
	}

	/**
	 * @param orderNumber
	 *            the orderNumber to set
	 */
	public void setOrderNumber(String orderNumber)
	{
		this.orderNumber = orderNumber;
	}

	/**
	 * @param pos
	 *            the pos to set
	 */
	public void setPos(String pos)
	{
		this.pos = pos;
	}

	/**
	 * @param priceGroup
	 *            the priceGroup to set
	 */
	public void setPriceGroup(String priceGroup)
	{
		this.priceGroup = priceGroup;
	}

	/**
	 * @param taxAmount
	 *            the taxAmount to set
	 */
	public void setTaxAmount(BigDecimal taxAmount)
	{
		this.taxAmount = taxAmount;
	}

	/**
	 * @param zCount
	 *            the zCount to set
	 */
	public void setzCount(long zCount)
	{
		this.zCount = zCount;
	}

}
