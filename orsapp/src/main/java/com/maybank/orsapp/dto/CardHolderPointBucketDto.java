/**
 * 
 */
package com.maybank.orsapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 80003905
 *
 */
public class CardHolderPointBucketDto {
	
	@JsonProperty
	private String cardNo;
	
	@JsonProperty
	private String custIcNo;

	@JsonProperty
	private String cardPostFlag;
	
	@JsonProperty
	private String programCode;
	
	@JsonProperty
	private Integer pointsBal;
	
	@JsonIgnore
	private Long cardholderPointBucketId;
	
	@JsonIgnore
	private Long programId;
	
	@JsonIgnore
	private String custNo;
	
	@JsonIgnore
	private String totalPointsSign;
	
	@JsonIgnore
	private String programDesc;

	/**
	 * 
	 */
	public CardHolderPointBucketDto() {
		
	}
	
	/**
	 * @param custIcNo
	 */
	public CardHolderPointBucketDto(String custIcNo) {
		this.custIcNo = custIcNo;
	}

	/**
	 * @param custIcNo
	 * @param programId
	 */
	public CardHolderPointBucketDto(String custIcNo, Long programId) {
		this.custIcNo = custIcNo;
		this.programId = programId;
	}

	/**
	 * @param cardholderPointBucketId
	 * @param cardNo
	 * @param custIcNo
	 * @param cardPostFlag
	 * @param programCode
	 * @param transformedTotalPointsBal
	 * @param custNo
	 * @param totalPointsSign
	 * @param programDesc
	 */
	public CardHolderPointBucketDto(Long cardholderPointBucketId, String cardNo, String custIcNo, String cardPostFlag,
			String programCode, Integer transformedTotalPointsBal, String custNo, String totalPointsSign,
			String programDesc) {
		this.cardholderPointBucketId = cardholderPointBucketId;
		this.cardNo = cardNo;
		this.custIcNo = custIcNo;
		this.cardPostFlag = (cardPostFlag.equalsIgnoreCase("XX"))? "PP":cardPostFlag;
		this.programCode = programCode;
		this.pointsBal = (totalPointsSign.equalsIgnoreCase("-"))?Integer.parseInt(totalPointsSign.concat(String.valueOf(transformedTotalPointsBal))):transformedTotalPointsBal;
		this.custNo = custNo;
		this.totalPointsSign = totalPointsSign;
		this.programDesc = programCode.concat(" - ").concat(programDesc);
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
	 * @return the custIcNo
	 */
	public String getCustIcNo() {
		return custIcNo;
	}

	/**
	 * @param custIcNo the custIcNo to set
	 */
	public void setCustIcNo(String custIcNo) {
		this.custIcNo = custIcNo;
	}

	/**
	 * @return the cardPostFlag
	 */
	public String getCardPostFlag() {
		return cardPostFlag;
	}

	/**
	 * @param cardPostFlag the cardPostFlag to set
	 */
	public void setCardPostFlag(String cardPostFlag) {
		this.cardPostFlag = cardPostFlag;
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
	 * @return the transformedTotalPointsBal
	 */
	public Integer getPointsBal() {
		return pointsBal;
	}

	/**
	 * @param transformedTotalPointsBal the transformedTotalPointsBal to set
	 */
	public void setPointsBal(Integer pointsBal) {
		this.pointsBal = pointsBal;
	}

	/**
	 * @return the cardholderPointBucketId
	 */
	public Long getCardholderPointBucketId() {
		return cardholderPointBucketId;
	}

	/**
	 * @param cardholderPointBucketId the cardholderPointBucketId to set
	 */
	public void setCardholderPointBucketId(Long cardholderPointBucketId) {
		this.cardholderPointBucketId = cardholderPointBucketId;
	}
	
	/**
	 * @return the programId
	 */
	public Long getProgramId() {
		return programId;
	}

	/**
	 * @param programId the programId to set
	 */
	public void setProgramId(Long programId) {
		this.programId = programId;
	}

	/**
	 * @return the custNo
	 */
	public String getCustNo() {
		return custNo;
	}

	/**
	 * @param custNo the custNo to set
	 */
	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}

	/**
	 * @return the totalPointsSign
	 */
	public String getTotalPointsSign() {
		return totalPointsSign;
	}

	/**
	 * @param totalPointsSign the totalPointsSign to set
	 */
	public void setTotalPointsSign(String totalPointsSign) {
		this.totalPointsSign = totalPointsSign;
	}

	/**
	 * @return the programDesc
	 */
	public String getProgramDesc() {
		return programDesc;
	}

	/**
	 * @param programDesc the programDesc to set
	 */
	public void setProgramDesc(String programDesc) {
		this.programDesc = programDesc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardNo == null) ? 0 : cardNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof CardHolderPointBucketDto))
			return false;
		CardHolderPointBucketDto other = (CardHolderPointBucketDto) obj;
		if (cardNo == null) {
			if (other.cardNo != null)
				return false;
		} else if (!cardNo.equals(other.cardNo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CardHolderPointBucketDto [cardNo=" + cardNo + ", custIcNo=" + custIcNo + ", cardPostFlag="
				+ cardPostFlag + ", programCode=" + programCode + "]";
	}
	
}
