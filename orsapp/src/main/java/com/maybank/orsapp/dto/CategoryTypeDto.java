/**
 * 
 */
package com.maybank.orsapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 80003905
 *
 */
public class CategoryTypeDto {
	
	@JsonProperty
	private Long categoryTypeId;
	
	@JsonProperty
	private String categoryTypeCode;
	
	@JsonProperty
	private String categoryTypeDesc;
	
	@JsonProperty
	private Boolean isCredit;
	
	@JsonProperty
	private Boolean isDebit;
	
	@JsonProperty
	private Boolean isPointConversion;

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
	 * @return the categoryTypeCode
	 */
	public String getCategoryTypeCode() {
		return categoryTypeCode;
	}

	/**
	 * @param categoryTypeCode the categoryTypeCode to set
	 */
	public void setCategoryTypeCode(String categoryTypeCode) {
		this.categoryTypeCode = categoryTypeCode;
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
	 * @return the debit
	 */
	public Boolean getIsDebit() {
		return isDebit;
	}

	/**
	 * @param isDebit the isDebit to set
	 */
	public void setIsDebit(Boolean isDebit) {
		this.isDebit = isDebit;
	}

	/**
	 * @return the isCredit
	 */
	public Boolean getIsCredit() {
		return isCredit;
	}

	/**
	 * @param isCredit the isCredit to set
	 */
	public void setIsCredit(Boolean isCredit) {
		this.isCredit = isCredit;
	}

	/**
	 * @return the isPointConversion
	 */
	public Boolean getIsPointConversion() {
		return isPointConversion;
	}

	/**
	 * @param isPointConversion the isPointConversion to set
	 */
	public void setIsPointConversion(Boolean isPointConversion) {
		this.isPointConversion = isPointConversion;
	}
	
	

}
