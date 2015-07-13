package com.kanokun.test.services;

import java.util.TimeZone;

import com.google.maps.GeoApiContext;
import com.google.maps.PendingResult;
import com.google.maps.TimeZoneApi;
import com.google.maps.model.LatLng;
import com.kanokun.test.utils.Constants;


/**
 *
 * Seems to be creating some deamon threads.
 * Might have just made a simple http call and read json. :(
 * @author Kunal
 *
 */
public class GoogleTimeZoneService {


	/**
	 * Calls google service and gets the timezone. Currently using my personal google API key
	 * //callign it synchronously here. Can be optmized with async
	 * @param lat
	 * @param longitude
	 * @return
	 * @throws Exception
	 */
	public TimeZone getTimeZone(double lat, double longitude) throws Exception {
		GeoApiContext context = new GeoApiContext();
		context.setApiKey(Constants.API_KEY);
		LatLng location = new LatLng(lat,longitude);
		PendingResult<TimeZone> result = TimeZoneApi.getTimeZone(context, location);
		TimeZone t = result.awaitIgnoreError();
		result.cancel();
		return t;
	}

}
