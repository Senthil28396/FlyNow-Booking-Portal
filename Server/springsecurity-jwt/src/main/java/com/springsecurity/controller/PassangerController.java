package com.springsecurity.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.dto.AuthRequest;
import com.springsecurity.entity.Passanger;
import com.springsecurity.exception.PassangerNotFoundException;
import com.springsecurity.repository.PassangersRepository;
import com.springsecurity.service.JwtService;
import com.springsecurity.service.PassangerService;

@RestController
@RequestMapping("/passangers")
@CrossOrigin(origins="http://localhost:3000")
public class PassangerController {

	@Autowired
	PassangerService passangerService;

	@Autowired
	PassangersRepository passangerRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/signup")
	public String addPassanger(@RequestBody Passanger passanger) {
		String encodedPassword = passwordEncoder.encode(passanger.getPassword());
		passanger.setPassword(encodedPassword);
		passangerRepository.save(passanger);
		return "Signup successfully";
	}

	@GetMapping("/get")
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<Passanger> getAllPassangers() throws PassangerNotFoundException {
		return passangerService.getAllPassengers();
	}

	@PostMapping("/login")
	public Map<String, Object> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
	    Authentication authentication = authenticationManager.authenticate(
	            new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
	    String email=authRequest.getEmail();
	    Passanger passanger=passangerRepository.findByEmail(email);
	    	Long id=passanger.getId();
	    	System.out.println(id);
	    
	    if (authentication.isAuthenticated()) {
	        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	        
	        // Check the user's roles to determine if they are an admin
	        boolean isAdmin = userDetails.getAuthorities().stream()
	                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ADMIN"));
	       
	        // Generate a JWT token
	        String token = jwtService.generateToken(authRequest.getEmail());
	        
	        // Create a response map with token and isAdmin flag
	        Map<String, Object> response = new HashMap<>();
	        response.put("token", token);
	        response.put("isAdmin", isAdmin);
	        response.put("id", id);
	        
	        return response;
	    } else {
	        throw new UsernameNotFoundException("Invalid user request!");
	    }
	}


	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
	public Passanger getPassanger(@PathVariable long id) throws PassangerNotFoundException {
		return passangerService.getPassanger(id);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('USER')")
	public String updatePassanger(@RequestBody Passanger passanger, @PathVariable long id)
			throws PassangerNotFoundException {
		passangerService.updatePassanger(passanger, id);
		return "updated successfully";
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('USER')")
	public String deletePassanger(@PathVariable long id) throws PassangerNotFoundException {
		passangerService.deletePassanger(id);
		return "Successfully Deleted Passanger record";
	}
	
	
}
