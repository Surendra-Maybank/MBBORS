package com.maybank.orsapp.dto;

import java.math.BigDecimal;

public class CardHolderDetailDTO {
	
	private BigDecimal cardholder_id;
	private String cust_ic_no;
	private String first_name;
	private String last_name;
	private String addr1;
	private String addr2;
	private String addr3;
	private String addr4;
	private String zip_code;
	private String home_no;
	private String office_no;
	private String mobile_no;
	
	public BigDecimal getCardholder_id() {
		return cardholder_id;
	}
	public void setCardholder_id(BigDecimal cardholder_id) {
		this.cardholder_id = cardholder_id;
	}
	public String getCust_ic_no() {
		return cust_ic_no;
	}
	public void setCust_ic_no(String cust_ic_no) {
		this.cust_ic_no = cust_ic_no;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getAddr3() {
		return addr3;
	}
	public void setAddr3(String addr3) {
		this.addr3 = addr3;
	}
	public String getAddr4() {
		return addr4;
	}
	public void setAddr4(String addr4) {
		this.addr4 = addr4;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public String getHome_no() {
		return home_no;
	}
	public void setHome_no(String home_no) {
		this.home_no = home_no;
	}
	public String getOffice_no() {
		return office_no;
	}
	public void setOffice_no(String office_no) {
		this.office_no = office_no;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	
}
