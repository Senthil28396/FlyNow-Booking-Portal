package com.airline.ticketbooking.model;

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
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="passanger_id")
	private Passanger passanger;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="flight_number")
	private Flight flight;
	
	private int numberOfPassangers;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="category")
	private Category category;

	public Reservation(int id, int numberOfPassangers) {
		super();
		this.id = id;
		this.numberOfPassangers = numberOfPassangers;
	}

	public Reservation() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Passanger getPassanger() {
		return passanger;
	}

	public void setPassanger(Passanger passanger) {
		this.passanger = passanger;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public int getNumberOfPassangers() {
		return numberOfPassangers;
	}

	public void setNumberOfPassangers(int numberOfPassangers) {
		this.numberOfPassangers = numberOfPassangers;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
