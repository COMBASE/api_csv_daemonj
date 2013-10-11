package net.combase.api.domain;


import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 
 * @author Mario Zieschang
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class TimeTrackingPeriodEntry extends AbstractRootDataObject
{
	private static final long serialVersionUID = -4789982800081736422L;

	@XmlElement(name = "start")
	@XmlSchemaType(name = "datetime")
	@XmlJavaTypeAdapter(JsonDateAdapter.class)
	private Date start;
	private String cashier;
	private String org;
	private String timeTrackingEntity;

	/**
	 * @return the cashier
	 */
	public String getCashier()
	{
		return cashier;
	}

	/**
	 * @return the pos
	 */
	public String getOrg()
	{
		return org;
	}

	/**
	 * @return the start
	 */
	public Date getStart()
	{
		return start;
	}

	/**
	 * @return the timeTrackingEntity
	 */
	public String getTimeTrackingEntity()
	{
		return timeTrackingEntity;
	}

	/**
	 * @param cashier
	 *            the cashier to set
	 */
	public void setCashier(String cashier)
	{
		this.cashier = cashier;
	}

	/**
	 * @param pos
	 *            the pos to set
	 */
	public void setOrg(String org)
	{
		this.org = org;
	}

	/**
	 * @param start
	 *            the start to set
	 */
	public void setStart(Date start)
	{
		this.start = start;
	}

	/**
	 * @param timeTrackingEntity
	 *            the timeTrackingEntity to set
	 */
	public void setTimeTrackingEntity(String timeTrackingEntity)
	{
		this.timeTrackingEntity = timeTrackingEntity;
	}


}
