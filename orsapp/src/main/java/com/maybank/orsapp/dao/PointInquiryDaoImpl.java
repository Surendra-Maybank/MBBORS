package com.maybank.orsapp.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.maybank.orsapp.dto.DTCardInfoDto;


/**
 * @author 80003905
 *
 */

@Repository
public class PointInquiryDaoImpl extends JdbcDaoSupport implements PointInquiryDao {
	
	public static final String MT_CARDHOLDER_BUCKET_DETAILS_JOIN = " FROM [dbo].[mt_CARDHOLDER_POINT_BUCKET] p INNER JOIN [dbo].[lk_PROGRAM] lp on lp.PROGRAM_ID = p.PROGRAM_ID";
	public static final String MT_CARDHOLDER_BUCKET_DETAILS = " FROM [dbo].[mt_CARDHOLDER_POINT_BUCKET] ";

	@Autowired
	@Qualifier("orsDataSource")
	DataSource datasource;

	@PostConstruct
	private void initialize() {
		setDataSource(datasource);
	}

	/****
	 * Need to implement Null Pointer Exception
	 */
	@Override
	public List<DTCardInfoDto> pointInquiryResponseForIcNo(String customerIcNo) {

		Object[] args = null;
		final String queryForIcNo = "SELECT p.[CUST_IC_NO], "
										 + "p.[CARD_NO], "
										 + "(CASE WHEN p.[CARD_POST_FLAG] = 'XX' THEN 'PP' ELSE p.[CARD_POST_FLAG] END) AS POSTING_FLAG, "
										 + "(lp.[PROGRAM_CODE] +' - ' + lp.[PROGRAM_DESC]) AS PROGRAM_CODES,"
										 + "p.[TRANSFORMED_TOTAL_POINTS_BAL] " 
								  + MT_CARDHOLDER_BUCKET_DETAILS_JOIN+" "
								  + " WHERE p.[CUST_IC_NO] = '"+ customerIcNo + "' AND p.[STATUS_ID] = '1'";
		
		ArrayList<DTCardInfoDto> cardInfoList = (ArrayList<DTCardInfoDto>) getJdbcTemplate().query(queryForIcNo, new PointInquiryRowMapper(), args);
		
		if(CollectionUtils.isEmpty(cardInfoList)) {
			return Collections.emptyList();
		}else {
			Optional<DTCardInfoDto> matchingObject = cardInfoList.stream().filter(p -> p.getPostingFlag().equals("PP")).findAny();
			String customerNo = null;
			if(matchingObject.isPresent()) {
				customerNo = getCustomerNoForTeminalPostingFlagPP(customerIcNo);
				List<DTCardInfoDto> pointBalListForCustNo = getPointBalForCustNo(customerNo);
				if(CollectionUtils.isEmpty(pointBalListForCustNo)) {
					return cardInfoList;
				}else {
					cardInfoList.addAll(pointBalListForCustNo);
					return cardInfoList;
				}
			}else {
				return cardInfoList;
			}
		}
	}
	
	@Override
	public List<DTCardInfoDto> pointInquiryResponseForCustomerCreditCardNo(String customerCreditCardNo) {
		
		final String queryForCardNo = "SELECT DISTINCT [CUST_IC_NO] "
										+ MT_CARDHOLDER_BUCKET_DETAILS+" "
										+ "WHERE [CARD_NO]  = ?"
										+ " AND [STATUS_ID] = '1' ";

		ArrayList<String> customerIcNoList = (ArrayList<String>) getJdbcTemplate().query(queryForCardNo, new GetCustomerCardNoRowMapper(), new Object[] { customerCreditCardNo });
		
		if(CollectionUtils.isEmpty(customerIcNoList)) {
			return Collections.emptyList();
		}
		else {
			List<DTCardInfoDto> cardInfoList = pointInquiryResponseForIcNo(customerIcNoList.get(0));
			if(CollectionUtils.isEmpty(cardInfoList)) {
				return Collections.emptyList();
			}else {
				return cardInfoList;
			}				
		}
	}

	@Override
	public List<DTCardInfoDto> pointInquiryResponseForCustomerDebitCardNo(String customerDebitCardNo) {
		
		final String queryForCardNo = "SELECT DISTINCT [CUST_IC_NO] "
									+ "FROM [dbo].[mt_DEBIT_CARDHOLDER] "
									+ "WHERE [CARD_NO]  = ? "
									+ "AND [STATUS_ID] = '1' ";

		String customerIcNo = (String) getJdbcTemplate().queryForObject(queryForCardNo, new Object[] { customerDebitCardNo }, String.class);
		
		if (customerIcNo == null || customerIcNo.trim().equals("") || customerIcNo.trim().equalsIgnoreCase("NULL")) {
			return Collections.emptyList();
		} else {
			List<DTCardInfoDto> cardInfoList = pointInquiryResponseForIcNo(customerIcNo);
			if(CollectionUtils.isEmpty(cardInfoList)) {
				return Collections.emptyList();
			}else {
				return cardInfoList;
			}				
		}
		
	}
	
	private List<DTCardInfoDto> getPointBalForCustNo(String customerNo) {
		
		Object[] args = null;
		final String queryForIcNo = "SELECT p.[CUST_IC_NO], "
										 + "p.[CARD_NO], "
										 + "(CASE WHEN p.[CARD_POST_FLAG] = 'XX' THEN 'PP' ELSE p.[CARD_POST_FLAG] END) AS POSTING_FLAG, "
										 + "(lp.[PROGRAM_CODE]  +' - ' + lp.[PROGRAM_DESC]) AS PROGRAM_CODES,"
										 + "p.[TRANSFORMED_TOTAL_POINTS_BAL] " 
								  +MT_CARDHOLDER_BUCKET_DETAILS_JOIN+ " "
								  + " WHERE p.[CUST_NO] = '"+ customerNo + "' AND p.[STATUS_ID] = '1' AND p.[CARD_POST_FLAG] != 'PP'";
		
		ArrayList<DTCardInfoDto> cardInfoList = (ArrayList<DTCardInfoDto>) getJdbcTemplate().query(queryForIcNo, new PointInquiryRowMapper(), args);
		
		if(CollectionUtils.isEmpty(cardInfoList)) {
			return Collections.emptyList();
		}else {
			return cardInfoList;
		}
	}
	
	private List<DTCardInfoDto> getTerminalPointBalForCustNo(String customerNo, String programId) {
		
		Object[] args = null;
		final String queryForIcNo = "SELECT p.[CARD_POST_FLAG], "
										 + "p.[TRANSFORMED_TOTAL_POINTS_BAL] " 
								  +MT_CARDHOLDER_BUCKET_DETAILS + " p "
								  + " WHERE p.[CUST_NO] = '"+ customerNo + "' AND p.[STATUS_ID] = '1' AND p.[CARD_POST_FLAG] in ('SP', 'XX') AND p.[PROGRAM_ID] = '"+programId+"' ";
		
		ArrayList<DTCardInfoDto> cardInfoList = (ArrayList<DTCardInfoDto>) getJdbcTemplate().query(queryForIcNo, new TerminalPointInquiryRowMapper(), args);
		
		if(CollectionUtils.isEmpty(cardInfoList)) {
			return Collections.emptyList();
		}else {
			return cardInfoList;
		}
	}
	
	private String getCustomerNoForTeminalPostingFlagPP(String customerIcNo) {
		final String queryForCardNo = "SELECT DISTINCT [CUST_NO] "
				+ MT_CARDHOLDER_BUCKET_DETAILS+ " "
				+ " WHERE [CUST_IC_NO]  = ?"
				+ " AND [CARD_POST_FLAG] = 'PP' AND [STATUS_ID] = '1' ";

		//String customerNo = (String) getJdbcTemplate().queryForObject(queryForCardNo, new Object[] { customerIcNo }, String.class);
		
		ArrayList<String> customerNoList = (ArrayList<String>) getJdbcTemplate().query(queryForCardNo, new GetCustomerCardNoRowMapper(), new Object[] { customerIcNo });
		
		if(CollectionUtils.isEmpty(customerNoList)) {
			return null;
		}
		else {
			return customerNoList.get(0);
		}

		
	}

	@Override
	public List<DTCardInfoDto> pointInquiryTerminalForCustomerCreditCardNo(String customerCreditCardNo) {
		final String queryForCardNo = "SELECT DISTINCT [CUST_IC_NO], [PROGRAM_ID] "
										+ MT_CARDHOLDER_BUCKET_DETAILS+" "
										+ "WHERE [CARD_NO]  = ?"
										+ " AND [STATUS_ID] = '1' ";

		ArrayList<String> customerIcNoList = (ArrayList<String>) getJdbcTemplate().query(queryForCardNo, new TerminalCustNoProgramIdRowMapper(), new Object[] { customerCreditCardNo });
		
		if(CollectionUtils.isEmpty(customerIcNoList)) {
			return Collections.emptyList();
		}
		else {
			String customerIcNo = getCustomerIcNo(customerIcNoList.get(0).split("AND"));
			String programId = getProgramId(customerIcNoList.get(0).split("AND"));
			List<DTCardInfoDto> cardInfoList = terminalPointInquiryForIcNo(customerIcNo, programId);
			if(CollectionUtils.isEmpty(cardInfoList)) {
				return Collections.emptyList();
			}else {
				return cardInfoList;
			}				
		}
	}

	@Override
	public List<DTCardInfoDto> pointInquiryTerminalForCustomerDebitCardNo(String customerDebitCardNo) {
		
		final String queryForCardNo = "SELECT DISTINCT [CUST_IC_NO] "
				+ "FROM [dbo].[mt_DEBIT_CARDHOLDER] "
				+ "WHERE [CARD_NO]  = ? "
				+ "AND [STATUS_ID] = '1' ";

		ArrayList<String> customerIcNoList = (ArrayList<String>) getJdbcTemplate().query(queryForCardNo, new TerminalCustNoProgramIdRowMapper(), new Object[] { customerDebitCardNo });
		
		if(CollectionUtils.isEmpty(customerIcNoList)) {
			return Collections.emptyList();
		}
		else {
			String customerIcNo = getCustomerIcNo(customerIcNoList.get(0).split("AND"));
			String programId = getProgramId(customerIcNoList.get(0).split("AND"));
			List<DTCardInfoDto> cardInfoList = terminalPointInquiryForIcNo(customerIcNo, programId);
			if(CollectionUtils.isEmpty(cardInfoList)) {
				return Collections.emptyList();
			}else {
				return cardInfoList;
			}				
		}
	}
	
	private List<DTCardInfoDto> terminalPointInquiryForIcNo(String customerIcNo, String programId){
		Object[] args = null;
		final String queryForIcNo = "SELECT [CARD_POST_FLAG], "
										 + "[TRANSFORMED_TOTAL_POINTS_BAL] " 
								  + MT_CARDHOLDER_BUCKET_DETAILS+" "
								  + " WHERE [CUST_IC_NO] = '"+ customerIcNo + "' AND [STATUS_ID] = '1' AND [PROGRAM_ID] ='"+programId+"'";
		
		ArrayList<DTCardInfoDto> cardInfoList = (ArrayList<DTCardInfoDto>) getJdbcTemplate().query(queryForIcNo, new TerminalPointInquiryRowMapper(), args);
		
		if(CollectionUtils.isEmpty(cardInfoList)) {
			return Collections.emptyList();
		}else {
			Optional<DTCardInfoDto> matchingObject = cardInfoList.stream().filter(p -> p.getPostingFlag().equals("PP")).findAny();
			String customerNo = null;
			if(matchingObject.isPresent()) {
				customerNo = getCustomerNoForTeminalPostingFlagPP(customerIcNo);
				List<DTCardInfoDto> pointBalListForCustNo = getTerminalPointBalForCustNo(customerNo, programId);
				if(CollectionUtils.isEmpty(pointBalListForCustNo)) {
					return cardInfoList;
				}else {
					cardInfoList.addAll(pointBalListForCustNo);
					return cardInfoList;
				}
			}else {
				return cardInfoList;
			}
		}
	}
	
	private String getCustomerIcNo(String[] customerIcNo) {		
        String[] custNoarray = customerIcNo[0].split("CUST_IC_NO: ");
        return custNoarray[1];
	}
	
	private String getProgramId(String[] customerIcNo) {		
        String[] custNoarray = customerIcNo[1].split("PROGRAM_ID: ");
        return custNoarray[1];
	}

	@Override
	public Double getConversionRate() {
		final String queryForCardNo = "SELECT DISTINCT [CONVERSION_RATE] "
				+ "[dbo].[mt_TIER_RATE] "
				+ " WHERE [TIER_RATE_CODE] = 'GLOBAL' AND [STATUS_ID] = '1' ";

		Double conversionRate = (Double) getJdbcTemplate().queryForObject(queryForCardNo, new Object[] {}, Double.class);
		return conversionRate;
	}
}
