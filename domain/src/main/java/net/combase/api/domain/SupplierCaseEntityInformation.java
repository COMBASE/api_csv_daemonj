/**
 * Copyright 2013 COMBASE AG
 */
package net.combase.api.domain;


import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author Till Freier
 */
@XmlRootElement
public class SupplierCaseEntityInformation extends AbstractRootDataObject

{
	private static final long serialVersionUID = 6428308099700800831L;

	private String gln;

	private String company;

	private String department;

	private String addressLine1;

	private String addressLine2;

	private String zipCode;

	private String city;

	private String state;

	private String country;

	private String taxId;


	public String getAddressLine1()
	{
		return addressLine1;
	}


	public String getAddressLine2()
	{
		return addressLine2;
	}


	public String getCity()
	{
		return city;
	}


	public String getCompany()
	{
		return company;
	}


	public String getCountry()
	{
		return country;
	}


	public String getDepartment()
	{
		return department;
	}


	public String getGln()
	{
		return gln;
	}


	public String getState()
	{
		return state;
	}


	public String getTaxId()
	{
		return taxId;
	}


	public String getZipCode()
	{
		return zipCode;
	}

	public void setAddressLine1(final String addressLine1)
	{
		this.addressLine1 = addressLine1;
	}


	public void setAddressLine2(final String addressLine2)
	{
		this.addressLine2 = addressLine2;
	}


	public void setCity(final String city)
	{
		this.city = city;
	}


	public void setCompany(final String company)
	{
		this.company = company;
	}


	public void setCountry(final String country)
	{
		this.country = country;
	}


	public void setDepartment(final String department)
	{
		this.department = department;
	}


	public void setGln(final String gln)
	{
		this.gln = gln;
	}


	public void setState(final String state)
	{
		this.state = state;
	}


	public void setTaxId(final String taxId)
	{
		this.taxId = taxId;
	}


	public void setZipCode(final String zipCode)
	{
		this.zipCode = zipCode;
	}

}
