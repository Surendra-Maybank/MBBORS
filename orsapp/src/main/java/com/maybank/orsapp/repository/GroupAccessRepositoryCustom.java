/**
 * 
 */
package com.maybank.orsapp.repository;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;

import com.maybank.orsapp.dto.LoginMenuDto;
import com.maybank.orsapp.dto.MenuDto;

/**
 * @author 80003905
 *
 */

@NoRepositoryBean
public interface GroupAccessRepositoryCustom {
	
	public List<LoginMenuDto> findActiveGroupAndMenuByGroupId(Long groupId);

	public List<MenuDto> getMenuAccessByGroupId(Long groupId);

}
