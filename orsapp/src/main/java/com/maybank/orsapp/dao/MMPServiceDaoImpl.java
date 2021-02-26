package com.maybank.orsapp.dao;

import java.sql.Types;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.maybank.orsapp.dto.RedemptionTxnDetailsMMPRequest;
import com.maybank.orsapp.dto.RedemptionTxnDetailsMMPResponse;
import com.maybank.orsapp.dto.RedemptionTxnMMPDetail;
import com.maybank.orsapp.dto.RedemptionTxnMMPRequest;
import com.maybank.orsapp.dto.UpdateDeliveryStatusMMPRequest;

@Repository
public class MMPServiceDaoImpl extends JdbcDaoSupport implements MMPServiceDao {

	@Autowired
	@Qualifier("orsDataSource")
	DataSource datasource;

	@PostConstruct
	private void initialize() {
		setDataSource(datasource);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<RedemptionTxnMMPDetail> getRedemptionTxnMMP(RedemptionTxnMMPRequest redemptionTxnMMPRequest) {
		try {
			int paramSize = 0;
			int paramFill = 0;
			// check all input
			if(!StringUtils.isEmpty(redemptionTxnMMPRequest.getORSMID())) {paramSize++;}
			if(!StringUtils.isEmpty(redemptionTxnMMPRequest.getStartDate()) && !StringUtils.isEmpty(redemptionTxnMMPRequest.getEndDate())) {paramSize+=2;}
			if(!StringUtils.isEmpty(redemptionTxnMMPRequest.getOrderNumber())) {paramSize++;}
			if(!StringUtils.isEmpty(redemptionTxnMMPRequest.getCustomerICNo())) {paramSize++;}
			if(!StringUtils.isEmpty(redemptionTxnMMPRequest.getCourierRefNo())) {paramSize++;}
			Object[] args = new Object[paramSize];
			
			StringBuffer redemptionTxnQuery = new StringBuffer("");
			redemptionTxnQuery.append("SELECT ptd.POINT_TXN_DETAIL_ID, ")
			.append("ptd.ORDER_NO, ")
			.append("FORMAT(ptd.CREATED_DATETIME, 'dd-MM-yyyy HH:mm:ss') AS CREATED_DATETIME, ")
			.append("pt.CUST_IC_NO, ")
			.append("CONCAT(pt.FIRST_NAME, ',' , pt.LAST_NAME) AS CUST_NAME, ")
			.append("ptd.UNIT_POINT * ptd.QTY AS TOTAL_POINT_REDEEMED, ")
			.append("p.PRODUCT_CODE + IIF(ptd.QTY IS NULL, '', ' (' + CAST(ptd.QTY AS NVARCHAR(20)) + ')') AS PRODUCT_CODE, ")
			.append("p.PRODUCT_NAME, ")
			.append("ptd.DELIVERY_STATUS, ")
			.append("ptd.DOCKET_NO AS COURIER_REF_NO, ")
			.append("FORMAT(ptd.FULFILMENT_DATETIME, 'dd-MM-yyyy HH:mm:ss') AS COURIER_DATETIME ")
			.append("FROM ap_POINT_TXN_DETAIL ptd WITH (NOLOCK) ")
			.append("INNER JOIN ap_POINT_TXN pt WITH (NOLOCK) ON pt.POINT_TXN_ID = ptd.POINT_TXN_ID ")
			.append("INNER JOIN mt_MERCHANT m WITH (NOLOCK) ON ptd.MERCHANT_ID = m.MERCHANT_ID AND ptd.STATUS_ID = 1 ")
			.append("LEFT JOIN mt_PRODUCT p WITH (NOLOCK) ON ptd.PRODUCT_ID = p.PRODUCT_ID ")
			.append("WHERE pt.STATUS_ID = 1 ");
			
			if(!StringUtils.isEmpty(redemptionTxnMMPRequest.getORSMID())) {redemptionTxnQuery.append("AND m.MID = ? "); args[paramFill++] = redemptionTxnMMPRequest.getORSMID();}
			if(!StringUtils.isEmpty(redemptionTxnMMPRequest.getStartDate()) && !StringUtils.isEmpty(redemptionTxnMMPRequest.getEndDate())) {redemptionTxnQuery.append("AND pt.CREATED_DATETIME BETWEEN ? AND ? "); args[paramFill++] = redemptionTxnMMPRequest.getStartDate(); args[paramFill++] = redemptionTxnMMPRequest.getEndDate();}
			if(!StringUtils.isEmpty(redemptionTxnMMPRequest.getOrderNumber())) {redemptionTxnQuery.append("AND pt.ORDER_NO = ? "); args[paramFill++] = redemptionTxnMMPRequest.getOrderNumber();}
			if(!StringUtils.isEmpty(redemptionTxnMMPRequest.getCustomerICNo())) {redemptionTxnQuery.append("AND pt.CUST_IC_NO = ? "); args[paramFill++] = redemptionTxnMMPRequest.getCustomerICNo();}
			if(!StringUtils.isEmpty(redemptionTxnMMPRequest.getCourierRefNo())) {redemptionTxnQuery.append("AND ptd.DOCKET_NO = ? "); args[paramFill++] = redemptionTxnMMPRequest.getCourierRefNo();}
			
			ArrayList<RedemptionTxnMMPDetail> redemptionTxnDtl = (ArrayList<RedemptionTxnMMPDetail>)getJdbcTemplate().query(redemptionTxnQuery.toString(), new RedemptionTxnMMPDetailRowMapper(), args);
			return redemptionTxnDtl;
		} catch(EmptyResultDataAccessException e) {
			throw e;
		} catch (DataAccessException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public RedemptionTxnDetailsMMPResponse getRedemptionTxnDetailsMMP(RedemptionTxnDetailsMMPRequest redemptionTxnDetailsMMPRequest) {
		try {
			
			RedemptionTxnDetailsMMPResponse redemptionTxnDetailsMMPResponse = null;
			
			StringBuffer redemptionTxnDetailsQuery = new StringBuffer("");
			redemptionTxnDetailsQuery.append("SELECT ptd.ORDER_NO, ")
			.append("FORMAT(ptd.CREATED_DATETIME, 'dd-MM-yyyy HH:mm:ss') AS CREATED_DATETIME, ")
			.append("pt.CUST_IC_NO, ")
			.append("CONCAT(pt.FIRST_NAME, ', ' , pt.LAST_NAME) AS CUST_NAME, ")
			.append("pt.MOBILE_NO, ")
			.append("pt.DELIVERY_ADDR1, ")
			.append("pt.DELIVERY_ADDR2, ")
			.append("pt.DELIVERY_ADDR3, ")
			.append("pt.DELIVERY_ADDR4, ")
			.append("ptd.UNIT_POINT * ptd.QTY AS TOTAL_POINT_REDEEMED, ")
			.append("p.PRODUCT_CODE + IIF(ptd.QTY IS NULL, '', ' (' + CAST(ptd.QTY AS NVARCHAR(20)) + ')') AS PRODUCT_CODE, ")
			.append("p.PRODUCT_NAME, ")
			.append("ptd.DELIVERY_STATUS, ")
			.append("ptd.DOCKET_NO AS COURIER_REF_NO, ")
			.append("FORMAT(ptd.FULFILMENT_DATETIME, 'dd-MM-yyyy HH:mm:ss') AS COURIER_DATETIME, ")
			.append("ptd.NOTE ")
			.append("FROM ap_POINT_TXN_DETAIL ptd WITH (NOLOCK) ")
			.append("INNER JOIN ap_POINT_TXN pt WITH (NOLOCK) ON pt.POINT_TXN_ID = ptd.POINT_TXN_ID ")
			.append("INNER JOIN mt_MERCHANT m WITH (NOLOCK) ON ptd.MERCHANT_ID = m.MERCHANT_ID AND ptd.STATUS_ID = 1 ")
			.append("LEFT JOIN mt_PRODUCT p WITH (NOLOCK) ON ptd.PRODUCT_ID = p.PRODUCT_ID ")
			.append("WHERE pt.STATUS_ID = 1 AND ptd.POINT_TXN_DETAIL_ID = ? ");

			Object[] args = new Object[] {redemptionTxnDetailsMMPRequest.getPointTxnDetailID()};
			redemptionTxnDetailsMMPResponse = (RedemptionTxnDetailsMMPResponse) getJdbcTemplate().queryForObject(redemptionTxnDetailsQuery.toString(), args, new RedemptionTxnDetailsMMPRowMapper());
			
			return redemptionTxnDetailsMMPResponse;
		}catch(Exception e) {
			throw e;
		}
	}

	@Override
	public int updateDeliveryStatusMMP(UpdateDeliveryStatusMMPRequest updateDeliveryStatusMMPRequest) {
		try {
			int paramSize = 0;
			int paramFill = 0;
			
			if(!StringUtils.isEmpty(updateDeliveryStatusMMPRequest.getCourierRefNo())) {paramSize++;}
			if(!StringUtils.isEmpty(updateDeliveryStatusMMPRequest.getCourierDate())) {paramSize++;}
			if(!StringUtils.isEmpty(updateDeliveryStatusMMPRequest.getNote())) {paramSize++;}
			if(!StringUtils.isEmpty(updateDeliveryStatusMMPRequest.getUserPFNo())) {paramSize++;}
			if(!StringUtils.isEmpty(updateDeliveryStatusMMPRequest.getPointTxnDetailID())) {paramSize++;}
			
			Object[] args = new Object[paramSize];
			int[] types = new int[paramSize];
			StringBuffer updateDeliveryStatusQuery = new StringBuffer("");
			updateDeliveryStatusQuery.append("UPDATE ap_POINT_TXN_DETAIL SET ")
			.append("DELIVERY_STATUS = 'D', ");
			if(!StringUtils.isEmpty(updateDeliveryStatusMMPRequest.getCourierRefNo())) {updateDeliveryStatusQuery.append("DOCKET_NO = ?, "); args[paramFill] = updateDeliveryStatusMMPRequest.getCourierRefNo(); types[paramFill++] = Types.VARCHAR;}
			if(!StringUtils.isEmpty(updateDeliveryStatusMMPRequest.getCourierDate())) {updateDeliveryStatusQuery.append("FULFILMENT_DATETIME = ?, "); args[paramFill] = updateDeliveryStatusMMPRequest.getCourierDate(); types[paramFill++] = Types.VARCHAR;}
			if(!StringUtils.isEmpty(updateDeliveryStatusMMPRequest.getNote())) {updateDeliveryStatusQuery.append("NOTE = ?, "); args[paramFill] = updateDeliveryStatusMMPRequest.getNote(); types[paramFill++] = Types.VARCHAR;}
			if(!StringUtils.isEmpty(updateDeliveryStatusMMPRequest.getUserPFNo())) {updateDeliveryStatusQuery.append("EDITED_BY = ?, "); args[paramFill] = updateDeliveryStatusMMPRequest.getUserPFNo(); types[paramFill++] = Types.VARCHAR;}
			updateDeliveryStatusQuery.append("EDITED_DATETIME = GETDATE() ");
			if(!StringUtils.isEmpty(updateDeliveryStatusMMPRequest.getPointTxnDetailID())) {updateDeliveryStatusQuery.append("WHERE POINT_TXN_DETAIL_ID = ? "); args[paramFill] = updateDeliveryStatusMMPRequest.getPointTxnDetailID(); types[paramFill++] = Types.VARCHAR;}

			int rowsUpdated= getJdbcTemplate().update(updateDeliveryStatusQuery.toString(), args, types);
			
			return rowsUpdated;
		}catch(Exception e) {
			throw e;
		}
	}

}
