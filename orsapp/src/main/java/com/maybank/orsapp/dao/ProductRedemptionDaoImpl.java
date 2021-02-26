package com.maybank.orsapp.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.maybank.orsapp.constant.MBBORSConstant;
import com.maybank.orsapp.dto.CardHolderBucketDetailDTO;
import com.maybank.orsapp.dto.CardHolderDetailDTO;
import com.maybank.orsapp.dto.CardHolderTotalPointDTO;
import com.maybank.orsapp.dto.CreditAndDebitCardDTO;
import com.maybank.orsapp.dto.OrsProgramDTO;
import com.maybank.orsapp.dto.ProductPlasticTypeDto;
import com.maybank.orsapp.dto.ProductPlaticTypeLinkDTO;
import com.maybank.orsapp.dto.ProductRedemptionDTO;
import com.maybank.orsapp.dto.ProductUnitPointDetailDTO;
import com.maybank.orsapp.dto.TerminalConversionDTO;
import com.maybank.orsapp.dto.ValidateAirlineRedeemProductRequest;
import com.maybank.orsapp.dto.ValidateAirlineRedeemProductResponse;

@Repository
public class ProductRedemptionDaoImpl extends JdbcDaoSupport implements ProductRedemptionDao {
	
	@Autowired
	@Qualifier("orsDataSource")
	DataSource datasource;

	public final String GET_PRODUCT_REDEMPTION_SQL = "SELECT DISTINCT" 
			+" prd.product_id, prd.product_code, prd.product_name, prd.unit_point,"
			+" prd.merchant_cost, prd.actual_product_cost, prd.qty,"
			+" mch.merchant_name, LEFT(CONVERT(VARCHAR, prd.valid_start_date, 120), 19) AS valid_start_date, LEFT(CONVERT(VARCHAR, prd.valid_end_date, 120), 19) valid_end_date,"
			+" prd.image_path, lct.category_type_desc, prd.is_premium_redemption,"
			+" prd.credit_amount, prd.debit_amount, prd.conversion_point,"
			+" prd.remarks"
			+" from mt_PRODUCT prd"
			+" inner join mt_MERCHANT mch"
			+" on mch.merchant_id = prd.merchant_id"
			+" inner join mt_PRODUCT_PROGRAM prdprg"
			+" on prdprg.product_id = prd.product_id"
			+" inner join lk_CATEGORY_TYPE lct"
			+" on lct.CATEGORY_TYPE_ID = prd.CATEGORY_TYPE_ID"
			+" where prd.valid_start_date<=SYSDATETIME() AND prd.valid_end_date>=SYSDATETIME()" 
			+" and lct.category_type_code not in (?) "
			+" and prd.status_id=? "
			+" AND prdprg.program_id IN ("
			+" SELECT program_id FROM lk_PROGRAM WHERE REWARD_TYPE_ID = ?"
			+" )";
	
	public final String GET_AIRLINE_PRODUCT_REDEMPTION_SQL = "SELECT DISTINCT" 
			+" prd.product_id, prd.product_code, prd.product_name, prd.unit_point,"
			+" prd.merchant_cost, prd.actual_product_cost, prd.qty,"
			+" mch.merchant_name, LEFT(CONVERT(VARCHAR, prd.valid_start_date, 120), 19) AS valid_start_date, LEFT(CONVERT(VARCHAR, prd.valid_end_date, 120), 19) valid_end_date,"
			+" prd.image_path, lct.category_type_desc, prd.is_premium_redemption,"
			+" prd.credit_amount, prd.debit_amount, prd.conversion_point,"
			+" prd.remarks"
			+" from mt_PRODUCT prd"
			+" inner join mt_MERCHANT mch"
			+" on mch.merchant_id = prd.merchant_id"
			+" inner join mt_PRODUCT_PROGRAM prdprg"
			+" on prdprg.product_id = prd.product_id"
			+" inner join lk_CATEGORY_TYPE lct"
			+" on lct.CATEGORY_TYPE_ID = prd.CATEGORY_TYPE_ID"
			+" where prd.valid_start_date<=SYSDATETIME() AND prd.valid_end_date>=SYSDATETIME()" 
			+" and lct.category_type_code = ?"
			+" and prd.status_id=? "
			+" AND prdprg.program_id IN ("
			+" SELECT program_id FROM lk_PROGRAM WHERE REWARD_TYPE_ID = ?"
			+" )";
	
	public final String GET_ICNUM_BY_CARDNUM = "SELECT cust_ic_no FROM mt_CARDHOLDER_POINT_BUCKET WHERE status_id=? AND card_no=?";
	
	public final String GET_CARDHOLDER_TOTAL_POINT = "SELECT " 
			+"	cardholder_point_bucket_id,cust_no,cust_ic_no " 
			+"  ,card_no,card_exp_date,card_post_flag" 
			+"  ,total_points_sign,total_points_bal,transformed_total_points_bal " 
			+" FROM mt_CARDHOLDER_POINT_BUCKET " 
			+" WHERE 1=1 "
			+" AND program_id IN ("
			+" SELECT program_id FROM lk_PROGRAM WHERE REWARD_TYPE_ID = ?"
			+" )"
			+" AND STATUS_ID = ? ";
	
	public final String GET_CARDHOLDER_DETAILS_BY_CARDNUM = "SELECT "
			+" cardholder_id,cust_ic_no,first_name"
			+"	 ,last_name,addr1,addr2"
			+"	 ,addr3,addr4,zip_code "
			+"	 ,home_no,office_no,mobile_no"
			+"	FROM mt_CARDHOLDER"
			+"	WHERE cust_ic_no = ? AND status_id = ?";
	
	public final String GET_CREDIT_AND_DEBIT_CARD_BY_ICNUM = "SELECT "
			+" cardholder_point_bucket_id,card_no"
			+"	FROM mt_CARDHOLDER_POINT_BUCKET"
			+"	WHERE cust_ic_no = ? AND status_id = ? AND card_post_flag IN (?,?)";
	
	public final String GET_CARDHOLDER_BUCKET = "SELECT " 
			+"	* "
			+" FROM mt_CARDHOLDER_POINT_BUCKET " 
			+" WHERE 1=1 "
			+" AND program_id IN ("
			+" SELECT program_id FROM lk_PROGRAM WHERE REWARD_TYPE_ID = ?"
			+" )"
			+" AND STATUS_ID = ? AND cust_ic_no = ?";
	
	public final String GET_PRODUCT_POINT = "SELECT "
			+ " UNIT_POINT"
			+ " FROM mt_PRODUCT"
			+ " WHERE STATUS_ID = ? AND PRODUCT_ID=?";
	
	public final String INSERT_POINT_TXN = "INSERT INTO ap_POINT_TXN("
			+ "ORDER_NO,REF_ORDER_ID,CUST_IC_NO,FIRST_NAME,LAST_NAME"
			+",TOTAL_POINT_REDEEMED,TOTAL_AMOUNT_PURCHASED,REWARD_TYPE_ID"
			+",DELIVERY_ADDR1,DELIVERY_ADDR2,DELIVERY_ADDR3,DELIVERY_ADDR4"
			+",DELIVERY_ZIP_CODE,EMAIL,HOME_NO,OFFICE_NO,MOBILE_NO"
			+",REDEMPTION_SOURCE,TXN_TYPE,REDEMPTION_STATUS"
			+",STATUS_ID,CREATED_BY,CREATED_DATETIME,EDITED_BY,EDITED_DATETIME,CARDHOLDER_ID)"
			+" VALUES("
			+"?,?,?,?,? ,?,?,? ,?,?,?,? ,?,?,?,?,? ,?,?,? ,?,?,?,?,?,?"
			+ ")";
	
	public final String INSERT_POINT_TXN_DETAILS = "INSERT INTO ap_POINT_TXN_DETAIL("
			+ "POINT_TXN_ID,ORDER_NO,PRODUCT_ID,QTY,UNIT_POINT,MERCHANT_ID,"
			+ "DELIVERY_STATUS,IS_PAYMENT_POSTED,MPYT_CARD_NO,"
			+ "STATUS_ID,CREATED_BY,CREATED_DATETIME,EDITED_BY,EDITED_DATETIME"
			+ ") "
			+ " VALUES("
			+ "?,?,?,?,?,? ,?,?,? ,?,?,GETDATE(),?,GETDATE()"
			+ ")";
	
	public final String INSERT_POINT_TXN_BUCKET = "INSERT INTO ap_POINT_TXN_BUCKET_DETAIL("
			+ "POINT_TXN_ID,CARDHOLDER_POINT_BUCKET_ID,ORDER_NO,ORG_NO,CARD_TYPE,CARD_NO"
			+ ",TXN_CODE,TXN_TYPE,TXN_DESC,PROGRAM_CODE"
			+ ",TOTAL_POINT_REDEEMED,TOTAL_AMOUNT_PURCHASED,TOTAL_PREV_POINT_SIGN,TOTAL_PREV_POINT_BAL,TOTAL_POINT_SIGN,TOTAL_POINT_BAL"
			+ ",MR_PARTNER_TYPE,MR_PARTNER_CODE,MR_PARTNER_MEMBER_NO,MR_PARTNER_POINT,MR_COST_PER_UNIT"
			+ ",BUCKET01_POINT_PREV_SIGN,BUCKET01_POINT_PREV_BAL,BUCKET01_POINT_REDEEMED,BUCKET01_POINT_SIGN,BUCKET01_POINT_BAL"
			+ ",BUCKET02_POINT_PREV_SIGN,BUCKET02_POINT_PREV_BAL,BUCKET02_POINT_REDEEMED,BUCKET02_POINT_SIGN,BUCKET02_POINT_BAL"
			+ ",BUCKET03_POINT_PREV_SIGN,BUCKET03_POINT_PREV_BAL,BUCKET03_POINT_REDEEMED,BUCKET03_POINT_SIGN,BUCKET03_POINT_BAL"
			+ ",BUCKET04_POINT_PREV_SIGN,BUCKET04_POINT_PREV_BAL,BUCKET04_POINT_REDEEMED,BUCKET04_POINT_SIGN,BUCKET04_POINT_BAL"
			+ ",BUCKET05_POINT_PREV_SIGN,BUCKET05_POINT_PREV_BAL,BUCKET05_POINT_REDEEMED,BUCKET05_POINT_SIGN,BUCKET05_POINT_BAL"
			+ ",BUCKET06_POINT_PREV_SIGN,BUCKET06_POINT_PREV_BAL,BUCKET06_POINT_REDEEMED,BUCKET06_POINT_SIGN,BUCKET06_POINT_BAL"
			+ ",BUCKET07_POINT_PREV_SIGN,BUCKET07_POINT_PREV_BAL,BUCKET07_POINT_REDEEMED,BUCKET07_POINT_SIGN,BUCKET07_POINT_BAL"
			+ ",BUCKET08_POINT_PREV_SIGN,BUCKET08_POINT_PREV_BAL,BUCKET08_POINT_REDEEMED,BUCKET08_POINT_SIGN,BUCKET08_POINT_BAL"
			+ ",BUCKET09_POINT_PREV_SIGN,BUCKET09_POINT_PREV_BAL,BUCKET09_POINT_REDEEMED,BUCKET09_POINT_SIGN,BUCKET09_POINT_BAL"
			+ ",BUCKET10_POINT_PREV_SIGN,BUCKET10_POINT_PREV_BAL,BUCKET10_POINT_REDEEMED,BUCKET10_POINT_SIGN,BUCKET10_POINT_BAL"
			+ ",BUCKET11_POINT_PREV_SIGN,BUCKET11_POINT_PREV_BAL,BUCKET11_POINT_REDEEMED,BUCKET11_POINT_SIGN,BUCKET11_POINT_BAL"
			+ ",BUCKET12_POINT_PREV_SIGN,BUCKET12_POINT_PREV_BAL,BUCKET12_POINT_REDEEMED,BUCKET12_POINT_SIGN,BUCKET12_POINT_BAL"
			+ ",BUCKET13_POINT_PREV_SIGN,BUCKET13_POINT_PREV_BAL,BUCKET13_POINT_REDEEMED,BUCKET13_POINT_SIGN,BUCKET13_POINT_BAL"
			+ ",BUCKET14_POINT_PREV_SIGN,BUCKET14_POINT_PREV_BAL,BUCKET14_POINT_REDEEMED,BUCKET14_POINT_SIGN,BUCKET14_POINT_BAL"
			+ ",BUCKET15_POINT_PREV_SIGN,BUCKET15_POINT_PREV_BAL,BUCKET15_POINT_REDEEMED,BUCKET15_POINT_SIGN,BUCKET15_POINT_BAL"
			+ ",BUCKET16_POINT_PREV_SIGN,BUCKET16_POINT_PREV_BAL,BUCKET16_POINT_REDEEMED,BUCKET16_POINT_SIGN,BUCKET16_POINT_BAL"
			+ ",BUCKET17_POINT_PREV_SIGN,BUCKET17_POINT_PREV_BAL,BUCKET17_POINT_REDEEMED,BUCKET17_POINT_SIGN,BUCKET17_POINT_BAL"
			+ ",BUCKET18_POINT_PREV_SIGN,BUCKET18_POINT_PREV_BAL,BUCKET18_POINT_REDEEMED,BUCKET18_POINT_SIGN,BUCKET18_POINT_BAL"
			+ ",BUCKET19_POINT_PREV_SIGN,BUCKET19_POINT_PREV_BAL,BUCKET19_POINT_REDEEMED,BUCKET19_POINT_SIGN,BUCKET19_POINT_BAL"
			+ ",BUCKET20_POINT_PREV_SIGN,BUCKET20_POINT_PREV_BAL,BUCKET20_POINT_REDEEMED,BUCKET20_POINT_SIGN,BUCKET20_POINT_BAL"
			+ ",BUCKET21_POINT_PREV_SIGN,BUCKET21_POINT_PREV_BAL,BUCKET21_POINT_REDEEMED,BUCKET21_POINT_SIGN,BUCKET21_POINT_BAL"
			+ ",BUCKET22_POINT_PREV_SIGN,BUCKET22_POINT_PREV_BAL,BUCKET22_POINT_REDEEMED,BUCKET22_POINT_SIGN,BUCKET22_POINT_BAL"
			+ ",BUCKET23_POINT_PREV_SIGN,BUCKET23_POINT_PREV_BAL,BUCKET23_POINT_REDEEMED,BUCKET23_POINT_SIGN,BUCKET23_POINT_BAL"
			+ ",BUCKET24_POINT_PREV_SIGN,BUCKET24_POINT_PREV_BAL,BUCKET24_POINT_REDEEMED,BUCKET24_POINT_SIGN,BUCKET24_POINT_BAL"
			+ ",BUCKET25_POINT_PREV_SIGN,BUCKET25_POINT_PREV_BAL,BUCKET25_POINT_REDEEMED,BUCKET25_POINT_SIGN,BUCKET25_POINT_BAL"
			+ ",BUCKET26_POINT_PREV_SIGN,BUCKET26_POINT_PREV_BAL,BUCKET26_POINT_REDEEMED,BUCKET26_POINT_SIGN,BUCKET26_POINT_BAL"
			+ ",BUCKET27_POINT_PREV_SIGN,BUCKET27_POINT_PREV_BAL,BUCKET27_POINT_REDEEMED,BUCKET27_POINT_SIGN,BUCKET27_POINT_BAL"
			+ ",BUCKET28_POINT_PREV_SIGN,BUCKET28_POINT_PREV_BAL,BUCKET28_POINT_REDEEMED,BUCKET28_POINT_SIGN,BUCKET28_POINT_BAL"
			+ ",BUCKET29_POINT_PREV_SIGN,BUCKET29_POINT_PREV_BAL,BUCKET29_POINT_REDEEMED,BUCKET29_POINT_SIGN,BUCKET29_POINT_BAL"
			+ ",BUCKET30_POINT_PREV_SIGN,BUCKET30_POINT_PREV_BAL,BUCKET30_POINT_REDEEMED,BUCKET30_POINT_SIGN,BUCKET30_POINT_BAL"
			+ ",BUCKET31_POINT_PREV_SIGN,BUCKET31_POINT_PREV_BAL,BUCKET31_POINT_REDEEMED,BUCKET31_POINT_SIGN,BUCKET31_POINT_BAL"
			+ ",BUCKET32_POINT_PREV_SIGN,BUCKET32_POINT_PREV_BAL,BUCKET32_POINT_REDEEMED,BUCKET32_POINT_SIGN,BUCKET32_POINT_BAL"
			+ ",BUCKET33_POINT_PREV_SIGN,BUCKET33_POINT_PREV_BAL,BUCKET33_POINT_REDEEMED,BUCKET33_POINT_SIGN,BUCKET33_POINT_BAL"
			+ ",BUCKET34_POINT_PREV_SIGN,BUCKET34_POINT_PREV_BAL,BUCKET34_POINT_REDEEMED,BUCKET34_POINT_SIGN,BUCKET34_POINT_BAL"
			+ ",BUCKET35_POINT_PREV_SIGN,BUCKET35_POINT_PREV_BAL,BUCKET35_POINT_REDEEMED,BUCKET35_POINT_SIGN,BUCKET35_POINT_BAL"
			+ ",BUCKET36_POINT_PREV_SIGN,BUCKET36_POINT_PREV_BAL,BUCKET36_POINT_REDEEMED,BUCKET36_POINT_SIGN,BUCKET36_POINT_BAL"
			+ ",LAST_EXPIRED_POINT_SIGN,LAST_EXPIRED_POINT_BAL,STATUS_ID,CREATED_BY,CREATED_DATETIME,EDITED_BY,EDITED_DATETIME)"
			+ " VALUES("
			+ " ?,?,?,?,?,? " + " ,?,?,?,? " + " ,?,?,?,?,?,? "	+ " ,?,?,?,?,? "
			
			+ " ,?,?,?,?,? " + " ,?,?,?,?,? " + " ,?,?,?,?,? " + " ,?,?,?,?,? " + " ,?,?,?,?,? "
			+ " ,?,?,?,?,? " + " ,?,?,?,?,? " + " ,?,?,?,?,? " + " ,?,?,?,?,? "	+ " ,?,?,?,?,? "
			
			+ " ,?,?,?,?,? " + " ,?,?,?,?,? " + " ,?,?,?,?,? " + " ,?,?,?,?,? " + " ,?,?,?,?,? "
			+ " ,?,?,?,?,? " + " ,?,?,?,?,? " + " ,?,?,?,?,? " + " ,?,?,?,?,? "	+ " ,?,?,?,?,? "		
			
			+ " ,?,?,?,?,? " + " ,?,?,?,?,? " + " ,?,?,?,?,? " + " ,?,?,?,?,? "	+ " ,?,?,?,?,? "	
			+ " ,?,?,?,?,? " + " ,?,?,?,?,? " + " ,?,?,?,?,? " + " ,?,?,?,?,? "	+ " ,?,?,?,?,? "
			
			+ " ,?,?,?,?,? " + " ,?,?,?,?,? " + " ,?,?,?,?,? " + " ,?,?,?,?,? " + " ,?,?,?,?,? "
			+ " ,?,?,?,?,? "
			
			+ " ,?,?,?,?,GETDATE(),?,GETDATE() "
			
			+ ")";
	
	public final String GET_REWARDTYPE_CODE = "SELECT "
			+ "	reward_type_code" 
			+ " FROM lk_REWARD_TYPE" 
			+ " WHERE reward_type_id = ?";
	
	public final String GET_REWARDTYPE_ID_BY_CODE = "SELECT "
			+ "	reward_type_id" 
			+ " FROM lk_REWARD_TYPE" 
			+ " WHERE reward_type_code = ?";
	
	public final String UPDATE_CARD_BUCKET = " UPDATE mt_CARDHOLDER_POINT_BUCKET SET "
			+ " TOTAL_POINTS_SIGN=?,TOTAL_POINTS_BAL=?,TRANSFORMED_TOTAL_POINTS_BAL=?,"
			+ " BUCKET01_POINT_SIGN=?,BUCKET01_POINT_BAL=?,BUCKET02_POINT_SIGN=?,BUCKET02_POINT_BAL=?,BUCKET03_POINT_SIGN=?,BUCKET03_POINT_BAL=?,"
			+ " BUCKET04_POINT_SIGN=?,BUCKET04_POINT_BAL=?,BUCKET05_POINT_SIGN=?,BUCKET05_POINT_BAL=?,BUCKET06_POINT_SIGN=?,BUCKET06_POINT_BAL=?,"
			+ " BUCKET07_POINT_SIGN=?,BUCKET07_POINT_BAL=?,BUCKET08_POINT_SIGN=?,BUCKET08_POINT_BAL=?,BUCKET09_POINT_SIGN=?,BUCKET09_POINT_BAL=?,"
			+ " BUCKET10_POINT_SIGN=?,BUCKET10_POINT_BAL=?,BUCKET11_POINT_SIGN=?,BUCKET11_POINT_BAL=?,BUCKET12_POINT_SIGN=?,BUCKET12_POINT_BAL=?,"
			+ " BUCKET13_POINT_SIGN=?,BUCKET13_POINT_BAL=?,BUCKET14_POINT_SIGN=?,BUCKET14_POINT_BAL=?,BUCKET15_POINT_SIGN=?,BUCKET15_POINT_BAL=?,"
			+ " BUCKET16_POINT_SIGN=?,BUCKET16_POINT_BAL=?,BUCKET17_POINT_SIGN=?,BUCKET17_POINT_BAL=?,BUCKET18_POINT_SIGN=?,BUCKET18_POINT_BAL=?,"
			+ " BUCKET19_POINT_SIGN=?,BUCKET19_POINT_BAL=?,BUCKET20_POINT_SIGN=?,BUCKET20_POINT_BAL=?,BUCKET21_POINT_SIGN=?,BUCKET21_POINT_BAL=?,"
			+ " BUCKET22_POINT_SIGN=?,BUCKET22_POINT_BAL=?,BUCKET23_POINT_SIGN=?,BUCKET23_POINT_BAL=?,BUCKET24_POINT_SIGN=?,BUCKET24_POINT_BAL=?,"
			+ " BUCKET25_POINT_SIGN=?,BUCKET25_POINT_BAL=?,BUCKET26_POINT_SIGN=?,BUCKET26_POINT_BAL=?,BUCKET27_POINT_SIGN=?,BUCKET27_POINT_BAL=?,"
			+ " BUCKET28_POINT_SIGN=?,BUCKET28_POINT_BAL=?,BUCKET29_POINT_SIGN=?,BUCKET29_POINT_BAL=?,BUCKET30_POINT_SIGN=?,BUCKET30_POINT_BAL=?,"
			+ " BUCKET31_POINT_SIGN=?,BUCKET31_POINT_BAL=?,BUCKET32_POINT_SIGN=?,BUCKET32_POINT_BAL=?,BUCKET33_POINT_SIGN=?,BUCKET33_POINT_BAL=?,"
			+ " BUCKET34_POINT_SIGN=?,BUCKET34_POINT_BAL=?,BUCKET35_POINT_SIGN=?,BUCKET35_POINT_BAL=?,BUCKET36_POINT_SIGN=?,BUCKET36_POINT_BAL=?,"
			+ " EDITED_BY=?,EDITED_DATETIME=GETDATE()"
			+ " WHERE CARDHOLDER_POINT_BUCKET_ID = ?";
			
	
	public final String GET_MERCHANT_ID_BY_MID = "SELECT "
			+ "	merchant_id" 
			+ " FROM mt_MERCHANT" 
			+ " WHERE mid = ? AND status_id = ?";
	
	public final String GET_TERMINAL_INFO_BY_TID = "SELECT "
			+ "	*" 
			+ " FROM mt_TERMINAL" 
			+ " WHERE tid = ? AND status_id = ?";
	
	public final String GET_PROGRAM_ID_BY_CARDNUM = "SELECT "
			+ "	PROGRAM_ID" 
			+ " FROM mt_CARDHOLDER_POINT_BUCKET" 
			+ " WHERE CARD_NO = ? AND status_id = ?";
	
	public final String GET_ICNUM_BY_DEBITCARD_NUM = "SELECT "
			+ "	CUST_IC_NO" 
			+ " FROM mt_DEBIT_CARDHOLDER" 
			+ " WHERE CARD_NO = ? AND STATUS_ID = ?";
	
	public final String GET_APPROVAL_CODE = "SELECT NEXT VALUE FOR terminal_approval_code AS approval_code";
	
	public final String GET_ORS_ORDER_NUM = "SELECT NEXT VALUE FOR product_redeemp_seq AS order_num_seq";
	
	public final String GET_PLASTIC_TYPE = "SELECT "
			+ "	 * "
			+ " FROM mt_PRODUCT_PLASTIC_TYPE"
			+ " WHERE PRODUCT_ID = ? AND STATUS_ID = ?";
	
	public final String GET_M2U_ORDER_ID_COUNT = "SELECT "
			+ "	COUNT(*)" 
			+ " FROM ap_POINT_TXN txn"
			+ " INNER JOIN ap_POINT_TXN_DETAIL txn_dtl" 
			+ " ON txn_dtl.point_txn_id = txn.point_txn_id" 
			+ " INNER JOIN mt_MERCHANT mch" 
			+ " ON mch.merchant_id = txn_dtl.merchant_id" 
			+ " WHERE txn.ref_order_id = ? AND mch.mid = ?";
	
	@PostConstruct
	private void initialize() {
		setDataSource(datasource);
	}
	
	public List<ProductRedemptionDTO> getProductRedemption(BigDecimal rewardTypeId){
		List<ProductRedemptionDTO> resultList = null;
		
		try {
			
			Object[] args = new Object[] {"A",MBBORSConstant.DB_STATUS_ACTIVE,rewardTypeId};

			int[] types = new int[] { Types.VARCHAR, Types.INTEGER, Types.BIGINT};

			resultList = getJdbcTemplate().query(GET_PRODUCT_REDEMPTION_SQL, args, types, new PrdRdpProductRowMapper());
			
		} catch (DataAccessException ex) {
			return null;
		}

		return resultList;
	}
	
	public List<ProductRedemptionDTO> getAirLineProductRedemption(BigDecimal rewardTypeId){
		List<ProductRedemptionDTO> resultList = null;
		
		try {
			
			Object[] args = new Object[] {"A",MBBORSConstant.DB_STATUS_ACTIVE,rewardTypeId};

			int[] types = new int[] { Types.VARCHAR, Types.INTEGER, Types.BIGINT};

			resultList = getJdbcTemplate().query(GET_AIRLINE_PRODUCT_REDEMPTION_SQL, args, types, new PrdRdpProductRowMapper());
			
		} catch (DataAccessException ex) {
			ex.printStackTrace();
			return null;
		}

		return resultList;
	}

	@Override
	public String getIcNumberByCardNum(String cardNum) {
		String result = "";
		
		try {
			
			Object[] args = new Object[] {MBBORSConstant.DB_STATUS_ACTIVE,cardNum};

			int[] types = new int[] { Types.INTEGER, Types.VARCHAR};

			result = getJdbcTemplate().queryForObject(GET_ICNUM_BY_CARDNUM, args, types,String.class);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return "";
		}
		
		return result;
	}
	
	@Override
	public List<CardHolderTotalPointDTO> getCardHolderTotalPoint(String icNum, String custNum, BigDecimal rewardTypeId) {
		
		String fnlSQL = GET_CARDHOLDER_TOTAL_POINT;
		List<CardHolderTotalPointDTO> resultList = null;
		
		Object[] args = null;
		int[] types = null;
		try {
			
			if(icNum!=null) {
				fnlSQL = fnlSQL.concat(" AND cust_ic_no = ?");
				args = new Object[] {rewardTypeId,MBBORSConstant.DB_STATUS_ACTIVE,icNum};
				types = new int[] {Types.BIGINT,Types.INTEGER,Types.VARCHAR};
			}
			if(custNum!=null) {
				fnlSQL = fnlSQL.concat(" AND cust_no = ?");
				args = new Object[] {rewardTypeId,MBBORSConstant.DB_STATUS_ACTIVE,custNum};
				types = new int[] {Types.BIGINT,Types.INTEGER,Types.VARCHAR};
			}
			System.out.println("fnlSQL :".concat(fnlSQL));
			
			resultList = getJdbcTemplate().query(fnlSQL, args, types,new PrdRdpCardHolderTotalPointRowMapper());
			
			System.out.println("List Size :".concat(Integer.toString(resultList.size())));
			
		} catch (DataAccessException ex) {
			System.out.println("empty");
			ex.printStackTrace();
			return null;
		}
		
		return resultList;
	}
	
	@Override
	public List<CardHolderTotalPointDTO> getSupCardHolderTotalPoint(List<String> cust_num, BigDecimal rewardTypeId) {
		
		List<CardHolderTotalPointDTO> resultList = null;
		
		final String GET_SUP_CARDHOLDER_TOTAL_POINT = "SELECT " 
				+"	cardholder_point_bucket_id,cust_no,cust_ic_no " 
				+"  ,card_no,card_exp_date,card_post_flag" 
				+"  ,total_points_sign,total_points_bal,transformed_total_points_bal " 
				+" FROM mt_CARDHOLDER_POINT_BUCKET " 
				+" WHERE 1=1 "
				+" AND program_id IN ("
				+" SELECT program_id FROM lk_PROGRAM WHERE REWARD_TYPE_ID = :rewardTypeId"
				+" )"
				+" AND cust_no IN ( :custNo )"
				+" AND STATUS_ID = :statusId ";
		
		try {
			
			NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(getJdbcTemplate());

			MapSqlParameterSource parameters = new MapSqlParameterSource();
			parameters.addValue("rewardTypeId", rewardTypeId);
			parameters.addValue("custNo", cust_num);
			parameters.addValue("statusId", MBBORSConstant.DB_STATUS_ACTIVE);
			
//			Object[] args = new Object[] {rewardTypeId,cust_num,MBBORSConstant.DB_STATUS_ACTIVE};
//			int[] types = new int[] {Types.BIGINT,Types.VARCHAR,Types.INTEGER};
			
			resultList = template.query(GET_SUP_CARDHOLDER_TOTAL_POINT, parameters, new PrdRdpCardHolderTotalPointRowMapper());
			
		} catch (DataAccessException ex) {
			System.out.println("empty");
			ex.printStackTrace();
			return null;
		}
		
		return resultList;
	}
	
	public CardHolderDetailDTO getCardHolderDetailsByIcNum(String icNum) {
		CardHolderDetailDTO result = null;
		
		try {
			
			Object[] args = new Object[] {icNum,MBBORSConstant.DB_STATUS_ACTIVE};

			int[] types = new int[] {Types.VARCHAR,Types.INTEGER};

			result = (CardHolderDetailDTO)getJdbcTemplate().queryForObject(GET_CARDHOLDER_DETAILS_BY_CARDNUM, args, types,new PrdRdpCardHolderDetailRowMapper());
			
		} catch (DataAccessException ex) {
			ex.printStackTrace();
			return null;
		}
		
		return result;
	}
	
	
	public List<CreditAndDebitCardDTO> getCreditAndDebitCardByIcNum(String icNum) {
		List<CreditAndDebitCardDTO> resultList = null;
		
		try {
			
			Object[] args = new Object[] {icNum,MBBORSConstant.DB_STATUS_ACTIVE,"PP","SP"};

			int[] types = new int[] {Types.VARCHAR,Types.INTEGER,Types.VARCHAR,Types.VARCHAR};

			resultList = getJdbcTemplate().query(GET_CREDIT_AND_DEBIT_CARD_BY_ICNUM, args, types,new PrdRdpCreditDebitCardRowMapper());
			
		} catch (DataAccessException ex) {
			ex.printStackTrace();
			return null;
		}
		
		return resultList;
	}
	
	@Override
	public List<CardHolderBucketDetailDTO> getCardHolderBucket(String icNum, BigDecimal rewardTypeId) {
		
		List<CardHolderBucketDetailDTO> resultList = null;
		
		Object[] args = null;
		int[] types = null;
		try {
			
			args = new Object[] {rewardTypeId,MBBORSConstant.DB_STATUS_ACTIVE,icNum};
			types = new int[] {Types.BIGINT,Types.INTEGER,Types.VARCHAR};
			
			resultList = getJdbcTemplate().query(GET_CARDHOLDER_BUCKET, args, types,new PrdRdpCardHolderBucketDetailRowMapper());
						
		} catch (DataAccessException ex) {
			System.out.println("empty");
			ex.printStackTrace();
			return null;
		}
		
		return resultList;
	}
	
	@Override
	public List<CardHolderBucketDetailDTO> getCardHolderBucketAirline(String icNum, BigDecimal rewardTypeId, List<Integer> platicTypeList) {
		
		List<CardHolderBucketDetailDTO> resultList = null;
		
		Object[] args = null;
		int[] types = null;
		try {
			
			String GET_CARDHOLDER_BUCKET = "SELECT " 
					+"	* "
					+" FROM mt_CARDHOLDER_POINT_BUCKET " 
					+" WHERE 1=1 "
					+" AND program_id IN ("
					+" SELECT program_id FROM lk_PROGRAM WHERE REWARD_TYPE_ID =:rewardTypeId"
					+" )"
					+" AND STATUS_ID =:statusId AND cust_ic_no =:custIcNum AND plastic_type_id in (:plasticTypeId)";
			
			NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(getJdbcTemplate());

			MapSqlParameterSource parameters = new MapSqlParameterSource();
			parameters.addValue("rewardTypeId", rewardTypeId);
			parameters.addValue("statusId", MBBORSConstant.DB_STATUS_ACTIVE);
			parameters.addValue("custIcNum", icNum);
			parameters.addValue("plasticTypeId", platicTypeList);
			
//			resultList = template.query(GET_SUP_CARDHOLDER_TOTAL_POINT, parameters, new PrdRdpCardHolderTotalPointRowMapper());
			
			
			resultList = template.query(GET_CARDHOLDER_BUCKET, parameters,new PrdRdpCardHolderBucketDetailRowMapper());
						
		} catch (DataAccessException ex) {
			System.out.println("empty");
			ex.printStackTrace();
			return null;
		}
		
		return resultList;
	}
			
	@Override
	public List<CardHolderBucketDetailDTO> getSupCardHolderBucket(List<String> cust_num, BigDecimal rewardTypeId) {
		
		List<CardHolderBucketDetailDTO> resultList = null;
		
		final String GET_SUP_CARDHOLDER_BUCKET = "SELECT " 
				+"	* "  
				+" FROM mt_CARDHOLDER_POINT_BUCKET " 
				+" WHERE 1=1 "
				+" AND program_id IN ("
				+" SELECT program_id FROM lk_PROGRAM WHERE REWARD_TYPE_ID = :rewardTypeId"
				+" )"
				+" AND cust_no IN ( :custNo )"
				+" AND STATUS_ID = :statusId ";
		
		try {
			
			NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(getJdbcTemplate());

			MapSqlParameterSource parameters = new MapSqlParameterSource();
			parameters.addValue("rewardTypeId", rewardTypeId);
			parameters.addValue("custNo", cust_num);
			parameters.addValue("statusId", MBBORSConstant.DB_STATUS_ACTIVE);
					
			resultList = template.query(GET_SUP_CARDHOLDER_BUCKET, parameters, new PrdRdpCardHolderBucketDetailRowMapper());
			
		} catch (DataAccessException ex) {
			System.out.println("empty");
			ex.printStackTrace();
			return null;
		}
		
		return resultList;
	}
	
	@Override
	public List<CardHolderBucketDetailDTO> getSupCardHolderBucketAirline(List<String> cust_num, BigDecimal rewardTypeId, List<Integer> platicTypeList) {
		
		List<CardHolderBucketDetailDTO> resultList = null;
		
		final String GET_SUP_CARDHOLDER_BUCKET = "SELECT " 
				+"	* "  
				+" FROM mt_CARDHOLDER_POINT_BUCKET " 
				+" WHERE 1=1 "
				+" AND program_id IN ("
				+" SELECT program_id FROM lk_PROGRAM WHERE REWARD_TYPE_ID = :rewardTypeId"
				+" )"
				+" AND cust_no IN ( :custNo )"
				+" AND STATUS_ID = :statusId AND plastic_type_id in (:plasticTypeId)";
		
		try {
			
			NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(getJdbcTemplate());

			MapSqlParameterSource parameters = new MapSqlParameterSource();
			parameters.addValue("rewardTypeId", rewardTypeId);
			parameters.addValue("custNo", cust_num);
			parameters.addValue("statusId", MBBORSConstant.DB_STATUS_ACTIVE);
			parameters.addValue("plasticTypeId", platicTypeList);
					
			resultList = template.query(GET_SUP_CARDHOLDER_BUCKET, parameters, new PrdRdpCardHolderBucketDetailRowMapper());
			
		} catch (DataAccessException ex) {
			System.out.println("empty");
			ex.printStackTrace();
			return null;
		}
		
		return resultList;
	}
	
	public BigDecimal getProductPointByProductId(BigDecimal productId) {
		BigDecimal result = null;
		
		System.out.println("in : ".concat(productId.toPlainString()));
		
		try {
			
			Object[] args = new Object[] {MBBORSConstant.DB_STATUS_ACTIVE,productId};

			int[] types = new int[] {Types.INTEGER, Types.BIGINT};

			result = getJdbcTemplate().queryForObject(GET_PRODUCT_POINT, args, types,BigDecimal.class);
			
		} catch (DataAccessException ex) {
			ex.printStackTrace();
			return null;
		}
		
		return result;
	}
	
	public BigDecimal newPointTxn(String orderNo, String refOrderNo, String custIcNo,String firstName, String lastName,
			BigDecimal totalPointRedeemed,BigDecimal totalAmountPurchased,BigDecimal rewardTypeId,
			String deliveryAddr1,String deliveryAddr2,String deliveryAddr3,String deliveryAddr4,
			String deliveryZipCode,String email,String homeNo,String officeNo,String mobileNo,
			String redemptionSource,String txnType,String redemptionStatus,String username,BigDecimal cardholderId) {
		
		BigDecimal result = BigDecimal.ZERO;
		KeyHolder holder = new GeneratedKeyHolder();
		
		try {

			getJdbcTemplate().update(new PreparedStatementCreator() {           

                @Override
                public PreparedStatement createPreparedStatement(Connection connection)
                        throws SQLException {
                	
                	Timestamp now = new Timestamp(System.currentTimeMillis());
                	
                    PreparedStatement ps = connection.prepareStatement(INSERT_POINT_TXN,
                        Statement.RETURN_GENERATED_KEYS); 
                    
//                    String orderNo, String custIcNo,String firstName, String lastName,
                    ps.setString(1, orderNo);
                    ps.setString(2, refOrderNo);
                    ps.setString(3, custIcNo);
                    ps.setString(4, firstName);
                    ps.setString(5, lastName);
//        			BigDecimal totalPointRedeemed,BigDecimal totalAmountPurchased,BigDecimal rewardTypeId,
                    ps.setBigDecimal(6, totalPointRedeemed);
                    ps.setBigDecimal(7, totalAmountPurchased);
                    ps.setBigDecimal(8, rewardTypeId);
//        			String deliveryAddr1,String deliveryAddr2,String deliveryAddr3,String deliveryAddr4,
                    ps.setString(9, deliveryAddr1);
                    ps.setString(10, deliveryAddr2);
                    ps.setString(11, deliveryAddr3);
                    ps.setString(12, deliveryAddr4);
//        			String deliveryZip_code,String email,String homeNo,String officeNo,String mobileNo,
                    ps.setString(13, deliveryZipCode);
                    ps.setString(14, email);
                    ps.setString(15, homeNo);
                    ps.setString(16, officeNo);
                    ps.setString(17, mobileNo);
//        			String redemptionSource,String txnType,String redemptionStatus,String username,BigDecimal cardholderId
                    ps.setString(18, redemptionSource);
                    ps.setString(19, txnType);
                    ps.setString(20, redemptionStatus);
                    //
                    ps.setInt(21, MBBORSConstant.DB_STATUS_ACTIVE);
                    ps.setString(22, username);
                    ps.setTimestamp(23, now);
                    ps.setString(24, username);
                    ps.setTimestamp(25, now);
                    ps.setBigDecimal(26, cardholderId);
                    return ps;
                }
            }, holder);

			result = new BigDecimal(holder.getKey().toString());
			
		} catch (DuplicateKeyException ex) {
			ex.printStackTrace();
		} catch (DataAccessException ex) {
			ex.printStackTrace();
		}
		return result;
	}
	
	public int newPointTxnDetails(BigDecimal txnId,String orderNo,BigDecimal productId,BigDecimal qty,BigDecimal unitPoint,BigDecimal merchantId,
			String deliveryStatus,boolean isPaymentPosted, String username, String firstCardNumber) {
		
		int result = 0;
		
		try {
				
			Object[] args = new Object[] {txnId,orderNo, productId, qty, unitPoint, merchantId,
					deliveryStatus,isPaymentPosted,firstCardNumber,MBBORSConstant.DB_STATUS_ACTIVE,username,username};

			int[] types = new int[] {Types.BIGINT,Types.VARCHAR,Types.BIGINT,Types.INTEGER,Types.INTEGER,Types.BIGINT,
					Types.VARCHAR,Types.BIT,Types.VARCHAR,Types.INTEGER,Types.VARCHAR,Types.VARCHAR,};

			result = getJdbcTemplate().update(INSERT_POINT_TXN_DETAILS, args, types);

		} catch (DuplicateKeyException ex) {
			ex.printStackTrace();
		} catch (DataAccessException ex) {
			ex.printStackTrace();
		}
		return result;	
	}
	
	public int newPointTxnBucket(
			BigDecimal POINT_TXN_ID,BigDecimal CARDHOLDER_POINT_BUCKET_ID,String ORDER_NO,String ORG_NO,String CARD_TYPE,String CARD_NO
			,String TXN_CODE,String TXN_TYPE,String TXN_DESC,String PROGRAM_CODE
			,BigDecimal TOTAL_POINT_REDEEMED,BigDecimal TOTAL_AMOUNT_PURCHASED,String TOTAL_PREV_POINT_SIGN,BigDecimal TOTAL_PREV_POINT_BAL,String TOTAL_POINT_SIGN,BigDecimal TOTAL_POINT_BAL
			,String MR_PARTNER_TYPE,String MR_PARTNER_CODE,String MR_PARTNER_MEMBER_NO,String MR_PARTNER_POINT,BigDecimal MR_COST_PER_UNIT
			,String BUCKET01_POINT_PREV_SIGN,BigDecimal BUCKET01_POINT_PREV_BAL,BigDecimal BUCKET01_POINT_REDEEMED,String BUCKET01_POINT_SIGN,BigDecimal BUCKET01_POINT_BAL
			,String BUCKET02_POINT_PREV_SIGN,BigDecimal BUCKET02_POINT_PREV_BAL,BigDecimal BUCKET02_POINT_REDEEMED,String BUCKET02_POINT_SIGN,BigDecimal BUCKET02_POINT_BAL
			,String BUCKET03_POINT_PREV_SIGN,BigDecimal BUCKET03_POINT_PREV_BAL,BigDecimal BUCKET03_POINT_REDEEMED,String BUCKET03_POINT_SIGN,BigDecimal BUCKET03_POINT_BAL
			,String BUCKET04_POINT_PREV_SIGN,BigDecimal BUCKET04_POINT_PREV_BAL,BigDecimal BUCKET04_POINT_REDEEMED,String BUCKET04_POINT_SIGN,BigDecimal BUCKET04_POINT_BAL
			,String BUCKET05_POINT_PREV_SIGN,BigDecimal BUCKET05_POINT_PREV_BAL,BigDecimal BUCKET05_POINT_REDEEMED,String BUCKET05_POINT_SIGN,BigDecimal BUCKET05_POINT_BAL
			,String BUCKET06_POINT_PREV_SIGN,BigDecimal BUCKET06_POINT_PREV_BAL,BigDecimal BUCKET06_POINT_REDEEMED,String BUCKET06_POINT_SIGN,BigDecimal BUCKET06_POINT_BAL
			,String BUCKET07_POINT_PREV_SIGN,BigDecimal BUCKET07_POINT_PREV_BAL,BigDecimal BUCKET07_POINT_REDEEMED,String BUCKET07_POINT_SIGN,BigDecimal BUCKET07_POINT_BAL
			,String BUCKET08_POINT_PREV_SIGN,BigDecimal BUCKET08_POINT_PREV_BAL,BigDecimal BUCKET08_POINT_REDEEMED,String BUCKET08_POINT_SIGN,BigDecimal BUCKET08_POINT_BAL
			,String BUCKET09_POINT_PREV_SIGN,BigDecimal BUCKET09_POINT_PREV_BAL,BigDecimal BUCKET09_POINT_REDEEMED,String BUCKET09_POINT_SIGN,BigDecimal BUCKET09_POINT_BAL
			,String BUCKET10_POINT_PREV_SIGN,BigDecimal BUCKET10_POINT_PREV_BAL,BigDecimal BUCKET10_POINT_REDEEMED,String BUCKET10_POINT_SIGN,BigDecimal BUCKET10_POINT_BAL
			,String BUCKET11_POINT_PREV_SIGN,BigDecimal BUCKET11_POINT_PREV_BAL,BigDecimal BUCKET11_POINT_REDEEMED,String BUCKET11_POINT_SIGN,BigDecimal BUCKET11_POINT_BAL
			,String BUCKET12_POINT_PREV_SIGN,BigDecimal BUCKET12_POINT_PREV_BAL,BigDecimal BUCKET12_POINT_REDEEMED,String BUCKET12_POINT_SIGN,BigDecimal BUCKET12_POINT_BAL
			,String BUCKET13_POINT_PREV_SIGN,BigDecimal BUCKET13_POINT_PREV_BAL,BigDecimal BUCKET13_POINT_REDEEMED,String BUCKET13_POINT_SIGN,BigDecimal BUCKET13_POINT_BAL
			,String BUCKET14_POINT_PREV_SIGN,BigDecimal BUCKET14_POINT_PREV_BAL,BigDecimal BUCKET14_POINT_REDEEMED,String BUCKET14_POINT_SIGN,BigDecimal BUCKET14_POINT_BAL
			,String BUCKET15_POINT_PREV_SIGN,BigDecimal BUCKET15_POINT_PREV_BAL,BigDecimal BUCKET15_POINT_REDEEMED,String BUCKET15_POINT_SIGN,BigDecimal BUCKET15_POINT_BAL
			,String BUCKET16_POINT_PREV_SIGN,BigDecimal BUCKET16_POINT_PREV_BAL,BigDecimal BUCKET16_POINT_REDEEMED,String BUCKET16_POINT_SIGN,BigDecimal BUCKET16_POINT_BAL
			,String BUCKET17_POINT_PREV_SIGN,BigDecimal BUCKET17_POINT_PREV_BAL,BigDecimal BUCKET17_POINT_REDEEMED,String BUCKET17_POINT_SIGN,BigDecimal BUCKET17_POINT_BAL
			,String BUCKET18_POINT_PREV_SIGN,BigDecimal BUCKET18_POINT_PREV_BAL,BigDecimal BUCKET18_POINT_REDEEMED,String BUCKET18_POINT_SIGN,BigDecimal BUCKET18_POINT_BAL
			,String BUCKET19_POINT_PREV_SIGN,BigDecimal BUCKET19_POINT_PREV_BAL,BigDecimal BUCKET19_POINT_REDEEMED,String BUCKET19_POINT_SIGN,BigDecimal BUCKET19_POINT_BAL
			,String BUCKET20_POINT_PREV_SIGN,BigDecimal BUCKET20_POINT_PREV_BAL,BigDecimal BUCKET20_POINT_REDEEMED,String BUCKET20_POINT_SIGN,BigDecimal BUCKET20_POINT_BAL
			,String BUCKET21_POINT_PREV_SIGN,BigDecimal BUCKET21_POINT_PREV_BAL,BigDecimal BUCKET21_POINT_REDEEMED,String BUCKET21_POINT_SIGN,BigDecimal BUCKET21_POINT_BAL
			,String BUCKET22_POINT_PREV_SIGN,BigDecimal BUCKET22_POINT_PREV_BAL,BigDecimal BUCKET22_POINT_REDEEMED,String BUCKET22_POINT_SIGN,BigDecimal BUCKET22_POINT_BAL
			,String BUCKET23_POINT_PREV_SIGN,BigDecimal BUCKET23_POINT_PREV_BAL,BigDecimal BUCKET23_POINT_REDEEMED,String BUCKET23_POINT_SIGN,BigDecimal BUCKET23_POINT_BAL
			,String BUCKET24_POINT_PREV_SIGN,BigDecimal BUCKET24_POINT_PREV_BAL,BigDecimal BUCKET24_POINT_REDEEMED,String BUCKET24_POINT_SIGN,BigDecimal BUCKET24_POINT_BAL
			,String BUCKET25_POINT_PREV_SIGN,BigDecimal BUCKET25_POINT_PREV_BAL,BigDecimal BUCKET25_POINT_REDEEMED,String BUCKET25_POINT_SIGN,BigDecimal BUCKET25_POINT_BAL
			,String BUCKET26_POINT_PREV_SIGN,BigDecimal BUCKET26_POINT_PREV_BAL,BigDecimal BUCKET26_POINT_REDEEMED,String BUCKET26_POINT_SIGN,BigDecimal BUCKET26_POINT_BAL
			,String BUCKET27_POINT_PREV_SIGN,BigDecimal BUCKET27_POINT_PREV_BAL,BigDecimal BUCKET27_POINT_REDEEMED,String BUCKET27_POINT_SIGN,BigDecimal BUCKET27_POINT_BAL
			,String BUCKET28_POINT_PREV_SIGN,BigDecimal BUCKET28_POINT_PREV_BAL,BigDecimal BUCKET28_POINT_REDEEMED,String BUCKET28_POINT_SIGN,BigDecimal BUCKET28_POINT_BAL
			,String BUCKET29_POINT_PREV_SIGN,BigDecimal BUCKET29_POINT_PREV_BAL,BigDecimal BUCKET29_POINT_REDEEMED,String BUCKET29_POINT_SIGN,BigDecimal BUCKET29_POINT_BAL
			,String BUCKET30_POINT_PREV_SIGN,BigDecimal BUCKET30_POINT_PREV_BAL,BigDecimal BUCKET30_POINT_REDEEMED,String BUCKET30_POINT_SIGN,BigDecimal BUCKET30_POINT_BAL
			,String BUCKET31_POINT_PREV_SIGN,BigDecimal BUCKET31_POINT_PREV_BAL,BigDecimal BUCKET31_POINT_REDEEMED,String BUCKET31_POINT_SIGN,BigDecimal BUCKET31_POINT_BAL
			,String BUCKET32_POINT_PREV_SIGN,BigDecimal BUCKET32_POINT_PREV_BAL,BigDecimal BUCKET32_POINT_REDEEMED,String BUCKET32_POINT_SIGN,BigDecimal BUCKET32_POINT_BAL
			,String BUCKET33_POINT_PREV_SIGN,BigDecimal BUCKET33_POINT_PREV_BAL,BigDecimal BUCKET33_POINT_REDEEMED,String BUCKET33_POINT_SIGN,BigDecimal BUCKET33_POINT_BAL
			,String BUCKET34_POINT_PREV_SIGN,BigDecimal BUCKET34_POINT_PREV_BAL,BigDecimal BUCKET34_POINT_REDEEMED,String BUCKET34_POINT_SIGN,BigDecimal BUCKET34_POINT_BAL
			,String BUCKET35_POINT_PREV_SIGN,BigDecimal BUCKET35_POINT_PREV_BAL,BigDecimal BUCKET35_POINT_REDEEMED,String BUCKET35_POINT_SIGN,BigDecimal BUCKET35_POINT_BAL
			,String BUCKET36_POINT_PREV_SIGN,BigDecimal BUCKET36_POINT_PREV_BAL,BigDecimal BUCKET36_POINT_REDEEMED,String BUCKET36_POINT_SIGN,BigDecimal BUCKET36_POINT_BAL
			,String LAST_EXPIRED_POINT_SIGN,BigDecimal LAST_EXPIRED_POINT_BAL,String username) {
		
		int result = 0;
		
		try {
			
			Object[] args = new Object[] {
					POINT_TXN_ID,CARDHOLDER_POINT_BUCKET_ID,ORDER_NO,ORG_NO,CARD_TYPE,CARD_NO
					,TXN_CODE,TXN_TYPE,TXN_DESC,PROGRAM_CODE
					,TOTAL_POINT_REDEEMED,TOTAL_AMOUNT_PURCHASED,TOTAL_PREV_POINT_SIGN,TOTAL_PREV_POINT_BAL,TOTAL_POINT_SIGN,TOTAL_POINT_BAL
					,MR_PARTNER_TYPE,MR_PARTNER_CODE,MR_PARTNER_MEMBER_NO,MR_PARTNER_POINT,MR_COST_PER_UNIT
					,BUCKET01_POINT_PREV_SIGN,BUCKET01_POINT_PREV_BAL,BUCKET01_POINT_REDEEMED,BUCKET01_POINT_SIGN,BUCKET01_POINT_BAL
					,BUCKET02_POINT_PREV_SIGN,BUCKET02_POINT_PREV_BAL,BUCKET02_POINT_REDEEMED,BUCKET02_POINT_SIGN,BUCKET02_POINT_BAL
					,BUCKET03_POINT_PREV_SIGN,BUCKET03_POINT_PREV_BAL,BUCKET03_POINT_REDEEMED,BUCKET03_POINT_SIGN,BUCKET03_POINT_BAL
					,BUCKET04_POINT_PREV_SIGN,BUCKET04_POINT_PREV_BAL,BUCKET04_POINT_REDEEMED,BUCKET04_POINT_SIGN,BUCKET04_POINT_BAL
					,BUCKET05_POINT_PREV_SIGN,BUCKET05_POINT_PREV_BAL,BUCKET05_POINT_REDEEMED,BUCKET05_POINT_SIGN,BUCKET05_POINT_BAL
					,BUCKET06_POINT_PREV_SIGN,BUCKET06_POINT_PREV_BAL,BUCKET06_POINT_REDEEMED,BUCKET06_POINT_SIGN,BUCKET06_POINT_BAL
					,BUCKET07_POINT_PREV_SIGN,BUCKET07_POINT_PREV_BAL,BUCKET07_POINT_REDEEMED,BUCKET07_POINT_SIGN,BUCKET07_POINT_BAL
					,BUCKET08_POINT_PREV_SIGN,BUCKET08_POINT_PREV_BAL,BUCKET08_POINT_REDEEMED,BUCKET08_POINT_SIGN,BUCKET08_POINT_BAL
					,BUCKET09_POINT_PREV_SIGN,BUCKET09_POINT_PREV_BAL,BUCKET09_POINT_REDEEMED,BUCKET09_POINT_SIGN,BUCKET09_POINT_BAL
					,BUCKET10_POINT_PREV_SIGN,BUCKET10_POINT_PREV_BAL,BUCKET10_POINT_REDEEMED,BUCKET10_POINT_SIGN,BUCKET10_POINT_BAL
					,BUCKET11_POINT_PREV_SIGN,BUCKET11_POINT_PREV_BAL,BUCKET11_POINT_REDEEMED,BUCKET11_POINT_SIGN,BUCKET11_POINT_BAL
					,BUCKET12_POINT_PREV_SIGN,BUCKET12_POINT_PREV_BAL,BUCKET12_POINT_REDEEMED,BUCKET12_POINT_SIGN,BUCKET12_POINT_BAL
					,BUCKET13_POINT_PREV_SIGN,BUCKET13_POINT_PREV_BAL,BUCKET13_POINT_REDEEMED,BUCKET13_POINT_SIGN,BUCKET13_POINT_BAL
					,BUCKET14_POINT_PREV_SIGN,BUCKET14_POINT_PREV_BAL,BUCKET14_POINT_REDEEMED,BUCKET14_POINT_SIGN,BUCKET14_POINT_BAL
					,BUCKET15_POINT_PREV_SIGN,BUCKET15_POINT_PREV_BAL,BUCKET15_POINT_REDEEMED,BUCKET15_POINT_SIGN,BUCKET15_POINT_BAL
					,BUCKET16_POINT_PREV_SIGN,BUCKET16_POINT_PREV_BAL,BUCKET16_POINT_REDEEMED,BUCKET16_POINT_SIGN,BUCKET16_POINT_BAL
					,BUCKET17_POINT_PREV_SIGN,BUCKET17_POINT_PREV_BAL,BUCKET17_POINT_REDEEMED,BUCKET17_POINT_SIGN,BUCKET17_POINT_BAL
					,BUCKET18_POINT_PREV_SIGN,BUCKET18_POINT_PREV_BAL,BUCKET18_POINT_REDEEMED,BUCKET18_POINT_SIGN,BUCKET18_POINT_BAL
					,BUCKET19_POINT_PREV_SIGN,BUCKET19_POINT_PREV_BAL,BUCKET19_POINT_REDEEMED,BUCKET19_POINT_SIGN,BUCKET19_POINT_BAL
					,BUCKET20_POINT_PREV_SIGN,BUCKET20_POINT_PREV_BAL,BUCKET20_POINT_REDEEMED,BUCKET20_POINT_SIGN,BUCKET20_POINT_BAL
					,BUCKET21_POINT_PREV_SIGN,BUCKET21_POINT_PREV_BAL,BUCKET21_POINT_REDEEMED,BUCKET21_POINT_SIGN,BUCKET21_POINT_BAL
					,BUCKET22_POINT_PREV_SIGN,BUCKET22_POINT_PREV_BAL,BUCKET22_POINT_REDEEMED,BUCKET22_POINT_SIGN,BUCKET22_POINT_BAL
					,BUCKET23_POINT_PREV_SIGN,BUCKET23_POINT_PREV_BAL,BUCKET23_POINT_REDEEMED,BUCKET23_POINT_SIGN,BUCKET23_POINT_BAL
					,BUCKET24_POINT_PREV_SIGN,BUCKET24_POINT_PREV_BAL,BUCKET24_POINT_REDEEMED,BUCKET24_POINT_SIGN,BUCKET24_POINT_BAL
					,BUCKET25_POINT_PREV_SIGN,BUCKET25_POINT_PREV_BAL,BUCKET25_POINT_REDEEMED,BUCKET25_POINT_SIGN,BUCKET25_POINT_BAL
					,BUCKET26_POINT_PREV_SIGN,BUCKET26_POINT_PREV_BAL,BUCKET26_POINT_REDEEMED,BUCKET26_POINT_SIGN,BUCKET26_POINT_BAL
					,BUCKET27_POINT_PREV_SIGN,BUCKET27_POINT_PREV_BAL,BUCKET27_POINT_REDEEMED,BUCKET27_POINT_SIGN,BUCKET27_POINT_BAL
					,BUCKET28_POINT_PREV_SIGN,BUCKET28_POINT_PREV_BAL,BUCKET28_POINT_REDEEMED,BUCKET28_POINT_SIGN,BUCKET28_POINT_BAL
					,BUCKET29_POINT_PREV_SIGN,BUCKET29_POINT_PREV_BAL,BUCKET29_POINT_REDEEMED,BUCKET29_POINT_SIGN,BUCKET29_POINT_BAL
					,BUCKET30_POINT_PREV_SIGN,BUCKET30_POINT_PREV_BAL,BUCKET30_POINT_REDEEMED,BUCKET30_POINT_SIGN,BUCKET30_POINT_BAL
					,BUCKET31_POINT_PREV_SIGN,BUCKET31_POINT_PREV_BAL,BUCKET31_POINT_REDEEMED,BUCKET31_POINT_SIGN,BUCKET31_POINT_BAL
					,BUCKET32_POINT_PREV_SIGN,BUCKET32_POINT_PREV_BAL,BUCKET32_POINT_REDEEMED,BUCKET32_POINT_SIGN,BUCKET32_POINT_BAL
					,BUCKET33_POINT_PREV_SIGN,BUCKET33_POINT_PREV_BAL,BUCKET33_POINT_REDEEMED,BUCKET33_POINT_SIGN,BUCKET33_POINT_BAL
					,BUCKET34_POINT_PREV_SIGN,BUCKET34_POINT_PREV_BAL,BUCKET34_POINT_REDEEMED,BUCKET34_POINT_SIGN,BUCKET34_POINT_BAL
					,BUCKET35_POINT_PREV_SIGN,BUCKET35_POINT_PREV_BAL,BUCKET35_POINT_REDEEMED,BUCKET35_POINT_SIGN,BUCKET35_POINT_BAL
					,BUCKET36_POINT_PREV_SIGN,BUCKET36_POINT_PREV_BAL,BUCKET36_POINT_REDEEMED,BUCKET36_POINT_SIGN,BUCKET36_POINT_BAL
					,LAST_EXPIRED_POINT_SIGN,LAST_EXPIRED_POINT_BAL,MBBORSConstant.DB_STATUS_ACTIVE,username,username						
			};

			int[] types = new int[] {
					Types.BIGINT,Types.BIGINT,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR
					,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR
					,Types.NUMERIC,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.NUMERIC
					//01
					,Types.VARCHAR,Types.NUMERIC,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					,Types.VARCHAR,Types.NUMERIC,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					,Types.VARCHAR,Types.NUMERIC,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					,Types.VARCHAR,Types.NUMERIC,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					,Types.VARCHAR,Types.NUMERIC,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					
					,Types.VARCHAR,Types.NUMERIC,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					,Types.VARCHAR,Types.NUMERIC,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					,Types.VARCHAR,Types.NUMERIC,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					,Types.VARCHAR,Types.NUMERIC,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					,Types.VARCHAR,Types.NUMERIC,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					//10
					,Types.VARCHAR,Types.NUMERIC,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					,Types.VARCHAR,Types.NUMERIC,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					,Types.VARCHAR,Types.NUMERIC,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					,Types.VARCHAR,Types.NUMERIC,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					,Types.VARCHAR,Types.NUMERIC,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					
					,Types.VARCHAR,Types.NUMERIC,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					,Types.VARCHAR,Types.NUMERIC,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					,Types.VARCHAR,Types.NUMERIC,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					,Types.VARCHAR,Types.NUMERIC,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					,Types.VARCHAR,Types.NUMERIC,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					//20
					,Types.VARCHAR,Types.NUMERIC,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					,Types.VARCHAR,Types.NUMERIC,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					,Types.VARCHAR,Types.NUMERIC,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					,Types.VARCHAR,Types.NUMERIC,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					,Types.VARCHAR,Types.NUMERIC,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					
					,Types.VARCHAR,Types.NUMERIC,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					,Types.VARCHAR,Types.NUMERIC,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					,Types.VARCHAR,Types.NUMERIC,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					,Types.VARCHAR,Types.NUMERIC,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					,Types.VARCHAR,Types.NUMERIC,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					//30
					,Types.VARCHAR,Types.NUMERIC,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					,Types.VARCHAR,Types.NUMERIC,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					,Types.VARCHAR,Types.NUMERIC,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					,Types.VARCHAR,Types.NUMERIC,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					,Types.VARCHAR,Types.NUMERIC,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					,Types.VARCHAR,Types.NUMERIC,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					//36
					,Types.VARCHAR,Types.NUMERIC,Types.INTEGER,Types.VARCHAR,Types.VARCHAR
					
			};

			result = getJdbcTemplate().update(INSERT_POINT_TXN_BUCKET, args, types);

		} catch (DuplicateKeyException ex) {
			ex.printStackTrace();
		} catch (DataAccessException ex) {
			ex.printStackTrace();
		}
		return result;
	}
	
	public List<ProductUnitPointDetailDTO> getProductPointDetailByID(List<BigDecimal> productIds){
		List<ProductUnitPointDetailDTO> resultList = null;		

		
		String GET_PRODUCT_REDEMPTION_SQL = "SELECT " 
				+" prd.product_id,prd.product_code,prd.unit_point,prd.merchant_id,"
				+" ct.category_type_code, ct.category_type_desc"
				+" from mt_PRODUCT prd"
				+" inner join lk_CATEGORY_TYPE ct"
				+" on prd.category_type_id = ct.category_type_id"
				+" where  prd.product_id in (:productIds)";
		
		try {
			
			NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(getJdbcTemplate());

			MapSqlParameterSource parameters = new MapSqlParameterSource();
			parameters.addValue("productIds", productIds);
			
			resultList = template.query(GET_PRODUCT_REDEMPTION_SQL, parameters, new PrdRdpProductUnitPointDetailRowMapper());
			
		} catch (DataAccessException ex) {
			System.out.println("empty");
			ex.printStackTrace();
			return null;
		}

		return resultList;
	}
	
	public List<OrsProgramDTO> getProgramList() {
		
		int ind = 1;
		List<OrsProgramDTO> result = new ArrayList<OrsProgramDTO>();
			
			String sql = "SELECT PROGRAM_ID,PROGRAM_CODE,PROGRAM_DESC,REWARD_TYPE_ID FROM lk_PROGRAM WHERE STATUS_ID = ?";

			Object[] args = null;
			int[] types = null;
			try {
				
				args = new Object[] {MBBORSConstant.DB_STATUS_ACTIVE};
				types = new int[] {Types.INTEGER};
				
				result = getJdbcTemplate().query(sql, args, types,new PrdRdpProgramRowMapper());
							
			} catch (DataAccessException ex) {
				System.out.println("empty");
				ex.printStackTrace();
				return null;
			}
			
		return result;
	}
	
	public String getRewardCodeById(int rewardTypeId) {		
		
		String result = null;
		Object[] args = null;
		int[] types = null;
		
		try {
			
			args = new Object[] {rewardTypeId};
			types = new int[] {Types.INTEGER};
			
			result = getJdbcTemplate().queryForObject(GET_REWARDTYPE_CODE, args, types,String.class);
						
		} catch (DataAccessException ex) {
			System.out.println("empty");
			ex.printStackTrace();
			return null;
		}
		
		return result;
	}
	
	public BigDecimal getRewardTypeIdByCode(String rewardTypeCode) {		
		
		BigDecimal result = null;
		Object[] args = null;
		int[] types = null;
		
		try {
			
			args = new Object[] {rewardTypeCode};
			types = new int[] {Types.VARCHAR};
			
			result = getJdbcTemplate().queryForObject(GET_REWARDTYPE_ID_BY_CODE, args, types,BigDecimal.class);
						
		} catch (DataAccessException ex) {
			System.out.println("empty");
			ex.printStackTrace();
			return null;
		}
		
		return result;
	}
	
	public BigDecimal getM2UOrderNumCount(String orderNum, String mid) {		
		
		BigDecimal result = null;
		Object[] args = null;
		int[] types = null;
		
		try {
			
			args = new Object[] {orderNum, mid};
			types = new int[] {Types.VARCHAR, Types.VARCHAR};
			
			result = getJdbcTemplate().queryForObject(GET_M2U_ORDER_ID_COUNT, args, types,BigDecimal.class);
						
		} catch (DataAccessException ex) {
			System.out.println("empty");
			ex.printStackTrace();
			return null;
		}
		
		return result;
	}
	
	public int updateCardBucket(String TOTAL_POINTS_SIGN,BigDecimal TOTAL_POINTS_BAL,BigDecimal TRANSFORMED_TOTAL_POINTS_BAL
			,String BUCKET01_POINT_SIGN,BigDecimal BUCKET01_POINT_BAL,String BUCKET02_POINT_SIGN,BigDecimal BUCKET02_POINT_BAL,String BUCKET03_POINT_SIGN,BigDecimal BUCKET03_POINT_BAL
			,String BUCKET04_POINT_SIGN,BigDecimal BUCKET04_POINT_BAL,String BUCKET05_POINT_SIGN,BigDecimal BUCKET05_POINT_BAL,String BUCKET06_POINT_SIGN,BigDecimal BUCKET06_POINT_BAL
			,String BUCKET07_POINT_SIGN,BigDecimal BUCKET07_POINT_BAL,String BUCKET08_POINT_SIGN,BigDecimal BUCKET08_POINT_BAL,String BUCKET09_POINT_SIGN,BigDecimal BUCKET09_POINT_BAL
			,String BUCKET10_POINT_SIGN,BigDecimal BUCKET10_POINT_BAL,String BUCKET11_POINT_SIGN,BigDecimal BUCKET11_POINT_BAL,String BUCKET12_POINT_SIGN,BigDecimal BUCKET12_POINT_BAL
			,String BUCKET13_POINT_SIGN,BigDecimal BUCKET13_POINT_BAL,String BUCKET14_POINT_SIGN,BigDecimal BUCKET14_POINT_BAL,String BUCKET15_POINT_SIGN,BigDecimal BUCKET15_POINT_BAL
			,String BUCKET16_POINT_SIGN,BigDecimal BUCKET16_POINT_BAL,String BUCKET17_POINT_SIGN,BigDecimal BUCKET17_POINT_BAL,String BUCKET18_POINT_SIGN,BigDecimal BUCKET18_POINT_BAL
			,String BUCKET19_POINT_SIGN,BigDecimal BUCKET19_POINT_BAL,String BUCKET20_POINT_SIGN,BigDecimal BUCKET20_POINT_BAL,String BUCKET21_POINT_SIGN,BigDecimal BUCKET21_POINT_BAL
			,String BUCKET22_POINT_SIGN,BigDecimal BUCKET22_POINT_BAL,String BUCKET23_POINT_SIGN,BigDecimal BUCKET23_POINT_BAL,String BUCKET24_POINT_SIGN,BigDecimal BUCKET24_POINT_BAL
			,String BUCKET25_POINT_SIGN,BigDecimal BUCKET25_POINT_BAL,String BUCKET26_POINT_SIGN,BigDecimal BUCKET26_POINT_BAL,String BUCKET27_POINT_SIGN,BigDecimal BUCKET27_POINT_BAL
			,String BUCKET28_POINT_SIGN,BigDecimal BUCKET28_POINT_BAL,String BUCKET29_POINT_SIGN,BigDecimal BUCKET29_POINT_BAL,String BUCKET30_POINT_SIGN,BigDecimal BUCKET30_POINT_BAL
			,String BUCKET31_POINT_SIGN,BigDecimal BUCKET31_POINT_BAL,String BUCKET32_POINT_SIGN,BigDecimal BUCKET32_POINT_BAL,String BUCKET33_POINT_SIGN,BigDecimal BUCKET33_POINT_BAL
			,String BUCKET34_POINT_SIGN,BigDecimal BUCKET34_POINT_BAL,String BUCKET35_POINT_SIGN,BigDecimal BUCKET35_POINT_BAL,String BUCKET36_POINT_SIGN,BigDecimal BUCKET36_POINT_BAL
			,String EDITED_BY,BigDecimal CARDHOLDER_POINT_BUCKET_ID) {
		
		int result = 0;
		
		try {
				
//			+ " TOTAL_POINTS_SIGN=?,TOTAL_POINTS_BAL=?,TRANSFORMED_TOTAL_POINTS_BAL=?,"
//			+ " BUCKET01_POINT_SIGN=?,BUCKET01_POINT_BAL=?,BUCKET02_POINT_SIGN=?,BUCKET02_POINT_BAL=?,BUCKET03_POINT_SIGN=?,BUCKET03_POINT_BAL=?,"
//			+ " BUCKET04_POINT_SIGN=?,BUCKET04_POINT_BAL=?,BUCKET05_POINT_SIGN=?,BUCKET05_POINT_BAL=?,BUCKET06_POINT_SIGN=?,BUCKET06_POINT_BAL=?,"
//			+ " BUCKET07_POINT_SIGN=?,BUCKET07_POINT_BAL=?,BUCKET08_POINT_SIGN=?,BUCKET08_POINT_BAL=?,BUCKET09_POINT_SIGN=?,BUCKET09_POINT_BAL=?,"
//			+ " BUCKET10_POINT_SIGN=?,BUCKET10_POINT_BAL=?,BUCKET11_POINT_SIGN=?,BUCKET11_POINT_BAL=?,BUCKET12_POINT_SIGN=?,BUCKET12_POINT_BAL=?,"
//			+ " BUCKET13_POINT_SIGN=?,BUCKET13_POINT_BAL=?,BUCKET14_POINT_SIGN=?,BUCKET14_POINT_BAL=?,BUCKET15_POINT_SIGN=?,BUCKET15_POINT_BAL=?,"
//			+ " BUCKET16_POINT_SIGN=?,BUCKET16_POINT_BAL=?,BUCKET17_POINT_SIGN=?,BUCKET17_POINT_BAL=?,BUCKET18_POINT_SIGN=?,BUCKET18_POINT_BAL=?,"
//			+ " BUCKET19_POINT_SIGN=?,BUCKET19_POINT_BAL=?,BUCKET20_POINT_SIGN=?,BUCKET20_POINT_BAL=?,BUCKET21_POINT_SIGN=?,BUCKET21_POINT_BAL=?,"
//			+ " BUCKET22_POINT_SIGN=?,BUCKET22_POINT_BAL=?,BUCKET23_POINT_SIGN=?,BUCKET23_POINT_BAL=?,BUCKET24_POINT_SIGN=?,BUCKET24_POINT_BAL=?,"
//			+ " BUCKET25_POINT_SIGN=?,BUCKET25_POINT_BAL=?,BUCKET26_POINT_SIGN=?,BUCKET26_POINT_BAL=?,BUCKET27_POINT_SIGN=?,BUCKET27_POINT_BAL=?,"
//			+ " BUCKET28_POINT_SIGN=?,BUCKET28_POINT_BAL=?,BUCKET29_POINT_SIGN=?,BUCKET29_POINT_BAL=?,BUCKET30_POINT_SIGN=?,BUCKET30_POINT_BAL=?,"
//			+ " BUCKET31_POINT_SIGN=?,BUCKET31_POINT_BAL=?,BUCKET32_POINT_SIGN=?,BUCKET32_POINT_BAL=?,BUCKET33_POINT_SIGN=?,BUCKET33_POINT_BAL=?,"
//			+ " BUCKET34_POINT_SIGN=?,BUCKET34_POINT_BAL=?,BUCKET35_POINT_SIGN=?,BUCKET35_POINT_BAL=?,BUCKET36_POINT_SIGN=?,BUCKET36_POINT_BAL=?,"
//			+ " EDITED_BY=?,EDITED_DATETIME=GETDATE()"
			
			
			Object[] args = new Object[] {TOTAL_POINTS_SIGN,TOTAL_POINTS_BAL,TRANSFORMED_TOTAL_POINTS_BAL
					,BUCKET01_POINT_SIGN,BUCKET01_POINT_BAL,BUCKET02_POINT_SIGN,BUCKET02_POINT_BAL,BUCKET03_POINT_SIGN,BUCKET03_POINT_BAL
					,BUCKET04_POINT_SIGN,BUCKET04_POINT_BAL,BUCKET05_POINT_SIGN,BUCKET05_POINT_BAL,BUCKET06_POINT_SIGN,BUCKET06_POINT_BAL
					,BUCKET07_POINT_SIGN,BUCKET07_POINT_BAL,BUCKET08_POINT_SIGN,BUCKET08_POINT_BAL,BUCKET09_POINT_SIGN,BUCKET09_POINT_BAL
					,BUCKET10_POINT_SIGN,BUCKET10_POINT_BAL,BUCKET11_POINT_SIGN,BUCKET11_POINT_BAL,BUCKET12_POINT_SIGN,BUCKET12_POINT_BAL
					,BUCKET13_POINT_SIGN,BUCKET13_POINT_BAL,BUCKET14_POINT_SIGN,BUCKET14_POINT_BAL,BUCKET15_POINT_SIGN,BUCKET15_POINT_BAL
					
					,BUCKET16_POINT_SIGN,BUCKET16_POINT_BAL,BUCKET17_POINT_SIGN,BUCKET17_POINT_BAL,BUCKET18_POINT_SIGN,BUCKET18_POINT_BAL
					,BUCKET19_POINT_SIGN,BUCKET19_POINT_BAL,BUCKET20_POINT_SIGN,BUCKET20_POINT_BAL,BUCKET21_POINT_SIGN,BUCKET21_POINT_BAL
					,BUCKET22_POINT_SIGN,BUCKET22_POINT_BAL,BUCKET23_POINT_SIGN,BUCKET23_POINT_BAL,BUCKET24_POINT_SIGN,BUCKET24_POINT_BAL
					,BUCKET25_POINT_SIGN,BUCKET25_POINT_BAL,BUCKET26_POINT_SIGN,BUCKET26_POINT_BAL,BUCKET27_POINT_SIGN,BUCKET27_POINT_BAL
					,BUCKET28_POINT_SIGN,BUCKET28_POINT_BAL,BUCKET29_POINT_SIGN,BUCKET29_POINT_BAL,BUCKET30_POINT_SIGN,BUCKET30_POINT_BAL
					
					,BUCKET31_POINT_SIGN,BUCKET31_POINT_BAL,BUCKET32_POINT_SIGN,BUCKET32_POINT_BAL,BUCKET33_POINT_SIGN,BUCKET33_POINT_BAL
					,BUCKET34_POINT_SIGN,BUCKET34_POINT_BAL,BUCKET35_POINT_SIGN,BUCKET35_POINT_BAL,BUCKET36_POINT_SIGN,BUCKET36_POINT_BAL
					,EDITED_BY,CARDHOLDER_POINT_BUCKET_ID};

			int[] types = new int[] {Types.VARCHAR,Types.NUMERIC,Types.NUMERIC
					,Types.VARCHAR,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					,Types.VARCHAR,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					,Types.VARCHAR,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					,Types.VARCHAR,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					,Types.VARCHAR,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					
					,Types.VARCHAR,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					,Types.VARCHAR,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					,Types.VARCHAR,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					,Types.VARCHAR,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					,Types.VARCHAR,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					
					,Types.VARCHAR,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					,Types.VARCHAR,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC,Types.VARCHAR,Types.NUMERIC
					,Types.VARCHAR,Types.BIGINT};

			result = getJdbcTemplate().update(UPDATE_CARD_BUCKET, args, types);

		} catch (DuplicateKeyException ex) {
			ex.printStackTrace();
		} catch (DataAccessException ex) {
			ex.printStackTrace();
		}
		return result;	
	}
	
	public BigDecimal getMerchantIdByMID(String MID) {		
		
		BigDecimal result = null;
		Object[] args = null;
		int[] types = null;
		
		try {
			
			args = new Object[] {MID,MBBORSConstant.DB_STATUS_ACTIVE};
			types = new int[] {Types.VARCHAR,Types.INTEGER};
			
			result = getJdbcTemplate().queryForObject(GET_MERCHANT_ID_BY_MID, args, types,BigDecimal.class);
						
		} catch (DataAccessException ex) {
			System.out.println("empty");
			ex.printStackTrace();
			return null;
		}
		
		return result;
	}
	
	public TerminalConversionDTO getTerminalConversionInfoByTID(String TID) {		
		
		TerminalConversionDTO result = null;
		Object[] args = null;
		int[] types = null;
		
		try {
			
			args = new Object[] {TID,MBBORSConstant.DB_STATUS_ACTIVE};
			types = new int[] {Types.VARCHAR,Types.INTEGER};
			
			result = getJdbcTemplate().queryForObject(GET_TERMINAL_INFO_BY_TID, args, types,new TerminalInfoRowMapper());
						
		} catch (DataAccessException ex) {
			System.out.println("empty");
			ex.printStackTrace();
			return null;
		}
		
		return result;
	}
	
	public Integer getProgramIdByCardNum(String cardNum) {
		Integer result = null;
		Object[] args = null;
		int[] types = null;
		
		try {
					
			args = new Object[] {cardNum,MBBORSConstant.DB_STATUS_ACTIVE};
			types = new int[] {Types.VARCHAR,Types.INTEGER};
			
			result = getJdbcTemplate().queryForObject(GET_PROGRAM_ID_BY_CARDNUM, args, types,Integer.class);
						
		} catch (DataAccessException ex) {
			System.out.println("empty");
			ex.printStackTrace();
			return null;
		}
		
		return result;
	}
	
	public String getICNumFromDebitCardNum(String debitCardNum) {
		String result = null;
		Object[] args = null;
		int[] types = null;
		
		try {
					
			args = new Object[] {debitCardNum,MBBORSConstant.DB_STATUS_ACTIVE};
			types = new int[] {Types.VARCHAR,Types.INTEGER};
			
			result = getJdbcTemplate().queryForObject(GET_ICNUM_BY_DEBITCARD_NUM, args, types,String.class);
						
		} catch (DataAccessException ex) {
			System.out.println("empty");
			ex.printStackTrace();
			return null;
		}
		
		return result;
	}
	
	public String getApprovalCode() {
		
		String result = null;
		
		try {
			
			BigDecimal approvalCode = getJdbcTemplate().queryForObject(GET_APPROVAL_CODE,BigDecimal.class);
						
			result = new DecimalFormat("000000").format(approvalCode);
		} catch (DataAccessException ex) {
			System.out.println("empty");
			ex.printStackTrace();
			return null;
		}
		
		return result;
	}
	
	public String getORSOrderNum() {
		
		String result = null;
		
		try {
			
			BigDecimal approvalCode = getJdbcTemplate().queryForObject(GET_ORS_ORDER_NUM,BigDecimal.class);
						
			result = new DecimalFormat("000000000000").format(approvalCode);
			result ="A".concat(result);
		} catch (DataAccessException ex) {
			System.out.println("empty");
			ex.printStackTrace();
			return null;
		}
		
		return result;
	}
	
	public List<ProductPlaticTypeLinkDTO> getProductPlasticType(BigDecimal productId){
		List<ProductPlaticTypeLinkDTO> resultList= null;
		
		Object[] args = null;
		int[] types = null;
		
		try {
					
			args = new Object[] {productId,MBBORSConstant.DB_STATUS_ACTIVE};
			types = new int[] {Types.BIGINT,Types.INTEGER};
			resultList = getJdbcTemplate().query(GET_PLASTIC_TYPE,args,types,new ProductPlasticTypeRowMapper());
						
		} catch (DataAccessException ex) {
			System.out.println("empty");
			ex.printStackTrace();
			return null;
		}
		
		return resultList;
	}
	
	@Override
	public ValidateAirlineRedeemProductResponse validateAirlineRedeemProduct(ValidateAirlineRedeemProductRequest validateAirlineRedeemProductRequest) throws Exception {
		try {
			ValidateAirlineRedeemProductResponse validateAirlineRedeemProductResponse = new ValidateAirlineRedeemProductResponse();
			StringBuffer validateAirlineRedeemProductQuery = new StringBuffer("");
			validateAirlineRedeemProductQuery.append("SELECT CUST_NO FROM mt_CARDHOLDER_POINT_BUCKET cpb ")
			.append("INNER JOIN mt_PRODUCT_PLASTIC_TYPE ppt ON ppt.PLASTIC_TYPE_ID = cpb.PLASTIC_TYPE_ID ")
			.append("WHERE cpb.PROGRAM_ID in (SELECT PROGRAM_ID FROM lk_PROGRAM WHERE REWARD_TYPE_ID = ? AND STATUS_ID = 1) ")
			.append("AND cpb.CUST_IC_NO = ? AND cpb.STATUS_ID = 1 ")
			.append("AND ppt.PRODUCT_ID = ? AND ppt.STATUS_ID = 1 ");
			
			Object[] args = new Object[] {validateAirlineRedeemProductRequest.getRewardTypeID(), validateAirlineRedeemProductRequest.getIcNumber(), validateAirlineRedeemProductRequest.getProductID()};
			try {
				String cust_no =  getJdbcTemplate().queryForObject(validateAirlineRedeemProductQuery.toString(), args, String.class);
				if(!StringUtils.isEmpty(cust_no)) {
					validateAirlineRedeemProductResponse.setResponseCode("00");
					validateAirlineRedeemProductResponse.setResponseMessage("Success");
				}
			}catch (DataAccessException ex) {
				// handle display error
				StringBuffer validateAirlineRedeemProductErrorQuery = new StringBuffer("");
				validateAirlineRedeemProductErrorQuery.append("SELECT pt.PLASTIC_TYPE_CODE + '-'+ pt.PLASTIC_TYPE_DESC AS PLASTIC_TYPE_CODE_DESC FROM mt_PRODUCT_PLASTIC_TYPE ppt ")
				.append("INNER JOIN lk_PLASTIC_TYPE pt ON ppt.PLASTIC_TYPE_ID = pt.PLASTIC_TYPE_ID ")
				.append("WHERE ppt.PRODUCT_ID = ? AND ppt.STATUS_ID = 1 ");
				
				String validCardList = "";
				List<Map<String, Object>> rows = getJdbcTemplate().queryForList(validateAirlineRedeemProductErrorQuery.toString(), new Object[] {validateAirlineRedeemProductRequest.getProductID()});
				if(rows.size()>0) {
					for (Map<String, Object> row : rows) {
						String cardDetail = row.get("PLASTIC_TYPE_CODE_DESC").toString();
						validCardList = validCardList + cardDetail + ", ";
					}
					validCardList = validCardList.substring(0, validCardList.length() - 2) + ".";
					String final_msg = "Customer NOT eligible to redeem this product. This product is eligible for Plastic Type:" + validCardList;
					validateAirlineRedeemProductResponse.setResponseCode("01");
					validateAirlineRedeemProductResponse.setResponseMessage(final_msg);
				}else {
					validateAirlineRedeemProductResponse.setResponseCode("02");
					validateAirlineRedeemProductResponse.setResponseMessage("Redemption not available.");
				}
			}
			return validateAirlineRedeemProductResponse;
		}catch(Exception e) {
			throw e;
		}
	}
}
