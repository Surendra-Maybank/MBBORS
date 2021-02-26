package com.maybank.orsapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.maybank.orsapp.dto.ProductPlaticTypeLinkDTO;

public class ProductPlasticTypeRowMapper implements RowMapper  {
	public ProductPlaticTypeLinkDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ProductPlaticTypeLinkDTO obj = new ProductPlaticTypeLinkDTO();
		obj.setProduct_plastic_type_id(rs.getBigDecimal("PRODUCT_PLASTIC_TYPE_ID"));
		obj.setProduct_id(rs.getBigDecimal("PRODUCT_ID"));
		obj.setPlastic_type_id(rs.getInt("PLASTIC_TYPE_ID"));
		
		return obj;
		
	}
}
