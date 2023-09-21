package com.airline.ticketbooking.model;

import java.security.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
@Entity
public class Trip {
	
	@Id
	@GeneratedValue
	private int id;
	private String departure;
	private String arrival;
	private LocalDate depatureDate;
	private LocalDate arrivalDate;
	private LocalTime depatureTime;
	private LocalTime arrivalTime;
	private String duration;
	private int availableSeats;
	private boolean status;
	private int pricePerSeat;
	private Timestamp createAt;
	
	public Trip() {
		super();
	}
	
	public Trip(int id, String departure, String arrival, LocalDate depatureDate, LocalDate arrivalDate,
			LocalTime depatureTime, LocalTime arrivalTime, String duration, int availableSeats, boolean status,
			int pricePerSeat, Timestamp createAt) {
		super();
		this.id = id;
		this.departure = departure;
		this.arrival = arrival;
		this.depatureDate = depatureDate;
		this.arrivalDate = arrivalDate;
		this.depatureTime = depatureTime;
		this.arrivalTime = arrivalTime;
		this.duration = duration;
		this.availableSeats = availableSeats;
		this.status = status;
		this.pricePerSeat = pricePerSeat;
		this.createAt = createAt;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public LocalDate getDepatureDate() {
		return depatureDate;
	}
	public void setDepatureDate(LocalDate depatureDate) {
		this.depatureDate = depatureDate;
	}
	public LocalDate getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public LocalTime getDepatureTime() {
		return depatureTime;
	}
	public void setDepatureTime(LocalTime depatureTime) {
		this.depatureTime = depatureTime;
	}
	public LocalTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getPricePerSeat() {
		return pricePerSeat;
	}
	public void setPricePerSeat(int pricePerSeat) {
		this.pricePerSeat = pricePerSeat;
	}
	public Timestamp getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}
	
}
