package net.combase.api.domain;


import java.util.Date;

public class SupplierCase extends AbstractRootAndNumberDataObject
{
	private static final long serialVersionUID = -240075007040544025L;

	private Date createTime;

	private Date bookingTime;

	private String bookedBy;

	private String createdBy;

	private String source;

	private String supplier;

	private String target;

	private SupplierCaseEntityInformation buyerInformation;

	private SupplierCaseEntityInformation deliveryAddressInformation;

	private SupplierCaseEntityInformation finalRecipientInformation;

	private SupplierCaseEntityInformation invoiceRecipientInformation;

	private SupplierCaseEntityInformation supplierInformation;

	private SupplierCaseEntityInformation transportServiceProviderInformation;

	private String description;

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

	/**
	 * @return the buyerInformation
	 */
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
	 * @return the source
	 */
	public String getSource()
	{
		return source;
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

	/**
	 * @param bookedBy
	 *            the bookedBy to set
	 */
	public void setBookedBy(String bookedBy)
	{
		this.bookedBy = bookedBy;
	}

	/**
	 * @param bookingTime
	 *            the bookingTime to set
	 */
	public void setBookingTime(Date bookingTime)
	{
		this.bookingTime = bookingTime;
	}

	/**
	 * @param buyerInformation
	 *            the buyerInformation to set
	 */
	public void setBuyerInformation(SupplierCaseEntityInformation buyerInformation)
	{
		this.buyerInformation = buyerInformation;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set
	 */
	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}

	/**
	 * @param createTime
	 *            the createTime to set
	 */
	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
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

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description)
	{
		this.description = description;
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
	 * @param source
	 *            the source to set
	 */
	public void setSource(String source)
	{
		this.source = source;
	}

	/**
	 * @param supplier
	 *            the supplier to set
	 */
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

	/**
	 * @param target
	 *            the target to set
	 */
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
