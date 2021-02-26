/**
 * 
 */
package com.maybank.orsapp.controller.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author 80003905
 *
 */

@JsonInclude(Include.NON_NULL)
public class PointsBalRequestDto {
	
	@JsonProperty
	private Long rewardTypeId;
	
	@JsonProperty
	private String customerIcNo;
	
	@JsonProperty
	private String customerCardNo;

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
	 * @return the customerIcNo
	 */
	public String getCustomerIcNo() {
		return customerIcNo;
	}

	/**
	 * @param customerIcNo the customerIcNo to set
	 */
	public void setCustomerIcNo(String customerIcNo) {
		this.customerIcNo = customerIcNo;
	}

	/**
	 * @return the customerCardNo
	 */
	public String getCustomerCardNo() {
		return customerCardNo;
	}

	/**
	 * @param customerCardNo the customerCardNo to set
	 */
	public void setCustomerCardNo(String customerCardNo) {
		this.customerCardNo = customerCardNo;
	}
	
	

}
