package com.maybank.orsapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.maybank.orsapp.dto.ProductUnitPointDetailDTO;

public class PrdRdpProductUnitPointDetailRowMapper implements RowMapper  {
	public ProductUnitPointDetailDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ProductUnitPointDetailDTO obj = new ProductUnitPointDetailDTO();
		obj.setMerchant_id(rs.getBigDecimal("merchant_id"));
		obj.setProduct_id(rs.getBigDecimal("product_id"));
		obj.setProduct_code(rs.getString("product_code"));
		obj.setUnit_point(rs.getBigDecimal("unit_point").intValue());
		obj.setCategory_type_code(rs.getString("category_type_code"));
		obj.setCategory_type_desc(rs.getString("category_type_desc"));
		
		return obj;
	}
}
