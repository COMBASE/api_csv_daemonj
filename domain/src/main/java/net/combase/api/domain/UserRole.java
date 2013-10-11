package net.combase.api.domain;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Mario Zieschang
 * 
 */
@XmlRootElement
public class UserRole extends AbstractRootAndNumberDataObject
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4581646509933126617L;

	private String name;

	private List<String> permissions = new ArrayList<String>();

	/**
	 * @return the name
	 */
	@Override
	public String getName()
	{
		return name;
	}

	/**
	 * @return the permissions
	 */
	public List<String> getPermissions()
	{
		return permissions;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	@Override
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @param permissions
	 *            the permissions to set
	 */
	public void setPermissions(List<String> permissions)
	{
		this.permissions = permissions;
	}


}
