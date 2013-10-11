/**
 * Copyright 2013 COMBASE AG
 */
package net.combase.api.domain;


import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Mario Zieschang
 * 
 */
@XmlRootElement
public class Currency extends AbstractRootAndNumberDataObject
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5576091202975645398L;

	private String symbol;

	/**
	 * @return the symbol
	 */
	public String getSymbol()
	{
		return symbol;
	}

	/**
	 * @param symbol
	 *            the symbol to set
	 */
	public void setSymbol(String symbol)
	{
		this.symbol = symbol;
	}
}
