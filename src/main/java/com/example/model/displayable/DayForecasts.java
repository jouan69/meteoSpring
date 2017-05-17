package com.example.model.displayable;

import java.util.List;

public class DayForecasts {
	
	String day;
	List<ForecastForHour> forecasts;
	
	public DayForecasts(String day, List<ForecastForHour> forecasts) {
		super();
		this.day = day;
		this.forecasts = forecasts;
	}

	public DayForecasts() {
		super();
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public List<ForecastForHour> getForecasts() {
		return forecasts;
	}

	public void setForecasts(List<ForecastForHour> forecasts) {
		this.forecasts = forecasts;
	}
}
