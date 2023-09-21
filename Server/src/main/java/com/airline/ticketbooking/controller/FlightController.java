package com.airline.ticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airline.ticketbooking.model.Flight;
import com.airline.ticketbooking.service.FlightService;


@RestController
//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequestMapping("/flights")
public class FlightController {
	
	@Autowired
	FlightService flightService;
	
	@PostMapping
	public String addFlight(@RequestBody Flight flight) {
//		flightService.addFlight(flight);
		return "Added Flight Details successfully";
	}
	@GetMapping("/{id}")
	public Flight getFlight(@PathVariable int id)
	{
		return flightService.getFlight(id);
	}
	@GetMapping    
	//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<Flight> getAllFlights(){
		return flightService.getAllFlights();
	}
	@PutMapping("/{id}")
    //@PreAuthorize("hasAuthority('ROLE_USER')")
	public String updateFlight(@RequestBody Flight flight,@PathVariable int id)
	{
//		flightService.updateFlight(flight,id);
		return "updated successfully";
	}
	@DeleteMapping("/{id}")
	public String deleteFlight(@PathVariable int id)
	{
		flightService.deleteFlight(id);
		return "Successfully Deleted Passanger record";
	}
	
	
}
