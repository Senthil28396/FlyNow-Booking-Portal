package com.airline.ticketbooking.model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Flight {
	@Id
	@GeneratedValue
	private int id;
	@Column(nullable = false,unique = true)
	private String flightNumber;
	private String flightName;
	private String flightType;// international or domestic
	private String source;
	private String destination;
	private LocalDate depatureDate;
	private LocalDate arrivalDate;
	private LocalTime depatureTime;
	private LocalTime arrivalTime;
	private String duration;
	private int availableSeats;

	public Flight(int id,String flightNumber, String flightName, String flightType, String source, String destination,
			LocalDate depatureDate, LocalDate arrivalDate, String duration, LocalTime depatureTime, LocalTime arrivalTime,
			int availableSeats) {
		super();
		this.id=id;
		this.flightNumber = flightNumber;
		this.flightName = flightName;
		this.flightType = flightType;
		this.source = source;
		this.destination = destination;
		this.depatureDate = depatureDate;
		this.arrivalDate = arrivalDate;
		this.duration = duration;
		this.depatureTime = depatureTime;
		this.arrivalTime = arrivalTime;
		this.availableSeats = availableSeats;
	}

	public Flight() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getFlightType() {
		return flightType;
	}

	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
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

	public String getDuration() {
		return duration;
	}

	public void setDuration(String difference) {
		this.duration = difference;
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

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

}
