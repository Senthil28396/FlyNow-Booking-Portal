package com.airline.ticketbooking.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.airline.ticketbooking.model.Passanger;
import com.airline.ticketbooking.repository.PassangerRepository;

@Component
public class PassangerUserDetailsService implements UserDetailsService {

    @Autowired
    private PassangerRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Passanger> passanger = repository.findByName(username);
        return passanger.map(PassangerUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

    }
}