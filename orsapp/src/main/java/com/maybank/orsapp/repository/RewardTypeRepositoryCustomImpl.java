package com.maybank.orsapp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.maybank.orsapp.constant.MBBORSConstant;
import com.maybank.orsapp.dto.MerchantDTO;
import com.maybank.orsapp.dto.MerchantDetailDTO;
import com.maybank.orsapp.dto.RewardTypeDTO;
import com.maybank.orsapp.dto.TierRateDTO;

@Repository
public class RewardTypeRepositoryCustomImpl implements RewardTypeRepositoryCustom {
	
	@PersistenceContext
	@Qualifier("entityManager")
    EntityManager entityManager;
	
	public EntityManager getEntityManager() {
	    return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<RewardTypeDTO> getAllRewardTypeList(){
		
		List<RewardTypeDTO> resultList = null;
		
		String hql = "SELECT NEW com.maybank.orsapp.dto.RewardTypeDTO(r.reward_type_id,"
				+ "r.reward_type_code,"
				+ "r.reward_type_desc"
				+ ") FROM RewardType r "
				+ " WHERE r.status_id=:statusId";
		
		resultList = entityManager.createQuery(hql)
				.setParameter("statusId", MBBORSConstant.DB_STATUS_ACTIVE)
				.getResultList();
		
		return resultList;
	}
}
