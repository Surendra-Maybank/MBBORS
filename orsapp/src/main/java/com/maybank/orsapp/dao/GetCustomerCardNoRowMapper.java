/**
 * 
 */
package com.maybank.orsapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * @author 80003905
 *
 */
public class GetCustomerCardNoRowMapper implements RowMapper<String>{

	@Override
	public String mapRow(ResultSet rs, int rowNum) throws SQLException {
		return rs.getString(1);
	}

}
