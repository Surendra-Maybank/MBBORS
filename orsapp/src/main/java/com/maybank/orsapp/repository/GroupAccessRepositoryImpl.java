/**
 * 
 */
package com.maybank.orsapp.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.CollectionUtils;

import com.maybank.orsapp.dto.LoginMenuDto;
import com.maybank.orsapp.dto.MenuDto;

/**
 * @author 80003905
 *
 */
public class GroupAccessRepositoryImpl implements GroupAccessRepositoryCustom {
	
	@PersistenceContext
	@Qualifier("entityManager")
    EntityManager entityManager;
	
	public EntityManager getEntityManager() {
	    return entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LoginMenuDto> findActiveGroupAndMenuByGroupId(Long groupId) {
		String hql = "SELECT m.MENU_NAME, ga.IS_ADD, ga.IS_EDIT, ga.IS_VIEW, ga.IS_DELETE "
				+ "FROM [dbo].[mt_GROUP_ACCESS] AS ga "
				+ "INNER JOIN [dbo].[mt_MENU] m on m.MENU_ID = ga.MENU_ID "
				+ "WHERE ga.GROUP_ID = "+ groupId + " AND ga.STATUS_ID = 1";
		List<Object[]> menuObjects = entityManager.createNativeQuery(hql).getResultList();
		if(CollectionUtils.isEmpty(menuObjects)) {
			return Collections.emptyList();
		}else {
			List<LoginMenuDto> menuList = new ArrayList<>();
			for(Object[] menuObject : menuObjects) {
				LoginMenuDto menu = new LoginMenuDto();
				menu.setMenuName(menuObject[0].toString());
				menu.setAdd((Boolean) menuObject[1]);
				menu.setEdit((Boolean) menuObject[2]);
				menu.setView((Boolean) menuObject[3]);
				menu.setDelete((Boolean) menuObject[3]);
				menuList.add(menu);
			}
			
			return menuList;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MenuDto> getMenuAccessByGroupId(Long groupId) {
		String hql = "SELECT m.MENU_CODE, ga.IS_ADD, ga.IS_EDIT, ga.IS_VIEW, ga.IS_DELETE "
				+ "FROM [dbo].[mt_GROUP_ACCESS] AS ga "
				+ "INNER JOIN [dbo].[mt_MENU] m on m.MENU_ID = ga.MENU_ID "
				+ "WHERE ga.GROUP_ID = "+ groupId + " AND ga.STATUS_ID = 1";
		List<Object[]> menuObjects = entityManager.createNativeQuery(hql).getResultList();
		if(CollectionUtils.isEmpty(menuObjects)) {
			return Collections.emptyList();
		}else {
			List<MenuDto> menuList = new ArrayList<>();
			for(Object[] menuObject : menuObjects) {
				MenuDto menu = new MenuDto();
				menu.setMenuCode(menuObject[0].toString());
				menu.setAdd((Boolean) menuObject[1]);
				menu.setEdit((Boolean) menuObject[2]);
				menu.setView((Boolean) menuObject[3]);
				menu.setDelete((Boolean) menuObject[3]);
				menuList.add(menu);
			}
			
			return menuList;
		}
	}

}
