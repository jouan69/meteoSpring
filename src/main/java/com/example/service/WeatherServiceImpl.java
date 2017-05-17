package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dao.CurrentWeatherDao;
import com.example.dao.ForecastWeatherDao;
import com.example.model.displayable.CurrentDay;
import com.example.model.displayable.DayForecasts;

@Component
public class WeatherServiceImpl implements WeatherService{

	@Autowired
	CurrentWeatherDao currentWeatherDao;
	@Autowired
	ForecastWeatherDao forecastWeatherDao;
	
	@Override
	public CurrentDay getCurrentDay() {
		return currentWeatherDao.getCurrentDay();
	}

	@Override
	public List<DayForecasts> getDayPlus() {
		return forecastWeatherDao.getForecastDays();
	}

}
