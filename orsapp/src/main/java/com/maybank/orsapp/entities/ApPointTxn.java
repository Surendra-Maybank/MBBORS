/**
 * 
 */
package com.maybank.orsapp.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author 80003905
 *
 */

@Entity
@Table(name = "ap_POINT_TXN")
public class ApPointTxn implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6283735582855456871L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "POINT_TXN_ID", unique = true, nullable = false)
	private Long pointTxnId;
	
	@Column(name = "CARDHOLDER_ID", unique = true, nullable = false)
	private Long cardHolderId;
	
	@Column(name = "ORDER_NO", nullable = false)
	private String orderNo;
	
	@Column(name = "REF_ORDER_ID")
	private String refOrderId;
	
	@Column(name = "CUST_IC_NO")
	private String customerIcNo;
	
	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "TOTAL_POINT_REDEEMED")
	private Double totalPointRedeemed;
	
	@Column(name = "TOTAL_AMOUNT_PURCHASED")
	private BigDecimal totalAmountPurchased;
	
	@Column(name = "REWARD_TYPE_ID")
	private Long rewardTypeId;
	
	@Column(name = "DELIVERY_ADDR1")
	private String deliveryAddress_1;
	
	@Column(name = "DELIVERY_ADDR2")
	private String deliveryAddress_2;
	
	@Column(name = "DELIVERY_ADDR3")
	private String deliveryAddress_3;
	
	@Column(name = "DELIVERY_ADDR4")
	private String deliveryAddress_4;
	
	@Column(name = "DELIVERY_ZIP_CODE")
	private String deliveryZipCode;
	
	@Column(name = "DELIVERY_CITY")
	private String deliveryCity;

	@Column(name = "EMAIL")
	private String emailId;
	
	@Column(name = "HOME_NO")
	private String homeNumber;
	
	@Column(name = "OFFICE_NO")
	private String officeNumber;
	
	@Column(name = "MOBILE_NO")
	private String mobileNumber;
	
	@Column(name = "REDEMPTION_SOURCE")
	private String redemptionSource;
	
	@Column(name = "TXN_TYPE")
	private String txnType;
	
	@Column(name = "REDEMPTION_STATUS")
	private String redemptionStatus;
	
	@Column(name = "REVERSAL_BY")
	private String reversalBy;
	
	@Column(name = "REVERSAL_DATETIME")
	private Date reversalDateTime;
	
	@Column(name = "REVERSAL_REASON")
	private String reversalReason;
	
	@Column(name = "AIRLINE_MEMBER_NO")
	private String airlineMemberNo;
	
	@Column(name = "CDCH_CARD_NO")
	private String cdchCardNo;
	
	@Column(name = "STATUS_ID")
	private Integer statusId;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "CREATED_DATETIME")
	private Date createdDateTime;

	@Column(name = "EDITED_BY")
	private String editedBy;

	@Column(name = "EDITED_DATETIME")
	private Date editedDateTime;
	
	@OneToMany(targetEntity=ApPointTxnBucketDetails.class, mappedBy="pointTxnId",cascade=CascadeType.ALL, fetch = FetchType.LAZY)    
	private List<ApPointTxnBucketDetails> pointTxnBucketDetails;
	
	@OneToMany(targetEntity=ApPointTxnDetails.class, mappedBy="pointTxnId",cascade=CascadeType.ALL, fetch = FetchType.LAZY)    
	private List<ApPointTxnBucketDetails> pointTxnDetails;

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
	 * @return the cardHolderId
	 */
	public Long getCardHolderId() {
		return cardHolderId;
	}

	/**
	 * @param cardHolderId the cardHolderId to set
	 */
	public void setCardHolderId(Long cardHolderId) {
		this.cardHolderId = cardHolderId;
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
	 * @return the refOrderId
	 */
	public String getRefOrderId() {
		return refOrderId;
	}

	/**
	 * @param refOrderId the refOrderId to set
	 */
	public void setRefOrderId(String refOrderId) {
		this.refOrderId = refOrderId;
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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the totalPointRedeemed
	 */
	public Double getTotalPointRedeemed() {
		return totalPointRedeemed;
	}

	/**
	 * @param totalPointRedeemed the totalPointRedeemed to set
	 */
	public void setTotalPointRedeemed(Double totalPointRedeemed) {
		this.totalPointRedeemed = totalPointRedeemed;
	}

	/**
	 * @return the totalAmountPurchased
	 */
	public BigDecimal getTotalAmountPurchased() {
		return totalAmountPurchased;
	}

	/**
	 * @param totalAmountPurchased the totalAmountPurchased to set
	 */
	public void setTotalAmountPurchased(BigDecimal totalAmountPurchased) {
		this.totalAmountPurchased = totalAmountPurchased;
	}

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
	 * @return the txnType
	 */
	public String getTxnType() {
		return txnType;
	}

	/**
	 * @param txnType the txnType to set
	 */
	public void setTxnType(String txnType) {
		this.txnType = txnType;
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
	 * @return the reversalBy
	 */
	public String getReversalBy() {
		return reversalBy;
	}

	/**
	 * @param reversalBy the reversalBy to set
	 */
	public void setReversalBy(String reversalBy) {
		this.reversalBy = reversalBy;
	}

	/**
	 * @return the reversalDateTime
	 */
	public Date getReversalDateTime() {
		return reversalDateTime;
	}

	/**
	 * @param reversalDateTime the reversalDateTime to set
	 */
	public void setReversalDateTime(Date reversalDateTime) {
		this.reversalDateTime = reversalDateTime;
	}

	/**
	 * @return the reversalReason
	 */
	public String getReversalReason() {
		return reversalReason;
	}

	/**
	 * @param reversalReason the reversalReason to set
	 */
	public void setReversalReason(String reversalReason) {
		this.reversalReason = reversalReason;
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
	 * @return the statusId
	 */
	public Integer getStatusId() {
		return statusId;
	}

	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdDateTime
	 */
	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	/**
	 * @param createdDateTime the createdDateTime to set
	 */
	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	/**
	 * @return the editedBy
	 */
	public String getEditedBy() {
		return editedBy;
	}

	/**
	 * @param editedBy the editedBy to set
	 */
	public void setEditedBy(String editedBy) {
		this.editedBy = editedBy;
	}

	/**
	 * @return the editedDateTime
	 */
	public Date getEditedDateTime() {
		return editedDateTime;
	}

	/**
	 * @param editedDateTime the editedDateTime to set
	 */
	public void setEditedDateTime(Date editedDateTime) {
		this.editedDateTime = editedDateTime;
	}

	/**
	 * @return the productPrograms
	 */
	public List<ApPointTxnBucketDetails> getPointTxnBucketDetails() {
		return pointTxnBucketDetails;
	}

	/**
	 * @param productPrograms the productPrograms to set
	 */
	public void setPointTxnBucketDetails(List<ApPointTxnBucketDetails> pointTxnBucketDetails) {
		this.pointTxnBucketDetails = pointTxnBucketDetails;
	}

	/**
	 * @return the pointTxnDetails
	 */
	public List<ApPointTxnBucketDetails> getPointTxnDetails() {
		return pointTxnDetails;
	}

	/**
	 * @param pointTxnDetails the pointTxnDetails to set
	 */
	public void setPointTxnDetails(List<ApPointTxnBucketDetails> pointTxnDetails) {
		this.pointTxnDetails = pointTxnDetails;
	}
	
}
