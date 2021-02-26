package com.maybank.orsapp.repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.maybank.orsapp.dto.MerchantAllDTO;
import com.maybank.orsapp.dto.MerchantDTO;
import com.maybank.orsapp.dto.MerchantDetailDTO;
import com.maybank.orsapp.dto.MerchantIDsDTO;
import com.maybank.orsapp.dto.MerchentDTO;
import com.maybank.orsapp.entities.Merchant;
import com.maybank.orsapp.entities.Terminal;

@Repository
public class MerchantRepositoryCustomImpl implements MerchantRepositoryCustom {
	
	@PersistenceContext
	@Qualifier("entityManager")
    EntityManager entityManager;
	
	public EntityManager getEntityManager() {
	    return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MerchantAllDTO> getAllMerchant(){
		List<MerchantAllDTO> result = null;

		String hql = "SELECT " + 
				"  NEW com.maybank.orsapp.dto.MerchantAllDTO(mch.merchant_id,mch.mid,mch.merchant_name,mch.store_no,mch.store_name,tr.tier_rate_desc " + 
				"  ,mch.conversion_rate" +
//				"  ,mch.global_max_redeem_point,mch.global_instant_reward_percentage" + 
				"  ,mch.created_by, mch.created_datetime, mch.edited_by,mch.edited_datetime) " + 
				"  from Merchant mch " + 
				"  inner join TierRate tr " + 
				"  on mch.tier_rate_id = tr.tier_rate_id" + 
				" WHERE mch.status_id =:status_id";
		result = entityManager.createQuery(hql)
				.setParameter("status_id", 1).getResultList();
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public MerchantDetailDTO getMerchantDetailByMerchantId(BigDecimal merchantId){
		List<MerchantDetailDTO> resultList = null;
		MerchantDetailDTO result = null;
		
		String hql = "SELECT " + 
				"  NEW com.maybank.orsapp.dto.MerchantDetailDTO(mch.merchant_id,mch.mid,mch.merchant_name,mch.store_no,mch.store_name,tr.tier_rate_id,tr.tier_rate_code,tr.tier_rate_desc " + 
				"  ,mch.conversion_rate,mch.is_auto_payment,mch.global_max_redeem_point,mch.global_instant_reward_percentage" + 
				"  ,stt.status_desc,mch.created_by,mch.created_datetime,mch.edited_by,mch.edited_datetime " +
				"  ,mch.global_receipt_hdr_1,mch.global_receipt_hdr_2,mch.global_receipt_hdr_3 " +
				"  ,mch.global_receipt_ftr_1,mch.global_receipt_ftr_2,mch.global_receipt_ftr_3 " +
				"  ,mch.global_is_point_inquiry,mch.global_is_instant_reward,mch.global_is_point_redemption " +
				"  ,mch.global_is_value_redemption,mch.global_is_gift_code_redemption,mch.global_is_hot_deal_redemption " +
				"  ,mch.global_is_void_redemption,mch.global_is_encryption) " +
				"  from Merchant mch " + 
				"  inner join TierRate tr " + 
				"  on mch.tier_rate_id = tr.tier_rate_id" +
				"  inner join Status stt " + 
				"  on stt.status_id = mch.status_id" +
				"  where mch.merchant_id = :merchantId and mch.status_id= :statusId";
		resultList = entityManager.createQuery(hql)
				.setParameter("merchantId", merchantId)
				.setParameter("statusId", 1).getResultList();
		System.out.println("LIST SIZE : ".concat(Integer.toString(resultList.size())));
		if(resultList!=null&&resultList.size()==1) {
			result = resultList.get(0);
			
			System.out.println("result : ".concat(result.getMerchant_name()));
		}
		
		return result;
	}
	
	@Override
	public int deleteMerchantByMerchantId(BigDecimal merchantId, String username) {
		int result = 0;
		
		String hql = "UPDATE Merchant SET status_id=:status_id , edited_by=:edited_by, edited_datetime=current_time() WHERE merchant_id=:merchant_id";
		
		result = entityManager.createQuery(hql)
				.setParameter("status_id", 2)
				.setParameter("edited_by", username)
				.setParameter("merchant_id", merchantId)
				.executeUpdate();
		
		return result;
	}
	
	@Override
	public int updateMerchantByMerchantId(Merchant merchant, String username) {
		int result = 0;
		
		String hql = "UPDATE Merchant SET edited_by=:edited_by, edited_datetime=current_time(), " +
				"tier_rate_id=:tier_rate_id, conversion_rate=:conversion_rate, "+
				"is_auto_payment=:is_auto_payment, global_max_redeem_point=:global_max_redeem_point, "+
				"global_instant_reward_percentage=:global_instant_reward_percentage, global_receipt_hdr_1=:global_receipt_hdr_1, "+
				
				"global_receipt_hdr_2=:global_receipt_hdr_2, global_receipt_hdr_3=:global_receipt_hdr_3,"+
				"global_receipt_ftr_1=:global_receipt_ftr_1, global_receipt_ftr_2=:global_receipt_ftr_2,"+
				"global_receipt_ftr_3=:global_receipt_ftr_3, global_is_instant_reward=:global_is_instant_reward,"+
				
				"global_is_point_inquiry=:global_is_point_inquiry, global_is_point_redemption=:global_is_point_redemption,"+
				"global_is_value_redemption=:global_is_value_redemption, global_is_gift_code_redemption=:global_is_gift_code_redemption,"+
				"global_is_hot_deal_redemption=:global_is_hot_deal_redemption, global_is_void_redemption=:global_is_void_redemption,"+
				
				"global_is_encryption=:global_is_encryption"+
				
				" WHERE merchant_id=:merchant_id";
		
		
		result = entityManager.createQuery(hql)
				.setParameter("edited_by", username)
				.setParameter("tier_rate_id",merchant.getTier_rate_id()).setParameter("conversion_rate", merchant.getConversion_rate())
				.setParameter("is_auto_payment",merchant.isIs_auto_payment()).setParameter("global_max_redeem_point", merchant.getGlobal_max_redeem_point())
				.setParameter("global_instant_reward_percentage", merchant.getGlobal_instant_reward_percentage()).setParameter("global_receipt_hdr_1", merchant.getGlobal_receipt_hdr_1())
				
				.setParameter("global_receipt_hdr_2", merchant.getGlobal_receipt_hdr_2()).setParameter("global_receipt_hdr_3", merchant.getGlobal_receipt_hdr_3())
				.setParameter("global_receipt_ftr_1", merchant.getGlobal_receipt_ftr_1()).setParameter("global_receipt_ftr_2", merchant.getGlobal_receipt_ftr_2())
				.setParameter("global_receipt_ftr_3", merchant.getGlobal_receipt_ftr_3()).setParameter("global_is_instant_reward", merchant.isGlobal_is_instant_reward())
				
				
				.setParameter("global_is_point_inquiry", merchant.isGlobal_is_point_inquiry()).setParameter("global_is_point_redemption", merchant.isGlobal_is_point_redemption())
				.setParameter("global_is_value_redemption", merchant.isGlobal_is_value_redemption()).setParameter("global_is_gift_code_redemption", merchant.isGlobal_is_gift_code_redemption())
				.setParameter("global_is_hot_deal_redemption", merchant.isGlobal_is_hot_deal_redemption()).setParameter("global_is_void_redemption", merchant.isGlobal_is_void_redemption())
				
				.setParameter("global_is_encryption", merchant.isGlobal_is_encryption())
				
				
				.setParameter("merchant_id", merchant.getMerchant_id())
				.executeUpdate();
		
		return result;
	}
	
	@Override
	public Merchant getMerchantByMid(String mid){
		
		Merchant result = null;
		
		String strHql = "SELECT m "
				+ " from Merchant m "
				+ " WHERE m.mid = :mid AND m.status_id=:status_id";
		
		result = entityManager.createQuery(strHql, Merchant.class)
				.setParameter("mid", mid)
				.setParameter("status_id", 1).getSingleResult();
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public BigDecimal getMerchantIdByMid(String mid){
		BigDecimal result = BigDecimal.ZERO;
		List<MerchantIDsDTO> merchantIdList = null;
		
		String hql = "SELECT " + 
				"  NEW com.maybank.orsapp.dto.MerchantIDsDTO(mch.merchant_id, mch.mid) " + 
				"  FROM Merchant mch " + 
				"  WHERE mid=:mid AND mch.status_id=:status_id";
		merchantIdList = entityManager.createQuery(hql)
				.setParameter("mid", mid)
				.setParameter("status_id", 1)
				.getResultList();
		
		if(merchantIdList!=null && merchantIdList.size()>0) {
			result = merchantIdList.get(0).getMerchant_id();
		}
		
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MerchentDTO> getAllActiveMerchant() {
		List<MerchentDTO> result = null;
		
		String hql = "SELECT " + 
				"  NEW com.maybank.orsapp.dto.MerchantDTO(mch.merchant_id, mch.mid, mch.merchant_name) " + 
				"  FROM Merchant mch " + 
				"  WHERE mch.status_id =:status_id";
		
		result = entityManager.createQuery(hql).setParameter("status_id", 1).getResultList();
		
		if(CollectionUtils.isEmpty(result)) {
			return Collections.emptyList();
		}
		else return result;
	}
	
	
}
