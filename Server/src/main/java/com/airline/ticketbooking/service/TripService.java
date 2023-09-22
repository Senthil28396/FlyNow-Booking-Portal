package com.airline.ticketbooking.service;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.ticketbooking.exceptions.FlightNotFoundException;
import com.airline.ticketbooking.exceptions.TripNotFoundException;
import com.airline.ticketbooking.model.Flight;
import com.airline.ticketbooking.model.Trip;
import com.airline.ticketbooking.repository.FlightRepository;
import com.airline.ticketbooking.repository.TripRepository;

@Service
public class TripService {
	
	@Autowired
	TripRepository tripRepository;
	
	public void addTrip(Trip trip)
	{
        Timestamp currentTimestamp = new Timestamp(new Date().getTime());
        trip.setCreateAt(currentTimestamp);
		tripRepository.save(trip);
	}
	
	public Trip getTrip(long id)
	{
		Optional<Trip> trips=tripRepository.findById(id);
		if(trips.isPresent()) {
			Trip trip=trips.get();
			return trip;
		}
		else {
			throw new TripNotFoundException("Trip not exist"+id);
		}
	}
	public List<Trip> getAllTrips(){
		List<Trip> trip=tripRepository.findAll();
		if(trip!=null) {
			return trip;
		}
		else
		{ 
			throw new TripNotFoundException("Trip not exist");
		}
	}
	public void updateTrip(Trip trip,long id) {
		Optional<Trip> fly=tripRepository.findById(id);
		if(fly.isPresent()) {
			Trip trips=fly.get();
			
			trips.setSource(trip.getSource());
			trips.setDestination(trip.getDestination());
			trips.setDepatureDate(trip.getDepatureDate());
			trips.setArrivalDate(trip.getArrivalDate());
			trips.setStatus(trip.getStatus());
			trips.setAvailableSeats(trip.getAvailableSeats());
			trips.setCreatedAt(trip.getCreatedAt());


			tripRepository.save(trips);
		}
		else
		{
			throw new TripNotFoundException("not found Trip id:"+id);
		}
	}
	public void deleteTrip(long id) {
		Optional<Trip> trip=tripRepository.findById(id);
		if(trip.isPresent()) {
			Trip fly=trip.get();
			tripRepository.delete(fly);
		}
		else
		{
			throw new TripNotFoundException("no records found for this id"+id);
		}
	}
}
