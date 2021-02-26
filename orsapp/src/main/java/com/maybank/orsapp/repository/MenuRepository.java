/**
 * 
 */
package com.maybank.orsapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.maybank.orsapp.entities.Menu;

/**
 * @author 80003905
 *
 */

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long>, MenuRepositoryCustom{
	
	@Query("SELECT m FROM Menu m WHERE m.statusId = 1")
	List<Menu> findAllActiveMenu();

}
