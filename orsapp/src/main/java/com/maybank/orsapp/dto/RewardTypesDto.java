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
public class RewardTypesDto {
	
	@JsonProperty
	private Long rewardTypeId;
	
	@JsonProperty
	private String rewardTypeCode;
	
	@JsonProperty
	private String rewardTypeDesc;

	/**
	 * @return the rewardTypeId
	 */
	public Long getRewardTypeId() {
		return rewardTypeId;
	}

	/**
	 * @param rewardTypeId the rewardTypeId to set
	 */
	public void setRewardTypeId(Long rewardTypeId) {
		this.rewardTypeId = rewardTypeId;
	}

	/**
	 * @return the rewardTypeCode
	 */
	public String getRewardTypeCode() {
		return rewardTypeCode;
	}

	/**
	 * @param rewardTypeCode the rewardTypeCode to set
	 */
	public void setRewardTypeCode(String rewardTypeCode) {
		this.rewardTypeCode = rewardTypeCode;
	}

	/**
	 * @return the rewardTypeDesc
	 */
	public String getRewardTypeDesc() {
		return rewardTypeDesc;
	}

	/**
	 * @param rewardTypeDesc the rewardTypeDesc to set
	 */
	public void setRewardTypeDesc(String rewardTypeDesc) {
		this.rewardTypeDesc = rewardTypeDesc;
	}
	
}
