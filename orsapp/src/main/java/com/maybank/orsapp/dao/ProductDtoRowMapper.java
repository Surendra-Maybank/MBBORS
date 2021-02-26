/**
 * 
 */
package com.maybank.orsapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;

import com.maybank.orsapp.dto.ProductDto;
import com.maybank.orsapp.enums.StatusCodes;
import com.maybank.orsapp.utils.TimeStampConversion;

/**
 * @author 80003905
 *
 */
public class ProductDtoRowMapper extends TimeStampConversion implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductDto productDto = new ProductDto();
		productDto.setProductId(rs.getLong("PRODUCT_ID"));
		productDto.setProductCode(rs.getString("PRODUCT_CODE"));
		productDto.setProductName(rs.getString("PRODUCT_NAME"));
		//productDto.setUnitPoint(rs.getInt("CUST_IC_NO"));
		productDto.setMerchantCost(rs.getBigDecimal("MERCHANT_COST"));
		productDto.setActualProductCost(rs.getBigDecimal("ACTUAL_PRODUCT_COST"));
		productDto.setStatusDesc(StatusCodes.valueOf(rs.getInt("STATUS_ID")));
		productDto.setMerchantName(rs.getString("MERCHANT_NAME"));
		//productDto.setMerchantId(rs.getLong("CUST_IC_NO"));
		productDto.setProductQuantity(rs.getInt("QTY"));
		productDto.setProgramCodes(rs.getString("PROGRAM_CODES"));
		productDto.setValidStartDate(dateTimeFormat(rs.getDate("VALID_START_DATE")));
		productDto.setValidEndDate(dateTimeFormat(rs.getDate("VALID_END_DATE")));
		productDto.setCategoryTypeDesc(rs.getString("CATEGORY_TYPE_CODE"));
		productDto.setAirlinesDesc(rs.getString("AIRLINES_CODE"));
		productDto.setCreditAmount(rs.getBigDecimal("CREDIT_AMOUNT"));
		productDto.setDebitAmount(rs.getBigDecimal("DEBIT_AMOUNT"));
		productDto.setConversionPoint(rs.getBigDecimal("CONVERSION_POINT"));
		productDto.setCreatedBy(rs.getString("CREATED_BY"));
		productDto.setCreatedDateTime(dateTimeFormat(rs.getDate("CREATED_DATETIME")));
		productDto.setEditedBy(rs.getString("EDITED_BY"));
		productDto.setEditedDateTime(dateTimeFormat(rs.getDate("EDITED_DATETIME")));
		
		return productDto;
	}
	
	

}
