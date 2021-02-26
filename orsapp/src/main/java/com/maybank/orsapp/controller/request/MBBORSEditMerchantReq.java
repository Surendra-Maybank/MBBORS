package com.maybank.orsapp.controller.request;

public class MBBORSEditMerchantReq {
	
	private EditMerchantInfoMerchantReq merchant;
	private EditMerchantInfoTerminalReq terminal;
	
	public EditMerchantInfoMerchantReq getMerchant() {
		return merchant;
	}
	public void setMerchant(EditMerchantInfoMerchantReq merchant) {
		this.merchant = merchant;
	}
	public EditMerchantInfoTerminalReq getTerminal() {
		return terminal;
	}
	public void setTerminal(EditMerchantInfoTerminalReq terminal) {
		this.terminal = terminal;
	}
	
	
}
