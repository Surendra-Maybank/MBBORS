/**
 * 
 */
package com.maybank.orsapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 80003905
 *
 */
public class AirlinesDto {
	
	
	@JsonProperty
	private Long airlinesId;
	
	@JsonProperty
	private String airlinesCode;
	
	@JsonProperty
	private String airlinesDesc;

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
	 * @return the airlinesCode
	 */
	public String getAirlinesCode() {
		return airlinesCode;
	}

	/**
	 * @param airlinesCode the airlinesCode to set
	 */
	public void setAirlinesCode(String airlinesCode) {
		this.airlinesCode = airlinesCode;
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
	
	

}
