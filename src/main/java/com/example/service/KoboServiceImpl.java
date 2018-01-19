package com.example.service;

import com.example.dao.ForecastWeatherDao;
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
    
    @Override
    public KoboWeather getPage() {

        List<DayForecasts> forecastDays = forecastWeatherDao.getForecastDays();

        DayForecasts today = forecastDays.get(0);
        ForecastForHour[] todayForecasts = today.getForecasts();

        ForecastForHour nowForecast = Arrays.stream(todayForecasts)
                .filter(t->t.getHour()!=null)
                .findFirst()
                .get();


        LocalDateTime now = LocalDateTime.now();
        String dateNow = now.format(DateTimeFormatter.ofPattern("EE dd", Locale.FRENCH));
        String timeNow = now.format(DateTimeFormatter.ofPattern("HH:mm", Locale.FRENCH));

        Integer currentTemp = nowForecast.getTemp();
        String icon = nowForecast.getIcon();

        String tomorrowStr = LocalDate.now()
                                .plusDays(1)
                                .format(DateTimeFormatter.ofPattern("EE dd", Locale.FRENCH));

        DayForecasts tomorrow = forecastDays.get(1);
        ForecastForHour[] tomorrowForecasts = tomorrow.getForecasts();

        Integer minTemp = Arrays.stream(tomorrowForecasts)
                                .map(t->t.getTemp())
                                .min(Comparator.naturalOrder())
                                .get();

        Integer maxTemp = Arrays.stream(tomorrowForecasts)
                .map(t->t.getTemp())
                .max(Comparator.naturalOrder())
                .get();

        String iconTomMorning = tomorrowForecasts[3].getIcon();

        String iconTomEvening = tomorrowForecasts[5].getIcon();

        KoboWeather.KoboWeatherBuilder builder = new KoboWeather.KoboWeatherBuilder();

        return builder
                .withDate(dateNow)
                .withTime(timeNow)
                .withCurrentTemp(currentTemp)
                .withDateTomorrow(tomorrowStr)
                .withMinTomorrow(minTemp)
                .withMaxTomorrow(maxTemp)
                .withIcon(icon)
                .withIconTomMorning(iconTomMorning)
                .withIconTomEvening(iconTomEvening)
                .build();
    }
}