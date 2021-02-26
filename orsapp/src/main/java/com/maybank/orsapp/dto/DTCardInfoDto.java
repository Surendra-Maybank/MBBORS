/**
 * 
 */
package com.maybank.orsapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 80003905
 *
 */
public class DTCardInfoDto {

    @JsonProperty
    protected String cardNo;
    
    @JsonProperty
    protected String icno;
    
    @JsonProperty
    protected String postingFlag;
    
    @JsonProperty
    protected String programID;
    
    @JsonProperty
    protected String programDesc;
    
    @JsonProperty
    protected Double pointsBal;
    
    @JsonProperty
    protected String pointSign;

    /**
     * Gets the value of the cardNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * Sets the value of the cardNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    /**
     * Gets the value of the icno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIcno() {
        return icno;
    }

    /**
     * Sets the value of the icno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIcno(String value) {
        this.icno = value;
    }

    /**
     * Gets the value of the postingFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostingFlag() {
        return postingFlag;
    }

    /**
     * Sets the value of the postingFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostingFlag(String value) {
        this.postingFlag = value;
    }

    /**
     * Gets the value of the programID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgramID() {
        return programID;
    }

    /**
     * Sets the value of the programID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgramID(String value) {
        this.programID = value;
    }

	/**
	 * @return the pointsBal
	 */
	public Double getPointsBal() {
		return pointsBal;
	}

	/**
	 * @param pointsBal the pointsBal to set
	 */
	public void setPointsBal(Double pointsBal) {
		this.pointsBal = pointsBal;
	}

	@Override
	public String toString() {
		return "DTCardInfoDto [cardNo=" + cardNo + ", icno=" + icno + ", postingFlag=" + postingFlag + ", programID="
				+ programID + ", pointsBal=" + pointsBal + "]";
	}
    
}

