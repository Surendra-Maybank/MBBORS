package com.maybank.orsapp.dto;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MerchantDetailDTO {
	
	private BigDecimal merchant_id;
	
	private String mid;
	
	private String merchant_name;	
	
	private String store_no;
	
	private String store_name;	
	
	private BigDecimal tier_rate_id;
	
	private String tier_rate_code;	
	
	private String tier_rate_desc;	
	
	private BigDecimal conversion_rate;	
	
	private boolean is_auto_payment;
	
	private BigDecimal global_max_redeem_point;	
	
	private BigDecimal global_instant_reward_percentage;
	
    private String global_receipt_hdr_1;
    
    private String global_receipt_hdr_2;
    
    private String global_receipt_hdr_3;
    
    private String global_receipt_ftr_1;
    
    private String global_receipt_ftr_2;
    
    private String global_receipt_ftr_3;
    
    private boolean global_is_point_inquiry;
    
    private boolean global_is_instant_reward;
    
    private boolean global_is_point_redemption;
    
    private boolean global_is_value_redemption;
    
    private boolean global_is_gift_code_redemption;
    
    private boolean global_is_hot_deal_redemption;
    
    private boolean global_is_void_redemption;
    
    private boolean global_is_encryption;
	
    private String status_desc;
    
	private String created_by;	
	
	private String created_datetime;	
	
	private String edited_by;	
	
	private String edited_datetime;

	public MerchantDetailDTO() {}
	
	public MerchantDetailDTO(
			BigDecimal merchant_id,
			String mid,
			String merchant_name,	
			String store_no,
			String store_name,	
			BigDecimal tier_rate_id,
			String tier_rate_code,	
			String tier_rate_desc,
			BigDecimal conversion_rate,	
			boolean is_auto_payment,
			BigDecimal global_max_redeem_point,	
			BigDecimal global_instant_reward_percentage,
			String status_desc,
			String created_by,	
			Date created_datetime,	
			String edited_by,	
			Date edited_datetime,
			String global_receipt_hdr_1,
		    String global_receipt_hdr_2,
		    String global_receipt_hdr_3,
		    String global_receipt_ftr_1,
		    String global_receipt_ftr_2,
		    String global_receipt_ftr_3,		 
			boolean global_is_point_inquiry,
			boolean global_is_instant_reward,
			boolean global_is_point_redemption,
			boolean global_is_value_redemption,
			boolean global_is_gift_code_redemption,
			boolean global_is_hot_deal_redemption,
			boolean global_is_void_redemption,
			boolean global_is_encryption
			) {
		this.merchant_id=merchant_id;
		this.mid=mid;
		this.merchant_name = merchant_name;
		this.store_no = store_no;
		this.store_name = store_name;
		this.tier_rate_id = tier_rate_id;
		this.tier_rate_code = tier_rate_code;	
		this.tier_rate_desc = tier_rate_desc;
		this.conversion_rate = conversion_rate;	
		this.is_auto_payment = is_auto_payment;
		this.global_max_redeem_point = global_max_redeem_point;	
		this.global_instant_reward_percentage = global_instant_reward_percentage;
		this.global_receipt_hdr_1 = global_receipt_hdr_1;
		this.global_receipt_hdr_2 = global_receipt_hdr_2;
		this.global_receipt_hdr_3 = global_receipt_hdr_3;
		this.global_receipt_ftr_1 = global_receipt_ftr_1;
		this.global_receipt_ftr_2 = global_receipt_ftr_2;
		this.global_receipt_ftr_3 = global_receipt_ftr_3;
		this.status_desc = status_desc;
		this.created_by = created_by;	
		this.created_datetime =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(created_datetime);	
		this.edited_by = edited_by;	
		this.edited_datetime =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(edited_datetime);
		this.global_is_point_inquiry = global_is_point_inquiry;
		this.global_is_instant_reward = global_is_instant_reward;
		this.global_is_point_redemption = global_is_point_redemption;
		this.global_is_value_redemption = global_is_value_redemption;
		this.global_is_gift_code_redemption = global_is_gift_code_redemption;
		this.global_is_hot_deal_redemption = global_is_hot_deal_redemption;
		this.global_is_void_redemption = global_is_void_redemption;
		this.global_is_encryption = global_is_encryption;	
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

	public String getEdited_by() {
		return edited_by;
	}

	public void setEdited_by(String edited_by) {
		this.edited_by = edited_by;
	}

	public boolean getIs_auto_payment() {
		return is_auto_payment;
	}

	public void setIs_auto_payment(boolean is_auto_payment) {
		this.is_auto_payment = is_auto_payment;
	}

	public String getGlobal_receipt_hdr_1() {
		return global_receipt_hdr_1;
	}

	public void setGlobal_receipt_hdr_1(String global_receipt_hdr_1) {
		this.global_receipt_hdr_1 = global_receipt_hdr_1;
	}

	public String getGlobal_receipt_hdr_2() {
		return global_receipt_hdr_2;
	}

	public void setGlobal_receipt_hdr_2(String global_receipt_hdr_2) {
		this.global_receipt_hdr_2 = global_receipt_hdr_2;
	}

	public String getGlobal_receipt_hdr_3() {
		return global_receipt_hdr_3;
	}

	public void setGlobal_receipt_hdr_3(String global_receipt_hdr_3) {
		this.global_receipt_hdr_3 = global_receipt_hdr_3;
	}

	public String getGlobal_receipt_ftr_1() {
		return global_receipt_ftr_1;
	}

	public void setGlobal_receipt_ftr_1(String global_receipt_ftr_1) {
		this.global_receipt_ftr_1 = global_receipt_ftr_1;
	}

	public String getGlobal_receipt_ftr_2() {
		return global_receipt_ftr_2;
	}

	public void setGlobal_receipt_ftr_2(String global_receipt_ftr_2) {
		this.global_receipt_ftr_2 = global_receipt_ftr_2;
	}

	public String getGlobal_receipt_ftr_3() {
		return global_receipt_ftr_3;
	}

	public void setGlobal_receipt_ftr_3(String global_receipt_ftr_3) {
		this.global_receipt_ftr_3 = global_receipt_ftr_3;
	}

	public boolean getGlobal_is_point_inquiry() {
		return global_is_point_inquiry;
	}

	public void setGlobal_is_point_inquiry(boolean global_is_point_inquiry) {
		this.global_is_point_inquiry = global_is_point_inquiry;
	}

	public boolean getGlobal_is_instant_reward() {
		return global_is_instant_reward;
	}

	public void setGlobal_is_instant_reward(boolean global_is_instant_reward) {
		this.global_is_instant_reward = global_is_instant_reward;
	}

	public boolean getGlobal_is_point_redemption() {
		return global_is_point_redemption;
	}

	public void setGlobal_is_point_redemption(boolean global_is_point_redemption) {
		this.global_is_point_redemption = global_is_point_redemption;
	}

	public boolean getGlobal_is_value_redemption() {
		return global_is_value_redemption;
	}

	public void setGlobal_is_value_redemption(boolean global_is_value_redemption) {
		this.global_is_value_redemption = global_is_value_redemption;
	}

	public boolean getGlobal_is_gift_code_redemption() {
		return global_is_gift_code_redemption;
	}

	public void setGlobal_is_gift_code_redemption(boolean global_is_gift_code_redemption) {
		this.global_is_gift_code_redemption = global_is_gift_code_redemption;
	}

	public boolean getGlobal_is_hot_deal_redemption() {
		return global_is_hot_deal_redemption;
	}

	public void setGlobal_is_hot_deal_redemption(boolean global_is_hot_deal_redemption) {
		this.global_is_hot_deal_redemption = global_is_hot_deal_redemption;
	}

	public boolean getGlobal_is_void_redemption() {
		return global_is_void_redemption;
	}

	public void setGlobal_is_void_redemption(boolean global_is_void_redemption) {
		this.global_is_void_redemption = global_is_void_redemption;
	}

	public boolean getGlobal_is_encryption() {
		return global_is_encryption;
	}

	public void setGlobal_is_encryption(boolean global_is_encryption) {
		this.global_is_encryption = global_is_encryption;
	}

	public String getCreated_datetime() {
		return created_datetime;
	}

	public void setCreated_datetime(String created_datetime) {
		this.created_datetime = created_datetime;
	}

	public String getEdited_datetime() {
		return edited_datetime;
	}

	public void setEdited_datetime(String edited_datetime) {
		this.edited_datetime = edited_datetime;
	}

	public String getStatus_desc() {
		return status_desc;
	}

	public void setStatus_desc(String status_desc) {
		this.status_desc = status_desc;
	}

	public BigDecimal getTier_rate_id() {
		return tier_rate_id;
	}

	public void setTier_rate_id(BigDecimal tier_rate_id) {
		this.tier_rate_id = tier_rate_id;
	}

	public String getTier_rate_desc() {
		return tier_rate_desc;
	}

	public void setTier_rate_desc(String tier_rate_desc) {
		this.tier_rate_desc = tier_rate_desc;
	}
	
}
