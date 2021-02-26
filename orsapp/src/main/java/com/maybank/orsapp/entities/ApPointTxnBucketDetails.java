/**
 * 
 */
package com.maybank.orsapp.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author 80003905
 *
 */

@Entity
@Table(name = "ap_POINT_TXN_BUCKET_DETAIL")
public class ApPointTxnBucketDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9107902918528648548L;

	@Id
	@Column(name = "POINT_TXN_BUCKET_DETAIL_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pointTxnBucketDetailId;

	@ManyToOne
	@JoinColumn(name = "POINT_TXN_ID", referencedColumnName = "POINT_TXN_ID")
	private ApPointTxn pointTxnId;

	@Column(name = "CARDHOLDER_POINT_BUCKET_ID")
	private Long cardHolderPointBucketId;

	@Column(name = "ORDER_NO")
	private String orderNo;

	@Column(name = "ORG_NO")
	private String orgNo;

	@Column(name = "CARD_NO")
	private String cardNo;

	@Column(name = "CARD_TYPE")
	private String cardType;

	@Column(name = "TXN_CODE")
	private String txnCode;

	@Column(name = "TXN_TYPE")
	private String txnType;

	@Column(name = "TXN_DESC")
	private String txnDescription;

	@Column(name = "PROGRAM_CODE")
	private String programCode;
	
	@Column(name = "TOTAL_POINT_REDEEMED")
	public BigDecimal totalPointRedeemed;

	@Column(name = "TOTAL_AMOUNT_PURCHASED")
	public BigDecimal totalAmountPurchased;

	@Column(name = "TOTAL_PREV_POINT_SIGN")
	public String totalPrevPointSign;

	@Column(name = "TOTAL_PREV_POINT_BAL")
	public BigDecimal totalPrevPointBal;

	@Column(name = "TOTAL_POINT_SIGN")
	public String totalPointSign;

	@Column(name = "TOTAL_POINT_BAL")
	public BigDecimal totalPointBal;

	@Column(name = "MR_PARTNER_TYPE")
	public String merchantPartnerType;

	@Column(name = "MR_PARTNER_CODE")
	public String merchantPartnerCode;

	@Column(name = "MR_PARTNER_MEMBER_NO")
	public String merchantPartnerMemberNo;

	@Column(name = "MR_PARTNER_POINT")
	public String merchantPartnerPoint;

	@Column(name = "MR_COST_PER_UNIT")
	public BigDecimal merchantCostPerUnit;

	@Column(name = "BUCKET01_POINT_PREV_SIGN")
	public String bucket01PointPrevSign;

	@Column(name = "BUCKET01_POINT_PREV_BAL")
	public BigDecimal bucket01PointPrevBal;

	@Column(name = "BUCKET01_POINT_REDEEMED")
	public BigDecimal bucket01PointRedeemed;

	@Column(name = "BUCKET01_POINT_SIGN")
	public String bucket01PointNewSign;

	@Column(name = "BUCKET01_POINT_BAL")
	public BigDecimal bucket01PointNewBal;

	@Column(name = "BUCKET02_POINT_PREV_SIGN")
	public String bucket02PointPrevSign;

	@Column(name = "BUCKET02_POINT_PREV_BAL")
	public BigDecimal bucket02PointPrevBal;

	@Column(name = "BUCKET02_POINT_REDEEMED")
	public BigDecimal bucket02PointRedeemed;

	@Column(name = "BUCKET02_POINT_SIGN")
	public String bucket02PointSign;

	@Column(name = "BUCKET02_POINT_BAL")
	public BigDecimal bucket02PointBal;

	@Column(name = "BUCKET03_POINT_PREV_SIGN")
	public String bucket03PointPrevSign;

	@Column(name = "BUCKET03_POINT_PREV_BAL")
	public BigDecimal bucket03PointPrevBal;

	@Column(name = "BUCKET03_POINT_REDEEMED")
	public BigDecimal bucket03PointRedeemed;

	@Column(name = "BUCKET03_POINT_SIGN")
	public String bucket03PointSign;

	@Column(name = "BUCKET03_POINT_BAL")
	public BigDecimal bucket03PointBal;

	@Column(name = "BUCKET04_POINT_PREV_SIGN")
	public String bucket04PointPrevSign;

	@Column(name = "BUCKET04_POINT_PREV_BAL")
	public BigDecimal bucket04PointPrevBal;

	@Column(name = "BUCKET04_POINT_REDEEMED")
	public BigDecimal bucket04PointRedeemed;

	@Column(name = "BUCKET04_POINT_SIGN")
	public String bucket04PointSign;

	@Column(name = "BUCKET04_POINT_BAL")
	public BigDecimal bucket04PointBal;

	@Column(name = "BUCKET05_POINT_PREV_SIGN")
	public String bucket05PointPrevSign;

	@Column(name = "BUCKET05_POINT_PREV_BAL")
	public BigDecimal bucket05PointPrevBal;

	@Column(name = "BUCKET05_POINT_REDEEMED")
	public BigDecimal bucket05PointRedeemed;

	@Column(name = "BUCKET05_POINT_SIGN")
	public String bucket05PointSign;

	@Column(name = "BUCKET05_POINT_BAL")
	public BigDecimal bucket05PointBal;

	@Column(name = "BUCKET06_POINT_PREV_SIGN")
	public String bucket06PointPrevSign;

	@Column(name = "BUCKET06_POINT_PREV_BAL")
	public BigDecimal bucket06PointPrevBal;

	@Column(name = "BUCKET06_POINT_REDEEMED")
	public BigDecimal bucket06PointRedeemed;

	@Column(name = "BUCKET06_POINT_SIGN")
	public String bucket06PointSign;

	@Column(name = "BUCKET06_POINT_BAL")
	public BigDecimal bucket06PointBal;

	@Column(name = "BUCKET07_POINT_PREV_SIGN")
	public String bucket07PointPrevSign;

	@Column(name = "BUCKET07_POINT_PREV_BAL")
	public BigDecimal bucket07PointPrevBal;

	@Column(name = "BUCKET07_POINT_REDEEMED")
	public BigDecimal bucket07PointRedeemed;

	@Column(name = "BUCKET07_POINT_SIGN")
	public String bucket07PointSign;

	@Column(name = "BUCKET07_POINT_BAL")
	public BigDecimal bucket07PointBal;

	@Column(name = "BUCKET08_POINT_PREV_SIGN")
	public String bucket08PointPrevSign;

	@Column(name = "BUCKET08_POINT_PREV_BAL")
	public BigDecimal bucket08PointPrevBal;

	@Column(name = "BUCKET08_POINT_REDEEMED")
	public BigDecimal bucket08PointRedeemed;

	@Column(name = "BUCKET08_POINT_SIGN")
	public String bucket08PointSign;

	@Column(name = "BUCKET08_POINT_BAL")
	public BigDecimal bucket08PointBal;

	@Column(name = "BUCKET09_POINT_PREV_SIGN")
	public String bucket09PointPrevSign;

	@Column(name = "BUCKET09_POINT_PREV_BAL")
	public BigDecimal bucket09PointPrevBal;

	@Column(name = "BUCKET09_POINT_REDEEMED")
	public BigDecimal bucket09PointRedeemed;

	@Column(name = "BUCKET09_POINT_SIGN")
	public String bucket09PointSign;

	@Column(name = "BUCKET09_POINT_BAL")
	public BigDecimal bucket09PointBal;

	@Column(name = "BUCKET10_POINT_PREV_SIGN")
	public String bucket10PointPrevSign;

	@Column(name = "BUCKET10_POINT_PREV_BAL")
	public BigDecimal bucket10PointPrevBal;

	@Column(name = "BUCKET10_POINT_REDEEMED")
	public BigDecimal bucket10PointRedeemed;

	@Column(name = "BUCKET10_POINT_SIGN")
	public String bucket10PointSign;

	@Column(name = "BUCKET10_POINT_BAL")
	public BigDecimal bucket10PointBal;

	@Column(name = "BUCKET11_POINT_PREV_SIGN")
	public String bucket11PointPrevSign;

	@Column(name = "BUCKET11_POINT_PREV_BAL")
	public BigDecimal bucket11PointPrevBal;

	@Column(name = "BUCKET11_POINT_REDEEMED")
	public BigDecimal bucket11PointRedeemed;

	@Column(name = "BUCKET11_POINT_SIGN")
	public String bucket11PointSign;

	@Column(name = "BUCKET11_POINT_BAL")
	public BigDecimal bucket11PointBal;

	@Column(name = "BUCKET12_POINT_PREV_SIGN")
	public String bucket12PointPrevSign;

	@Column(name = "BUCKET12_POINT_PREV_BAL")
	public BigDecimal bucket12PointPrevBal;

	@Column(name = "BUCKET12_POINT_REDEEMED")
	public BigDecimal bucket12PointRedeemed;

	@Column(name = "BUCKET12_POINT_SIGN")
	public String bucket12PointSign;

	@Column(name = "BUCKET12_POINT_BAL")
	public BigDecimal bucket12PointBal;

	@Column(name = "BUCKET13_POINT_PREV_SIGN")
	public String bucket13PointPrevSign;

	@Column(name = "BUCKET13_POINT_PREV_BAL")
	public BigDecimal bucket13PointPrevBal;

	@Column(name = "BUCKET13_POINT_REDEEMED")
	public BigDecimal bucket13PointRedeemed;

	@Column(name = "BUCKET13_POINT_SIGN")
	public String bucket13PointSign;

	@Column(name = "BUCKET13_POINT_BAL")
	public BigDecimal bucket13PointBal;

	@Column(name = "BUCKET14_POINT_PREV_SIGN")
	public String bucket14PointPrevSign;

	@Column(name = "BUCKET14_POINT_PREV_BAL")
	public BigDecimal bucket14PointPrevBal;

	@Column(name = "BUCKET14_POINT_REDEEMED")
	public BigDecimal bucket14PointRedeemed;

	@Column(name = "BUCKET14_POINT_SIGN")
	public String bucket14PointSign;

	@Column(name = "BUCKET14_POINT_BAL")  
	public BigDecimal bucket14PointBal;

	@Column(name = "BUCKET15_POINT_PREV_SIGN")  
	public String bucket15PointPrevSign;

	@Column(name = "BUCKET15_POINT_PREV_BAL")  
	public BigDecimal bucket15PointPrevBal;

	@Column(name = "BUCKET15_POINT_REDEEMED")  
	public BigDecimal bucket15PointRedeemed;

	@Column(name = "BUCKET15_POINT_SIGN")  
	public String bucket15PointSign;

	@Column(name = "BUCKET15_POINT_BAL")  
	public BigDecimal bucket15PointBal;

	@Column(name = "BUCKET16_POINT_PREV_SIGN")  
	public String bucket16PointPrevSign;

	@Column(name = "BUCKET16_POINT_PREV_BAL")  
	public BigDecimal bucket16PointPrevBal;

	@Column(name = "BUCKET16_POINT_REDEEMED")  
	public BigDecimal bucket16PointRedeemed;

	@Column(name = "BUCKET16_POINT_SIGN")  
	public String bucket16PointSign;

	@Column(name = "BUCKET16_POINT_BAL")  
	public BigDecimal bucket16PointBal;

	@Column(name = "BUCKET17_POINT_PREV_SIGN")  
	public String bucket17PointPrevSign;

	@Column(name = "BUCKET17_POINT_PREV_BAL")  
	public BigDecimal bucket17PointPrevBal;

	@Column(name = "BUCKET17_POINT_REDEEMED")  
	public BigDecimal bucket17PointRedeemed;

	@Column(name = "BUCKET17_POINT_SIGN")  
	public String bucket17PointSign;

	@Column(name = "BUCKET17_POINT_BAL")  
	public BigDecimal bucket17PointBal;

	@Column(name = "BUCKET18_POINT_PREV_SIGN")  
	public String bucket18PointPrevSign;

	@Column(name = "BUCKET18_POINT_PREV_BAL")  
	public BigDecimal bucket18PointPrevBal;

	@Column(name = "BUCKET18_POINT_REDEEMED")  
	public BigDecimal bucket18PointRedeemed;

	@Column(name = "BUCKET18_POINT_SIGN")  
	public String bucket18PointSign;

	@Column(name = "BUCKET18_POINT_BAL")  
	public BigDecimal bucket18PointBal;

	@Column(name = "BUCKET19_POINT_PREV_SIGN")  
	public String bucket19PointPrevSign;

	@Column(name = "BUCKET19_POINT_PREV_BAL")  
	public BigDecimal bucket19PointPrevBal;

	@Column(name = "BUCKET19_POINT_REDEEMED")  
	public BigDecimal bucket19PointRedeemed;

	@Column(name = "BUCKET19_POINT_SIGN")  
	public String bucket19PointSign;

	@Column(name = "BUCKET19_POINT_BAL")  
	public BigDecimal bucket19PointBal;

	@Column(name = "BUCKET20_POINT_PREV_SIGN")  
	public String bucket20PointPrevSign;

	@Column(name = "BUCKET20_POINT_PREV_BAL")  
	public BigDecimal bucket20PointPrevBal;

	@Column(name = "BUCKET20_POINT_REDEEMED")  
	public BigDecimal bucket20PointRedeemed;

	@Column(name = "BUCKET20_POINT_SIGN")  
	public String bucket20PointSign;

	@Column(name = "BUCKET20_POINT_BAL")  
	public BigDecimal bucket20PointBal;

	@Column(name = "BUCKET21_POINT_PREV_SIGN")  
	public String bucket21PointPrevSign;

	@Column(name = "BUCKET21_POINT_PREV_BAL")  
	public BigDecimal bucket21PointPrevBal;

	@Column(name = "BUCKET21_POINT_REDEEMED")  
	public BigDecimal bucket21PointRedeemed;

	@Column(name = "BUCKET21_POINT_SIGN")  
	public String bucket21PointSign;

	@Column(name = "BUCKET21_POINT_BAL")  
	public BigDecimal bucket21PointBal;

	@Column(name = "BUCKET22_POINT_PREV_SIGN")  
	public String bucket22PointPrevSign;

	@Column(name = "BUCKET22_POINT_PREV_BAL")  
	public BigDecimal bucket22PointPrevBal;

	@Column(name = "BUCKET22_POINT_REDEEMED")  
	public BigDecimal bucket22PointRedeemed;

	@Column(name = "BUCKET22_POINT_SIGN")  
	public String bucket22PointSign;

	@Column(name = "BUCKET22_POINT_BAL")  
	public BigDecimal bucket22PointBal;

	@Column(name = "BUCKET23_POINT_PREV_SIGN")  
	public String bucket23PointPrevSign;

	@Column(name = "BUCKET23_POINT_PREV_BAL")  
	public BigDecimal bucket23PointPrevBal;

	@Column(name = "BUCKET23_POINT_REDEEMED")  
	public BigDecimal bucket23PointRedeemed;

	@Column(name = "BUCKET23_POINT_SIGN")  
	public String bucket23PointSign;

	@Column(name = "BUCKET23_POINT_BAL")  
	public BigDecimal bucket23PointBal;

	@Column(name = "BUCKET24_POINT_PREV_SIGN")  
	public String bucket24PointPrevSign;

	@Column(name = "BUCKET24_POINT_PREV_BAL")  
	public BigDecimal bucket24PointPrevBal;

	@Column(name = "BUCKET24_POINT_REDEEMED")  
	public BigDecimal bucket24PointRedeemed;

	@Column(name = "BUCKET24_POINT_SIGN")  
	public String bucket24PointSign;

	@Column(name = "BUCKET24_POINT_BAL")  
	public BigDecimal bucket24PointBal;

	@Column(name = "BUCKET25_POINT_PREV_SIGN")  
	public String bucket25PointPrevSign;

	@Column(name = "BUCKET25_POINT_PREV_BAL")  
	public BigDecimal bucket25PointPrevBal;

	@Column(name = "BUCKET25_POINT_REDEEMED")  
	public BigDecimal bucket25PointRedeemed;

	@Column(name = "BUCKET25_POINT_SIGN")  
	public String bucket25PointSign;

	@Column(name = "BUCKET25_POINT_BAL")  
	public BigDecimal bucket25PointBal;

	@Column(name = "BUCKET26_POINT_PREV_SIGN")  
	public String bucket26PointPrevSign;

	@Column(name = "BUCKET26_POINT_PREV_BAL")  
	public BigDecimal bucket26PointPrevBal;

	@Column(name = "BUCKET26_POINT_REDEEMED")  
	public BigDecimal bucket26PointRedeemed;

	@Column(name = "BUCKET26_POINT_SIGN")  
	public String bucket26PointSign;

	@Column(name = "BUCKET26_POINT_BAL")  
	public BigDecimal bucket26PointBal;

	@Column(name = "BUCKET27_POINT_PREV_SIGN")  
	public String bucket27PointPrevSign;

	@Column(name = "BUCKET27_POINT_PREV_BAL")  
	public BigDecimal bucket27PointPrevBal;

	@Column(name = "BUCKET27_POINT_REDEEMED")  
	public BigDecimal bucket27PointRedeemed;

	@Column(name = "BUCKET27_POINT_SIGN")  
	public String bucket27PointSign;

	@Column(name = "BUCKET27_POINT_BAL")  
	public BigDecimal bucket27PointBal;

	@Column(name = "BUCKET28_POINT_PREV_SIGN")  
	public String bucket28PointPrevSign;

	@Column(name = "BUCKET28_POINT_PREV_BAL")  
	public BigDecimal bucket28PointPrevBal;

	@Column(name = "BUCKET28_POINT_REDEEMED")  
	public BigDecimal bucket28PointRedeemed;

	@Column(name = "BUCKET28_POINT_SIGN")  
	public String bucket28PointSign;

	@Column(name = "BUCKET28_POINT_BAL")  
	public BigDecimal bucket28PointBal;

	@Column(name = "BUCKET29_POINT_PREV_SIGN")  
	public String bucket29PointPrevSign;

	@Column(name = "BUCKET29_POINT_PREV_BAL")  
	public BigDecimal bucket29PointPrevBal;

	@Column(name = "BUCKET29_POINT_REDEEMED")  
	public BigDecimal bucket29PointRedeemed;

	@Column(name = "BUCKET29_POINT_SIGN")  
	public String bucket29PointSign;

	@Column(name = "BUCKET29_POINT_BAL")  
	public BigDecimal bucket29PointBal;

	@Column(name = "BUCKET30_POINT_PREV_SIGN")  
	public String bucket30PointPrevSign;

	@Column(name = "BUCKET30_POINT_PREV_BAL")  
	public BigDecimal bucket30PointPrevBal;

	@Column(name = "BUCKET30_POINT_REDEEMED")  
	public BigDecimal bucket30PointRedeemed;

	@Column(name = "BUCKET30_POINT_SIGN")  
	public String bucket30PointSign;

	@Column(name = "BUCKET30_POINT_BAL")  
	public BigDecimal bucket30PointBal;

	@Column(name = "BUCKET31_POINT_PREV_SIGN")  
	public String bucket31PointPrevSign;

	@Column(name = "BUCKET31_POINT_PREV_BAL")  
	public BigDecimal bucket31PointPrevBal;

	@Column(name = "BUCKET31_POINT_REDEEMED")  
	public BigDecimal bucket31PointRedeemed;

	@Column(name = "BUCKET31_POINT_SIGN")  
	public String bucket31PointSign;

	@Column(name = "BUCKET31_POINT_BAL")  
	public BigDecimal bucket31PointBal;

	@Column(name = "BUCKET32_POINT_PREV_SIGN")  
	public String bucket32PointPrevSign;

	@Column(name = "BUCKET32_POINT_PREV_BAL")  
	public BigDecimal bucket32PointPrevBal;

	@Column(name = "BUCKET32_POINT_REDEEMED")  
	public BigDecimal bucket32PointRedeemed;

	@Column(name = "BUCKET32_POINT_SIGN")  
	public String bucket32PointSign;

	@Column(name = "BUCKET32_POINT_BAL")  
	public BigDecimal bucket32PointBal;

	@Column(name = "BUCKET33_POINT_PREV_SIGN")  
	public String bucket33PointPrevSign;

	@Column(name = "BUCKET33_POINT_PREV_BAL")  
	public BigDecimal bucket33PointPrevBal;

	@Column(name = "BUCKET33_POINT_REDEEMED")  
	public BigDecimal bucket33PointRedeemed;

	@Column(name = "BUCKET33_POINT_SIGN")  
	public String bucket33PointSign;

	@Column(name = "BUCKET33_POINT_BAL")  
	public BigDecimal bucket33PointBal;

	@Column(name = "BUCKET34_POINT_PREV_SIGN")  
	public String bucket34PointPrevSign;

	@Column(name = "BUCKET34_POINT_PREV_BAL")  
	public BigDecimal bucket34PointPrevBal;

	@Column(name = "BUCKET34_POINT_REDEEMED")  
	public BigDecimal bucket34PointRedeemed;

	@Column(name = "BUCKET34_POINT_SIGN")  
	public String bucket34PointSign;

	@Column(name = "BUCKET34_POINT_BAL")  
	public BigDecimal bucket34PointBal;

	@Column(name = "BUCKET35_POINT_PREV_SIGN")  
	public String bucket35PointPrevSign;

	@Column(name = "BUCKET35_POINT_PREV_BAL")  
	public BigDecimal bucket35PointPrevBal;

	@Column(name = "BUCKET35_POINT_REDEEMED")  
	public BigDecimal bucket35PointRedeemed;

	@Column(name = "BUCKET35_POINT_SIGN")  
	public String bucket35PointSign;

	@Column(name = "BUCKET35_POINT_BAL")  
	public BigDecimal bucket35PointBal;

	@Column(name = "BUCKET36_POINT_PREV_SIGN")  
	public String bucket36PointPrevSign;

	@Column(name = "BUCKET36_POINT_PREV_BAL")  
	public BigDecimal bucket36PointPrevBal;

	@Column(name = "BUCKET36_POINT_REDEEMED")  
	public BigDecimal bucket36PointRedeemed;

	@Column(name = "BUCKET36_POINT_SIGN")  
	public String bucket36PointSign;

	@Column(name = "BUCKET36_POINT_BAL")  
	public BigDecimal bucket36PointBal;

	@Column(name = "LAST_EXPIRED_POINT_SIGN")  
	public String lastExpiredPointSign;

	@Column(name = "LAST_EXPIRED_POINT_BAL")  
	public BigDecimal lastExpiredPointBal;
	
	@Column(name="STATUS_ID")
	private Integer statusId;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "CREATED_DATETIME")
	private Timestamp createdDatetime;
	
	@Column(name="EDITED_BY")
	private String editedBy;

	@Column(name="EDITED_DATETIME")
	private Timestamp editedDatetime;

	/**
	 * @return the pointTxnBucketDetailId
	 */
	public Long getPointTxnBucketDetailId() {
		return pointTxnBucketDetailId;
	}

	/**
	 * @param pointTxnBucketDetailId the pointTxnBucketDetailId to set
	 */
	public void setPointTxnBucketDetailId(Long pointTxnBucketDetailId) {
		this.pointTxnBucketDetailId = pointTxnBucketDetailId;
	}

	/**
	 * @return the pointTxnId
	 */
	public ApPointTxn getPointTxnId() {
		return pointTxnId;
	}

	/**
	 * @param pointTxnId the pointTxnId to set
	 */
	public void setPointTxnId(ApPointTxn pointTxnId) {
		this.pointTxnId = pointTxnId;
	}

	/**
	 * @return the cardHolderPointBucketId
	 */
	public Long getCardHolderPointBucketId() {
		return cardHolderPointBucketId;
	}

	/**
	 * @param cardHolderPointBucketId the cardHolderPointBucketId to set
	 */
	public void setCardHolderPointBucketId(Long cardHolderPointBucketId) {
		this.cardHolderPointBucketId = cardHolderPointBucketId;
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
	 * @return the orgNo
	 */
	public String getOrgNo() {
		return orgNo;
	}

	/**
	 * @param orgNo the orgNo to set
	 */
	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}

	/**
	 * @return the cardNo
	 */
	public String getCardNo() {
		return cardNo;
	}

	/**
	 * @param cardNo the cardNo to set
	 */
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	/**
	 * @return the cardType
	 */
	public String getCardType() {
		return cardType;
	}

	/**
	 * @param cardType the cardType to set
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	/**
	 * @return the txnCode
	 */
	public String getTxnCode() {
		return txnCode;
	}

	/**
	 * @param txnCode the txnCode to set
	 */
	public void setTxnCode(String txnCode) {
		this.txnCode = txnCode;
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
	 * @return the txnDescription
	 */
	public String getTxnDescription() {
		return txnDescription;
	}

	/**
	 * @param txnDescription the txnDescription to set
	 */
	public void setTxnDescription(String txnDescription) {
		this.txnDescription = txnDescription;
	}

	/**
	 * @return the programCode
	 */
	public String getProgramCode() {
		return programCode;
	}

	/**
	 * @param programCode the programCode to set
	 */
	public void setProgramCode(String programCode) {
		this.programCode = programCode;
	}

	/**
	 * @return the totalPointRedeemed
	 */
	public BigDecimal getTotalPointRedeemed() {
		return totalPointRedeemed;
	}

	/**
	 * @param totalPointRedeemed the totalPointRedeemed to set
	 */
	public void setTotalPointRedeemed(BigDecimal totalPointRedeemed) {
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
	 * @return the totalPrevPointSign
	 */
	public String getTotalPrevPointSign() {
		return totalPrevPointSign;
	}

	/**
	 * @param totalPrevPointSign the totalPrevPointSign to set
	 */
	public void setTotalPrevPointSign(String totalPrevPointSign) {
		this.totalPrevPointSign = totalPrevPointSign;
	}

	/**
	 * @return the totalPrevPointBal
	 */
	public BigDecimal getTotalPrevPointBal() {
		return totalPrevPointBal;
	}

	/**
	 * @param totalPrevPointBal the totalPrevPointBal to set
	 */
	public void setTotalPrevPointBal(BigDecimal totalPrevPointBal) {
		this.totalPrevPointBal = totalPrevPointBal;
	}

	/**
	 * @return the totalPointSign
	 */
	public String getTotalPointSign() {
		return totalPointSign;
	}

	/**
	 * @param totalPointSign the totalPointSign to set
	 */
	public void setTotalPointSign(String totalPointSign) {
		this.totalPointSign = totalPointSign;
	}

	/**
	 * @return the totalPointBal
	 */
	public BigDecimal getTotalPointBal() {
		return totalPointBal;
	}

	/**
	 * @param totalPointBal the totalPointBal to set
	 */
	public void setTotalPointBal(BigDecimal totalPointBal) {
		this.totalPointBal = totalPointBal;
	}

	/**
	 * @return the merchantPartnerType
	 */
	public String getMerchantPartnerType() {
		return merchantPartnerType;
	}

	/**
	 * @param merchantPartnerType the merchantPartnerType to set
	 */
	public void setMerchantPartnerType(String merchantPartnerType) {
		this.merchantPartnerType = merchantPartnerType;
	}

	/**
	 * @return the merchantPartnerCode
	 */
	public String getMerchantPartnerCode() {
		return merchantPartnerCode;
	}

	/**
	 * @param merchantPartnerCode the merchantPartnerCode to set
	 */
	public void setMerchantPartnerCode(String merchantPartnerCode) {
		this.merchantPartnerCode = merchantPartnerCode;
	}

	/**
	 * @return the merchantPartnerMemberNo
	 */
	public String getMerchantPartnerMemberNo() {
		return merchantPartnerMemberNo;
	}

	/**
	 * @param merchantPartnerMemberNo the merchantPartnerMemberNo to set
	 */
	public void setMerchantPartnerMemberNo(String merchantPartnerMemberNo) {
		this.merchantPartnerMemberNo = merchantPartnerMemberNo;
	}

	/**
	 * @return the merchantPartnerPoint
	 */
	public String getMerchantPartnerPoint() {
		return merchantPartnerPoint;
	}

	/**
	 * @param merchantPartnerPoint the merchantPartnerPoint to set
	 */
	public void setMerchantPartnerPoint(String merchantPartnerPoint) {
		this.merchantPartnerPoint = merchantPartnerPoint;
	}

	/**
	 * @return the merchantCostPerUnit
	 */
	public BigDecimal getMerchantCostPerUnit() {
		return merchantCostPerUnit;
	}

	/**
	 * @param merchantCostPerUnit the merchantCostPerUnit to set
	 */
	public void setMerchantCostPerUnit(BigDecimal merchantCostPerUnit) {
		this.merchantCostPerUnit = merchantCostPerUnit;
	}

	/**
	 * @return the bucket01PointPrevSign
	 */
	public String getBucket01PointPrevSign() {
		return bucket01PointPrevSign;
	}

	/**
	 * @param bucket01PointPrevSign the bucket01PointPrevSign to set
	 */
	public void setBucket01PointPrevSign(String bucket01PointPrevSign) {
		this.bucket01PointPrevSign = bucket01PointPrevSign;
	}

	/**
	 * @return the bucket01PointPrevBal
	 */
	public BigDecimal getBucket01PointPrevBal() {
		return bucket01PointPrevBal;
	}

	/**
	 * @param bucket01PointPrevBal the bucket01PointPrevBal to set
	 */
	public void setBucket01PointPrevBal(BigDecimal bucket01PointPrevBal) {
		this.bucket01PointPrevBal = bucket01PointPrevBal;
	}

	/**
	 * @return the bucket01PointRedeemed
	 */
	public BigDecimal getBucket01PointRedeemed() {
		return bucket01PointRedeemed;
	}

	/**
	 * @param bucket01PointRedeemed the bucket01PointRedeemed to set
	 */
	public void setBucket01PointRedeemed(BigDecimal bucket01PointRedeemed) {
		this.bucket01PointRedeemed = bucket01PointRedeemed;
	}

	/**
	 * @return the bucket01PointNewSign
	 */
	public String getBucket01PointNewSign() {
		return bucket01PointNewSign;
	}

	/**
	 * @param bucket01PointNewSign the bucket01PointNewSign to set
	 */
	public void setBucket01PointNewSign(String bucket01PointNewSign) {
		this.bucket01PointNewSign = bucket01PointNewSign;
	}

	/**
	 * @return the bucket01PointNewBal
	 */
	public BigDecimal getBucket01PointNewBal() {
		return bucket01PointNewBal;
	}

	/**
	 * @param bucket01PointNewBal the bucket01PointNewBal to set
	 */
	public void setBucket01PointNewBal(BigDecimal bucket01PointNewBal) {
		this.bucket01PointNewBal = bucket01PointNewBal;
	}

	/**
	 * @return the bucket02PointPrevSign
	 */
	public String getBucket02PointPrevSign() {
		return bucket02PointPrevSign;
	}

	/**
	 * @param bucket02PointPrevSign the bucket02PointPrevSign to set
	 */
	public void setBucket02PointPrevSign(String bucket02PointPrevSign) {
		this.bucket02PointPrevSign = bucket02PointPrevSign;
	}

	/**
	 * @return the bucket02PointPrevBal
	 */
	public BigDecimal getBucket02PointPrevBal() {
		return bucket02PointPrevBal;
	}

	/**
	 * @param bucket02PointPrevBal the bucket02PointPrevBal to set
	 */
	public void setBucket02PointPrevBal(BigDecimal bucket02PointPrevBal) {
		this.bucket02PointPrevBal = bucket02PointPrevBal;
	}

	/**
	 * @return the bucket02PointRedeemed
	 */
	public BigDecimal getBucket02PointRedeemed() {
		return bucket02PointRedeemed;
	}

	/**
	 * @param bucket02PointRedeemed the bucket02PointRedeemed to set
	 */
	public void setBucket02PointRedeemed(BigDecimal bucket02PointRedeemed) {
		this.bucket02PointRedeemed = bucket02PointRedeemed;
	}

	/**
	 * @return the bucket02PointSign
	 */
	public String getBucket02PointSign() {
		return bucket02PointSign;
	}

	/**
	 * @param bucket02PointSign the bucket02PointSign to set
	 */
	public void setBucket02PointSign(String bucket02PointSign) {
		this.bucket02PointSign = bucket02PointSign;
	}

	/**
	 * @return the bucket02PointBal
	 */
	public BigDecimal getBucket02PointBal() {
		return bucket02PointBal;
	}

	/**
	 * @param bucket02PointBal the bucket02PointBal to set
	 */
	public void setBucket02PointBal(BigDecimal bucket02PointBal) {
		this.bucket02PointBal = bucket02PointBal;
	}

	/**
	 * @return the bucket03PointPrevSign
	 */
	public String getBucket03PointPrevSign() {
		return bucket03PointPrevSign;
	}

	/**
	 * @param bucket03PointPrevSign the bucket03PointPrevSign to set
	 */
	public void setBucket03PointPrevSign(String bucket03PointPrevSign) {
		this.bucket03PointPrevSign = bucket03PointPrevSign;
	}

	/**
	 * @return the bucket03PointPrevBal
	 */
	public BigDecimal getBucket03PointPrevBal() {
		return bucket03PointPrevBal;
	}

	/**
	 * @param bucket03PointPrevBal the bucket03PointPrevBal to set
	 */
	public void setBucket03PointPrevBal(BigDecimal bucket03PointPrevBal) {
		this.bucket03PointPrevBal = bucket03PointPrevBal;
	}

	/**
	 * @return the bucket03PointRedeemed
	 */
	public BigDecimal getBucket03PointRedeemed() {
		return bucket03PointRedeemed;
	}

	/**
	 * @param bucket03PointRedeemed the bucket03PointRedeemed to set
	 */
	public void setBucket03PointRedeemed(BigDecimal bucket03PointRedeemed) {
		this.bucket03PointRedeemed = bucket03PointRedeemed;
	}

	/**
	 * @return the bucket03PointSign
	 */
	public String getBucket03PointSign() {
		return bucket03PointSign;
	}

	/**
	 * @param bucket03PointSign the bucket03PointSign to set
	 */
	public void setBucket03PointSign(String bucket03PointSign) {
		this.bucket03PointSign = bucket03PointSign;
	}

	/**
	 * @return the bucket03PointBal
	 */
	public BigDecimal getBucket03PointBal() {
		return bucket03PointBal;
	}

	/**
	 * @param bucket03PointBal the bucket03PointBal to set
	 */
	public void setBucket03PointBal(BigDecimal bucket03PointBal) {
		this.bucket03PointBal = bucket03PointBal;
	}

	/**
	 * @return the bucket04PointPrevSign
	 */
	public String getBucket04PointPrevSign() {
		return bucket04PointPrevSign;
	}

	/**
	 * @param bucket04PointPrevSign the bucket04PointPrevSign to set
	 */
	public void setBucket04PointPrevSign(String bucket04PointPrevSign) {
		this.bucket04PointPrevSign = bucket04PointPrevSign;
	}

	/**
	 * @return the bucket04PointPrevBal
	 */
	public BigDecimal getBucket04PointPrevBal() {
		return bucket04PointPrevBal;
	}

	/**
	 * @param bucket04PointPrevBal the bucket04PointPrevBal to set
	 */
	public void setBucket04PointPrevBal(BigDecimal bucket04PointPrevBal) {
		this.bucket04PointPrevBal = bucket04PointPrevBal;
	}

	/**
	 * @return the bucket04PointRedeemed
	 */
	public BigDecimal getBucket04PointRedeemed() {
		return bucket04PointRedeemed;
	}

	/**
	 * @param bucket04PointRedeemed the bucket04PointRedeemed to set
	 */
	public void setBucket04PointRedeemed(BigDecimal bucket04PointRedeemed) {
		this.bucket04PointRedeemed = bucket04PointRedeemed;
	}

	/**
	 * @return the bucket04PointSign
	 */
	public String getBucket04PointSign() {
		return bucket04PointSign;
	}

	/**
	 * @param bucket04PointSign the bucket04PointSign to set
	 */
	public void setBucket04PointSign(String bucket04PointSign) {
		this.bucket04PointSign = bucket04PointSign;
	}

	/**
	 * @return the bucket04PointBal
	 */
	public BigDecimal getBucket04PointBal() {
		return bucket04PointBal;
	}

	/**
	 * @param bucket04PointBal the bucket04PointBal to set
	 */
	public void setBucket04PointBal(BigDecimal bucket04PointBal) {
		this.bucket04PointBal = bucket04PointBal;
	}

	/**
	 * @return the bucket05PointPrevSign
	 */
	public String getBucket05PointPrevSign() {
		return bucket05PointPrevSign;
	}

	/**
	 * @param bucket05PointPrevSign the bucket05PointPrevSign to set
	 */
	public void setBucket05PointPrevSign(String bucket05PointPrevSign) {
		this.bucket05PointPrevSign = bucket05PointPrevSign;
	}

	/**
	 * @return the bucket05PointPrevBal
	 */
	public BigDecimal getBucket05PointPrevBal() {
		return bucket05PointPrevBal;
	}

	/**
	 * @param bucket05PointPrevBal the bucket05PointPrevBal to set
	 */
	public void setBucket05PointPrevBal(BigDecimal bucket05PointPrevBal) {
		this.bucket05PointPrevBal = bucket05PointPrevBal;
	}

	/**
	 * @return the bucket05PointRedeemed
	 */
	public BigDecimal getBucket05PointRedeemed() {
		return bucket05PointRedeemed;
	}

	/**
	 * @param bucket05PointRedeemed the bucket05PointRedeemed to set
	 */
	public void setBucket05PointRedeemed(BigDecimal bucket05PointRedeemed) {
		this.bucket05PointRedeemed = bucket05PointRedeemed;
	}

	/**
	 * @return the bucket05PointSign
	 */
	public String getBucket05PointSign() {
		return bucket05PointSign;
	}

	/**
	 * @param bucket05PointSign the bucket05PointSign to set
	 */
	public void setBucket05PointSign(String bucket05PointSign) {
		this.bucket05PointSign = bucket05PointSign;
	}

	/**
	 * @return the bucket05PointBal
	 */
	public BigDecimal getBucket05PointBal() {
		return bucket05PointBal;
	}

	/**
	 * @param bucket05PointBal the bucket05PointBal to set
	 */
	public void setBucket05PointBal(BigDecimal bucket05PointBal) {
		this.bucket05PointBal = bucket05PointBal;
	}

	/**
	 * @return the bucket06PointPrevSign
	 */
	public String getBucket06PointPrevSign() {
		return bucket06PointPrevSign;
	}

	/**
	 * @param bucket06PointPrevSign the bucket06PointPrevSign to set
	 */
	public void setBucket06PointPrevSign(String bucket06PointPrevSign) {
		this.bucket06PointPrevSign = bucket06PointPrevSign;
	}

	/**
	 * @return the bucket06PointPrevBal
	 */
	public BigDecimal getBucket06PointPrevBal() {
		return bucket06PointPrevBal;
	}

	/**
	 * @param bucket06PointPrevBal the bucket06PointPrevBal to set
	 */
	public void setBucket06PointPrevBal(BigDecimal bucket06PointPrevBal) {
		this.bucket06PointPrevBal = bucket06PointPrevBal;
	}

	/**
	 * @return the bucket06PointRedeemed
	 */
	public BigDecimal getBucket06PointRedeemed() {
		return bucket06PointRedeemed;
	}

	/**
	 * @param bucket06PointRedeemed the bucket06PointRedeemed to set
	 */
	public void setBucket06PointRedeemed(BigDecimal bucket06PointRedeemed) {
		this.bucket06PointRedeemed = bucket06PointRedeemed;
	}

	/**
	 * @return the bucket06PointSign
	 */
	public String getBucket06PointSign() {
		return bucket06PointSign;
	}

	/**
	 * @param bucket06PointSign the bucket06PointSign to set
	 */
	public void setBucket06PointSign(String bucket06PointSign) {
		this.bucket06PointSign = bucket06PointSign;
	}

	/**
	 * @return the bucket06PointBal
	 */
	public BigDecimal getBucket06PointBal() {
		return bucket06PointBal;
	}

	/**
	 * @param bucket06PointBal the bucket06PointBal to set
	 */
	public void setBucket06PointBal(BigDecimal bucket06PointBal) {
		this.bucket06PointBal = bucket06PointBal;
	}

	/**
	 * @return the bucket07PointPrevSign
	 */
	public String getBucket07PointPrevSign() {
		return bucket07PointPrevSign;
	}

	/**
	 * @param bucket07PointPrevSign the bucket07PointPrevSign to set
	 */
	public void setBucket07PointPrevSign(String bucket07PointPrevSign) {
		this.bucket07PointPrevSign = bucket07PointPrevSign;
	}

	/**
	 * @return the bucket07PointPrevBal
	 */
	public BigDecimal getBucket07PointPrevBal() {
		return bucket07PointPrevBal;
	}

	/**
	 * @param bucket07PointPrevBal the bucket07PointPrevBal to set
	 */
	public void setBucket07PointPrevBal(BigDecimal bucket07PointPrevBal) {
		this.bucket07PointPrevBal = bucket07PointPrevBal;
	}

	/**
	 * @return the bucket07PointRedeemed
	 */
	public BigDecimal getBucket07PointRedeemed() {
		return bucket07PointRedeemed;
	}

	/**
	 * @param bucket07PointRedeemed the bucket07PointRedeemed to set
	 */
	public void setBucket07PointRedeemed(BigDecimal bucket07PointRedeemed) {
		this.bucket07PointRedeemed = bucket07PointRedeemed;
	}

	/**
	 * @return the bucket07PointSign
	 */
	public String getBucket07PointSign() {
		return bucket07PointSign;
	}

	/**
	 * @param bucket07PointSign the bucket07PointSign to set
	 */
	public void setBucket07PointSign(String bucket07PointSign) {
		this.bucket07PointSign = bucket07PointSign;
	}

	/**
	 * @return the bucket07PointBal
	 */
	public BigDecimal getBucket07PointBal() {
		return bucket07PointBal;
	}

	/**
	 * @param bucket07PointBal the bucket07PointBal to set
	 */
	public void setBucket07PointBal(BigDecimal bucket07PointBal) {
		this.bucket07PointBal = bucket07PointBal;
	}

	/**
	 * @return the bucket08PointPrevSign
	 */
	public String getBucket08PointPrevSign() {
		return bucket08PointPrevSign;
	}

	/**
	 * @param bucket08PointPrevSign the bucket08PointPrevSign to set
	 */
	public void setBucket08PointPrevSign(String bucket08PointPrevSign) {
		this.bucket08PointPrevSign = bucket08PointPrevSign;
	}

	/**
	 * @return the bucket08PointPrevBal
	 */
	public BigDecimal getBucket08PointPrevBal() {
		return bucket08PointPrevBal;
	}

	/**
	 * @param bucket08PointPrevBal the bucket08PointPrevBal to set
	 */
	public void setBucket08PointPrevBal(BigDecimal bucket08PointPrevBal) {
		this.bucket08PointPrevBal = bucket08PointPrevBal;
	}

	/**
	 * @return the bucket08PointRedeemed
	 */
	public BigDecimal getBucket08PointRedeemed() {
		return bucket08PointRedeemed;
	}

	/**
	 * @param bucket08PointRedeemed the bucket08PointRedeemed to set
	 */
	public void setBucket08PointRedeemed(BigDecimal bucket08PointRedeemed) {
		this.bucket08PointRedeemed = bucket08PointRedeemed;
	}

	/**
	 * @return the bucket08PointSign
	 */
	public String getBucket08PointSign() {
		return bucket08PointSign;
	}

	/**
	 * @param bucket08PointSign the bucket08PointSign to set
	 */
	public void setBucket08PointSign(String bucket08PointSign) {
		this.bucket08PointSign = bucket08PointSign;
	}

	/**
	 * @return the bucket08PointBal
	 */
	public BigDecimal getBucket08PointBal() {
		return bucket08PointBal;
	}

	/**
	 * @param bucket08PointBal the bucket08PointBal to set
	 */
	public void setBucket08PointBal(BigDecimal bucket08PointBal) {
		this.bucket08PointBal = bucket08PointBal;
	}

	/**
	 * @return the bucket09PointPrevSign
	 */
	public String getBucket09PointPrevSign() {
		return bucket09PointPrevSign;
	}

	/**
	 * @param bucket09PointPrevSign the bucket09PointPrevSign to set
	 */
	public void setBucket09PointPrevSign(String bucket09PointPrevSign) {
		this.bucket09PointPrevSign = bucket09PointPrevSign;
	}

	/**
	 * @return the bucket09PointPrevBal
	 */
	public BigDecimal getBucket09PointPrevBal() {
		return bucket09PointPrevBal;
	}

	/**
	 * @param bucket09PointPrevBal the bucket09PointPrevBal to set
	 */
	public void setBucket09PointPrevBal(BigDecimal bucket09PointPrevBal) {
		this.bucket09PointPrevBal = bucket09PointPrevBal;
	}

	/**
	 * @return the bucket09PointRedeemed
	 */
	public BigDecimal getBucket09PointRedeemed() {
		return bucket09PointRedeemed;
	}

	/**
	 * @param bucket09PointRedeemed the bucket09PointRedeemed to set
	 */
	public void setBucket09PointRedeemed(BigDecimal bucket09PointRedeemed) {
		this.bucket09PointRedeemed = bucket09PointRedeemed;
	}

	/**
	 * @return the bucket09PointSign
	 */
	public String getBucket09PointSign() {
		return bucket09PointSign;
	}

	/**
	 * @param bucket09PointSign the bucket09PointSign to set
	 */
	public void setBucket09PointSign(String bucket09PointSign) {
		this.bucket09PointSign = bucket09PointSign;
	}

	/**
	 * @return the bucket09PointBal
	 */
	public BigDecimal getBucket09PointBal() {
		return bucket09PointBal;
	}

	/**
	 * @param bucket09PointBal the bucket09PointBal to set
	 */
	public void setBucket09PointBal(BigDecimal bucket09PointBal) {
		this.bucket09PointBal = bucket09PointBal;
	}

	/**
	 * @return the bucket10PointPrevSign
	 */
	public String getBucket10PointPrevSign() {
		return bucket10PointPrevSign;
	}

	/**
	 * @param bucket10PointPrevSign the bucket10PointPrevSign to set
	 */
	public void setBucket10PointPrevSign(String bucket10PointPrevSign) {
		this.bucket10PointPrevSign = bucket10PointPrevSign;
	}

	/**
	 * @return the bucket10PointPrevBal
	 */
	public BigDecimal getBucket10PointPrevBal() {
		return bucket10PointPrevBal;
	}

	/**
	 * @param bucket10PointPrevBal the bucket10PointPrevBal to set
	 */
	public void setBucket10PointPrevBal(BigDecimal bucket10PointPrevBal) {
		this.bucket10PointPrevBal = bucket10PointPrevBal;
	}

	/**
	 * @return the bucket10PointRedeemed
	 */
	public BigDecimal getBucket10PointRedeemed() {
		return bucket10PointRedeemed;
	}

	/**
	 * @param bucket10PointRedeemed the bucket10PointRedeemed to set
	 */
	public void setBucket10PointRedeemed(BigDecimal bucket10PointRedeemed) {
		this.bucket10PointRedeemed = bucket10PointRedeemed;
	}

	/**
	 * @return the bucket10PointSign
	 */
	public String getBucket10PointSign() {
		return bucket10PointSign;
	}

	/**
	 * @param bucket10PointSign the bucket10PointSign to set
	 */
	public void setBucket10PointSign(String bucket10PointSign) {
		this.bucket10PointSign = bucket10PointSign;
	}

	/**
	 * @return the bucket10PointBal
	 */
	public BigDecimal getBucket10PointBal() {
		return bucket10PointBal;
	}

	/**
	 * @param bucket10PointBal the bucket10PointBal to set
	 */
	public void setBucket10PointBal(BigDecimal bucket10PointBal) {
		this.bucket10PointBal = bucket10PointBal;
	}

	/**
	 * @return the bucket11PointPrevSign
	 */
	public String getBucket11PointPrevSign() {
		return bucket11PointPrevSign;
	}

	/**
	 * @param bucket11PointPrevSign the bucket11PointPrevSign to set
	 */
	public void setBucket11PointPrevSign(String bucket11PointPrevSign) {
		this.bucket11PointPrevSign = bucket11PointPrevSign;
	}

	/**
	 * @return the bucket11PointPrevBal
	 */
	public BigDecimal getBucket11PointPrevBal() {
		return bucket11PointPrevBal;
	}

	/**
	 * @param bucket11PointPrevBal the bucket11PointPrevBal to set
	 */
	public void setBucket11PointPrevBal(BigDecimal bucket11PointPrevBal) {
		this.bucket11PointPrevBal = bucket11PointPrevBal;
	}

	/**
	 * @return the bucket11PointRedeemed
	 */
	public BigDecimal getBucket11PointRedeemed() {
		return bucket11PointRedeemed;
	}

	/**
	 * @param bucket11PointRedeemed the bucket11PointRedeemed to set
	 */
	public void setBucket11PointRedeemed(BigDecimal bucket11PointRedeemed) {
		this.bucket11PointRedeemed = bucket11PointRedeemed;
	}

	/**
	 * @return the bucket11PointSign
	 */
	public String getBucket11PointSign() {
		return bucket11PointSign;
	}

	/**
	 * @param bucket11PointSign the bucket11PointSign to set
	 */
	public void setBucket11PointSign(String bucket11PointSign) {
		this.bucket11PointSign = bucket11PointSign;
	}

	/**
	 * @return the bucket11PointBal
	 */
	public BigDecimal getBucket11PointBal() {
		return bucket11PointBal;
	}

	/**
	 * @param bucket11PointBal the bucket11PointBal to set
	 */
	public void setBucket11PointBal(BigDecimal bucket11PointBal) {
		this.bucket11PointBal = bucket11PointBal;
	}

	/**
	 * @return the bucket12PointPrevSign
	 */
	public String getBucket12PointPrevSign() {
		return bucket12PointPrevSign;
	}

	/**
	 * @param bucket12PointPrevSign the bucket12PointPrevSign to set
	 */
	public void setBucket12PointPrevSign(String bucket12PointPrevSign) {
		this.bucket12PointPrevSign = bucket12PointPrevSign;
	}

	/**
	 * @return the bucket12PointPrevBal
	 */
	public BigDecimal getBucket12PointPrevBal() {
		return bucket12PointPrevBal;
	}

	/**
	 * @param bucket12PointPrevBal the bucket12PointPrevBal to set
	 */
	public void setBucket12PointPrevBal(BigDecimal bucket12PointPrevBal) {
		this.bucket12PointPrevBal = bucket12PointPrevBal;
	}

	/**
	 * @return the bucket12PointRedeemed
	 */
	public BigDecimal getBucket12PointRedeemed() {
		return bucket12PointRedeemed;
	}

	/**
	 * @param bucket12PointRedeemed the bucket12PointRedeemed to set
	 */
	public void setBucket12PointRedeemed(BigDecimal bucket12PointRedeemed) {
		this.bucket12PointRedeemed = bucket12PointRedeemed;
	}

	/**
	 * @return the bucket12PointSign
	 */
	public String getBucket12PointSign() {
		return bucket12PointSign;
	}

	/**
	 * @param bucket12PointSign the bucket12PointSign to set
	 */
	public void setBucket12PointSign(String bucket12PointSign) {
		this.bucket12PointSign = bucket12PointSign;
	}

	/**
	 * @return the bucket12PointBal
	 */
	public BigDecimal getBucket12PointBal() {
		return bucket12PointBal;
	}

	/**
	 * @param bucket12PointBal the bucket12PointBal to set
	 */
	public void setBucket12PointBal(BigDecimal bucket12PointBal) {
		this.bucket12PointBal = bucket12PointBal;
	}

	/**
	 * @return the bucket13PointPrevSign
	 */
	public String getBucket13PointPrevSign() {
		return bucket13PointPrevSign;
	}

	/**
	 * @param bucket13PointPrevSign the bucket13PointPrevSign to set
	 */
	public void setBucket13PointPrevSign(String bucket13PointPrevSign) {
		this.bucket13PointPrevSign = bucket13PointPrevSign;
	}

	/**
	 * @return the bucket13PointPrevBal
	 */
	public BigDecimal getBucket13PointPrevBal() {
		return bucket13PointPrevBal;
	}

	/**
	 * @param bucket13PointPrevBal the bucket13PointPrevBal to set
	 */
	public void setBucket13PointPrevBal(BigDecimal bucket13PointPrevBal) {
		this.bucket13PointPrevBal = bucket13PointPrevBal;
	}

	/**
	 * @return the bucket13PointRedeemed
	 */
	public BigDecimal getBucket13PointRedeemed() {
		return bucket13PointRedeemed;
	}

	/**
	 * @param bucket13PointRedeemed the bucket13PointRedeemed to set
	 */
	public void setBucket13PointRedeemed(BigDecimal bucket13PointRedeemed) {
		this.bucket13PointRedeemed = bucket13PointRedeemed;
	}

	/**
	 * @return the bucket13PointSign
	 */
	public String getBucket13PointSign() {
		return bucket13PointSign;
	}

	/**
	 * @param bucket13PointSign the bucket13PointSign to set
	 */
	public void setBucket13PointSign(String bucket13PointSign) {
		this.bucket13PointSign = bucket13PointSign;
	}

	/**
	 * @return the bucket13PointBal
	 */
	public BigDecimal getBucket13PointBal() {
		return bucket13PointBal;
	}

	/**
	 * @param bucket13PointBal the bucket13PointBal to set
	 */
	public void setBucket13PointBal(BigDecimal bucket13PointBal) {
		this.bucket13PointBal = bucket13PointBal;
	}

	/**
	 * @return the bucket14PointPrevSign
	 */
	public String getBucket14PointPrevSign() {
		return bucket14PointPrevSign;
	}

	/**
	 * @param bucket14PointPrevSign the bucket14PointPrevSign to set
	 */
	public void setBucket14PointPrevSign(String bucket14PointPrevSign) {
		this.bucket14PointPrevSign = bucket14PointPrevSign;
	}

	/**
	 * @return the bucket14PointPrevBal
	 */
	public BigDecimal getBucket14PointPrevBal() {
		return bucket14PointPrevBal;
	}

	/**
	 * @param bucket14PointPrevBal the bucket14PointPrevBal to set
	 */
	public void setBucket14PointPrevBal(BigDecimal bucket14PointPrevBal) {
		this.bucket14PointPrevBal = bucket14PointPrevBal;
	}

	/**
	 * @return the bucket14PointRedeemed
	 */
	public BigDecimal getBucket14PointRedeemed() {
		return bucket14PointRedeemed;
	}

	/**
	 * @param bucket14PointRedeemed the bucket14PointRedeemed to set
	 */
	public void setBucket14PointRedeemed(BigDecimal bucket14PointRedeemed) {
		this.bucket14PointRedeemed = bucket14PointRedeemed;
	}

	/**
	 * @return the bucket14PointSign
	 */
	public String getBucket14PointSign() {
		return bucket14PointSign;
	}

	/**
	 * @param bucket14PointSign the bucket14PointSign to set
	 */
	public void setBucket14PointSign(String bucket14PointSign) {
		this.bucket14PointSign = bucket14PointSign;
	}

	/**
	 * @return the bucket14PointBal
	 */
	public BigDecimal getBucket14PointBal() {
		return bucket14PointBal;
	}

	/**
	 * @param bucket14PointBal the bucket14PointBal to set
	 */
	public void setBucket14PointBal(BigDecimal bucket14PointBal) {
		this.bucket14PointBal = bucket14PointBal;
	}

	/**
	 * @return the bucket15PointPrevSign
	 */
	public String getBucket15PointPrevSign() {
		return bucket15PointPrevSign;
	}

	/**
	 * @param bucket15PointPrevSign the bucket15PointPrevSign to set
	 */
	public void setBucket15PointPrevSign(String bucket15PointPrevSign) {
		this.bucket15PointPrevSign = bucket15PointPrevSign;
	}

	/**
	 * @return the bucket15PointPrevBal
	 */
	public BigDecimal getBucket15PointPrevBal() {
		return bucket15PointPrevBal;
	}

	/**
	 * @param bucket15PointPrevBal the bucket15PointPrevBal to set
	 */
	public void setBucket15PointPrevBal(BigDecimal bucket15PointPrevBal) {
		this.bucket15PointPrevBal = bucket15PointPrevBal;
	}

	/**
	 * @return the bucket15PointRedeemed
	 */
	public BigDecimal getBucket15PointRedeemed() {
		return bucket15PointRedeemed;
	}

	/**
	 * @param bucket15PointRedeemed the bucket15PointRedeemed to set
	 */
	public void setBucket15PointRedeemed(BigDecimal bucket15PointRedeemed) {
		this.bucket15PointRedeemed = bucket15PointRedeemed;
	}

	/**
	 * @return the bucket15PointSign
	 */
	public String getBucket15PointSign() {
		return bucket15PointSign;
	}

	/**
	 * @param bucket15PointSign the bucket15PointSign to set
	 */
	public void setBucket15PointSign(String bucket15PointSign) {
		this.bucket15PointSign = bucket15PointSign;
	}

	/**
	 * @return the bucket15PointBal
	 */
	public BigDecimal getBucket15PointBal() {
		return bucket15PointBal;
	}

	/**
	 * @param bucket15PointBal the bucket15PointBal to set
	 */
	public void setBucket15PointBal(BigDecimal bucket15PointBal) {
		this.bucket15PointBal = bucket15PointBal;
	}

	/**
	 * @return the bucket16PointPrevSign
	 */
	public String getBucket16PointPrevSign() {
		return bucket16PointPrevSign;
	}

	/**
	 * @param bucket16PointPrevSign the bucket16PointPrevSign to set
	 */
	public void setBucket16PointPrevSign(String bucket16PointPrevSign) {
		this.bucket16PointPrevSign = bucket16PointPrevSign;
	}

	/**
	 * @return the bucket16PointPrevBal
	 */
	public BigDecimal getBucket16PointPrevBal() {
		return bucket16PointPrevBal;
	}

	/**
	 * @param bucket16PointPrevBal the bucket16PointPrevBal to set
	 */
	public void setBucket16PointPrevBal(BigDecimal bucket16PointPrevBal) {
		this.bucket16PointPrevBal = bucket16PointPrevBal;
	}

	/**
	 * @return the bucket16PointRedeemed
	 */
	public BigDecimal getBucket16PointRedeemed() {
		return bucket16PointRedeemed;
	}

	/**
	 * @param bucket16PointRedeemed the bucket16PointRedeemed to set
	 */
	public void setBucket16PointRedeemed(BigDecimal bucket16PointRedeemed) {
		this.bucket16PointRedeemed = bucket16PointRedeemed;
	}

	/**
	 * @return the bucket16PointSign
	 */
	public String getBucket16PointSign() {
		return bucket16PointSign;
	}

	/**
	 * @param bucket16PointSign the bucket16PointSign to set
	 */
	public void setBucket16PointSign(String bucket16PointSign) {
		this.bucket16PointSign = bucket16PointSign;
	}

	/**
	 * @return the bucket16PointBal
	 */
	public BigDecimal getBucket16PointBal() {
		return bucket16PointBal;
	}

	/**
	 * @param bucket16PointBal the bucket16PointBal to set
	 */
	public void setBucket16PointBal(BigDecimal bucket16PointBal) {
		this.bucket16PointBal = bucket16PointBal;
	}

	/**
	 * @return the bucket17PointPrevSign
	 */
	public String getBucket17PointPrevSign() {
		return bucket17PointPrevSign;
	}

	/**
	 * @param bucket17PointPrevSign the bucket17PointPrevSign to set
	 */
	public void setBucket17PointPrevSign(String bucket17PointPrevSign) {
		this.bucket17PointPrevSign = bucket17PointPrevSign;
	}

	/**
	 * @return the bucket17PointPrevBal
	 */
	public BigDecimal getBucket17PointPrevBal() {
		return bucket17PointPrevBal;
	}

	/**
	 * @param bucket17PointPrevBal the bucket17PointPrevBal to set
	 */
	public void setBucket17PointPrevBal(BigDecimal bucket17PointPrevBal) {
		this.bucket17PointPrevBal = bucket17PointPrevBal;
	}

	/**
	 * @return the bucket17PointRedeemed
	 */
	public BigDecimal getBucket17PointRedeemed() {
		return bucket17PointRedeemed;
	}

	/**
	 * @param bucket17PointRedeemed the bucket17PointRedeemed to set
	 */
	public void setBucket17PointRedeemed(BigDecimal bucket17PointRedeemed) {
		this.bucket17PointRedeemed = bucket17PointRedeemed;
	}

	/**
	 * @return the bucket17PointSign
	 */
	public String getBucket17PointSign() {
		return bucket17PointSign;
	}

	/**
	 * @param bucket17PointSign the bucket17PointSign to set
	 */
	public void setBucket17PointSign(String bucket17PointSign) {
		this.bucket17PointSign = bucket17PointSign;
	}

	/**
	 * @return the bucket17PointBal
	 */
	public BigDecimal getBucket17PointBal() {
		return bucket17PointBal;
	}

	/**
	 * @param bucket17PointBal the bucket17PointBal to set
	 */
	public void setBucket17PointBal(BigDecimal bucket17PointBal) {
		this.bucket17PointBal = bucket17PointBal;
	}

	/**
	 * @return the bucket18PointPrevSign
	 */
	public String getBucket18PointPrevSign() {
		return bucket18PointPrevSign;
	}

	/**
	 * @param bucket18PointPrevSign the bucket18PointPrevSign to set
	 */
	public void setBucket18PointPrevSign(String bucket18PointPrevSign) {
		this.bucket18PointPrevSign = bucket18PointPrevSign;
	}

	/**
	 * @return the bucket18PointPrevBal
	 */
	public BigDecimal getBucket18PointPrevBal() {
		return bucket18PointPrevBal;
	}

	/**
	 * @param bucket18PointPrevBal the bucket18PointPrevBal to set
	 */
	public void setBucket18PointPrevBal(BigDecimal bucket18PointPrevBal) {
		this.bucket18PointPrevBal = bucket18PointPrevBal;
	}

	/**
	 * @return the bucket18PointRedeemed
	 */
	public BigDecimal getBucket18PointRedeemed() {
		return bucket18PointRedeemed;
	}

	/**
	 * @param bucket18PointRedeemed the bucket18PointRedeemed to set
	 */
	public void setBucket18PointRedeemed(BigDecimal bucket18PointRedeemed) {
		this.bucket18PointRedeemed = bucket18PointRedeemed;
	}

	/**
	 * @return the bucket18PointSign
	 */
	public String getBucket18PointSign() {
		return bucket18PointSign;
	}

	/**
	 * @param bucket18PointSign the bucket18PointSign to set
	 */
	public void setBucket18PointSign(String bucket18PointSign) {
		this.bucket18PointSign = bucket18PointSign;
	}

	/**
	 * @return the bucket18PointBal
	 */
	public BigDecimal getBucket18PointBal() {
		return bucket18PointBal;
	}

	/**
	 * @param bucket18PointBal the bucket18PointBal to set
	 */
	public void setBucket18PointBal(BigDecimal bucket18PointBal) {
		this.bucket18PointBal = bucket18PointBal;
	}

	/**
	 * @return the bucket19PointPrevSign
	 */
	public String getBucket19PointPrevSign() {
		return bucket19PointPrevSign;
	}

	/**
	 * @param bucket19PointPrevSign the bucket19PointPrevSign to set
	 */
	public void setBucket19PointPrevSign(String bucket19PointPrevSign) {
		this.bucket19PointPrevSign = bucket19PointPrevSign;
	}

	/**
	 * @return the bucket19PointPrevBal
	 */
	public BigDecimal getBucket19PointPrevBal() {
		return bucket19PointPrevBal;
	}

	/**
	 * @param bucket19PointPrevBal the bucket19PointPrevBal to set
	 */
	public void setBucket19PointPrevBal(BigDecimal bucket19PointPrevBal) {
		this.bucket19PointPrevBal = bucket19PointPrevBal;
	}

	/**
	 * @return the bucket19PointRedeemed
	 */
	public BigDecimal getBucket19PointRedeemed() {
		return bucket19PointRedeemed;
	}

	/**
	 * @param bucket19PointRedeemed the bucket19PointRedeemed to set
	 */
	public void setBucket19PointRedeemed(BigDecimal bucket19PointRedeemed) {
		this.bucket19PointRedeemed = bucket19PointRedeemed;
	}

	/**
	 * @return the bucket19PointSign
	 */
	public String getBucket19PointSign() {
		return bucket19PointSign;
	}

	/**
	 * @param bucket19PointSign the bucket19PointSign to set
	 */
	public void setBucket19PointSign(String bucket19PointSign) {
		this.bucket19PointSign = bucket19PointSign;
	}

	/**
	 * @return the bucket19PointBal
	 */
	public BigDecimal getBucket19PointBal() {
		return bucket19PointBal;
	}

	/**
	 * @param bucket19PointBal the bucket19PointBal to set
	 */
	public void setBucket19PointBal(BigDecimal bucket19PointBal) {
		this.bucket19PointBal = bucket19PointBal;
	}

	/**
	 * @return the bucket20PointPrevSign
	 */
	public String getBucket20PointPrevSign() {
		return bucket20PointPrevSign;
	}

	/**
	 * @param bucket20PointPrevSign the bucket20PointPrevSign to set
	 */
	public void setBucket20PointPrevSign(String bucket20PointPrevSign) {
		this.bucket20PointPrevSign = bucket20PointPrevSign;
	}

	/**
	 * @return the bucket20PointPrevBal
	 */
	public BigDecimal getBucket20PointPrevBal() {
		return bucket20PointPrevBal;
	}

	/**
	 * @param bucket20PointPrevBal the bucket20PointPrevBal to set
	 */
	public void setBucket20PointPrevBal(BigDecimal bucket20PointPrevBal) {
		this.bucket20PointPrevBal = bucket20PointPrevBal;
	}

	/**
	 * @return the bucket20PointRedeemed
	 */
	public BigDecimal getBucket20PointRedeemed() {
		return bucket20PointRedeemed;
	}

	/**
	 * @param bucket20PointRedeemed the bucket20PointRedeemed to set
	 */
	public void setBucket20PointRedeemed(BigDecimal bucket20PointRedeemed) {
		this.bucket20PointRedeemed = bucket20PointRedeemed;
	}

	/**
	 * @return the bucket20PointSign
	 */
	public String getBucket20PointSign() {
		return bucket20PointSign;
	}

	/**
	 * @param bucket20PointSign the bucket20PointSign to set
	 */
	public void setBucket20PointSign(String bucket20PointSign) {
		this.bucket20PointSign = bucket20PointSign;
	}

	/**
	 * @return the bucket20PointBal
	 */
	public BigDecimal getBucket20PointBal() {
		return bucket20PointBal;
	}

	/**
	 * @param bucket20PointBal the bucket20PointBal to set
	 */
	public void setBucket20PointBal(BigDecimal bucket20PointBal) {
		this.bucket20PointBal = bucket20PointBal;
	}

	/**
	 * @return the bucket21PointPrevSign
	 */
	public String getBucket21PointPrevSign() {
		return bucket21PointPrevSign;
	}

	/**
	 * @param bucket21PointPrevSign the bucket21PointPrevSign to set
	 */
	public void setBucket21PointPrevSign(String bucket21PointPrevSign) {
		this.bucket21PointPrevSign = bucket21PointPrevSign;
	}

	/**
	 * @return the bucket21PointPrevBal
	 */
	public BigDecimal getBucket21PointPrevBal() {
		return bucket21PointPrevBal;
	}

	/**
	 * @param bucket21PointPrevBal the bucket21PointPrevBal to set
	 */
	public void setBucket21PointPrevBal(BigDecimal bucket21PointPrevBal) {
		this.bucket21PointPrevBal = bucket21PointPrevBal;
	}

	/**
	 * @return the bucket21PointRedeemed
	 */
	public BigDecimal getBucket21PointRedeemed() {
		return bucket21PointRedeemed;
	}

	/**
	 * @param bucket21PointRedeemed the bucket21PointRedeemed to set
	 */
	public void setBucket21PointRedeemed(BigDecimal bucket21PointRedeemed) {
		this.bucket21PointRedeemed = bucket21PointRedeemed;
	}

	/**
	 * @return the bucket21PointSign
	 */
	public String getBucket21PointSign() {
		return bucket21PointSign;
	}

	/**
	 * @param bucket21PointSign the bucket21PointSign to set
	 */
	public void setBucket21PointSign(String bucket21PointSign) {
		this.bucket21PointSign = bucket21PointSign;
	}

	/**
	 * @return the bucket21PointBal
	 */
	public BigDecimal getBucket21PointBal() {
		return bucket21PointBal;
	}

	/**
	 * @param bucket21PointBal the bucket21PointBal to set
	 */
	public void setBucket21PointBal(BigDecimal bucket21PointBal) {
		this.bucket21PointBal = bucket21PointBal;
	}

	/**
	 * @return the bucket22PointPrevSign
	 */
	public String getBucket22PointPrevSign() {
		return bucket22PointPrevSign;
	}

	/**
	 * @param bucket22PointPrevSign the bucket22PointPrevSign to set
	 */
	public void setBucket22PointPrevSign(String bucket22PointPrevSign) {
		this.bucket22PointPrevSign = bucket22PointPrevSign;
	}

	/**
	 * @return the bucket22PointPrevBal
	 */
	public BigDecimal getBucket22PointPrevBal() {
		return bucket22PointPrevBal;
	}

	/**
	 * @param bucket22PointPrevBal the bucket22PointPrevBal to set
	 */
	public void setBucket22PointPrevBal(BigDecimal bucket22PointPrevBal) {
		this.bucket22PointPrevBal = bucket22PointPrevBal;
	}

	/**
	 * @return the bucket22PointRedeemed
	 */
	public BigDecimal getBucket22PointRedeemed() {
		return bucket22PointRedeemed;
	}

	/**
	 * @param bucket22PointRedeemed the bucket22PointRedeemed to set
	 */
	public void setBucket22PointRedeemed(BigDecimal bucket22PointRedeemed) {
		this.bucket22PointRedeemed = bucket22PointRedeemed;
	}

	/**
	 * @return the bucket22PointSign
	 */
	public String getBucket22PointSign() {
		return bucket22PointSign;
	}

	/**
	 * @param bucket22PointSign the bucket22PointSign to set
	 */
	public void setBucket22PointSign(String bucket22PointSign) {
		this.bucket22PointSign = bucket22PointSign;
	}

	/**
	 * @return the bucket22PointBal
	 */
	public BigDecimal getBucket22PointBal() {
		return bucket22PointBal;
	}

	/**
	 * @param bucket22PointBal the bucket22PointBal to set
	 */
	public void setBucket22PointBal(BigDecimal bucket22PointBal) {
		this.bucket22PointBal = bucket22PointBal;
	}

	/**
	 * @return the bucket23PointPrevSign
	 */
	public String getBucket23PointPrevSign() {
		return bucket23PointPrevSign;
	}

	/**
	 * @param bucket23PointPrevSign the bucket23PointPrevSign to set
	 */
	public void setBucket23PointPrevSign(String bucket23PointPrevSign) {
		this.bucket23PointPrevSign = bucket23PointPrevSign;
	}

	/**
	 * @return the bucket23PointPrevBal
	 */
	public BigDecimal getBucket23PointPrevBal() {
		return bucket23PointPrevBal;
	}

	/**
	 * @param bucket23PointPrevBal the bucket23PointPrevBal to set
	 */
	public void setBucket23PointPrevBal(BigDecimal bucket23PointPrevBal) {
		this.bucket23PointPrevBal = bucket23PointPrevBal;
	}

	/**
	 * @return the bucket23PointRedeemed
	 */
	public BigDecimal getBucket23PointRedeemed() {
		return bucket23PointRedeemed;
	}

	/**
	 * @param bucket23PointRedeemed the bucket23PointRedeemed to set
	 */
	public void setBucket23PointRedeemed(BigDecimal bucket23PointRedeemed) {
		this.bucket23PointRedeemed = bucket23PointRedeemed;
	}

	/**
	 * @return the bucket23PointSign
	 */
	public String getBucket23PointSign() {
		return bucket23PointSign;
	}

	/**
	 * @param bucket23PointSign the bucket23PointSign to set
	 */
	public void setBucket23PointSign(String bucket23PointSign) {
		this.bucket23PointSign = bucket23PointSign;
	}

	/**
	 * @return the bucket23PointBal
	 */
	public BigDecimal getBucket23PointBal() {
		return bucket23PointBal;
	}

	/**
	 * @param bucket23PointBal the bucket23PointBal to set
	 */
	public void setBucket23PointBal(BigDecimal bucket23PointBal) {
		this.bucket23PointBal = bucket23PointBal;
	}

	/**
	 * @return the bucket24PointPrevSign
	 */
	public String getBucket24PointPrevSign() {
		return bucket24PointPrevSign;
	}

	/**
	 * @param bucket24PointPrevSign the bucket24PointPrevSign to set
	 */
	public void setBucket24PointPrevSign(String bucket24PointPrevSign) {
		this.bucket24PointPrevSign = bucket24PointPrevSign;
	}

	/**
	 * @return the bucket24PointPrevBal
	 */
	public BigDecimal getBucket24PointPrevBal() {
		return bucket24PointPrevBal;
	}

	/**
	 * @param bucket24PointPrevBal the bucket24PointPrevBal to set
	 */
	public void setBucket24PointPrevBal(BigDecimal bucket24PointPrevBal) {
		this.bucket24PointPrevBal = bucket24PointPrevBal;
	}

	/**
	 * @return the bucket24PointRedeemed
	 */
	public BigDecimal getBucket24PointRedeemed() {
		return bucket24PointRedeemed;
	}

	/**
	 * @param bucket24PointRedeemed the bucket24PointRedeemed to set
	 */
	public void setBucket24PointRedeemed(BigDecimal bucket24PointRedeemed) {
		this.bucket24PointRedeemed = bucket24PointRedeemed;
	}

	/**
	 * @return the bucket24PointSign
	 */
	public String getBucket24PointSign() {
		return bucket24PointSign;
	}

	/**
	 * @param bucket24PointSign the bucket24PointSign to set
	 */
	public void setBucket24PointSign(String bucket24PointSign) {
		this.bucket24PointSign = bucket24PointSign;
	}

	/**
	 * @return the bucket24PointBal
	 */
	public BigDecimal getBucket24PointBal() {
		return bucket24PointBal;
	}

	/**
	 * @param bucket24PointBal the bucket24PointBal to set
	 */
	public void setBucket24PointBal(BigDecimal bucket24PointBal) {
		this.bucket24PointBal = bucket24PointBal;
	}

	/**
	 * @return the bucket25PointPrevSign
	 */
	public String getBucket25PointPrevSign() {
		return bucket25PointPrevSign;
	}

	/**
	 * @param bucket25PointPrevSign the bucket25PointPrevSign to set
	 */
	public void setBucket25PointPrevSign(String bucket25PointPrevSign) {
		this.bucket25PointPrevSign = bucket25PointPrevSign;
	}

	/**
	 * @return the bucket25PointPrevBal
	 */
	public BigDecimal getBucket25PointPrevBal() {
		return bucket25PointPrevBal;
	}

	/**
	 * @param bucket25PointPrevBal the bucket25PointPrevBal to set
	 */
	public void setBucket25PointPrevBal(BigDecimal bucket25PointPrevBal) {
		this.bucket25PointPrevBal = bucket25PointPrevBal;
	}

	/**
	 * @return the bucket25PointRedeemed
	 */
	public BigDecimal getBucket25PointRedeemed() {
		return bucket25PointRedeemed;
	}

	/**
	 * @param bucket25PointRedeemed the bucket25PointRedeemed to set
	 */
	public void setBucket25PointRedeemed(BigDecimal bucket25PointRedeemed) {
		this.bucket25PointRedeemed = bucket25PointRedeemed;
	}

	/**
	 * @return the bucket25PointSign
	 */
	public String getBucket25PointSign() {
		return bucket25PointSign;
	}

	/**
	 * @param bucket25PointSign the bucket25PointSign to set
	 */
	public void setBucket25PointSign(String bucket25PointSign) {
		this.bucket25PointSign = bucket25PointSign;
	}

	/**
	 * @return the bucket25PointBal
	 */
	public BigDecimal getBucket25PointBal() {
		return bucket25PointBal;
	}

	/**
	 * @param bucket25PointBal the bucket25PointBal to set
	 */
	public void setBucket25PointBal(BigDecimal bucket25PointBal) {
		this.bucket25PointBal = bucket25PointBal;
	}

	/**
	 * @return the bucket26PointPrevSign
	 */
	public String getBucket26PointPrevSign() {
		return bucket26PointPrevSign;
	}

	/**
	 * @param bucket26PointPrevSign the bucket26PointPrevSign to set
	 */
	public void setBucket26PointPrevSign(String bucket26PointPrevSign) {
		this.bucket26PointPrevSign = bucket26PointPrevSign;
	}

	/**
	 * @return the bucket26PointPrevBal
	 */
	public BigDecimal getBucket26PointPrevBal() {
		return bucket26PointPrevBal;
	}

	/**
	 * @param bucket26PointPrevBal the bucket26PointPrevBal to set
	 */
	public void setBucket26PointPrevBal(BigDecimal bucket26PointPrevBal) {
		this.bucket26PointPrevBal = bucket26PointPrevBal;
	}

	/**
	 * @return the bucket26PointRedeemed
	 */
	public BigDecimal getBucket26PointRedeemed() {
		return bucket26PointRedeemed;
	}

	/**
	 * @param bucket26PointRedeemed the bucket26PointRedeemed to set
	 */
	public void setBucket26PointRedeemed(BigDecimal bucket26PointRedeemed) {
		this.bucket26PointRedeemed = bucket26PointRedeemed;
	}

	/**
	 * @return the bucket26PointSign
	 */
	public String getBucket26PointSign() {
		return bucket26PointSign;
	}

	/**
	 * @param bucket26PointSign the bucket26PointSign to set
	 */
	public void setBucket26PointSign(String bucket26PointSign) {
		this.bucket26PointSign = bucket26PointSign;
	}

	/**
	 * @return the bucket26PointBal
	 */
	public BigDecimal getBucket26PointBal() {
		return bucket26PointBal;
	}

	/**
	 * @param bucket26PointBal the bucket26PointBal to set
	 */
	public void setBucket26PointBal(BigDecimal bucket26PointBal) {
		this.bucket26PointBal = bucket26PointBal;
	}

	/**
	 * @return the bucket27PointPrevSign
	 */
	public String getBucket27PointPrevSign() {
		return bucket27PointPrevSign;
	}

	/**
	 * @param bucket27PointPrevSign the bucket27PointPrevSign to set
	 */
	public void setBucket27PointPrevSign(String bucket27PointPrevSign) {
		this.bucket27PointPrevSign = bucket27PointPrevSign;
	}

	/**
	 * @return the bucket27PointPrevBal
	 */
	public BigDecimal getBucket27PointPrevBal() {
		return bucket27PointPrevBal;
	}

	/**
	 * @param bucket27PointPrevBal the bucket27PointPrevBal to set
	 */
	public void setBucket27PointPrevBal(BigDecimal bucket27PointPrevBal) {
		this.bucket27PointPrevBal = bucket27PointPrevBal;
	}

	/**
	 * @return the bucket27PointRedeemed
	 */
	public BigDecimal getBucket27PointRedeemed() {
		return bucket27PointRedeemed;
	}

	/**
	 * @param bucket27PointRedeemed the bucket27PointRedeemed to set
	 */
	public void setBucket27PointRedeemed(BigDecimal bucket27PointRedeemed) {
		this.bucket27PointRedeemed = bucket27PointRedeemed;
	}

	/**
	 * @return the bucket27PointSign
	 */
	public String getBucket27PointSign() {
		return bucket27PointSign;
	}

	/**
	 * @param bucket27PointSign the bucket27PointSign to set
	 */
	public void setBucket27PointSign(String bucket27PointSign) {
		this.bucket27PointSign = bucket27PointSign;
	}

	/**
	 * @return the bucket27PointBal
	 */
	public BigDecimal getBucket27PointBal() {
		return bucket27PointBal;
	}

	/**
	 * @param bucket27PointBal the bucket27PointBal to set
	 */
	public void setBucket27PointBal(BigDecimal bucket27PointBal) {
		this.bucket27PointBal = bucket27PointBal;
	}

	/**
	 * @return the bucket28PointPrevSign
	 */
	public String getBucket28PointPrevSign() {
		return bucket28PointPrevSign;
	}

	/**
	 * @param bucket28PointPrevSign the bucket28PointPrevSign to set
	 */
	public void setBucket28PointPrevSign(String bucket28PointPrevSign) {
		this.bucket28PointPrevSign = bucket28PointPrevSign;
	}

	/**
	 * @return the bucket28PointPrevBal
	 */
	public BigDecimal getBucket28PointPrevBal() {
		return bucket28PointPrevBal;
	}

	/**
	 * @param bucket28PointPrevBal the bucket28PointPrevBal to set
	 */
	public void setBucket28PointPrevBal(BigDecimal bucket28PointPrevBal) {
		this.bucket28PointPrevBal = bucket28PointPrevBal;
	}

	/**
	 * @return the bucket28PointRedeemed
	 */
	public BigDecimal getBucket28PointRedeemed() {
		return bucket28PointRedeemed;
	}

	/**
	 * @param bucket28PointRedeemed the bucket28PointRedeemed to set
	 */
	public void setBucket28PointRedeemed(BigDecimal bucket28PointRedeemed) {
		this.bucket28PointRedeemed = bucket28PointRedeemed;
	}

	/**
	 * @return the bucket28PointSign
	 */
	public String getBucket28PointSign() {
		return bucket28PointSign;
	}

	/**
	 * @param bucket28PointSign the bucket28PointSign to set
	 */
	public void setBucket28PointSign(String bucket28PointSign) {
		this.bucket28PointSign = bucket28PointSign;
	}

	/**
	 * @return the bucket28PointBal
	 */
	public BigDecimal getBucket28PointBal() {
		return bucket28PointBal;
	}

	/**
	 * @param bucket28PointBal the bucket28PointBal to set
	 */
	public void setBucket28PointBal(BigDecimal bucket28PointBal) {
		this.bucket28PointBal = bucket28PointBal;
	}

	/**
	 * @return the bucket29PointPrevSign
	 */
	public String getBucket29PointPrevSign() {
		return bucket29PointPrevSign;
	}

	/**
	 * @param bucket29PointPrevSign the bucket29PointPrevSign to set
	 */
	public void setBucket29PointPrevSign(String bucket29PointPrevSign) {
		this.bucket29PointPrevSign = bucket29PointPrevSign;
	}

	/**
	 * @return the bucket29PointPrevBal
	 */
	public BigDecimal getBucket29PointPrevBal() {
		return bucket29PointPrevBal;
	}

	/**
	 * @param bucket29PointPrevBal the bucket29PointPrevBal to set
	 */
	public void setBucket29PointPrevBal(BigDecimal bucket29PointPrevBal) {
		this.bucket29PointPrevBal = bucket29PointPrevBal;
	}

	/**
	 * @return the bucket29PointRedeemed
	 */
	public BigDecimal getBucket29PointRedeemed() {
		return bucket29PointRedeemed;
	}

	/**
	 * @param bucket29PointRedeemed the bucket29PointRedeemed to set
	 */
	public void setBucket29PointRedeemed(BigDecimal bucket29PointRedeemed) {
		this.bucket29PointRedeemed = bucket29PointRedeemed;
	}

	/**
	 * @return the bucket29PointSign
	 */
	public String getBucket29PointSign() {
		return bucket29PointSign;
	}

	/**
	 * @param bucket29PointSign the bucket29PointSign to set
	 */
	public void setBucket29PointSign(String bucket29PointSign) {
		this.bucket29PointSign = bucket29PointSign;
	}

	/**
	 * @return the bucket29PointBal
	 */
	public BigDecimal getBucket29PointBal() {
		return bucket29PointBal;
	}

	/**
	 * @param bucket29PointBal the bucket29PointBal to set
	 */
	public void setBucket29PointBal(BigDecimal bucket29PointBal) {
		this.bucket29PointBal = bucket29PointBal;
	}

	/**
	 * @return the bucket30PointPrevSign
	 */
	public String getBucket30PointPrevSign() {
		return bucket30PointPrevSign;
	}

	/**
	 * @param bucket30PointPrevSign the bucket30PointPrevSign to set
	 */
	public void setBucket30PointPrevSign(String bucket30PointPrevSign) {
		this.bucket30PointPrevSign = bucket30PointPrevSign;
	}

	/**
	 * @return the bucket30PointPrevBal
	 */
	public BigDecimal getBucket30PointPrevBal() {
		return bucket30PointPrevBal;
	}

	/**
	 * @param bucket30PointPrevBal the bucket30PointPrevBal to set
	 */
	public void setBucket30PointPrevBal(BigDecimal bucket30PointPrevBal) {
		this.bucket30PointPrevBal = bucket30PointPrevBal;
	}

	/**
	 * @return the bucket30PointRedeemed
	 */
	public BigDecimal getBucket30PointRedeemed() {
		return bucket30PointRedeemed;
	}

	/**
	 * @param bucket30PointRedeemed the bucket30PointRedeemed to set
	 */
	public void setBucket30PointRedeemed(BigDecimal bucket30PointRedeemed) {
		this.bucket30PointRedeemed = bucket30PointRedeemed;
	}

	/**
	 * @return the bucket30PointSign
	 */
	public String getBucket30PointSign() {
		return bucket30PointSign;
	}

	/**
	 * @param bucket30PointSign the bucket30PointSign to set
	 */
	public void setBucket30PointSign(String bucket30PointSign) {
		this.bucket30PointSign = bucket30PointSign;
	}

	/**
	 * @return the bucket30PointBal
	 */
	public BigDecimal getBucket30PointBal() {
		return bucket30PointBal;
	}

	/**
	 * @param bucket30PointBal the bucket30PointBal to set
	 */
	public void setBucket30PointBal(BigDecimal bucket30PointBal) {
		this.bucket30PointBal = bucket30PointBal;
	}

	/**
	 * @return the bucket31PointPrevSign
	 */
	public String getBucket31PointPrevSign() {
		return bucket31PointPrevSign;
	}

	/**
	 * @param bucket31PointPrevSign the bucket31PointPrevSign to set
	 */
	public void setBucket31PointPrevSign(String bucket31PointPrevSign) {
		this.bucket31PointPrevSign = bucket31PointPrevSign;
	}

	/**
	 * @return the bucket31PointPrevBal
	 */
	public BigDecimal getBucket31PointPrevBal() {
		return bucket31PointPrevBal;
	}

	/**
	 * @param bucket31PointPrevBal the bucket31PointPrevBal to set
	 */
	public void setBucket31PointPrevBal(BigDecimal bucket31PointPrevBal) {
		this.bucket31PointPrevBal = bucket31PointPrevBal;
	}

	/**
	 * @return the bucket31PointRedeemed
	 */
	public BigDecimal getBucket31PointRedeemed() {
		return bucket31PointRedeemed;
	}

	/**
	 * @param bucket31PointRedeemed the bucket31PointRedeemed to set
	 */
	public void setBucket31PointRedeemed(BigDecimal bucket31PointRedeemed) {
		this.bucket31PointRedeemed = bucket31PointRedeemed;
	}

	/**
	 * @return the bucket31PointSign
	 */
	public String getBucket31PointSign() {
		return bucket31PointSign;
	}

	/**
	 * @param bucket31PointSign the bucket31PointSign to set
	 */
	public void setBucket31PointSign(String bucket31PointSign) {
		this.bucket31PointSign = bucket31PointSign;
	}

	/**
	 * @return the bucket31PointBal
	 */
	public BigDecimal getBucket31PointBal() {
		return bucket31PointBal;
	}

	/**
	 * @param bucket31PointBal the bucket31PointBal to set
	 */
	public void setBucket31PointBal(BigDecimal bucket31PointBal) {
		this.bucket31PointBal = bucket31PointBal;
	}

	/**
	 * @return the bucket32PointPrevSign
	 */
	public String getBucket32PointPrevSign() {
		return bucket32PointPrevSign;
	}

	/**
	 * @param bucket32PointPrevSign the bucket32PointPrevSign to set
	 */
	public void setBucket32PointPrevSign(String bucket32PointPrevSign) {
		this.bucket32PointPrevSign = bucket32PointPrevSign;
	}

	/**
	 * @return the bucket32PointPrevBal
	 */
	public BigDecimal getBucket32PointPrevBal() {
		return bucket32PointPrevBal;
	}

	/**
	 * @param bucket32PointPrevBal the bucket32PointPrevBal to set
	 */
	public void setBucket32PointPrevBal(BigDecimal bucket32PointPrevBal) {
		this.bucket32PointPrevBal = bucket32PointPrevBal;
	}

	/**
	 * @return the bucket32PointRedeemed
	 */
	public BigDecimal getBucket32PointRedeemed() {
		return bucket32PointRedeemed;
	}

	/**
	 * @param bucket32PointRedeemed the bucket32PointRedeemed to set
	 */
	public void setBucket32PointRedeemed(BigDecimal bucket32PointRedeemed) {
		this.bucket32PointRedeemed = bucket32PointRedeemed;
	}

	/**
	 * @return the bucket32PointSign
	 */
	public String getBucket32PointSign() {
		return bucket32PointSign;
	}

	/**
	 * @param bucket32PointSign the bucket32PointSign to set
	 */
	public void setBucket32PointSign(String bucket32PointSign) {
		this.bucket32PointSign = bucket32PointSign;
	}

	/**
	 * @return the bucket32PointBal
	 */
	public BigDecimal getBucket32PointBal() {
		return bucket32PointBal;
	}

	/**
	 * @param bucket32PointBal the bucket32PointBal to set
	 */
	public void setBucket32PointBal(BigDecimal bucket32PointBal) {
		this.bucket32PointBal = bucket32PointBal;
	}

	/**
	 * @return the bucket33PointPrevSign
	 */
	public String getBucket33PointPrevSign() {
		return bucket33PointPrevSign;
	}

	/**
	 * @param bucket33PointPrevSign the bucket33PointPrevSign to set
	 */
	public void setBucket33PointPrevSign(String bucket33PointPrevSign) {
		this.bucket33PointPrevSign = bucket33PointPrevSign;
	}

	/**
	 * @return the bucket33PointPrevBal
	 */
	public BigDecimal getBucket33PointPrevBal() {
		return bucket33PointPrevBal;
	}

	/**
	 * @param bucket33PointPrevBal the bucket33PointPrevBal to set
	 */
	public void setBucket33PointPrevBal(BigDecimal bucket33PointPrevBal) {
		this.bucket33PointPrevBal = bucket33PointPrevBal;
	}

	/**
	 * @return the bucket33PointRedeemed
	 */
	public BigDecimal getBucket33PointRedeemed() {
		return bucket33PointRedeemed;
	}

	/**
	 * @param bucket33PointRedeemed the bucket33PointRedeemed to set
	 */
	public void setBucket33PointRedeemed(BigDecimal bucket33PointRedeemed) {
		this.bucket33PointRedeemed = bucket33PointRedeemed;
	}

	/**
	 * @return the bucket33PointSign
	 */
	public String getBucket33PointSign() {
		return bucket33PointSign;
	}

	/**
	 * @param bucket33PointSign the bucket33PointSign to set
	 */
	public void setBucket33PointSign(String bucket33PointSign) {
		this.bucket33PointSign = bucket33PointSign;
	}

	/**
	 * @return the bucket33PointBal
	 */
	public BigDecimal getBucket33PointBal() {
		return bucket33PointBal;
	}

	/**
	 * @param bucket33PointBal the bucket33PointBal to set
	 */
	public void setBucket33PointBal(BigDecimal bucket33PointBal) {
		this.bucket33PointBal = bucket33PointBal;
	}

	/**
	 * @return the bucket34PointPrevSign
	 */
	public String getBucket34PointPrevSign() {
		return bucket34PointPrevSign;
	}

	/**
	 * @param bucket34PointPrevSign the bucket34PointPrevSign to set
	 */
	public void setBucket34PointPrevSign(String bucket34PointPrevSign) {
		this.bucket34PointPrevSign = bucket34PointPrevSign;
	}

	/**
	 * @return the bucket34PointPrevBal
	 */
	public BigDecimal getBucket34PointPrevBal() {
		return bucket34PointPrevBal;
	}

	/**
	 * @param bucket34PointPrevBal the bucket34PointPrevBal to set
	 */
	public void setBucket34PointPrevBal(BigDecimal bucket34PointPrevBal) {
		this.bucket34PointPrevBal = bucket34PointPrevBal;
	}

	/**
	 * @return the bucket34PointRedeemed
	 */
	public BigDecimal getBucket34PointRedeemed() {
		return bucket34PointRedeemed;
	}

	/**
	 * @param bucket34PointRedeemed the bucket34PointRedeemed to set
	 */
	public void setBucket34PointRedeemed(BigDecimal bucket34PointRedeemed) {
		this.bucket34PointRedeemed = bucket34PointRedeemed;
	}

	/**
	 * @return the bucket34PointSign
	 */
	public String getBucket34PointSign() {
		return bucket34PointSign;
	}

	/**
	 * @param bucket34PointSign the bucket34PointSign to set
	 */
	public void setBucket34PointSign(String bucket34PointSign) {
		this.bucket34PointSign = bucket34PointSign;
	}

	/**
	 * @return the bucket34PointBal
	 */
	public BigDecimal getBucket34PointBal() {
		return bucket34PointBal;
	}

	/**
	 * @param bucket34PointBal the bucket34PointBal to set
	 */
	public void setBucket34PointBal(BigDecimal bucket34PointBal) {
		this.bucket34PointBal = bucket34PointBal;
	}

	/**
	 * @return the bucket35PointPrevSign
	 */
	public String getBucket35PointPrevSign() {
		return bucket35PointPrevSign;
	}

	/**
	 * @param bucket35PointPrevSign the bucket35PointPrevSign to set
	 */
	public void setBucket35PointPrevSign(String bucket35PointPrevSign) {
		this.bucket35PointPrevSign = bucket35PointPrevSign;
	}

	/**
	 * @return the bucket35PointPrevBal
	 */
	public BigDecimal getBucket35PointPrevBal() {
		return bucket35PointPrevBal;
	}

	/**
	 * @param bucket35PointPrevBal the bucket35PointPrevBal to set
	 */
	public void setBucket35PointPrevBal(BigDecimal bucket35PointPrevBal) {
		this.bucket35PointPrevBal = bucket35PointPrevBal;
	}

	/**
	 * @return the bucket35PointRedeemed
	 */
	public BigDecimal getBucket35PointRedeemed() {
		return bucket35PointRedeemed;
	}

	/**
	 * @param bucket35PointRedeemed the bucket35PointRedeemed to set
	 */
	public void setBucket35PointRedeemed(BigDecimal bucket35PointRedeemed) {
		this.bucket35PointRedeemed = bucket35PointRedeemed;
	}

	/**
	 * @return the bucket35PointSign
	 */
	public String getBucket35PointSign() {
		return bucket35PointSign;
	}

	/**
	 * @param bucket35PointSign the bucket35PointSign to set
	 */
	public void setBucket35PointSign(String bucket35PointSign) {
		this.bucket35PointSign = bucket35PointSign;
	}

	/**
	 * @return the bucket35PointBal
	 */
	public BigDecimal getBucket35PointBal() {
		return bucket35PointBal;
	}

	/**
	 * @param bucket35PointBal the bucket35PointBal to set
	 */
	public void setBucket35PointBal(BigDecimal bucket35PointBal) {
		this.bucket35PointBal = bucket35PointBal;
	}

	/**
	 * @return the bucket36PointPrevSign
	 */
	public String getBucket36PointPrevSign() {
		return bucket36PointPrevSign;
	}

	/**
	 * @param bucket36PointPrevSign the bucket36PointPrevSign to set
	 */
	public void setBucket36PointPrevSign(String bucket36PointPrevSign) {
		this.bucket36PointPrevSign = bucket36PointPrevSign;
	}

	/**
	 * @return the bucket36PointPrevBal
	 */
	public BigDecimal getBucket36PointPrevBal() {
		return bucket36PointPrevBal;
	}

	/**
	 * @param bucket36PointPrevBal the bucket36PointPrevBal to set
	 */
	public void setBucket36PointPrevBal(BigDecimal bucket36PointPrevBal) {
		this.bucket36PointPrevBal = bucket36PointPrevBal;
	}

	/**
	 * @return the bucket36PointRedeemed
	 */
	public BigDecimal getBucket36PointRedeemed() {
		return bucket36PointRedeemed;
	}

	/**
	 * @param bucket36PointRedeemed the bucket36PointRedeemed to set
	 */
	public void setBucket36PointRedeemed(BigDecimal bucket36PointRedeemed) {
		this.bucket36PointRedeemed = bucket36PointRedeemed;
	}

	/**
	 * @return the bucket36PointSign
	 */
	public String getBucket36PointSign() {
		return bucket36PointSign;
	}

	/**
	 * @param bucket36PointSign the bucket36PointSign to set
	 */
	public void setBucket36PointSign(String bucket36PointSign) {
		this.bucket36PointSign = bucket36PointSign;
	}

	/**
	 * @return the bucket36PointBal
	 */
	public BigDecimal getBucket36PointBal() {
		return bucket36PointBal;
	}

	/**
	 * @param bucket36PointBal the bucket36PointBal to set
	 */
	public void setBucket36PointBal(BigDecimal bucket36PointBal) {
		this.bucket36PointBal = bucket36PointBal;
	}

	/**
	 * @return the lastExpiredPointSign
	 */
	public String getLastExpiredPointSign() {
		return lastExpiredPointSign;
	}

	/**
	 * @param lastExpiredPointSign the lastExpiredPointSign to set
	 */
	public void setLastExpiredPointSign(String lastExpiredPointSign) {
		this.lastExpiredPointSign = lastExpiredPointSign;
	}

	/**
	 * @return the lastExpiredPointBal
	 */
	public BigDecimal getLastExpiredPointBal() {
		return lastExpiredPointBal;
	}

	/**
	 * @param lastExpiredPointBal the lastExpiredPointBal to set
	 */
	public void setLastExpiredPointBal(BigDecimal lastExpiredPointBal) {
		this.lastExpiredPointBal = lastExpiredPointBal;
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
	 * @return the createdDatetime
	 */
	public Timestamp getCreatedDatetime() {
		return createdDatetime;
	}

	/**
	 * @param createdDatetime the createdDatetime to set
	 */
	public void setCreatedDatetime(Timestamp createdDatetime) {
		this.createdDatetime = createdDatetime;
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
	 * @return the editedDatetime
	 */
	public Timestamp getEditedDatetime() {
		return editedDatetime;
	}

	/**
	 * @param editedDatetime the editedDatetime to set
	 */
	public void setEditedDatetime(Timestamp editedDatetime) {
		this.editedDatetime = editedDatetime;
	}
	
	

}
