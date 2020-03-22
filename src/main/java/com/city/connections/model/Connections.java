package com.city.connections.model;

import java.util.Map;
import java.util.Set;

/**
 * Connections class contains map of city connections. 
 * 
 * @author Ranga
 *
 */
public class Connections {
	
	private Map<String, Set<String>> cities;

	/**
	 * Get City map
	 *
	 * @return java.util.Map contains cities
	 */
	public Map<String, Set<String>> getCities() {
		return cities;
	}

	/**
	 * Set City Map
	 * 
	 * @param java.util.Map contains cities
	 */
	public void setCities(Map<String, Set<String>> cities) {
		this.cities = cities;
	}
	
}
