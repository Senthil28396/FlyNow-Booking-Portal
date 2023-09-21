package com.airline.ticketbooking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airline.ticketbooking.model.Passanger;
@Repository
public interface PassangerRepository extends JpaRepository<Passanger, Long> {
	
    List<Passanger> findByEmail(String email);

    Passanger getByEmail(String email);

    Passanger findByToken(String token);

	Optional<Passanger> findByName(String username);
}
