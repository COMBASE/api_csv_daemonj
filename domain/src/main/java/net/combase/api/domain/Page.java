/**
 * Copyright 2013 COMBASE AG
 */
package net.combase.api.domain;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Till Freier
 * 
 */
@XmlRootElement
public class Page<T> implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7392727698253018145L;

	private List<T> items = new ArrayList<T>();

	private int pageItemCount;

	private long totalItemCount;

	/**
	 * @return the items
	 */
	public List<T> getItems()
	{
		return items;
	}

	/**
	 * @return the pageItemCount
	 */
	public int getPageItemCount()
	{
		return pageItemCount;
	}

	/**
	 * @return the totalItemCount
	 */
	public long getTotalItemCount()
	{
		return totalItemCount;
	}

	/**
	 * @param items
	 *            the items to set
	 */
	public void setItems(final List<T> items)
	{
		this.items = items;
	}

	/**
	 * @param pageItemCount
	 *            the pageItemCount to set
	 */
	public void setPageItemCount(final int pageItemCount)
	{
		this.pageItemCount = pageItemCount;
	}

	/**
	 * @param totalItemCount
	 *            the totalItemCount to set
	 */
	public void setTotalItemCount(final long totalItemCount)
	{
		this.totalItemCount = totalItemCount;
	}


}
