package com.example.mapper;

import com.example.model.KoboWeather;
import com.example.model.displayable.DayForecasts;
import com.example.model.displayable.ForecastForHour;
import com.example.model.displayable.ForecastedKoboDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
public class KoboWeatherMapperImpl implements KoboWeatherMapper {

    @Autowired
    Wind windUtility;

    @Override
    public KoboWeather toKoboWeather(List<DayForecasts> forecastDays) {

        // today
        DayForecasts today = forecastDays.get(0);
        ForecastForHour[] todayForecasts = today.getForecasts();
        ForecastForHour nowForecast = Arrays.stream(todayForecasts)
                .filter(t->t.getHour()!=null)
                .findFirst()
                .get();
        Integer currentTemp = nowForecast.getTemp();
        String icon = nowForecast.getIcon();
        String wind = getWind(nowForecast.getWindHeading(), nowForecast.getWindStrength());
        // tomorrows
        List<ForecastedKoboDay> forecastedKoboDays = new ArrayList<>();
        for(int i=1;i<=2;i++){
            forecastedKoboDays.add(getForecasteddDay(forecastDays.get(i), i));
        }

        return new KoboWeather.KoboWeatherBuilder()
                .withCurrentTemp(currentTemp)
                .withIcon(icon)
                .withWind(wind)
                .withForecastedKoboDays(forecastedKoboDays)
                .build();
    }

    private String getWind(Double windHeading, Double windStrength) {
        String h = windUtility.getHeading(windHeading);
        int b = windUtility.getBeaufort(windStrength);
        return " - "+b+""+h;
    }

    private ForecastedKoboDay getForecasteddDay(DayForecasts dayForecasts, int plusDay){

        DayForecasts tomorrow = dayForecasts;

        String tomorrowStr = LocalDate.now()
                .plusDays(plusDay)
                .format(DateTimeFormatter.ofPattern("EEdd", Locale.FRENCH))
                .replaceAll("\\."," ");

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

        return new ForecastedKoboDay(tomorrowStr, iconTomMorning, minTemp, iconTomEvening, maxTemp);
    }
}
