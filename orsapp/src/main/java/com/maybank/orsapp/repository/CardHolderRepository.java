/**
 * 
 */
package com.maybank.orsapp.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.maybank.orsapp.entities.CardHolder;

/**
 * @author 80003905
 *
 */

@Repository
public interface CardHolderRepository extends JpaRepository<CardHolder, BigDecimal>{
	
	@Query("SELECT ch FROM CardHolder ch WHERE ch.statusId = ?1 and ch.custIcNo = ?2")
	Optional<CardHolder> findCardHolderByIcNo(Integer statusId, String customerIcNo);
	
}
