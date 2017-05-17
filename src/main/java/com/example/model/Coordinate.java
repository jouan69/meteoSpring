package com.example.model;

public class Coordinate {
	
	Double lat;
	Double lon;

	public Coordinate(Double lat, Double lon) {
		super();
		this.lat = lat;
		this.lon = lon;
	}
	
	public Coordinate() {
		super();
	}

	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLon() {
		return lon;
	}
	public void setLon(Double lon) {
		this.lon = lon;
	}
}
