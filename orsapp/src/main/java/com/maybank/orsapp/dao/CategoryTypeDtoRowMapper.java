/**
 * 
 */
package com.maybank.orsapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.maybank.orsapp.dto.CategoryTypeDto;

/**
 * @author 80003905
 *
 */
public class CategoryTypeDtoRowMapper implements RowMapper<CategoryTypeDto>{

	@Override
	public CategoryTypeDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CategoryTypeDto categoryType = new CategoryTypeDto();
		categoryType.setCategoryTypeId(rs.getLong("CATEGORY_TYPE_ID"));
		categoryType.setCategoryTypeCode(rs.getString("CATEGORY_TYPE_CODE"));
		categoryType.setCategoryTypeDesc(rs.getString("CATEGORY_TYPE_DESC"));
		categoryType.setIsCredit(rs.getBoolean("IS_CREDIT_AMOUNT"));
		categoryType.setIsDebit(rs.getBoolean("IS_DEBIT_AMOUNT"));
		categoryType.setIsPointConversion(rs.getBoolean("IS_POINT_CONVERSION"));
		return categoryType;
		
	}

}
