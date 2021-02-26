package com.maybank.orsapp.util;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {

	public static String getDate(String dateFormat, Date date, int day) {
		String result = "";
		DateFormat df = new SimpleDateFormat(dateFormat);
		try {

			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DATE, day);
			result = df.format(cal.getTime());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return result;
	}
}
