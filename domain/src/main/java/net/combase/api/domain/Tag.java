/**
 * Copyright 2013 COMBASE AG
 */
package net.combase.api.domain;



/**
 * @author Mario Zieschang
 * 
 */
public class Tag extends AbstractRootAndNumberDataObject
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6959912492554549236L;
	private String name;

	/**
	 * @return the name
	 */
	@Override
	public String getName()
	{
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	@Override
	public void setName(String name)
	{
		this.name = name;
	}
}
