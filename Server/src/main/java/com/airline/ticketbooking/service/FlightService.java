package com.airline.ticketbooking.service;

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

import com.airline.ticketbooking.exceptions.FlightNotFoundException;
import com.airline.ticketbooking.exceptions.PassangerNotFoundException;
import com.airline.ticketbooking.model.Flight;
import com.airline.ticketbooking.model.Passanger;
import com.airline.ticketbooking.repository.FlightRepository;

@Service
public class FlightService {
	
	@Autowired
	FlightRepository flightRepository;
	
	public void addFlight(Flight flight)
	{
		LocalTime depatureTime=flight.getDepatureTime();
		LocalTime arrivalTime=flight.getArrivalTime();
		String difference=timeDiff(depatureTime,arrivalTime);
	    flight.setDuration(difference);
		flightRepository.save(flight);
	}
	
	public Flight getFlight(int id)
	{
		Optional<Flight> flights=flightRepository.findById(id);
		if(flights.isPresent()) {
			Flight flight=flights.get();
			return flight;
		}
		else {
			throw new PassangerNotFoundException("Flight not exist"+id);
		}
	}
	public List<Flight> getAllFlights(){
		List<Flight> flight=flightRepository.findAll();
		if(flight!=null) {
			return flight;
		}
		else
		{ 
			throw new PassangerNotFoundException("no flight records found");
		}
	}
	public void updateFlight(Flight flight,int id) {
		Optional<Flight> fly=flightRepository.findById(id);
		if(fly.isPresent()) {
			Flight flights=fly.get();
			
			flights.setFlightName(flight.getFlightName());
			flights.setFlightType(flight.getFlightType());
			flights.setSource(flight.getSource());
			flights.setDestination(flight.getDestination());
			flights.setDepatureDate(flight.getDepatureDate());
			flights.setArrivalDate(flight.getArrivalDate());
			flights.setDepatureTime(flight.getDepatureTime());
			flights.setArrivalTime(flight.getArrivalTime());
			flights.setDuration(timeDiff(flight.getDepatureTime(),flight.getArrivalTime()));
			flights.setAvailableSeats(flight.getAvailableSeats());
			
			flightRepository.save(flights);
		}
		else
		{
			throw new FlightNotFoundException("not found flight id:"+id);
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
	public static String timeDiff(LocalTime depatureTime,LocalTime arrivalTime) {
		long hours = ChronoUnit.HOURS.between(depatureTime, arrivalTime);
	    
	    long minutes
	        = ChronoUnit.MINUTES.between(depatureTime, arrivalTime) % 60;

	    long seconds
	        = ChronoUnit.SECONDS.between(depatureTime, arrivalTime) % 60;

	String difference=
	        hours + " hours " + minutes
	        + " minutes " + seconds + " seconds.";
	return difference;
	}

}
