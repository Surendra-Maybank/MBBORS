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
public class ProductProgramDto {
	
	@JsonProperty
	private Long productProgramId;
	
	@JsonProperty
	private Long programId;
	
	@JsonProperty
	private String programCode;
	
	@JsonProperty
	private String programDesc;
	
	@JsonProperty
	private Long productId;
	
	public ProductProgramDto() {
		
	}

	/**
	 * @param productProgramId
	 * @param programId
	 * @param productId
	 */
	public ProductProgramDto(Long productProgramId, Long programId, String programCode, String programDesc) {
		this.productProgramId = productProgramId;
		this.programId = programId;
		this.programCode = programCode;
		this.programDesc = programDesc;
	}


	/**
	 * @return the productProgramId
	 */
	public Long getProductProgramId() {
		return productProgramId;
	}

	/**
	 * @param productProgramId the productProgramId to set
	 */
	public void setProductProgramId(Long productProgramId) {
		this.productProgramId = productProgramId;
	}

	/**
	 * @return the programId
	 */
	public Long getProgramId() {
		return programId;
	}

	/**
	 * @param programId the programId to set
	 */
	public void setProgramId(Long programId) {
		this.programId = programId;
	}
	
	/**
	 * @return the programCode
	 */
	public String getProgramCode() {
		return programCode;
	}

	/**
	 * @param programCode the programCode to set
	 */
	public void setProgramCode(String programCode) {
		this.programCode = programCode;
	}

	/**
	 * @return the programDesc
	 */
	public String getProgramDesc() {
		return programDesc;
	}

	/**
	 * @param programDesc the programDesc to set
	 */
	public void setProgramDesc(String programDesc) {
		this.programDesc = programDesc;
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
}
