/**
 * Copyright 2013 COMBASE AG
 */
package net.combase.api.domain;


import java.math.BigDecimal;


/**
 * @author Mario Zieschang
 * 
 */
public class StockOrderItem extends AbstractRootDataObject
{
	private static final long serialVersionUID = 432044535547045327L;

	private BigDecimal bookedQuantity;
	private BigDecimal containerQuantity;
	private BigDecimal quantity;
	private BigDecimal purchasePrice;
	private BigDecimal salesPrice;
	private BigDecimal desiredOverallQuantity;
	private BigDecimal actualOverallQuantity;
	private BigDecimal itemPrice;

	private String product;
	private String color;
	private String size;


	/**
	 * @return the actualOverallQuantity
	 */
	public BigDecimal getActualOverallQuantity()
	{
		return actualOverallQuantity;
	}

	public BigDecimal getBookedQuantity()
	{
		return bookedQuantity;
	}

	/**
	 * @return the color
	 */
	public String getColor()
	{
		return color;
	}

	public BigDecimal getContainerQuantity()
	{
		return containerQuantity;
	}

	/**
	 * @return the desiredOverallQuantity
	 */
	public BigDecimal getDesiredOverallQuantity()
	{
		return desiredOverallQuantity;
	}

	/**
	 * @return the itemPrice
	 */
	public BigDecimal getItemPrice()
	{
		return itemPrice;
	}

	public String getProduct()
	{
		return product;
	}

	/**
	 * @return the purchasePrice
	 */
	public BigDecimal getPurchasePrice()
	{
		return purchasePrice;
	}

	public BigDecimal getQuantity()
	{
		return quantity;
	}

	/**
	 * @return the salesPrice
	 */
	public BigDecimal getSalesPrice()
	{
		return salesPrice;
	}

	/**
	 * @return the size
	 */
	public String getSize()
	{
		return size;
	}

	/**
	 * @param actualOverallQuantity
	 *            the actualOverallQuantity to set
	 */
	public void setActualOverallQuantity(BigDecimal actualOverallQuantity)
	{
		this.actualOverallQuantity = actualOverallQuantity;
	}

	public void setBookedQuantity(BigDecimal bookedQuantity)
	{
		this.bookedQuantity = bookedQuantity;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(String color)
	{
		this.color = color;
	}

	public void setContainerQuantity(BigDecimal containerQuantity)
	{
		this.containerQuantity = containerQuantity;
	}

	/**
	 * @param desiredOverallQuantity
	 *            the desiredOverallQuantity to set
	 */
	public void setDesiredOverallQuantity(BigDecimal desiredOverallQuantity)
	{
		this.desiredOverallQuantity = desiredOverallQuantity;
	}

	/**
	 * @param itemPrice
	 *            the itemPrice to set
	 */
	public void setItemPrice(BigDecimal itemPrice)
	{
		this.itemPrice = itemPrice;
	}

	public void setProduct(String product)
	{
		this.product = product;
	}

	/**
	 * @param purchasePrice
	 *            the purchasePrice to set
	 */
	public void setPurchasePrice(BigDecimal purchasePrice)
	{
		this.purchasePrice = purchasePrice;
	}

	public void setQuantity(BigDecimal quantity)
	{
		this.quantity = quantity;
	}

	/**
	 * @param salesPrice
	 *            the salesPrice to set
	 */
	public void setSalesPrice(BigDecimal salesPrice)
	{
		this.salesPrice = salesPrice;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public void setSize(String size)
	{
		this.size = size;
	}
}
