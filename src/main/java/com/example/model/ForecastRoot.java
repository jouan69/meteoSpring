package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ForecastRoot {
	@JsonProperty("cod")
	private Long cod;
	@JsonProperty("message")
	private Double message;
	@JsonProperty("cnt")
	private Long cnt;
	@JsonProperty("list")
	private WeatherRoot[] weatherRoots;
	@JsonProperty("city")
	private City city;
	
	public Long getCod() {
		return cod;
	}
	public void setCod(Long cod) {
		this.cod = cod;
	}
	public Double getMessage() {
		return message;
	}
	public void setMessage(Double message) {
		this.message = message;
	}
	public Long getCnt() {
		return cnt;
	}
	public void setCnt(Long cnt) {
		this.cnt = cnt;
	}
	public WeatherRoot[] getWeatherRoots() {
		return weatherRoots;
	}
	public void setWeatherRoots(WeatherRoot[] weatherRoots) {
		this.weatherRoots = weatherRoots;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
}
