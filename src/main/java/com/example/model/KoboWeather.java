package com.example.model;

public class KoboWeather {

    private final String dateNow;
    private final String timeNow;
    private final Integer current;
    private final String tomorrow;
    private final Integer minTomorrow;
    private final Integer maxTomorrow;
    private final String icon;
    private final String description;
    private final String iconTomMorning;
    private final String iconTomEvening;

    KoboWeather(String dateNow, String timeNow, Integer current, String tomorrow, Integer minTomorrow, Integer maxTomorrow, String icon, String description, String iconTomMorning, String iconTomEvening) {
        this.dateNow = dateNow;
        this.timeNow = timeNow;
        this.current = current;
        this.tomorrow = tomorrow;
        this.minTomorrow = minTomorrow;
        this.maxTomorrow = maxTomorrow;
        this.icon = icon;
        this.description = description;
        this.iconTomMorning = iconTomMorning;
        this.iconTomEvening = iconTomEvening;
    }

    public String getDateNow() {
        return dateNow;
    }

    public String getTimeNow() {
        return timeNow;
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

    public static class KoboWeatherBuilder {
        private String now;
        private String timeNow;
        private Integer current;
        private String tomorrow;
        private Integer minTomorrow;
        private Integer maxTomorrow;
        private String icon;
        private String description;
        private String iconTomMorning;
        private String iconTomEvening;

        public KoboWeatherBuilder withDate(String now){
            this.now = now;
            return this;
        }

        public KoboWeatherBuilder withTime(String timeNow){
            this.timeNow = timeNow;
            return this;
        }

        public KoboWeatherBuilder withCurrentTemp(Integer current){
            this.current = current;
            return this;
        }

        public KoboWeatherBuilder withDateTomorrow(String tomorrow){
            this.tomorrow = tomorrow;
            return this;
        }

        public KoboWeatherBuilder withMinTomorrow(Integer minTomorrow){
            this.minTomorrow = minTomorrow;
            return this;
        }

        public KoboWeatherBuilder withMaxTomorrow(Integer maxTomorrow){
            this.maxTomorrow = maxTomorrow;
            return this;
        }

        public KoboWeatherBuilder withIcon(String icon){
            this.icon = icon;
            return this;
        }

        public KoboWeatherBuilder withDescription(String description){
            this.description = description;
            return this;
        }

        public KoboWeatherBuilder withIconTomMorning(String iconTomMorning){
            this.iconTomMorning = iconTomMorning;
            return this;
        }

        public KoboWeatherBuilder withIconTomEvening(String iconTomEvening){
            this.iconTomEvening = iconTomEvening;
            return this;
        }


        public KoboWeather build(){
            return new KoboWeather(now, timeNow, current, tomorrow, minTomorrow, maxTomorrow, icon, description, iconTomMorning,
                    iconTomEvening);
        }
    }
}
