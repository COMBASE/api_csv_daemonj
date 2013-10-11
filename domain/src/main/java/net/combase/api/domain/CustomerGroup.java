package net.combase.api.domain;


import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Mario Zieschang
 * 
 */
@XmlRootElement
public class CustomerGroup extends AbstractRootAndNumberDataObject
{
	private static final long serialVersionUID = 2888535513727094872L;

	private String priceGroup;

	/**
	 * @return the priceGroup
	 */
	public String getPriceGroup()
	{
		return priceGroup;
	}

	/**
	 * @param priceGroup the priceGroup to set
	 */
	public void setPriceGroup(String priceGroup)
	{
		this.priceGroup = priceGroup;
	}
}
