package com.example.service;

import com.example.dao.ForecastWeatherDao;
import com.example.mapper.KoboWeatherMapper;
import com.example.model.KoboWeather;
import com.example.model.displayable.DayForecasts;
import com.example.model.displayable.ForecastForHour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/**
 * Created by erwanjouan on 18/01/2018.
 */
@Component
public class KoboServiceImpl implements KoboService {

    @Autowired
    ForecastWeatherDao forecastWeatherDao;

    @Autowired
    KoboWeatherMapper koboWeatherMapper;

    @Override
    public KoboWeather getPage() {

        List<DayForecasts> forecastDays = forecastWeatherDao.getForecastDays();
        
        return koboWeatherMapper.toKoboWeather(forecastDays);
    }
}
