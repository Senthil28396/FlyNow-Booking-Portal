
package com.airline.ticketbooking.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Role {

	@Id
	@GeneratedValue
	private int id;
	private String role;

	@JsonIgnore
	@ManyToMany(mappedBy = "roles")
	private Set<Passanger> passanger;

	public Role(int id, String role) {
		super();
		this.id = id;
		this.role = role;
	}

	public Role() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<Passanger> getPassanger() {
		return passanger;
	}

	public void setPassanger(Set<Passanger> passanger) {
		this.passanger = passanger;
	}
}
