/**
 * 
 */
package com.maybank.orsapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.maybank.orsapp.dto.ProgramDto;

/**
 * @author 80003905
 *
 */
public class ProgramsDtoRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProgramDto programDto = new ProgramDto();
		programDto.setProgramId(rs.getLong("PROGRAM_ID"));
		programDto.setProgramCode(rs.getString("PROGRAM_CODE"));
		programDto.setProgramDesc(rs.getString("PROGRAM_DESC"));
		return programDto;
	}

}
