/**
 * 
 */
package com.maybank.orsapp.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.maybank.orsapp.controller.response.MenuResponse;
import com.maybank.orsapp.dto.MenuDto;
import com.maybank.orsapp.dto.MenuRightsDto;
import com.maybank.orsapp.repository.MenuRepositoryImpl;
import com.maybank.orsapp.service.MenuService;

/**
 * @author 80003905
 *
 */

@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	MenuRepositoryImpl menuRepository;

	@Override
	public MenuResponse getMenuList() {
		MenuResponse menuResponse = new MenuResponse();
		List<MenuDto> ativeMenuList = menuRepository.listOfActiveMenus();
		List<MenuDto> menuList = getMenu(ativeMenuList);
		if(CollectionUtils.isEmpty(menuList)) {
			menuResponse.setResponseCode("01");
			menuResponse.setResponseMessage("No Active Recors");
		}else {
			menuResponse.setResponseCode("00");
			menuResponse.setResponseMessage("Success");
			menuResponse.setListOfActiveMenus(menuList);
		}
		return menuResponse;
	}
	
	private List<MenuDto> getMenu(List<MenuDto> menuList){
		List<MenuDto> menuDtoList = new ArrayList<>();
		if(!CollectionUtils.isEmpty(menuList)) {
			for(MenuDto menuDto : menuList) {
				MenuDto menu = new MenuDto();
				menu.setMenuId(menuDto.getMenuId());
				menu.setMenuName(menuDto.getMenuName());
				menu.setMenuCode(menuDto.getMenuCode());
				List<MenuRightsDto> rights = getMenuAccess(menuDto);
				if(!CollectionUtils.isEmpty(rights)) {
					menu.setRights(rights);
				}
				menuDtoList.add(menu);
			}
		}
		return menuDtoList;
	}
	
	private List<MenuRightsDto> getMenuAccess(MenuDto menu) {
		List<MenuRightsDto> rights = new ArrayList<>();
		MenuRightsDto right = null;

		if (menu.getAdd() || !menu.getAdd()) {
			right = new MenuRightsDto();
			right.setName("add");
			right.setAccess(menu.getAdd());
			right.setChecked(Boolean.FALSE);
			rights.add(right);
		}
		if (menu.getView() || !menu.getView()) {
			right = new MenuRightsDto();
			right.setName("view");
			right.setAccess(menu.getView());
			right.setChecked(Boolean.FALSE);
			rights.add(right);
		}
		if (menu.getEdit() || !menu.getEdit()) {
			right = new MenuRightsDto();
			right.setName("edit");
			right.setAccess(menu.getEdit());
			right.setChecked(Boolean.FALSE);
			rights.add(right);
		}
		if (menu.getDelete() || !menu.getDelete()) {
			right = new MenuRightsDto();
			right.setName("delete");
			right.setAccess(menu.getDelete());
			right.setChecked(Boolean.FALSE);
			rights.add(right);
		}

		if (CollectionUtils.isEmpty(rights)) {
			return Collections.emptyList();
		} else {
			return rights;
		}
	}

}
