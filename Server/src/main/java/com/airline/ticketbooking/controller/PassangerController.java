package com.airline.ticketbooking.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airline.ticketbooking.model.Passanger;
import com.airline.ticketbooking.model.PassangerDto;
import com.airline.ticketbooking.service.PassangerService;

@RestController
@RequestMapping("/passangers")
public class PassangerController {
	
	@Autowired
	PassangerService passangerService;
	
	@Autowired
	PasswordEncoder encoder;
	
	@PostMapping("/add")
	public String addPassanger(@RequestBody PassangerDto passanger) {
		passangerService.addPassanger(passanger);
		return "Added Passanger Details successfully";
	}
	
	@GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
	public Passanger getPassanger(@PathVariable long id)
	{
		return passangerService.getPassanger(id);
	}
	@GetMapping("/get")    
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<Passanger> getAllPassangers(){
		return passangerService.getAllPassangers();
	}
	@PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
	public String updatePassanger(@RequestBody Passanger passanger,@PathVariable long id)
	{
		passangerService.updatePassanger(passanger,id);
		return "updated successfully";
	}
	@DeleteMapping("/{id}")
    //@PreAuthorize("hasAuthority('ROLE_USER')")
	public String deletePassanger(@PathVariable long id)
	{
		passangerService.deletePassanger(id);
		return "Successfully Deleted Passanger record";
	}
	
	@PostMapping("/forgot-password")
	public String forgotPassword(@RequestParam String email) {

		String response = passangerService.forgotPassword(email);

		if (!response.startsWith("Invalid")) {
			response = "http://localhost:8080/reset-password?token=" + response;
		}
		return response;
	}

	@PutMapping("/reset-password")
	public String resetPassword(@RequestParam String token,
			@RequestParam String password) {

		return passangerService.resetPassword(token, password);
	}	 

}
