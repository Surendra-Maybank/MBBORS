package com.maybank.orsapp.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CardHolderTotalPointDTO {
	
	private BigDecimal cardholder_point_bucket_id;
	@JsonIgnore
	private String cust_no;
	@JsonIgnore
	private String cust_ic_no;
	private String card_no;
	private BigDecimal total_points_bal;
	private String card_post_flag;
	
	public BigDecimal getCardholder_point_bucket_id() {
		return cardholder_point_bucket_id;
	}
	public void setCardholder_point_bucket_id(BigDecimal cardholder_point_bucket_id) {
		this.cardholder_point_bucket_id = cardholder_point_bucket_id;
	}
	public String getCard_no() {
		return card_no;
	}
	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}
	public BigDecimal getTotal_points_bal() {
		return total_points_bal;
	}
	public void setTotal_points_bal(BigDecimal total_points_bal) {
		this.total_points_bal = total_points_bal;
	}
	public String getCard_post_flag() {
		return card_post_flag;
	}
	public void setCard_post_flag(String card_post_flag) {
		this.card_post_flag = card_post_flag;
	}	
	public String getCust_no() {
		return cust_no;
	}
	public void setCust_no(String cust_no) {
		this.cust_no = cust_no;
	}	
	public String getCust_ic_no() {
		return cust_ic_no;
	}
	public void setCust_ic_no(String cust_ic_no) {
		this.cust_ic_no = cust_ic_no;
	}
    
}
