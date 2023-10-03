package com.springsecurity.controller;

import java.sql.Timestamp;
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

import com.springsecurity.entity.Flight;
import com.springsecurity.exception.FlightNotFoundException;
import com.springsecurity.exception.PassangerNotFoundException;
import com.springsecurity.repository.FlightRepository;
import com.springsecurity.service.FlightService;

@RestController
@RequestMapping("/flights")
public class FlightController {

	@Autowired
	FlightService flightService;
	@Autowired
	FlightRepository flightRepository;

	@PostMapping
	@PreAuthorize("hasAuthority('ADMIN')")
	public String addFlight(@RequestBody Flight flight) {
		flight.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		flightRepository.save(flight);
		return "Added Flight Details successfully";
	}

	@GetMapping("/{id}")
	public Flight getFlight(@PathVariable int id) throws FlightNotFoundException {
		return flightService.getFlight(id);
	}

	@GetMapping
	public List<Flight> getAllFlights() {
		return flightService.getAllFlights();
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String updateFlight(@RequestBody Flight flight, @PathVariable int id) {
		flightService.updateFlight(flight, id);
		return "updated successfully";
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteFlight(@PathVariable int id) {
		flightService.deleteFlight(id);
		return "Successfully Deleted Passanger record";
	}

}
