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
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.maybank.orsapp.dto.UserDto;
import com.maybank.orsapp.entities.User;

/**
 * @author 80003905
 *
 */
@SuppressWarnings("unused")
@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {

	@PersistenceContext
	@Qualifier("entityManager")
    EntityManager entityManager;
	
	public EntityManager getEntityManager() {
	    return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Optional<User> findUserByPfNo(String pfNo) {
		
		List<Integer> status = new ArrayList<>();
    	status.add(1);
    	status.add(3);
    	
		Query query = getEntityManager().createQuery("select u from User u where u.pfNo =:pfNo and u.statusId in (:status)", User.class);
        query.setParameter("pfNo", pfNo);
        query.setParameter("status", status);
        List<User> user = query.getResultList();		
		if(!CollectionUtils.isEmpty(user)) { 
			return Optional.ofNullable(user.get(0)); 
		}
		 
		return Optional.empty();
	}
	
	@Override
	public void saveUser(User user) {
		getEntityManager().persist(user);
    }
    
    @SuppressWarnings({"unchecked"})
	@Override
    public List<UserDto> getAllUser() {   
    	List<UserDto> result = null;
    	
    	String getAllUsers = "SELECT "
			    			+ " NEW com.maybank.orsapp.dto.UserDto(u.id, u.pfNo, u.firstName, u.lastName, u.emailId, u.telephoneNumber, "
			    			+ " g.id, g.groupCode, g.groupDescription, u.statusId, u.createdBy, u.createdDateTime, u.editedBy, u.editedDateTime) "
			    			+ " FROM User u "
			    			+ " INNER JOIN Group g ON g.id = u.groupId "
			    			+ " WHERE u.statusId !=:statusId";
    	
    	Query query = getEntityManager().createQuery(getAllUsers);
        query.setParameter("statusId", 2);
        
        result = query.getResultList();
        if(!CollectionUtils.isEmpty(result)) {
        	return result;
        }
		return Collections.emptyList();
    }
    
    @Override
    public User updateUser(User user) {
		entityManager.merge(user);
        return user;
    }

    @Override
    public void deleteUser(User user) {
		entityManager.merge(user);
    }

	@SuppressWarnings("unchecked")
	@Override
	public Optional<User> findUserById(Long id) {
		Query query = getEntityManager().createQuery("select u from User u where u.id =:id and u.statusId !=: statusId", User.class);
        query.setParameter("id", id);
        query.setParameter("statusId", 2);
        List<User> user = query.getResultList();		
		if(!CollectionUtils.isEmpty(user)) { 
			return Optional.ofNullable(user.get(0)); 
		}
		 
		return Optional.empty();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Optional<User> findUserForLogin(String pfNo) {
		Query query = getEntityManager().createQuery("select u from User u where u.pfNo =:pfNo and u.statusId =:statusId", User.class);
        query.setParameter("pfNo", pfNo);
        query.setParameter("statusId", 1);
        List<User> user = query.getResultList();		
		if(!CollectionUtils.isEmpty(user)) { 
			return Optional.ofNullable(user.get(0)); 
		}
		 
		return Optional.empty();
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserDto findUserByUserId(Long id) {
		List<UserDto> result = null;
		UserDto userDto = null;
		String getActiveUser = "SELECT "
    			+ " NEW com.maybank.orsapp.dto.UserDto(u.id, u.pfNo, u.firstName, u.lastName, u.emailId, u.telephoneNumber, "
    			+ " g.id, g.groupCode, g.groupDescription, u.statusId, u.createdBy, u.createdDateTime, u.editedBy, u.editedDateTime) "
    			+ " FROM User u "
    			+ " LEFT OUTER JOIN Group g ON g.id = u.groupId "
    			+ " WHERE u.statusId !=:statusId AND u.id=:id";

		Query query = getEntityManager().createQuery(getActiveUser);
		query.setParameter("statusId", 2);
		query.setParameter("id", id);
		result = query.getResultList();
		if(!CollectionUtils.isEmpty(result)) {
			return result.get(0);
		}
		return userDto;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> findUsersByGroupId(Long groupId) {
		Query query = getEntityManager().createQuery("select u from User u where u.groupId =:groupId and u.statusId =: statusId", User.class);
        query.setParameter("groupId", groupId);
        query.setParameter("statusId", 1);
		List<User> user = query.getResultList();		
		if(!CollectionUtils.isEmpty(user)) { 
			return user; 
		}
		 
		return Collections.emptyList();
	}
	
    

}
