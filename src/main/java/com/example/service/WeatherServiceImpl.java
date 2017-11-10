package com.example.service;

import com.example.dao.ForecastWeatherDao;
import com.example.model.displayable.DayForecasts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WeatherServiceImpl implements WeatherService{

	@Autowired
	ForecastWeatherDao forecastWeatherDao;

	@Override
	public List<DayForecasts> getDayPlus() {
		return forecastWeatherDao.getForecastDays();
	}

}
