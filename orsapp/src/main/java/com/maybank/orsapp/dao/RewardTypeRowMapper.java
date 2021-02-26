/**
 * 
 */
package com.maybank.orsapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.maybank.orsapp.dto.RewardTypesDto;

/**
 * @author 80003905
 *
 */
public class RewardTypeRowMapper implements RowMapper<RewardTypesDto>{

	@Override
	public RewardTypesDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		RewardTypesDto rewardType= new RewardTypesDto();
		rewardType.setRewardTypeId(rs.getLong("REWARD_TYPE_ID"));
		rewardType.setRewardTypeCode(rs.getString("REWARD_TYPE_CODE"));
		rewardType.setRewardTypeDesc(rs.getString("REWARD_TYPE_DESC"));
		return rewardType;
	}

}
