package com.example.dao;

import com.example.log.LogService;
import com.example.log.LogServiceFactory;
import com.example.log.LoggingRequestInterceptor;
import com.example.model.ForecastRoot;
import com.example.model.WeatherRoot;
import com.example.model.displayable.DayForecasts;
import com.example.model.displayable.ForecastForHour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormatSymbols;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Repository
public class ForecastWeatherDaoImpl extends AbstractDao implements ForecastWeatherDao {

    final static String prefix = "http://api.openweathermap.org/data/2.5/";
    final static String suffix = "?id=2988507&units=metric&lang=fr&appid=84f2ce1f4e70ee9b3dcaaa52b398fdc4";
    final static String forecast_uri = prefix + "forecast" + suffix;
    String[] dayNames = (new DateFormatSymbols(new Locale("fr"))).getShortWeekdays();

    private LogService logService;
    private RestTemplate restTemplate;

    @Autowired
    ForecastWeatherDaoImpl(LogServiceFactory logServiceFactory){
        logService = logServiceFactory.getLogService(this.getClass().getName());

        // Interceptor resttemplate
        restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new LoggingRequestInterceptor(logServiceFactory));
        restTemplate.setInterceptors(interceptors);
    }

    @Override
    public List<DayForecasts> getForecastDays() {
        ForecastRoot forecastRoot = restTemplate.getForObject(forecast_uri, ForecastRoot.class);
        logService.info(()->forecast_uri, null);
        logService.info(forecastRoot, null);
        return toForecasts(forecastRoot);
    }

    private List<DayForecasts> toForecasts(ForecastRoot forecast) {
        //
        List<DayForecasts> dayForecasts = new ArrayList<>();
        // TreeMap orders its keys (natural or via comparator)
        Map<String, ForecastForHour[]> hourForecasts = new TreeMap<>();
        //
        for (WeatherRoot w : forecast.getWeatherRoots()) {
            //
            ForecastForHour forecastForHour = toForecastForHour(w);
            //
            String laDate = getLongDate(forecastForHour.getDate());
            //
            if (!hourForecasts.containsKey(laDate)) {
                hourForecasts.put(laDate, new ForecastForHour[8]);
            }
            int index = forecastForHour.getHour() / 3;
            hourForecasts.get(laDate)[index] = forecastForHour;
        }
        //
        for (Map.Entry<String, ForecastForHour[]> entry : hourForecasts.entrySet()) {
            String key = entry.getKey();
            String shortDay = key.split("_")[1];
            // current day has holes in the past hour
            addEmptyForecasts(entry.getValue());
            dayForecasts.add(new DayForecasts(shortDay, hourForecasts.get(key)));
        }
        //
        return dayForecasts;
    }

    private void addEmptyForecasts(ForecastForHour[] value) {
        for (int i = 0; i < value.length; i++) {
            if (value[i] == null) {
                value[i] = new ForecastForHour();
            }
        }
    }

    private LocalDateTime getMeasLocalDateTime(WeatherRoot w) {
        Instant measInstant = Instant.ofEpochSecond(w.getDt());
        return LocalDateTime.ofInstant(measInstant, ZoneId.systemDefault());
    }

    private ForecastForHour toForecastForHour(WeatherRoot w) {
        //
        ForecastForHour toReturn = new ForecastForHour();
        //
        LocalDateTime measLocalDateTime = getMeasLocalDateTime(w);
        LocalDate measLocalDate = measLocalDateTime.toLocalDate();
        toReturn.setDate(measLocalDate);
        toReturn.setHour(measLocalDateTime.atZone(ZoneId.systemDefault()).getHour());
        //
        Double measTemp = w.getMainMeasurements().getTemp();
        toReturn.setTemp((measTemp == null) ? null : measTemp.intValue());
        //
        String icon = fontIconClass(w.getWeatherEntries()[0].getId());
        toReturn.setIcon(icon);
        //
        String descr = capitalizeFirstLetter(w.getWeatherEntries()[0].getDescription());
        toReturn.setDescription(descr);
        //
        Double windHeading = w.getWind().getDeg();
        toReturn.setWindHeading(windHeading);
        //
        Double windStrength = w.getWind().getSpeed();
        toReturn.setWindStrength(windStrength);
        //
        return toReturn;
    }

    private String fontIconClass(Long id) {
        return "owf owf-"+id;
    }

    private String getShortDate(LocalDate date) {
        if (date == null) {
            return null;
        } else {
            int dayOfWeek = date.getDayOfWeek().getValue();
            int dayIndex = (dayOfWeek == 7) ? 1 : dayOfWeek + 1;
            return dayNames[dayIndex];
        }
    }

    private String getLongDate(LocalDate date) {
        if (date == null) {
            return null;
        } else {
            return date.toString() + "_" + getShortDate(date);
        }
    }
}