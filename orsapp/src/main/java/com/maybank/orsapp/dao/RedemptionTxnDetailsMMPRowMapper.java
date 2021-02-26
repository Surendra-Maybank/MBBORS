package com.maybank.orsapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.StringUtils;

import com.maybank.orsapp.dto.RedemptionTxnDetailsMMPResponse;

public class RedemptionTxnDetailsMMPRowMapper implements RowMapper {
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		RedemptionTxnDetailsMMPResponse redemptionTxnDetailsMMPResponse = new RedemptionTxnDetailsMMPResponse();
		redemptionTxnDetailsMMPResponse.setOrderNumber(rs.getString("ORDER_NO"));
		redemptionTxnDetailsMMPResponse.setRedemptionDateTime(rs.getString("CREATED_DATETIME"));
		redemptionTxnDetailsMMPResponse.setCustomerICNo(rs.getString("CUST_IC_NO"));
		redemptionTxnDetailsMMPResponse.setCustomerName(rs.getString("CUST_NAME"));
		redemptionTxnDetailsMMPResponse.setContactNumber(rs.getString("MOBILE_NO"));
		redemptionTxnDetailsMMPResponse.setDeliveryAdd1(rs.getString("DELIVERY_ADDR1"));
		redemptionTxnDetailsMMPResponse.setDeliveryAdd2(rs.getString("DELIVERY_ADDR2"));
		redemptionTxnDetailsMMPResponse.setDeliveryAdd3(rs.getString("DELIVERY_ADDR3"));
		redemptionTxnDetailsMMPResponse.setDeliveryAdd4(rs.getString("DELIVERY_ADDR4"));
		redemptionTxnDetailsMMPResponse.setPointRedeemed(rs.getString("TOTAL_POINT_REDEEMED"));
		redemptionTxnDetailsMMPResponse.setProductCode(rs.getString("PRODUCT_CODE"));
		redemptionTxnDetailsMMPResponse.setProductName(rs.getString("PRODUCT_NAME"));
		String deliveryStatus = !StringUtils.isEmpty(rs.getString("DELIVERY_STATUS"))?rs.getString("DELIVERY_STATUS").equalsIgnoreCase("P")?"Pending":rs.getString("DELIVERY_STATUS").equalsIgnoreCase("D")?"Delivered":rs.getString("DELIVERY_STATUS"):rs.getString("DELIVERY_STATUS");
		redemptionTxnDetailsMMPResponse.setDeliveryStatus(deliveryStatus);
		redemptionTxnDetailsMMPResponse.setCourierReferenceNo(rs.getString("COURIER_REF_NO"));
		redemptionTxnDetailsMMPResponse.setCourierDate(rs.getString("COURIER_DATETIME"));
		redemptionTxnDetailsMMPResponse.setNote(rs.getString("NOTE"));
		
		return redemptionTxnDetailsMMPResponse;
	}
}
