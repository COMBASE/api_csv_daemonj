/**
 * Copyright 2013 COMBASE AG
 */
package net.combase.api.domain;


import java.io.Serializable;

/**
 * @author Till Freier
 * 
 */
public class AbstractRootDataObject implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1669810499763731934L;

	private boolean deleted = false;

	private String name;


	private long revision;

	private String uuid;


	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @return the revision
	 */
	public long getRevision()
	{
		return revision;
	}

	/**
	 * @return the uuid
	 */
	public String getUuid()
	{
		return uuid;
	}

	/**
	 * @return the deleted
	 */
	public boolean isDeleted()
	{
		return deleted;
	}

	/**
	 * @param deleted
	 *            the deleted to set
	 */
	public void setDeleted(final boolean deleted)
	{
		this.deleted = deleted;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(final String name)
	{
		this.name = name;
	}

	/**
	 * @param revision
	 *            the revision to set
	 */
	public void setRevision(final long revision)
	{
		this.revision = revision;
	}

	/**
	 * @param uuid
	 *            the uuid to set
	 */
	public void setUuid(final String uuid)
	{
		this.uuid = uuid;
	}
}
