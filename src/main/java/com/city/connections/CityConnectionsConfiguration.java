package com.city.connections;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.city.connections.common.Constants;
import com.city.connections.model.Connections;


/**
 * City Connections configuration class used to load 
 * and make available city connections via Spring bean.
 * 
 * @author Ranga
 *
 */
@Configuration
public class CityConnectionsConfiguration {
	
	@Autowired
	private ResourceLoader resourceLoader;

	public final Logger LOGGER = LoggerFactory.getLogger(CityConnectionsConfiguration.class);

	private Scanner scan;
		
	
	/**
	 * Bean representation of CityGraph. It reads file city.txt in 
	 * src/main/resource/data classpath and loads all city connections 
	 * into a CityGraph object. The CityGraph object can be 
	 * used by any class wiring this object.
	 * 
	 * @return Connections the CityGraph
	 */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public Connections getCityConnections() {		
		Map<String, Set<String>> cities = new HashMap<>();
		String[] cityLineArray = new String[2];
		InputStream inputStream = null;		
		Resource resource = resourceLoader.getResource(Constants.FILE_NAME);
		Connections cityGraph = new Connections();
		
		try {
			inputStream = resource.getInputStream();	
			scan = new Scanner(inputStream);
		}catch(IOException e) {
			LOGGER.error("Exception in CityConnectionsConfiguration class");			
		}
        
        // Read file and store city connection into map
		while (scan.hasNext()) {
			cityLineArray = scan.nextLine().toLowerCase().split(",");
			String city1 = cityLineArray[0].trim();
			String city2 = cityLineArray[1].trim();
			
			// Set the city and its connecting city in CityGraph
			if(cities.containsKey(city1)) {
				cities.get(city1).add(city2);
			} else {
				Set<String> adjCity = new HashSet<>();
				adjCity.add(city2);
				cities.put(city1, adjCity);
			}
			
			if(cities.containsKey(city2)) {
				cities.get(city2).add(city1);
			} else {
				Set<String> adjCity = new HashSet<>();
				adjCity.add(city1);
				cities.put(city2, adjCity);
			}
		}
		cityGraph.setCities(cities);		
		scan.close();
		return cityGraph;
	}

}
