package com.example.model.displayable;

public class DayForecasts {
	
	String day;
	ForecastForHour[] forecasts = new ForecastForHour[8];
	
	public DayForecasts(String day, ForecastForHour[] forecasts) {
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

	public ForecastForHour[] getForecasts() {
		return forecasts;
	}

	public void setForecasts(ForecastForHour[] forecasts) {
		this.forecasts = forecasts;
	}
}
