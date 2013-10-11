/**
 * Copyright 2013 COMBASE AG
 */
package net.combase.api.domain;


import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Till Freier
 * 
 */
public class ProductCode implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6552013134855812182L;
	private String code;
	private BigDecimal quantity;

	/**
	 * @return the code
	 */
	public String getCode()
	{
		return code;
	}

	/**
	 * @return the quantity
	 */
	public BigDecimal getQuantity()
	{
		return quantity;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(final String code)
	{
		this.code = code;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(final BigDecimal quantity)
	{
		this.quantity = quantity;
	}


}
