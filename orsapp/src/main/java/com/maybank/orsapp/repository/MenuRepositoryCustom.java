/**
 * 
 */
package com.maybank.orsapp.repository;

import java.util.List;

import com.maybank.orsapp.dto.MenuDto;

/**
 * @author 80003905
 *
 */
public interface MenuRepositoryCustom{
	
	public List<MenuDto> listOfActiveMenus();

	public String getMenuName(Long menuId);

}
