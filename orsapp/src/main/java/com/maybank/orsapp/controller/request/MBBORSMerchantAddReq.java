package com.maybank.orsapp.controller.request;

import java.math.BigDecimal;

public class MBBORSMerchantAddReq {
	
	private String mid;
	
	private String merchant_name;	
	
	private String store_no;
	
	private String store_name;	
	
	private String tier_rate_code;	
	
	private BigDecimal conversion_rate;	
	
	private BigDecimal global_max_redeem_point;	
	
	private BigDecimal global_instant_reward_percentage;
			
	public String getMid() {
		return mid;
	}
	
	public void setMid(String mid) {
		this.mid = mid;
	}

	public void setTier_rate_code(String tier_rate_code) {
		this.tier_rate_code = tier_rate_code;
	}

	public String getMerchant_name() {
		return merchant_name;
	}

	public void setMerchant_name(String merchant_name) {
		this.merchant_name = merchant_name;
	}

	public String getStore_no() {
		return store_no;
	}

	public void setStore_no(String store_no) {
		this.store_no = store_no;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public String getTier_rate_code() {
		return tier_rate_code;
	}

	public void setTier_rate_id(String tier_rate_code) {
		this.tier_rate_code = tier_rate_code;
	}

	public BigDecimal getConversion_rate() {
		return conversion_rate;
	}

	public void setConversion_rate(BigDecimal conversion_rate) {
		this.conversion_rate = conversion_rate;
	}

	public BigDecimal getGlobal_max_redeem_point() {
		return global_max_redeem_point;
	}

	public void setGlobal_max_redeem_point(BigDecimal global_max_redeem_point) {
		this.global_max_redeem_point = global_max_redeem_point;
	}

	public BigDecimal getGlobal_instant_reward_percentage() {
		return global_instant_reward_percentage;
	}

	public void setGlobal_instant_reward_percentage(BigDecimal global_instant_reward_percentage) {
		this.global_instant_reward_percentage = global_instant_reward_percentage;
	}

}
