package com.maybank.orsapp.dto;

import java.math.BigDecimal;
import java.util.Date;

public class TierRateDTO {
	
	private BigDecimal tier_rate_id;
	private String tier_rate_code;
	private String tier_rate_desc;
	private BigDecimal conversion_rate;
//	private String created_by;
//	private Date created_datetime;
//	private String edited_by;
//	private Date edited_datetime;
	
	public TierRateDTO(){}
	
	public TierRateDTO(BigDecimal tier_rate_id,
		BigDecimal conversion_rate,
		String tier_rate_desc,
		String tier_rate_code
//		String created_by,
//		Date created_datetime,
//		String edited_by,
//		Date edited_datetime
		) {
		
			this.tier_rate_id=tier_rate_id;
			this.tier_rate_code=tier_rate_code;
			this.conversion_rate=conversion_rate;
			this.tier_rate_desc=tier_rate_desc;
////			this.conversion_rate=conversion_rate;
//			this.created_by=created_by;
//			this.created_datetime=created_datetime;
//			this.edited_by=edited_by;
//			this.edited_datetime=edited_datetime;
		
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

	public BigDecimal getConversion_rate() {
		return conversion_rate;
	}

	public void setConversion_rate(BigDecimal conversion_rate) {
		this.conversion_rate = conversion_rate;
	}

	public String getTier_rate_code() {
		return tier_rate_code;
	}

	public void setTier_rate_code(String tier_rate_code) {
		this.tier_rate_code = tier_rate_code;
	}

}
