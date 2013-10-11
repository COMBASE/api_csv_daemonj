/**
 * Copyright 2012 COMBASE AG
 */
package net.combase.api.domain;


import java.util.ArrayList;
import java.util.List;


/**
 * @author Till Freier
 */
public class Cashier extends AbstractRootAndNumberDataObject
{
	private static final long serialVersionUID = 6413235026698152579L;

	private String firstname;

	private String loginCode;

	private List<String> permissions = new ArrayList<String>();

	private String surname;


	public String getFirstname()
	{
		return firstname;
	}

	public String getLoginCode()
	{
		return loginCode;
	}


	public List<String> getPermissions()
	{
		return permissions;
	}


	public String getSurname()
	{
		return surname;
	}


	public void setFirstname(final String firstname)
	{
		this.firstname = firstname;
	}


	public void setLoginCode(final String loginCode)
	{
		this.loginCode = loginCode;
	}


	public void setPermissions(final List<String> permissions)
	{
		this.permissions = permissions;
	}


	public void setSurname(final String surname)
	{
		this.surname = surname;
	}
}
