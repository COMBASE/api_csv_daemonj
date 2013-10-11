package net.combase.api.domain;


import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class Sale extends AbstractRootDataObject
{
	private static final long serialVersionUID = 2216806025437461671L;

	private String article;

	private String cashier;

	private String commodityGroup;

	private Date bookingTime;

	private String description;

	private final Map<Integer, String> infoTexts = new TreeMap<Integer, String>();

	private String itemNumber;

	private String itemSequence;

	private final boolean manualPrice = false;

	private BigDecimal itemPrice;

	private BigDecimal grossItemPrice;

	private BigDecimal netItemPrice;

	private BigDecimal baseItemPrice;

	private BigDecimal quantity;

	private int receiptIndex;

	private String receiptNumber;

	private String sector;

	private String serialNumber;

	private String pos;

	/**
	 * @return the article
	 */
	public String getArticle()
	{
		return article;
	}

	/**
	 * @return the baseItemPrice
	 */
	public BigDecimal getBaseItemPrice()
	{
		return baseItemPrice;
	}

	/**
	 * @return the bookingTime
	 */
	public Date getBookingTime()
	{
		return bookingTime;
	}

	/**
	 * @return the cashier
	 */
	public String getCashier()
	{
		return cashier;
	}

	/**
	 * @return the commodityGroup
	 */
	public String getCommodityGroup()
	{
		return commodityGroup;
	}

	/**
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * @return the grossItemPrice
	 */
	public BigDecimal getGrossItemPrice()
	{
		return grossItemPrice;
	}

	/**
	 * @return the infoTexts
	 */
	public Map<Integer, String> getInfoTexts()
	{
		return infoTexts;
	}

	/**
	 * @return the itemNumber
	 */
	public String getItemNumber()
	{
		return itemNumber;
	}

	/**
	 * @return the itemPrice
	 */
	public BigDecimal getItemPrice()
	{
		return itemPrice;
	}

	/**
	 * @return the itemSequence
	 */
	public String getItemSequence()
	{
		return itemSequence;
	}

	/**
	 * @return the netItemPrice
	 */
	public BigDecimal getNetItemPrice()
	{
		return netItemPrice;
	}

	/**
	 * @return the pos
	 */
	public String getPos()
	{
		return pos;
	}

	/**
	 * @return the quantity
	 */
	public BigDecimal getQuantity()
	{
		return quantity;
	}

	/**
	 * @return the receiptIndex
	 */
	public int getReceiptIndex()
	{
		return receiptIndex;
	}

	/**
	 * @return the receiptNumber
	 */
	public String getReceiptNumber()
	{
		return receiptNumber;
	}

	/**
	 * @return the sector
	 */
	public String getSector()
	{
		return sector;
	}

	/**
	 * @return the serialNumber
	 */
	public String getSerialNumber()
	{
		return serialNumber;
	}

	/**
	 * @return the manualPrice
	 */
	public boolean isManualPrice()
	{
		return manualPrice;
	}

	/**
	 * @param article
	 *            the article to set
	 */
	public void setArticle(String article)
	{
		this.article = article;
	}

	/**
	 * @param baseItemPrice
	 *            the baseItemPrice to set
	 */
	public void setBaseItemPrice(BigDecimal baseItemPrice)
	{
		this.baseItemPrice = baseItemPrice;
	}

	/**
	 * @param bookingTime
	 *            the bookingTime to set
	 */
	public void setBookingTime(Date bookingTime)
	{
		this.bookingTime = bookingTime;
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
	 * @param commodityGroup
	 *            the commodityGroup to set
	 */
	public void setCommodityGroup(String commodityGroup)
	{
		this.commodityGroup = commodityGroup;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}

	/**
	 * @param grossItemPrice
	 *            the grossItemPrice to set
	 */
	public void setGrossItemPrice(BigDecimal grossItemPrice)
	{
		this.grossItemPrice = grossItemPrice;
	}

	/**
	 * @param itemNumber
	 *            the itemNumber to set
	 */
	public void setItemNumber(String itemNumber)
	{
		this.itemNumber = itemNumber;
	}

	/**
	 * @param itemPrice
	 *            the itemPrice to set
	 */
	public void setItemPrice(BigDecimal itemPrice)
	{
		this.itemPrice = itemPrice;
	}

	/**
	 * @param itemSequence
	 *            the itemSequence to set
	 */
	public void setItemSequence(String itemSequence)
	{
		this.itemSequence = itemSequence;
	}

	/**
	 * @param netItemPrice
	 *            the netItemPrice to set
	 */
	public void setNetItemPrice(BigDecimal netItemPrice)
	{
		this.netItemPrice = netItemPrice;
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
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(BigDecimal quantity)
	{
		this.quantity = quantity;
	}

	/**
	 * @param receiptIndex
	 *            the receiptIndex to set
	 */
	public void setReceiptIndex(int receiptIndex)
	{
		this.receiptIndex = receiptIndex;
	}

	/**
	 * @param receiptNumber
	 *            the receiptNumber to set
	 */
	public void setReceiptNumber(String receiptNumber)
	{
		this.receiptNumber = receiptNumber;
	}

	/**
	 * @param sector
	 *            the sector to set
	 */
	public void setSector(String sector)
	{
		this.sector = sector;
	}

	/**
	 * @param serialNumber
	 *            the serialNumber to set
	 */
	public void setSerialNumber(String serialNumber)
	{
		this.serialNumber = serialNumber;
	}

}
