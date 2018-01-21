package com.example.mapper;

import com.example.model.KoboWeather;
import com.example.model.displayable.DayForecasts;

import java.util.List;

public interface KoboWeatherMapper {

    KoboWeather toKoboWeather(List<DayForecasts> forecastDays);

}
