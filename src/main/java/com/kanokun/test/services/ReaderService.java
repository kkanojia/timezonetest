package com.kanokun.test.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.kanokun.test.domain.VehicleInformation;

public class ReaderService {

	public List<VehicleInformation> parseFile(String filePath) {
		List<VehicleInformation> listOfVehicles = new ArrayList();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				List<String> items = Arrays.asList(line.split(","));
				VehicleInformation vehicleInfo = new VehicleInformation();
				vehicleInfo.setUtcDateTimeString(items.get(0));
				vehicleInfo.setLatitude(Double.parseDouble(items.get(1)));
				vehicleInfo.setLongitude(Double.parseDouble(items.get(2)));
				listOfVehicles.add(vehicleInfo);
			}
		} catch (IOException e) {
			//Ignoring errors might have to exit if required.
			e.printStackTrace();
		}
		return listOfVehicles;
	}

}
