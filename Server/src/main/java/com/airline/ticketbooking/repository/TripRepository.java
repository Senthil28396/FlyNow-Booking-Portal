package com.airline.ticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airline.ticketbooking.model.Trip;
@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
	
}
