package com.maybank.orsapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.maybank.orsapp.dto.CardHolderDetailDTO;

public class PrdRdpCardHolderDetailRowMapper implements RowMapper  {
	public CardHolderDetailDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CardHolderDetailDTO obj = new CardHolderDetailDTO();
		obj.setCardholder_id(rs.getBigDecimal("CARDHOLDER_ID"));
		obj.setCust_ic_no(rs.getString("cust_ic_no"));
		obj.setFirst_name(rs.getString("first_name"));
		obj.setLast_name(rs.getString("last_name"));
		obj.setAddr1(rs.getString("addr1"));
		obj.setAddr2(rs.getString("addr2"));
		obj.setAddr3(rs.getString("addr3"));
		obj.setAddr4(rs.getString("addr4"));
		obj.setZip_code(rs.getString("zip_code"));
		obj.setHome_no(rs.getString("home_no"));
		obj.setOffice_no(rs.getString("office_no"));
		obj.setMobile_no(rs.getString("mobile_no"));
	
		return obj;
	}
}
