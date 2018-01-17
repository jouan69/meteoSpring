package com.example.ws;

import com.example.model.WeatherTable;
import com.example.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	@Autowired
	WeatherService weatherService;

	@RequestMapping("/meteo")
	public String welcome(Model model) {
		WeatherTable weatherTable = weatherService.getDayPlus();
		model.addAttribute("forecastedDays", weatherTable.getForecasts());
		model.addAttribute("hours", weatherTable.getHours());
		return "welcome"; 
	}

}
