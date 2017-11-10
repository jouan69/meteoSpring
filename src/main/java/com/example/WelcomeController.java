package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.displayable.DayForecasts;
import com.example.service.WeatherService;

@Controller
public class WelcomeController {

	@Autowired
	WeatherService weatherService;

	@RequestMapping("/meteo")
	public String welcome(Model model) {

		List<DayForecasts> forecastedDays = new ArrayList<>();
		forecastedDays.addAll(weatherService.getDayPlus());
		model.addAttribute("forecastedDays", forecastedDays);
		
		return "welcome"; 
	}

}
