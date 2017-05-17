package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CurrentWeatherDao;
import com.example.dao.ForecastWeatherDao;
import com.example.model.DisplayedDay;

@Service
public class WeatherService {

	@Autowired
	ForecastWeatherDao forecast;
	
	@Autowired
	CurrentWeatherDao current;
	
	public DisplayedDay getCurrentDay(){
		return current.getCurrentDay();
	}

	public List<DisplayedDay> getDayPlus() {
		return forecast.getDayPlus();
	}

}
