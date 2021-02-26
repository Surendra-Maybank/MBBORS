package com.maybank.orsapp.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mt_MERCHANT")
public class Merchant {

	@Id
	@Column(name="MERCHANT_ID", nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigDecimal merchant_id;		
	
	@Column(name="MID", nullable=false)
	private String mid;		
	
	@Column(name="MERCHANT_NAME", nullable=true)
	private String merchant_name;	
	
	@Column(name="STORE_NO", nullable=true)
	private String store_no;
	
	@Column(name="STORE_NAME", nullable=true)
	private String store_name;	
	
	@Column(name="TIER_RATE_ID", nullable=true)
	private int tier_rate_id;	
	
	@Column(name="CONVERSION_RATE", nullable=true)
	private BigDecimal conversion_rate;	
	
	@Column(name="IS_AUTO_PAYMENT", nullable=true)
	private boolean is_auto_payment;	
	
	@Column(name="GLOBAL_MAX_REDEEM_POINT", nullable=true)
	private BigDecimal global_max_redeem_point;	
	
	@Column(name="GLOBAL_INSTANT_REWARD_PERCENTAGE", nullable=true)
	private BigDecimal global_instant_reward_percentage;
	
	@Column(name="GLOBAL_RECEIPT_HDR_1", nullable=true)
	private String global_receipt_hdr_1;
	
	@Column(name="GLOBAL_RECEIPT_HDR_2", nullable=true)
	private String global_receipt_hdr_2;
	
	@Column(name="GLOBAL_RECEIPT_HDR_3", nullable=true)
	private String global_receipt_hdr_3;
	
	@Column(name="GLOBAL_RECEIPT_FTR_1", nullable=true)
	private String global_receipt_ftr_1;
	
	@Column(name="GLOBAL_RECEIPT_FTR_2", nullable=true)
	private String global_receipt_ftr_2;	
	
	@Column(name="GLOBAL_RECEIPT_FTR_3", nullable=true)
	private String global_receipt_ftr_3;	
	
	@Column(name="GLOBAL_IS_POINT_INQUIRY", nullable=true)
	private boolean global_is_point_inquiry;	
	
	@Column(name="GLOBAL_IS_INSTANT_REWARD", nullable=true)
	private boolean global_is_instant_reward;	
	
	@Column(name="GLOBAL_IS_POINT_REDEMPTION", nullable=true)
	private boolean global_is_point_redemption;	
	
	@Column(name="GLOBAL_IS_VALUE_REDEMPTION", nullable=true)
	private boolean global_is_value_redemption;		
	
	@Column(name="GLOBAL_IS_GIFT_CODE_REDEMPTION", nullable=true)
	private boolean global_is_gift_code_redemption;	
	
	@Column(name="GLOBAL_IS_HOT_DEAL_REDEMPTION", nullable=true)
	private boolean global_is_hot_deal_redemption;	
	
	@Column(name="GLOBAL_IS_VOID_REDEMPTION", nullable=true)
	private boolean global_is_void_redemption;	
	
	@Column(name="GLOBAL_IS_ENCRYPTION", nullable=true)
	private boolean global_is_encryption;	
	
	@Column(name="STATUS_ID", nullable=true)
	private int status_id;		
	
	@Column(name="CREATED_BY", nullable=true)
	private String created_by;	
	
	@Column(name="CREATED_DATETIME", nullable=true)
	private Timestamp created_datetime;	
	
	@Column(name="EDITED_BY", nullable=true)
	private String edited_by;	
	
	@Column(name="EDITED_DATETIME", nullable=true)
	private Timestamp edited_datetime;
	
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
	public int getTier_rate_id() {
		return tier_rate_id;
	}
	public void setTier_rate_id(int tier_rate_id) {
		this.tier_rate_id = tier_rate_id;
	}
	public BigDecimal getConversion_rate() {
		return conversion_rate;
	}
	public void setConversion_rate(BigDecimal conversion_rate) {
		this.conversion_rate = conversion_rate;
	}
	public boolean isIs_auto_payment() {
		return is_auto_payment;
	}
	public void setIs_auto_payment(boolean is_auto_payment) {
		this.is_auto_payment = is_auto_payment;
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
	public boolean isGlobal_is_point_inquiry() {
		return global_is_point_inquiry;
	}
	public void setGlobal_is_point_inquiry(boolean global_is_point_inquiry) {
		this.global_is_point_inquiry = global_is_point_inquiry;
	}
	public boolean isGlobal_is_instant_reward() {
		return global_is_instant_reward;
	}
	public void setGlobal_is_instant_reward(boolean global_is_instant_reward) {
		this.global_is_instant_reward = global_is_instant_reward;
	}
	public boolean isGlobal_is_point_redemption() {
		return global_is_point_redemption;
	}
	public void setGlobal_is_point_redemption(boolean global_is_point_redemption) {
		this.global_is_point_redemption = global_is_point_redemption;
	}
	public boolean isGlobal_is_value_redemption() {
		return global_is_value_redemption;
	}
	public void setGlobal_is_value_redemption(boolean global_is_value_redemption) {
		this.global_is_value_redemption = global_is_value_redemption;
	}
	public boolean isGlobal_is_gift_code_redemption() {
		return global_is_gift_code_redemption;
	}
	public void setGlobal_is_gift_code_redemption(boolean global_is_gift_code_redemption) {
		this.global_is_gift_code_redemption = global_is_gift_code_redemption;
	}
	public boolean isGlobal_is_hot_deal_redemption() {
		return global_is_hot_deal_redemption;
	}
	public void setGlobal_is_hot_deal_redemption(boolean global_is_hot_deal_redemption) {
		this.global_is_hot_deal_redemption = global_is_hot_deal_redemption;
	}
	public boolean isGlobal_is_void_redemption() {
		return global_is_void_redemption;
	}
	public void setGlobal_is_void_redemption(boolean global_is_void_redemption) {
		this.global_is_void_redemption = global_is_void_redemption;
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
	public Timestamp getCreated_datetime() {
		return created_datetime;
	}
	public void setCreated_datetime(Timestamp created_datetime) {
		this.created_datetime = created_datetime;
	}
	public String getEdited_by() {
		return edited_by;
	}
	public void setEdited_by(String edited_by) {
		this.edited_by = edited_by;
	}
	public Timestamp getEdited_datetime() {
		return edited_datetime;
	}
	public void setEdited_datetime(Timestamp edited_datetime) {
		this.edited_datetime = edited_datetime;
	}
	public boolean isGlobal_is_encryption() {
		return global_is_encryption;
	}
	public void setGlobal_is_encryption(boolean global_is_encryption) {
		this.global_is_encryption = global_is_encryption;
	}
}
