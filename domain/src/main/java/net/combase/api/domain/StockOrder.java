/**
 * Copyright 2013 COMBASE AG
 */
package net.combase.api.domain;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Mario Zieschang
 * 
 */
@XmlRootElement
public class StockOrder extends AbstractRootAndNumberDataObject
{
	private static final long serialVersionUID = 6857491646049226246L;

	private Date requiredFrom;
	private Date requiredTo;
	private Date pickUpDate;
	private Date autoFinalization;
	private boolean autoSend;
	private Date posFinalizationTime;
	private Date dispatchNotificationCreationTime;
	private Date stockReceiptCreationTime;
	private Date stockReceiptFinalizationTime;
	private Date returnCreationTime;
	private Date bookingTime;
	private Date createTime;

	private boolean send;

	private String currency;
	private String specialOfferCode;
	private String bookedBy;
	private String createdBy;
	private String target;
	private String supplier;
	private String source;
	private String description;

	private List<StockOrderItem> items = new ArrayList<StockOrderItem>();

	private SupplierCaseEntityInformation buyerInformation;
	private SupplierCaseEntityInformation deliveryAddressInformation;
	private SupplierCaseEntityInformation finalRecipientInformation;
	private SupplierCaseEntityInformation invoiceRecipientInformation;
	private SupplierCaseEntityInformation transportServiceProviderInformation;
	private SupplierCaseEntityInformation supplierInformation;

	/**
	 * @return the autoFinalization
	 */
	public Date getAutoFinalization()
	{
		return autoFinalization;
	}


	/**
	 * @return the bookedBy
	 */
	public String getBookedBy()
	{
		return bookedBy;
	}


	/**
	 * @return the bookingTime
	 */
	public Date getBookingTime()
	{
		return bookingTime;
	}


	public SupplierCaseEntityInformation getBuyerInformation()
	{
		return buyerInformation;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy()
	{
		return createdBy;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime()
	{
		return createTime;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency()
	{
		return currency;
	}

	/**
	 * @return the deliveryAddressInformation
	 */
	public SupplierCaseEntityInformation getDeliveryAddressInformation()
	{
		return deliveryAddressInformation;
	}

	/**
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * @return the dispatchNotificationCreationTime
	 */
	public Date getDispatchNotificationCreationTime()
	{
		return dispatchNotificationCreationTime;
	}

	/**
	 * @return the finalRecipientInformation
	 */
	public SupplierCaseEntityInformation getFinalRecipientInformation()
	{
		return finalRecipientInformation;
	}

	/**
	 * @return the invoiceRecipientInformation
	 */
	public SupplierCaseEntityInformation getInvoiceRecipientInformation()
	{
		return invoiceRecipientInformation;
	}

	/**
	 * @return the items
	 */
	public List<StockOrderItem> getItems()
	{
		return items;
	}

	/**
	 * @return the pickUpDate
	 */
	public Date getPickUpDate()
	{
		return pickUpDate;
	}

	/**
	 * @return the posFinalizationTime
	 */
	public Date getPosFinalizationTime()
	{
		return posFinalizationTime;
	}

	/**
	 * @return the requiredFrom
	 */
	public Date getRequiredFrom()
	{
		return requiredFrom;
	}

	/**
	 * @return the requiredTo
	 */
	public Date getRequiredTo()
	{
		return requiredTo;
	}

	/**
	 * @return the returnCreationTime
	 */
	public Date getReturnCreationTime()
	{
		return returnCreationTime;
	}

	/**
	 * @return the source
	 */
	public String getSource()
	{
		return source;
	}

	/**
	 * @return the specialOfferCode
	 */
	public String getSpecialOfferCode()
	{
		return specialOfferCode;
	}

	/**
	 * @return the stockReceiptCreationTime
	 */
	public Date getStockReceiptCreationTime()
	{
		return stockReceiptCreationTime;
	}

	/**
	 * @return the stockReceiptFinalizationTime
	 */
	public Date getStockReceiptFinalizationTime()
	{
		return stockReceiptFinalizationTime;
	}

	/**
	 * @return the supplier
	 */
	public String getSupplier()
	{
		return supplier;
	}

	/**
	 * @return the supplierInformation
	 */
	public SupplierCaseEntityInformation getSupplierInformation()
	{
		return supplierInformation;
	}

	/**
	 * @return the target
	 */
	public String getTarget()
	{
		return target;
	}

	/**
	 * @return the transportServiceProviderInformation
	 */
	public SupplierCaseEntityInformation getTransportServiceProviderInformation()
	{
		return transportServiceProviderInformation;
	}

	public boolean isAutoSend()
	{
		return autoSend;
	}

	public boolean isSend()
	{
		return send;
	}

	/**
	 * @param autoFinalization
	 *            the autoFinalization to set
	 */
	public void setAutoFinalization(Date autoFinalization)
	{
		this.autoFinalization = autoFinalization;
	}

	public void setAutoSend(boolean autoSend)
	{
		this.autoSend = autoSend;
	}

	public void setBookedBy(String bookedBy)
	{
		this.bookedBy = bookedBy;
	}

	public void setBookingTime(Date bookingTime)
	{
		this.bookingTime = bookingTime;
	}

	public void setBuyerInformation(SupplierCaseEntityInformation buyerInformation)
	{
		this.buyerInformation = buyerInformation;
	}

	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}

	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}

	/**
	 * @param currency
	 *            the currency to set
	 */
	public void setCurrency(String currency)
	{
		this.currency = currency;
	}

	/**
	 * @param deliveryAddressInformation
	 *            the deliveryAddressInformation to set
	 */
	public void setDeliveryAddressInformation(
		SupplierCaseEntityInformation deliveryAddressInformation)
	{
		this.deliveryAddressInformation = deliveryAddressInformation;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	/**
	 * @param dispatchNotificationCreationTime
	 *            the dispatchNotificationCreationTime to set
	 */
	public void setDispatchNotificationCreationTime(Date dispatchNotificationCreationTime)
	{
		this.dispatchNotificationCreationTime = dispatchNotificationCreationTime;
	}

	/**
	 * @param finalRecipientInformation
	 *            the finalRecipientInformation to set
	 */
	public void setFinalRecipientInformation(SupplierCaseEntityInformation finalRecipientInformation)
	{
		this.finalRecipientInformation = finalRecipientInformation;
	}

	/**
	 * @param invoiceRecipientInformation
	 *            the invoiceRecipientInformation to set
	 */
	public void setInvoiceRecipientInformation(
		SupplierCaseEntityInformation invoiceRecipientInformation)
	{
		this.invoiceRecipientInformation = invoiceRecipientInformation;
	}

	/**
	 * @param items
	 *            the items to set
	 */
	public void setItems(List<StockOrderItem> items)
	{
		this.items = items;
	}

	/**
	 * @param pickUpDate
	 *            the pickUpDate to set
	 */
	public void setPickUpDate(Date pickUpDate)
	{
		this.pickUpDate = pickUpDate;
	}

	/**
	 * @param posFinalizationTime
	 *            the posFinalizationTime to set
	 */
	public void setPosFinalizationTime(Date posFinalizationTime)
	{
		this.posFinalizationTime = posFinalizationTime;
	}

	/**
	 * @param requiredFrom
	 *            the requiredFrom to set
	 */
	public void setRequiredFrom(Date requiredFrom)
	{
		this.requiredFrom = requiredFrom;
	}

	/**
	 * @param requiredTo
	 *            the requiredTo to set
	 */
	public void setRequiredTo(Date requiredTo)
	{
		this.requiredTo = requiredTo;
	}

	/**
	 * @param returnCreationTime
	 *            the returnCreationTime to set
	 */
	public void setReturnCreationTime(Date returnCreationTime)
	{
		this.returnCreationTime = returnCreationTime;
	}

	public void setSend(boolean send)
	{
		this.send = send;
	}

	public void setSource(String source)
	{
		this.source = source;
	}

	/**
	 * @param specialOfferCode
	 *            the specialOfferCode to set
	 */
	public void setSpecialOfferCode(String specialOfferCode)
	{
		this.specialOfferCode = specialOfferCode;
	}

	/**
	 * @param stockReceiptCreationTime
	 *            the stockReceiptCreationTime to set
	 */
	public void setStockReceiptCreationTime(Date stockReceiptCreationTime)
	{
		this.stockReceiptCreationTime = stockReceiptCreationTime;
	}

	/**
	 * @param stockReceiptFinalizationTime
	 *            the stockReceiptFinalizationTime to set
	 */
	public void setStockReceiptFinalizationTime(Date stockReceiptFinalizationTime)
	{
		this.stockReceiptFinalizationTime = stockReceiptFinalizationTime;
	}

	public void setSupplier(String supplier)
	{
		this.supplier = supplier;
	}

	/**
	 * @param supplierInformation
	 *            the supplierInformation to set
	 */
	public void setSupplierInformation(SupplierCaseEntityInformation supplierInformation)
	{
		this.supplierInformation = supplierInformation;
	}

	public void setTarget(String target)
	{
		this.target = target;
	}

	/**
	 * @param transportServiceProviderInformation
	 *            the transportServiceProviderInformation to set
	 */
	public void setTransportServiceProviderInformation(
		SupplierCaseEntityInformation transportServiceProviderInformation)
	{
		this.transportServiceProviderInformation = transportServiceProviderInformation;
	}

}
