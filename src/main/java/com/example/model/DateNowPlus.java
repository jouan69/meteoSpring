package com.example.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class DateNowPlus {
	
	private LocalDate date;
	
	public DateNowPlus(int plus){
		this.date = LocalDate.now().plusDays(plus);
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
	    DayOfWeek dayOfWeek = date.getDayOfWeek();
	    sb.append(dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.FRENCH));
	    sb.append(" ");
	    int jourMois = date.getDayOfMonth();
	    sb.append(jourMois);
	    sb.append(" ");
	    Month mois = date.getMonth();
	    sb.append(mois.getDisplayName(TextStyle.SHORT, Locale.FRENCH));
	    return sb.toString();
	}
}
