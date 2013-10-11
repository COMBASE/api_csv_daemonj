/**
 * Copyright 2013 COMBASE AG
 */
package net.combase.api.domain;


/**
 * @author Till Freier
 * 
 */
public class AbstractRootAndNumberDataObject extends AbstractRootDataObject
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1669810499763731934L;


	private String number;

	/**
	 * @return the number
	 */
	public String getNumber()
	{
		return number;
	}

	/**
	 * @param number
	 *            the number to set
	 */
	public void setNumber(final String number)
	{
		this.number = number;
	}

}
