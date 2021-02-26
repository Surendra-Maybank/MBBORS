package com.maybank.orsapp.controller.request;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

public class MBBORSInsertNewTerminalReq {
		
	@JsonProperty("TIDs")
	private List<InsertNewTerminalReq> TIDs;
	private String merchant_id;
	private String tier_rate_id;
	private String conversion_rate;
	private String is_inherit;
	private String max_redeem_point;			
	private String instant_reward_percentage;

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
	
	public List<InsertNewTerminalReq> getTIDs() {
		return TIDs;
	}
	public void setTIDs(List<InsertNewTerminalReq> tIDs) {
		TIDs = tIDs;
	}
	public String getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(String merchant_id) {
		this.merchant_id = merchant_id;
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
	public String getIs_inherit() {
		return is_inherit;
	}
	public void setIs_inherit(String is_inherit) {
		this.is_inherit = is_inherit;
	}
	public String getMax_redeem_point() {
		return max_redeem_point;
	}
	public void setMax_redeem_point(String max_redeem_point) {
		this.max_redeem_point = max_redeem_point;
	}
	public String getInstant_reward_percentage() {
		return instant_reward_percentage;
	}
	public void setInstant_reward_percentage(String instant_reward_percentage) {
		this.instant_reward_percentage = instant_reward_percentage;
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
	public String getIs_encryption() {
		return is_encryption;
	}
	public void setIs_encryption(String is_encryption) {
		this.is_encryption = is_encryption;
	}

	public String toString() {
		
		String msg = "";
		
		if(TIDs!=null&&TIDs.size()>0) {
			for(int ind=0;ind<TIDs.size();ind++) {
				if(ind==(TIDs.size()-1)) {
					msg=msg.concat(TIDs.get(ind).toString());
				}else{
					msg=msg.concat(TIDs.get(ind).toString()).concat(",");
				}
			}
		}
		
		return "MBBORSInsertNewTerminalReq :{"
//		private List<InsertNewTerminalReq> TIDs;
			+ "TIDs=".concat(msg)
//		private String merchant_id;
			+ "merchant_id=".concat((merchant_id==null?"":merchant_id))
//		private String tier_rate_id;
			+ "tier_rate_id=".concat((tier_rate_id==null?"":tier_rate_id))
//		private String conversion_rate;
			+ "conversion_rate=".concat((conversion_rate==null?"":conversion_rate))
//		private String is_inherit;
			+ "is_inherit=".concat((is_inherit==null?"":is_inherit))
//		private String max_redeem_point;
			+ "max_redeem_point=".concat((max_redeem_point==null?"":max_redeem_point))
//		private String instant_reward_percentage;
			+ "instant_reward_percentage=".concat((instant_reward_percentage==null?"":instant_reward_percentage))
//		private String receipt_hdr_1;	
			+ "receipt_hdr_1=".concat((receipt_hdr_1==null?"":receipt_hdr_1))
//		private String receipt_hdr_2;
			+ "receipt_hdr_2=".concat((receipt_hdr_2==null?"":receipt_hdr_2))
//		private String receipt_hdr_3;	
			+ "receipt_hdr_3=".concat((receipt_hdr_3==null?"":receipt_hdr_3))
//		private String receipt_ftr_1;	
			+ "receipt_ftr_1=".concat((receipt_ftr_1==null?"":receipt_ftr_1))
//		private String receipt_ftr_2;	
			+ "receipt_ftr_2=".concat((receipt_ftr_2==null?"":receipt_ftr_2))
//		private String receipt_ftr_3;				
			+ "receipt_ftr_3=".concat((receipt_ftr_3==null?"":receipt_ftr_3))
//		private String is_point_inquiry;
			+ "is_point_inquiry=".concat((is_point_inquiry==null?"":is_point_inquiry))
//		private String is_instant_reward;
			+ "is_instant_reward=".concat((is_instant_reward==null?"":is_instant_reward))
//		private String is_point_redemption;	
			+ "is_point_redemption=".concat((is_point_redemption==null?"":is_point_redemption))
//		private String is_value_redemption;
			+ "is_value_redemption=".concat((is_value_redemption==null?"":is_value_redemption))
//		private String is_gift_code_redemption;
			+ "is_gift_code_redemption=".concat((is_gift_code_redemption==null?"":is_gift_code_redemption))
//		private String is_hot_deal_redemption;	
			+ "is_hot_deal_redemption=".concat((is_hot_deal_redemption==null?"":is_hot_deal_redemption))
//		private String is_void_redemption;
			+ "is_void_redemption=".concat((is_void_redemption==null?"":is_void_redemption))
//		private String is_encryption;
			+ "is_encryption=".concat((is_encryption==null?"":is_encryption))
			+ "}";
	}
}
