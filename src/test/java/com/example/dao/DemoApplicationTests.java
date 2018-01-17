package com.example.dao;

import com.example.model.ForecastRoot;
import com.example.model.WeatherRoot;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	
	
	@Test
	public void weatherRoot() {
	    RestTemplate restTemplate = new RestTemplate();
	}

	@Test
	public void contextLoads() {
	    RestTemplate restTemplate = new RestTemplate();
	    ForecastRoot result = restTemplate.getForObject(ForecastWeatherDaoImpl.forecast_uri, ForecastRoot.class);
	}

}
