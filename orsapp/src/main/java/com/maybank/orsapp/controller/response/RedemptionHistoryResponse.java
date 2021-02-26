/**
 * 
 */
package com.maybank.orsapp.controller.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.maybank.orsapp.dto.RedemptionCustomerDto;
import com.maybank.orsapp.dto.RedemptionHistorySearchDto;
import com.maybank.orsapp.dto.RedemptionSearchCardDto;
import com.maybank.orsapp.dto.RedemptionSearchProductDto;

/**
 * @author 80003905
 *
 */

@JsonInclude(Include.NON_NULL)
public class RedemptionHistoryResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4098064529991810203L;
	
	@JsonProperty
	private String responseCode;
	
	@JsonProperty
	private String responseMessage;
	
	@JsonProperty
	private RedemptionCustomerDto customerDetails;
	
	@JsonProperty
	private List<RedemptionSearchProductDto> productList;
	
	@JsonProperty
	private BigDecimal totalPointsRedeemed = BigDecimal.ZERO;
	
	@JsonProperty
	private List<RedemptionSearchCardDto> redeemedCardList;
	
	@JsonProperty
	private List<RedemptionHistorySearchDto> redemptionHistorySearchList;

	/**
	 * @return the responseCode
	 */
	public String getResponseCode() {
		return responseCode;
	}

	/**
	 * @param responseCode the responseCode to set
	 */
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * @return the responseMessage
	 */
	public String getResponseMessage() {
		return responseMessage;
	}

	/**
	 * @param responseMessage the responseMessage to set
	 */
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	/**
	 * @return the customerDetails
	 */
	public RedemptionCustomerDto getCustomerDetails() {
		return customerDetails;
	}

	/**
	 * @param customerDetails the customerDetails to set
	 */
	public void setCustomerDetails(RedemptionCustomerDto customerDetails) {
		this.customerDetails = customerDetails;
	}

	/**
	 * @return the productList
	 */
	public List<RedemptionSearchProductDto> getProductList() {
		return productList;
	}

	/**
	 * @param productList the productList to set
	 */
	public void setProductList(List<RedemptionSearchProductDto> productList) {
		this.productList = productList;
	}

	/**
	 * @return the totalPointsRedeemed
	 */
	public BigDecimal getTotalPointsRedeemed() {
		return totalPointsRedeemed;
	}

	/**
	 * @param totalPointsRedeemed the totalPointsRedeemed to set
	 */
	public void setTotalPointsRedeemed(BigDecimal totalPointsRedeemed) {
		this.totalPointsRedeemed = totalPointsRedeemed;
	}

	/**
	 * @return the redeemedCardList
	 */
	public List<RedemptionSearchCardDto> getRedeemedCardList() {
		return redeemedCardList;
	}

	/**
	 * @param redeemedCardList the redeemedCardList to set
	 */
	public void setRedeemedCardList(List<RedemptionSearchCardDto> redeemedCardList) {
		this.redeemedCardList = redeemedCardList;
	}

	/**
	 * @return the redemptionHistorySearchList
	 */
	public List<RedemptionHistorySearchDto> getRedemptionHistorySearchList() {
		return redemptionHistorySearchList;
	}

	/**
	 * @param redemptionHistorySearchList the redemptionHistorySearchList to set
	 */
	public void setRedemptionHistorySearchList(List<RedemptionHistorySearchDto> redemptionHistorySearchList) {
		this.redemptionHistorySearchList = redemptionHistorySearchList;
	}
	
	

}
