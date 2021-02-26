package com.maybank.orsapp.dto;

import java.math.BigDecimal;

public class TerminalConversionDTO {

	private BigDecimal terminal_id;	
    private String tid;		
    private BigDecimal merchant_id;	
    private BigDecimal conversion_rate;
    private BigDecimal max_redeem_point;
    
	public BigDecimal getTerminal_id() {
		return terminal_id;
	}
	public void setTerminal_id(BigDecimal terminal_id) {
		this.terminal_id = terminal_id;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public BigDecimal getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(BigDecimal merchant_id) {
		this.merchant_id = merchant_id;
	}
	public BigDecimal getConversion_rate() {
		return conversion_rate;
	}
	public void setConversion_rate(BigDecimal conversion_rate) {
		this.conversion_rate = conversion_rate;
	}
	public BigDecimal getMax_redeem_point() {
		return max_redeem_point;
	}
	public void setMax_redeem_point(BigDecimal max_redeem_point) {
		this.max_redeem_point = max_redeem_point;
	}	
	
}
