/**
 * 
 */
package com.maybank.orsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maybank.orsapp.entities.GroupAccessAudit;

/**
 * @author 80003905
 *
 */

@Repository
public interface GroupAccessAuditRepository extends JpaRepository<GroupAccessAudit, Long>{

}
