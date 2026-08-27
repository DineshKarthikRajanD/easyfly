package com.easyfly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.easyfly.dao.FlightDaoWrapper;
import com.easyfly.model.FlightModel;

@Component
@Profile(value = {"default", "qa", "dev", "prod"})
public class LoadFlightData implements CommandLineRunner{
	
	@Autowired
	FlightDaoWrapper flightDaoWrapper;
	
	@Override
	public void run(String... args) throws Exception {
		flightDaoWrapper.addFlightDetails(new FlightModel(1, "AI-501", "Mumbai", "Dubai", "Delayed", 2.4, 15000));
		flightDaoWrapper.addFlightDetails(new FlightModel(2, "Lufthansa-502", "Delhi", "New York", "On-Time", 12.30, 64000));
		flightDaoWrapper.addFlightDetails(new FlightModel(3, "FlyEmirates-503", "Bengaluru", "Singapore", "Running", 8.1, 23000));
		flightDaoWrapper.addFlightDetails(new FlightModel(4, "Indigo-504", "Chennai", "London", "Cancelled", 9.5, 41000));
		flightDaoWrapper.addFlightDetails(new FlightModel(5, "SpiceJet-505", "Hyderabad", "Melbourne", "On-Time", 13.40, 38000));
	}
}
