package com.kanokun.test.services;

import java.util.TimeZone;

import org.junit.Assert;
import org.junit.Test;

//Run carefully we have a limit set by google :( 2500 requests
public class GoogleTimeZoneServiceTest {


	GoogleTimeZoneService service = new GoogleTimeZoneService();

	@Test
	public void testGoogleService() throws Exception {
		TimeZone tx = service.getTimeZone(-44.490947,171.220966);
		Assert.assertEquals("Pacific/Auckland", tx.getID());

	}

}
