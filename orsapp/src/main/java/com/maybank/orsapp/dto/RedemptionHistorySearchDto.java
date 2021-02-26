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
public class RedemptionHistorySearchDto{
	
	@JsonProperty
	private Long pointTxnId;
	
	private String orderNo;
	
	private String customerCardNumbers;
	
	private String transactionDateTime;
	
	private String productName;
	
	private String redemptionStatus;
		
	public RedemptionHistorySearchDto() {
		
	}

	/**
	 * @param pointTxnId
	 * @param orderNo
	 * @param customerCardNumbers
	 * @param transactionDateTime
	 * @param redemptionStatus
	 */
	public RedemptionHistorySearchDto(Long pointTxnId, String orderNo, String customerCardNumbers,
			String transactionDateTime, String redemptionStatus) {
		
		this.pointTxnId = pointTxnId;
		this.orderNo = orderNo;
		this.customerCardNumbers = customerCardNumbers;
		this.transactionDateTime = transactionDateTime;
		this.redemptionStatus = redemptionStatus;
	}



	/**
	 * @return the pointTxnId
	 */
	public Long getPointTxnId() {
		return pointTxnId;
	}

	/**
	 * @param pointTxnId the pointTxnId to set
	 */
	public void setPointTxnId(Long pointTxnId) {
		this.pointTxnId = pointTxnId;
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
	 * @return the customerCardNumbers
	 */
	public String getCustomerCardNumbers() {
		return customerCardNumbers;
	}

	/**
	 * @param customerCardNumbers the customerCardNumbers to set
	 */
	public void setCustomerCardNumbers(String customerCardNumbers) {
		this.customerCardNumbers = customerCardNumbers;
	}

	/**
	 * @return the transactionDateTime
	 */
	public String getTransactionDateTime() {
		return transactionDateTime;
	}

	/**
	 * @param transactionDateTime the transactionDateTime to set
	 */
	public void setTransactionDateTime(String transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}

	/**
	 * @return the redemptionStatus
	 */
	public String getRedemptionStatus() {
		return redemptionStatus;
	}

	/**
	 * @param redemptionStatus the redemptionStatus to set
	 */
	public void setRedemptionStatus(String redemptionStatus) {
		this.redemptionStatus = redemptionStatus;
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
	
	

}
