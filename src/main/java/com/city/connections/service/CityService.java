package com.city.connections.service;

/**
 * CityService is used to determine if cities are connected.
 * 
 * @author Ranga
 *
 */
public interface CityService {
	
	String CITY_IS_CONNECTED = "yes";
	String CITY_IS_NOT_CONNECTED = "no";
	
	/**
	 * Returns 'yes' if cities are connected 
	 * or 'no' if cities are not connected
	 * 
	 * @param origin the city origin
	 * @param destination the city destination
	 * @return java.lang.String if the city is connected 'yes' else 'no'
	 */
	String connectedCities(String origin, String destination);
}
