package com.kanokun.test.utils;

import static org.junit.Assert.assertTrue;

import java.util.TimeZone;

import org.junit.Assert;
import org.junit.Test;

import com.kanokun.test.utils.DateUtils;

public class DateUtilTest {

	@Test
	public void testParseDate() {
		Assert.assertNotNull(DateUtils.parseDate("2013-07-10 02:52:49"));
		Assert.assertNull(DateUtils.parseDate("2013-07-10"));
		Assert.assertNull(null);
	}


	@Test
	public void testTimeZoneDate() {
		TimeZone tz = TimeZone.getTimeZone("Pacific/Auckland");
		String date = DateUtils.getTimeZoneTime(tz , "2013-07-10 02:52:49");
		Assert.assertEquals("2013-07-10T14:52:49", date);
	}

}
