package com.maybank.orsapp.dto;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MerchantAllDTO{

private BigDecimal merchant_id;
	
	private String mid;
	
	private String merchant_name;	
	
	private String store_no;
	
	private String store_name;	
	
	private String tier_rate_desc;	
	
	private BigDecimal conversion_rate;	
	
//	private BigDecimal global_max_redeem_point;	
//	
//	private BigDecimal global_instant_reward_percentage;
	
	private String created_by;	
	
	private String created_datetime;	
	
	private String edited_by;	
	
	private String edited_datetime;

	public MerchantAllDTO() {}
	
	public MerchantAllDTO(
			BigDecimal merchant_id,
			String mid,
			String merchant_name,
			String store_no,
			String store_name,
			String tier_rate_desc, 
			BigDecimal conversion_rate,
//			BigDecimal global_max_redeem_point,
//			BigDecimal global_instant_reward_percentage,
			String created_by,
			Date created_datetime,
			String edited_by,
			Date edited_datetime) {
		this.merchant_id = merchant_id;
		this.mid = mid;
		this.merchant_name = merchant_name;
		this.store_no = store_no;
		this.store_name = store_name;
		this.tier_rate_desc = tier_rate_desc;
		this.conversion_rate = conversion_rate;
//		this.global_max_redeem_point = global_max_redeem_point;
//		this.global_instant_reward_percentage = global_instant_reward_percentage;
		this.created_by = created_by;
		this.created_datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(created_datetime);
		this.edited_by = edited_by;
		this.edited_datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(edited_datetime);
		
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

	public BigDecimal getConversion_rate() {
		return conversion_rate;
	}

	public void setConversion_rate(BigDecimal conversion_rate) {
		this.conversion_rate = conversion_rate;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getCreated_datetime() {
		return created_datetime;
	}

	public void setCreated_datetime(String created_datetime) {
		this.created_datetime = created_datetime;
	}

	public String getEdited_by() {
		return edited_by;
	}

	public void setEdited_by(String edited_by) {
		this.edited_by = edited_by;
	}

	public String getEdited_datetime() {
		return edited_datetime;
	}

	public void setEdited_datetime(String edited_datetime) {
		this.edited_datetime = edited_datetime;
	}

	public String getTier_rate_desc() {
		return tier_rate_desc;
	}

	public void setTier_rate_desc(String tier_rate_desc) {
		this.tier_rate_desc = tier_rate_desc;
	}

}
