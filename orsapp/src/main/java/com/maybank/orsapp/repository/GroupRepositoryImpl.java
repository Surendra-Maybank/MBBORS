/**
 * 
 */
package com.maybank.orsapp.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.CollectionUtils;

//import com.maybank.orsapp.dto.GroupAndMenuAccessDto;
import com.maybank.orsapp.dto.GroupDto;
import com.maybank.orsapp.entities.Group;

/**
 * @author 80003905
 *
 */
public class GroupRepositoryImpl implements GroupRepositoryCustom {
	
	@PersistenceContext
	@Qualifier("entityManager")
    EntityManager entityManager;
	
	public EntityManager getEntityManager() {
	    return entityManager;
	}
	
	@SuppressWarnings({"unchecked"})
	@Override
    public List<GroupDto> getAllUserGroups() {   
    	List<GroupDto> result = null;
    	
    	String getAllUsers = "SELECT "
			    			+ " NEW com.maybank.orsapp.dto.GroupDto(g.id, g.groupCode, g.groupDescription) "
			    			+ " FROM Group g "
			    			+ " WHERE g.statusId =:statusId";
    	
    	Query query = getEntityManager().createQuery(getAllUsers);
        query.setParameter("statusId", 1);
        
        result = query.getResultList();
        if(!CollectionUtils.isEmpty(result)) {
        	return result;
        }
		return Collections.emptyList();
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Group> findAllActiveGroups() {
		
		List<Group> result = null;
    	String getAllActiveGroups = "SELECT g FROM Group g WHERE g.statusId !=:statusId";
    	
    	Query query = getEntityManager().createQuery(getAllActiveGroups);
        query.setParameter("statusId", 2);
        
        result = query.getResultList();
        if(!CollectionUtils.isEmpty(result)) {
        	return result;
        }
		return Collections.emptyList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Optional<Group> findGroupByGroupId(Long groupId) {
		
		List<Group> result = null;
		String getAllActiveGroups = "SELECT g FROM Group g WHERE g.statusId !=:statusId AND g.id =:groupId";
    	
    	Query query = getEntityManager().createQuery(getAllActiveGroups);
        query.setParameter("statusId", 2);
        query.setParameter("groupId", groupId);
        
        result = query.getResultList();
        if(!CollectionUtils.isEmpty(result)) {
        	return Optional.ofNullable(result.get(0));
        }
        
		return Optional.empty();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Optional<Group> findGroupByGroupCode(String groupCode) {
		
		List<Group> result = null;
		String getAllActiveGroups = "SELECT g FROM Group g WHERE g.statusId in (:status) AND g.groupCode =:groupCode";
    	List<Integer> status = new ArrayList<>();
    	status.add(1);
    	status.add(3);
    	Query query = getEntityManager().createQuery(getAllActiveGroups);
        query.setParameter("status", status);
        query.setParameter("groupCode", groupCode);
        
        result = query.getResultList();
        if(!CollectionUtils.isEmpty(result)) {
        	return Optional.ofNullable(result.get(0));
        }
        
		return Optional.empty();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Optional<Group> findGroupAndGroupAccess(Long groupId) {
		
		List<Group> result = null;
		String getAllActiveGroups = "FROM Group g JOIN FETCH g.groupAccess ga WHERE g.statusId in (:status) AND g.id =:groupId";
    	List<Integer> status = new ArrayList<>();
    	status.add(1);
    	status.add(3);
    	Query query = getEntityManager().createQuery(getAllActiveGroups);
        query.setParameter("status", status);
        query.setParameter("groupId", groupId);
        
        result = query.getResultList();
        if(!CollectionUtils.isEmpty(result)) {
        	return Optional.ofNullable(result.get(0));
        }
        
		return Optional.empty();
	}
	
	

}
