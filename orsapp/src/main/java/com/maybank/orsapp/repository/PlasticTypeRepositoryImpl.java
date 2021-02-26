/**
 * 
 */
package com.maybank.orsapp.repository;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.CollectionUtils;

import com.maybank.orsapp.dto.ProductPlasticTypeDto;

/**
 * @author 80003905
 *
 */
public class PlasticTypeRepositoryImpl implements PlasticTypeRepositoryCustom {
	
	@PersistenceContext
	@Qualifier("entityManager")
    EntityManager entityManager;
	
	public EntityManager getEntityManager() {
	    return entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductPlasticTypeDto> findAllActivePlasticTypes() {
		List<ProductPlasticTypeDto> result = null;
		
		String hql = "SELECT NEW com.maybank.orsapp.dto.ProductPlasticTypeDto(pt.id, pt.plasticTypeCode, pt.plasticTypeDesc) FROM PlasticType pt WHERE pt.statusId =:statusId ";
						
		result = entityManager.createQuery(hql).setParameter("statusId", 1).getResultList();
		
		if(CollectionUtils.isEmpty(result)) {
			return Collections.emptyList();
		}
		else return result;
	}

}
