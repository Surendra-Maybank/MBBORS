package com.maybank.orsapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.maybank.orsapp.dto.CreditAndDebitCardDTO;

public class PrdRdpCreditDebitCardRowMapper implements RowMapper  {
	public CreditAndDebitCardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CreditAndDebitCardDTO obj = new CreditAndDebitCardDTO();
		obj.setCardholder_point_bucket_id(rs.getBigDecimal("CARDHOLDER_POINT_BUCKET_ID"));
		obj.setCard_no(rs.getString("CARD_NO"));
	
		return obj;
	}
}
