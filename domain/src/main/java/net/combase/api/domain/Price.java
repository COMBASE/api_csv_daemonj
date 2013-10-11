/**
 * Copyright 2013 COMBASE AG
 */
package net.combase.api.domain;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Till Freier
 * 
 */
public class Price implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8377588872357149524L;

	private BigDecimal value;

	private String priceList;

	private Date validFrom;

	/**
	 * @return the price
	 */
	public BigDecimal getValue()
	{
		return value;
	}

	/**
	 * @return the priceGroup
	 */
	public String getPriceList()
	{
		return priceList;
	}

	/**
	 * @return the validFrom
	 */
	public Date getValidFrom()
	{
		return validFrom;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setValue(final BigDecimal price)
	{
		this.value = price;
	}

	/**
	 * @param priceGroup
	 *            the priceGroup to set
	 */
	public void setPriceList(final String priceGroup)
	{
		priceList = priceGroup;
	}

	/**
	 * @param validFrom
	 *            the validFrom to set
	 */
	public void setValidFrom(final Date validFrom)
	{
		this.validFrom = validFrom;
	}
}
