/**
 * 
 */
package com.maybank.orsapp.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 * @author 80003905
 *
 */
public class TimeStampConversion {
	
	public String dateFormat(Timestamp datetime) {
		LocalDateTime date = datetime.toLocalDateTime();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss", Locale.ENGLISH);
		return formatter.format(date);
	}
	
	public String dateTimeFormat(Date datetime) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.ENGLISH);
		return dateFormat.format(datetime);
	}
	
	public Date dateTime(String datetime) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy HH:mm:ss", Locale.ENGLISH);
		try {
			return dateFormat.parse(datetime);
		} catch (ParseException e) {			
			e.printStackTrace();
		}
		return null;
	}
	
	public Date formatDate(String datetime) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
		try {
			return dateFormat.parse(datetime);
		} catch (ParseException e) {			
			e.printStackTrace();
		}
		return null;
	}
	
	public String formatStartDate(String datetime) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date date = formatDate(datetime);
		return dateFormat.format(date);
	}

}
