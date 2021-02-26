package com.maybank.orsapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maybank.orsapp.controller.request.MBBORSGetTerminalReq;
import com.maybank.orsapp.controller.request.MBBORSInsertNewTerminalReq;
import com.maybank.orsapp.controller.response.MBBORSGetMMPTerminalListByMidRes;
import com.maybank.orsapp.controller.response.MBBORSGetTerminalDetailByTidRes;
import com.maybank.orsapp.controller.response.MBBORSGetTerminalListByMidRes;
import com.maybank.orsapp.controller.response.MBBORSGetTerminalRes;
import com.maybank.orsapp.controller.response.MBBORSInsertNewTerminalRes;
import com.maybank.orsapp.service.TerminalService;

@RestController
@RequestMapping("/")
public class TerminalController {

	private final Logger logger = LoggerFactory.getLogger(TerminalController.class);
	
	@Autowired
	TerminalService terminalService;
	
	@GetMapping("/GetTerminalDetailByTid/{terminalId}")
	public ResponseEntity<MBBORSGetTerminalDetailByTidRes> GetTerminalDetailByTid(@PathVariable("terminalId") String tid){

		logger.info("##Received Request GetTerminalDetailByTid : [terminalId=".concat(tid).concat("]"));
		
		MBBORSGetTerminalDetailByTidRes res = terminalService.getTerminalDetailByTerminalId(tid);
		
		logger.info("##Respond GetTerminalDetailByTid : [".concat(res.toString()).concat("]"));
				
		return ResponseEntity.ok(res);		
	}
	
	@GetMapping("/GetTerminalListByMid/{mid}")
	public ResponseEntity<MBBORSGetTerminalListByMidRes> GetTerminalListByMid(@PathVariable("mid") String mid){
		
		return ResponseEntity.ok(terminalService.getTerminalListByMid(mid));		
	}
	
	@GetMapping("/GetMMPTerminalListByMid/{mid}")
	public ResponseEntity<MBBORSGetMMPTerminalListByMidRes> GetMMPTerminalListByMid(@PathVariable("mid") String mid){
		
		logger.info("##Received Request GetMMPTerminalListByMid : [mid=".concat(mid).concat("]"));
		
		MBBORSGetMMPTerminalListByMidRes res= terminalService.getMMPTerminalListByMid(mid);
		
		logger.info("##Respond GetMMPTerminalListByMid : [".concat(res.toString()).concat("]"));
		
		return ResponseEntity.ok(res);		
	}
	
   @PostMapping(value="/CreateTerminal",headers="Accept=application/json")
   public ResponseEntity<MBBORSInsertNewTerminalRes> CreateTerminal(@RequestBody MBBORSInsertNewTerminalReq merchant){
	   
	   logger.info("##Received Request CreateTerminal : [".concat(merchant.toString()).concat("]")); 
	   
	   MBBORSInsertNewTerminalRes res = terminalService.insertNewTerminal(merchant);
	   
	   logger.info("##Respond CreateTerminal : [".concat(res.toString()).concat("]"));
	   
       return ResponseEntity.ok(res);
   }
   
	@RequestMapping(value = "/downloadTerminal", consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public MBBORSGetTerminalRes downloadTerminal(@RequestBody MBBORSGetTerminalReq requestBean) throws Exception{
		MBBORSGetTerminalRes respond = null;
				
		respond = terminalService.getTerminalDetails(requestBean.getTid());
		
		return respond;
	}
	
}
