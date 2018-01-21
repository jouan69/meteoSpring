package com.example.model.displayable;

/**
 * Created by Erwan on 21/01/2018.
 */
public class ForecastedKoboDay {
    String date;
    String iconMorning;
    Integer tempMorning;
    String iconEvening;
    Integer tempEvening;

    public ForecastedKoboDay(String date, String iconMorning, Integer tempMorning, String iconEvening, Integer tempEvening) {
        this.date = date;
        this.iconMorning = iconMorning;
        this.tempMorning = tempMorning;
        this.iconEvening = iconEvening;
        this.tempEvening = tempEvening;
    }

    public String getDate() {
        return date;
    }

    public String getIconMorning() {
        return iconMorning;
    }

    public Integer getTempMorning() {
        return tempMorning;
    }

    public String getIconEvening() {
        return iconEvening;
    }

    public Integer getTempEvening() {
        return tempEvening;
    }
}
