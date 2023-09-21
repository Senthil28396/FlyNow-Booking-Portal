package com.airline.ticketbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airline.ticketbooking.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

	List<Reservation> findByPassanger(int passanger);

}
