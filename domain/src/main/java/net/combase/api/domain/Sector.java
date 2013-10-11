/**
 * Copyright 2013 COMBASE AG
 */
package net.combase.api.domain;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Till Freier
 * 
 */
@XmlRootElement
public class Sector extends AbstractRootAndNumberDataObject
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5576091202975645398L;

	private List<SectorTaxItem> items = new ArrayList<SectorTaxItem>();

	/**
	 * @return the items
	 */
	public List<SectorTaxItem> getItems()
	{
		return items;
	}

	/**
	 * @param items
	 *            the items to set
	 */
	public void setItems(final List<SectorTaxItem> items)
	{
		this.items = items;
	}


}
