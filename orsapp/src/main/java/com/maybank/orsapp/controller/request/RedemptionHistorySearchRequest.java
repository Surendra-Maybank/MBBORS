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
public class RedemptionHistorySearchRequest {
	
	@JsonProperty
	private String redemptionStartDate;
	
	@JsonProperty
	private String redemptionEndDate;
	
	@JsonProperty
	private String customerIcNo;
	
	@JsonProperty
	private String merchantId;
	
	@JsonProperty
	private String orderNo;
	
	@JsonProperty
	private String myTreatsOrderNo;

	/**
	 * @return the redemptionStartDate
	 */
	public String getRedemptionStartDate() {
		return redemptionStartDate;
	}

	/**
	 * @param redemptionStartDate the redemptionStartDate to set
	 */
	public void setRedemptionStartDate(String redemptionStartDate) {
		this.redemptionStartDate = redemptionStartDate;
	}

	/**
	 * @return the redemptionEndDate
	 */
	public String getRedemptionEndDate() {
		return redemptionEndDate;
	}

	/**
	 * @param redemptionEndDate the redemptionEndDate to set
	 */
	public void setRedemptionEndDate(String redemptionEndDate) {
		this.redemptionEndDate = redemptionEndDate;
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
	 * @return the merchantId
	 */
	public String getMerchantId() {
		return merchantId;
	}

	/**
	 * @param merchantId the merchantId to set
	 */
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	/**
	 * @return the orderNo
	 */
	public String getOrderNo() {
		return orderNo;
	}

	/**
	 * @param orderNo the orderNo to set
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	/**
	 * @return the myTreatsOrderNo
	 */
	public String getMyTreatsOrderNo() {
		return myTreatsOrderNo;
	}

	/**
	 * @param myTreatsOrderNo the myTreatsOrderNo to set
	 */
	public void setMyTreatsOrderNo(String myTreatsOrderNo) {
		this.myTreatsOrderNo = myTreatsOrderNo;
	}
}
