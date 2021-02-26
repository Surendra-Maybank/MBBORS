package com.maybank.orsapp.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.maybank.orsapp.dto.OrsProgramDTO;
import com.maybank.orsapp.dto.ProductRedemptionDTO;

public class PrdRdpProgramRowMapper implements RowMapper  {
	public OrsProgramDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		OrsProgramDTO obj = new OrsProgramDTO();
		obj.setProgramId(rs.getInt("PROGRAM_ID"));
		obj.setProgramCode(rs.getString("PROGRAM_CODE"));
		obj.setProgramDesc(rs.getString("PROGRAM_DESC"));
		obj.setRewardTypeId(rs.getInt("REWARD_TYPE_ID"));
	
		return obj;
	}
}
