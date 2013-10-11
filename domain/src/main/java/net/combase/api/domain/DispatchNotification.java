/**
 * Copyright 2013 COMBASE AG
 */
package net.combase.api.domain;


import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Mario Zieschang
 * 
 */
@XmlRootElement
public class DispatchNotification extends SupplierCase
{
	private static final long serialVersionUID = 3359426440348993754L;

	private String order;

	private Date deliveryDate;

	private Date shippingDate;

	private List<DispatchContainer> containers;

	public List<DispatchContainer> getContainers()
	{
		return containers;
	}

	/**
	 * @return the deliveryDate
	 */
	public Date getDeliveryDate()
	{
		return deliveryDate;
	}

	/**
	 * @return the order
	 */
	public String getOrder()
	{
		return order;
	}

	/**
	 * @return the shippingDate
	 */
	public Date getShippingDate()
	{
		return shippingDate;
	}

	public void setContainers(List<DispatchContainer> containers)
	{
		this.containers = containers;
	}

	/**
	 * @param deliveryDate
	 *            the deliveryDate to set
	 */
	public void setDeliveryDate(Date deliveryDate)
	{
		this.deliveryDate = deliveryDate;
	}

	/**
	 * @param order
	 *            the order to set
	 */
	public void setOrder(String order)
	{
		this.order = order;
	}

	/**
	 * @param shippingDate
	 *            the shippingDate to set
	 */
	public void setShippingDate(Date shippingDate)
	{
		this.shippingDate = shippingDate;
	}


}
