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
import javax.persistence.Table;

/**
 * @author 80003905
 *
 */

@Entity
@Table(name = "mt_CARDHOLDER_POINT_BUCKET")
public class CardHolderPointBucket implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1431355124468118087L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CARDHOLDER_POINT_BUCKET_ID", unique=true, nullable=false)
	private Long cardholderPointBucketId;

	@Column(name="BUCKET01_POINT_BAL", precision=15, scale=2)
	private BigDecimal bucket01PointBal;

	@Column(name="BUCKET01_POINT_SIGN")
	private String bucket01PointSign;

	@Column(name="BUCKET02_POINT_BAL", precision=15, scale=2)
	private BigDecimal bucket02PointBal;

	@Column(name="BUCKET02_POINT_SIGN")
	private String bucket02PointSign;

	@Column(name="BUCKET03_POINT_BAL", precision=15, scale=2)
	private BigDecimal bucket03PointBal;

	@Column(name="BUCKET03_POINT_SIGN")
	private String bucket03PointSign;

	@Column(name="BUCKET04_POINT_BAL", precision=15, scale=2)
	private BigDecimal bucket04PointBal;

	@Column(name="BUCKET04_POINT_SIGN")
	private String bucket04PointSign;

	@Column(name="BUCKET05_POINT_BAL", precision=15, scale=2)
	private BigDecimal bucket05PointBal;

	@Column(name="BUCKET05_POINT_SIGN")
	private String bucket05PointSign;

	@Column(name="BUCKET06_POINT_BAL", precision=15, scale=2)
	private BigDecimal bucket06PointBal;

	@Column(name="BUCKET06_POINT_SIGN")
	private String bucket06PointSign;

	@Column(name="BUCKET07_POINT_BAL", precision=15, scale=2)
	private BigDecimal bucket07PointBal;

	@Column(name="BUCKET07_POINT_SIGN")
	private String bucket07PointSign;

	@Column(name="BUCKET08_POINT_BAL", precision=15, scale=2)
	private BigDecimal bucket08PointBal;

	@Column(name="BUCKET08_POINT_SIGN")
	private String bucket08PointSign;

	@Column(name="BUCKET09_POINT_BAL", precision=15, scale=2)
	private BigDecimal bucket09PointBal;

	@Column(name="BUCKET09_POINT_SIGN")
	private String bucket09PointSign;

	@Column(name="BUCKET10_POINT_BAL", precision=15, scale=2)
	private BigDecimal bucket10PointBal;

	@Column(name="BUCKET10_POINT_SIGN")
	private String bucket10PointSign;

	@Column(name="BUCKET11_POINT_BAL", precision=15, scale=2)
	private BigDecimal bucket11PointBal;

	@Column(name="BUCKET11_POINT_SIGN")
	private String bucket11PointSign;

	@Column(name="BUCKET12_POINT_BAL", precision=15, scale=2)
	private BigDecimal bucket12PointBal;

	@Column(name="BUCKET12_POINT_SIGN")
	private String bucket12PointSign;

	@Column(name="BUCKET13_POINT_BAL", precision=15, scale=2)
	private BigDecimal bucket13PointBal;

	@Column(name="BUCKET13_POINT_SIGN")
	private String bucket13PointSign;

	@Column(name="BUCKET14_POINT_BAL", precision=15, scale=2)
	private BigDecimal bucket14PointBal;

	@Column(name="BUCKET14_POINT_SIGN")
	private String bucket14PointSign;

	@Column(name="BUCKET15_POINT_BAL", precision=15, scale=2)
	private BigDecimal bucket15PointBal;

	@Column(name="BUCKET15_POINT_SIGN")
	private String bucket15PointSign;

	@Column(name="BUCKET16_POINT_BAL", precision=15, scale=2)
	private BigDecimal bucket16PointBal;

	@Column(name="BUCKET16_POINT_SIGN")
	private String bucket16PointSign;

	@Column(name="BUCKET17_POINT_BAL", precision=15, scale=2)
	private BigDecimal bucket17PointBal;

	@Column(name="BUCKET17_POINT_SIGN")
	private String bucket17PointSign;

	@Column(name="BUCKET18_POINT_BAL", precision=15, scale=2)
	private BigDecimal bucket18PointBal;

	@Column(name="BUCKET18_POINT_SIGN")
	private String bucket18PointSign;

	@Column(name="BUCKET19_POINT_BAL", precision=15, scale=2)
	private BigDecimal bucket19PointBal;

	@Column(name="BUCKET19_POINT_SIGN")
	private String bucket19PointSign;

	@Column(name="BUCKET20_POINT_BAL", precision=15, scale=2)
	private BigDecimal bucket20PointBal;

	@Column(name="BUCKET20_POINT_SIGN")
	private String bucket20PointSign;

	@Column(name="BUCKET21_POINT_BAL", precision=15, scale=2)
	private BigDecimal bucket21PointBal;

	@Column(name="BUCKET21_POINT_SIGN")
	private String bucket21PointSign;

	@Column(name="BUCKET22_POINT_BAL", precision=15, scale=2)
	private BigDecimal bucket22PointBal;

	@Column(name="BUCKET22_POINT_SIGN")
	private String bucket22PointSign;

	@Column(name="BUCKET23_POINT_BAL", precision=15, scale=2)
	private BigDecimal bucket23PointBal;

	@Column(name="BUCKET23_POINT_SIGN")
	private String bucket23PointSign;

	@Column(name="BUCKET24_POINT_BAL", precision=15, scale=2)
	private BigDecimal bucket24PointBal;

	@Column(name="BUCKET24_POINT_SIGN")
	private String bucket24PointSign;

	@Column(name="BUCKET25_POINT_BAL", precision=15, scale=2)
	private BigDecimal bucket25PointBal;

	@Column(name="BUCKET25_POINT_SIGN")
	private String bucket25PointSign;

	@Column(name="BUCKET26_POINT_BAL", precision=15, scale=2)
	private BigDecimal bucket26PointBal;

	@Column(name="BUCKET26_POINT_SIGN")
	private String bucket26PointSign;

	@Column(name="BUCKET27_POINT_BAL", precision=15, scale=2)
	private BigDecimal bucket27PointBal;

	@Column(name="BUCKET27_POINT_SIGN")
	private String bucket27PointSign;

	@Column(name="BUCKET28_POINT_BAL", precision=15, scale=2)
	private BigDecimal bucket28PointBal;

	@Column(name="BUCKET28_POINT_SIGN")
	private String bucket28PointSign;

	@Column(name="BUCKET29_POINT_BAL", precision=15, scale=2)
	private BigDecimal bucket29PointBal;

	@Column(name="BUCKET29_POINT_SIGN")
	private String bucket29PointSign;

	@Column(name="BUCKET30_POINT_BAL", precision=15, scale=2)
	private BigDecimal bucket30PointBal;

	@Column(name="BUCKET30_POINT_SIGN")
	private String bucket30PointSign;

	@Column(name="BUCKET31_POINT_BAL", precision=15, scale=2)
	private BigDecimal bucket31PointBal;

	@Column(name="BUCKET31_POINT_SIGN")
	private String bucket31PointSign;

	@Column(name="BUCKET32_POINT_BAL", precision=15, scale=2)
	private BigDecimal bucket32PointBal;

	@Column(name="BUCKET32_POINT_SIGN")
	private String bucket32PointSign;

	@Column(name="BUCKET33_POINT_BAL", precision=15, scale=2)
	private BigDecimal bucket33PointBal;

	@Column(name="BUCKET33_POINT_SIGN")
	private String bucket33PointSign;

	@Column(name="BUCKET34_POINT_BAL", precision=15, scale=2)
	private BigDecimal bucket34PointBal;

	@Column(name="BUCKET34_POINT_SIGN")
	private String bucket34PointSign;

	@Column(name="BUCKET35_POINT_BAL", precision=15, scale=2)
	private BigDecimal bucket35PointBal;

	@Column(name="BUCKET35_POINT_SIGN")
	private String bucket35PointSign;

	@Column(name="BUCKET36_POINT_BAL", precision=15, scale=2)
	private BigDecimal bucket36PointBal;

	@Column(name="BUCKET36_POINT_SIGN")
	private String bucket36PointSign;

	@Column(name="CARD_EXP_DATE")
	private String cardExpDate;

	@Column(name="CARD_NO")
	private String cardNo;

	@Column(name="CARD_POST_FLAG")
	private String cardPostFlag;

	@Column(name="CARD_TYPE")
	private String cardType;

	@Column(name="CREATED_BY", nullable=false)
	private String createdBy;

	@Column(name="CREATED_DATETIME", nullable=false)
	private Timestamp createdDatetime;

	@Column(name="CUST_IC_NO")
	private String custIcNo;

	@Column(name="CUST_NO")
	private String custNo;

	@Column(name="EDITED_BY", nullable=false)
	private String editedBy;

	@Column(name="EDITED_DATETIME", nullable=false)
	private Timestamp editedDatetime;

	@Column(name="LAST_EXPIRED_POINT_BAL", precision=15, scale=2)
	private BigDecimal lastExpiredPointBal;

	@Column(name="LAST_EXPIRED_POINT_SIGN")
	private String lastExpiredPointSign;

	@Column(name="LOYALTY_ID")
	private String loyaltyId;

	@Column(name="ORG_NO")
	private String orgNo;

	@Column(name="POINT", precision=15, scale=2)
	private BigDecimal point;

	@Column(name="POINT_SIGN")
	private String pointSign;

	@Column(name="PROGRAM_ID")
	private Long programId;

	@Column(name="STATUS_ID", nullable=false)
	private Integer statusId;

	@Column(name="TOTAL_POINTS_BAL", precision=15, scale=2)
	private BigDecimal totalPointsBal;

	@Column(name="TOTAL_POINTS_SIGN")
	private String totalPointsSign;

	@Column(name="TRANSFORMED_TOTAL_POINTS_BAL")
	private Integer transformedTotalPointsBal;

	public Long getCardholderPointBucketId() {
		return this.cardholderPointBucketId;
	}

	public void setCardholderPointBucketId(Long cardholderPointBucketId) {
		this.cardholderPointBucketId = cardholderPointBucketId;
	}

	public BigDecimal getBucket01PointBal() {
		return this.bucket01PointBal;
	}

	public void setBucket01PointBal(BigDecimal bucket01PointBal) {
		this.bucket01PointBal = bucket01PointBal;
	}

	public String getBucket01PointSign() {
		return this.bucket01PointSign;
	}

	public void setBucket01PointSign(String bucket01PointSign) {
		this.bucket01PointSign = bucket01PointSign;
	}

	public BigDecimal getBucket02PointBal() {
		return this.bucket02PointBal;
	}

	public void setBucket02PointBal(BigDecimal bucket02PointBal) {
		this.bucket02PointBal = bucket02PointBal;
	}

	public String getBucket02PointSign() {
		return this.bucket02PointSign;
	}

	public void setBucket02PointSign(String bucket02PointSign) {
		this.bucket02PointSign = bucket02PointSign;
	}

	public BigDecimal getBucket03PointBal() {
		return this.bucket03PointBal;
	}

	public void setBucket03PointBal(BigDecimal bucket03PointBal) {
		this.bucket03PointBal = bucket03PointBal;
	}

	public String getBucket03PointSign() {
		return this.bucket03PointSign;
	}

	public void setBucket03PointSign(String bucket03PointSign) {
		this.bucket03PointSign = bucket03PointSign;
	}

	public BigDecimal getBucket04PointBal() {
		return this.bucket04PointBal;
	}

	public void setBucket04PointBal(BigDecimal bucket04PointBal) {
		this.bucket04PointBal = bucket04PointBal;
	}

	public String getBucket04PointSign() {
		return this.bucket04PointSign;
	}

	public void setBucket04PointSign(String bucket04PointSign) {
		this.bucket04PointSign = bucket04PointSign;
	}

	public BigDecimal getBucket05PointBal() {
		return this.bucket05PointBal;
	}

	public void setBucket05PointBal(BigDecimal bucket05PointBal) {
		this.bucket05PointBal = bucket05PointBal;
	}

	public String getBucket05PointSign() {
		return this.bucket05PointSign;
	}

	public void setBucket05PointSign(String bucket05PointSign) {
		this.bucket05PointSign = bucket05PointSign;
	}

	public BigDecimal getBucket06PointBal() {
		return this.bucket06PointBal;
	}

	public void setBucket06PointBal(BigDecimal bucket06PointBal) {
		this.bucket06PointBal = bucket06PointBal;
	}

	public String getBucket06PointSign() {
		return this.bucket06PointSign;
	}

	public void setBucket06PointSign(String bucket06PointSign) {
		this.bucket06PointSign = bucket06PointSign;
	}

	public BigDecimal getBucket07PointBal() {
		return this.bucket07PointBal;
	}

	public void setBucket07PointBal(BigDecimal bucket07PointBal) {
		this.bucket07PointBal = bucket07PointBal;
	}

	public String getBucket07PointSign() {
		return this.bucket07PointSign;
	}

	public void setBucket07PointSign(String bucket07PointSign) {
		this.bucket07PointSign = bucket07PointSign;
	}

	public BigDecimal getBucket08PointBal() {
		return this.bucket08PointBal;
	}

	public void setBucket08PointBal(BigDecimal bucket08PointBal) {
		this.bucket08PointBal = bucket08PointBal;
	}

	public String getBucket08PointSign() {
		return this.bucket08PointSign;
	}

	public void setBucket08PointSign(String bucket08PointSign) {
		this.bucket08PointSign = bucket08PointSign;
	}

	public BigDecimal getBucket09PointBal() {
		return this.bucket09PointBal;
	}

	public void setBucket09PointBal(BigDecimal bucket09PointBal) {
		this.bucket09PointBal = bucket09PointBal;
	}

	public String getBucket09PointSign() {
		return this.bucket09PointSign;
	}

	public void setBucket09PointSign(String bucket09PointSign) {
		this.bucket09PointSign = bucket09PointSign;
	}

	public BigDecimal getBucket10PointBal() {
		return this.bucket10PointBal;
	}

	public void setBucket10PointBal(BigDecimal bucket10PointBal) {
		this.bucket10PointBal = bucket10PointBal;
	}

	public String getBucket10PointSign() {
		return this.bucket10PointSign;
	}

	public void setBucket10PointSign(String bucket10PointSign) {
		this.bucket10PointSign = bucket10PointSign;
	}

	public BigDecimal getBucket11PointBal() {
		return this.bucket11PointBal;
	}

	public void setBucket11PointBal(BigDecimal bucket11PointBal) {
		this.bucket11PointBal = bucket11PointBal;
	}

	public String getBucket11PointSign() {
		return this.bucket11PointSign;
	}

	public void setBucket11PointSign(String bucket11PointSign) {
		this.bucket11PointSign = bucket11PointSign;
	}

	public BigDecimal getBucket12PointBal() {
		return this.bucket12PointBal;
	}

	public void setBucket12PointBal(BigDecimal bucket12PointBal) {
		this.bucket12PointBal = bucket12PointBal;
	}

	public String getBucket12PointSign() {
		return this.bucket12PointSign;
	}

	public void setBucket12PointSign(String bucket12PointSign) {
		this.bucket12PointSign = bucket12PointSign;
	}

	public BigDecimal getBucket13PointBal() {
		return this.bucket13PointBal;
	}

	public void setBucket13PointBal(BigDecimal bucket13PointBal) {
		this.bucket13PointBal = bucket13PointBal;
	}

	public String getBucket13PointSign() {
		return this.bucket13PointSign;
	}

	public void setBucket13PointSign(String bucket13PointSign) {
		this.bucket13PointSign = bucket13PointSign;
	}

	public BigDecimal getBucket14PointBal() {
		return this.bucket14PointBal;
	}

	public void setBucket14PointBal(BigDecimal bucket14PointBal) {
		this.bucket14PointBal = bucket14PointBal;
	}

	public String getBucket14PointSign() {
		return this.bucket14PointSign;
	}

	public void setBucket14PointSign(String bucket14PointSign) {
		this.bucket14PointSign = bucket14PointSign;
	}

	public BigDecimal getBucket15PointBal() {
		return this.bucket15PointBal;
	}

	public void setBucket15PointBal(BigDecimal bucket15PointBal) {
		this.bucket15PointBal = bucket15PointBal;
	}

	public String getBucket15PointSign() {
		return this.bucket15PointSign;
	}

	public void setBucket15PointSign(String bucket15PointSign) {
		this.bucket15PointSign = bucket15PointSign;
	}

	public BigDecimal getBucket16PointBal() {
		return this.bucket16PointBal;
	}

	public void setBucket16PointBal(BigDecimal bucket16PointBal) {
		this.bucket16PointBal = bucket16PointBal;
	}

	public String getBucket16PointSign() {
		return this.bucket16PointSign;
	}

	public void setBucket16PointSign(String bucket16PointSign) {
		this.bucket16PointSign = bucket16PointSign;
	}

	public BigDecimal getBucket17PointBal() {
		return this.bucket17PointBal;
	}

	public void setBucket17PointBal(BigDecimal bucket17PointBal) {
		this.bucket17PointBal = bucket17PointBal;
	}

	public String getBucket17PointSign() {
		return this.bucket17PointSign;
	}

	public void setBucket17PointSign(String bucket17PointSign) {
		this.bucket17PointSign = bucket17PointSign;
	}

	public BigDecimal getBucket18PointBal() {
		return this.bucket18PointBal;
	}

	public void setBucket18PointBal(BigDecimal bucket18PointBal) {
		this.bucket18PointBal = bucket18PointBal;
	}

	public String getBucket18PointSign() {
		return this.bucket18PointSign;
	}

	public void setBucket18PointSign(String bucket18PointSign) {
		this.bucket18PointSign = bucket18PointSign;
	}

	public BigDecimal getBucket19PointBal() {
		return this.bucket19PointBal;
	}

	public void setBucket19PointBal(BigDecimal bucket19PointBal) {
		this.bucket19PointBal = bucket19PointBal;
	}

	public String getBucket19PointSign() {
		return this.bucket19PointSign;
	}

	public void setBucket19PointSign(String bucket19PointSign) {
		this.bucket19PointSign = bucket19PointSign;
	}

	public BigDecimal getBucket20PointBal() {
		return this.bucket20PointBal;
	}

	public void setBucket20PointBal(BigDecimal bucket20PointBal) {
		this.bucket20PointBal = bucket20PointBal;
	}

	public String getBucket20PointSign() {
		return this.bucket20PointSign;
	}

	public void setBucket20PointSign(String bucket20PointSign) {
		this.bucket20PointSign = bucket20PointSign;
	}

	public BigDecimal getBucket21PointBal() {
		return this.bucket21PointBal;
	}

	public void setBucket21PointBal(BigDecimal bucket21PointBal) {
		this.bucket21PointBal = bucket21PointBal;
	}

	public String getBucket21PointSign() {
		return this.bucket21PointSign;
	}

	public void setBucket21PointSign(String bucket21PointSign) {
		this.bucket21PointSign = bucket21PointSign;
	}

	public BigDecimal getBucket22PointBal() {
		return this.bucket22PointBal;
	}

	public void setBucket22PointBal(BigDecimal bucket22PointBal) {
		this.bucket22PointBal = bucket22PointBal;
	}

	public String getBucket22PointSign() {
		return this.bucket22PointSign;
	}

	public void setBucket22PointSign(String bucket22PointSign) {
		this.bucket22PointSign = bucket22PointSign;
	}

	public BigDecimal getBucket23PointBal() {
		return this.bucket23PointBal;
	}

	public void setBucket23PointBal(BigDecimal bucket23PointBal) {
		this.bucket23PointBal = bucket23PointBal;
	}

	public String getBucket23PointSign() {
		return this.bucket23PointSign;
	}

	public void setBucket23PointSign(String bucket23PointSign) {
		this.bucket23PointSign = bucket23PointSign;
	}

	public BigDecimal getBucket24PointBal() {
		return this.bucket24PointBal;
	}

	public void setBucket24PointBal(BigDecimal bucket24PointBal) {
		this.bucket24PointBal = bucket24PointBal;
	}

	public String getBucket24PointSign() {
		return this.bucket24PointSign;
	}

	public void setBucket24PointSign(String bucket24PointSign) {
		this.bucket24PointSign = bucket24PointSign;
	}

	public BigDecimal getBucket25PointBal() {
		return this.bucket25PointBal;
	}

	public void setBucket25PointBal(BigDecimal bucket25PointBal) {
		this.bucket25PointBal = bucket25PointBal;
	}

	public String getBucket25PointSign() {
		return this.bucket25PointSign;
	}

	public void setBucket25PointSign(String bucket25PointSign) {
		this.bucket25PointSign = bucket25PointSign;
	}

	public BigDecimal getBucket26PointBal() {
		return this.bucket26PointBal;
	}

	public void setBucket26PointBal(BigDecimal bucket26PointBal) {
		this.bucket26PointBal = bucket26PointBal;
	}

	public String getBucket26PointSign() {
		return this.bucket26PointSign;
	}

	public void setBucket26PointSign(String bucket26PointSign) {
		this.bucket26PointSign = bucket26PointSign;
	}

	public BigDecimal getBucket27PointBal() {
		return this.bucket27PointBal;
	}

	public void setBucket27PointBal(BigDecimal bucket27PointBal) {
		this.bucket27PointBal = bucket27PointBal;
	}

	public String getBucket27PointSign() {
		return this.bucket27PointSign;
	}

	public void setBucket27PointSign(String bucket27PointSign) {
		this.bucket27PointSign = bucket27PointSign;
	}

	public BigDecimal getBucket28PointBal() {
		return this.bucket28PointBal;
	}

	public void setBucket28PointBal(BigDecimal bucket28PointBal) {
		this.bucket28PointBal = bucket28PointBal;
	}

	public String getBucket28PointSign() {
		return this.bucket28PointSign;
	}

	public void setBucket28PointSign(String bucket28PointSign) {
		this.bucket28PointSign = bucket28PointSign;
	}

	public BigDecimal getBucket29PointBal() {
		return this.bucket29PointBal;
	}

	public void setBucket29PointBal(BigDecimal bucket29PointBal) {
		this.bucket29PointBal = bucket29PointBal;
	}

	public String getBucket29PointSign() {
		return this.bucket29PointSign;
	}

	public void setBucket29PointSign(String bucket29PointSign) {
		this.bucket29PointSign = bucket29PointSign;
	}

	public BigDecimal getBucket30PointBal() {
		return this.bucket30PointBal;
	}

	public void setBucket30PointBal(BigDecimal bucket30PointBal) {
		this.bucket30PointBal = bucket30PointBal;
	}

	public String getBucket30PointSign() {
		return this.bucket30PointSign;
	}

	public void setBucket30PointSign(String bucket30PointSign) {
		this.bucket30PointSign = bucket30PointSign;
	}

	public BigDecimal getBucket31PointBal() {
		return this.bucket31PointBal;
	}

	public void setBucket31PointBal(BigDecimal bucket31PointBal) {
		this.bucket31PointBal = bucket31PointBal;
	}

	public String getBucket31PointSign() {
		return this.bucket31PointSign;
	}

	public void setBucket31PointSign(String bucket31PointSign) {
		this.bucket31PointSign = bucket31PointSign;
	}

	public BigDecimal getBucket32PointBal() {
		return this.bucket32PointBal;
	}

	public void setBucket32PointBal(BigDecimal bucket32PointBal) {
		this.bucket32PointBal = bucket32PointBal;
	}

	public String getBucket32PointSign() {
		return this.bucket32PointSign;
	}

	public void setBucket32PointSign(String bucket32PointSign) {
		this.bucket32PointSign = bucket32PointSign;
	}

	public BigDecimal getBucket33PointBal() {
		return this.bucket33PointBal;
	}

	public void setBucket33PointBal(BigDecimal bucket33PointBal) {
		this.bucket33PointBal = bucket33PointBal;
	}

	public String getBucket33PointSign() {
		return this.bucket33PointSign;
	}

	public void setBucket33PointSign(String bucket33PointSign) {
		this.bucket33PointSign = bucket33PointSign;
	}

	public BigDecimal getBucket34PointBal() {
		return this.bucket34PointBal;
	}

	public void setBucket34PointBal(BigDecimal bucket34PointBal) {
		this.bucket34PointBal = bucket34PointBal;
	}

	public String getBucket34PointSign() {
		return this.bucket34PointSign;
	}

	public void setBucket34PointSign(String bucket34PointSign) {
		this.bucket34PointSign = bucket34PointSign;
	}

	public BigDecimal getBucket35PointBal() {
		return this.bucket35PointBal;
	}

	public void setBucket35PointBal(BigDecimal bucket35PointBal) {
		this.bucket35PointBal = bucket35PointBal;
	}

	public String getBucket35PointSign() {
		return this.bucket35PointSign;
	}

	public void setBucket35PointSign(String bucket35PointSign) {
		this.bucket35PointSign = bucket35PointSign;
	}

	public BigDecimal getBucket36PointBal() {
		return this.bucket36PointBal;
	}

	public void setBucket36PointBal(BigDecimal bucket36PointBal) {
		this.bucket36PointBal = bucket36PointBal;
	}

	public String getBucket36PointSign() {
		return this.bucket36PointSign;
	}

	public void setBucket36PointSign(String bucket36PointSign) {
		this.bucket36PointSign = bucket36PointSign;
	}

	public String getCardExpDate() {
		return this.cardExpDate;
	}

	public void setCardExpDate(String cardExpDate) {
		this.cardExpDate = cardExpDate;
	}

	public String getCardNo() {
		return this.cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCardPostFlag() {
		return this.cardPostFlag;
	}

	public void setCardPostFlag(String cardPostFlag) {
		this.cardPostFlag = cardPostFlag;
	}

	public String getCardType() {
		return this.cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDatetime() {
		return this.createdDatetime;
	}

	public void setCreatedDatetime(Timestamp createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	public String getCustIcNo() {
		return this.custIcNo;
	}

	public void setCustIcNo(String custIcNo) {
		this.custIcNo = custIcNo;
	}

	public String getCustNo() {
		return this.custNo;
	}

	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}

	public String getEditedBy() {
		return this.editedBy;
	}

	public void setEditedBy(String editedBy) {
		this.editedBy = editedBy;
	}

	public Timestamp getEditedDatetime() {
		return this.editedDatetime;
	}

	public void setEditedDatetime(Timestamp editedDatetime) {
		this.editedDatetime = editedDatetime;
	}

	public BigDecimal getLastExpiredPointBal() {
		return this.lastExpiredPointBal;
	}

	public void setLastExpiredPointBal(BigDecimal lastExpiredPointBal) {
		this.lastExpiredPointBal = lastExpiredPointBal;
	}

	public String getLastExpiredPointSign() {
		return this.lastExpiredPointSign;
	}

	public void setLastExpiredPointSign(String lastExpiredPointSign) {
		this.lastExpiredPointSign = lastExpiredPointSign;
	}

	public String getLoyaltyId() {
		return this.loyaltyId;
	}

	public void setLoyaltyId(String loyaltyId) {
		this.loyaltyId = loyaltyId;
	}

	public String getOrgNo() {
		return this.orgNo;
	}

	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}

	public BigDecimal getPoint() {
		return this.point;
	}

	public void setPoint(BigDecimal point) {
		this.point = point;
	}

	public String getPointSign() {
		return this.pointSign;
	}

	public void setPointSign(String pointSign) {
		this.pointSign = pointSign;
	}

	public Long getProgramId() {
		return this.programId;
	}

	public void setProgramId(Long programId) {
		this.programId = programId;
	}

	public Integer getStatusId() {
		return this.statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public BigDecimal getTotalPointsBal() {
		return this.totalPointsBal;
	}

	public void setTotalPointsBal(BigDecimal totalPointsBal) {
		this.totalPointsBal = totalPointsBal;
	}

	public String getTotalPointsSign() {
		return this.totalPointsSign;
	}

	public void setTotalPointsSign(String totalPointsSign) {
		this.totalPointsSign = totalPointsSign;
	}

	public Integer getTransformedTotalPointsBal() {
		return this.transformedTotalPointsBal;
	}

	public void setTransformedTotalPointsBal(Integer transformedTotalPointsBal) {
		this.transformedTotalPointsBal = transformedTotalPointsBal;
	}
}
