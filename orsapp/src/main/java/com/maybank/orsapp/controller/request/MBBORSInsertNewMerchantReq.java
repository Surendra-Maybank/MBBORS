package com.maybank.orsapp.controller.request;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

public class MBBORSInsertNewMerchantReq {
	
	private String mid;
	
	private String merchant_name;	
	
	private String store_no;
	
	private String store_name;	
	
	private String tier_rate_id;	
	
	private String conversion_rate;	
	
	private String is_auto_payment;
	
	private String global_max_redeem_point;	
	
	private String global_instant_reward_percentage;
	
    private String global_receipt_hdr_1;
    
    private String global_receipt_hdr_2;
    
    private String global_receipt_hdr_3;
    
    private String global_receipt_ftr_1;
    
    private String global_receipt_ftr_2;
    
    private String global_receipt_ftr_3;
    
    private String global_is_point_inquiry;
    
    private String global_is_instant_reward;
    
    private String global_is_point_redemption;
    
    private String global_is_value_redemption;
    
    private String global_is_gift_code_redemption;
    
    private String global_is_hot_deal_redemption;
    
    private String global_is_void_redemption;
    
    private String global_is_encryption;
    
    @JsonProperty("tids")
	private List<InsertNewMerchantTidReq> tid;

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

	public List<InsertNewMerchantTidReq> getTid() {
		return tid;
	}

	public void setTid(List<InsertNewMerchantTidReq> tid) {
		this.tid = tid;
	}

	public String getTier_rate_id() {
		return tier_rate_id;
	}

	public void setTier_rate_id(String tier_rate_id) {
		this.tier_rate_id = tier_rate_id;
	}

	public String getConversion_rate() {
		return conversion_rate;
	}

	public void setConversion_rate(String conversion_rate) {
		this.conversion_rate = conversion_rate;
	}

	public String getIs_auto_payment() {
		return is_auto_payment;
	}

	public void setIs_auto_payment(String is_auto_payment) {
		this.is_auto_payment = is_auto_payment;
	}

	public String getGlobal_max_redeem_point() {
		return global_max_redeem_point;
	}

	public void setGlobal_max_redeem_point(String global_max_redeem_point) {
		this.global_max_redeem_point = global_max_redeem_point;
	}

	public String getGlobal_instant_reward_percentage() {
		return global_instant_reward_percentage;
	}

	public void setGlobal_instant_reward_percentage(String global_instant_reward_percentage) {
		this.global_instant_reward_percentage = global_instant_reward_percentage;
	}

	public String getGlobal_is_point_inquiry() {
		return global_is_point_inquiry;
	}

	public void setGlobal_is_point_inquiry(String global_is_point_inquiry) {
		this.global_is_point_inquiry = global_is_point_inquiry;
	}

	public String getGlobal_is_instant_reward() {
		return global_is_instant_reward;
	}

	public void setGlobal_is_instant_reward(String global_is_instant_reward) {
		this.global_is_instant_reward = global_is_instant_reward;
	}

	public String getGlobal_is_point_redemption() {
		return global_is_point_redemption;
	}

	public void setGlobal_is_point_redemption(String global_is_point_redemption) {
		this.global_is_point_redemption = global_is_point_redemption;
	}

	public String getGlobal_is_value_redemption() {
		return global_is_value_redemption;
	}

	public void setGlobal_is_value_redemption(String global_is_value_redemption) {
		this.global_is_value_redemption = global_is_value_redemption;
	}

	public String getGlobal_is_gift_code_redemption() {
		return global_is_gift_code_redemption;
	}

	public void setGlobal_is_gift_code_redemption(String global_is_gift_code_redemption) {
		this.global_is_gift_code_redemption = global_is_gift_code_redemption;
	}

	public String getGlobal_is_hot_deal_redemption() {
		return global_is_hot_deal_redemption;
	}

	public void setGlobal_is_hot_deal_redemption(String global_is_hot_deal_redemption) {
		this.global_is_hot_deal_redemption = global_is_hot_deal_redemption;
	}

	public String getGlobal_is_void_redemption() {
		return global_is_void_redemption;
	}

	public void setGlobal_is_void_redemption(String global_is_void_redemption) {
		this.global_is_void_redemption = global_is_void_redemption;
	}

	public String getGlobal_is_encryption() {
		return global_is_encryption;
	}

	public void setGlobal_is_encryption(String global_is_encryption) {
		this.global_is_encryption = global_is_encryption;
	}
	
}
