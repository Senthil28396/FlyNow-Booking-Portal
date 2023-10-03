package com.springsecurity.entity;


import java.sql.Timestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Reservation {
	@Id
	@GeneratedValue
	private int id;

	private int numberOfPassangers;
	private Timestamp bookedAt;
	private Timestamp cancelledAt;
	private boolean status;
	private String paymentStatus;
	private String paymentMode;
	private String transactionId;
	private int totalPrice;
	@ManyToOne
	@JoinColumn(name = "passenger_id")
	private Passanger passenger;
	
	 @ManyToOne
	 @JoinColumn(name = "trip_id")
	 private Trip trip;
	
	public Reservation() {
		super();
	}

	public Reservation(int id, int numberOfPassangers, Timestamp bookedAt, Timestamp cancelledAt, boolean status,
			String paymentStatus, String paymentMode, String transactionId, int totalPrice) {
		super();
		this.id = id;
		this.numberOfPassangers = numberOfPassangers;
		this.bookedAt = bookedAt;
		this.cancelledAt = cancelledAt;
		this.status = status;
		this.paymentStatus = paymentStatus;
		this.paymentMode = paymentMode;
		this.transactionId = transactionId;
		this.totalPrice = totalPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumberOfPassangers() {
		return numberOfPassangers;
	}

	public void setNumberOfPassangers(int numberOfPassangers) {
		this.numberOfPassangers = numberOfPassangers;
	}

	public Timestamp getBookedAt() {
		return bookedAt;
	}

	public void setBookedAt(java.sql.Timestamp timestamp) {
		this.bookedAt = timestamp;
	}

	public Timestamp getCancelledAt() {
		return cancelledAt;
	}

	public void setCancelledAt(Timestamp cancelledAt) {
		this.cancelledAt = cancelledAt;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Passanger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passanger passenger) {
		this.passenger = passenger;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

}
