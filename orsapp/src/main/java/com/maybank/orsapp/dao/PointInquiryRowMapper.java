/**
 * 
 */
package com.maybank.orsapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.maybank.orsapp.dto.DTCardInfoDto;

/**
 * @author 80003905
 *
 */
public class PointInquiryRowMapper implements RowMapper<DTCardInfoDto> {

	public DTCardInfoDto mapRow(ResultSet rs, int rowNum) throws SQLException {

		DTCardInfoDto cardInfo = new DTCardInfoDto();
		cardInfo.setIcno(rs.getString("CUST_IC_NO"));
		cardInfo.setCardNo(rs.getString("CARD_NO"));
		cardInfo.setPostingFlag(rs.getString("POSTING_FLAG"));
		cardInfo.setProgramID(rs.getString("PROGRAM_CODES"));
		cardInfo.setPointsBal(rs.getDouble("TRANSFORMED_TOTAL_POINTS_BAL"));
		return cardInfo;

	}


}
