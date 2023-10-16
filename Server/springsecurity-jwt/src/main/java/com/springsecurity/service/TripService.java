package com.springsecurity.service;


import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springsecurity.entity.Flight;
import com.springsecurity.entity.Passanger;
import com.springsecurity.entity.Trip;
import com.springsecurity.exception.FlightNotFoundException;
import com.springsecurity.exception.TripNotFoundException;
import com.springsecurity.repository.FlightRepository;
import com.springsecurity.repository.TripRepository;

@Service
public class TripService {
	
	@Autowired
	TripRepository tripRepository;
	
	@Autowired
	FlightRepository flightRepository;
	
	public void addTrip(Trip trip) {
		Optional<Flight> flight=flightRepository.findById(trip.getFlight().getId());
		
		 int availableSeats = flight.get().getTotalSeats();

	        
	            trip.setAvailableSeats(availableSeats);
		
		
	    Timestamp currentTimestamp = new Timestamp(new Date().getTime());

	    LocalTime departureTime = trip.getDepatureTime();
	    LocalTime arrivalTime = trip.getArrivalTime();
	    long durationMinutes = Duration.between(departureTime, arrivalTime).toMinutes();

	    long hours = durationMinutes / 60;
	    long minutes = durationMinutes % 60;
	    String duration = hours + "hrs " + minutes + "mins";

	    trip.setDuration(duration);
	    trip.setCreateAt(currentTimestamp);
	    if(flight.isPresent()) {
	    	Flight presentFlight=flight.get();
		    trip.setFlight(presentFlight);

	    }
	    else {
	    	throw new FlightNotFoundException("Flight "+trip.getFlight().getId()+ "is not present ");
	    }

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
		List<Trip> trip=(List<Trip>)tripRepository.findAll();
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
			if(trip.getArrival()!=null)
				trips.setArrival(trip.getArrival());
			if(trip.getArrivalDate()!=null)
				trips.setArrivalDate(trip.getArrivalDate());
			if(trip.getArrivalTime()!=null)
				trips.setArrivalTime(trip.getArrivalTime());
			if(trip.getDeparture()!=null)
				trips.setDeparture(trip.getDeparture());
			if(trip.getDepatureDate()!=null)	
				trips.setDepatureDate(trip.getDepatureDate());
			if(trip.getDepatureTime()!=null)
				trips.setDepatureTime(trip.getDepatureTime());
			if(trip.getDuration()!=null)
				trips.setDuration(trip.getDuration());
			if(trip.getFlight()!=null)
				trips.setFlight(trip.getFlight());
			
				trips.setStatus(trip.isStatus());			
			if(trip.getPricePerSeat()!=0)
				trips.setPricePerSeat(trip.getPricePerSeat());
			
			
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
	 public List<Trip> searchTrips(String departure, String arrival, LocalDate date) {
	        return tripRepository.findByDepartureAndArrivalAndDepatureDate(departure, arrival, date);
	    }
}
