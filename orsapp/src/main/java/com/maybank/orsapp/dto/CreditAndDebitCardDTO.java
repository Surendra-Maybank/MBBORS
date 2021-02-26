package com.maybank.orsapp.dto;

import java.math.BigDecimal;

public class CreditAndDebitCardDTO {

	private BigDecimal cardholder_point_bucket_id;
	
	private String card_no;

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
	
	
}
