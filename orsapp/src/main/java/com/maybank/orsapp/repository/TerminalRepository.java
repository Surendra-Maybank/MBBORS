package com.maybank.orsapp.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maybank.orsapp.entities.Terminal;

@Repository
public interface TerminalRepository  extends JpaRepository<Terminal, BigDecimal>, TerminalRepositoryCustom{
	
	
}
