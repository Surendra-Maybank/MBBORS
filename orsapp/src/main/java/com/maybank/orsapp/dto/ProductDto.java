/**
 * 
 */
package com.maybank.orsapp.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.maybank.orsapp.enums.StatusCodes;
import com.maybank.orsapp.utils.TimeStampConversion;

/**
 * @author 80003905
 *
 */

public class ProductDto extends TimeStampConversion{
	
	@JsonProperty
	private Long productId;
	
	@JsonProperty
	private String productCode;
	
	@JsonProperty
	private String productName;
	
	@JsonProperty
	private Integer unitPoint;
	
	@JsonProperty
	private BigDecimal merchantCost;
	
	@JsonProperty
	private BigDecimal actualProductCost;
	
	@JsonProperty
	private Integer productQuantity;
	
	@JsonProperty
	private Long merchantId;
	
	@JsonProperty
	private String merchantName;
	
	@JsonProperty
	private String validStartDate;
	
	@JsonProperty
	private String validEndDate;
	
	@JsonProperty
	private String imagePath;
	
	@JsonProperty
	private Long categoryTypeId;
	
	@JsonProperty
	private String categoryTypeDesc;
	
	@JsonProperty
	private Long airlinesId;
	
	@JsonProperty
	private String airlinesDesc;
	
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	private Long plasticTypes;
	
	@JsonProperty
	private Boolean isPremiumRedemption = Boolean.FALSE;
	
	@JsonProperty
	private BigDecimal creditAmount;
	
	@JsonProperty
	private BigDecimal debitAmount;
	
	@JsonProperty
	private BigDecimal conversionPoint;
	
	@JsonProperty
	private String remarks;
	
	@JsonProperty
	private StatusCodes statusDesc;

	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	private String createdBy;

	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	private String createdDateTime;

	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	private String editedBy;

	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	private String editedDateTime;
	
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	private String rewardType;
	
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	private String programCodes;
	
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	private List<ProductProgramDto> productProgramDtos;	
	
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	private List<ProductPlasticTypeDto> listOfSelectedPlasticTypes;

	public ProductDto() {
		
	}

	/***
	 * 
	 * @param productId
	 * @param productCode
	 * @param productName
	 * @param unitPoint
	 * @param merchantCost
	 * @param actualProductCost
	 * @param statusId
	 * @param merchantName
	 * @param productQuantity
	 * @param rewardType
	 * @param validStartDate
	 * @param validEndDate
	 * @param categoryTypeDesc
	 * @param airlinesDesc
	 * @param creditAmount
	 * @param debitAmount
	 * @param conversionPoint
	 * @param remarks
	 * @param createdBy
	 * @param createdDateTime
	 * @param editedBy
	 * @param editedDateTime
	 */
	public ProductDto(Long productId, String productCode, String productName, Integer unitPoint, BigDecimal merchantCost,
			BigDecimal actualProductCost, Integer statusId, String merchantName, Integer productQuantity, String rewardType, 
			Date validStartDate, Date validEndDate, String categoryTypeDesc, String airlinesDesc, BigDecimal creditAmount, 
			BigDecimal debitAmount, BigDecimal conversionPoint, String remarks, String createdBy, Date createdDateTime, String editedBy, Date editedDateTime) {
		this.productId = productId;
		this.productCode = productCode;
		this.productName = productName;
		this.unitPoint = unitPoint;
		this.merchantCost = merchantCost;
		this.actualProductCost = actualProductCost;
		this.statusDesc = StatusCodes.valueOf(statusId);
		this.merchantName = merchantName;
		this.productQuantity = productQuantity;
		this.rewardType = rewardType;
		this.validStartDate = dateTimeFormat(validStartDate);
		this.validEndDate = dateTimeFormat(validEndDate);
		this.categoryTypeDesc = categoryTypeDesc;
		this.airlinesDesc = airlinesDesc;
		this.creditAmount = creditAmount;
		this.debitAmount = debitAmount;
		this.conversionPoint = conversionPoint;
		this.remarks = remarks;
		this.createdBy = createdBy;
		this.createdDateTime = dateTimeFormat(createdDateTime);
		this.editedBy = editedBy;
		this.editedDateTime = dateTimeFormat(editedDateTime);
	}
	
	/***
	 * 
	 * @param productId
	 * @param productCode
	 * @param productName
	 * @param unitPoint
	 * @param merchantCost
	 * @param actualProductCost
	 * @param productQuantity
	 * @param merchantId
	 * @param merchantName
	 * @param validStartDate
	 * @param validEndDate
	 * @param categoryTypeId
	 * @param categoryTypeDesc
	 * @param airlinesId
	 * @param airlinesDesc
	 * @param isPremiumRedemption
	 * @param creditAmount
	 * @param debitAmount
	 * @param conversionPoint
	 * @param remarks
	 * @param statusId
	 * @param createdBy
	 * @param createdDateTime
	 * @param editedBy
	 * @param editedDateTime
	 */
	public ProductDto(Long productId, String productCode, String productName, Integer unitPoint, BigDecimal merchantCost,
			BigDecimal actualProductCost, Integer productQuantity, BigDecimal merchantId, String merchantName,
			Date validStartDate, Date validEndDate,  Long categoryTypeId, String categoryTypeDesc,
			Long airlinesId, String airlinesDesc, Boolean isPremiumRedemption, BigDecimal creditAmount,
			BigDecimal debitAmount, BigDecimal conversionPoint, String remarks, Integer statusId, String createdBy, Date createdDateTime, String editedBy, Date editedDateTime) {
		this.productId = productId;
		this.productCode = productCode;
		this.productName = productName;
		this.unitPoint = unitPoint;
		this.merchantCost = merchantCost;
		this.actualProductCost = actualProductCost;
		this.productQuantity = productQuantity;
		this.merchantId = merchantId.longValue();
		this.merchantName = merchantName;
		this.validStartDate = dateTimeFormat(validStartDate);
		this.validEndDate = dateTimeFormat(validEndDate);
		//this.imagePath = imagePath;
		this.categoryTypeId = categoryTypeId;
		this.categoryTypeDesc = categoryTypeDesc;
		this.airlinesId = airlinesId;
		this.airlinesDesc = airlinesDesc;
		this.isPremiumRedemption = isPremiumRedemption;
		this.creditAmount = creditAmount;
		this.debitAmount = debitAmount;
		this.conversionPoint = conversionPoint;
		this.remarks = remarks;
		this.statusDesc = StatusCodes.valueOf(statusId);
		this.createdBy = createdBy;
		this.createdDateTime = dateTimeFormat(createdDateTime);
		this.editedBy = editedBy;
		this.editedDateTime = dateTimeFormat(editedDateTime);
	}

	/**
	 * @return the productId
	 */
	public Long getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
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
	 * @return the merchantName
	 */
	public String getMerchantName() {
		return merchantName;
	}

	/**
	 * @param merchantName the merchantName to set
	 */
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	/**
	 * @return the validStartDate
	 */
	public String getValidStartDate() {
		return validStartDate;
	}

	/**
	 * @param validStartDate the validStartDate to set
	 */
	public void setValidStartDate(String validStartDate) {
		this.validStartDate = validStartDate;
	}

	/**
	 * @return the validEndDate
	 */
	public String getValidEndDate() {
		return validEndDate;
	}

	/**
	 * @param validEndDate the validEndDate to set
	 */
	public void setValidEndDate(String validEndDate) {
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
	 * @return the categoryTypeDesc
	 */
	public String getCategoryTypeDesc() {
		return categoryTypeDesc;
	}

	/**
	 * @param categoryTypeDesc the categoryTypeDesc to set
	 */
	public void setCategoryTypeDesc(String categoryTypeDesc) {
		this.categoryTypeDesc = categoryTypeDesc;
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
	 * @return the airlinesDesc
	 */
	public String getAirlinesDesc() {
		return airlinesDesc;
	}

	/**
	 * @param airlinesDesc the airlinesDesc to set
	 */
	public void setAirlinesDesc(String airlinesDesc) {
		this.airlinesDesc = airlinesDesc;
	}

	/**
	 * @return the plasticTypes
	 */
	public Long getPlasticTypes() {
		return plasticTypes;
	}

	/**
	 * @param plasticTypes the plasticTypes to set
	 */
	public void setPlasticTypes(Long plasticTypes) {
		this.plasticTypes = plasticTypes;
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
	public StatusCodes getStatusDesc() {
		return statusDesc;
	}

	/**
	 * @param statusDesc the statusDesc to set
	 */
	public void setStatusDesc(StatusCodes statusDesc) {
		this.statusDesc = statusDesc;
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
	public String getCreatedDateTime() {
		return createdDateTime;
	}

	/**
	 * @param createdDateTime the createdDateTime to set
	 */
	public void setCreatedDateTime(String createdDateTime) {
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
	public String getEditedDateTime() {
		return editedDateTime;
	}

	/**
	 * @param editedDateTime the editedDateTime to set
	 */
	public void setEditedDateTime(String editedDateTime) {
		this.editedDateTime = editedDateTime;
	}

	/**
	 * @return the rewardType
	 */
	public String getRewardType() {
		return rewardType;
	}

	/**
	 * @param rewardType the rewardType to set
	 */
	public void setRewardType(String rewardType) {
		this.rewardType = rewardType;
	}

	/**
	 * @return the programCodes
	 */
	public String getProgramCodes() {
		return programCodes;
	}

	/**
	 * @param programCodes the programCodes to set
	 */
	public void setProgramCodes(String programCodes) {
		this.programCodes = programCodes;
	}

	/**
	 * @return the productProgramDtos
	 */
	public List<ProductProgramDto> getProductProgramDtos() {
		return productProgramDtos;
	}

	/**
	 * @param productProgramDtos the productProgramDtos to set
	 */
	public void setProductProgramDtos(List<ProductProgramDto> productProgramDtos) {
		this.productProgramDtos = productProgramDtos;
	}

	/**
	 * @return the listOfSelectedPlasticTypes
	 */
	public List<ProductPlasticTypeDto> getListOfSelectedPlasticTypes() {
		return listOfSelectedPlasticTypes;
	}

	/**
	 * @param listOfSelectedPlasticTypes the listOfSelectedPlasticTypes to set
	 */
	public void setListOfSelectedPlasticTypes(List<ProductPlasticTypeDto> listOfSelectedPlasticTypes) {
		this.listOfSelectedPlasticTypes = listOfSelectedPlasticTypes;
	}
	
	@Override
    public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productCode == null) ? 0 : productCode.hashCode());
		return result;
    }
	
	@Override
    public boolean equals(Object obj) {
        if (obj instanceof ProductDto) {
            return ((ProductDto) obj).productCode.equals(productCode);
        }
        return false;
    }
    
	
}
