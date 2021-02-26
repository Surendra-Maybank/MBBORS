package com.maybank.orsapp.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "mt_TERMINAL")
public class Terminal implements Serializable{
	    
    	/**
	 * 
	 */
	private static final long serialVersionUID = 6379284183594996066L;
		@Id
    	@Column(name="TERMINAL_ID", nullable=false)
    	@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private BigDecimal terminal_id;		
    	@Column(name="TID", nullable=false)
	    private String tid;		
    	@Column(name="MERCHANT_ID", nullable=false)
	    private BigDecimal merchant_id;	
    	@Column(name="TIER_RATE_ID", nullable=false)
    	private int tier_rate_id;
    	@Column(name="CONVERSION_RATE", nullable=false)
    	private BigDecimal conversion_rate;
    	@Column(name="IS_INHERIT", nullable=false)
    	private boolean is_inherit;
    	@Column(name="MAX_REDEEM_POINT", nullable=false)
	    private BigDecimal max_redeem_point;			
    	@Column(name="INSTANT_REWARD_PERCENTAGE", nullable=false)
    	private BigDecimal instant_reward_percentage;
    	
    	@Column(name="RECEIPT_HDR_1", nullable=true)
	    private String receipt_hdr_1;	
    	@Column(name="RECEIPT_HDR_2", nullable=true)
	    private String receipt_hdr_2;
    	@Column(name="RECEIPT_HDR_3", nullable=true)
	    private String receipt_hdr_3;	
    	
    	@Column(name="RECEIPT_FTR_1", nullable=true)
	    private String receipt_ftr_1;	
    	@Column(name="RECEIPT_FTR_2", nullable=true)
	    private String receipt_ftr_2;	
    	@Column(name="RECEIPT_FTR_3", nullable=true)
	    private String receipt_ftr_3;				
	    
    	@Column(name="IS_POINT_INQUIRY", nullable=false)
	    private boolean is_point_inquiry;
    	@Column(name="IS_INSTANT_REWARD", nullable=false)
	    private boolean is_instant_reward;
    	@Column(name="IS_POINT_REDEMPTION", nullable=false)
	    private boolean is_point_redemption;	
    	@Column(name="IS_VALUE_REDEMPTION", nullable=false)
	    private boolean is_value_redemption;
    	@Column(name="IS_GIFT_CODE_REDEMPTION", nullable=false)
	    private boolean is_gift_code_redemption;
    	@Column(name="IS_HOT_DEAL_REDEMPTION", nullable=false)
	    private boolean is_hot_deal_redemption;	
    	@Column(name="IS_VOID_REDEMPTION", nullable=false)
	    private boolean is_void_redemption;
    	@Column(name="IS_ENCRYPTION", nullable=false)
	    private boolean is_encryption;
    	@Column(name="STATUS_ID", nullable=false)
    	private int status_id;
    	@Column(name="CREATED_BY", nullable=false)
    	private String created_by;
    	@Column(name="CREATED_DATETIME", nullable=false)
    	private Date created_datetime;
    	@Column(name="EDITED_BY", nullable=false)
    	private String edited_by;
    	@Column(name="EDITED_DATETIME", nullable=false)
    	private Date edited_datetime;
  
		public BigDecimal getTerminal_id() {
			return terminal_id;
		}
		public void setTerminal_id(BigDecimal terminal_id) {
			this.terminal_id = terminal_id;
		}
		public String getTid() {
			return tid;
		}
		public void setTid(String tid) {
			this.tid = tid;
		}
		public BigDecimal getMerchant_id() {
			return merchant_id;
		}
		public void setMerchant_id(BigDecimal merchant_id) {
			this.merchant_id = merchant_id;
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
		public boolean getIs_point_inquiry() {
			return is_point_inquiry;
		}
		public void setIs_point_inquiry(boolean is_point_inquiry) {
			this.is_point_inquiry = is_point_inquiry;
		}
		public boolean getIs_instant_reward() {
			return is_instant_reward;
		}
		public void setIs_instant_reward(boolean is_instant_reward) {
			this.is_instant_reward = is_instant_reward;
		}
		public boolean getIs_point_redemption() {
			return is_point_redemption;
		}
		public void setIs_point_redemption(boolean is_point_redemption) {
			this.is_point_redemption = is_point_redemption;
		}
		public boolean getIs_value_redemption() {
			return is_value_redemption;
		}
		public void setIs_value_redemption(boolean is_value_redemption) {
			this.is_value_redemption = is_value_redemption;
		}
		public boolean getIs_gift_code_redemption() {
			return is_gift_code_redemption;
		}
		public void setIs_gift_code_redemption(boolean is_gift_code_redemption) {
			this.is_gift_code_redemption = is_gift_code_redemption;
		}
		public boolean getIs_hot_deal_redemption() {
			return is_hot_deal_redemption;
		}
		public void setIs_hot_deal_redemption(boolean is_hot_deal_redemption) {
			this.is_hot_deal_redemption = is_hot_deal_redemption;
		}
		public boolean getIs_void_redemption() {
			return is_void_redemption;
		}
		public void setIs_void_redemption(boolean is_void_redemption) {
			this.is_void_redemption = is_void_redemption;
		}
		public boolean getIs_encryption() {
			return is_encryption;
		}
		public void setIs_encryption(boolean is_encryption) {
			this.is_encryption = is_encryption;
		}
		public int getStatus_id() {
			return status_id;
		}
		public void setStatus_id(int status_id) {
			this.status_id = status_id;
		}		
		public boolean getIs_inherit() {
			return is_inherit;
		}
		public void setIs_inherit(boolean is_inherit) {
			this.is_inherit = is_inherit;
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
		public BigDecimal getInstant_reward_percentage() {
			return instant_reward_percentage;
		}
		public void setInstant_reward_percentage(BigDecimal instant_reward_percentage) {
			this.instant_reward_percentage = instant_reward_percentage;
		}			
    	
}
