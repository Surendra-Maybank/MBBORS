package com.maybank.orsapp.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maybank.orsapp.entities.Merchant;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, BigDecimal>, MerchantRepositoryCustom{

}
