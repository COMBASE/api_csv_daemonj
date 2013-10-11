/**
 * Copyright 2013 COMBASE AG
 */
package net.combase.api.domain;


import java.math.BigDecimal;
import java.util.List;


/**
 * @author Till Freier
 */
public class DispatchContainer extends AbstractRootDataObject
{
	private static final long serialVersionUID = 4640543529019935309L;

	private int dispatchPosition;

	private String packaging;

	private String shippingUnitNumer;

	private String pieceOf;

	private BigDecimal grossVolume;

	private String volumeUnit;

	private BigDecimal grossWeight;

	private String weightUnit;

	private String boxPieces;

	private String boxPieceType;

	private List<DispatchItem> items;

	/**
	 * @return the boxPieces
	 */
	public String getBoxPieces()
	{
		return boxPieces;
	}

	/**
	 * @return the boxPieceType
	 */
	public String getBoxPieceType()
	{
		return boxPieceType;
	}

	/**
	 * @return the dispatchPosition
	 */
	public int getDispatchPosition()
	{
		return dispatchPosition;
	}

	/**
	 * @return the grossVolume
	 */
	public BigDecimal getGrossVolume()
	{
		return grossVolume;
	}

	/**
	 * @return the grossWeight
	 */
	public BigDecimal getGrossWeight()
	{
		return grossWeight;
	}

	/**
	 * @return the items
	 */
	public List<DispatchItem> getItems()
	{
		return items;
	}

	/**
	 * @return the packaging
	 */
	public String getPackaging()
	{
		return packaging;
	}

	/**
	 * @return the pieceOf
	 */
	public String getPieceOf()
	{
		return pieceOf;
	}

	/**
	 * @return the shippingUnitNumer
	 */
	public String getShippingUnitNumer()
	{
		return shippingUnitNumer;
	}

	/**
	 * @return the volumeUnit
	 */
	public String getVolumeUnit()
	{
		return volumeUnit;
	}

	/**
	 * @return the weightUnit
	 */
	public String getWeightUnit()
	{
		return weightUnit;
	}

	/**
	 * @param boxPieces
	 *            the boxPieces to set
	 */
	public void setBoxPieces(String boxPieces)
	{
		this.boxPieces = boxPieces;
	}

	/**
	 * @param boxPieceType
	 *            the boxPieceType to set
	 */
	public void setBoxPieceType(String boxPieceType)
	{
		this.boxPieceType = boxPieceType;
	}

	/**
	 * @param dispatchPosition
	 *            the dispatchPosition to set
	 */
	public void setDispatchPosition(int dispatchPosition)
	{
		this.dispatchPosition = dispatchPosition;
	}

	/**
	 * @param grossVolume
	 *            the grossVolume to set
	 */
	public void setGrossVolume(BigDecimal grossVolume)
	{
		this.grossVolume = grossVolume;
	}

	/**
	 * @param grossWeight
	 *            the grossWeight to set
	 */
	public void setGrossWeight(BigDecimal grossWeight)
	{
		this.grossWeight = grossWeight;
	}

	public void setItems(List<DispatchItem> items)
	{
		this.items = items;
	}

	/**
	 * @param packaging
	 *            the packaging to set
	 */
	public void setPackaging(String packaging)
	{
		this.packaging = packaging;
	}

	/**
	 * @param pieceOf
	 *            the pieceOf to set
	 */
	public void setPieceOf(String pieceOf)
	{
		this.pieceOf = pieceOf;
	}

	/**
	 * @param shippingUnitNumer
	 *            the shippingUnitNumer to set
	 */
	public void setShippingUnitNumer(String shippingUnitNumer)
	{
		this.shippingUnitNumer = shippingUnitNumer;
	}

	/**
	 * @param volumeUnit
	 *            the volumeUnit to set
	 */
	public void setVolumeUnit(String volumeUnit)
	{
		this.volumeUnit = volumeUnit;
	}

	/**
	 * @param weightUnit
	 *            the weightUnit to set
	 */
	public void setWeightUnit(String weightUnit)
	{
		this.weightUnit = weightUnit;
	}


}
