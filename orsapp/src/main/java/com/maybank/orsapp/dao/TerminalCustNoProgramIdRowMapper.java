package com.maybank.orsapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TerminalCustNoProgramIdRowMapper implements RowMapper<String> {
	
	
	@Override
	public String mapRow(ResultSet rs, int rowNum) throws SQLException { 
		return "CUST_IC_NO: " + rs.getString("CUST_IC_NO") + "AND" + "PROGRAM_ID: " + rs.getString("PROGRAM_ID");
	}

}
