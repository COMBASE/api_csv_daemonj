/**
 * Copyright 2013 COMBASE AG
 */
package net.combase.api.domain;


import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author Till Freier
 * 
 */
@XmlRootElement
public class CommodityGroup extends AbstractRootAndNumberDataObject
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8803302729442146573L;

	private String parentCommodityGroup;

	private String key;

	private boolean hasChildren;


	public String getKey()
	{
		return key;
	}

	public String getParentCommodityGroup()
	{
		return parentCommodityGroup;
	}

	public boolean isHasChildren()
	{
		return hasChildren;
	}

	public void setHasChildren(boolean hasChildren)
	{
		this.hasChildren = hasChildren;
	}

	public void setKey(String key)
	{
		this.key = key;
	}

	public void setParentCommodityGroup(String parentCommodityGroup)
	{
		this.parentCommodityGroup = parentCommodityGroup;
	}


}
