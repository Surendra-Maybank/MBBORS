package com.maybank.orsapp.dto;

import java.math.BigDecimal;

public class ProductPlaticTypeLinkDTO {

	private BigDecimal product_plastic_type_id;
	private BigDecimal product_id;
	private Integer plastic_type_id;
	
	public BigDecimal getProduct_plastic_type_id() {
		return product_plastic_type_id;
	}
	public void setProduct_plastic_type_id(BigDecimal product_plastic_type_id) {
		this.product_plastic_type_id = product_plastic_type_id;
	}
	public BigDecimal getProduct_id() {
		return product_id;
	}
	public void setProduct_id(BigDecimal product_id) {
		this.product_id = product_id;
	}
	public Integer getPlastic_type_id() {
		return plastic_type_id;
	}
	public void setPlastic_type_id(Integer plastic_type_id) {
		this.plastic_type_id = plastic_type_id;
	}
	
	
}
