package com.maybank.orsapp.dao;

import java.math.BigDecimal;

public interface VoidRedemptionDao {
	
	public int updateCardBucket(String TOTAL_POINTS_SIGN,BigDecimal TOTAL_POINTS_BAL,BigDecimal TRANSFORMED_TOTAL_POINTS_BAL
			,String BUCKET01_POINT_SIGN,BigDecimal BUCKET01_POINT_BAL,String BUCKET02_POINT_SIGN,BigDecimal BUCKET02_POINT_BAL,String BUCKET03_POINT_SIGN,BigDecimal BUCKET03_POINT_BAL
			,String BUCKET04_POINT_SIGN,BigDecimal BUCKET04_POINT_BAL,String BUCKET05_POINT_SIGN,BigDecimal BUCKET05_POINT_BAL,String BUCKET06_POINT_SIGN,BigDecimal BUCKET06_POINT_BAL
			,String BUCKET07_POINT_SIGN,BigDecimal BUCKET07_POINT_BAL,String BUCKET08_POINT_SIGN,BigDecimal BUCKET08_POINT_BAL,String BUCKET09_POINT_SIGN,BigDecimal BUCKET09_POINT_BAL
			,String BUCKET10_POINT_SIGN,BigDecimal BUCKET10_POINT_BAL,String BUCKET11_POINT_SIGN,BigDecimal BUCKET11_POINT_BAL,String BUCKET12_POINT_SIGN,BigDecimal BUCKET12_POINT_BAL
			,String BUCKET13_POINT_SIGN,BigDecimal BUCKET13_POINT_BAL,String BUCKET14_POINT_SIGN,BigDecimal BUCKET14_POINT_BAL,String BUCKET15_POINT_SIGN,BigDecimal BUCKET15_POINT_BAL
			,String BUCKET16_POINT_SIGN,BigDecimal BUCKET16_POINT_BAL,String BUCKET17_POINT_SIGN,BigDecimal BUCKET17_POINT_BAL,String BUCKET18_POINT_SIGN,BigDecimal BUCKET18_POINT_BAL
			,String BUCKET19_POINT_SIGN,BigDecimal BUCKET19_POINT_BAL,String BUCKET20_POINT_SIGN,BigDecimal BUCKET20_POINT_BAL,String BUCKET21_POINT_SIGN,BigDecimal BUCKET21_POINT_BAL
			,String BUCKET22_POINT_SIGN,BigDecimal BUCKET22_POINT_BAL,String BUCKET23_POINT_SIGN,BigDecimal BUCKET23_POINT_BAL,String BUCKET24_POINT_SIGN,BigDecimal BUCKET24_POINT_BAL
			,String BUCKET25_POINT_SIGN,BigDecimal BUCKET25_POINT_BAL,String BUCKET26_POINT_SIGN,BigDecimal BUCKET26_POINT_BAL,String BUCKET27_POINT_SIGN,BigDecimal BUCKET27_POINT_BAL
			,String BUCKET28_POINT_SIGN,BigDecimal BUCKET28_POINT_BAL,String BUCKET29_POINT_SIGN,BigDecimal BUCKET29_POINT_BAL,String BUCKET30_POINT_SIGN,BigDecimal BUCKET30_POINT_BAL
			,String BUCKET31_POINT_SIGN,BigDecimal BUCKET31_POINT_BAL,String BUCKET32_POINT_SIGN,BigDecimal BUCKET32_POINT_BAL,String BUCKET33_POINT_SIGN,BigDecimal BUCKET33_POINT_BAL
			,String BUCKET34_POINT_SIGN,BigDecimal BUCKET34_POINT_BAL,String BUCKET35_POINT_SIGN,BigDecimal BUCKET35_POINT_BAL,String BUCKET36_POINT_SIGN,BigDecimal BUCKET36_POINT_BAL
			,String EDITED_BY,BigDecimal CARDHOLDER_POINT_BUCKET_ID);
	
	public int updateApPointTxn(Long pointTxnId, String reversalReason);

}
