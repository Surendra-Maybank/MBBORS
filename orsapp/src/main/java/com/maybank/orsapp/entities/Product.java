/**
 * 
 */
package com.maybank.orsapp.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author 80003905
 *
 */

@Entity
@Table(name = "mt_PRODUCT")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7211206523404188622L;
	
	@Id
	@Column(name = "PRODUCT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "PRODUCT_CODE")
	private String productCode;
	
	@Column(name = "PRODUCT_NAME")
	private String productName;
	
	@Column(name = "UNIT_POINT")
	private Integer unitPoint;
	
	@Column(name = "MERCHANT_COST")
	private BigDecimal merchantCost;
	
	@Column(name = "ACTUAL_PRODUCT_COST")
	private BigDecimal actualProductCost;
	
	@Column(name = "QTY")
	private Integer productQuantity;
	
	@Column(name = "MERCHANT_ID")
	private Long merchantId;
	
	@Column(name = "VALID_START_DATE")
	private Timestamp validStartDate;
	
	@Column(name = "VALID_END_DATE")
	private Timestamp validEndDate;
	
	@Column(name = "IMAGE_PATH")
	private String imagePath;
	
	@Column(name = "CATEGORY_TYPE_ID")
	private Long categoryTypeId;
	
	@Column(name = "AIRLINES_ID")
	private Long airlinesId;
	
	@Column(name = "IS_PREMIUM_REDEMPTION")
	private Boolean isPremiumRedemption = Boolean.FALSE;
	
	@Column(name = "CREDIT_AMOUNT")
	private BigDecimal creditAmount;
	
	@Column(name = "DEBIT_AMOUNT")
	private BigDecimal debitAmount;
	
	@Column(name = "CONVERSION_POINT")
	private BigDecimal conversionPoint;
	
	@Column(name = "REMARKS")
	private String remarks;
	
	@Column(name = "STATUS_ID")
	private Integer statusId;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "CREATED_DATETIME")
	private Timestamp createdDateTime;

	@Column(name = "EDITED_BY")
	private String editedBy;

	@Column(name = "EDITED_DATETIME")
	private Timestamp editedDateTime;
	
	@OneToMany(targetEntity=ProductProgram.class, mappedBy="productId",cascade=CascadeType.ALL, fetch = FetchType.LAZY)    
	private List<ProductProgram> productPrograms;
	
	@OneToMany(targetEntity=ProductPlasticType.class, mappedBy="productId",cascade=CascadeType.ALL, fetch = FetchType.LAZY)    
	private List<ProductPlasticType> productPlasticTypes;
	
	@OneToMany(targetEntity=ApPointTxnDetails.class, mappedBy="productId",cascade=CascadeType.ALL, fetch = FetchType.LAZY)    
	private List<ApPointTxnDetails> apPointTxnDetails;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the unitPoint
	 */
	public Integer getUnitPoint() {
		return unitPoint;
	}

	/**
	 * @param unitPoint the unitPoint to set
	 */
	public void setUnitPoint(Integer unitPoint) {
		this.unitPoint = unitPoint;
	}

	/**
	 * @return the merchantCost
	 */
	public BigDecimal getMerchantCost() {
		return merchantCost;
	}

	/**
	 * @param merchantCost the merchantCost to set
	 */
	public void setMerchantCost(BigDecimal merchantCost) {
		this.merchantCost = merchantCost;
	}

	/**
	 * @return the actualProductCost
	 */
	public BigDecimal getActualProductCost() {
		return actualProductCost;
	}

	/**
	 * @param actualProductCost the actualProductCost to set
	 */
	public void setActualProductCost(BigDecimal actualProductCost) {
		this.actualProductCost = actualProductCost;
	}

	/**
	 * @return the productQuantity
	 */
	public Integer getProductQuantity() {
		return productQuantity;
	}

	/**
	 * @param productQuantity the productQuantity to set
	 */
	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	/**
	 * @return the merchantId
	 */
	public Long getMerchantId() {
		return merchantId;
	}

	/**
	 * @param merchantId the merchantId to set
	 */
	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}

	/**
	 * @return the validStartDate
	 */
	public Timestamp getValidStartDate() {
		return validStartDate;
	}

	/**
	 * @param validStartDate the validStartDate to set
	 */
	public void setValidStartDate(Timestamp validStartDate) {
		this.validStartDate = validStartDate;
	}

	/**
	 * @return the validEndDate
	 */
	public Timestamp getValidEndDate() {
		return validEndDate;
	}

	/**
	 * @param validEndDate the validEndDate to set
	 */
	public void setValidEndDate(Timestamp validEndDate) {
		this.validEndDate = validEndDate;
	}

	/**
	 * @return the imagePath
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * @param imagePath the imagePath to set
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	/**
	 * @return the categoryTypeId
	 */
	public Long getCategoryTypeId() {
		return categoryTypeId;
	}

	/**
	 * @param categoryTypeId the categoryTypeId to set
	 */
	public void setCategoryTypeId(Long categoryTypeId) {
		this.categoryTypeId = categoryTypeId;
	}

	/**
	 * @return the airlinesId
	 */
	public Long getAirlinesId() {
		return airlinesId;
	}

	/**
	 * @param airlinesId the airlinesId to set
	 */
	public void setAirlinesId(Long airlinesId) {
		this.airlinesId = airlinesId;
	}

	/**
	 * @return the isPremiumRedemption
	 */
	public Boolean getIsPremiumRedemption() {
		return isPremiumRedemption;
	}

	/**
	 * @param isPremiumRedemption the isPremiumRedemption to set
	 */
	public void setIsPremiumRedemption(Boolean isPremiumRedemption) {
		this.isPremiumRedemption = isPremiumRedemption;
	}

	/**
	 * @return the creditAmount
	 */
	public BigDecimal getCreditAmount() {
		return creditAmount;
	}

	/**
	 * @param creditAmount the creditAmount to set
	 */
	public void setCreditAmount(BigDecimal creditAmount) {
		this.creditAmount = creditAmount;
	}

	/**
	 * @return the debitAmount
	 */
	public BigDecimal getDebitAmount() {
		return debitAmount;
	}

	/**
	 * @param debitAmount the debitAmount to set
	 */
	public void setDebitAmount(BigDecimal debitAmount) {
		this.debitAmount = debitAmount;
	}

	/**
	 * @return the conversionPoint
	 */
	public BigDecimal getConversionPoint() {
		return conversionPoint;
	}

	/**
	 * @param conversionPoint the conversionPoint to set
	 */
	public void setConversionPoint(BigDecimal conversionPoint) {
		this.conversionPoint = conversionPoint;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * @return the statusId
	 */
	public Integer getStatusId() {
		return statusId;
	}

	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdDateTime
	 */
	public Timestamp getCreatedDateTime() {
		return createdDateTime;
	}

	/**
	 * @param createdDateTime the createdDateTime to set
	 */
	public void setCreatedDateTime(Timestamp createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	/**
	 * @return the editedBy
	 */
	public String getEditedBy() {
		return editedBy;
	}

	/**
	 * @param editedBy the editedBy to set
	 */
	public void setEditedBy(String editedBy) {
		this.editedBy = editedBy;
	}

	/**
	 * @return the editedDateTime
	 */
	public Timestamp getEditedDateTime() {
		return editedDateTime;
	}

	/**
	 * @param editedDateTime the editedDateTime to set
	 */
	public void setEditedDateTime(Timestamp editedDateTime) {
		this.editedDateTime = editedDateTime;
	}

	/**
	 * @return the productPrograms
	 */
	public List<ProductProgram> getProductPrograms() {
		return productPrograms;
	}

	/**
	 * @param productPrograms the productPrograms to set
	 */
	public void setProductPrograms(List<ProductProgram> productPrograms) {
		this.productPrograms = productPrograms;
	}

	/**
	 * @return the productPlasticTypes
	 */
	public List<ProductPlasticType> getProductPlasticTypes() {
		return productPlasticTypes;
	}

	/**
	 * @param productPlasticTypes the productPlasticTypes to set
	 */
	public void setProductPlasticTypes(List<ProductPlasticType> productPlasticTypes) {
		this.productPlasticTypes = productPlasticTypes;
	}

	/**
	 * @return the apPointTxnDetails
	 */
	public List<ApPointTxnDetails> getApPointTxnDetails() {
		return apPointTxnDetails;
	}

	/**
	 * @param apPointTxnDetails the apPointTxnDetails to set
	 */
	public void setApPointTxnDetails(List<ApPointTxnDetails> apPointTxnDetails) {
		this.apPointTxnDetails = apPointTxnDetails;
	}

}
