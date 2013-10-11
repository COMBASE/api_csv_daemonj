/**
 * Copyright 2013 COMBASE AG
 */
package net.combase.api.domain;



/**
 * @author Till Freier
 * 
 */
public class InfoText extends AbstractRootAndNumberDataObject
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8015246589967605690L;

	private String text;

	private String type;

	/**
	 * @return the text
	 */
	public String getText()
	{
		return text;
	}

	/**
	 * @return the type
	 */
	public String getType()
	{
		return type;
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(String text)
	{
		this.text = text;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type)
	{
		this.type = type;
	}


}
