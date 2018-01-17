package com.example.model;

import com.example.model.displayable.DayForecasts;

import java.util.List;

public class WeatherTable {

    private List<Integer> hours;

    private List<DayForecasts> forecasts;

    public WeatherTable(final List<Integer> hours, final List<DayForecasts> forecasts) {
        this.hours = hours;
        this.forecasts = forecasts;
    }

    public List<Integer> getHours() {
        return hours;
    }

    public List<DayForecasts> getForecasts() {
        return forecasts;
    }
}
