package com.airline.ticketbooking.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Passanger {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String gender;
	private String phoneNumber;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	@Column(unique = true,nullable = false)
	private String email;
	private int age;
	@Column(unique = true)
	private String passportNumber;
	private String nationality;
	@JsonIgnore
	private String token;
	
	@JsonIgnore
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime tokenCreationDate;
	
	//@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "passanger_role", joinColumns = @JoinColumn(name = "passanger_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	@OneToMany(mappedBy = "passanger")
	private List<Reservation> reservation;
	
	public Passanger(Long id, String name, String gender, String phoneNumber, String password, String email, int age,
			String passportNumber, String nationality) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.email = email;
		this.age = age;
		this.passportNumber = passportNumber;
		this.nationality = nationality;
	}

	public Passanger() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LocalDateTime getTokenCreationDate() {
		return tokenCreationDate;
	}

	public void setTokenCreationDate(LocalDateTime tokenCreationDate) {
		this.tokenCreationDate = tokenCreationDate;
	}
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public List<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}

	public void addRoles(Role role) {
		this.roles.add(role);
		role.getPassanger().add(this);
	}	
	
	public void removeRole(Role role) {
		this.getRoles().remove(role);
		role.getPassanger().remove(this);
	}

	public void removeRoles() {
		for (Role role : new HashSet<>(roles)) {
			removeRole(role);
		}
	}
	
    public void addReservation(Reservation review) {
        this.reservation.add(review);
        review.setPassanger(this);
    }


}
