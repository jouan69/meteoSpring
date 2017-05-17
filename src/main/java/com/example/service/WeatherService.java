package com.example.service;

import java.util.List;

import com.example.model.displayable.CurrentDay;
import com.example.model.displayable.DayForecasts;

public interface WeatherService {

	CurrentDay getCurrentDay();

	List<DayForecasts> getDayPlus();

}
