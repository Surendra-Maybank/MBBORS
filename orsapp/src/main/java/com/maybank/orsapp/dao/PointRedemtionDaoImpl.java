/**
 * 
 */
package com.maybank.orsapp.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.maybank.orsapp.dto.DTCardInfoDto;
import com.maybank.orsapp.dto.RewardTypesDto;
import com.maybank.orsapp.entities.Product;

/**
 * @author 80003905
 *
 */

@Repository
public class PointRedemtionDaoImpl extends JdbcDaoSupport  implements PointRedemptionDao {
	
	public static final String MT_CARDHOLDER_BUCKET_DETAILS_JOIN = " FROM [dbo].[mt_CARDHOLDER_POINT_BUCKET] p "
																	+ "INNER JOIN [dbo].[lk_PROGRAM] lp on lp.PROGRAM_ID = p.PROGRAM_ID "
																	+ "INNER JOIN [dbo].[lk_REWARD_TYPE] rt on rt.REWARD_TYPE_ID = lp.REWARD_TYPE_ID";
	public static final String MT_CARDHOLDER_BUCKET_DETAILS = " FROM [dbo].[mt_CARDHOLDER_POINT_BUCKET] ";
	
	@Autowired
	@Qualifier("orsDataSource")
	DataSource datasource;

	@PostConstruct
	private void initialize() {
		setDataSource(datasource);
	}

	@Override
	public List<RewardTypesDto> getRewardTypesForPointRedemption() {
		try {
			Object[] args = null;
			final String queryToRewardTypes = "select [REWARD_TYPE_ID], [REWARD_TYPE_CODE], [REWARD_TYPE_DESC] from [dbo].[lk_REWARD_TYPE] WHERE [STATUS_ID] = 1 ";
			
			ArrayList<RewardTypesDto> rewardTypes = (ArrayList<RewardTypesDto>) getJdbcTemplate().query(queryToRewardTypes, new RewardTypeRowMapper(), args);
			
			if(CollectionUtils.isEmpty(rewardTypes)) {
				return Collections.emptyList();
			}else {
				return rewardTypes;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProductsForRewardTypeId(Long rewardTypeId) {
		Object[] args = null;
		final String queryProductForRewardType = "SELECT p.* "
												  + "FROM [ORS].[dbo].[mt_PRODUCT] p"
												  + "INNER JOIN [ORS].[dbo].[mt_PRODUCT_PROGRAM] pp on pp.PRODUCT_ID = p.PRODUCT_ID "
												  + "INNER JOIN [ORS].[dbo].[lk_PROGRAM] lp on lp.PROGRAM_ID = pp.PROGRAM_ID "
												  + "INNER JOIN [ORS].[dbo].[lk_REWARD_TYPE] rt on rt.REWARD_TYPE_ID = lp.REWARD_TYPE_ID "
												  + " WHERE rt.[REWARD_TYPE_ID] ="+ rewardTypeId + " AND p.[STATUS_ID] = '1'";
		
		ArrayList<Product> productList = (ArrayList<Product>) getJdbcTemplate().query(queryProductForRewardType, (ResultSetExtractor<?>) new Object(), args);
		
		if(CollectionUtils.isEmpty(productList)) {
			return Collections.emptyList();
		}else {
			return productList;
		}
	}
	
	@Override
	public List<DTCardInfoDto> getPointsBalForRewardTypeIdAndIcNo(Long rewardTypeId, String customerIcNo) {

		Object[] args = null;
		final String queryForIcNo = "SELECT p.[CUST_IC_NO], "
										 + "p.[CARD_NO], p.[CARD_POST_FLAG], lp.[PROGRAM_CODE],"
										 + "p.[TRANSFORMED_TOTAL_POINTS_BAL] " 
								  + MT_CARDHOLDER_BUCKET_DETAILS_JOIN+" "
								  + " WHERE rt.[REWARD_TYPE_ID] ="+ rewardTypeId +" AND p.[CUST_IC_NO] = '"+ customerIcNo + "' AND p.[STATUS_ID] = '1'";
		
		ArrayList<DTCardInfoDto> cardInfoList = (ArrayList<DTCardInfoDto>) getJdbcTemplate().query(queryForIcNo, new PointInquiryRowMapper(), args);
		
		if(CollectionUtils.isEmpty(cardInfoList)) {
			return Collections.emptyList();
		}else {
			String customerNo = getCustomerNoForPostingFlagPP(cardInfoList);
			if (customerNo == null || customerNo.trim().equals("") || customerNo.trim().equalsIgnoreCase("NULL")) {
				return cardInfoList;
			} else {
				List<DTCardInfoDto> pointBalListForCustNo = getPointBalForCustNo(rewardTypeId, customerNo);
				if(CollectionUtils.isEmpty(pointBalListForCustNo)) {
					return cardInfoList;
				}else {
					cardInfoList.addAll(pointBalListForCustNo);
					return cardInfoList;
				}				
			}
		}
	}
	
	
	
	@Override
	public List<DTCardInfoDto> getPointsBalForRewardTypeIdAndCustomerCreditCardNo(Long rewardTypeId, String customerCreditCardNo) {
		
		final String queryForCardNo = "SELECT DISTINCT [CUST_IC_NO] "
										+ MT_CARDHOLDER_BUCKET_DETAILS+" "
										+ "WHERE [CARD_NO]  = ?"
										+ " AND [STATUS_ID] = '1' ";

		ArrayList<String> customerIcNoList = (ArrayList<String>) getJdbcTemplate().query(queryForCardNo, new GetCustomerCardNoRowMapper(), new Object[] { customerCreditCardNo });
		
		if(CollectionUtils.isEmpty(customerIcNoList)) {
			return Collections.emptyList();
		}
		else {
			List<DTCardInfoDto> cardInfoList = getPointsBalForRewardTypeIdAndIcNo(rewardTypeId, customerIcNoList.get(0));
			if(CollectionUtils.isEmpty(cardInfoList)) {
				return Collections.emptyList();
			}else {
				return cardInfoList;
			}				
		}
	}

	@Override
	public List<DTCardInfoDto> getPointsBalForRewardTypeIdAndCustomerDebitCardNo(Long rewardTypeId, String customerDebitCardNo) {
		
		final String queryForCardNo = "SELECT DISTINCT [CUST_IC_NO] "
									+ "FROM [dbo].[mt_DEBIT_CARDHOLDER] "
									+ "WHERE [CARD_NO]  = ? "
									+ "AND [STATUS_ID] = '1' ";

		String customerIcNo = (String) getJdbcTemplate().queryForObject(queryForCardNo, new Object[] { customerDebitCardNo }, String.class);
		
		if (customerIcNo == null || customerIcNo.trim().equals("") || customerIcNo.trim().equalsIgnoreCase("NULL")) {
			return Collections.emptyList();
		} else {
			List<DTCardInfoDto> cardInfoList = getPointsBalForRewardTypeIdAndIcNo(rewardTypeId, customerIcNo);
			if(CollectionUtils.isEmpty(cardInfoList)) {
				return Collections.emptyList();
			}else {
				return cardInfoList;
			}				
		}
		
	}
	
	private List<DTCardInfoDto> getPointBalForCustNo(Long rewardTypeId, String customerNo) {
		
		Object[] args = null;
		final String queryForIcNo = "SELECT p.[CUST_IC_NO], "
										 + "p.[CARD_NO], p.[CARD_POST_FLAG], lp.[PROGRAM_CODE],"
										 + "p.[TRANSFORMED_TOTAL_POINTS_BAL] " 
								  + MT_CARDHOLDER_BUCKET_DETAILS_JOIN+ " "
								  + " WHERE rt.[REWARD_TYPE_ID] ="+ rewardTypeId +" AND p.[CUST_NO] = '"+ customerNo + "' AND p.[STATUS_ID] = '1' AND p.[CARD_POST_FLAG] != 'PP'";
		
		ArrayList<DTCardInfoDto> cardInfoList = (ArrayList<DTCardInfoDto>) getJdbcTemplate().query(queryForIcNo, new PointInquiryRowMapper(), args);
		
		if(CollectionUtils.isEmpty(cardInfoList)) {
			return Collections.emptyList();
		}else {
			return cardInfoList;
		}
	}
	
	
	private String getCustomerNoForPostingFlagPP(List<DTCardInfoDto> cardInfoList) {
		String customerIcNo = null;
		List<DTCardInfoDto> cardInfoListWithPostingFlagPP = cardInfoList.stream()
																		.filter(cardInfo -> cardInfo.getPostingFlag().equalsIgnoreCase("PP"))
				  													 	.collect(Collectors.toList());
		
		if(CollectionUtils.isEmpty(cardInfoListWithPostingFlagPP)) {
			return customerIcNo;
		}
		else {
			customerIcNo = cardInfoListWithPostingFlagPP.get(0).getIcno();
			
			final String queryForCardNo = "SELECT DISTINCT [CUST_NO] "
										+ MT_CARDHOLDER_BUCKET_DETAILS+ " "
										+ " WHERE [CUST_IC_NO]  = ?"
										+ " AND [CARD_POST_FLAG] = 'PP' AND [STATUS_ID] = '1' ";
			
			String customerNo = (String) getJdbcTemplate().queryForObject(queryForCardNo, new Object[] { customerIcNo }, String.class);
			
			return customerNo;
		}
		
		
	}
	

}
