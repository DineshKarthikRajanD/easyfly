package com.easyfly.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "FlightDetails")
public class FlightEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "flight_id")
	private int flightId;
	@Column(name = "flight_number")
	private String flightNumber;
	@Column(name = "flight_source")
	private String source;
	@Column(name = "flight_destination")
	private String destination;
	@Column(name = "flight_status")
	private String status;
	@Column(name = "flight_duration")
	private double duration;
	@Column(name = "flight_fare")
	private double fare;

	public FlightEntity(String flightNumber, String source, String destination, String status, double duration,
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
