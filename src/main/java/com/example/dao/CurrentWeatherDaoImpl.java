package com.example.dao;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.model.DateNowPlus;
import com.example.model.WeatherRoot;
import com.example.model.displayable.CurrentDay;

@Component
public class CurrentWeatherDaoImpl extends AbstractDao implements CurrentWeatherDao{

	final static String prefix = "http://api.openweathermap.org/data/2.5/";
	final static String suffix = "?id=2988507&units=metric&lang=fr&appid=84f2ce1f4e70ee9b3dcaaa52b398fdc4";
	final static String current_uri = prefix + "weather" + suffix;

	@Override
	public CurrentDay getCurrentDay() {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println(current_uri);
	    WeatherRoot result = restTemplate.getForObject(current_uri, WeatherRoot.class);
	    return toDisplayedDay(result);
	}

	private CurrentDay toDisplayedDay(WeatherRoot result) {
		CurrentDay displayedDay = new CurrentDay();
		displayedDay.setDate((new DateNowPlus(0)).toString());
		displayedDay.setCurrentTemp(result.getMainMeasurements().getTemp().intValue());
		displayedDay.setDescription(capitalizeFirstLetter(result.getWeatherEntries()[0].getDescription()));
		displayedDay.setIcon(getIconUrl(result.getWeatherEntries()[0].getIcon()));
		displayedDay.setWindHeading(result.getWind().getDeg());
		displayedDay.setWindStrength(result.getWind().getSpeed());
		return displayedDay;
	}
}
