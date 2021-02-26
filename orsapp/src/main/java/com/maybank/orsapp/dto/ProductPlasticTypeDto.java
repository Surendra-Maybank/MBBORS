/**
 * 
 */
package com.maybank.orsapp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 80003905
 *
 */

@JsonInclude(Include.NON_NULL)
public class ProductPlasticTypeDto {
	
	@JsonProperty
	private Long productPlasticTypeId;
	
	@JsonProperty
	private Long plasticTypeId;
	
	@JsonProperty
	private String plasticTypeCode;
	
	@JsonProperty
	private String plasticTypeDesc;
	
	public ProductPlasticTypeDto() {
	
	}
	
	/***
	 * 
	 * @param plasticTypeId
	 * @param plasticTypeCode
	 * @param plasticTypeDesc
	 */
	public ProductPlasticTypeDto(Long plasticTypeId, String plasticTypeCode,
			String plasticTypeDesc) {
		this.plasticTypeId = plasticTypeId;
		this.plasticTypeCode = plasticTypeCode;
		this.plasticTypeDesc = plasticTypeDesc;
	}
	
	/**
	 * @param productPlasticTypeId
	 * @param plasticTypeId
	 * @param plasticTypeCode
	 * @param plasticTypeDesc
	 */
	public ProductPlasticTypeDto(Long productPlasticTypeId, Long plasticTypeId, String plasticTypeCode,
			String plasticTypeDesc) {
		this.productPlasticTypeId = productPlasticTypeId;
		this.plasticTypeId = plasticTypeId;
		this.plasticTypeCode = plasticTypeCode;
		this.plasticTypeDesc = plasticTypeDesc;
	}

	/**
	 * @return the productPlasticTypeId
	 */
	public Long getProductPlasticTypeId() {
		return productPlasticTypeId;
	}

	/**
	 * @param productPlasticTypeId the productPlasticTypeId to set
	 */
	public void setProductPlasticTypeId(Long productPlasticTypeId) {
		this.productPlasticTypeId = productPlasticTypeId;
	}

	/**
	 * @return the plasticTypeId
	 */
	public Long getPlasticTypeId() {
		return plasticTypeId;
	}

	/**
	 * @param plasticTypeId the plasticTypeId to set
	 */
	public void setPlasticTypeId(Long plasticTypeId) {
		this.plasticTypeId = plasticTypeId;
	}

	/**
	 * @return the plasticTypeCode
	 */
	public String getPlasticTypeCode() {
		return plasticTypeCode;
	}

	/**
	 * @param plasticTypeCode the plasticTypeCode to set
	 */
	public void setPlasticTypeCode(String plasticTypeCode) {
		this.plasticTypeCode = plasticTypeCode;
	}

	/**
	 * @return the plasticTypeDesc
	 */
	public String getPlasticTypeDesc() {
		return plasticTypeDesc;
	}

	/**
	 * @param plasticTypeDesc the plasticTypeDesc to set
	 */
	public void setPlasticTypeDesc(String plasticTypeDesc) {
		this.plasticTypeDesc = plasticTypeDesc;
	}
	
	

}
