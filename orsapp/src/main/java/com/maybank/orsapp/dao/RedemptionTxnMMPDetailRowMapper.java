package com.maybank.orsapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.StringUtils;

import com.maybank.orsapp.dto.RedemptionTxnMMPDetail;

public class RedemptionTxnMMPDetailRowMapper implements RowMapper{

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		RedemptionTxnMMPDetail redemptionTxnMMPDetail = new RedemptionTxnMMPDetail();
		redemptionTxnMMPDetail.setPointTxnDetailID(rs.getString("POINT_TXN_DETAIL_ID"));
		redemptionTxnMMPDetail.setOrderNumber(rs.getString("ORDER_NO"));
		redemptionTxnMMPDetail.setRedemptionDateTime(rs.getString("CREATED_DATETIME"));
		redemptionTxnMMPDetail.setCustomerICNo(rs.getString("CUST_IC_NO"));
		redemptionTxnMMPDetail.setCustomerName(rs.getString("CUST_NAME"));
		redemptionTxnMMPDetail.setPointRedeemed(rs.getString("TOTAL_POINT_REDEEMED"));
		redemptionTxnMMPDetail.setProductCode(rs.getString("PRODUCT_CODE"));
		redemptionTxnMMPDetail.setProductName(rs.getString("PRODUCT_NAME"));
		String deliveryStatus = !StringUtils.isEmpty(rs.getString("DELIVERY_STATUS"))?rs.getString("DELIVERY_STATUS").equalsIgnoreCase("P")?"Pending":rs.getString("DELIVERY_STATUS").equalsIgnoreCase("D")?"Delivered":rs.getString("DELIVERY_STATUS"):rs.getString("DELIVERY_STATUS");
		redemptionTxnMMPDetail.setDeliveryStatus(deliveryStatus);
		redemptionTxnMMPDetail.setCourierReferenceNo(rs.getString("COURIER_REF_NO"));
		redemptionTxnMMPDetail.setCourierDate(rs.getString("COURIER_DATETIME"));
		return redemptionTxnMMPDetail;
	};
}
