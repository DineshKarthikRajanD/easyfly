package com.easyfly.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.easyfly.entity.FlightEntity;
import com.easyfly.model.FlightModel;

@Repository("flightDaoWrapper")
public class FlightDaoWrapper {
	@Autowired
	private FlightDao flightDao;

	public int addFlightDetails(FlightModel flightModel) {
		// convert flightModel to flightEntity
		FlightEntity flightEntity = new FlightEntity();
		BeanUtils.copyProperties(flightModel, flightEntity);
		FlightEntity savedFlightEntity = flightDao.save(flightEntity);
		if (savedFlightEntity != null) {
			return savedFlightEntity.getFlightId();
		} else {
			return -1;
		}
	}

	public List<FlightModel> getAllFlights() {
		List<FlightEntity> flightEntityList = flightDao.findAll();
		List<FlightModel> flightModelList = new ArrayList<FlightModel>();
		for (FlightEntity fe : flightEntityList) {
			FlightModel fm = new FlightModel();
			BeanUtils.copyProperties(fe, fm);
			flightModelList.add(fm);
		}
		return flightModelList;
	}
	public FlightModel getFlightById(int flightId) {
		Optional<FlightEntity> OptionalFlightEntity = flightDao.findById(flightId);
		if(OptionalFlightEntity.isPresent()) {
			FlightEntity flightEntity = OptionalFlightEntity.get();
			FlightModel flightModel = new FlightModel();
			BeanUtils.copyProperties(flightEntity, flightModel);
			return flightModel;
		}else {
			return null;
		}
	}
	public int deleteFlight(int flightId) {
		Optional<FlightEntity> OptionalFlightEntity = flightDao.findById(flightId);
		if(OptionalFlightEntity.isPresent()) {
			flightDao.delete(OptionalFlightEntity.get());
			return 1;
		}else {
			return -1;
		}
	}
	
	public int updateFlightDetails(int flightId, FlightModel flightModel) {
		Optional<FlightEntity> OptionalFlightEntity = flightDao.findById(flightId);
		if(OptionalFlightEntity.isPresent()) {
			FlightEntity flightEntity = new FlightEntity();
			BeanUtils.copyProperties(flightModel, flightEntity);
			FlightEntity updatedFlightEntity = flightDao.save(flightEntity);
			if(updatedFlightEntity!=null) {
				return 1;	
			}else {
				return -1;
			}			
		}else {
			return -1;
		}		 
	}
}
