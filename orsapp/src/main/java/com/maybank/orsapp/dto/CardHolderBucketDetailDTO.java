package com.maybank.orsapp.dto;

import java.math.BigDecimal;

public class CardHolderBucketDetailDTO {
	
	private BigDecimal cardholder_point_bucket_id;
	private String cust_no;
	private String cust_ic_no;
	private String org_no;
	private String card_type;
	private String card_no;
	private String card_exp_date;
	private String card_post_flag;
	private String total_points_sign;
	private BigDecimal total_points_bal;
	private Integer program_id;
	private String bucket01_point_sign;
	private BigDecimal bucket01_point_bal;
	private String bucket02_point_sign;
	private BigDecimal bucket02_point_bal;
	private String bucket03_point_sign;
	private BigDecimal bucket03_point_bal;
	private String bucket04_point_sign;
	private BigDecimal bucket04_point_bal;
	private String bucket05_point_sign;
	private BigDecimal bucket05_point_bal;
	private String bucket06_point_sign;
	private BigDecimal bucket06_point_bal;
	private String bucket07_point_sign;
	private BigDecimal bucket07_point_bal;
	private String bucket08_point_sign;
	private BigDecimal bucket08_point_bal;
	private String bucket09_point_sign;
	private BigDecimal bucket09_point_bal;
	private String bucket10_point_sign;
	private BigDecimal bucket10_point_bal;
	private String bucket11_point_sign;
	private BigDecimal bucket11_point_bal;
	private String bucket12_point_sign;
	private BigDecimal bucket12_point_bal;
	private String bucket13_point_sign;
	private BigDecimal bucket13_point_bal;
	private String bucket14_point_sign;
	private BigDecimal bucket14_point_bal;
	private String bucket15_point_sign;
	private BigDecimal bucket15_point_bal;
	private String bucket16_point_sign;
	private BigDecimal bucket16_point_bal;
	private String bucket17_point_sign;
	private BigDecimal bucket17_point_bal;
	private String bucket18_point_sign;
	private BigDecimal bucket18_point_bal;
	private String bucket19_point_sign;
	private BigDecimal bucket19_point_bal;
	private String bucket20_point_sign;
	private BigDecimal bucket20_point_bal;
	private String bucket21_point_sign;
	private BigDecimal bucket21_point_bal;
	private String bucket22_point_sign;
	private BigDecimal bucket22_point_bal;
	private String bucket23_point_sign;
	private BigDecimal bucket23_point_bal;
	private String bucket24_point_sign;
	private BigDecimal bucket24_point_bal;
	private String bucket25_point_sign;
	private BigDecimal bucket25_point_bal;
	private String bucket26_point_sign;
	private BigDecimal bucket26_point_bal;
	private String bucket27_point_sign;
	private BigDecimal bucket27_point_bal;
	private String bucket28_point_sign;
	private BigDecimal bucket28_point_bal;
	private String bucket29_point_sign;
	private BigDecimal bucket29_point_bal;
	private String bucket30_point_sign;
	private BigDecimal bucket30_point_bal;
	private String bucket31_point_sign;
	private BigDecimal bucket31_point_bal;
	private String bucket32_point_sign;
	private BigDecimal bucket32_point_bal;
	private String bucket33_point_sign;
	private BigDecimal bucket33_point_bal;
	private String bucket34_point_sign;
	private BigDecimal bucket34_point_bal;
	private String bucket35_point_sign;
	private BigDecimal bucket35_point_bal;
	private String bucket36_point_sign;
	private BigDecimal bucket36_point_bal;
	private String last_expired_point_sign;
	private BigDecimal last_expired_point_bal;
	private boolean isDeducted;
	
	public CardHolderBucketDetailDTO(){}
	
	public CardHolderBucketDetailDTO(CardHolderBucketDetailDTO cardHolderBucketDetailDTO) {
		this.cardholder_point_bucket_id = cardHolderBucketDetailDTO.cardholder_point_bucket_id;   
		this.cust_no = cardHolderBucketDetailDTO.cust_no;
		this.cust_ic_no = cardHolderBucketDetailDTO.cust_ic_no;
		this.card_type = cardHolderBucketDetailDTO.card_type;
		this.card_no = cardHolderBucketDetailDTO.card_no;
		this.card_exp_date =cardHolderBucketDetailDTO.card_exp_date;
		this.card_post_flag = cardHolderBucketDetailDTO.card_post_flag;
		this.total_points_sign = cardHolderBucketDetailDTO.total_points_sign;
		this.total_points_bal = cardHolderBucketDetailDTO.total_points_bal;
		this.program_id = cardHolderBucketDetailDTO.program_id;
		this.bucket01_point_sign = cardHolderBucketDetailDTO.bucket01_point_sign;
		this.bucket01_point_bal = cardHolderBucketDetailDTO.bucket01_point_bal;
		this.bucket02_point_sign = cardHolderBucketDetailDTO.bucket02_point_sign;
		this.bucket02_point_bal = cardHolderBucketDetailDTO.bucket02_point_bal;
		this.bucket03_point_sign = cardHolderBucketDetailDTO.bucket03_point_sign;
		this.bucket03_point_bal = cardHolderBucketDetailDTO.bucket03_point_bal;
		this.bucket04_point_sign =cardHolderBucketDetailDTO.bucket04_point_sign;
		this.bucket04_point_bal = cardHolderBucketDetailDTO.bucket04_point_bal;
		this.bucket05_point_sign = cardHolderBucketDetailDTO.bucket05_point_sign;
		this.bucket05_point_bal =cardHolderBucketDetailDTO.bucket05_point_bal;
		this.bucket06_point_sign =cardHolderBucketDetailDTO.bucket06_point_sign;
		this.bucket06_point_bal = cardHolderBucketDetailDTO.bucket06_point_bal;
		this.bucket07_point_sign =cardHolderBucketDetailDTO.bucket07_point_sign;
		this.bucket07_point_bal =  cardHolderBucketDetailDTO.bucket07_point_bal;
		this.bucket08_point_sign =  cardHolderBucketDetailDTO.bucket08_point_sign;
		this.bucket08_point_bal = cardHolderBucketDetailDTO.bucket08_point_bal;
		this.bucket09_point_sign =cardHolderBucketDetailDTO.bucket09_point_sign;
		this.bucket09_point_bal = cardHolderBucketDetailDTO.bucket09_point_bal;
		this.bucket10_point_sign =cardHolderBucketDetailDTO.bucket10_point_sign;
		this.bucket10_point_bal = cardHolderBucketDetailDTO.bucket10_point_bal;
		this.bucket11_point_sign =cardHolderBucketDetailDTO.bucket11_point_sign;
		this.bucket11_point_bal = cardHolderBucketDetailDTO.bucket11_point_bal;
		this.bucket12_point_sign =cardHolderBucketDetailDTO.bucket12_point_sign;
		this.bucket12_point_bal = cardHolderBucketDetailDTO.bucket12_point_bal;
		this.bucket13_point_sign =  cardHolderBucketDetailDTO.bucket13_point_sign;
		this.bucket13_point_bal = cardHolderBucketDetailDTO.bucket13_point_bal;
		this.bucket14_point_sign =cardHolderBucketDetailDTO.bucket14_point_sign;
		this.bucket14_point_bal = cardHolderBucketDetailDTO.bucket14_point_bal;
		this.bucket15_point_sign =cardHolderBucketDetailDTO.bucket15_point_sign;
		this.bucket15_point_bal = cardHolderBucketDetailDTO.bucket15_point_bal;
		this.bucket16_point_sign = cardHolderBucketDetailDTO.bucket16_point_sign;
		this.bucket16_point_bal = cardHolderBucketDetailDTO.bucket16_point_bal;
		this.bucket17_point_sign =cardHolderBucketDetailDTO.bucket17_point_sign;
		this.bucket17_point_bal = cardHolderBucketDetailDTO.bucket17_point_bal;
		this.bucket18_point_sign =cardHolderBucketDetailDTO.bucket18_point_sign;
		this.bucket18_point_bal =cardHolderBucketDetailDTO.bucket18_point_bal;
		this.bucket19_point_sign = cardHolderBucketDetailDTO.bucket19_point_sign;
		this.bucket19_point_bal =cardHolderBucketDetailDTO.bucket19_point_bal;
		this.bucket20_point_sign = cardHolderBucketDetailDTO.bucket20_point_sign;
		this.bucket20_point_bal =cardHolderBucketDetailDTO.bucket20_point_bal;
		this.bucket21_point_sign =cardHolderBucketDetailDTO.bucket21_point_sign;
		this.bucket21_point_bal =cardHolderBucketDetailDTO.bucket21_point_bal;
		this.bucket22_point_sign = cardHolderBucketDetailDTO.bucket22_point_sign;
		this.bucket22_point_bal = cardHolderBucketDetailDTO.bucket22_point_bal;
		this.bucket23_point_sign =  cardHolderBucketDetailDTO.bucket23_point_sign; 
		this.bucket23_point_bal =cardHolderBucketDetailDTO.bucket23_point_bal;
		this.bucket24_point_sign =cardHolderBucketDetailDTO.bucket24_point_sign;
		this.bucket24_point_bal =cardHolderBucketDetailDTO.bucket24_point_bal;
		this.bucket25_point_sign =cardHolderBucketDetailDTO.bucket25_point_sign;
		this.bucket25_point_bal = cardHolderBucketDetailDTO.bucket25_point_bal;
		this.bucket26_point_sign =cardHolderBucketDetailDTO.bucket26_point_sign;
		this.bucket26_point_bal =cardHolderBucketDetailDTO.bucket26_point_bal;
		this.bucket27_point_sign = cardHolderBucketDetailDTO.bucket27_point_sign; 
		this.bucket27_point_bal =cardHolderBucketDetailDTO.bucket27_point_bal;
		this.bucket28_point_sign = cardHolderBucketDetailDTO.bucket28_point_sign; 
		this.bucket28_point_bal = cardHolderBucketDetailDTO.bucket28_point_bal;
		this.bucket29_point_sign =cardHolderBucketDetailDTO.bucket29_point_sign;
		this.bucket29_point_bal = cardHolderBucketDetailDTO.bucket29_point_bal;
		this.bucket30_point_sign =cardHolderBucketDetailDTO.bucket30_point_sign;
		this.bucket30_point_bal =cardHolderBucketDetailDTO.bucket30_point_bal;
		this.bucket31_point_sign =cardHolderBucketDetailDTO.bucket31_point_sign;
		this.bucket31_point_bal = cardHolderBucketDetailDTO.bucket31_point_bal;
		this.bucket32_point_sign =cardHolderBucketDetailDTO.bucket32_point_sign;
		this.bucket32_point_bal = cardHolderBucketDetailDTO.bucket32_point_bal;
		this.bucket33_point_sign =cardHolderBucketDetailDTO.bucket33_point_sign;
		this.bucket33_point_bal = cardHolderBucketDetailDTO.bucket33_point_bal;
		this.bucket34_point_sign = cardHolderBucketDetailDTO.bucket34_point_sign;
		this.bucket34_point_bal = cardHolderBucketDetailDTO.bucket34_point_bal;
		this.bucket35_point_sign =cardHolderBucketDetailDTO.bucket35_point_sign;
		this.bucket35_point_bal = cardHolderBucketDetailDTO.bucket35_point_bal;
		this.bucket36_point_sign =cardHolderBucketDetailDTO.bucket36_point_sign;
		this.bucket36_point_bal =cardHolderBucketDetailDTO.bucket36_point_bal;
		this.last_expired_point_sign = cardHolderBucketDetailDTO.last_expired_point_sign;
		this.last_expired_point_bal = cardHolderBucketDetailDTO.last_expired_point_bal;
		this.isDeducted = cardHolderBucketDetailDTO.isDeducted;
	}
	
	public BigDecimal getCardholder_point_bucket_id() {
		return cardholder_point_bucket_id;
	}
	public void setCardholder_point_bucket_id(BigDecimal cardholder_point_bucket_id) {
		this.cardholder_point_bucket_id = cardholder_point_bucket_id;
	}
	public String getCust_no() {
		return cust_no;
	}
	public void setCust_no(String cust_no) {
		this.cust_no = cust_no;
	}
	public String getCust_ic_no() {
		return cust_ic_no;
	}
	public void setCust_ic_no(String cust_ic_no) {
		this.cust_ic_no = cust_ic_no;
	}
	public String getCard_type() {
		return card_type;
	}
	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}
	public String getCard_no() {
		return card_no;
	}
	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}
	public String getCard_exp_date() {
		return card_exp_date;
	}
	public void setCard_exp_date(String card_exp_date) {
		this.card_exp_date = card_exp_date;
	}
	public String getCard_post_flag() {
		return card_post_flag;
	}
	public void setCard_post_flag(String card_post_flag) {
		this.card_post_flag = card_post_flag;
	}
	public String getTotal_points_sign() {
		return total_points_sign;
	}
	public void setTotal_points_sign(String total_points_sign) {
		this.total_points_sign = total_points_sign;
	}	
	public BigDecimal getTotal_points_bal() {
		return total_points_bal;
	}
	public void setTotal_points_bal(BigDecimal total_points_bal) {
		this.total_points_bal = total_points_bal;
	}
	public Integer getProgram_id() {
		return program_id;
	}
	public void setProgram_id(Integer program_id) {
		this.program_id = program_id;
	}
	public String getBucket01_point_sign() {
		return bucket01_point_sign;
	}
	public void setBucket01_point_sign(String bucket01_point_sign) {
		this.bucket01_point_sign = bucket01_point_sign;
	}
	public BigDecimal getBucket01_point_bal() {
		return bucket01_point_bal;
	}
	public void setBucket01_point_bal(BigDecimal bucket01_point_bal) {
		this.bucket01_point_bal = bucket01_point_bal;
	}
	public String getBucket02_point_sign() {
		return bucket02_point_sign;
	}
	public void setBucket02_point_sign(String bucket02_point_sign) {
		this.bucket02_point_sign = bucket02_point_sign;
	}
	public BigDecimal getBucket02_point_bal() {
		return bucket02_point_bal;
	}
	public void setBucket02_point_bal(BigDecimal bucket02_point_bal) {
		this.bucket02_point_bal = bucket02_point_bal;
	}
	public String getBucket03_point_sign() {
		return bucket03_point_sign;
	}
	public void setBucket03_point_sign(String bucket03_point_sign) {
		this.bucket03_point_sign = bucket03_point_sign;
	}
	public BigDecimal getBucket03_point_bal() {
		return bucket03_point_bal;
	}
	public void setBucket03_point_bal(BigDecimal bucket03_point_bal) {
		this.bucket03_point_bal = bucket03_point_bal;
	}
	public String getBucket04_point_sign() {
		return bucket04_point_sign;
	}
	public void setBucket04_point_sign(String bucket04_point_sign) {
		this.bucket04_point_sign = bucket04_point_sign;
	}
	public BigDecimal getBucket04_point_bal() {
		return bucket04_point_bal;
	}
	public void setBucket04_point_bal(BigDecimal bucket04_point_bal) {
		this.bucket04_point_bal = bucket04_point_bal;
	}
	public String getBucket05_point_sign() {
		return bucket05_point_sign;
	}
	public void setBucket05_point_sign(String bucket05_point_sign) {
		this.bucket05_point_sign = bucket05_point_sign;
	}
	public BigDecimal getBucket05_point_bal() {
		return bucket05_point_bal;
	}
	public void setBucket05_point_bal(BigDecimal bucket05_point_bal) {
		this.bucket05_point_bal = bucket05_point_bal;
	}
	public String getBucket06_point_sign() {
		return bucket06_point_sign;
	}
	public void setBucket06_point_sign(String bucket06_point_sign) {
		this.bucket06_point_sign = bucket06_point_sign;
	}
	public BigDecimal getBucket06_point_bal() {
		return bucket06_point_bal;
	}
	public void setBucket06_point_bal(BigDecimal bucket06_point_bal) {
		this.bucket06_point_bal = bucket06_point_bal;
	}
	public String getBucket07_point_sign() {
		return bucket07_point_sign;
	}
	public void setBucket07_point_sign(String bucket07_point_sign) {
		this.bucket07_point_sign = bucket07_point_sign;
	}
	public BigDecimal getBucket07_point_bal() {
		return bucket07_point_bal;
	}
	public void setBucket07_point_bal(BigDecimal bucket07_point_bal) {
		this.bucket07_point_bal = bucket07_point_bal;
	}
	public String getBucket08_point_sign() {
		return bucket08_point_sign;
	}
	public void setBucket08_point_sign(String bucket08_point_sign) {
		this.bucket08_point_sign = bucket08_point_sign;
	}
	public BigDecimal getBucket08_point_bal() {
		return bucket08_point_bal;
	}
	public void setBucket08_point_bal(BigDecimal bucket08_point_bal) {
		this.bucket08_point_bal = bucket08_point_bal;
	}
	public String getBucket09_point_sign() {
		return bucket09_point_sign;
	}
	public void setBucket09_point_sign(String bucket09_point_sign) {
		this.bucket09_point_sign = bucket09_point_sign;
	}
	public BigDecimal getBucket09_point_bal() {
		return bucket09_point_bal;
	}
	public void setBucket09_point_bal(BigDecimal bucket09_point_bal) {
		this.bucket09_point_bal = bucket09_point_bal;
	}
	public String getBucket10_point_sign() {
		return bucket10_point_sign;
	}
	public void setBucket10_point_sign(String bucket10_point_sign) {
		this.bucket10_point_sign = bucket10_point_sign;
	}
	public BigDecimal getBucket10_point_bal() {
		return bucket10_point_bal;
	}
	public void setBucket10_point_bal(BigDecimal bucket10_point_bal) {
		this.bucket10_point_bal = bucket10_point_bal;
	}
	public String getBucket11_point_sign() {
		return bucket11_point_sign;
	}
	public void setBucket11_point_sign(String bucket11_point_sign) {
		this.bucket11_point_sign = bucket11_point_sign;
	}
	public BigDecimal getBucket11_point_bal() {
		return bucket11_point_bal;
	}
	public void setBucket11_point_bal(BigDecimal bucket11_point_bal) {
		this.bucket11_point_bal = bucket11_point_bal;
	}
	public String getBucket12_point_sign() {
		return bucket12_point_sign;
	}
	public void setBucket12_point_sign(String bucket12_point_sign) {
		this.bucket12_point_sign = bucket12_point_sign;
	}
	public BigDecimal getBucket12_point_bal() {
		return bucket12_point_bal;
	}
	public void setBucket12_point_bal(BigDecimal bucket12_point_bal) {
		this.bucket12_point_bal = bucket12_point_bal;
	}
	public String getBucket13_point_sign() {
		return bucket13_point_sign;
	}
	public void setBucket13_point_sign(String bucket13_point_sign) {
		this.bucket13_point_sign = bucket13_point_sign;
	}
	public BigDecimal getBucket13_point_bal() {
		return bucket13_point_bal;
	}
	public void setBucket13_point_bal(BigDecimal bucket13_point_bal) {
		this.bucket13_point_bal = bucket13_point_bal;
	}
	public String getBucket14_point_sign() {
		return bucket14_point_sign;
	}
	public void setBucket14_point_sign(String bucket14_point_sign) {
		this.bucket14_point_sign = bucket14_point_sign;
	}
	public BigDecimal getBucket14_point_bal() {
		return bucket14_point_bal;
	}
	public void setBucket14_point_bal(BigDecimal bucket14_point_bal) {
		this.bucket14_point_bal = bucket14_point_bal;
	}
	public String getBucket15_point_sign() {
		return bucket15_point_sign;
	}
	public void setBucket15_point_sign(String bucket15_point_sign) {
		this.bucket15_point_sign = bucket15_point_sign;
	}
	public BigDecimal getBucket15_point_bal() {
		return bucket15_point_bal;
	}
	public void setBucket15_point_bal(BigDecimal bucket15_point_bal) {
		this.bucket15_point_bal = bucket15_point_bal;
	}
	public String getBucket16_point_sign() {
		return bucket16_point_sign;
	}
	public void setBucket16_point_sign(String bucket16_point_sign) {
		this.bucket16_point_sign = bucket16_point_sign;
	}
	public BigDecimal getBucket16_point_bal() {
		return bucket16_point_bal;
	}
	public void setBucket16_point_bal(BigDecimal bucket16_point_bal) {
		this.bucket16_point_bal = bucket16_point_bal;
	}
	public String getBucket17_point_sign() {
		return bucket17_point_sign;
	}
	public void setBucket17_point_sign(String bucket17_point_sign) {
		this.bucket17_point_sign = bucket17_point_sign;
	}
	public BigDecimal getBucket17_point_bal() {
		return bucket17_point_bal;
	}
	public void setBucket17_point_bal(BigDecimal bucket17_point_bal) {
		this.bucket17_point_bal = bucket17_point_bal;
	}
	public String getBucket18_point_sign() {
		return bucket18_point_sign;
	}
	public void setBucket18_point_sign(String bucket18_point_sign) {
		this.bucket18_point_sign = bucket18_point_sign;
	}
	public BigDecimal getBucket18_point_bal() {
		return bucket18_point_bal;
	}
	public void setBucket18_point_bal(BigDecimal bucket18_point_bal) {
		this.bucket18_point_bal = bucket18_point_bal;
	}
	public String getBucket19_point_sign() {
		return bucket19_point_sign;
	}
	public void setBucket19_point_sign(String bucket19_point_sign) {
		this.bucket19_point_sign = bucket19_point_sign;
	}
	public BigDecimal getBucket19_point_bal() {
		return bucket19_point_bal;
	}
	public void setBucket19_point_bal(BigDecimal bucket19_point_bal) {
		this.bucket19_point_bal = bucket19_point_bal;
	}
	public String getBucket20_point_sign() {
		return bucket20_point_sign;
	}
	public void setBucket20_point_sign(String bucket20_point_sign) {
		this.bucket20_point_sign = bucket20_point_sign;
	}
	public BigDecimal getBucket20_point_bal() {
		return bucket20_point_bal;
	}
	public void setBucket20_point_bal(BigDecimal bucket20_point_bal) {
		this.bucket20_point_bal = bucket20_point_bal;
	}
	public String getBucket21_point_sign() {
		return bucket21_point_sign;
	}
	public void setBucket21_point_sign(String bucket21_point_sign) {
		this.bucket21_point_sign = bucket21_point_sign;
	}
	public BigDecimal getBucket21_point_bal() {
		return bucket21_point_bal;
	}
	public void setBucket21_point_bal(BigDecimal bucket21_point_bal) {
		this.bucket21_point_bal = bucket21_point_bal;
	}
	public String getBucket22_point_sign() {
		return bucket22_point_sign;
	}
	public void setBucket22_point_sign(String bucket22_point_sign) {
		this.bucket22_point_sign = bucket22_point_sign;
	}
	public BigDecimal getBucket22_point_bal() {
		return bucket22_point_bal;
	}
	public void setBucket22_point_bal(BigDecimal bucket22_point_bal) {
		this.bucket22_point_bal = bucket22_point_bal;
	}
	public String getBucket23_point_sign() {
		return bucket23_point_sign;
	}
	public void setBucket23_point_sign(String bucket23_point_sign) {
		this.bucket23_point_sign = bucket23_point_sign;
	}
	public BigDecimal getBucket23_point_bal() {
		return bucket23_point_bal;
	}
	public void setBucket23_point_bal(BigDecimal bucket23_point_bal) {
		this.bucket23_point_bal = bucket23_point_bal;
	}
	public String getBucket24_point_sign() {
		return bucket24_point_sign;
	}
	public void setBucket24_point_sign(String bucket24_point_sign) {
		this.bucket24_point_sign = bucket24_point_sign;
	}
	public BigDecimal getBucket24_point_bal() {
		return bucket24_point_bal;
	}
	public void setBucket24_point_bal(BigDecimal bucket24_point_bal) {
		this.bucket24_point_bal = bucket24_point_bal;
	}
	public String getBucket25_point_sign() {
		return bucket25_point_sign;
	}
	public void setBucket25_point_sign(String bucket25_point_sign) {
		this.bucket25_point_sign = bucket25_point_sign;
	}
	public BigDecimal getBucket25_point_bal() {
		return bucket25_point_bal;
	}
	public void setBucket25_point_bal(BigDecimal bucket25_point_bal) {
		this.bucket25_point_bal = bucket25_point_bal;
	}
	public String getBucket26_point_sign() {
		return bucket26_point_sign;
	}
	public void setBucket26_point_sign(String bucket26_point_sign) {
		this.bucket26_point_sign = bucket26_point_sign;
	}
	public BigDecimal getBucket26_point_bal() {
		return bucket26_point_bal;
	}
	public void setBucket26_point_bal(BigDecimal bucket26_point_bal) {
		this.bucket26_point_bal = bucket26_point_bal;
	}
	public String getBucket27_point_sign() {
		return bucket27_point_sign;
	}
	public void setBucket27_point_sign(String bucket27_point_sign) {
		this.bucket27_point_sign = bucket27_point_sign;
	}
	public BigDecimal getBucket27_point_bal() {
		return bucket27_point_bal;
	}
	public void setBucket27_point_bal(BigDecimal bucket27_point_bal) {
		this.bucket27_point_bal = bucket27_point_bal;
	}
	public String getBucket28_point_sign() {
		return bucket28_point_sign;
	}
	public void setBucket28_point_sign(String bucket28_point_sign) {
		this.bucket28_point_sign = bucket28_point_sign;
	}
	public BigDecimal getBucket28_point_bal() {
		return bucket28_point_bal;
	}
	public void setBucket28_point_bal(BigDecimal bucket28_point_bal) {
		this.bucket28_point_bal = bucket28_point_bal;
	}
	public String getBucket29_point_sign() {
		return bucket29_point_sign;
	}
	public void setBucket29_point_sign(String bucket29_point_sign) {
		this.bucket29_point_sign = bucket29_point_sign;
	}
	public BigDecimal getBucket29_point_bal() {
		return bucket29_point_bal;
	}
	public void setBucket29_point_bal(BigDecimal bucket29_point_bal) {
		this.bucket29_point_bal = bucket29_point_bal;
	}
	public String getBucket30_point_sign() {
		return bucket30_point_sign;
	}
	public void setBucket30_point_sign(String bucket30_point_sign) {
		this.bucket30_point_sign = bucket30_point_sign;
	}
	public BigDecimal getBucket30_point_bal() {
		return bucket30_point_bal;
	}
	public void setBucket30_point_bal(BigDecimal bucket30_point_bal) {
		this.bucket30_point_bal = bucket30_point_bal;
	}
	public String getBucket31_point_sign() {
		return bucket31_point_sign;
	}
	public void setBucket31_point_sign(String bucket31_point_sign) {
		this.bucket31_point_sign = bucket31_point_sign;
	}
	public BigDecimal getBucket31_point_bal() {
		return bucket31_point_bal;
	}
	public void setBucket31_point_bal(BigDecimal bucket31_point_bal) {
		this.bucket31_point_bal = bucket31_point_bal;
	}
	public String getBucket32_point_sign() {
		return bucket32_point_sign;
	}
	public void setBucket32_point_sign(String bucket32_point_sign) {
		this.bucket32_point_sign = bucket32_point_sign;
	}
	public BigDecimal getBucket32_point_bal() {
		return bucket32_point_bal;
	}
	public void setBucket32_point_bal(BigDecimal bucket32_point_bal) {
		this.bucket32_point_bal = bucket32_point_bal;
	}
	public String getBucket33_point_sign() {
		return bucket33_point_sign;
	}
	public void setBucket33_point_sign(String bucket33_point_sign) {
		this.bucket33_point_sign = bucket33_point_sign;
	}
	public BigDecimal getBucket33_point_bal() {
		return bucket33_point_bal;
	}
	public void setBucket33_point_bal(BigDecimal bucket33_point_bal) {
		this.bucket33_point_bal = bucket33_point_bal;
	}
	public String getBucket34_point_sign() {
		return bucket34_point_sign;
	}
	public void setBucket34_point_sign(String bucket34_point_sign) {
		this.bucket34_point_sign = bucket34_point_sign;
	}
	public BigDecimal getBucket34_point_bal() {
		return bucket34_point_bal;
	}
	public void setBucket34_point_bal(BigDecimal bucket34_point_bal) {
		this.bucket34_point_bal = bucket34_point_bal;
	}
	public String getBucket35_point_sign() {
		return bucket35_point_sign;
	}
	public void setBucket35_point_sign(String bucket35_point_sign) {
		this.bucket35_point_sign = bucket35_point_sign;
	}
	public BigDecimal getBucket35_point_bal() {
		return bucket35_point_bal;
	}
	public void setBucket35_point_bal(BigDecimal bucket35_point_bal) {
		this.bucket35_point_bal = bucket35_point_bal;
	}
	public String getBucket36_point_sign() {
		return bucket36_point_sign;
	}
	public void setBucket36_point_sign(String bucket36_point_sign) {
		this.bucket36_point_sign = bucket36_point_sign;
	}
	public BigDecimal getBucket36_point_bal() {
		return bucket36_point_bal;
	}
	public void setBucket36_point_bal(BigDecimal bucket36_point_bal) {
		this.bucket36_point_bal = bucket36_point_bal;
	}
    
    public String getLast_expired_point_sign() {
		return last_expired_point_sign;
	}

	public void setLast_expired_point_sign(String last_expired_point_sign) {
		this.last_expired_point_sign = last_expired_point_sign;
	}

	public BigDecimal getLast_expired_point_bal() {
		return last_expired_point_bal;
	}

	public void setLast_expired_point_bal(BigDecimal last_expired_point_bal) {
		this.last_expired_point_bal = last_expired_point_bal;
	}	

	public String getOrg_no() {
		return org_no;
	}

	public void setOrg_no(String org_no) {
		this.org_no = org_no;
	}
		
	public boolean isDeducted() {
		return isDeducted;
	}

	public void setDeducted(boolean isDeducted) {
		this.isDeducted = isDeducted;
	}

	@Override
    public String toString() {
    	return "CardHolderBucketDetailDTO ["
    			+"cust_no=".concat(cust_no)
    			+",cust_ic_no=".concat(cust_ic_no)
    			+",card_no=".concat(card_no)
    			+",card_post_flag=".concat(card_post_flag)
    			+",total_points_sign=".concat(total_points_sign)
    			+",total_points_bal=".concat(total_points_bal.toPlainString())
    			+",bucket01_point_sign=".concat(bucket01_point_sign)
    			+",bucket01_point_bal=".concat(bucket01_point_bal.toPlainString())
    			+",bucket02_point_sign=".concat(bucket02_point_sign)
    			+",bucket02_point_bal=".concat(bucket02_point_bal.toPlainString())
    			+",bucket03_point_sign=".concat(bucket03_point_sign)
    			+",bucket03_point_bal=".concat(bucket03_point_bal.toPlainString())
    			+",bucket04_point_sign=".concat(bucket04_point_sign)
    			+",bucket04_point_bal=".concat(bucket04_point_bal.toPlainString())
    			+",bucket05_point_sign=".concat(bucket05_point_sign)
    			+",bucket05_point_bal=".concat(bucket05_point_bal.toPlainString())
    			+",bucket06_point_sign=".concat(bucket06_point_sign)
    			+",bucket06_point_bal=".concat(bucket06_point_bal.toPlainString())
    			+",bucket07_point_sign=".concat(bucket07_point_sign)
    			+",bucket07_point_bal=".concat(bucket07_point_bal.toPlainString())
    			+",bucket08_point_sign=".concat(bucket08_point_sign)
    			+",bucket08_point_bal=".concat(bucket08_point_bal.toPlainString())
    			+",bucket09_point_sign=".concat(bucket09_point_sign)
    			+",bucket09_point_bal=".concat(bucket09_point_bal.toPlainString())
    			+",bucket10_point_sign=".concat(bucket10_point_sign)
    			+",bucket10_point_bal=".concat(bucket10_point_bal.toPlainString())
    			+",bucket11_point_sign=".concat(bucket11_point_sign)
    			+",bucket11_point_bal=".concat(bucket11_point_bal.toPlainString())
    			+",bucket12_point_sign=".concat(bucket12_point_sign)
    			+",bucket12_point_bal=".concat(bucket12_point_bal.toPlainString())
    			+",bucket13_point_sign=".concat(bucket13_point_sign)
    			+",bucket13_point_bal=".concat(bucket13_point_bal.toPlainString())
    			+",bucket14_point_sign=".concat(bucket14_point_sign)
    			+",bucket14_point_bal=".concat(bucket14_point_bal.toPlainString())
    			+",bucket15_point_sign=".concat(bucket15_point_sign)
    			+",bucket15_point_bal=".concat(bucket15_point_bal.toPlainString())
    			+",bucket16_point_sign=".concat(bucket16_point_sign)
    			+",bucket16_point_bal=".concat(bucket16_point_bal.toPlainString())
    			+",bucket17_point_sign=".concat(bucket17_point_sign)
    			+",bucket17_point_bal=".concat(bucket17_point_bal.toPlainString())
    			+",bucket18_point_sign=".concat(bucket18_point_sign)
    			+",bucket18_point_bal=".concat(bucket18_point_bal.toPlainString())
    			+",bucket19_point_sign=".concat(bucket19_point_sign)
    			+",bucket19_point_bal=".concat(bucket19_point_bal.toPlainString())
    			+",bucket20_point_sign=".concat(bucket20_point_sign)
    			+",bucket20_point_bal=".concat(bucket20_point_bal.toPlainString())
    			+",bucket21_point_sign=".concat(bucket21_point_sign)
    			+",bucket21_point_bal=".concat(bucket21_point_bal.toPlainString())
    			+",bucket22_point_sign=".concat(bucket22_point_sign)
    			+",bucket22_point_bal=".concat(bucket22_point_bal.toPlainString())
    			+",bucket23_point_sign=".concat(bucket23_point_sign)
    			+",bucket23_point_bal=".concat(bucket23_point_bal.toPlainString())
    			+",bucket24_point_sign=".concat(bucket24_point_sign)
    			+",bucket24_point_bal=".concat(bucket24_point_bal.toPlainString())
    			+",bucket25_point_sign=".concat(bucket25_point_sign)
    			+",bucket25_point_bal=".concat(bucket25_point_bal.toPlainString())
    			+",bucket26_point_sign=".concat(bucket26_point_sign)
    			+",bucket26_point_bal=".concat(bucket26_point_bal.toPlainString())
    			+",bucket27_point_sign=".concat(bucket27_point_sign)
    			+",bucket27_point_bal=".concat(bucket27_point_bal.toPlainString())
    			+",bucket28_point_sign=".concat(bucket28_point_sign)
    			+",bucket28_point_bal=".concat(bucket28_point_bal.toPlainString())
    			+",bucket29_point_sign=".concat(bucket29_point_sign)
    			+",bucket29_point_bal=".concat(bucket29_point_bal.toPlainString())
    			+",bucket30_point_sign=".concat(bucket30_point_sign)
    			+",bucket30_point_bal=".concat(bucket30_point_bal.toPlainString())
    			+",bucket31_point_sign=".concat(bucket31_point_sign)
    			+",bucket31_point_bal=".concat(bucket31_point_bal.toPlainString())
    			+",bucket32_point_sign=".concat(bucket32_point_sign)
    			+",bucket32_point_bal=".concat(bucket32_point_bal.toPlainString())
    			+",bucket33_point_sign=".concat(bucket33_point_sign)
    			+",bucket33_point_bal=".concat(bucket33_point_bal.toPlainString())
    			+",bucket34_point_sign=".concat(bucket34_point_sign)
    			+",bucket34_point_bal=".concat(bucket34_point_bal.toPlainString())
    			+",bucket35_point_sign=".concat(bucket35_point_sign)
    			+",bucket35_point_bal=".concat(bucket35_point_bal.toPlainString())
    			+",bucket36_point_sign=".concat(bucket36_point_sign)
    			+",bucket36_point_bal=".concat(bucket36_point_bal.toPlainString())
    			+"]";
    }
}
