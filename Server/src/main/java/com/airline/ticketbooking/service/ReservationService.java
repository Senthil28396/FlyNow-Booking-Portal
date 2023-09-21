package com.airline.ticketbooking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.ticketbooking.exceptions.ReservationNotFoundException;
import com.airline.ticketbooking.model.Reservation;
import com.airline.ticketbooking.repository.ReservationRepository;

@Service
public class ReservationService {

	@Autowired
    ReservationRepository reservationRepository;

	 public void saveReservation(Reservation reservation) {
	         reservationRepository.save(reservation);
	    }
	 
    public List<Reservation> getAllReservations() {
      
		List<Reservation> reservation = reservationRepository.findAll();

		if (reservation.size() > 0) {
			return reservation;
		} 
		else {
			return new ArrayList<Reservation>();
		}
	}


    public Reservation getReservationById(int id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);

		if (reservation.isPresent()) {
			return reservation.get();
		} 
		else {
			throw new ReservationNotFoundException("No Reservation record exist for given id"+id);
		}
    }

    public List<Reservation> getReservationsByPassengerId(int passanger) {
        return reservationRepository.findByPassanger(passanger);
    }

    public void deleteReservation(int id) {
    	reservationRepository.deleteById(id);
    }

}
