/**
 * Copyright 2013 COMBASE AG
 */
package net.combase.api.domain;



import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;



/**
 * @author Till Freier
 */
@XmlRootElement
public class Supplier extends AbstractRootAndNumberDataObject
{

	private static final long serialVersionUID = -5868148841242112327L;

	private String name;

	private String customerNumber;

	private String additionalInformation;

	private String contactPersonSalutation;

	private String contactPersonFirstname;

	private String contactPersonSurname;

	private String contactPersonEmail;

	private String contactPersonPhone;

	private String contactPersonMobile;

	private String contactPersonTelefax;

	private String contactPhone;

	private String contactTelefax;

	private String contactEmail;

	private String contactWebsite;

	private String orderPhone;

	private String orderEmail;

	private Integer orderWeekdays;

	private Date orderTimeFrom;

	private Date orderTimeTo;

	private Integer deliveryWeekdays;

	private Integer deliveryTime;

	private Integer delayedDeliveryStarting;

	private String shipper;


	private String bank;

	private String rountingCode;

	private String bic;

	private String accountNumber;

	private String iban;

	private String creditorIdentifier;



	public String getAccountNumber()
	{
		return accountNumber;
	}


	public String getAdditionalInformation()
	{
		return additionalInformation;
	}

	public String getBank()
	{
		return bank;
	}


	public String getBic()
	{
		return bic;
	}


	public String getContactEmail()
	{
		return contactEmail;
	}

	public String getContactPersonEmail()
	{
		return contactPersonEmail;
	}


	public String getContactPersonFirstname()
	{
		return contactPersonFirstname;
	}


	public String getContactPersonMobile()
	{
		return contactPersonMobile;
	}


	public String getContactPersonPhone()
	{
		return contactPersonPhone;
	}


	public String getContactPersonSalutation()
	{
		return contactPersonSalutation;
	}


	public String getContactPersonSurname()
	{
		return contactPersonSurname;
	}


	public String getContactPersonTelefax()
	{
		return contactPersonTelefax;
	}


	public String getContactPhone()
	{
		return contactPhone;
	}


	public String getContactTelefax()
	{
		return contactTelefax;
	}


	public String getContactWebsite()
	{
		return contactWebsite;
	}


	public String getCreditorIdentifier()
	{
		return creditorIdentifier;
	}


	public String getCustomerNumber()
	{
		return customerNumber;
	}


	public Integer getDelayedDeliveryStarting()
	{
		return delayedDeliveryStarting;
	}


	public Integer getDeliveryTime()
	{
		return deliveryTime;
	}


	public Integer getDeliveryWeekdays()
	{
		return deliveryWeekdays;
	}



	public String getIban()
	{
		return iban;
	}


	@Override
	public String getName()
	{
		return name;
	}


	public String getOrderEmail()
	{
		return orderEmail;
	}


	public String getOrderPhone()
	{
		return orderPhone;
	}


	public Date getOrderTimeFrom()
	{
		return orderTimeFrom;
	}


	public Date getOrderTimeTo()
	{
		return orderTimeTo;
	}


	public Integer getOrderWeekdays()
	{
		return orderWeekdays;
	}



	public String getRountingCode()
	{
		return rountingCode;
	}


	public String getShipper()
	{
		return shipper;
	}



	public void setAccountNumber(final String accountNumber)
	{
		this.accountNumber = accountNumber;
	}


	public void setAdditionalInformation(final String additionalInformation)
	{
		this.additionalInformation = additionalInformation;
	}


	public void setBank(final String bank)
	{
		this.bank = bank;
	}


	public void setBic(final String bic)
	{
		this.bic = bic;
	}


	public void setContactEmail(final String contactEmail)
	{
		this.contactEmail = contactEmail;
	}


	public void setContactPersonEmail(final String contactPersonEmail)
	{
		this.contactPersonEmail = contactPersonEmail;
	}


	public void setContactPersonFirstname(final String contactPersonFirstname)
	{
		this.contactPersonFirstname = contactPersonFirstname;
	}


	public void setContactPersonMobile(final String contactPersonMobile)
	{
		this.contactPersonMobile = contactPersonMobile;
	}


	public void setContactPersonPhone(final String contactPersonPhome)
	{
		contactPersonPhone = contactPersonPhome;
	}


	public void setContactPersonSalutation(final String contactPersonSalutation)
	{
		this.contactPersonSalutation = contactPersonSalutation;
	}


	public void setContactPersonSurname(final String contactPersonSurname)
	{
		this.contactPersonSurname = contactPersonSurname;
	}


	public void setContactPersonTelefax(final String contactPersonTelefax)
	{
		this.contactPersonTelefax = contactPersonTelefax;
	}


	public void setContactPhone(final String contactPhone)
	{
		this.contactPhone = contactPhone;
	}


	public void setContactTelefax(final String contactTelefax)
	{
		this.contactTelefax = contactTelefax;
	}


	public void setContactWebsite(final String contactWebsite)
	{
		this.contactWebsite = contactWebsite;
	}


	public void setCreditorIdentifier(final String creditorIdentifier)
	{
		this.creditorIdentifier = creditorIdentifier;
	}


	public void setCustomerNumber(final String customerNumber)
	{
		this.customerNumber = customerNumber;
	}


	public void setDelayedDeliveryStarting(final Integer delayedDeliveryStarting)
	{
		this.delayedDeliveryStarting = delayedDeliveryStarting;
	}


	public void setDeliveryTime(final Integer deliveryTime)
	{
		this.deliveryTime = deliveryTime;
	}


	public void setDeliveryWeekdays(final Integer deliveryWeekdays)
	{
		this.deliveryWeekdays = deliveryWeekdays;
	}


	public void setIban(final String iban)
	{
		this.iban = iban;
	}


	@Override
	public void setName(final String name)
	{
		this.name = name;
	}


	public void setOrderEmail(final String orderEmail)
	{
		this.orderEmail = orderEmail;
	}


	public void setOrderPhone(final String orderPhone)
	{
		this.orderPhone = orderPhone;
	}


	public void setOrderTimeFrom(final Date orderTimeFrom)
	{
		this.orderTimeFrom = orderTimeFrom;
	}


	public void setOrderTimeTo(final Date orderTimeTo)
	{
		this.orderTimeTo = orderTimeTo;
	}


	public void setOrderWeekdays(final Integer orderWeekdays)
	{
		this.orderWeekdays = orderWeekdays;
	}


	public void setRountingCode(final String rountingCode)
	{
		this.rountingCode = rountingCode;
	}


	public void setShipper(final String shipper)
	{
		this.shipper = shipper;
	}



}
