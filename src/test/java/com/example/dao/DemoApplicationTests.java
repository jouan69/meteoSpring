package com.example.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.example.dao.CurrentWeatherDaoImpl;
import com.example.model.ForecastRoot;
import com.example.model.WeatherRoot;
import com.example.service.WeatherService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	
	
	@Test
	public void weatherRoot() {
	    RestTemplate restTemplate = new RestTemplate();
	    WeatherRoot result = restTemplate.getForObject(CurrentWeatherDaoImpl.current_uri, WeatherRoot.class);
	}

	@Test
	public void contextLoads() {
	    RestTemplate restTemplate = new RestTemplate();
	    ForecastRoot result = restTemplate.getForObject(ForecastWeatherDaoImpl.forecast_uri, ForecastRoot.class);
	    //WeatherService.processForecast(result);
	}

}