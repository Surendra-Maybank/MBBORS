package com.maybank.orsapp.dto;

import java.math.BigDecimal;

public class TerminalDTO {
	
	private BigDecimal terminal_id;	
    private String tid;
    
    public TerminalDTO() {}
    
    public TerminalDTO(BigDecimal terminal_id, String tid) {
    	this.terminal_id = terminal_id;
    	this.tid = tid;
    }
    
	public BigDecimal getTerminal_id() {
		return terminal_id;
	}
	public void setTerminal_id(BigDecimal terminal_id) {
		this.terminal_id = terminal_id;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}	
    
    
}
