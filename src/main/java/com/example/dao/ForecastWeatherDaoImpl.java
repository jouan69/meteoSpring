package com.example.dao;

import java.text.DateFormatSymbols;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.model.ForecastRoot;
import com.example.model.WeatherRoot;
import com.example.model.displayable.DayForecasts;
import com.example.model.displayable.ForecastForHour;

@Component
public class ForecastWeatherDaoImpl extends AbstractDao implements ForecastWeatherDao {

	final static String prefix = "http://api.openweathermap.org/data/2.5/";
	final static String suffix = "?id=2988507&units=metric&lang=fr&appid=84f2ce1f4e70ee9b3dcaaa52b398fdc4";
	final static String forecast_uri = prefix + "forecast" + suffix;
	String[] dayNames = (new DateFormatSymbols(new Locale("fr"))).getShortWeekdays();
	
	@Override
	public List<DayForecasts> getForecastDays() {
		RestTemplate restTemplate = new RestTemplate();
		ForecastRoot forecastRestTemplate = restTemplate.getForObject(forecast_uri, ForecastRoot.class);
		System.out.println(forecast_uri);
		List<DayForecasts> toReturn = toForecasts(forecastRestTemplate);
		return toReturn;
	}

	private List<DayForecasts> toForecasts(ForecastRoot forecast) {
		//
		List<DayForecasts> dayForecasts = new ArrayList<>();
		Map<String,ForecastForHour[]> hourForecasts = new TreeMap<>();
		//
		for (WeatherRoot w : forecast.getWeatherRoots()) {
			//
			ForecastForHour forecastForHour = toForecastForHour(w);
			//
			String laDate = getLongDate(forecastForHour.getDate());
			//
			if(!hourForecasts.containsKey(laDate)){
				hourForecasts.put(laDate, new ForecastForHour[8]);
			}
			int index = forecastForHour.getHour()/3;
			hourForecasts.get(laDate)[index] = forecastForHour;
		}
		//
		for(String date : hourForecasts.keySet()){
			String day = date.split("_")[1];
			dayForecasts.add(new DayForecasts(day, hourForecasts.get(date)));
		}
		//
		return dayForecasts;
	}

	private LocalDateTime getMeasLocalDateTime(WeatherRoot w) {
		Instant measInstant = Instant.ofEpochSecond(w.getDt());
		return LocalDateTime.ofInstant(measInstant, ZoneId.systemDefault());
	}
	
	private ForecastForHour toForecastForHour(WeatherRoot w){
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
		String icon = getIconUrl(w.getWeatherEntries()[0].getIcon());
		toReturn.setIcon(icon);
		//
		String descr = capitalizeFirstLetter(w.getWeatherEntries()[0].getDescription());
		toReturn.setDescription(descr);
		//
		Double windHeading = new Double(0);
		toReturn.setWindHeading(windHeading);
		//
		Double windStrength = new Double(0);
		toReturn.setWindStrength(windStrength);
		//
		return toReturn;
	}
	
	private String getShortDate(LocalDate date){
		if(date==null){
			return null;
		}else{
			int dayOfWeek = date.getDayOfWeek().getValue();
			int dayIndex = (dayOfWeek==7)?1:dayOfWeek+1;
			return dayNames[dayIndex];			
		}
	}
	
	private String getLongDate(LocalDate date){
		if(date==null){
			return null;
		}else{
			return date.toString()+"_"+getShortDate(date);			
		}
	}
}