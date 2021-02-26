package com.maybank.orsapp.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mt_TIER_RATE")
public class TierRate implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1769931358584618237L;

	@Id
	@Column(name="TIER_RATE_ID", nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigDecimal tier_rate_id;	
	
	@Column(name="TIER_RATE_CODE", nullable=true)
	private String tier_rate_code;	
	
	@Column(name="TIER_RATE_DESC", nullable=false)
	private String tier_rate_desc;	
	
	@Column(name="CONVERSION_RATE", nullable=false)
	private BigDecimal conversion_rate;	
	
	@Column(name="STATUS_ID", nullable=false)
	private int status_id;
	
	@Column(name="CREATED_BY", nullable=false)
	private String created_by;	
	
	@Column(name="CREATED_DATETIME", nullable=false)
	private Timestamp created_datetime;
	
	@Column(name="EDITED_BY", nullable=false)
	private String edited_by;	
	
	@Column(name="EDITED_DATETIME", nullable=false)
	private Timestamp edited_datetime;

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

	public BigDecimal getConversion_rate() {
		return conversion_rate;
	}

	public void setConversion_rate(BigDecimal conversion_rate) {
		this.conversion_rate = conversion_rate;
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
}
