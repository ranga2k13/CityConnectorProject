package com.city.connections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import com.city.connections.service.CityService;

@WebMvcTest
public class CityControllerTests {
	
	@Autowired
    private CityService cityService;

}
