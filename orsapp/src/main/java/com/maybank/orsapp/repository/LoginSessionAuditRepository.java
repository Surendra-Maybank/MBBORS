/**
 * 
 */
package com.maybank.orsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maybank.orsapp.entities.LoginSessionAudit;

/**
 * @author 80003905
 *
 */

@Repository
public interface LoginSessionAuditRepository extends JpaRepository<LoginSessionAudit, Long>{

}
