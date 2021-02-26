/**
 * 
 */
package com.maybank.orsapp.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 80003905
 *
 */
public class CardsDTO {
	
	@JsonProperty
	private String programCodeDesc;
	
	@JsonProperty
	private List<CardHolderPointBucketDto> userCardsList;
	
	@JsonProperty
	private BigDecimal sumOfTotalPointsBalance;

	/**
	 * @return the programCodeDesc
	 */
	public String getProgramCodeDesc() {
		return programCodeDesc;
	}

	/**
	 * @param programCodeDesc the programCodeDesc to set
	 */
	public void setProgramCodeDesc(String programCodeDesc) {
		this.programCodeDesc = programCodeDesc;
	}

	/**
	 * @return the userCardsList
	 */
	public List<CardHolderPointBucketDto> getUserCardsList() {
		return userCardsList;
	}

	/**
	 * @param userCardsList the userCardsList to set
	 */
	public void setUserCardsList(List<CardHolderPointBucketDto> userCardsList) {
		this.userCardsList = userCardsList;
	}

	/**
	 * @return the sumOfTotalPointsBalance
	 */
	public BigDecimal getSumOfTotalPointsBalance() {
		return sumOfTotalPointsBalance;
	}

	/**
	 * @param sumOfTotalPointsBalance the sumOfTotalPointsBalance to set
	 */
	public void setSumOfTotalPointsBalance(BigDecimal sumOfTotalPointsBalance) {
		this.sumOfTotalPointsBalance = sumOfTotalPointsBalance;
	}
	
	

}
