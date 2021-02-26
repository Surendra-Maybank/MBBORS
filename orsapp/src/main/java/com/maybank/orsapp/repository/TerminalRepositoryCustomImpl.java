package com.maybank.orsapp.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.maybank.orsapp.dto.TerminalDTO;
import com.maybank.orsapp.dto.TerminalDetailDTO;
import com.maybank.orsapp.entities.Merchant;
import com.maybank.orsapp.entities.Terminal;

@Repository
public class TerminalRepositoryCustomImpl implements TerminalRepositoryCustom{
	
	@PersistenceContext
	@Qualifier("entityManager")
    EntityManager entityManager;
	
	public EntityManager getEntityManager() {
	    return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getTerminalListByMid(String mid){
		
		List<String> resultList = null;
		
		String strHql = "SELECT NEW java.lang.String(t.tid) from Terminal t INNER JOIN Merchant mch ON t.merchant_id=mch.merchant_id WHERE mch.mid = :mid AND t.status_id=:status_id";
		
		resultList = entityManager.createQuery(strHql)
				.setParameter("mid", mid)
				.setParameter("status_id", 1)
				.getResultList();
		
		return resultList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getTerminalListByTids(List<String> tidList){
		
		List<String> resultList = null;
		
		String strHql = "SELECT NEW java.lang.String(t.tid) from Terminal t WHERE t.tid in (:tids) AND t.status_id=:status_id";
		
		resultList = entityManager.createQuery(strHql)
				.setParameter("tids", tidList)
				.setParameter("status_id", 1)
				.getResultList();
		
		return resultList;
	}
	
	@Override
	public List<TerminalDTO> getTerminalListByMerchantId(BigDecimal merchantId){
		
		List<TerminalDTO> resultList = null;
		
		try {
		String strHql = "SELECT NEW com.maybank.orsapp.dto.TerminalDTO(t.terminal_id,t.tid) from Terminal t INNER JOIN Merchant mch ON t.merchant_id=mch.merchant_id WHERE t.merchant_id = :merchantId";
		
		resultList = entityManager.createQuery(strHql).setParameter("merchantId", merchantId).getResultList();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return resultList;
	}
	
	public TerminalDetailDTO getTerminalDetailByTerminalId(BigDecimal terminalId){
		
		List<TerminalDetailDTO> resultList = null;
		TerminalDetailDTO result = new TerminalDetailDTO();
    	
		try {
			String strHql = "SELECT NEW com.maybank.orsapp.dto.TerminalDetailDTO("
					+ " t.terminal_id," + 
					" t.tid," + 	" mch.mid," + 	" t.max_redeem_point," + 
					" t.is_inherit,"+"t.instant_reward_percentage," + "t.conversion_rate," +
					" t.receipt_hdr_1, " + " t.receipt_hdr_2, " + " t.receipt_hdr_3,	" + 
					" t.receipt_ftr_1, " + " t.receipt_ftr_2, " + " t.receipt_ftr_3,	" + 
					" tr.tier_rate_id, " + " tr.tier_rate_code, " + " tr.tier_rate_desc,	" + 
					" t.is_point_inquiry, " + " t.is_instant_reward, " + " t.is_point_redemption, " + 
					" t.is_value_redemption, " + " t.is_gift_code_redemption, " + " t.is_hot_deal_redemption, " + 
					" t.is_void_redemption, " + " t.is_encryption, " + " t.status_id, " + 
					" t.created_by, " + " t.created_datetime, " + " t.edited_by, " + 
					" t.edited_datetime"
					+ ") from Terminal t "
					+ " INNER JOIN Merchant mch "
					+ " ON mch.merchant_id=t.merchant_id "
					+ " INNER JOIN TierRate tr "
					+ " ON tr.tier_rate_id=t.tier_rate_id "
					+ " WHERE t.terminal_id = :terminalId";
			
			resultList = entityManager.createQuery(strHql).setParameter("terminalId", terminalId).getResultList();
			
			if(resultList!=null&&resultList.size()>0) {
				result = resultList.get(0);
			}else {
				return null;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
		return result;
	}
	
	public Terminal getTerminalByTerminalId(BigDecimal terminalId){
		
		Terminal result = null;
		
		String strHql = "SELECT t "
				+ " from Terminal t "
				+ " WHERE t.terminal_id = :terminalId";
		
		result = entityManager.createQuery(strHql, Terminal.class).setParameter("terminalId", terminalId).getSingleResult();
		
		return result;
	}
	
	public TerminalDetailDTO getTerminalDetailsByTID(String tid) {
		List<TerminalDetailDTO> resultList = null;
		TerminalDetailDTO result = new TerminalDetailDTO();
    	
		try {
			String strHql = "SELECT NEW com.maybank.orsapp.dto.TerminalDetailDTO("
					+ " t.terminal_id," + 
					" t.tid," + 	" mch.mid," + 	" t.max_redeem_point," + 
					" t.is_inherit,"+"t.instant_reward_percentage," + "t.conversion_rate," +
					" t.receipt_hdr_1, " + " t.receipt_hdr_2, " + " t.receipt_hdr_3,	" + 
					" t.receipt_ftr_1, " + " t.receipt_ftr_2, " + " t.receipt_ftr_3,	" + 
					" tr.tier_rate_id, " + " tr.tier_rate_code, " + " tr.tier_rate_desc,	" + 
					" t.is_point_inquiry, " + " t.is_instant_reward, " + " t.is_point_redemption, " + 
					" t.is_value_redemption, " + " t.is_gift_code_redemption, " + " t.is_hot_deal_redemption, " + 
					" t.is_void_redemption, " + " t.is_encryption, " + " t.status_id, " + 
					" t.created_by, " + " t.created_datetime, " + " t.edited_by, " + 
					" t.edited_datetime"
					+ ") from Terminal t "
					+ " INNER JOIN Merchant mch "
					+ " ON mch.merchant_id=t.merchant_id "
					+ " INNER JOIN TierRate tr "
					+ " ON tr.tier_rate_id=t.tier_rate_id "
					+ " WHERE t.tid = :terminalId";
			
			resultList = entityManager.createQuery(strHql).setParameter("terminalId", tid).getResultList();
			
			if(resultList!=null&&resultList.size()>0) {
				result = resultList.get(0);
			}else {
				return null;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public int updateTerminalByTid(Terminal terminal, String username) {
		int result = 0;
			
		String hql = "UPDATE Terminal SET edited_by=:edited_by, edited_datetime=current_time(),"
				+ " tier_rate_id=:tier_rate_id, conversion_rate=:conversion_rate,"
				+ " is_inherit=:is_inherit, max_redeem_point=:max_redeem_point,"
				
				+ " instant_reward_percentage=:instant_reward_percentage, receipt_hdr_1=:receipt_hdr_1,"
				+ " receipt_hdr_2=:receipt_hdr_2, receipt_hdr_3=:receipt_hdr_3,"
				+ " receipt_ftr_1=:receipt_ftr_1, receipt_ftr_2=:receipt_ftr_2, receipt_ftr_3=:receipt_ftr_3,"
				
				+ " is_point_inquiry=:is_point_inquiry, is_instant_reward=:is_instant_reward,"
				+ " is_point_redemption=:is_point_redemption, is_value_redemption=:is_value_redemption,"
				+ " is_gift_code_redemption=:is_gift_code_redemption, is_hot_deal_redemption=:is_hot_deal_redemption,"
				
				+ " is_void_redemption=:is_void_redemption, is_encryption=:is_encryption"
				
				+ " WHERE terminal_id=:terminalId";
		
		
		result = entityManager.createQuery(hql)
				.setParameter("edited_by", username)
				
				
				.setParameter("tier_rate_id", terminal.getTier_rate_id()).setParameter("conversion_rate", terminal.getConversion_rate())
				.setParameter("is_inherit", terminal.getIs_inherit()).setParameter("max_redeem_point", terminal.getMax_redeem_point())
				
				.setParameter("instant_reward_percentage", terminal.getInstant_reward_percentage()).setParameter("receipt_hdr_1", terminal.getReceipt_hdr_1())
				.setParameter("receipt_hdr_2", terminal.getReceipt_hdr_2()).setParameter("receipt_hdr_3", terminal.getReceipt_hdr_3())
				.setParameter("receipt_ftr_1", terminal.getReceipt_ftr_1()).setParameter("receipt_ftr_2", terminal.getReceipt_ftr_2()).setParameter("receipt_ftr_3", terminal.getReceipt_ftr_3())
				
				.setParameter("is_point_inquiry", terminal.getIs_point_inquiry()).setParameter("is_instant_reward", terminal.getIs_instant_reward())
				.setParameter("is_point_redemption", terminal.getIs_point_redemption()).setParameter("is_value_redemption", terminal.getIs_value_redemption())
				.setParameter("is_gift_code_redemption", terminal.getIs_gift_code_redemption()).setParameter("is_hot_deal_redemption", terminal.getIs_hot_deal_redemption())
				
				.setParameter("is_void_redemption", terminal.getIs_void_redemption()).setParameter("is_encryption", terminal.getIs_encryption())
				.setParameter("terminalId", terminal.getTerminal_id())
				.executeUpdate();
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public int updateGlobalTerminalByMid(Merchant merchant, String username) {
		int result = 0;
			
		String hql = "UPDATE Terminal SET edited_by=:edited_by, edited_datetime=current_time(),"
				+ " conversion_rate=:conversion_rate,"
				+ " max_redeem_point=:max_redeem_point,"
				
				+ " instant_reward_percentage=:instant_reward_percentage, receipt_hdr_1=:receipt_hdr_1,"
				+ " receipt_hdr_2=:receipt_hdr_2, receipt_hdr_3=:receipt_hdr_3,"
				+ " receipt_ftr_1=:receipt_ftr_1, receipt_ftr_2=:receipt_ftr_2,receipt_ftr_3=:receipt_ftr_3,"
				
				+ " is_point_inquiry=:is_point_inquiry, is_instant_reward=:is_instant_reward,"
				+ " is_point_redemption=:is_point_redemption, is_value_redemption=:is_value_redemption,"
				+ " is_gift_code_redemption=:is_gift_code_redemption, is_hot_deal_redemption=:is_hot_deal_redemption,"
				
				+ " is_void_redemption=:is_void_redemption, is_encryption=:is_encryption"
				
				+ " WHERE merchant_id=:merchantId AND is_inherit=:isInherit";
		
		
		result = entityManager.createQuery(hql)
				.setParameter("edited_by", username)
				.setParameter("merchantId", merchant.getMerchant_id())
				.setParameter("isInherit",true)
				
//				.setParameter("tier_rate_id", merchant.getTier_rate_id())
				.setParameter("conversion_rate", merchant.getConversion_rate())
				.setParameter("max_redeem_point", merchant.getGlobal_max_redeem_point())
				
				.setParameter("instant_reward_percentage", merchant.getGlobal_instant_reward_percentage()).setParameter("receipt_hdr_1", merchant.getGlobal_receipt_hdr_1())
				.setParameter("receipt_hdr_2", merchant.getGlobal_receipt_hdr_2()).setParameter("receipt_hdr_3", merchant.getGlobal_receipt_hdr_3())
				.setParameter("receipt_ftr_1", merchant.getGlobal_receipt_ftr_1()).setParameter("receipt_ftr_2", merchant.getGlobal_receipt_ftr_2()).setParameter("receipt_ftr_3", merchant.getGlobal_receipt_ftr_3())
				
				.setParameter("is_point_inquiry", merchant.isGlobal_is_point_inquiry()).setParameter("is_instant_reward", merchant.isGlobal_is_instant_reward())
				.setParameter("is_point_redemption", merchant.isGlobal_is_point_redemption()).setParameter("is_value_redemption", merchant.isGlobal_is_value_redemption())
				.setParameter("is_gift_code_redemption", merchant.isGlobal_is_gift_code_redemption()).setParameter("is_hot_deal_redemption", merchant.isGlobal_is_hot_deal_redemption())
				
				.setParameter("is_void_redemption", merchant.isGlobal_is_void_redemption()).setParameter("is_encryption", merchant.isGlobal_is_encryption())
				
				.executeUpdate();
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public int deleteTerminalByMerchantId(BigDecimal merchantId, String username) {
		int result = 0;
		
		String hql = "UPDATE Terminal SET status_id=:status_id , edited_by=:edited_by, edited_datetime=current_time() WHERE merchant_id=:merchantId";
		
		result = entityManager.createQuery(hql)
				.setParameter("status_id", 2)
				.setParameter("edited_by", username)
				.setParameter("merchantId", merchantId)
				.executeUpdate();
		
		return result;
	}
}
