package com.springsecurity.service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.springsecurity.entity.Passanger;
import com.springsecurity.entity.Reservation;
import com.springsecurity.entity.Trip;
import com.springsecurity.exception.PassangerNotFoundException;
import com.springsecurity.exception.ReservationNotFoundException;
import com.springsecurity.repository.PassangersRepository;
import com.springsecurity.repository.ReservationRepository;
import com.springsecurity.repository.TripRepository;

@Service
public class ReservationService {

	@Autowired
	ReservationRepository reservationRepository;

	@Autowired
	TripRepository tripRepository;
	
	@Autowired
	PassangersRepository passangersRepository;
	
	public void saveReservation(Reservation reservation) throws PassangerNotFoundException {
      

	    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

	    Passanger passenger = passangersRepository.findByEmail(userDetails.getUsername());

	    if (passenger != null) {
	        reservation.setPassenger(passenger);
	        
	        Trip trip = tripRepository.findById(reservation.getTrip().getId());

	        if (trip != null) {
	            int pricePerSeat = trip.getPricePerSeat();
	            int numberOfPassengers = reservation.getNumberOfPassangers();
	            int totalPrice = pricePerSeat * numberOfPassengers;
	            reservation.setTotalPrice(totalPrice);

	            int remainingSeats = trip.getAvailableSeats() - numberOfPassengers;
	            if (remainingSeats < 0) {
	                throw new ReservationNotFoundException("Not enough available seats for this reservation.");
	            }

	            trip.setAvailableSeats(remainingSeats);
	            LocalDate now=LocalDate.now();
	            reservation.setBookedAt(now);
	            reservationRepository.save(reservation);
	            tripRepository.save(trip);
	        } else {
	            throw new ReservationNotFoundException("Trip not found.");
	        }
	    } else {
	        throw new PassangerNotFoundException("Passenger not found.");
	    }
	}

	
	public List<Reservation> getAllReservations() {

		List<Reservation> reservation = reservationRepository.findAll();

		if (reservation.size() > 0) {
			return reservation;
		} else {
			return new ArrayList<Reservation>();
		}
	}

	public Reservation getReservationById(int id) {

		Optional<Reservation> reservation = reservationRepository.findById(id);

		if (reservation.isPresent()) {
			return reservation.get();
		} else {
			throw new ReservationNotFoundException("No Reservation record exist for given  id" + id);

		}
	}


	public List<Reservation> getReservationsByPassengerId(Long passengerId) {
        if (passangersRepository.findById(passengerId).isPresent()) {
            return reservationRepository.findByPassengerId(passengerId);
        } else {
            return new ArrayList<>();
        }
    }

	public void deleteReservation(int id) {

		reservationRepository.deleteById(id);

	}


	public Reservation updateReservationById(int id) {
	    Optional<Reservation> reservationOptional = reservationRepository.findById(id);

	    if (reservationOptional.isPresent()) {
	        Reservation reservation = reservationOptional.get();

	        if (reservation.isStatus()) {
	            reservation.setStatus(false);

	            LocalDate now=LocalDate.now();
	            reservation.setCancelledAt(now);
	            Trip trip = reservation.getTrip();
	            if (trip != null) {
	                int numberOfPassengers = reservation.getNumberOfPassangers();
	                int updatedAvailableSeats = trip.getAvailableSeats() + numberOfPassengers;
	                trip.setAvailableSeats(updatedAvailableSeats);
	                tripRepository.save(trip);
	            }

	            return reservationRepository.save(reservation);
	        } else {
	            throw new ReservationNotFoundException("Reservation is already canceled.");
	        }
	    } else {
	        throw new ReservationNotFoundException("Reservation not found.");
	    }
	}

}
