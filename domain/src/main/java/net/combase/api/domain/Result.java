/**
 * Copyright 2013 COMBASE AG
 */
package net.combase.api.domain;


import java.sql.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * @author Till Freier
 * 
 */
@XmlRootElement
@XmlSeeAlso({ AbstractRootDataObject.class, AbstractRootAndNumberDataObject.class, Cashier.class,
		CommodityGroup.class, Currency.class, Customer.class, CustomerGroup.class, Date.class,
		DispatchContainer.class, DispatchItem.class, DispatchNotification.class, Long.class,
		Price.class, PriceList.class, Product.class, Receipt.class, Sale.class, Sector.class,
		StockOrder.class, StockOrderItem.class, SupplierCaseEntityInformation.class, Tag.class,
		Tax.class, TimeTrackingEntity.class, TimeTrackingPeriodEntry.class, User.class,
		UserRole.class })
public class Result<T>
{
	private String error;
	private T result;
	private List<T> resultList;
	private List<String> errorList;
	private long totalElements;
	private int totalPages;

	/**
	 * @return the error
	 */
	public String getError()
	{
		return error;
	}

	public List<String> getErrorList()
	{
		return errorList;
	}

	/**
	 * @return the result
	 */
	public T getResult()
	{
		return result;
	}

	/**
	 * @return the resultList
	 */
	public List<T> getResultList()
	{
		return resultList;
	}

	public long getTotalElements()
	{
		return totalElements;
	}

	public int getTotalPages()
	{
		return totalPages;
	}

	/**
	 * @param error
	 *            the error to set
	 */
	public void setError(final String error)
	{
		this.error = error;
	}

	public void setErrorList(final List<String> errorList)
	{
		this.errorList = errorList;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(final T result)
	{
		this.result = result;
	}

	/**
	 * @param resultList
	 *            the resultList to set
	 */
	public void setResultList(final List<T> resultList)
	{
		this.resultList = resultList;
	}

	public void setTotalElements(long totalElements)
	{
		this.totalElements = totalElements;
	}

	public void setTotalPages(int totalPages)
	{
		this.totalPages = totalPages;
	}


}
