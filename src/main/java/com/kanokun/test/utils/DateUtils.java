package com.kanokun.test.utils;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.joda.time.DateTimeZone;

public class DateUtils {


	// Sample 2013-07-10 02:52:49
	public static Date parseDate(String str) {
		if (str == null || "".equalsIgnoreCase(str)) {
			return null;
		}
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			return dateFormat.parse(str);
		} catch (ParseException e) {
			System.out.println(e);
		}
		return null;
	}

	public static String getTimeZoneTime(TimeZone tz, String timeToConvert) {
		Date utcDate = parseDate(timeToConvert);
		DateTimeZone localTimeZone = DateTimeZone.forTimeZone(tz);
		Date localDate = new Date(localTimeZone.convertUTCToLocal(utcDate.getTime()));
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		return formatter.format(localDate);
	}

}
