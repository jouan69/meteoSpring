package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherRoot {
	@JsonProperty("coord")
	private Coordinate coordinate;
	@JsonProperty("weather")
	WeatherEntry[] weatherEntries;
	@JsonProperty("base")
	private String base;
	@JsonProperty("main")
	private MainMeasurements mainMeasurements;
	@JsonProperty("visibility")
	private Long visibility;
	@JsonProperty("wind")
	private Wind wind;
	@JsonProperty("clouds")
	private Clouds clouds;
	@JsonProperty("dt")
	private Long dt;
	@JsonProperty("sys")
	private Sys sys;
	@JsonProperty("id")
	private Long id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("cod")
	private Long cod;
	
	public Coordinate getCoordinate() {
		return coordinate;
	}
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public MainMeasurements getMainMeasurements() {
		return mainMeasurements;
	}
	public void setMainMeasurements(MainMeasurements mainMeasurements) {
		this.mainMeasurements = mainMeasurements;
	}
	public Long getVisibility() {
		return visibility;
	}
	public void setVisibility(Long visibility) {
		this.visibility = visibility;
	}
	public Wind getWind() {
		return wind;
	}
	public void setWind(Wind wind) {
		this.wind = wind;
	}
	public Clouds getClouds() {
		return clouds;
	}
	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}
	public Long getDt() {
		return dt;
	}
	public void setDt(Long dt) {
		this.dt = dt;
	}
	public Sys getSys() {
		return sys;
	}
	public void setSys(Sys sys) {
		this.sys = sys;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getCod() {
		return cod;
	}
	public void setCod(Long cod) {
		this.cod = cod;
	}
	public WeatherEntry[] getWeatherEntries() {
		return weatherEntries;
	}
	public void setWeatherEntries(WeatherEntry[] weatherEntries) {
		this.weatherEntries = weatherEntries;
	}
}
