package com.airline.ticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airline.ticketbooking.model.Flight;
@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

}
