package com.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springsecurity.entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

	Flight findByFlightName(String flightName);

}
