/**
 * Copyright 2013 COMBASE AG
 */
package net.combase.api.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Till Freier
 * 
 */
@XmlRootElement
public class Product extends AbstractRootAndNumberDataObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5300691003543978790L;

	private List<ProductCode> codes = new ArrayList<ProductCode>();

	private String commodityGroup;

	private String description;

	private boolean discountable = true;

	private BigDecimal maxPrice;

	private BigDecimal minPrce;

	private boolean priceChangable = true;

	private List<Price> prices = new ArrayList<Price>();

	private String receiptText;

	private String sector;

	private List<Tag> tags = new ArrayList<Tag>();

	private String assortment;

	private Date activeAssortmentFrom;

	private String alternativeSector;

	private List<ProductCode> articleCodes = new ArrayList<ProductCode>();

	private List<String> articleTexts = new ArrayList<String>();

	private String barcode;

	private final BigDecimal basePriceMax = BigDecimal.valueOf(9999.99);

	private final BigDecimal basePriceMin = BigDecimal.valueOf(-9999.99);

	private String itemSequence;

	private String name;

	private BigDecimal packagingQuantity;

	private boolean priceChangeable;

	private List<String> infoTexts = new ArrayList<String>();

	private List<String> subarticleRelations = new ArrayList<String>();

	private boolean activeAssortment = true;

	private String producer;

	private String ticketValidityDescription;

	private boolean trackInventory = false;

	private boolean requiresSerialNumber = false;

	private List<String> subArticleSelections = new ArrayList<String>();

	private List<String> supplierItemPrices = new ArrayList<String>();

	private boolean preparationArticle = false;

	private String imageId;

	private BigDecimal purchasePrice;

	private BigDecimal costs = BigDecimal.ZERO;

	public Date getActiveAssortmentFrom() {
		return activeAssortmentFrom;
	}

	/**
	 * @return the alternativeSector
	 */
	public String getAlternativeSector() {
		return alternativeSector;
	}

	/**
	 * @return the articleCodes
	 */
	public List<ProductCode> getArticleCodes() {
		return articleCodes;
	}

	/**
	 * @return the articleTexts
	 */
	public List<String> getArticleTexts() {
		return articleTexts;
	}

	/**
	 * @return the assortment
	 */
	public String getAssortment() {
		return assortment;
	}

	/**
	 * @return the barcode
	 */
	public String getBarcode() {
		return barcode;
	}

	/**
	 * @return the basePriceMax
	 */
	public BigDecimal getBasePriceMax() {
		return basePriceMax;
	}

	/**
	 * @return the basePriceMin
	 */
	public BigDecimal getBasePriceMin() {
		return basePriceMin;
	}

	/**
	 * @return the codes
	 */
	public List<ProductCode> getCodes() {
		return codes;
	}

	/**
	 * @return the commodityGroup
	 */
	public String getCommodityGroup() {
		return commodityGroup;
	}

	/**
	 * @return the costs
	 */
	public BigDecimal getCosts() {
		return costs;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the imageId
	 */
	public String getImageId() {
		return imageId;
	}

	/**
	 * @return the infoTexts
	 */
	public List<String> getInfoTexts() {
		return infoTexts;
	}

	/**
	 * @return the itemSequence
	 */
	public String getItemSequence() {
		return itemSequence;
	}

	/**
	 * @return the maxPrice
	 */
	public BigDecimal getMaxPrice() {
		return maxPrice;
	}

	/**
	 * @return the minPrce
	 */
	public BigDecimal getMinPrce() {
		return minPrce;
	}

	/**
	 * @return the name
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * @return the packagingQuantity
	 */
	public BigDecimal getPackagingQuantity() {
		return packagingQuantity;
	}

	/**
	 * @return the prices
	 */
	public List<Price> getPrices() {
		return prices;
	}

	/**
	 * @return the producer
	 */
	public String getProducer() {
		return producer;
	}

	/**
	 * @return the purchasePrice
	 */
	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}

	/**
	 * @return the receiptText
	 */
	public String getReceiptText() {
		return receiptText;
	}

	/**
	 * @return the sector
	 */
	public String getSector() {
		return sector;
	}

	/**
	 * @return the subarticleRelations
	 */
	public List<String> getSubarticleRelations() {
		return subarticleRelations;
	}

	/**
	 * @return the subArticleSelections
	 */
	public List<String> getSubArticleSelections() {
		return subArticleSelections;
	}

	/**
	 * @return the supplierItemPrices
	 */
	public List<String> getSupplierItemPrices() {
		return supplierItemPrices;
	}

	/**
	 * @return the tags
	 */
	public List<Tag> getTags() {
		return tags;
	}

	/**
	 * @return the ticketValidityDescription
	 */
	public String getTicketValidityDescription() {
		return ticketValidityDescription;
	}

	/**
	 * @return the activeAssortment
	 */
	public boolean isActiveAssortment() {
		return activeAssortment;
	}

	/**
	 * @return the discoutable
	 */
	public boolean isDiscountable() {
		return discountable;
	}

	/**
	 * @return the preparationArticle
	 */
	public boolean isPreparationArticle() {
		return preparationArticle;
	}

	/**
	 * @return the priceChangable
	 */
	public boolean isPriceChangable() {
		return priceChangable;
	}

	/**
	 * @return the priceChangeable
	 */
	public boolean isPriceChangeable() {
		return priceChangeable;
	}

	/**
	 * @return the requiresSerialNumber
	 */
	public boolean isRequiresSerialNumber() {
		return requiresSerialNumber;
	}

	/**
	 * @return the trackInventory
	 */
	public boolean isTrackInventory() {
		return trackInventory;
	}

	/**
	 * @param activeAssortment
	 *            the activeAssortment to set
	 */
	public void setActiveAssortment(boolean activeAssortment) {
		this.activeAssortment = activeAssortment;
	}

	public void setActiveAssortmentFrom(Date activeAssortmentFrom) {
		this.activeAssortmentFrom = activeAssortmentFrom;
	}

	/**
	 * @param alternativeSector
	 *            the alternativeSector to set
	 */
	public void setAlternativeSector(String alternativeSector) {
		this.alternativeSector = alternativeSector;
	}

	/**
	 * @param articleCodes
	 *            the articleCodes to set
	 */
	public void setArticleCodes(List<ProductCode> articleCodes) {
		this.articleCodes = articleCodes;
	}

	/**
	 * @param articleTexts
	 *            the articleTexts to set
	 */
	public void setArticleTexts(List<String> articleTexts) {
		this.articleTexts = articleTexts;
	}

	/**
	 * @param assortment
	 *            the assortment to set
	 */
	public void setAssortment(String assortment) {
		this.assortment = assortment;
	}

	/**
	 * @param barcode
	 *            the barcode to set
	 */
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	/**
	 * @param codes
	 *            the codes to set
	 */
	public void setCodes(final List<ProductCode> codes) {
		this.codes = codes;
	}

	/**
	 * @param commodityGroup
	 *            the commodityGroup to set
	 */
	public void setCommodityGroup(final String commodityGroup) {
		this.commodityGroup = commodityGroup;
	}

	/**
	 * @param costs
	 *            the costs to set
	 */
	public void setCosts(BigDecimal costs) {
		this.costs = costs;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(final String description) {
		this.description = description;
	}

	/**
	 * @param discoutable
	 *            the discoutable to set
	 */
	public void setDiscountable(final boolean discoutable) {
		discountable = discoutable;
	}

	/**
	 * @param imageId
	 *            the imageId to set
	 */
	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	/**
	 * @param list
	 *            the infoTexts to set
	 */
	public void setInfoTexts(List<String> list) {
		infoTexts = list;
	}

	/**
	 * @param itemSequence
	 *            the itemSequence to set
	 */
	public void setItemSequence(String itemSequence) {
		this.itemSequence = itemSequence;
	}

	/**
	 * @param maxPrice
	 *            the maxPrice to set
	 */
	public void setMaxPrice(final BigDecimal maxPrice) {
		this.maxPrice = maxPrice;
	}

	/**
	 * @param minPrce
	 *            the minPrce to set
	 */
	public void setMinPrce(final BigDecimal minPrce) {
		this.minPrce = minPrce;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param packagingQuantity
	 *            the packagingQuantity to set
	 */
	public void setPackagingQuantity(BigDecimal packagingQuantity) {
		this.packagingQuantity = packagingQuantity;
	}

	/**
	 * @param preparationArticle
	 *            the preparationArticle to set
	 */
	public void setPreparationArticle(boolean preparationArticle) {
		this.preparationArticle = preparationArticle;
	}

	/**
	 * @param priceChangable
	 *            the priceChangable to set
	 */
	public void setPriceChangable(final boolean priceChangable) {
		this.priceChangable = priceChangable;
	}

	/**
	 * @param priceChangeable
	 *            the priceChangeable to set
	 */
	public void setPriceChangeable(boolean priceChangeable) {
		this.priceChangeable = priceChangeable;
	}

	/**
	 * @param prices
	 *            the prices to set
	 */
	public void setPrices(final List<Price> prices) {
		this.prices = prices;
	}

	/**
	 * @param producer
	 *            the producer to set
	 */
	public void setProducer(String producer) {
		this.producer = producer;
	}

	/**
	 * @param purchasePrice
	 *            the purchasePrice to set
	 */
	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	/**
	 * @param receiptText
	 *            the receiptText to set
	 */
	public void setReceiptText(final String receiptText) {
		this.receiptText = receiptText;
	}

	/**
	 * @param requiresSerialNumber
	 *            the requiresSerialNumber to set
	 */
	public void setRequiresSerialNumber(boolean requiresSerialNumber) {
		this.requiresSerialNumber = requiresSerialNumber;
	}

	/**
	 * @param sector
	 *            the sector to set
	 */
	public void setSector(final String sector) {
		this.sector = sector;
	}

	/**
	 * @param subarticleRelations
	 *            the subarticleRelations to set
	 */
	public void setSubarticleRelations(List<String> subarticleRelations) {
		this.subarticleRelations = subarticleRelations;
	}

	/**
	 * @param subArticleSelections
	 *            the subArticleSelections to set
	 */
	public void setSubArticleSelections(List<String> subArticleSelections) {
		this.subArticleSelections = subArticleSelections;
	}

	/**
	 * @param supplierItemPrices
	 *            the supplierItemPrices to set
	 */
	public void setSupplierItemPrices(List<String> supplierItemPrices) {
		this.supplierItemPrices = supplierItemPrices;
	}

	/**
	 * @param tags
	 *            the tags to set
	 */
	public void setTags(final List<Tag> tags) {
		this.tags = tags;
	}

	/**
	 * @param ticketValidityDescription
	 *            the ticketValidityDescription to set
	 */
	public void setTicketValidityDescription(String ticketValidityDescription) {
		this.ticketValidityDescription = ticketValidityDescription;
	}

	/**
	 * @param trackInventory
	 *            the trackInventory to set
	 */
	public void setTrackInventory(boolean trackInventory) {
		this.trackInventory = trackInventory;
	}

}
