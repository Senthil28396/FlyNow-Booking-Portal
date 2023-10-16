package com.springsecurity.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.entity.Trip;
import com.springsecurity.service.TripService;


@RestController
@RequestMapping("/trips")
@CrossOrigin(origins="http://localhost:3000")
public class TripController {
	
	@Autowired
	TripService tripService;
	
	@PostMapping
	@PreAuthorize("hasAuthority('ADMIN')")
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
	@PreAuthorize("hasAuthority('ADMIN')")
	public String updateTrip(@RequestBody Trip trip,@PathVariable int id)
	{
		tripService.updateTrip(trip,id);
		return "updated successfully";
	}
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteTrip(@PathVariable int id)
	{
		tripService.deleteTrip(id);
		return "Successfully Deleted Trip record";
	}
	 @GetMapping("/search")
	    public ResponseEntity<List<Trip>> searchTrips(
	            @RequestParam("departure") String departure,
	            @RequestParam("arrival") String arrival,
	            @RequestParam("arrivalDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
	        List<Trip> trips = tripService.searchTrips(departure, arrival, date);
	        
	        if (trips.isEmpty()) {
	            return ResponseEntity.notFound().build();
	        } else {
	            return ResponseEntity.ok(trips);
	        }
	    }
	
}
