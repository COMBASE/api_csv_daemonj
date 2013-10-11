/**
 * Copyright 2013 COMBASE AG
 */
package net.combase.api.domain;


import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Till Freier
 * 
 */
@XmlRootElement
public class SectorTaxItem implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2179277708296523685L;

	private int index;

	private String tax;

	/**
	 * @return the index
	 */
	public int getIndex()
	{
		return index;
	}

	/**
	 * @return the tax
	 */
	public String getTax()
	{
		return tax;
	}

	/**
	 * @param index
	 *            the index to set
	 */
	public void setIndex(final int index)
	{
		this.index = index;
	}

	/**
	 * @param tax
	 *            the tax to set
	 */
	public void setTax(final String tax)
	{
		this.tax = tax;
	}


}
