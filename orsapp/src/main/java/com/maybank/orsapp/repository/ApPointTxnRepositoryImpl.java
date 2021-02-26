/**
 * 
 */
package com.maybank.orsapp.repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.CollectionUtils;

import com.maybank.orsapp.controller.request.RedemptionHistorySearchRequest;
import com.maybank.orsapp.dto.RedemptionCustomerDto;
import com.maybank.orsapp.dto.RedemptionHistorySearchDto;
import com.maybank.orsapp.dto.RedemptionSearchCardDto;
import com.maybank.orsapp.dto.RedemptionSearchProductDto;
import com.maybank.orsapp.entities.ApPointTxnBucketDetails;
import com.maybank.orsapp.utils.TimeStampConversion;

/**
 * @author 80003905
 *
 */
public class ApPointTxnRepositoryImpl extends TimeStampConversion implements ApPointTxnRepositoryCustom {

	@PersistenceContext
	@Qualifier("entityManager")
	EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RedemptionHistorySearchDto> getRedemptionHistorySearchList(
			RedemptionHistorySearchRequest searchRequest) {

		List<RedemptionHistorySearchDto> redemptionHistoryList = new ArrayList<>();

		StringBuilder searchRedemptionList = new StringBuilder("SELECT DISTINCT ap.[POINT_TXN_ID], ap.[ORDER_NO],  "
				+ " (SELECT DISTINCT(apb.CARD_NO)+ ', '  FROM [dbo].[ap_POINT_TXN_BUCKET_DETAIL] apb  WHERE ap.POINT_TXN_ID = apb.POINT_TXN_ID FOR XML PATH('')) [CARD_NUMBER], "
				+ " ap.[CREATED_DATETIME] AS TRANSACTION_DATETIME, "
				+ " (SELECT DISTINCT(p.PRODUCT_NAME)+ ', '  FROM [dbo].[ap_POINT_TXN_DETAIL] apt "
				+ " INNER JOIN [dbo].[mt_PRODUCT] p ON p.PRODUCT_ID = apt.PRODUCT_ID WHERE ap.POINT_TXN_ID = apt.POINT_TXN_ID FOR XML PATH('')) [PRODUCT_NAME], "
				+ " ap.REDEMPTION_STATUS " + " FROM [dbo].[ap_POINT_TXN] ap "
				+ " INNER JOIN [dbo].[ap_POINT_TXN_DETAIL] apd ON ap.POINT_TXN_ID = apd.POINT_TXN_ID "
				+ " LEFT OUTER JOIN [dbo].[mt_MERCHANT] m ON apd.MERCHANT_ID = m.MERCHANT_ID"
				+ " WHERE ap.[STATUS_ID] =:statusId ");

		if (StringUtils.isNotBlank(searchRequest.getCustomerIcNo())) {
			searchRedemptionList.append(" AND ap.[CUST_IC_NO] =:customerIcNo ");
		}

		if (StringUtils.isNotBlank(searchRequest.getOrderNo())) {
			searchRedemptionList.append(" AND ap.[ORDER_NO] =:orderNo ");
		}

		if (StringUtils.isNotBlank(searchRequest.getMerchantId())) {
			searchRedemptionList.append(" AND m.[MID] =:merchantId ");
		}

		if (StringUtils.isNotBlank(searchRequest.getRedemptionStartDate())) {
			searchRedemptionList.append(" AND ap.[CREATED_DATETIME] >=:redemptionStartDate ");
		}

		if (StringUtils.isNotBlank(searchRequest.getRedemptionEndDate())) {
			searchRedemptionList.append(" AND ap.[CREATED_DATETIME] <:redemptionEndDate ");
		}

		if (StringUtils.isNotBlank(searchRequest.getMyTreatsOrderNo())) {
			searchRedemptionList.append(" AND ap.[REF_ORDER_ID] =:myTreatsOrderNo ");
		}

		Query query = getEntityManager().createNativeQuery(searchRedemptionList.toString());
		query.setParameter("statusId", 1);

		if (StringUtils.isNotBlank(searchRequest.getCustomerIcNo())) {
			query.setParameter("customerIcNo", searchRequest.getCustomerIcNo());
		}

		if (StringUtils.isNotBlank(searchRequest.getOrderNo())) {
			query.setParameter("orderNo", searchRequest.getOrderNo());
		}

		if (StringUtils.isNotBlank(searchRequest.getMerchantId())) {
			query.setParameter("merchantId", searchRequest.getMerchantId());
		}

		if (StringUtils.isNotBlank(searchRequest.getRedemptionStartDate())) {
			query.setParameter("redemptionStartDate", formatStartDate(searchRequest.getRedemptionStartDate()));
			// query.setParameter("redemptionStartDate",
			// searchRequest.getRedemptionStartDate());
		}

		if (StringUtils.isNotBlank(searchRequest.getRedemptionEndDate())) {
			query.setParameter("redemptionEndDate", searchRequest.getRedemptionEndDate());
			// query.setParameter("redemptionEndDate",
			// formatDate(searchRequest.getRedemptionEndDate()));
		}

		if (StringUtils.isNotBlank(searchRequest.getMyTreatsOrderNo())) {
			query.setParameter("myTreatsOrderNo", searchRequest.getMyTreatsOrderNo());
		}

		List<Object[]> results = query.getResultList();

		if (CollectionUtils.isEmpty(results)) {
			return Collections.emptyList();
		} else {
			for (Object[] obj : results) {
				RedemptionHistorySearchDto searchDto = new RedemptionHistorySearchDto();
				searchDto.setPointTxnId(obj[1] != null ? ((BigInteger) obj[0]).longValue() : null);
				searchDto.setOrderNo(obj[1] != null ? obj[1].toString() : "");
				if (obj[2] != null) {
					String cardNumbers = obj[2].toString().substring(0, obj[2].toString().length() - 2);
					searchDto.setCustomerCardNumbers(cardNumbers);
				}
				searchDto.setTransactionDateTime(obj[3] != null ? dateTimeFormat((Date) obj[3]) : "");
				if (obj[4] != null) {
					String productNames = obj[4].toString().substring(0, obj[4].toString().length() - 2);
					searchDto.setProductName(productNames);
				}
				// searchDto.setProductName(obj[4] != null?obj[4].toString():"");
				if (obj[5] != null) {
					if (obj[5].toString().equalsIgnoreCase("S")) {
						searchDto.setRedemptionStatus("SUCCESSFUL");
					} else if (obj[5].toString().equalsIgnoreCase("R")) {
						searchDto.setRedemptionStatus("REVERSED");
					} else {
						searchDto.setRedemptionStatus("VOID");
					}
				}

				redemptionHistoryList.add(searchDto);
			}
			if (CollectionUtils.isEmpty(redemptionHistoryList)) {
				return Collections.emptyList();
			} else
				return redemptionHistoryList;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public RedemptionCustomerDto getRedemptionCustomer(Long pointTxnId) {
		List<RedemptionCustomerDto> result = null;

		String queryForCard = "SELECT NEW com.maybank.orsapp.dto.RedemptionCustomerDto(ap.customerIcNo,  ap.firstName,  ap.lastName,  ap.deliveryAddress_1, ap.deliveryAddress_2,  ap.deliveryAddress_3,  ap.deliveryAddress_4,  "
				+ "ap.deliveryZipCode, ap.deliveryCity,  ap.emailId,  ap.homeNumber, ap.officeNumber, ap.mobileNumber,  ap.orderNo,  ap.redemptionSource, ap.redemptionStatus,  ap.createdBy,  ap.createdDateTime, rt.rewardTypeCode, rt.rewardTypeDesc, ap.cdchCardNo, ap.airlineMemberNo) "
				+ " FROM ApPointTxn ap " + " INNER JOIN RewardType rt ON rt.id = ap.rewardTypeId "
				+ " WHERE ap.pointTxnId =:pointTxnId ";

		Query query = getEntityManager().createQuery(queryForCard);
		query.setParameter("pointTxnId", pointTxnId);

		result = query.getResultList();
		if (CollectionUtils.isEmpty(result)) {
			return null;
		} else {
			return result.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RedemptionSearchProductDto> getRedeemedProductList(Long pointTxnId) {
		List<RedemptionSearchProductDto> result = null;

		String queryForCard = "SELECT NEW com.maybank.orsapp.dto.RedemptionSearchProductDto(p.productCode, p.productName, m.mid, m.merchant_name, apd.tid, apd.unitPoint, apd.quantity, apd.docketNo, apd.fulfilmentDatetime) "
				+ " FROM ApPointTxnDetails apd " + " INNER JOIN ApPointTxn ap ON ap.pointTxnId = apd.pointTxnId"
				+ " INNER JOIN Product p ON apd.productId = p.id "
				+ " INNER JOIN Merchant m ON m.merchant_id = p.merchantId "
				// + " LEFT OUTER JOIN Terminal t ON m.merchant_id = t.merchant_id "
				+ " WHERE ap.pointTxnId =:pointTxnId " + " ORDER BY p.productCode asc";

		Query query = getEntityManager().createQuery(queryForCard);
		query.setParameter("pointTxnId", pointTxnId);

		result = query.getResultList();
		if (CollectionUtils.isEmpty(result)) {
			return Collections.emptyList();
		} else {
			return result;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RedemptionSearchCardDto> getRedeemedCardList(Long pointTxnId) {
		List<RedemptionSearchCardDto> result = null;

		String queryForCard = "SELECT NEW com.maybank.orsapp.dto.RedemptionSearchCardDto(apd.cardNo, sum(apd.totalPointRedeemed), cpb.totalPointsBal) "
				+ " FROM ApPointTxnBucketDetails apd " + " INNER JOIN ApPointTxn ap ON ap.pointTxnId = apd.pointTxnId"
				+ " INNER JOIN CardHolderPointBucket cpb ON apd.cardHolderPointBucketId = cpb.cardholderPointBucketId "
				+ " WHERE ap.pointTxnId =:pointTxnId " + " GROUP BY apd.cardNo, cpb.totalPointsBal";

		Query query = getEntityManager().createQuery(queryForCard);
		query.setParameter("pointTxnId", pointTxnId);

		result = query.getResultList();
		if (CollectionUtils.isEmpty(result)) {
			return Collections.emptyList();
		} else {
			return result;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ApPointTxnBucketDetails> getPointTxnBucketDetailsForVoidRedemption(Long pointTxnId) {
		List<ApPointTxnBucketDetails> results = null;

		StringBuilder queryForVoidRedeem = new StringBuilder("SELECT apd FROM ApPointTxnBucketDetails apd "
				+ " INNER JOIN ApPointTxn ap ON ap.pointTxnId = apd.pointTxnId "
				+ " WHERE ap.pointTxnId =:pointTxnId AND apd.statusId =:statusId AND ap.redemptionStatus !=:redemptionStatus ");

		Query query = getEntityManager().createQuery(queryForVoidRedeem.toString());
		query.setParameter("pointTxnId", pointTxnId);
		query.setParameter("statusId", 1);
		query.setParameter("redemptionStatus", "V");

		results = query.getResultList();

		if (CollectionUtils.isEmpty(results)) {
			return Collections.emptyList();
		} else {
			return results;
		}
	}

}
