/**
 * 
 */
package com.maybank.orsapp.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.maybank.orsapp.dto.CardHolderPointBucketDto;
import com.maybank.orsapp.dto.MTCardHolderPointBucketDTO;

/**
 * @author 80003905
 *
 */

@Repository
public class CardHolderPointBucketRepositoryImpl implements CardHolderPointBucketRepositoryCustom {

	@PersistenceContext
	@Qualifier("entityManager")
    EntityManager entityManager;
	
	public EntityManager getEntityManager() {
	    return entityManager;
	}
	
	public static final String MT_CARDHOLDER_BUCKET_DETAILS = " FROM CardHolderPointBucket chpb ";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CardHolderPointBucketDto> pointInquiryResponseForIcNo(String customerIcNo, List<Long> programId) {
		
		List<CardHolderPointBucketDto> results = null;
		
		StringBuilder queryForIcNo = new StringBuilder("SELECT NEW com.maybank.orsapp.dto.CardHolderPointBucketDto(chpb.cardholderPointBucketId, chpb.cardNo, chpb.custIcNo, chpb.cardPostFlag, "
									+ " p.programCode, chpb.transformedTotalPointsBal, chpb.custNo, chpb.totalPointsSign, p.programDesc) "
				  					+ MT_CARDHOLDER_BUCKET_DETAILS
				  					+ " INNER JOIN Programs p ON p.id = chpb.programId"
				  					+ " WHERE chpb.custIcNo =:customerIcNo AND chpb.statusId =:statusId AND chpb.cardPostFlag !=:cardPostFlag");
		if(!CollectionUtils.isEmpty(programId)) {
			queryForIcNo.append(" AND p.id in (:programId)");
		}
		
		Query query = getEntityManager().createQuery(queryForIcNo.toString());
		query.setParameter("customerIcNo", customerIcNo);
		query.setParameter("statusId", 1);
		query.setParameter("cardPostFlag", "NP");
		
		if(!CollectionUtils.isEmpty(programId)) {
			query.setParameter("programId", programId);
		}
		
		results = query.getResultList();
		
		if(CollectionUtils.isEmpty(results)) {
			return Collections.emptyList();
		}else {
			Optional<CardHolderPointBucketDto> matchingObject = results.stream().filter(p -> p.getCardPostFlag().equals("PP")).findAny();
			if(matchingObject.isPresent()) {
				List<Long> listOfIds = results.stream().map(CardHolderPointBucketDto::getCardholderPointBucketId).collect(Collectors.toList());
				List<CardHolderPointBucketDto> resultsForCustNo = getPointsBalForCustomerNo(listOfIds, matchingObject.get().getCustNo(), programId);
				if(CollectionUtils.isEmpty(resultsForCustNo)) {
					return results;
				}else {
					results.addAll(resultsForCustNo);
					return results;
				}
			}else {
				return results;
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CardHolderPointBucketDto> pointInquiryResponseForCustomerCreditCardNo(String customerCreditCardNo, Boolean isTerminal) {
		
		List<CardHolderPointBucketDto> results = null;
		
		String queryForCardNo = "SELECT NEW com.maybank.orsapp.dto.CardHolderPointBucketDto(chpb.custIcNo, chpb.programId) "
								+ MT_CARDHOLDER_BUCKET_DETAILS
								+ " WHERE chpb.cardNo  =:customerCreditCardNo"
								+ " AND chpb.statusId =:statusId ";
		
		Query query = getEntityManager().createQuery(queryForCardNo);
		query.setParameter("customerCreditCardNo", customerCreditCardNo);
		query.setParameter("statusId", 1);
		
		results = query.getResultList();
		
		if(CollectionUtils.isEmpty(results)) {
			return Collections.emptyList();
		}else {
			if(isTerminal) {
				List<Long> listOfProgramIds = new ArrayList<>();
				listOfProgramIds.add(results.get(0).getProgramId());
				return pointInquiryResponseForIcNo(results.get(0).getCustIcNo(), listOfProgramIds);
			}else {
				return pointInquiryResponseForIcNo(results.get(0).getCustIcNo(), null);
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CardHolderPointBucketDto> pointInquiryResponseForCustomerDebitCardNo(String customerDebitCardNo, Boolean isTerminal) {
		List<CardHolderPointBucketDto> results = null;
		
		String queryForCardNo = "SELECT NEW com.maybank.orsapp.dto.CardHolderPointBucketDto(dch.custIcNo) "
								+ " FROM DebitCardHolder dch"
								+ " WHERE dch.cardNo = :customerDebitCardNo"
								+ " AND dch.statusId =:statusId ";
		
		Query query = getEntityManager().createQuery(queryForCardNo);
		query.setParameter("customerDebitCardNo", customerDebitCardNo);
		query.setParameter("statusId", 1);
		
		results = query.getResultList();
		
		if(CollectionUtils.isEmpty(results)) {
			return Collections.emptyList();
		}else {
			if(isTerminal) {
				List<Long> listOfProgramIds = new ArrayList<>();
				listOfProgramIds.add(new Long(1));
				listOfProgramIds.add(new Long(2));
				return pointInquiryResponseForIcNo(results.get(0).getCustIcNo(), listOfProgramIds);
			}else {
				return pointInquiryResponseForIcNo(results.get(0).getCustIcNo(), null);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private List<CardHolderPointBucketDto> getPointsBalForCustomerNo(List<Long> listOfIds, String customerNo, List<Long> programId){
		List<CardHolderPointBucketDto> results = null;
		
		StringBuilder queryForIcNo = new StringBuilder("SELECT NEW com.maybank.orsapp.dto.CardHolderPointBucketDto(chpb.cardholderPointBucketId, chpb.cardNo, chpb.custIcNo, chpb.cardPostFlag, "
									+ " p.programCode, chpb.transformedTotalPointsBal, chpb.custNo, chpb.totalPointsSign, p.programDesc) "
				  					+ MT_CARDHOLDER_BUCKET_DETAILS
				  					+ " INNER JOIN Programs p ON p.id = chpb.programId"
				  					+ " WHERE chpb.custNo =:customerNo AND chpb.statusId =:statusId AND chpb.cardPostFlag !=:cardPostFlag");
		
		if(!CollectionUtils.isEmpty(listOfIds)) {
			queryForIcNo.append(" AND chpb.cardholderPointBucketId not in (:listOfIds)");
		}
		
		if(!CollectionUtils.isEmpty(programId)) {
			queryForIcNo.append(" AND p.id in (:programId)");
		}
		
		Query query = getEntityManager().createQuery(queryForIcNo.toString());
		query.setParameter("customerNo", customerNo);
		query.setParameter("statusId", 1);
		query.setParameter("cardPostFlag", "PP");
		
		if(!CollectionUtils.isEmpty(listOfIds)) {
			query.setParameter("listOfIds", listOfIds);
		}
		
		if(!CollectionUtils.isEmpty(programId)) {
			query.setParameter("programId", programId);
		}
		
		results = query.getResultList();
		
		if(CollectionUtils.isEmpty(results)) {
			return Collections.emptyList();
		}else {
			return results;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MTCardHolderPointBucketDTO> getPointBucketDetailsForVoidRedemption(Long apPointTxnId) {
		
		List<MTCardHolderPointBucketDTO> results = null;
		
		StringBuilder queryForVoidRedeem = new StringBuilder("SELECT NEW com.maybank.orsapp.dto.MTCardHolderPointBucketDTO(chpb.cardholderPointBucketId, "
				+ "chpb.totalPointsSign, chpb.totalPointsBal, chpb.transformedTotalPointsBal, chpb.bucket01PointSign, chpb.bucket01PointBal, chpb.bucket02PointSign, chpb.bucket02PointBal, "
				+ "chpb.bucket03PointSign, chpb.bucket03PointBal, chpb.bucket04PointSign, chpb.bucket04PointBal, chpb.bucket05PointSign, chpb.bucket05PointBal, "
				+ "chpb.bucket06PointSign, chpb.bucket06PointBal, chpb.bucket07PointSign, chpb.bucket07PointBal, chpb.bucket08PointSign, chpb.bucket08PointBal, "
				+ "chpb.bucket09PointSign, chpb.bucket09PointBal, chpb.bucket10PointSign, chpb.bucket10PointBal, chpb.bucket11PointSign, chpb.bucket11PointBal, "
				+ "chpb.bucket12PointSign, chpb.bucket12PointBal, chpb.bucket13PointSign, chpb.bucket13PointBal, chpb.bucket14PointSign, chpb.bucket14PointBal, "
				+ "chpb.bucket15PointSign, chpb.bucket15PointBal, chpb.bucket16PointSign, chpb.bucket16PointBal, chpb.bucket17PointSign, chpb.bucket17PointBal, "
				+ "chpb.bucket18PointSign, chpb.bucket18PointBal, chpb.bucket19PointSign, chpb.bucket19PointBal, chpb.bucket20PointSign, chpb.bucket20PointBal, "
				+ "chpb.bucket21PointSign, chpb.bucket21PointBal, chpb.bucket22PointSign, chpb.bucket22PointBal, chpb.bucket23PointSign, chpb.bucket23PointBal, "
				+ "chpb.bucket24PointSign, chpb.bucket24PointBal, chpb.bucket25PointSign, chpb.bucket25PointBal, chpb.bucket26PointSign, chpb.bucket26PointBal, "
				+ "chpb.bucket27PointSign, chpb.bucket27PointBal, chpb.bucket28PointSign, chpb.bucket28PointBal, chpb.bucket29PointSign, chpb.bucket29PointBal, "
				+ "chpb.bucket30PointSign, chpb.bucket30PointBal, chpb.bucket31PointSign, chpb.bucket31PointBal, chpb.bucket32PointSign, chpb.bucket32PointBal, "
				+ "chpb.bucket33PointSign, chpb.bucket33PointBal, chpb.bucket34PointSign, chpb.bucket34PointBal, chpb.bucket35PointSign, chpb.bucket35PointBal, "
				+ "chpb.bucket36PointSign, chpb.bucket36PointBal) "
					+ MT_CARDHOLDER_BUCKET_DETAILS
					+ " INNER JOIN ApPointTxnBucketDetails apd ON apd.cardHolderPointBucketId = chpb.cardholderPointBucketId"
					+ " INNER JOIN ApPointTxn ap ON ap.pointTxnId = apd.pointTxnId "
					+ " WHERE ap.pointTxnId =:apPointTxnId AND chpb.statusId =:statusId ");
		
		Query query = getEntityManager().createQuery(queryForVoidRedeem.toString());
		query.setParameter("apPointTxnId", apPointTxnId);
		query.setParameter("statusId", 1);
		
		results = query.getResultList();
		
		if(CollectionUtils.isEmpty(results)) {
			return Collections.emptyList();
		}else {
			return results;
		}
	}

}
