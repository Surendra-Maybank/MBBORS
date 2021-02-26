/**
 * 
 */
package com.maybank.orsapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.maybank.orsapp.dto.AirlinesDto;

/**
 * @author 80003905
 *
 */
public class AirlinesDtoRowMapper implements RowMapper<AirlinesDto> {

	@Override
	public AirlinesDto mapRow(ResultSet rs, int rowNum) throws SQLException {		
		AirlinesDto airlinesDto = new AirlinesDto();
		airlinesDto.setAirlinesId(rs.getLong("AIRLINES_ID"));
		airlinesDto.setAirlinesCode(rs.getString("AIRLINES_CODE"));
		airlinesDto.setAirlinesDesc(rs.getString("AIRLINES_DESC"));
		return airlinesDto;
	}

}
