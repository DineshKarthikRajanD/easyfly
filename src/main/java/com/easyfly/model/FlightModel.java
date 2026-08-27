package com.easyfly.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FlightModel {
	private int flightId;
	private String flightNumber;
	private String source;
	private String destination;
	private String status;
	private double duration;
	private double fare;
	public FlightModel(String flightNumber, String source, String destination, String status, double duration,
			double fare) {
		super();
		this.flightNumber = flightNumber;
		this.source = source;
		this.destination = destination;
		this.status = status;
		this.duration = duration;
		this.fare = fare;
	}
	
}
