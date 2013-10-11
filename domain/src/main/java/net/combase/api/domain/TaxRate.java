/**
 * Copyright 2013 COMBASE AG
 */
package net.combase.api.domain;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Till Freier
 * 
 */
public class TaxRate implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -969046625595517598L;

	private BigDecimal rate;

	private Date validFrom;

	/**
	 * @return the rate
	 */
	public BigDecimal getRate()
	{
		return rate;
	}

	/**
	 * @return the validFrom
	 */
	public Date getValidFrom()
	{
		return validFrom;
	}

	/**
	 * @param rate
	 *            the rate to set
	 */
	public void setRate(final BigDecimal rate)
	{
		this.rate = rate;
	}

	/**
	 * @param validFrom
	 *            the validFrom to set
	 */
	public void setValidFrom(final Date validFrom)
	{
		this.validFrom = validFrom;
	}


}
