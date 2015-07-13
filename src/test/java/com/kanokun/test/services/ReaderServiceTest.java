package com.kanokun.test.services;

import java.io.InputStream;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.kanokun.test.domain.VehicleInformation;



/**
 * Expects a file to be in C directory. Could have done this better
 * @author Kunal
 *
 */
public class ReaderServiceTest {

	ReaderService service = new ReaderService();

	@Test
	public void testFileRead() {
		List<VehicleInformation> list = service.parseFile("C:\\sample.csv");
		Assert.assertNotNull("List should not be null", list);
		Assert.assertEquals("Size should be 2", 2, list.size());

	}

}
