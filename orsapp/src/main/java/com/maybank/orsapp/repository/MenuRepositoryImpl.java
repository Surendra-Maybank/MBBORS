/**
 * 
 */
package com.maybank.orsapp.repository;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.maybank.orsapp.dto.MenuDto;

/**
 * @author 80003905
 *
 */

@Repository
public class MenuRepositoryImpl implements MenuRepositoryCustom {
	
	@PersistenceContext
	@Qualifier("entityManager")
    EntityManager entityManager;
	
	public EntityManager getEntityManager() {
	    return entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MenuDto> listOfActiveMenus() {
		List<MenuDto> result = null;
		
		String getAllMenus = "SELECT "
    			+ " NEW com.maybank.orsapp.dto.MenuDto(m.id, m.menuCode, m.menuName, m.view, m.add, m.edit, m.delete) "
    			+ " FROM Menu m WHERE m.statusId =:statusId ";

		Query query = getEntityManager().createQuery(getAllMenus);
		query.setParameter("statusId", 1);
		
		result = query.getResultList();
		if(!CollectionUtils.isEmpty(result)) {
			return result;
		}
		
		return Collections.emptyList();
	}
	
	@Override
	public String getMenuName(Long menuId) {
		String result = null;
		
		String getMenuName = "SELECT "
    			+ " m.menuName "
    			+ " FROM Menu m WHERE m.statusId =:statusId AND m.id =:menuId";

		Query query = getEntityManager().createQuery(getMenuName);
		query.setParameter("statusId", 1);
		query.setParameter("menuId", menuId);
		result = (String) query.getSingleResult();
		if(StringUtils.isNotBlank(result)) {
			return result;
		}
		
		return null;
	}

}
