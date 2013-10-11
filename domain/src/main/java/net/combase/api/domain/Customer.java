/**
 * Copyright 2013 COMBASE AG
 */
package net.combase.api.domain;


import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Till Freier
 * 
 */
@XmlRootElement
public class Customer extends AbstractRootAndNumberDataObject
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2723951233407704004L;

	private String firstName;
	private String lastName;
	private BigDecimal loyaltyRewardPoints;
	private String email;
	private Date birthday;
	private String gender;
	private String zipCode;
	private String addressLine1;
	private String addressLine2;
	private String state;
	private String city;
	private String country;
	private String customerGroup;
	private String phone;


	public String getAddressLine1()
	{
		return addressLine1;
	}

	public String getAddressLine2()
	{
		return addressLine2;
	}

	public Date getBirthday()
	{
		return birthday;
	}

	public String getCity()
	{
		return city;
	}

	public String getCountry()
	{
		return country;
	}

	public String getCustomerGroup()
	{
		return customerGroup;
	}

	public String getEmail()
	{
		return email;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getGender()
	{
		return gender;
	}

	public String getLastName()
	{
		return lastName;
	}

	public BigDecimal getLoyaltyRewardPoints()
	{
		return loyaltyRewardPoints;
	}

	public String getPhone()
	{
		return phone;
	}

	public String getState()
	{
		return state;
	}

	public String getZipCode()
	{
		return zipCode;
	}

	public void setAddressLine1(String addressLine1)
	{
		this.addressLine1 = addressLine1;
	}

	public void setAddressLine2(String addressLine2)
	{
		this.addressLine2 = addressLine2;
	}

	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	/**
	 * 
	 */
	private void setCombinedName()
	{
		StringBuilder sb = new StringBuilder();
		if (firstName != null)
			sb.append(firstName).append(' ');
		if (lastName != null)
			sb.append(lastName);

		setName(sb.toString().trim());
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public void setCustomerGroup(String customerGroup)
	{
		this.customerGroup = customerGroup;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;

		setCombinedName();
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
		setCombinedName();
	}

	public void setLoyaltyRewardPoints(BigDecimal loyaltyRewardPoints)
	{
		this.loyaltyRewardPoints = loyaltyRewardPoints;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public void setZipCode(String zipCode)
	{
		this.zipCode = zipCode;
	}


}
