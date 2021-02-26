package com.maybank.orsapp.repository;

import java.math.BigDecimal;
import java.util.List;

import com.maybank.orsapp.dto.TerminalDTO;
import com.maybank.orsapp.dto.TerminalDetailDTO;
import com.maybank.orsapp.entities.Merchant;
import com.maybank.orsapp.entities.Terminal;

public interface TerminalRepositoryCustom {
	
	public List<String> getTerminalListByMid(String mid);
	
	public List<TerminalDTO> getTerminalListByMerchantId(BigDecimal merchantId);
	
	public int updateTerminalByTid(Terminal terminal, String username);
	
	public int updateGlobalTerminalByMid(Merchant merchant, String username);
	
	public int deleteTerminalByMerchantId(BigDecimal merchantId, String username) ;
	
	public List<String> getTerminalListByTids(List<String> tidList);
	
	public TerminalDetailDTO getTerminalDetailByTerminalId(BigDecimal terminalId);
	
	public TerminalDetailDTO getTerminalDetailsByTID(String tid);
	
	public Terminal getTerminalByTerminalId(BigDecimal terminalId);
}
