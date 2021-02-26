/**
 * 
 */
package com.maybank.orsapp.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.maybank.orsapp.dto.AirlinesDto;
import com.maybank.orsapp.dto.CategoryTypeDto;
import com.maybank.orsapp.dto.ProductDto;
import com.maybank.orsapp.dto.ProgramDto;

/**
 * @author 80003905
 *
 */

@Repository
public class ProductDaoImpl extends JdbcDaoSupport implements ProductDao {
	
	@Autowired
	@Qualifier("orsDataSource")
	DataSource datasource;

	@PostConstruct
	private void initialize() {
		setDataSource(datasource);
	}

	@Override
	public List<CategoryTypeDto> getAllActiveCategoryTypes() {
		Object[] args = null;
		final String queryForActiveCategoryTypes = "SELECT [CATEGORY_TYPE_ID], [CATEGORY_TYPE_CODE], [CATEGORY_TYPE_DESC], "
													+ "[IS_CREDIT_AMOUNT], [IS_DEBIT_AMOUNT], [IS_POINT_CONVERSION] "
										 			+ "FROM  [dbo].[lk_CATEGORY_TYPE] "
										 			+ "WHERE [STATUS_ID] = '1'";
		
		ArrayList<CategoryTypeDto> categoryTypeDtoList = (ArrayList<CategoryTypeDto>) getJdbcTemplate().query(queryForActiveCategoryTypes, new CategoryTypeDtoRowMapper(), args);
		
		if(CollectionUtils.isEmpty(categoryTypeDtoList)) {
			return Collections.emptyList();
		}else {
			return categoryTypeDtoList;
		}
	}

	@Override
	public List<AirlinesDto> getAllActiveAirlines() {
		Object[] args = null;
		final String queryForActiveAirlines = "SELECT [AIRLINES_ID], [AIRLINES_CODE], [AIRLINES_DESC] " 
									 			+ "FROM  [dbo].[lk_AIRLINES] "
									 			+ "WHERE [STATUS_ID] = '1'";
		
		ArrayList<AirlinesDto> airlinesDtoList = (ArrayList<AirlinesDto>) getJdbcTemplate().query(queryForActiveAirlines, new AirlinesDtoRowMapper(), args);
		
		if(CollectionUtils.isEmpty(airlinesDtoList)) {
			return Collections.emptyList();
		}else {
			return airlinesDtoList;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProgramDto> getAllActivePrograms() {
		Object[] args = null;
		final String queryForActiveAirlines = "SELECT [PROGRAM_ID], [PROGRAM_CODE], [PROGRAM_DESC] " 
										 			+ "FROM [dbo].[lk_PROGRAM] "
										 			+ "WHERE [STATUS_ID] = '1'";
		
		ArrayList<ProgramDto> programDtoList = (ArrayList<ProgramDto>) getJdbcTemplate().query(queryForActiveAirlines, new ProgramsDtoRowMapper(), args);
		
		if(CollectionUtils.isEmpty(programDtoList)) {
			return Collections.emptyList();
		}else {
			return programDtoList;
		}
	}
	
	@SuppressWarnings("unchecked")
	private void getProductsByRewardTypeId(Long rewardTypeId) {
		Object[] args = null;
		final String queryForActiveAirlines = "SELECT p.* " 
										 			+ "FROM [dbo].[mt_PRODUCT] p "
										 			+ "INNER JOIN [ORS].[dbo].[mt_PRODUCT_PROGRAM] pp on pp.PRODUCT_ID = p.PRODUCT_ID "
										 			+ "INNER JOIN [ORS].[dbo].[lk_PROGRAM] lp on lp.PROGRAM_ID = pp.PROGRAM_ID "
										 			+ "INNER JOIN [ORS].[dbo].[lk_REWARD_TYPE] rt on rt.REWARD_TYPE_ID = lp.REWARD_TYPE_ID "
										 			+ "WHERE rt.[REWARD_TYPE_ID] = "+rewardTypeId+" AND p.[STATUS_ID] = 1";
		
		ArrayList<ProgramDto> programDtoList = (ArrayList<ProgramDto>) getJdbcTemplate().query(queryForActiveAirlines, new ProgramsDtoRowMapper(), args);
		
		if(CollectionUtils.isEmpty(programDtoList)) {
			//return Collections.emptyList();
		}else {
			//return programDtoList;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductDto> getAllActiveProducts(){
		
		Object[] args = null;
		final String queryForProducts = "select "
							           + "p.PRODUCT_ID as PRODUCT_ID, "
							           + "p.PRODUCT_CODE as PRODUCT_CODE, "
							           + "p.PRODUCT_NAME as PRODUCT_NAME, "
							           + "p.MERCHANT_COST as MERCHANT_COST, "
							           + "p.ACTUAL_PRODUCT_COST as ACTUAL_PRODUCT_COST, "
							           + "p.STATUS_ID as STATUS_ID, "
							           + "m.MERCHANT_NAME as MERCHANT_NAME, "
							           + "p.QTY as QTY, "
							           + "(	SELECT CASE " + 
							           			"  WHEN lp.PROGRAM_CODE  LIKE '%,'  THEN LEFT(lp.PROGRAM_CODE, LEN(lp.PROGRAM_CODE)-1) " + 
							           			"	ELSE lp.PROGRAM_CODE + ', ' " + 
							           			"	END  FROM lk_PROGRAM lp inner join mt_PRODUCT_PROGRAM pp on (lp.PROGRAM_ID=pp.PROGRAM_ID) "
							           + "	WHERE pp.PRODUCT_ID=p.PRODUCT_ID FOR XML PATH('')"
							           + ") AS PROGRAM_CODES, "
							           + "p.VALID_START_DATE as VALID_START_DATE, "
							           + "p.VALID_END_DATE as VALID_END_DATE, "
							           + "ct.CATEGORY_TYPE_CODE as CATEGORY_TYPE_CODE, "
							           + "a.AIRLINES_CODE as AIRLINES_CODE, "
							           + "p.CREDIT_AMOUNT as CREDIT_AMOUNT, "
							           + "p.DEBIT_AMOUNT as DEBIT_AMOUNT, "
							           + "p.CONVERSION_POINT as CONVERSION_POINT, "
							           + "p.REMARKS as REMARKS, "
							           + "p.CREATED_BY as CREATED_BY, "
							           + "p.CREATED_DATETIME as CREATED_DATETIME, "
							           + "p.EDITED_BY as EDITED_BY, "
							           + "p.EDITED_DATETIME as EDITED_DATETIME "
							           + "FROM mt_PRODUCT p "
							           + "left outer join mt_MERCHANT m on (m.MERCHANT_ID=p.MERCHANT_ID) "
							           + "inner join lk_CATEGORY_TYPE ct on (ct.CATEGORY_TYPE_ID=p.CATEGORY_TYPE_ID) "
							           + "left outer join lk_AIRLINES a on (a.AIRLINES_ID=p.AIRLINES_ID) "
							           + "where p.STATUS_ID = 1"
							           + "group by p.PRODUCT_ID , p.PRODUCT_CODE , p.PRODUCT_NAME , p.MERCHANT_COST , p.ACTUAL_PRODUCT_COST , "
							           + "p.STATUS_ID , m.MERCHANT_NAME, p.QTY, p.VALID_START_DATE , p.VALID_END_DATE , ct.CATEGORY_TYPE_CODE , a.AIRLINES_CODE , p.CREDIT_AMOUNT , "
							           + "p.DEBIT_AMOUNT , p.CONVERSION_POINT , p.REMARKS , p.CREATED_BY , p.CREATED_DATETIME , p.EDITED_BY , p.EDITED_DATETIME";
		
		ArrayList<ProductDto> productList = (ArrayList<ProductDto>) getJdbcTemplate().query(queryForProducts, new ProductDtoRowMapper(), args);
		
		if(CollectionUtils.isEmpty(productList)) {
			return null;
		}
		else {
			return productList;
		}
		
	}

}
