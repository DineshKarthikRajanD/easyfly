package com.easyfly.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easyfly.model.FlightModel;
import com.easyfly.service.FlightService;

import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api-v1/flights")
@Slf4j
public class FlightController {
	@Autowired
	private FlightService flightService;
	
	@PostMapping(value = "/", produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addFlight(@RequestBody FlightModel flight){
		int flightId = flightService.addFlight(flight);
		if(flightId==-1) {
			log.info("Could not add flight details. please try again!!!");
			return new ResponseEntity<String>("Could not add flight details. please try again!!!", HttpStatus.BAD_REQUEST);
		}else {
			log.info("Successfully added flight details with Id: "+ flightId);
			return new ResponseEntity<String>("Successfully added flight details with Id: "+ flightId, HttpStatus.CREATED);
		}
	}
	
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FlightModel>> getAllFlights(){
 		List<FlightModel> flightList = flightService.fetchAllFlights();
 		if(flightList.isEmpty()) {
 			log.info("No flight found!!!");
 			return new ResponseEntity<List<FlightModel>>(HttpStatus.NO_CONTENT);
 		}else {
 			log.info("fetching all flights: found "+ flightList.size() + " flights");
 			return new ResponseEntity<List<FlightModel>>(flightList, HttpStatus.OK);
 		}
	}
	@GetMapping(value = "/{flightId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FlightModel> getFlightById(@PathVariable("flightId") int flightId){
 		FlightModel flight  = flightService.getFlightById(flightId);
 		if(flight==null) {
 			log.info("could not get flight details with id : "+ flightId);
 			return new ResponseEntity<FlightModel>(HttpStatus.NO_CONTENT);
 		}else {
 			log.info("flight details found with id : "+ flightId);
 			return new ResponseEntity<FlightModel>(flight, HttpStatus.FOUND);
 		}
	}
	@DeleteMapping(value = "/{flightId}", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> deleteFlightById(@PathVariable("flightId") int flightId){
 		int deleteStatus  = flightService.deleteFlightById(flightId);
 		if(deleteStatus==-1) {
 			log.info("No flight found with id: "+ flightId);
 			return new ResponseEntity<String>("No flight found !!!",HttpStatus.BAD_REQUEST);
 		}else {
 			log.info("successfully deleted flight details with id: "+ flightId);
 			return new ResponseEntity<String>("successfully deleted flight details", HttpStatus.OK);
 		}
	}
	
	@PutMapping(value = "/{flightId}", produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateFlightDetails(@PathVariable("flightId") int flightId, @RequestBody FlightModel flight){
		int updateStatus = flightService.updateFlight(flightId, flight);
		if(updateStatus==-1) {
			log.info("Could not update flight details with id:"+ flightId);
			return new ResponseEntity<String>("Could not update flight details. please try again!!!", HttpStatus.BAD_REQUEST);
		}else {
			log.info("Successfully updated flight details with Id: "+ flightId);
			return new ResponseEntity<String>("Successfully updated flight details with Id: "+ flightId, HttpStatus.CREATED);
		}
	}
}
