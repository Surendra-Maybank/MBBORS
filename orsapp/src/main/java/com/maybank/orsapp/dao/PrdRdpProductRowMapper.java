package com.maybank.orsapp.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.maybank.orsapp.dto.ProductRedemptionDTO;

public class PrdRdpProductRowMapper implements RowMapper  {
	public ProductRedemptionDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ProductRedemptionDTO obj = new ProductRedemptionDTO();
		obj.setProduct_id(rs.getBigDecimal("PRODUCT_ID"));
		obj.setProduct_name(rs.getString("PRODUCT_NAME"));
		obj.setProduct_code(rs.getString("PRODUCT_CODE"));
		obj.setUnit_point(rs.getInt("UNIT_POINT"));
		obj.setMerchant_cost(rs.getBigDecimal("MERCHANT_COST"));
		obj.setActual_product_cost(rs.getBigDecimal("ACTUAL_PRODUCT_COST"));
		obj.setQty(rs.getInt("QTY"));
		obj.setMerchant_name(rs.getString("MERCHANT_NAME"));
		obj.setValid_start_date(rs.getString("VALID_START_DATE"));
		obj.setValid_end_date(rs.getString("VALID_END_DATE"));
		obj.setImage_path(rs.getString("IMAGE_PATH"));
		obj.setCategory_type_desc(rs.getString("CATEGORY_TYPE_DESC"));
		obj.setIs_premium_redemption(rs.getBoolean("IS_PREMIUM_REDEMPTION"));
		obj.setCredit_amount(rs.getBigDecimal("CREDIT_AMOUNT"));
		obj.setDebit_amount(rs.getBigDecimal("DEBIT_AMOUNT"));
		obj.setConversion_point(rs.getBigDecimal("CONVERSION_POINT"));
		obj.setRemarks(rs.getString("REMARKS"));
	
		return obj;
	}
}
