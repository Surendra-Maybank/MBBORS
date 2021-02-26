package com.maybank.orsapp.dto;

import java.math.BigDecimal;
import java.util.Date;

public class ProductUnitPointDetailDTO {
	
	private BigDecimal product_id;
	private String product_code;
	private Integer	unit_point;
	private BigDecimal merchant_id;
	private String category_type_code;
	private String category_type_desc;
	
	public BigDecimal getProduct_id() {
		return product_id;
	}
	public void setProduct_id(BigDecimal product_id) {
		this.product_id = product_id;
	}
	public Integer getUnit_point() {
		return unit_point;
	}
	public void setUnit_point(Integer unit_point) {
		this.unit_point = unit_point;
	}
	public BigDecimal getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(BigDecimal merchant_id) {
		this.merchant_id = merchant_id;
	}
	public String getCategory_type_code() {
		return category_type_code;
	}
	public void setCategory_type_code(String category_type_code) {
		this.category_type_code = category_type_code;
	}
	public String getCategory_type_desc() {
		return category_type_desc;
	}
	public void setCategory_type_desc(String category_type_desc) {
		this.category_type_desc = category_type_desc;
	}
	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	
}
