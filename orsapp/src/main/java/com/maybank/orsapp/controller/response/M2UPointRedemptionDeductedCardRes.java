package com.maybank.orsapp.controller.response;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class M2UPointRedemptionDeductedCardRes {

	@JsonProperty("Card_PAN")
	private String card_PAN;
	@JsonProperty("Icno")
	private String icno;
	@JsonProperty("Prev_Pts_Bal")
	private BigDecimal prev_Pts_Bal;
	@JsonProperty("New_Pts_Bal")
	private BigDecimal new_Pts_Bal;
	@JsonProperty("Pts_Deducted")
	private BigDecimal pts_Deducted;
	@JsonProperty("Posting_Flag")
	private String posting_Flag;
	@JsonProperty("Program_Id")
	private String program_Id;
	
	public String getCard_PAN() {
		return card_PAN;
	}
	public void setCard_PAN(String card_PAN) {
		this.card_PAN = card_PAN;
	}
	public String getIcno() {
		return icno;
	}
	public void setIcno(String icno) {
		this.icno = icno;
	}
	public BigDecimal getPrev_Pts_Bal() {
		return prev_Pts_Bal;
	}
	public void setPrev_Pts_Bal(BigDecimal prev_Pts_Bal) {
		this.prev_Pts_Bal = prev_Pts_Bal;
	}
	public BigDecimal getNew_Pts_Bal() {
		return new_Pts_Bal;
	}
	public void setNew_Pts_Bal(BigDecimal new_Pts_Bal) {
		this.new_Pts_Bal = new_Pts_Bal;
	}
	public BigDecimal getPts_Deducted() {
		return pts_Deducted;
	}
	public void setPts_Deducted(BigDecimal pts_Deducted) {
		this.pts_Deducted = pts_Deducted;
	}
	public String getPosting_Flag() {
		return posting_Flag;
	}
	public void setPosting_Flag(String posting_Flag) {
		this.posting_Flag = posting_Flag;
	}
	public String getProgram_Id() {
		return program_Id;
	}
	public void setProgram_Id(String program_Id) {
		this.program_Id = program_Id;
	}
	
}
