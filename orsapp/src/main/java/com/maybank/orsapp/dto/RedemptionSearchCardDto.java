/**
 * 
 */
package com.maybank.orsapp.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 80003905
 *
 */

@JsonInclude(Include.NON_NULL)
public class RedemptionSearchCardDto {

	@JsonProperty
	private String cardNumber;
	
	@JsonProperty
	private BigDecimal pointsRedeemed;
	
	@JsonProperty
	private BigDecimal previousBalance;
	
	@JsonProperty
	private BigDecimal newBalance;

	/**
	 * 
	 */
	public RedemptionSearchCardDto() {
		
	}

	/**
	 * @param cardNumber
	 * @param pointsRedeemed
	 * @param previousBalance
	 * @param newBalance
	 */
	public RedemptionSearchCardDto(String cardNumber, BigDecimal pointsRedeemed, BigDecimal previousBalance) {
		this.cardNumber = cardNumber;
		this.pointsRedeemed = pointsRedeemed;
		this.previousBalance = previousBalance;
		this.newBalance = previousBalance.subtract(pointsRedeemed);
	}

	/**
	 * @return the cardNumber
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * @return the pointsRedeemed
	 */
	public BigDecimal getPointsRedeemed() {
		return pointsRedeemed;
	}

	/**
	 * @param pointsRedeemed the pointsRedeemed to set
	 */
	public void setPointsRedeemed(BigDecimal pointsRedeemed) {
		this.pointsRedeemed = pointsRedeemed;
	}

	/**
	 * @return the previousBalance
	 */
	public BigDecimal getPreviousBalance() {
		return previousBalance;
	}

	/**
	 * @param previousBalance the previousBalance to set
	 */
	public void setPreviousBalance(BigDecimal previousBalance) {
		this.previousBalance = previousBalance;
	}

	/**
	 * @return the newBalance
	 */
	public BigDecimal getNewBalance() {
		return newBalance;
	}

	/**
	 * @param newBalance the newBalance to set
	 */
	public void setNewBalance(BigDecimal newBalance) {
		this.newBalance = newBalance;
	}

}
