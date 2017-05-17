package com.example.model.displayable;

import java.time.LocalDate;

public class ForecastForHour {
	
	LocalDate date;
	Integer temp;
	String description;
	Double windHeading;
	Double windStrength;
	String icon;
	Integer hour;

	public ForecastForHour(LocalDate date, Integer temp, String description, Double windHeading, Double windStrength,
			String icon,Integer hour) {
		super();
		this.date = date;
		this.temp = temp;
		this.description = description;
		this.windHeading = windHeading;
		this.windStrength = windStrength;
		this.icon = icon;
		this.hour = hour;
	}

	public ForecastForHour() {
		super();
	}

	public ForecastForHour(int hour, String icon) {
		this.hour = hour;
		this.icon = icon;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Integer getTemp() {
		return temp;
	}

	public void setTemp(Integer temp) {
		this.temp = temp;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getWindHeading() {
		return windHeading;
	}

	public void setWindHeading(Double windHeading) {
		this.windHeading = windHeading;
	}

	public Double getWindStrength() {
		return windStrength;
	}

	public void setWindStrength(Double windStrength) {
		this.windStrength = windStrength;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getHour() {
		return hour;
	}

	public void setHour(Integer hour) {
		this.hour = hour;
	}
		
}
