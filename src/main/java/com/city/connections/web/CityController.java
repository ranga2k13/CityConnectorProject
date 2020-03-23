package com.city.connections.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.city.connections.service.CityService;

/**
 * REST controller class for city connections
 * 
 * @author Ranga
 *
 */
@RestController
@RequestMapping("/connected")
public class CityController {
	
	@Autowired
	CityService service;
	
	/**
	 * GET request to check if city origin and destination are connected.
	 * 
	 * @param origin
	 * @param destination
	 * @return String (values either yes or no)
	 */
	@GetMapping	
	public String getCheckConnectedCities(
			@RequestParam(value="origin", required=true) String origin, 
			@RequestParam(value="destination", required=true) String destination
			) {
		
		return service.connectedCities(origin, destination);
		
	}
	
}
