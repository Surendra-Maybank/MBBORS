package com.maybank.orsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maybank.orsapp.entities.RewardType;

@Repository
public interface RewardTypeRepository extends JpaRepository<RewardType, Integer>, RewardTypeRepositoryCustom{

}
