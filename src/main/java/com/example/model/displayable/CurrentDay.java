package com.example.model.displayable;

public class CurrentDay {
	
	String date;
	Integer currentTemp;
	String description;
	Double windHeading;
	Double windStrength;
	String icon;
	
	public CurrentDay(String date, Integer currentTemp, String description,
			Double windHeading, Double windStrength, String icon) {
		super();
		this.date = date;
		this.currentTemp = currentTemp;
		this.description = description;
		this.windHeading = windHeading;
		this.windStrength = windStrength;
		this.icon = icon;
	}
	public CurrentDay() {
		super();
	}
	public String getDate() {
		return date.toString();
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getCurrentTemp() {
		return currentTemp;
	}
	public void setCurrentTemp(Integer currentTemp) {
		this.currentTemp = currentTemp;
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
}
