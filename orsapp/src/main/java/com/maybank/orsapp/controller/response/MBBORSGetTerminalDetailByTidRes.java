package com.maybank.orsapp.controller.response;

import java.math.BigDecimal;

public class MBBORSGetTerminalDetailByTidRes extends MBBORSCommonRes {
	
	private String tid;		
    private String mid;	
    private BigDecimal max_redeem_point;	
    private String is_inherit;
    private BigDecimal instant_reward_percentage;
    private BigDecimal conversion_rate;

    private String receipt_hdr_1;	
    private String receipt_hdr_2;
    private String receipt_hdr_3;	
	
    private String receipt_ftr_1;	
    private String receipt_ftr_2;	
    private String receipt_ftr_3;	
    
    private BigDecimal tier_rate_id;
    private String tier_rate_code;
    private String tier_rate_desc;
    
    private String is_point_inquiry;
    private String is_instant_reward;
    private String is_point_redemption;	
    private String is_value_redemption;
    private String is_gift_code_redemption;
    private String is_hot_deal_redemption;	
    private String is_void_redemption;
    private String is_encryption;
	private int status_id;
	private String created_by;
	private String created_datetime;
	private String edited_by;
	private String edited_datetime;
	
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public BigDecimal getMax_redeem_point() {
		return max_redeem_point;
	}
	public void setMax_redeem_point(BigDecimal max_redeem_point) {
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
	public int getStatus_id() {
		return status_id;
	}
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
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
	public String getIs_encryption() {
		return is_encryption;
	}
	public void setIs_encryption(String is_encryption) {
		this.is_encryption = is_encryption;
	}
	public BigDecimal getTier_rate_id() {
		return tier_rate_id;
	}
	public void setTier_rate_id(BigDecimal tier_rate_id) {
		this.tier_rate_id = tier_rate_id;
	}
	public String getTier_rate_code() {
		return tier_rate_code;
	}
	public void setTier_rate_code(String tier_rate_code) {
		this.tier_rate_code = tier_rate_code;
	}
	public String getTier_rate_desc() {
		return tier_rate_desc;
	}
	public void setTier_rate_desc(String tier_rate_desc) {
		this.tier_rate_desc = tier_rate_desc;
	}
	public BigDecimal getInstant_reward_percentage() {
		return instant_reward_percentage;
	}
	public void setInstant_reward_percentage(BigDecimal instant_reward_percentage) {
		this.instant_reward_percentage = instant_reward_percentage;
	}	
	public String getIs_inherit() {
		return is_inherit;
	}
	public void setIs_inherit(String is_inherit) {
		this.is_inherit = is_inherit;
	}
	public BigDecimal getConversion_rate() {
		return conversion_rate;
	}
	public void setConversion_rate(BigDecimal conversion_rate) {
		this.conversion_rate = conversion_rate;
	}
	
	public String toString() {
		
		return "[MBBORSGetTerminalDetailByTidRes : {"
				+"responseCode=".concat(this.getResponseCode())
//			    private String mid;	
				+",responseMessage=".concat(this.getResponseMessage())
				+",tid=".concat(tid==null?"":tid)
//			    private String mid;	
				+",mid=".concat(mid==null?"":mid)
//			    private BigDecimal max_redeem_point;	
				+",max_redeem_point=".concat(max_redeem_point==null?"":max_redeem_point.toPlainString())
//			    private String receipt_hdr_1;	
				+",receipt_hdr_1=".concat(receipt_hdr_1==null?"":receipt_hdr_1)
//			    private String receipt_hdr_2;
				+",receipt_hdr_2=".concat(receipt_hdr_2==null?"":receipt_hdr_2)
//			    private String receipt_hdr_3;
				+",receipt_hdr_3=".concat(receipt_hdr_3==null?"":receipt_hdr_3)
//			    private String receipt_ftr_1;	
				+",receipt_ftr_1=".concat(receipt_ftr_1==null?"":receipt_ftr_1)
//			    private String receipt_ftr_2;	
				+",receipt_ftr_2=".concat(receipt_ftr_2==null?"":receipt_ftr_2)
//			    private String receipt_ftr_3;
				+",receipt_ftr_3=".concat(receipt_ftr_3==null?"":receipt_ftr_3)
//			    private String is_point_inquiry;
				+",is_point_inquiry=".concat(is_point_inquiry==null?"":is_point_inquiry)
//			    private String is_instant_reward;
				+",is_instant_reward=".concat(is_instant_reward==null?"":is_instant_reward)
//			    private String is_point_redemption;	
				+",is_point_redemption=".concat(is_point_redemption==null?"":is_point_redemption)
//			    private String is_value_redemption;
				+",is_value_redemption=".concat(is_value_redemption==null?"":is_value_redemption)
//			    private String is_gift_code_redemption;
				+",is_gift_code_redemption=".concat(is_gift_code_redemption==null?"":is_gift_code_redemption)
//			    private String is_hot_deal_redemption;	
				+",is_hot_deal_redemption=".concat(is_hot_deal_redemption==null?"":is_hot_deal_redemption)
//			    private String is_void_redemption;
				+",is_void_redemption=".concat(is_void_redemption==null?"":is_void_redemption)
//			    private String is_encryption;
				+",is_encryption=".concat(is_encryption==null?"":is_encryption)
//				private int status_id;
				+",status_id=".concat(Integer.toString(status_id))
//				private String created_by;
				+",created_by=".concat(created_by==null?"":created_by)
//				private String created_datetime;
				+",created_datetime=".concat(created_datetime==null?"":created_datetime)
//				private String edited_by;
				+",edited_by=".concat(edited_by==null?"":edited_by)
//				private String edited_datetime;
				+",edited_datetime=".concat(edited_datetime==null?"":edited_datetime)				
				+ "}"
				+ "}]";
	}
}
