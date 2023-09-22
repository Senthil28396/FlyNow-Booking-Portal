package com.airline.ticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airline.ticketbooking.model.Flight;
import com.airline.ticketbooking.model.Trip;
import com.airline.ticketbooking.service.FlightService;
import com.airline.ticketbooking.service.TripService;


@RestController
@RequestMapping("/trips")
public class TripController {
	
	@Autowired
	TripService tripService;
	
	@PostMapping
	public String addTrip(@RequestBody Trip trip) {
		tripService.addTrip(trip);
		return "Added Trip Details successfully";
	}
	@GetMapping("/{id}")
	public Trip getTrip(@PathVariable int id)
	{
		return tripService.getTrip(id);
	}
	@GetMapping    
	public List<Trip> getAllTrips(){
		return tripService.getAllTrips();
	}
	@PutMapping("/{id}")
	public String updateTrip(@RequestBody Trip trip,@PathVariable int id)
	{
		tripService.updateTrip(trip,id);
		return "updated successfully";
	}
	@DeleteMapping("/{id}")
	public String deleteTrip(@PathVariable int id)
	{
		tripService.deleteTrip(id);
		return "Successfully Deleted Trip record";
	}
	
	
}
