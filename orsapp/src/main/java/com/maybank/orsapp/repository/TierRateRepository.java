/**
 * 
 */
package com.maybank.orsapp.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.maybank.orsapp.entities.TierRate;


/**
 * @author SURENDRA
 *
 */

@Repository
public interface TierRateRepository extends JpaRepository<TierRate, BigDecimal>{
	
	@Query("SELECT tr FROM TierRate tr WHERE tr.status_id = 1 AND tr.tier_rate_id =?1")
	Optional<TierRate> findTierRateById(BigDecimal tier_rate_id);

}
