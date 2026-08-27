package com.easyfly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyfly.dao.FlightDaoWrapper;
import com.easyfly.model.FlightModel;

@Service("flightService")
public class FlightServiceImpl implements FlightService {
	
	@Autowired
	private FlightDaoWrapper flightDaoWrapper;

	@Override
	public int addFlight(FlightModel flightModel) {
		return flightDaoWrapper.addFlightDetails(flightModel);
	}

	@Override
	public List<FlightModel> fetchAllFlights() {
		return flightDaoWrapper.getAllFlights();
	}

	@Override
	public FlightModel getFlightById(int flightId) {
		return flightDaoWrapper.getFlightById(flightId);
	}

	@Override
	public int deleteFlightById(int flightId) {
		return flightDaoWrapper.deleteFlight(flightId);
	}

	@Override
	public int updateFlight(int flightId, FlightModel flightModel) {
		return flightDaoWrapper.updateFlightDetails(flightId, flightModel);
	}
}
