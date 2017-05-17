package com.example.dao;

import java.util.List;

import com.example.model.displayable.DayForecasts;

public interface ForecastWeatherDao {
	List<DayForecasts> getForecastDays();
}
