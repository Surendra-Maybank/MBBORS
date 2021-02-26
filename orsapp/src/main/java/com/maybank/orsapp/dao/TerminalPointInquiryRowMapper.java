package com.maybank.orsapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.maybank.orsapp.dto.DTCardInfoDto;

/**
 * @author 80003905
 *
 */
public class TerminalPointInquiryRowMapper implements RowMapper<DTCardInfoDto> {

	@Override
	public DTCardInfoDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		DTCardInfoDto cardInfo = new DTCardInfoDto();
		cardInfo.setPostingFlag(rs.getString("CARD_POST_FLAG"));
		cardInfo.setPointsBal(rs.getDouble("TRANSFORMED_TOTAL_POINTS_BAL"));
		return cardInfo;
	}

}
