package com.kanokun.test;

import java.io.File;
import java.util.List;
import java.util.TimeZone;

import com.kanokun.test.domain.VehicleInformation;
import com.kanokun.test.services.GoogleTimeZoneService;
import com.kanokun.test.services.ReaderService;
import com.kanokun.test.utils.DateUtils;
import com.kanokun.test.utils.FileWriterUtil;

/**
 * @author Kunal
 *
 */
public class TestMain {

	/**
	 * Expects file as first argument or assumes its in c drive named as sample
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		String filename = args.length > 1  ? args[0] : "C:\\sample.csv" ;

		String outFileName  = args.length > 2 ?  args[1] :  "D:\\outfileName.csv" ;

		File file = new File(outFileName);

		//creating out file will append if already exists
		if (!file.exists()) {
			file.createNewFile();
		}

		//Read file into list
		ReaderService service = new ReaderService();
		List<VehicleInformation> listOfVehicles = service.parseFile(filename);
		//System.out.println(listOfVehicles);

		//for each obj call api and get result
		for (VehicleInformation vehicleInfo : listOfVehicles) {
			GoogleTimeZoneService tzService = new GoogleTimeZoneService();
			TimeZone tz = tzService.getTimeZone(vehicleInfo.getLatitude(),vehicleInfo.getLongitude());
			System.out.format("%s,%s,%s,%s,%s", vehicleInfo.getUtcDateTimeString(),vehicleInfo.getLatitude(),vehicleInfo.getLongitude(),
					tz.getID(),DateUtils.getTimeZoneTime(tz, vehicleInfo.getUtcDateTimeString()));

			FileWriterUtil.writetoFIle(String.format("%s,%s,%s,%s,%s", vehicleInfo.getUtcDateTimeString(),vehicleInfo.getLatitude(),vehicleInfo.getLongitude(),
					tz.getID(),DateUtils.getTimeZoneTime(tz, vehicleInfo.getUtcDateTimeString())), file);

		}

		System.exit(0);
	}


}
