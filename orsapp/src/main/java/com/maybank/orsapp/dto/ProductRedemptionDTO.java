package com.maybank.orsapp.dto;

import java.math.BigDecimal;
import java.util.Date;

public class ProductRedemptionDTO {
	
	private BigDecimal product_id;
	private String product_name;
	private String product_code;
	private Integer	unit_point;
	private BigDecimal merchant_cost;
	private BigDecimal actual_product_cost;
	private Integer qty;
	private String merchant_name;
	private String valid_start_date;
	private String valid_end_date;
	private String image_path;
	private String category_type_desc;
	private boolean is_premium_redemption;
	private BigDecimal credit_amount;
	private BigDecimal debit_amount;
	private BigDecimal conversion_point;
	private String remarks;
	
	public ProductRedemptionDTO(){}
	
	public ProductRedemptionDTO(
			BigDecimal product_id,
			String product_name,
			int	unit_point,
			BigDecimal merchant_cost,
			BigDecimal actual_product_cost,
			int qty,
			String merchant_name,
			String valid_start_date,
			String valid_end_date,
			String image_path,
			String category_type_desc,
			boolean is_premium_redemption,
			BigDecimal credit_amount,
			BigDecimal debit_amount,
			BigDecimal conversion_point,
			String remarks
			) {
		this.product_id = product_id;
		this.product_name = product_name;
		this.unit_point = unit_point;
		this.merchant_cost = merchant_cost;
		this.actual_product_cost = actual_product_cost;
		this.qty = qty;
		this.merchant_name = merchant_name;
		this.valid_start_date = valid_start_date;
		this.valid_end_date = valid_end_date;
		this.image_path = image_path;
		this.category_type_desc = category_type_desc;
		this.is_premium_redemption = is_premium_redemption;
		this.credit_amount = credit_amount;
		this.debit_amount = debit_amount;
		this.conversion_point = conversion_point;
		this.remarks = remarks;
		
	}
	
	public BigDecimal getProduct_id() {
		return product_id;
	}
	public void setProduct_id(BigDecimal product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getUnit_point() {
		return unit_point;
	}
	public void setUnit_point(int unit_point) {
		this.unit_point = unit_point;
	}
	public BigDecimal getMerchant_cost() {
		return merchant_cost;
	}
	public void setMerchant_cost(BigDecimal merchant_cost) {
		this.merchant_cost = merchant_cost;
	}
	public BigDecimal getActual_product_cost() {
		return actual_product_cost;
	}
	public void setActual_product_cost(BigDecimal actual_product_cost) {
		this.actual_product_cost = actual_product_cost;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public String getImage_path() {
		return image_path;
	}
	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}
	public boolean isIs_premium_redemption() {
		return is_premium_redemption;
	}
	public void setIs_premium_redemption(boolean is_premium_redemption) {
		this.is_premium_redemption = is_premium_redemption;
	}
	public BigDecimal getCredit_amount() {
		return credit_amount;
	}
	public void setCredit_amount(BigDecimal credit_amount) {
		this.credit_amount = credit_amount;
	}
	public BigDecimal getDebit_amount() {
		return debit_amount;
	}
	public void setDebit_amount(BigDecimal debit_amount) {
		this.debit_amount = debit_amount;
	}
	public BigDecimal getConversion_point() {
		return conversion_point;
	}
	public void setConversion_point(BigDecimal conversion_point) {
		this.conversion_point = conversion_point;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getCategory_type_desc() {
		return category_type_desc;
	}
	public void setCategory_type_desc(String category_type_desc) {
		this.category_type_desc = category_type_desc;
	}
	public String getMerchant_name() {
		return merchant_name;
	}
	public void setMerchant_name(String merchant_name) {
		this.merchant_name = merchant_name;
	}

	public String getValid_start_date() {
		return valid_start_date;
	}

	public void setValid_start_date(String valid_start_date) {
		this.valid_start_date = valid_start_date;
	}

	public String getValid_end_date() {
		return valid_end_date;
	}

	public void setValid_end_date(String valid_end_date) {
		this.valid_end_date = valid_end_date;
	}

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public void setUnit_point(Integer unit_point) {
		this.unit_point = unit_point;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

}
