package com.maybank.orsapp.service;

import com.maybank.orsapp.controller.request.MBBORSInsertNewTerminalReq;
import com.maybank.orsapp.controller.response.MBBORSGetMMPTerminalListByMidRes;
import com.maybank.orsapp.controller.response.MBBORSGetTerminalDetailByTidRes;
import com.maybank.orsapp.controller.response.MBBORSGetTerminalListByMidRes;
import com.maybank.orsapp.controller.response.MBBORSGetTerminalRes;
import com.maybank.orsapp.controller.response.MBBORSInsertNewTerminalRes;

public interface TerminalService {

	public MBBORSGetMMPTerminalListByMidRes getMMPTerminalListByMid (String mid);
	
	public MBBORSGetTerminalListByMidRes getTerminalListByMid (String mid);
	
	public MBBORSGetTerminalDetailByTidRes getTerminalDetailByTerminalId(String terminalId);
	
	public MBBORSInsertNewTerminalRes insertNewTerminal(MBBORSInsertNewTerminalReq request);
	
	public MBBORSGetTerminalRes getTerminalDetails(String tid);
}
