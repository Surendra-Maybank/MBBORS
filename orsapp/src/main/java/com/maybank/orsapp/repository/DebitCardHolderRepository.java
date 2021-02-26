/**
 * 
 */
package com.maybank.orsapp.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maybank.orsapp.entities.DebitCardHolder;

/**
 * @author 80003905
 *
 */

@Repository
public interface DebitCardHolderRepository extends JpaRepository<DebitCardHolder, BigDecimal>{

}
