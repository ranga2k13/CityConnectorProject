package com.city.connections;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * RestEndpoint Unit Test
 * 
 * @author Ranga
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CityConnectionsApplication.class)
public final class CityControllerTests {
		
	private MockMvc mockMvc;		
	
	@Autowired
	WebApplicationContext webApplicationContext;	
			
	/**
	 * Instantiate MockMvc
	 */
	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	/**
	 * Test 1
	 * ======
	 * 
	 * Test city connection from Boston -> Newark
	 * 
	 * @throws Exception
	 * 
	 */
	@Test
	@DisplayName("Test city connection from Boston -> Newark")
	public void cityService_Boston_to_Newark() throws Exception{	
		String uri = "/connected";
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(uri)
				.contentType(MediaType.TEXT_PLAIN)				
				.param("origin", "Boston")
				.param("destination","Newark")			
				)
				.andExpect(MockMvcResultMatchers.status().isOk())				
				.andReturn();
		String actual = mvcResult.getResponse().getContentAsString();
		assertEquals("yes", actual);
	}	
	
	/**
	 * Test 2
	 * ======
	 * 
	 * Test city connection from Boston -> Philadelphia
	 * 
	 * @throws Exception
	 * 
	 */
	@Test
	@DisplayName("Test city connection from Boston -> Philadelphia")
	public void cityService_Boston_to_Philadelphia() throws Exception{	
		String uri = "/connected";
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(uri)
				.contentType(MediaType.TEXT_PLAIN)				
				.param("origin", "Boston")
				.param("destination","Philadelphia")			
				)
				.andExpect(MockMvcResultMatchers.status().isOk())				
				.andReturn();
		String actual = mvcResult.getResponse().getContentAsString();
		assertEquals("yes", actual);
	}
	
	/**
	 * Test 3
	 * ======
	 * 
	 * Test city connection road doesn't exist from Philadelphia -> Albany 
	 * 
	 * @throws Exception
	 */
	@Test
	@DisplayName("Test city connection road doesn't exist from Philadelphia -> Albany")
	public void cityService_Philadelphia_to_Albany() throws Exception{	
		String uri = "/connected";
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(uri)
				.contentType(MediaType.TEXT_PLAIN)				
				.param("origin", "Philadelphia")
				.param("destination","Albany")			
				)
				.andExpect(MockMvcResultMatchers.status().isOk())				
				.andReturn();
		String actual = mvcResult.getResponse().getContentAsString();
		assertEquals("no", actual);
	}	
	
	/**
	 * Test 4
	 * ======
	 * 
	 * Test city connection lower case from new york -> philadelphia
	 * 
	 * @throws Exception
	 * 
	 */
	@Test
	@DisplayName("Test city connection road doesn't exist from new york -> philadelphia")
	public void cityService_NewYork_to_Philadelphia_lowercase() throws Exception{	
		String uri = "/connected";
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(uri)
				.contentType(MediaType.TEXT_PLAIN)				
				.param("origin", "new york")
				.param("destination","philadelphia")			
				)
				.andExpect(MockMvcResultMatchers.status().isOk())				
				.andReturn();
		String actual = mvcResult.getResponse().getContentAsString();
		assertEquals("yes", actual);
	}
	
	/**
	 * Test 5
	 * ======
	 * 
	 * Test city connection upper case from NEW YORK -> PHILADELPHIA
	 * 
	 * @throws Exception it throws 
	 * 
	 */
	@Test
	@DisplayName("Test city connection upper case from NEW YORK -> PHILADELPHIA")
	public void cityService_NewYork_to_Philadelphia_uppercase() throws Exception{	
		String uri = "/connected";
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(uri)
				.contentType(MediaType.TEXT_PLAIN)				
				.param("origin", "NEW YORK")
				.param("destination","PHILADELPHIA")			
				)
				.andExpect(MockMvcResultMatchers.status().isOk())				
				.andReturn();
		String actual = mvcResult.getResponse().getContentAsString();
		assertEquals("yes", actual);
	}
	
	/**
	 * Test 6
	 * ======
	 * 
	 * Test city connection origin does't exist in the file Los Angeles -> New York
	 * 
	 * @throws Exception
	 * 
	 */
	@Test
	@DisplayName("Test city connection origin does't exist in the file Los Angeles -> New York")
	public void cityService_origin_notexist() throws Exception{	
		String uri = "/connected";
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(uri)
				.contentType(MediaType.TEXT_PLAIN)				
				.param("origin", "Los Angeles")
				.param("destination","New York")			
				)
				.andExpect(MockMvcResultMatchers.status().isOk())				
				.andReturn();
		String actual = mvcResult.getResponse().getContentAsString();
		assertEquals("no", actual);
	}
		
	/**
	 * Test 7
	 * ======
	 * 
	 * Test city connection destination does't exist in the file New York -> San Francisco
	 * 
	 * @throws Exception
	 * 
	 */
	@Test
	@DisplayName("Test city connection destination does't exist in the file New York -> San Francisco")
	public void cityService_destination_notexist() throws Exception{	
		String uri = "/connected";
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(uri)
				.contentType(MediaType.TEXT_PLAIN)				
				.param("origin", "New York")
				.param("destination","San Francisco")			
				)
				.andExpect(MockMvcResultMatchers.status().isOk())				
				.andReturn();
		String actual = mvcResult.getResponse().getContentAsString();
		assertEquals("no", actual);
	}
	
	
	/**
	 * Test 8
	 * ======
	 * 
	 * Test city connection without origin parameter
	 * 
	 * @throws Exception
	 * 
	 */
	@Test
	@DisplayName("Test city connection without origin parameter")
	public void cityService_without_origin() throws Exception{	
		String uri = "/connected";
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(uri)
				.contentType(MediaType.TEXT_PLAIN)								
				.param("destination","Boston")			
				)
				.andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andReturn();		
		String actual = mvcResult.getResponse().getContentAsString();
		assertEquals("Required String parameter 'origin' is not present", actual);
	}
	
	/**
	 * Test 9
	 * ======
	 * 
	 * Test city connection without destination parameter
	 * 
	 * @throws Exception
	 * 
	 */
	@Test
	@DisplayName("Test city connection without destination parameter")
	public void cityService_without_destination() throws Exception{	
		String uri = "/connected";
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(uri)
				.contentType(MediaType.TEXT_PLAIN)								
				.param("origin","Newark")			
				)
				.andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andReturn();		
		String actual = mvcResult.getResponse().getContentAsString();
		assertEquals("Required String parameter 'destination' is not present", actual);
	}
	
	

}
