/**
 * 
 */
package com.maybank.orsapp.dto;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.maybank.orsapp.utils.TimeStampConversion;

/**
 * @author 80003905
 *
 */

public class RedemptionCustomerDto extends TimeStampConversion {

	
	@JsonProperty
	private String customerIcNo;

	@JsonProperty
	private String customerName;

	@JsonProperty
	private String deliveryAddress_1;

	@JsonProperty
	private String deliveryAddress_2;

	@JsonProperty
	private String deliveryAddress_3;

	@JsonProperty
	private String deliveryAddress_4;

	@JsonProperty
	private String deliveryZipCode;

	@JsonProperty
	private String deliveryCity;

	@JsonProperty
	private String emailId;
	
	@JsonProperty
	private String homeNumber;
	
	@JsonProperty
	private String officeNumber;

	@JsonProperty
	private String mobileNumber;

	@JsonProperty
	private String orderNo;

	@JsonProperty
	private String redemptionSource;

	@JsonProperty
	private String redemptionStatus;

	@JsonProperty
	private String redemptionBy;

	@JsonProperty
	private String redemptionDate;

	@JsonProperty
	private String rewardType;
	
	@JsonProperty
	private String cdchCardNo;
	
	@JsonProperty
	private String airlineMemberNo;

	/**
	 * 
	 */
	public RedemptionCustomerDto() {
		
	}
	
	/**
	 * 
	 * @param customerIcNo
	 * @param firstName
	 * @param lastName
	 * @param deliveryAddress_1
	 * @param deliveryAddress_2
	 * @param deliveryAddress_3
	 * @param deliveryAddress_4
	 * @param deliveryZipCode
	 * @param deliveryCity
	 * @param emailId
	 * @param homeNumber
	 * @param officeNumber
	 * @param mobileNumber
	 * @param orderNo
	 * @param redemptionSource
	 * @param redemptionStatus
	 * @param redemptionBy
	 * @param redemptionDate
	 * @param rewardTypeCode
	 * @param rewardTypeDesc
	 * @param cdchCardNo
	 * @param airlineMemberNo
	 */
	public RedemptionCustomerDto(String customerIcNo, String firstName, String lastName, String deliveryAddress_1,
			String deliveryAddress_2, String deliveryAddress_3, String deliveryAddress_4, String deliveryZipCode,
			String deliveryCity, String emailId, String homeNumber, String officeNumber, String mobileNumber, String orderNo, String redemptionSource,
			String redemptionStatus, String redemptionBy, Date redemptionDate, String rewardTypeCode, String rewardTypeDesc, String cdchCardNo, String airlineMemberNo) {
		this.customerIcNo = customerIcNo;
		this.customerName = getCustName(firstName, lastName);
		this.deliveryAddress_1 = deliveryAddress_1;
		this.deliveryAddress_2 = deliveryAddress_2;
		this.deliveryAddress_3 = deliveryAddress_3;
		this.deliveryAddress_4 = deliveryAddress_4;
		this.deliveryZipCode = deliveryZipCode;
		this.deliveryCity = deliveryCity;
		this.emailId = emailId;
		this.homeNumber = homeNumber;
		this.officeNumber = officeNumber;
		this.mobileNumber = mobileNumber;
		this.orderNo = orderNo;
		this.redemptionSource = redemptionSource;
		this.redemptionStatus = getRedemptionStatus(redemptionStatus);
		this.redemptionBy = redemptionBy;
		this.redemptionDate = dateTimeFormat(redemptionDate);
		this.rewardType = getRewardFullDesc(rewardTypeCode, rewardTypeDesc);
		this.cdchCardNo = cdchCardNo;
		this.airlineMemberNo = airlineMemberNo;
	}
	
	private String getRedemptionStatus(String redemptionStatus) {
		
		if(redemptionStatus.equalsIgnoreCase("S")) {
			return "SUCCESSFULL";
		}
		else if(redemptionStatus.equalsIgnoreCase("R")) {
			return "REVERSED";
		}else {
			return "VOID";
		}
	}
	private String getCustName(String firstName, String lastName) {
		if(StringUtils.isNotBlank(firstName) && StringUtils.isBlank(lastName))
			return firstName;
		else if(StringUtils.isBlank(firstName) && StringUtils.isNotBlank(lastName))
			return lastName;
		else if(StringUtils.isNotBlank(firstName) && StringUtils.isNotBlank(lastName))
			return firstName.concat(" ").concat(lastName);
		else return null;
	}
	
	private String getRewardFullDesc(String rewardTypeCode, String rewardTypeDesc) {
		if(StringUtils.isNotBlank(rewardTypeCode) && StringUtils.isBlank(rewardTypeDesc))
			return rewardTypeCode;
		else if(StringUtils.isBlank(rewardTypeCode) && StringUtils.isNotBlank(rewardTypeDesc))
			return rewardTypeDesc;
		else if(StringUtils.isNotBlank(rewardTypeCode) && StringUtils.isNotBlank(rewardTypeDesc))
			return rewardTypeCode.concat(" - ").concat(rewardTypeDesc);
		else return null;
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
	 * @return the deliveryAddress_1
	 */
	public String getDeliveryAddress_1() {
		return deliveryAddress_1;
	}

	/**
	 * @param deliveryAddress_1 the deliveryAddress_1 to set
	 */
	public void setDeliveryAddress_1(String deliveryAddress_1) {
		this.deliveryAddress_1 = deliveryAddress_1;
	}

	/**
	 * @return the deliveryAddress_2
	 */
	public String getDeliveryAddress_2() {
		return deliveryAddress_2;
	}

	/**
	 * @param deliveryAddress_2 the deliveryAddress_2 to set
	 */
	public void setDeliveryAddress_2(String deliveryAddress_2) {
		this.deliveryAddress_2 = deliveryAddress_2;
	}

	/**
	 * @return the deliveryAddress_3
	 */
	public String getDeliveryAddress_3() {
		return deliveryAddress_3;
	}

	/**
	 * @param deliveryAddress_3 the deliveryAddress_3 to set
	 */
	public void setDeliveryAddress_3(String deliveryAddress_3) {
		this.deliveryAddress_3 = deliveryAddress_3;
	}

	/**
	 * @return the deliveryAddress_4
	 */
	public String getDeliveryAddress_4() {
		return deliveryAddress_4;
	}

	/**
	 * @param deliveryAddress_4 the deliveryAddress_4 to set
	 */
	public void setDeliveryAddress_4(String deliveryAddress_4) {
		this.deliveryAddress_4 = deliveryAddress_4;
	}

	/**
	 * @return the deliveryZipCode
	 */
	public String getDeliveryZipCode() {
		return deliveryZipCode;
	}

	/**
	 * @param deliveryZipCode the deliveryZipCode to set
	 */
	public void setDeliveryZipCode(String deliveryZipCode) {
		this.deliveryZipCode = deliveryZipCode;
	}

	/**
	 * @return the deliveryCity
	 */
	public String getDeliveryCity() {
		return deliveryCity;
	}

	/**
	 * @param deliveryCity the deliveryCity to set
	 */
	public void setDeliveryCity(String deliveryCity) {
		this.deliveryCity = deliveryCity;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	/**
	 * @return the homeNumber
	 */
	public String getHomeNumber() {
		return homeNumber;
	}

	/**
	 * @param homeNumber the homeNumber to set
	 */
	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}

	/**
	 * @return the officeNumber
	 */
	public String getOfficeNumber() {
		return officeNumber;
	}

	/**
	 * @param officeNumber the officeNumber to set
	 */
	public void setOfficeNumber(String officeNumber) {
		this.officeNumber = officeNumber;
	}

	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
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
	 * @return the redemptionSource
	 */
	public String getRedemptionSource() {
		return redemptionSource;
	}

	/**
	 * @param redemptionSource the redemptionSource to set
	 */
	public void setRedemptionSource(String redemptionSource) {
		this.redemptionSource = redemptionSource;
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
	 * @return the redemptionBy
	 */
	public String getRedemptionBy() {
		return redemptionBy;
	}

	/**
	 * @param redemptionBy the redemptionBy to set
	 */
	public void setRedemptionBy(String redemptionBy) {
		this.redemptionBy = redemptionBy;
	}

	/**
	 * @return the redemptionDate
	 */
	public String getRedemptionDate() {
		return redemptionDate;
	}

	/**
	 * @param redemptionDate the redemptionDate to set
	 */
	public void setRedemptionDate(String redemptionDate) {
		this.redemptionDate = redemptionDate;
	}

	/**
	 * @return the rewardType
	 */
	public String getRewardType() {
		return rewardType;
	}

	/**
	 * @param rewardType the rewardType to set
	 */
	public void setRewardType(String rewardType) {
		this.rewardType = rewardType;
	}

	/**
	 * @return the cdchCardNo
	 */
	public String getCdchCardNo() {
		return cdchCardNo;
	}

	/**
	 * @param cdchCardNo the cdchCardNo to set
	 */
	public void setCdchCardNo(String cdchCardNo) {
		this.cdchCardNo = cdchCardNo;
	}

	/**
	 * @return the airlineMemberNo
	 */
	public String getAirlineMemberNo() {
		return airlineMemberNo;
	}

	/**
	 * @param airlineMemberNo the airlineMemberNo to set
	 */
	public void setAirlineMemberNo(String airlineMemberNo) {
		this.airlineMemberNo = airlineMemberNo;
	}
	
	
}
