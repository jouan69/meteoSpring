package com.example.model;

import com.example.model.displayable.ForecastedKoboDay;

import java.util.List;

public class KoboWeather {

    private final Integer current;
    private final String icon;
    private final String wind;
    private List<ForecastedKoboDay> forecastedKoboDays;

    KoboWeather(Integer current, String icon, String wind, List<ForecastedKoboDay> forecastedKoboDays) {
        this.current = current;
        this.icon = icon;
        this.wind= wind;
        this.forecastedKoboDays = forecastedKoboDays;
    }

    public Integer getCurrent() {
        return current;
    }

    public String getIcon() {
        return icon;
    }

    public List<ForecastedKoboDay> getForecastedKoboDays() {
        return forecastedKoboDays;
    }

    public String getWind() {
        return wind;
    }

    public static class KoboWeatherBuilder {
        private Integer current;
        private String icon;
        private List<ForecastedKoboDay> forecastedKoboDays;
        private String wind;

        public KoboWeatherBuilder withCurrentTemp(Integer current) {
            this.current = current;
            return this;
        }

        public KoboWeatherBuilder withIcon(String icon) {
            this.icon = icon;
            return this;
        }

        public KoboWeatherBuilder withWind(String wind) {
            this.wind = wind;
            return this;
        }

        public KoboWeatherBuilder withForecastedKoboDays(final List<ForecastedKoboDay> forecastedKoboDays){
            this.forecastedKoboDays = forecastedKoboDays;
            return this;
        }

        public KoboWeather build() {
            return new KoboWeather(current, icon, wind, forecastedKoboDays);
        }
    }
}
