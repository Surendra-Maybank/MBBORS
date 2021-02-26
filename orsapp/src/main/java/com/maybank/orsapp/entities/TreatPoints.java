/**
 * 
 */
package com.maybank.orsapp.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 80003905
 *
 */
@Entity
@Table(name="TREAT_POINTS")
public class TreatPoints implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BTS_ID", unique=true, nullable=false)
	private Long btsId;

	@Column(name="BCKT1_POINT_BAL", precision=15, scale=2)
	private BigDecimal bckt1PointBal;

	@Column(name="BCKT1_POINT_SIGN")
	private String bckt1PointSign;
	
	@Column(name="BCKT2_POINT_BAL", precision=15, scale=2)
	private BigDecimal bckt2PointBal;

	@Column(name="BCKT2_POINT_SIGN")
	private String bckt2PointSign;
	
	@Column(name="BCKT3_POINT_BAL", precision=15, scale=2)
	private BigDecimal bckt3PointBal;

	@Column(name="BCKT3_POINT_SIGN")
	private String bckt3PointSign;
	
	@Column(name="BCKT4_POINT_BAL", precision=15, scale=2)
	private BigDecimal bckt4PointBal;

	@Column(name="BCKT4_POINT_SIGN")
	private String bckt4PointSign;

	@Column(name="BCKT5_POINT_BAL", precision=15, scale=2)
	private BigDecimal bckt5PointBal;

	@Column(name="BCKT5_POINT_SIGN")
	private String bckt5PointSign;

	@Column(name="BCKT6_POINT_BAL", precision=15, scale=2)
	private BigDecimal bckt6PointBal;

	@Column(name="BCKT6_POINT_SIGN")
	private String bckt6PointSign;

	@Column(name="BCKT7_POINT_BAL", precision=15, scale=2)
	private BigDecimal bckt7PointBal;

	@Column(name="BCKT7_POINT_SIGN")
	private String bckt7PointSign;

	@Column(name="BCKT8_POINT_BAL", precision=15, scale=2)
	private BigDecimal bckt8PointBal;

	@Column(name="BCKT8_POINT_SIGN")
	private String bckt8PointSign;

	@Column(name="BCKT9_POINT_BAL", precision=15, scale=2)
	private BigDecimal bckt9PointBal;

	@Column(name="BCKT9_POINT_SIGN")
	private String bckt9PointSign;

	@Column(name="BCKT10_POINT_BAL", precision=15, scale=2)
	private BigDecimal bckt10PointBal;

	@Column(name="BCKT10_POINT_SIGN")
	private String bckt10PointSign;

	@Column(name="BCKT11_POINT_BAL", precision=15, scale=2)
	private BigDecimal bckt11PointBal;

	@Column(name="BCKT11_POINT_SIGN")
	private String bckt11PointSign;

	@Column(name="BCKT12_POINT_BAL", precision=15, scale=2)
	private BigDecimal bckt12PointBal;

	@Column(name="BCKT12_POINT_SIGN")
	private String bckt12PointSign;

	@Column(name="BCKT13_POINT_BAL", precision=15, scale=2)
	private BigDecimal bckt13PointBal;

	@Column(name="BCKT13_POINT_SIGN")
	private String bckt13PointSign;

	@Column(name="BCKT14_POINT_BAL", precision=15, scale=2)
	private BigDecimal bckt14PointBal;

	@Column(name="BCKT14_POINT_SIGN")
	private String bckt14PointSign;

	@Column(name="BCKT15_POINT_BAL", precision=15, scale=2)
	private BigDecimal bckt15PointBal;

	@Column(name="BCKT15_POINT_SIGN")
	private String bckt15PointSign;

	@Column(name="BCKT16_POINT_BAL", precision=15, scale=2)
	private BigDecimal bckt16PointBal;

	@Column(name="BCKT16_POINT_SIGN")
	private String bckt16PointSign;

	@Column(name="BCKT17_POINT_BAL", precision=15, scale=2)
	private BigDecimal bckt17PointBal;

	@Column(name="BCKT17_POINT_SIGN")
	private String bckt17PointSign;

	@Column(name="BCKT18_POINT_BAL", precision=15, scale=2)
	private BigDecimal bckt18PointBal;

	@Column(name="BCKT18_POINT_SIGN")
	private String bckt18PointSign;

	@Column(name="BCKT19_POINT_BAL", precision=15, scale=2)
	private BigDecimal bckt19PointBal;

	@Column(name="BCKT19_POINT_SIGN")
	private String bckt19PointSign;

	@Column(name="BCKT20_POINT_BAL", precision=15, scale=2)
	private BigDecimal bckt20PointBal;

	@Column(name="BCKT20_POINT_SIGN")
	private String bckt20PointSign;

	@Column(name="BCKT21_POINT_BAL", precision=15, scale=2)
	private BigDecimal bckt21PointBal;

	@Column(name="BCKT21_POINT_SIGN")
	private String bckt21PointSign;

	@Column(name="BCKT22_POINT_BAL", precision=15, scale=2)
	private BigDecimal bckt22PointBal;

	@Column(name="BCKT22_POINT_SIGN")
	private String bckt22PointSign;

	@Column(name="BCKT23_POINT_BAL", precision=15, scale=2)
	private BigDecimal bckt23PointBal;

	@Column(name="BCKT23_POINT_SIGN")
	private String bckt23PointSign;

	@Column(name="BCKT24_POINT_BAL", precision=15, scale=2)
	private BigDecimal bckt24PointBal;

	@Column(name="BCKT24_POINT_SIGN")
	private String bckt24PointSign;

	@Column(name="BCKT25_POINT_BAL", precision=15, scale=2)
	private BigDecimal bckt25PointBal;

	@Column(name="BCKT25_POINT_SIGN")
	private String bckt25PointSign;

	@Column(name="BCKT26_POINT_BAL", precision=15, scale=2)
	private BigDecimal bckt26PointBal;

	@Column(name="BCKT26_POINT_SIGN")
	private String bckt26PointSign;

	@Column(name="BCKT27_POINT_BAL", precision=15, scale=2)
	private BigDecimal bckt27PointBal;

	@Column(name="BCKT27_POINT_SIGN")
	private String bckt27PointSign;

	@Column(name="BCKT28_POINT_BAL", precision=15, scale=2)
	private BigDecimal bckt28PointBal;

	@Column(name="BCKT28_POINT_SIGN")
	private String bckt28PointSign;

	@Column(name="BCKT29_POINT_BAL", precision=15, scale=2)
	private BigDecimal bckt29PointBal;

	@Column(name="BCKT29_POINT_SIGN")
	private String bckt29PointSign;

	@Column(name="BCKT30_POINT_BAL", precision=15, scale=2)
	private BigDecimal bckt30PointBal;

	@Column(name="BCKT30_POINT_SIGN")
	private String bckt30PointSign;

	@Column(name="BCKT31_POINT_BAL", precision=15, scale=2)
	private BigDecimal bckt31PointBal;

	@Column(name="BCKT31_POINT_SIGN")
	private String bckt31PointSign;

	@Column(name="BCKT32_POINT_BAL", precision=15, scale=2)
	private BigDecimal bckt32PointBal;

	@Column(name="BCKT32_POINT_SIGN")
	private String bckt32PointSign;

	@Column(name="BCKT33_POINT_BAL", precision=15, scale=2)
	private BigDecimal bckt33PointBal;

	@Column(name="BCKT33_POINT_SIGN")
	private String bckt33PointSign;

	@Column(name="BCKT34_POINT_BAL", precision=15, scale=2)
	private BigDecimal bckt34PointBal;

	@Column(name="BCKT34_POINT_SIGN")
	private String bckt34PointSign;

	@Column(name="BCKT35_POINT_BAL", precision=15, scale=2)
	private BigDecimal bckt35PointBal;

	@Column(name="BCKT35_POINT_SIGN")
	private String bckt35PointSign;

	@Column(name="BCKT36_POINT_BAL", precision=15, scale=2)
	private BigDecimal bckt36PointBal;

	@Column(name="BCKT36_POINT_SIGN")
	private String bckt36PointSign;

	@Column(name="BTS_ACTIVE")
	private String btsActive;

	@Column(name="BTS_CREATED_DATETIME")
	private Timestamp btsCreatedDatetime;

	@Column(name="BTS_UPDATED_DATETIME")
	private Timestamp btsUpdatedDatetime;

	@Column(name="CARD_NO")
	private String cardNo;

	@Column(name="CARD_TYPE")
	private String cardType;

	@Column(name="CUST_ADDR1")
	private String custAddr1;

	@Column(name="CUST_ADDR2")
	private String custAddr2;

	@Column(name="CUST_ADDR3")
	private String custAddr3;

	@Column(name="CUST_ADDR4")
	private String custAddr4;

	@Column(name="CUST_EXP_DATE")
	private String custExpDate;

	@Column(name="CUST_HOME_NO")
	private String custHomeNo;

	@Column(name="CUST_IC")
	private String custIc;

	@Column(name="CUST_MOBILE_NO")
	private String custMobileNo;

	@Column(name="CUST_NAME1")
	private String custName1;

	@Column(name="CUST_NAME2")
	private String custName2;

	@Column(name="CUST_NO")
	private String custNo;

	@Column(name="CUST_OFF_NO")
	private String custOffNo;

	@Column(name="CUST_POST_FLAG")
	private String custPostFlag;

	@Column(name="LOYALTY_ID")
	private String loyaltyId;

	@Column(name="ORG_NO")
	private String orgNo;

	@Column(name="POINT", precision=15, scale=2)
	private BigDecimal point;

	@Column(name="POINT_SIGN")
	private String pointSign;

	@Column(name="PROGRAM_ID")
	private Long programId;

	@Column(name="TOT_EXP_LAST_BAL", precision=15, scale=2)
	private BigDecimal totExpLastBal;

	@Column(name="TOT_EXP_LAST_SIGN")
	private String totExpLastSign;

	@Column(name="TOTAL_POINTS_BAL", precision=15, scale=2)
	private BigDecimal totalPointsBal;

	@Column(name="TOTAL_POINTS_SIGN")
	private String totalPointsSign;

	@Column(name="TRANSFORMED_TOTAL_POINTS_BAL")
	private Integer transformedTotalPointsBal;

	@Column(name="ZIP_CODE")
	private String zipCode;

	public BigDecimal getBckt1PointBal() {
		return this.bckt1PointBal;
	}

	public void setBckt1PointBal(BigDecimal bckt1PointBal) {
		this.bckt1PointBal = bckt1PointBal;
	}

	public String getBckt1PointSign() {
		return this.bckt1PointSign;
	}

	public void setBckt1PointSign(String bckt1PointSign) {
		this.bckt1PointSign = bckt1PointSign;
	}

	public BigDecimal getBckt10PointBal() {
		return this.bckt10PointBal;
	}

	public void setBckt10PointBal(BigDecimal bckt10PointBal) {
		this.bckt10PointBal = bckt10PointBal;
	}

	public String getBckt10PointSign() {
		return this.bckt10PointSign;
	}

	public void setBckt10PointSign(String bckt10PointSign) {
		this.bckt10PointSign = bckt10PointSign;
	}

	public BigDecimal getBckt11PointBal() {
		return this.bckt11PointBal;
	}

	public void setBckt11PointBal(BigDecimal bckt11PointBal) {
		this.bckt11PointBal = bckt11PointBal;
	}

	public String getBckt11PointSign() {
		return this.bckt11PointSign;
	}

	public void setBckt11PointSign(String bckt11PointSign) {
		this.bckt11PointSign = bckt11PointSign;
	}

	public BigDecimal getBckt12PointBal() {
		return this.bckt12PointBal;
	}

	public void setBckt12PointBal(BigDecimal bckt12PointBal) {
		this.bckt12PointBal = bckt12PointBal;
	}

	public String getBckt12PointSign() {
		return this.bckt12PointSign;
	}

	public void setBckt12PointSign(String bckt12PointSign) {
		this.bckt12PointSign = bckt12PointSign;
	}

	public BigDecimal getBckt13PointBal() {
		return this.bckt13PointBal;
	}

	public void setBckt13PointBal(BigDecimal bckt13PointBal) {
		this.bckt13PointBal = bckt13PointBal;
	}

	public String getBckt13PointSign() {
		return this.bckt13PointSign;
	}

	public void setBckt13PointSign(String bckt13PointSign) {
		this.bckt13PointSign = bckt13PointSign;
	}

	public BigDecimal getBckt14PointBal() {
		return this.bckt14PointBal;
	}

	public void setBckt14PointBal(BigDecimal bckt14PointBal) {
		this.bckt14PointBal = bckt14PointBal;
	}

	public String getBckt14PointSign() {
		return this.bckt14PointSign;
	}

	public void setBckt14PointSign(String bckt14PointSign) {
		this.bckt14PointSign = bckt14PointSign;
	}

	public BigDecimal getBckt15PointBal() {
		return this.bckt15PointBal;
	}

	public void setBckt15PointBal(BigDecimal bckt15PointBal) {
		this.bckt15PointBal = bckt15PointBal;
	}

	public String getBckt15PointSign() {
		return this.bckt15PointSign;
	}

	public void setBckt15PointSign(String bckt15PointSign) {
		this.bckt15PointSign = bckt15PointSign;
	}

	public BigDecimal getBckt16PointBal() {
		return this.bckt16PointBal;
	}

	public void setBckt16PointBal(BigDecimal bckt16PointBal) {
		this.bckt16PointBal = bckt16PointBal;
	}

	public String getBckt16PointSign() {
		return this.bckt16PointSign;
	}

	public void setBckt16PointSign(String bckt16PointSign) {
		this.bckt16PointSign = bckt16PointSign;
	}

	public BigDecimal getBckt17PointBal() {
		return this.bckt17PointBal;
	}

	public void setBckt17PointBal(BigDecimal bckt17PointBal) {
		this.bckt17PointBal = bckt17PointBal;
	}

	public String getBckt17PointSign() {
		return this.bckt17PointSign;
	}

	public void setBckt17PointSign(String bckt17PointSign) {
		this.bckt17PointSign = bckt17PointSign;
	}

	public BigDecimal getBckt18PointBal() {
		return this.bckt18PointBal;
	}

	public void setBckt18PointBal(BigDecimal bckt18PointBal) {
		this.bckt18PointBal = bckt18PointBal;
	}

	public String getBckt18PointSign() {
		return this.bckt18PointSign;
	}

	public void setBckt18PointSign(String bckt18PointSign) {
		this.bckt18PointSign = bckt18PointSign;
	}

	public BigDecimal getBckt19PointBal() {
		return this.bckt19PointBal;
	}

	public void setBckt19PointBal(BigDecimal bckt19PointBal) {
		this.bckt19PointBal = bckt19PointBal;
	}

	public String getBckt19PointSign() {
		return this.bckt19PointSign;
	}

	public void setBckt19PointSign(String bckt19PointSign) {
		this.bckt19PointSign = bckt19PointSign;
	}

	public BigDecimal getBckt2PointBal() {
		return this.bckt2PointBal;
	}

	public void setBckt2PointBal(BigDecimal bckt2PointBal) {
		this.bckt2PointBal = bckt2PointBal;
	}

	public String getBckt2PointSign() {
		return this.bckt2PointSign;
	}

	public void setBckt2PointSign(String bckt2PointSign) {
		this.bckt2PointSign = bckt2PointSign;
	}

	public BigDecimal getBckt20PointBal() {
		return this.bckt20PointBal;
	}

	public void setBckt20PointBal(BigDecimal bckt20PointBal) {
		this.bckt20PointBal = bckt20PointBal;
	}

	public String getBckt20PointSign() {
		return this.bckt20PointSign;
	}

	public void setBckt20PointSign(String bckt20PointSign) {
		this.bckt20PointSign = bckt20PointSign;
	}

	public BigDecimal getBckt21PointBal() {
		return this.bckt21PointBal;
	}

	public void setBckt21PointBal(BigDecimal bckt21PointBal) {
		this.bckt21PointBal = bckt21PointBal;
	}

	public String getBckt21PointSign() {
		return this.bckt21PointSign;
	}

	public void setBckt21PointSign(String bckt21PointSign) {
		this.bckt21PointSign = bckt21PointSign;
	}

	public BigDecimal getBckt22PointBal() {
		return this.bckt22PointBal;
	}

	public void setBckt22PointBal(BigDecimal bckt22PointBal) {
		this.bckt22PointBal = bckt22PointBal;
	}

	public String getBckt22PointSign() {
		return this.bckt22PointSign;
	}

	public void setBckt22PointSign(String bckt22PointSign) {
		this.bckt22PointSign = bckt22PointSign;
	}

	public BigDecimal getBckt23PointBal() {
		return this.bckt23PointBal;
	}

	public void setBckt23PointBal(BigDecimal bckt23PointBal) {
		this.bckt23PointBal = bckt23PointBal;
	}

	public String getBckt23PointSign() {
		return this.bckt23PointSign;
	}

	public void setBckt23PointSign(String bckt23PointSign) {
		this.bckt23PointSign = bckt23PointSign;
	}

	public BigDecimal getBckt24PointBal() {
		return this.bckt24PointBal;
	}

	public void setBckt24PointBal(BigDecimal bckt24PointBal) {
		this.bckt24PointBal = bckt24PointBal;
	}

	public String getBckt24PointSign() {
		return this.bckt24PointSign;
	}

	public void setBckt24PointSign(String bckt24PointSign) {
		this.bckt24PointSign = bckt24PointSign;
	}

	public BigDecimal getBckt25PointBal() {
		return this.bckt25PointBal;
	}

	public void setBckt25PointBal(BigDecimal bckt25PointBal) {
		this.bckt25PointBal = bckt25PointBal;
	}

	public String getBckt25PointSign() {
		return this.bckt25PointSign;
	}

	public void setBckt25PointSign(String bckt25PointSign) {
		this.bckt25PointSign = bckt25PointSign;
	}

	public BigDecimal getBckt26PointBal() {
		return this.bckt26PointBal;
	}

	public void setBckt26PointBal(BigDecimal bckt26PointBal) {
		this.bckt26PointBal = bckt26PointBal;
	}

	public String getBckt26PointSign() {
		return this.bckt26PointSign;
	}

	public void setBckt26PointSign(String bckt26PointSign) {
		this.bckt26PointSign = bckt26PointSign;
	}

	public BigDecimal getBckt27PointBal() {
		return this.bckt27PointBal;
	}

	public void setBckt27PointBal(BigDecimal bckt27PointBal) {
		this.bckt27PointBal = bckt27PointBal;
	}

	public String getBckt27PointSign() {
		return this.bckt27PointSign;
	}

	public void setBckt27PointSign(String bckt27PointSign) {
		this.bckt27PointSign = bckt27PointSign;
	}

	public BigDecimal getBckt28PointBal() {
		return this.bckt28PointBal;
	}

	public void setBckt28PointBal(BigDecimal bckt28PointBal) {
		this.bckt28PointBal = bckt28PointBal;
	}

	public String getBckt28PointSign() {
		return this.bckt28PointSign;
	}

	public void setBckt28PointSign(String bckt28PointSign) {
		this.bckt28PointSign = bckt28PointSign;
	}

	public BigDecimal getBckt29PointBal() {
		return this.bckt29PointBal;
	}

	public void setBckt29PointBal(BigDecimal bckt29PointBal) {
		this.bckt29PointBal = bckt29PointBal;
	}

	public String getBckt29PointSign() {
		return this.bckt29PointSign;
	}

	public void setBckt29PointSign(String bckt29PointSign) {
		this.bckt29PointSign = bckt29PointSign;
	}

	public BigDecimal getBckt3PointBal() {
		return this.bckt3PointBal;
	}

	public void setBckt3PointBal(BigDecimal bckt3PointBal) {
		this.bckt3PointBal = bckt3PointBal;
	}

	public String getBckt3PointSign() {
		return this.bckt3PointSign;
	}

	public void setBckt3PointSign(String bckt3PointSign) {
		this.bckt3PointSign = bckt3PointSign;
	}

	public BigDecimal getBckt30PointBal() {
		return this.bckt30PointBal;
	}

	public void setBckt30PointBal(BigDecimal bckt30PointBal) {
		this.bckt30PointBal = bckt30PointBal;
	}

	public String getBckt30PointSign() {
		return this.bckt30PointSign;
	}

	public void setBckt30PointSign(String bckt30PointSign) {
		this.bckt30PointSign = bckt30PointSign;
	}

	public BigDecimal getBckt31PointBal() {
		return this.bckt31PointBal;
	}

	public void setBckt31PointBal(BigDecimal bckt31PointBal) {
		this.bckt31PointBal = bckt31PointBal;
	}

	public String getBckt31PointSign() {
		return this.bckt31PointSign;
	}

	public void setBckt31PointSign(String bckt31PointSign) {
		this.bckt31PointSign = bckt31PointSign;
	}

	public BigDecimal getBckt32PointBal() {
		return this.bckt32PointBal;
	}

	public void setBckt32PointBal(BigDecimal bckt32PointBal) {
		this.bckt32PointBal = bckt32PointBal;
	}

	public String getBckt32PointSign() {
		return this.bckt32PointSign;
	}

	public void setBckt32PointSign(String bckt32PointSign) {
		this.bckt32PointSign = bckt32PointSign;
	}

	public BigDecimal getBckt33PointBal() {
		return this.bckt33PointBal;
	}

	public void setBckt33PointBal(BigDecimal bckt33PointBal) {
		this.bckt33PointBal = bckt33PointBal;
	}

	public String getBckt33PointSign() {
		return this.bckt33PointSign;
	}

	public void setBckt33PointSign(String bckt33PointSign) {
		this.bckt33PointSign = bckt33PointSign;
	}

	public BigDecimal getBckt34PointBal() {
		return this.bckt34PointBal;
	}

	public void setBckt34PointBal(BigDecimal bckt34PointBal) {
		this.bckt34PointBal = bckt34PointBal;
	}

	public String getBckt34PointSign() {
		return this.bckt34PointSign;
	}

	public void setBckt34PointSign(String bckt34PointSign) {
		this.bckt34PointSign = bckt34PointSign;
	}

	public BigDecimal getBckt35PointBal() {
		return this.bckt35PointBal;
	}

	public void setBckt35PointBal(BigDecimal bckt35PointBal) {
		this.bckt35PointBal = bckt35PointBal;
	}

	public String getBckt35PointSign() {
		return this.bckt35PointSign;
	}

	public void setBckt35PointSign(String bckt35PointSign) {
		this.bckt35PointSign = bckt35PointSign;
	}

	public BigDecimal getBckt36PointBal() {
		return this.bckt36PointBal;
	}

	public void setBckt36PointBal(BigDecimal bckt36PointBal) {
		this.bckt36PointBal = bckt36PointBal;
	}

	public String getBckt36PointSign() {
		return this.bckt36PointSign;
	}

	public void setBckt36PointSign(String bckt36PointSign) {
		this.bckt36PointSign = bckt36PointSign;
	}

	public BigDecimal getBckt4PointBal() {
		return this.bckt4PointBal;
	}

	public void setBckt4PointBal(BigDecimal bckt4PointBal) {
		this.bckt4PointBal = bckt4PointBal;
	}

	public String getBckt4PointSign() {
		return this.bckt4PointSign;
	}

	public void setBckt4PointSign(String bckt4PointSign) {
		this.bckt4PointSign = bckt4PointSign;
	}

	public BigDecimal getBckt5PointBal() {
		return this.bckt5PointBal;
	}

	public void setBckt5PointBal(BigDecimal bckt5PointBal) {
		this.bckt5PointBal = bckt5PointBal;
	}

	public String getBckt5PointSign() {
		return this.bckt5PointSign;
	}

	public void setBckt5PointSign(String bckt5PointSign) {
		this.bckt5PointSign = bckt5PointSign;
	}

	public BigDecimal getBckt6PointBal() {
		return this.bckt6PointBal;
	}

	public void setBckt6PointBal(BigDecimal bckt6PointBal) {
		this.bckt6PointBal = bckt6PointBal;
	}

	public String getBckt6PointSign() {
		return this.bckt6PointSign;
	}

	public void setBckt6PointSign(String bckt6PointSign) {
		this.bckt6PointSign = bckt6PointSign;
	}

	public BigDecimal getBckt7PointBal() {
		return this.bckt7PointBal;
	}

	public void setBckt7PointBal(BigDecimal bckt7PointBal) {
		this.bckt7PointBal = bckt7PointBal;
	}

	public String getBckt7PointSign() {
		return this.bckt7PointSign;
	}

	public void setBckt7PointSign(String bckt7PointSign) {
		this.bckt7PointSign = bckt7PointSign;
	}

	public BigDecimal getBckt8PointBal() {
		return this.bckt8PointBal;
	}

	public void setBckt8PointBal(BigDecimal bckt8PointBal) {
		this.bckt8PointBal = bckt8PointBal;
	}

	public String getBckt8PointSign() {
		return this.bckt8PointSign;
	}

	public void setBckt8PointSign(String bckt8PointSign) {
		this.bckt8PointSign = bckt8PointSign;
	}

	public BigDecimal getBckt9PointBal() {
		return this.bckt9PointBal;
	}

	public void setBckt9PointBal(BigDecimal bckt9PointBal) {
		this.bckt9PointBal = bckt9PointBal;
	}

	public String getBckt9PointSign() {
		return this.bckt9PointSign;
	}

	public void setBckt9PointSign(String bckt9PointSign) {
		this.bckt9PointSign = bckt9PointSign;
	}

	public String getBtsActive() {
		return this.btsActive;
	}

	public void setBtsActive(String btsActive) {
		this.btsActive = btsActive;
	}

	public Timestamp getBtsCreatedDatetime() {
		return this.btsCreatedDatetime;
	}

	public void setBtsCreatedDatetime(Timestamp btsCreatedDatetime) {
		this.btsCreatedDatetime = btsCreatedDatetime;
	}

	public Long getBtsId() {
		return this.btsId;
	}

	public void setBtsId(Long btsId) {
		this.btsId = btsId;
	}

	public Timestamp getBtsUpdatedDatetime() {
		return this.btsUpdatedDatetime;
	}

	public void setBtsUpdatedDatetime(Timestamp btsUpdatedDatetime) {
		this.btsUpdatedDatetime = btsUpdatedDatetime;
	}

	public String getCardNo() {
		return this.cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCardType() {
		return this.cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCustAddr1() {
		return this.custAddr1;
	}

	public void setCustAddr1(String custAddr1) {
		this.custAddr1 = custAddr1;
	}

	public String getCustAddr2() {
		return this.custAddr2;
	}

	public void setCustAddr2(String custAddr2) {
		this.custAddr2 = custAddr2;
	}

	public String getCustAddr3() {
		return this.custAddr3;
	}

	public void setCustAddr3(String custAddr3) {
		this.custAddr3 = custAddr3;
	}

	public String getCustAddr4() {
		return this.custAddr4;
	}

	public void setCustAddr4(String custAddr4) {
		this.custAddr4 = custAddr4;
	}

	public String getCustExpDate() {
		return this.custExpDate;
	}

	public void setCustExpDate(String custExpDate) {
		this.custExpDate = custExpDate;
	}

	public String getCustHomeNo() {
		return this.custHomeNo;
	}

	public void setCustHomeNo(String custHomeNo) {
		this.custHomeNo = custHomeNo;
	}

	public String getCustIc() {
		return this.custIc;
	}

	public void setCustIc(String custIc) {
		this.custIc = custIc;
	}

	public String getCustMobileNo() {
		return this.custMobileNo;
	}

	public void setCustMobileNo(String custMobileNo) {
		this.custMobileNo = custMobileNo;
	}

	public String getCustName1() {
		return this.custName1;
	}

	public void setCustName1(String custName1) {
		this.custName1 = custName1;
	}

	public String getCustName2() {
		return this.custName2;
	}

	public void setCustName2(String custName2) {
		this.custName2 = custName2;
	}

	public String getCustNo() {
		return this.custNo;
	}

	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}

	public String getCustOffNo() {
		return this.custOffNo;
	}

	public void setCustOffNo(String custOffNo) {
		this.custOffNo = custOffNo;
	}

	public String getCustPostFlag() {
		return this.custPostFlag;
	}

	public void setCustPostFlag(String custPostFlag) {
		this.custPostFlag = custPostFlag;
	}

	public String getLoyaltyId() {
		return this.loyaltyId;
	}

	public void setLoyaltyId(String loyaltyId) {
		this.loyaltyId = loyaltyId;
	}

	public String getOrgNo() {
		return this.orgNo;
	}

	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}

	public BigDecimal getPoint() {
		return this.point;
	}

	public void setPoint(BigDecimal point) {
		this.point = point;
	}

	public String getPointSign() {
		return this.pointSign;
	}

	public void setPointSign(String pointSign) {
		this.pointSign = pointSign;
	}

	public Long getProgramId() {
		return this.programId;
	}

	public void setProgramId(Long programId) {
		this.programId = programId;
	}

	public BigDecimal getTotExpLastBal() {
		return this.totExpLastBal;
	}

	public void setTotExpLastBal(BigDecimal totExpLastBal) {
		this.totExpLastBal = totExpLastBal;
	}

	public String getTotExpLastSign() {
		return this.totExpLastSign;
	}

	public void setTotExpLastSign(String totExpLastSign) {
		this.totExpLastSign = totExpLastSign;
	}

	public BigDecimal getTotalPointsBal() {
		return this.totalPointsBal;
	}

	public void setTotalPointsBal(BigDecimal totalPointsBal) {
		this.totalPointsBal = totalPointsBal;
	}

	public String getTotalPointsSign() {
		return this.totalPointsSign;
	}

	public void setTotalPointsSign(String totalPointsSign) {
		this.totalPointsSign = totalPointsSign;
	}

	public int getTransformedTotalPointsBal() {
		return this.transformedTotalPointsBal;
	}

	public void setTransformedTotalPointsBal(int transformedTotalPointsBal) {
		this.transformedTotalPointsBal = transformedTotalPointsBal;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
