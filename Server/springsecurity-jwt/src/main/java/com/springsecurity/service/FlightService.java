package com.springsecurity.service;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springsecurity.entity.Flight;
import com.springsecurity.exception.FlightNotFoundException;
import com.springsecurity.exception.PassangerNotFoundException;
import com.springsecurity.repository.FlightRepository;


@Service
public class FlightService {
	
	@Autowired
	FlightRepository flightRepository;
	
	public Flight getFlight(int id) throws FlightNotFoundException
	{
		Optional<Flight> flights=flightRepository.findById(id);
		if(flights.isPresent()) {
			Flight flight=flights.get();
			return flight;
		}
		else {
			throw new FlightNotFoundException("Flight not exist"+id);
		}
	}
	public List<Flight> getAllFlights(){
		List<Flight> flight=flightRepository.findAll();
		if(flight!=null) {
			return flight;
		}
		else
		{ 
			throw new FlightNotFoundException("No flight records found");
		}
	}
	/*public void updateFlight(Flight flight,int id) {
		Optional<Flight> fly=flightRepository.findById(id);
		if(fly.isPresent()) {
			Flight flights=fly.get();
			
			flights.setCreatedAt(new Timestamp(System.currentTimeMillis()));
			flights.setFlightName(flight.getFlightName());
			flights.setFlightNumber(flight.getFlightNumber());
			flights.setStatus(flight.isStatus());
			flights.setTotalSeats(flight.getTotalSeats());
			
			flightRepository.save(flights);
		}
		else
		{
			throw new FlightNotFoundException("not found flight id:"+id);
		}
	}*/
	public void updateFlight(Flight flight, int id) {
	    Optional<Flight> optionalFlight = flightRepository.findById(id);
	    if (optionalFlight.isPresent()) {
	        Flight existingFlight = optionalFlight.get();
	        existingFlight.setCreatedAt(existingFlight.getCreatedAt());
	        
	        if(flight.getFlightNumber()!=null) 
		        flight.setFlightNumber(flight.getFlightNumber());
	        if(flight.getFlightName()!=null)
	        	existingFlight.setFlightName(flight.getFlightName());
	        if(flight.getTotalSeats()!=0)
		        existingFlight.setTotalSeats(flight.getTotalSeats());
	        
	        existingFlight.setStatus(flight.isStatus());

	        flightRepository.save(existingFlight);
	    } else {
	        throw new FlightNotFoundException("Flight not found with id: " + id);
	    }
	}

	public void deleteFlight(int id) {
		Optional<Flight> flight=flightRepository.findById(id);
		if(flight.isPresent()) {
			Flight pass=flight.get();
			flightRepository.delete(pass);
		}
		else
		{
			throw new FlightNotFoundException("no records found for this id"+id);
		}
	}
	/*public static String timeDiff(LocalTime depatureTime,LocalTime arrivalTime) {
		long hours = ChronoUnit.HOURS.between(depatureTime, arrivalTime);
	    
	    long minutes
	        = ChronoUnit.MINUTES.between(depatureTime, arrivalTime) % 60;

	    long seconds
	        = ChronoUnit.SECONDS.between(depatureTime, arrivalTime) % 60;

	String difference=
	        hours + " hours " + minutes
	        + " minutes " + seconds + " seconds.";
	return difference;
	}*/

}
