/**
 * 
 */
package com.maybank.orsapp.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.maybank.orsapp.utils.TimeStampConversion;

/**
 * @author 80003905
 *
 */

public class RedemptionSearchProductDto extends TimeStampConversion{

	@JsonProperty
	private String productCode;
	
	@JsonProperty
	private String productName;
	
	@JsonProperty
	private String merchantId;
	
	@JsonProperty
	private String merchantName;
	
	@JsonProperty
	private String terminalId;
	
	@JsonProperty
	private Integer points;
	
	@JsonProperty
	private Integer quantity;
	
	@JsonProperty
	private BigDecimal totalPoints;
	
	@JsonProperty
	private String courierNo;
	
	@JsonProperty
	private String courierDate;
	
	@JsonProperty
	private String courierNote;
	
	/**
	 * 
	 */
	public RedemptionSearchProductDto() {
		
	}

	/**
	 * @param productCode
	 * @param productName
	 * @param merchantId
	 * @param merchantName
	 * @param points
	 * @param quantity
	 * @param totalPoints
	 */
	public RedemptionSearchProductDto(String productCode, String productName, String merchantId, String merchantName, String terminalId,
			Integer points, Integer quantity, String courierNo, Date courierDate) {
		this.productCode = productCode;
		this.productName = productName;
		this.merchantId = merchantId;
		this.merchantName = merchantName;
		this.terminalId = terminalId;
		this.points = points;
		this.quantity = quantity;
		this.totalPoints = new BigDecimal(points).multiply(new BigDecimal(quantity));
		this.courierNo = courierNo;
		this.courierDate = courierDate != null?dateTimeFormat(courierDate):"";
	}

	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}



	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
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
	 * @return the merchantName
	 */
	public String getMerchantName() {
		return merchantName;
	}

	/**
	 * @param merchantName the merchantName to set
	 */
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	/**
	 * @return the terminalId
	 */
	public String getTerminalId() {
		return terminalId;
	}

	/**
	 * @param terminalId the terminalId to set
	 */
	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	/**
	 * @return the points
	 */
	public Integer getPoints() {
		return points;
	}



	/**
	 * @param points the points to set
	 */
	public void setPoints(Integer points) {
		this.points = points;
	}



	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}



	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the totalPoints
	 */
	public BigDecimal getTotalPoints() {
		return totalPoints;
	}

	/**
	 * @param totalPoints the totalPoints to set
	 */
	public void setTotalPoints(BigDecimal totalPoints) {
		this.totalPoints = totalPoints;
	}

	/**
	 * @return the courierNo
	 */
	public String getCourierNo() {
		return courierNo;
	}

	/**
	 * @param courierNo the courierNo to set
	 */
	public void setCourierNo(String courierNo) {
		this.courierNo = courierNo;
	}

	/**
	 * @return the courierDate
	 */
	public String getCourierDate() {
		return courierDate;
	}

	/**
	 * @param courierDate the courierDate to set
	 */
	public void setCourierDate(String courierDate) {
		this.courierDate = courierDate;
	}

	/**
	 * @return the courierNote
	 */
	public String getCourierNote() {
		return courierNote;
	}

	/**
	 * @param courierNote the courierNote to set
	 */
	public void setCourierNote(String courierNote) {
		this.courierNote = courierNote;
	}

}
