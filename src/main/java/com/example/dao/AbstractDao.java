package com.example.dao;

public class AbstractDao {

	protected String getIconUrl(String icon){
		StringBuilder sb = new StringBuilder("http://openweathermap.org/img/w/");
		sb.append(icon);
		sb.append(".png");
		return sb.toString();
	}
	
	protected String capitalizeFirstLetter(String str){
		String cap = str.substring(0, 1).toUpperCase() + str.substring(1);
		return cap;
	}
}
