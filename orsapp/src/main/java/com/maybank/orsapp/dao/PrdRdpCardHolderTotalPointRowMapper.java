package com.maybank.orsapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.maybank.orsapp.dto.CardHolderTotalPointDTO;

public class PrdRdpCardHolderTotalPointRowMapper implements RowMapper  {
	public CardHolderTotalPointDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CardHolderTotalPointDTO obj = new CardHolderTotalPointDTO();
		obj.setCardholder_point_bucket_id(rs.getBigDecimal("CARDHOLDER_POINT_BUCKET_ID"));
		obj.setCust_ic_no(rs.getString("CUST_IC_NO"));
		obj.setCard_no(rs.getString("CARD_NO"));
		obj.setCust_no(rs.getString("CUST_NO"));
		obj.setTotal_points_bal(rs.getBigDecimal("TOTAL_POINTS_BAL"));
		obj.setCard_post_flag(rs.getString("CARD_POST_FLAG"));
	
		return obj;
	}
}
