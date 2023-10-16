package com.springsecurity.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springsecurity.entity.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

	Trip findById(int id);

	List<Trip> findByDepartureAndArrivalAndDepatureDate(String departure, String arrival, LocalDate date);
	
}
