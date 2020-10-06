package com.lti.dto;

import org.springframework.stereotype.Component;

@Component
public class ViewFlightCityDto {

	private String source;
	private String destination;
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
}
