package net.combase.api.domain;


import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Mario Zieschang
 * 
 */
@XmlRootElement
public class Assortment extends AbstractRootAndNumberDataObject
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8700504840311476975L;
	private Date lastCleanUp;
	private String description;

	public String getDescription()
	{
		return description;
	}

	public Date getLastCleanUp()
	{
		return lastCleanUp;
	}

	public void setDescription(String description)
	{
		// TODO Auto-generated method stub
		this.description = description;
	}

	public void setLastCleanUp(Date lastCleanUp)
	{
		// TODO Auto-generated method stub
		this.lastCleanUp = lastCleanUp;
	}

}
