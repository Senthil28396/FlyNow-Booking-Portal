package com.airline.ticketbooking.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Cancellation {
	@Id
	@GeneratedValue
	private Long cancellationNumber;
	private LocalDateTime cancellationDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="reservation_id")
	private Reservation reservation;
	
	public Cancellation(Long cancellationNumber, LocalDateTime cancellationDate) {
		super();
		this.cancellationNumber = cancellationNumber;
		this.cancellationDate = cancellationDate;
	}

	public Cancellation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getCancellationNumber() {
		return cancellationNumber;
	}

	public void setCancellationNumber(Long cancellationNumber) {
		this.cancellationNumber = cancellationNumber;
	}

	public LocalDateTime getCancellationDate() {
		return cancellationDate;
	}

	public void setCancellationDate(LocalDateTime cancellationDate) {
		this.cancellationDate = cancellationDate;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	

	}
