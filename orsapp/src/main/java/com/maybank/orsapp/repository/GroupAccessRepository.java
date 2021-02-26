/**
 * 
 */
package com.maybank.orsapp.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.maybank.orsapp.entities.Group;
import com.maybank.orsapp.entities.GroupAccess;

/**
 * @author 80003905
 *
 */

@Repository
public interface GroupAccessRepository extends JpaRepository<GroupAccess, Long>, GroupAccessRepositoryCustom{
	
	@Query("SELECT g FROM GroupAccess g WHERE g.statusId != 2 and g.groupId = ?1")
	Collection<GroupAccess> findAllActiveGroupAccess(Group groupId);

}
