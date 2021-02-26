/**
 * 
 */
package com.maybank.orsapp.controller.response;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.maybank.orsapp.dto.CardsDTO;
import com.maybank.orsapp.dto.DTCardInfoDto;

/**
 * @author 80003905
 *
 */

@JsonInclude(Include.NON_NULL)
public class PointInquiryResponse {
	
	@JsonProperty
	private String responseCode;
	
	@JsonProperty
	private String responseMessage;
	
	@JsonProperty
	private String customerName;
	
	@JsonProperty
	private String customerIcNumber;
	
	@JsonProperty
	private List<CardsDTO> cardInfoList;
	
	@JsonProperty
	private Map<String, BigDecimal> sumOfTotalPointsBalance;
	
	@JsonProperty
	private List<DTCardInfoDto> rewardTypeCardInfoList;
	
	@JsonProperty
	private String totalPointsBalForPP;
	
	@JsonProperty
	private String totalPointsBalForSP;
	
	@JsonProperty
	private BigDecimal totalPointsBalForXX;
	
	@JsonProperty
	private String totalPointsBal;
	
	@JsonProperty
	private String totalEquivalentRMValue;
	
	/**
	 * @return the code
	 */
	public String getResponseCode() {
		return responseCode;
	}

	/**
	 * @param code the code to set
	 */
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * @return the message
	 */
	public String getResponseMessage() {
		return responseMessage;
	}

	/**
	 * @param message the message to set
	 */
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the customerIcNumber
	 */
	public String getCustomerIcNumber() {
		return customerIcNumber;
	}

	/**
	 * @param customerIcNumber the customerIcNumber to set
	 */
	public void setCustomerIcNumber(String customerIcNumber) {
		this.customerIcNumber = customerIcNumber;
	}

	/**
	 * @return the rewardTypeCardInfoList
	 */
	public List<DTCardInfoDto> getRewardTypeCardInfoList() {
		return rewardTypeCardInfoList;
	}

	/**
	 * @param rewardTypeCardInfoList the rewardTypeCardInfoList to set
	 */
	public void setRewardTypeCardInfoList(List<DTCardInfoDto> rewardTypeCardInfoList) {
		this.rewardTypeCardInfoList = rewardTypeCardInfoList;
	}
	
	/**
	 * @return the mapCardInfo
	 */
	public List<CardsDTO> getCardInfoList() {
		return cardInfoList;
	}
	
	/**
	 * @param mapCardInfo the mapCardInfo to set
	 */
	public void setCardInfoList(List<CardsDTO> cardInfoList) {
		this.cardInfoList = cardInfoList;
	}
	/**
	 * @return the sumOfTotalPointsBalance
	 */
	public Map<String, BigDecimal> getSumOfTotalPointsBalance() {
		return sumOfTotalPointsBalance;
	}

	/**
	 * @param sumOfTotalPointsBalance the sumOfTotalPointsBalance to set
	 */
	public void setSumOfTotalPointsBalance(Map<String, BigDecimal> sumOfTotalPointsBalance) {
		this.sumOfTotalPointsBalance = sumOfTotalPointsBalance;
	}

	/**
	 * @return the totalPointsBalForPP
	 */
	public String getTotalPointsBalForPP() {
		return totalPointsBalForPP;
	}

	/**
	 * @param totalPointsBalForPP the totalPointsBalForPP to set
	 */
	public void setTotalPointsBalForPP(String totalPointsBalForPP) {
		this.totalPointsBalForPP = totalPointsBalForPP;
	}

	/**
	 * @return the totalPointsBalForSP
	 */
	public String getTotalPointsBalForSP() {
		return totalPointsBalForSP;
	}

	/**
	 * @param totalPointsBalForSP the totalPointsBalForSP to set
	 */
	public void setTotalPointsBalForSP(String totalPointsBalForSP) {
		this.totalPointsBalForSP = totalPointsBalForSP;
	}

	/**
	 * @return the totalPointsBalForXX
	 */
	public BigDecimal getTotalPointsBalForXX() {
		return totalPointsBalForXX;
	}

	/**
	 * @param totalPointsBalForXX the totalPointsBalForXX to set
	 */
	public void setTotalPointsBalForXX(BigDecimal totalPointsBalForXX) {
		this.totalPointsBalForXX = totalPointsBalForXX;
	}

	/**
	 * @return the totalPointsBal
	 */
	public String getTotalPointsBal() {
		return totalPointsBal;
	}

	/**
	 * @param totalPointsBal the totalPointsBal to set
	 */
	public void setTotalPointsBal(String totalPointsBal) {
		this.totalPointsBal = totalPointsBal;
	}

	/**
	 * @return the totalEquivalentRMValue
	 */
	public String getTotalEquivalentRMValue() {
		return totalEquivalentRMValue;
	}

	/**
	 * @param totalEquivalentRMValue the totalEquivalentRMValue to set
	 */
	public void setTotalEquivalentRMValue(String totalEquivalentRMValue) {
		this.totalEquivalentRMValue = totalEquivalentRMValue;
	}
	
	

}
