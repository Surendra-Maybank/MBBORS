package com.maybank.orsapp.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MerchantDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7979762123820915606L;

	private String merchant_id;
	
	private String mid;
	
	private String merchant_name;	
	
	private String store_no;
	
	private String store_name;	
	
	private String tier_rate_code;	
	
	private BigDecimal conversion_rate;	
	
	private BigDecimal global_max_redeem_point;	
	
	private BigDecimal global_instant_reward_percentage;
	
	private String created_by;	
	
	private Date created_datetime;	
	
	private String edited_by;	
	
	private Date edited_datetime;

	public MerchantDTO() {}
	
	/**
	 * @param merchant_id
	 * @param mid
	 * @param merchant_name
	 */
	public MerchantDTO(BigDecimal merchant_id, String mid, String merchant_name) {
		this.merchant_id = merchant_id.toString();
		this.mid = mid;
		this.merchant_name = merchant_name;
	}

	/**
	 * 
	 * @param merchant_id
	 * @param mid
	 * @param merchant_name
	 * @param store_no
	 * @param store_name
	 * @param tier_rate_code
	 * @param conversion_rate
	 * @param global_max_redeem_point
	 * @param global_instant_reward_percentage
	 * @param created_by
	 * @param created_datetime
	 * @param edited_by
	 * @param edited_datetime
	 */
	public MerchantDTO(
			String merchant_id,
			String mid,
			String merchant_name,
			String store_no,
			String store_name,
			String tier_rate_code, 
			BigDecimal conversion_rate,
			BigDecimal global_max_redeem_point,
			BigDecimal global_instant_reward_percentage,
			String created_by,
			Date created_datetime,
			String edited_by,
			Date edited_datetime) {
		this.merchant_id = merchant_id;
		this.mid = mid;
		this.merchant_name = merchant_name;
		this.store_no = store_no;
		this.store_name = store_name;
		this.tier_rate_code = tier_rate_code;
		this.conversion_rate = conversion_rate;
		this.global_max_redeem_point = global_max_redeem_point;
		this.global_instant_reward_percentage = global_instant_reward_percentage;
		this.created_by = created_by;
		this.created_datetime = created_datetime;
		this.edited_by = edited_by;
		this.edited_datetime = edited_datetime;
		
	}
	
	public String getMerchant_id() {
		return merchant_id;
	}

	public void setMerchant_id(String merchant_id) {
		this.merchant_id = merchant_id;
	}

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

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public Date getCreated_datetime() {
		return created_datetime;
	}

	public void setCreated_datetime(Date created_datetime) {
		this.created_datetime = created_datetime;
	}

	public String getEdited_by() {
		return edited_by;
	}

	public void setEdited_by(String edited_by) {
		this.edited_by = edited_by;
	}

	public Date getEdited_datetime() {
		return edited_datetime;
	}

	public void setEdited_datetime(Date edited_datetime) {
		this.edited_datetime = edited_datetime;
	}

}
