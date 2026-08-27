package com.easyfly.service;

import java.util.List;

import com.easyfly.model.FlightModel;

public interface FlightService {
	public int addFlight(FlightModel flightModel);
	public List<FlightModel> fetchAllFlights();
	public FlightModel getFlightById(int flightId);
	public int deleteFlightById(int flightId);
	public int updateFlight(int flightId, FlightModel flightModel);
}
