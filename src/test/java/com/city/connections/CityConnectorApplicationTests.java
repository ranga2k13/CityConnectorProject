package com.city.connections;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.city.connections.service.CityService;

@RunWith(SpringRunner.class)
@SpringBootTest
public final class CityConnectorApplicationTests {

	@Autowired
    private CityService cityService;
    
	/**
	 * Test 1
	 * ======
	 * 
	 * Test city connection from Boston -> Newark
	 */
	@Test
	@DisplayName("Test city connection from Boston -> Newark")
	public void cityService_Boston_to_Newark() {		
		String connectedTestStr = cityService.connectedCities("Boston", "Newark");
		assertEquals("yes", connectedTestStr);
	}
	
	/**
	 * Test 2
	 * ======
	 * 
	 * Test city connection from Boston -> Philadelphia
	 */
	@Test
	@DisplayName("Test city connection from Boston -> Philadelphia")
	public void cityService_Boston_to_Philadelphia() {
		String connectedTestStr = cityService.connectedCities("Boston", "Philadelphia");
		assertEquals("yes", connectedTestStr);
	}
	
	/**
	 * Test 3
	 * ======
	 * 
	 * Test city connection road doesn't exist from Philadelphia -> Albany
	 */
	@Test
	@DisplayName("Test city connection road doesn't exist from Philadelphia -> Albany")
	public void cityService_Philadelphia_to_Albany() {
		String connectedTestStr = cityService.connectedCities("Philadelphia", "Albany");
		assertEquals("no", connectedTestStr);
	}
	
	/**
	 * Test 4
	 * ======
	 * 
	 * Test city connection lower case from new york -> philadelphia
	 * 
	 */
	@Test
	@DisplayName("Test city connection lower case from new york -> philadelphia")
	public void cityService_NewYork_to_Philadelphia_lowercase() {	
		String connectedTestStr = cityService.connectedCities("new york", "philadelphia");
		assertEquals("yes", connectedTestStr);
	}
	
	/**
	 * Test 5
	 * ======
	 * 
	 * Test city connection upper case from NEW YORK -> PHILADELPHIA
	 */
	@Test
	@DisplayName("Test city connection upper case from NEW YORK -> PHILADELPHIA")
	public void cityService_NewYork_to_Philadelphia_uppercase() {
		
		String connectedTestStr = cityService.connectedCities("NEW YORK", "PHILADELPHIA");
		assertEquals("yes", connectedTestStr);
	}
	
	/**
	 * Test 6
	 * ======
	 * 
	 * Test city connection origin does't exist in the file Los Angeles -> New York
	 */
	@Test
	@DisplayName("Test city connection origin does't exist in the file Los Angeles -> New York")
	public void cityService_origin_notexist() {
		
		String connectedTestStr = cityService.connectedCities("Los Angeles", "New York");
		assertEquals("no", connectedTestStr);
	}
	
	/**
 	 * Test 7
	 * ======
	 * 
	 * Test city connection destination does't exist in the file New York -> San Francisco
	 */
	@Test
	@DisplayName("Test city connection destination does't exist in the file New York -> San Francisco")
	public void cityService_destination_notexist() {

		String connectedTestStr = cityService.connectedCities("New York", "San Francisco");
		assertEquals("no", connectedTestStr);
	}
	
	

}
