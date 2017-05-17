package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class City {
	@JsonProperty("id")
	private Long id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("coord")
	private Coordinate coordinate;
	@JsonProperty("country")
	private String country;
}
