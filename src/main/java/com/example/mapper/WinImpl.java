package com.example.mapper;

import org.springframework.stereotype.Component;

@Component
public class WinImpl implements Wind {

    @Override
    public String getHeading(Double windHeading) {
        String dir;
        if (windHeading <= 22.5) {
            return "N";
        } else if (windHeading <= 67.5) {
            return "NE";
        } else if (windHeading <= 112.5) {
            return "E";
        } else if (windHeading <= 157.5) {
            return "SE";
        } else if (windHeading <= 202.5) {
            return "S";
        } else if (windHeading <= 247.5) {
            return "SW";
        } else if (windHeading <= 292.5) {
            return "W";
        } else if (windHeading <= 337.5) {
            return "NW";
        } else {
            return "N";
        }
    }

    @Override
    public int getBeaufort (Double windSpeed){
        Double term = Math.pow(windSpeed, 2.0) / 9.0;
        return (int) Math.round(Math.pow(term, 1.0 / 3));
    }
}
