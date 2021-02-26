package com.maybank.orsapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.maybank.orsapp.dto.TerminalConversionDTO;

public class TerminalInfoRowMapper implements RowMapper<TerminalConversionDTO>{

	@Override
	public TerminalConversionDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

		TerminalConversionDTO terminalConversionDTO = new TerminalConversionDTO();
		terminalConversionDTO.setMerchant_id(rs.getBigDecimal("merchant_id"));
		terminalConversionDTO.setTid(rs.getString("tid"));
		terminalConversionDTO.setConversion_rate(rs.getBigDecimal("conversion_rate"));
		terminalConversionDTO.setMax_redeem_point(rs.getBigDecimal("max_redeem_point"));
		
		return terminalConversionDTO;
	}
	

	
}
