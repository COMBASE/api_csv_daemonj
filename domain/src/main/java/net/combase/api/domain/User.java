package net.combase.api.domain;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Mario Zieschang
 * 
 */
@XmlRootElement
public class User extends AbstractRootAndNumberDataObject
{
	private static final long serialVersionUID = 4383987525963919927L;

	private Date created;

	private String email;

	private String requestedEmail;

	private int emailChangeCount;

	private String firstname;

	private List<String> orgs = new ArrayList<String>();

	private List<String> permissions = new ArrayList<String>();

	private String surname;

	private UserRole role;

	/**
	 * @return the created
	 */
	public Date getCreated()
	{
		return created;
	}

	/**
	 * @return the email
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * @return the emailChangeCount
	 */
	public int getEmailChangeCount()
	{
		return emailChangeCount;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname()
	{
		return firstname;
	}

	/**
	 * @return the orgs
	 */
	public List<String> getOrgs()
	{
		return orgs;
	}

	/**
	 * @return the permissions
	 */
	public List<String> getPermissions()
	{
		return permissions;
	}

	/**
	 * @return the requestedEmail
	 */
	public String getRequestedEmail()
	{
		return requestedEmail;
	}

	/**
	 * @return the role
	 */
	public UserRole getRole()
	{
		return role;
	}

	/**
	 * @return the surname
	 */
	public String getSurname()
	{
		return surname;
	}

	/**
	 * @param created
	 *            the created to set
	 */
	public void setCreated(Date created)
	{
		this.created = created;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}

	/**
	 * @param emailChangeCount
	 *            the emailChangeCount to set
	 */
	public void setEmailChangeCount(int emailChangeCount)
	{
		this.emailChangeCount = emailChangeCount;
	}

	/**
	 * @param firstname
	 *            the firstname to set
	 */
	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}

	public void setOrgs(final List<String> orgs)
	{
		this.orgs = orgs;
	}

	public void setPermissions(List<String> permissions)
	{
		this.permissions = permissions;
	}

	/**
	 * @param requestedEmail
	 *            the requestedEmail to set
	 */
	public void setRequestedEmail(String requestedEmail)
	{
		this.requestedEmail = requestedEmail;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(UserRole role)
	{
		this.role = role;
	}

	/**
	 * @param surname
	 *            the surname to set
	 */
	public void setSurname(String surname)
	{
		this.surname = surname;
	}
}
