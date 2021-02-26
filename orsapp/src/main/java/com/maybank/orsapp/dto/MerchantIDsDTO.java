package com.maybank.orsapp.dto;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MerchantIDsDTO{

	private BigDecimal merchant_id;
	
	private String mid;

	public MerchantIDsDTO() {}
	
	public MerchantIDsDTO(
			BigDecimal merchant_id,
			String mid
			) {
		this.merchant_id = merchant_id;
		this.mid = mid;	
	}

	public BigDecimal getMerchant_id() {
		return merchant_id;
	}

	public void setMerchant_id(BigDecimal merchant_id) {
		this.merchant_id = merchant_id;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

}
