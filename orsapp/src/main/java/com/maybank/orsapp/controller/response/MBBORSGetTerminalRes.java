package com.maybank.orsapp.controller.response;

public class MBBORSGetTerminalRes {
	
    private String tid;		
    private String merchant_id;	
    private String max_redeem_point;			

	private String receipt_hdr_1;	
    private String receipt_hdr_2;
    private String receipt_hdr_3;	
	
	private String receipt_ftr_1;	
    private String receipt_ftr_2;	
    private String receipt_ftr_3;				
    
	private String is_point_inquiry;
    private String is_instant_reward;
    private String is_point_redemption;	
    private String is_value_redemption;
    private String is_gift_code_redemption;
    private String is_hot_deal_redemption;	
    private String is_void_redemption;
    private String is_encryption;
    
    private String code;
    
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(String merchant_id) {
		this.merchant_id = merchant_id;
	}
	public String getMax_redeem_point() {
		return max_redeem_point;
	}
	public void setMax_redeem_point(String max_redeem_point) {
		this.max_redeem_point = max_redeem_point;
	}
	public String getReceipt_hdr_1() {
		return receipt_hdr_1;
	}
	public void setReceipt_hdr_1(String receipt_hdr_1) {
		this.receipt_hdr_1 = receipt_hdr_1;
	}
	public String getReceipt_hdr_2() {
		return receipt_hdr_2;
	}
	public void setReceipt_hdr_2(String receipt_hdr_2) {
		this.receipt_hdr_2 = receipt_hdr_2;
	}
	public String getReceipt_hdr_3() {
		return receipt_hdr_3;
	}
	public void setReceipt_hdr_3(String receipt_hdr_3) {
		this.receipt_hdr_3 = receipt_hdr_3;
	}
	public String getReceipt_ftr_1() {
		return receipt_ftr_1;
	}
	public void setReceipt_ftr_1(String receipt_ftr_1) {
		this.receipt_ftr_1 = receipt_ftr_1;
	}
	public String getReceipt_ftr_2() {
		return receipt_ftr_2;
	}
	public void setReceipt_ftr_2(String receipt_ftr_2) {
		this.receipt_ftr_2 = receipt_ftr_2;
	}
	public String getReceipt_ftr_3() {
		return receipt_ftr_3;
	}
	public void setReceipt_ftr_3(String receipt_ftr_3) {
		this.receipt_ftr_3 = receipt_ftr_3;
	}
	public String getIs_point_inquiry() {
		return is_point_inquiry;
	}
	public void setIs_point_inquiry(String is_point_inquiry) {
		this.is_point_inquiry = is_point_inquiry;
	}
	public String getIs_instant_reward() {
		return is_instant_reward;
	}
	public void setIs_instant_reward(String is_instant_reward) {
		this.is_instant_reward = is_instant_reward;
	}
	public String getIs_point_redemption() {
		return is_point_redemption;
	}
	public void setIs_point_redemption(String is_point_redemption) {
		this.is_point_redemption = is_point_redemption;
	}
	public String getIs_value_redemption() {
		return is_value_redemption;
	}
	public void setIs_value_redemption(String is_value_redemption) {
		this.is_value_redemption = is_value_redemption;
	}
	public String getIs_gift_code_redemption() {
		return is_gift_code_redemption;
	}
	public void setIs_gift_code_redemption(String is_gift_code_redemption) {
		this.is_gift_code_redemption = is_gift_code_redemption;
	}
	public String getIs_hot_deal_redemption() {
		return is_hot_deal_redemption;
	}
	public void setIs_hot_deal_redemption(String is_hot_deal_redemption) {
		this.is_hot_deal_redemption = is_hot_deal_redemption;
	}
	public String getIs_void_redemption() {
		return is_void_redemption;
	}
	public void setIs_void_redemption(String is_void_redemption) {
		this.is_void_redemption = is_void_redemption;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getIs_encryption() {
		return is_encryption;
	}
	public void setIs_encryption(String is_encryption) {
		this.is_encryption = is_encryption;
	}
}
