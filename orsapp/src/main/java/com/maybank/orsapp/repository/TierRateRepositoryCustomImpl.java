package com.maybank.orsapp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.maybank.orsapp.dto.MerchantDTO;
import com.maybank.orsapp.dto.MerchantDetailDTO;
import com.maybank.orsapp.dto.TierRateDTO;

@Repository
public class TierRateRepositoryCustomImpl implements TierRateRepositoryCustom {
	
	@PersistenceContext
	@Qualifier("entityManager")
    EntityManager entityManager;
	
	public EntityManager getEntityManager() {
	    return entityManager;
	}
	
	public List<TierRateDTO> getAllTierRate(){
		
		List<TierRateDTO> resultList = null;
		
		String hql = "SELECT NEW com.maybank.orsapp.dto.TierRateDTO(tier_rate_id,"
				+ "conversion_rate,"
				+ "tier_rate_desc,"
				+ "tier_rate_code"
				+ ") FROM TierRate t";
		
		resultList = entityManager.createQuery(hql).getResultList();
		
		return resultList;
	}
}
