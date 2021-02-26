package com.maybank.orsapp.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;

public class TerminalDetailDTO {

	private BigDecimal terminal_id;	
    private String tid;		
    private String mid;	
    private BigDecimal max_redeem_point;	
    private boolean is_inherit;
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
    
    private boolean is_point_inquiry;
    private boolean is_instant_reward;
    private boolean is_point_redemption;	
    private boolean is_value_redemption;
    private boolean is_gift_code_redemption;
    private boolean is_hot_deal_redemption;	
    private boolean is_void_redemption;
    private boolean is_encryption;
	private int status_id;
	private String created_by;
	private Date created_datetime;
	private String edited_by;
	private Date edited_datetime;
	
	public TerminalDetailDTO() {}
	
	public TerminalDetailDTO(BigDecimal terminal_id,	
					    String tid,		
					    String mid,	
					    BigDecimal max_redeem_point,	
					    boolean is_inherit,
					    BigDecimal instant_reward_percentage,
					    BigDecimal conversion_rate,
					    String receipt_hdr_1,	
					    String receipt_hdr_2,
					    String receipt_hdr_3,	
					    String receipt_ftr_1,	
					    String receipt_ftr_2,	
					    String receipt_ftr_3,	
					    BigDecimal tier_rate_id,
					    String tier_rate_code,
					    String tier_rate_desc,
					    boolean is_point_inquiry,
					    boolean is_instant_reward,
					    boolean is_point_redemption,	
					    boolean is_value_redemption,
					    boolean is_gift_code_redemption,
					    boolean is_hot_deal_redemption,	
					    boolean is_void_redemption,
					    boolean is_encryption,
						int status_id,
						String created_by,
						Date created_datetime,
						String edited_by,
						Date edited_datetime) {
		this.terminal_id=	terminal_id;
	    this.tid=tid;
	    this.mid=mid;
	    this.max_redeem_point=max_redeem_point;		
	    this.is_inherit=is_inherit;
	    this.instant_reward_percentage=instant_reward_percentage;
	    this.conversion_rate=conversion_rate;
	    this.receipt_hdr_1=receipt_hdr_1;
	    this.receipt_hdr_2=receipt_hdr_2;
	    this.receipt_hdr_3=receipt_hdr_3;	
	    this.receipt_ftr_1=receipt_ftr_1;	
	    this.receipt_ftr_2=receipt_ftr_2;	
	    this.receipt_ftr_3=receipt_ftr_3;	
	    this.tier_rate_id=tier_rate_id;
	    this.tier_rate_code=tier_rate_code;
	    this.tier_rate_desc=tier_rate_desc;
	    this.is_point_inquiry=is_point_inquiry;
	    this.is_instant_reward=is_instant_reward;
	    this.is_point_redemption=is_point_redemption;
	    this.is_value_redemption=is_value_redemption;
	    this.is_gift_code_redemption=is_gift_code_redemption;
	    this.is_hot_deal_redemption=is_hot_deal_redemption;
	    this.is_void_redemption=is_void_redemption;
	    this.is_encryption=is_encryption;
		this.status_id=status_id;
		this.created_by=created_by;
		this.created_datetime=created_datetime;
		this.edited_by=edited_by;
		this.edited_datetime=edited_datetime;
		
	}
	
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

	public boolean isIs_point_inquiry() {
		return is_point_inquiry;
	}

	public void setIs_point_inquiry(boolean is_point_inquiry) {
		this.is_point_inquiry = is_point_inquiry;
	}

	public boolean isIs_instant_reward() {
		return is_instant_reward;
	}

	public void setIs_instant_reward(boolean is_instant_reward) {
		this.is_instant_reward = is_instant_reward;
	}

	public boolean isIs_point_redemption() {
		return is_point_redemption;
	}

	public void setIs_point_redemption(boolean is_point_redemption) {
		this.is_point_redemption = is_point_redemption;
	}

	public boolean isIs_value_redemption() {
		return is_value_redemption;
	}

	public void setIs_value_redemption(boolean is_value_redemption) {
		this.is_value_redemption = is_value_redemption;
	}

	public boolean isIs_gift_code_redemption() {
		return is_gift_code_redemption;
	}

	public void setIs_gift_code_redemption(boolean is_gift_code_redemption) {
		this.is_gift_code_redemption = is_gift_code_redemption;
	}

	public boolean isIs_hot_deal_redemption() {
		return is_hot_deal_redemption;
	}

	public void setIs_hot_deal_redemption(boolean is_hot_deal_redemption) {
		this.is_hot_deal_redemption = is_hot_deal_redemption;
	}

	public boolean isIs_void_redemption() {
		return is_void_redemption;
	}

	public void setIs_void_redemption(boolean is_void_redemption) {
		this.is_void_redemption = is_void_redemption;
	}

	public boolean isIs_encryption() {
		return is_encryption;
	}

	public void setIs_encryption(boolean is_encryption) {
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

	public boolean isIs_inherit() {
		return is_inherit;
	}

	public void setIs_inherit(boolean is_inherit) {
		this.is_inherit = is_inherit;
	}

	public BigDecimal getInstant_reward_percentage() {
		return instant_reward_percentage;
	}

	public void setInstant_reward_percentage(BigDecimal instant_reward_percentage) {
		this.instant_reward_percentage = instant_reward_percentage;
	}

	public BigDecimal getConversion_rate() {
		return conversion_rate;
	}

	public void setConversion_rate(BigDecimal conversion_rate) {
		this.conversion_rate = conversion_rate;
	}
	
}
