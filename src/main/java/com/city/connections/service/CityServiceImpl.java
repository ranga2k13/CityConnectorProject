package com.city.connections.service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.city.connections.model.Connections;

/**
 * Service class used to determine whether or not cities are connected.
 * 
 * @author Ranga
 *
 */
@Service
public class CityServiceImpl implements CityService {
	
	@Autowired
	Connections connections;

	/**
	 * Returns 'yes' if city origin and destination are connected. 
	 * Returns 'no' if not connected.
	 * 
	 * @param origin
	 * @param destination
	 * @return Either yes or no
	 * 
	 */
	@Override
	public String connectedCities(String origin, String destination) {
		// set of cities that were visited
		Set<String> visited = new HashSet<>();
		// map of cities and its connections
		Map<String, Set<String>> cities = connections.getCities();		
		
		if(!cities.containsKey(origin.toLowerCase()) || !cities.containsKey(destination.toLowerCase()) ) {
			return CITY_IS_NOT_CONNECTED;
		}
		
		// Queue used to contain cities to visit
		Queue<String> queue = new LinkedList<>();
		queue.add(origin.toLowerCase());
		
		while(!queue.isEmpty()) {
			String city = queue.poll();
						
			if(visited.contains(city))
				continue;
			
			visited.add(city);
			
			// Adjacent city connections
			Set<String> adjCities = cities.get(city);
					
			for(String adjCity : adjCities) {
				if(adjCity.equalsIgnoreCase(destination))
					return CITY_IS_CONNECTED;
				
				// push adjacent city into queue
				if(!visited.contains(adjCity))
					queue.add(adjCity);
			}
		}
		
		return CITY_IS_NOT_CONNECTED;
	}

}
