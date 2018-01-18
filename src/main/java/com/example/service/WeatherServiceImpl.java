package com.example.service;

import com.example.dao.ForecastWeatherDao;
import com.example.model.WeatherTable;
import com.example.model.displayable.DayForecasts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class WeatherServiceImpl implements WeatherService{

	@Autowired
	ForecastWeatherDao forecastWeatherDao;

	@Override
	public WeatherTable getFullForecast() {

		List<DayForecasts> dayForecasts  = forecastWeatherDao.getForecastDays();
		DayForecasts tomorrow = dayForecasts.get(1);
		List<Integer> hours = Arrays.stream(tomorrow.getForecasts())
									.map(f -> f.getHour())
									.collect(Collectors.toList());
		return new WeatherTable(hours, dayForecasts);
	}

}
