package com.easyfly.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easyfly.entity.FlightEntity;

@Repository("flightRepo")
public interface FlightDao extends JpaRepository<FlightEntity, Integer> {

}
