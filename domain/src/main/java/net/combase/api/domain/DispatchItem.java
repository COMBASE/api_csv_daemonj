package net.combase.api.domain;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DispatchItem implements Serializable
{
	private static final long serialVersionUID = -1562119665311167539L;

	private Long id;

	private String name;

	private String color;

	private String size;

	private Date bestBeforeDate;

	private String batch;

	private String code;

	private String supplierItemNumber;

	private String buyerItemNumber;

	private BigDecimal orderQuantity;

	private String orderQuantityUnit;

	private BigDecimal deliveryQuantity;

	private String deliveryQuantityUnit;

	private String partDelivery;

	private String article;

	/**
	 * @return the article
	 */
	public String getArticle()
	{
		return article;
	}

	/**
	 * @return the batch
	 */
	public String getBatch()
	{
		return batch;
	}

	/**
	 * @return the bestBeforeDate
	 */
	public Date getBestBeforeDate()
	{
		return bestBeforeDate;
	}

	/**
	 * @return the buyerItemNumber
	 */
	public String getBuyerItemNumber()
	{
		return buyerItemNumber;
	}

	/**
	 * @return the code
	 */
	public String getCode()
	{
		return code;
	}

	/**
	 * @return the color
	 */
	public String getColor()
	{
		return color;
	}

	/**
	 * @return the deliveryQuantity
	 */
	public BigDecimal getDeliveryQuantity()
	{
		return deliveryQuantity;
	}

	/**
	 * @return the deliveryQuantityUnit
	 */
	public String getDeliveryQuantityUnit()
	{
		return deliveryQuantityUnit;
	}

	/**
	 * @return the id
	 */
	public Long getId()
	{
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @return the orderQuantity
	 */
	public BigDecimal getOrderQuantity()
	{
		return orderQuantity;
	}

	/**
	 * @return the orderQuantityUnit
	 */
	public String getOrderQuantityUnit()
	{
		return orderQuantityUnit;
	}

	/**
	 * @return the partDelivery
	 */
	public String getPartDelivery()
	{
		return partDelivery;
	}

	/**
	 * @return the size
	 */
	public String getSize()
	{
		return size;
	}

	/**
	 * @return the supplierItemNumber
	 */
	public String getSupplierItemNumber()
	{
		return supplierItemNumber;
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
	 * @param batch
	 *            the batch to set
	 */
	public void setBatch(String batch)
	{
		this.batch = batch;
	}

	/**
	 * @param bestBeforeDate
	 *            the bestBeforeDate to set
	 */
	public void setBestBeforeDate(Date bestBeforeDate)
	{
		this.bestBeforeDate = bestBeforeDate;
	}

	/**
	 * @param buyerItemNumber
	 *            the buyerItemNumber to set
	 */
	public void setBuyerItemNumber(String buyerItemNumber)
	{
		this.buyerItemNumber = buyerItemNumber;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code)
	{
		this.code = code;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(String color)
	{
		this.color = color;
	}

	/**
	 * @param deliveryQuantity
	 *            the deliveryQuantity to set
	 */
	public void setDeliveryQuantity(BigDecimal deliveryQuantity)
	{
		this.deliveryQuantity = deliveryQuantity;
	}

	/**
	 * @param deliveryQuantityUnit
	 *            the deliveryQuantityUnit to set
	 */
	public void setDeliveryQuantityUnit(String deliveryQuantityUnit)
	{
		this.deliveryQuantityUnit = deliveryQuantityUnit;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id)
	{
		this.id = id;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @param orderQuantity
	 *            the orderQuantity to set
	 */
	public void setOrderQuantity(BigDecimal orderQuantity)
	{
		this.orderQuantity = orderQuantity;
	}

	/**
	 * @param orderQuantityUnit
	 *            the orderQuantityUnit to set
	 */
	public void setOrderQuantityUnit(String orderQuantityUnit)
	{
		this.orderQuantityUnit = orderQuantityUnit;
	}

	/**
	 * @param partDelivery
	 *            the partDelivery to set
	 */
	public void setPartDelivery(String partDelivery)
	{
		this.partDelivery = partDelivery;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public void setSize(String size)
	{
		this.size = size;
	}

	/**
	 * @param supplierItemNumber
	 *            the supplierItemNumber to set
	 */
	public void setSupplierItemNumber(String supplierItemNumber)
	{
		this.supplierItemNumber = supplierItemNumber;
	}
}
