/**
 * Copyright 2013 COMBASE AG
 */
package net.combase.api.domain;


import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Mario Zieschang
 * 
 */
@XmlRootElement
public class PriceList extends AbstractRootAndNumberDataObject
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -236040769519470273L;

	private String currency;
	private boolean netPrices;

	/**
	 * @return the currency
	 */
	public String getCurrency()
	{
		return currency;
	}

	/**
	 * @return the netPrices
	 */
	public boolean isNetPrices()
	{
		return netPrices;
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
	 * @param netPrices
	 *            the netPrices to set
	 */
	public void setNetPrices(boolean netPrices)
	{
		this.netPrices = netPrices;
	}
}
