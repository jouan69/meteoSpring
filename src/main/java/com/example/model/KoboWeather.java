package com.example.model;

/**
 * Created by erwanjouan on 18/01/2018.
 */
public class KoboWeather {

    private final String now;
    private final Integer current;
    private final String tomorrow;
    private final Integer minTomorrow;
    private final Integer maxTomorrow;
    private final String icon;
    private final String description;
    private final String iconTomMorning;
    private final String iconTomEvening;

    public KoboWeather(String now, Integer current, String tomorrow, Integer minTomorrow, Integer maxTomorrow, String icon, String description, String iconTomMorning, String iconTomEvening) {
        this.now = now;
        this.current = current;
        this.tomorrow = tomorrow;
        this.minTomorrow = minTomorrow;
        this.maxTomorrow = maxTomorrow;
        this.icon = icon;
        this.description = description;
        this.iconTomMorning = iconTomMorning;
        this.iconTomEvening = iconTomEvening;
    }

    public String getNow() {
        return now;
    }

    public Integer getCurrent() {
        return current;
    }

    public Integer getMinTomorrow() {
        return minTomorrow;
    }

    public Integer getMaxTomorrow() {
        return maxTomorrow;
    }

    public String getIcon() {
        return icon;
    }

    public String getDescription() {
        return description;
    }

    public String getIconTomMorning() {
        return iconTomMorning;
    }

    public String getIconTomEvening() {
        return iconTomEvening;
    }

    public String getTomorrow() {
        return tomorrow;
    }
}
