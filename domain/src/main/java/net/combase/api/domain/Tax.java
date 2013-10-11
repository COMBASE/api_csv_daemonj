/**
 * Copyright 2013 COMBASE AG
 */
package net.combase.api.domain;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Till Freier
 * 
 */
@XmlRootElement
public class Tax extends AbstractRootAndNumberDataObject
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6417341026645749287L;

	private String economicZone;

	private boolean included = false;

	private List<TaxRate> rates = new ArrayList<TaxRate>();


	/**
	 * @return the economicZone
	 */
	public String getEconomicZone()
	{
		return economicZone;
	}

	/**
	 * @return the rates
	 */
	public List<TaxRate> getRates()
	{
		return rates;
	}

	/**
	 * @return the included
	 */
	public boolean isIncluded()
	{
		return included;
	}

	/**
	 * @param economicZone
	 *            the economicZone to set
	 */
	public void setEconomicZone(final String economicZone)
	{
		this.economicZone = economicZone;
	}

	/**
	 * @param included
	 *            the included to set
	 */
	public void setIncluded(final boolean included)
	{
		this.included = included;
	}

	/**
	 * @param rates
	 *            the rates to set
	 */
	public void setRates(final List<TaxRate> rates)
	{
		this.rates = rates;
	}


}
