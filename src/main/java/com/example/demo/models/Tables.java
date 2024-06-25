package com.example.demo.models;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Tables implements Serializable {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id ; 
	private Long nbchaise ;
	private String nom ; 
	
	
	
	
	
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getNbchaise() {
		return nbchaise;
	}
	public void setNbchaise(Long nbchaise) {
		this.nbchaise = nbchaise;
	} 
	@ManyToOne
 @JoinColumn(name="restaurantid")
	private Restaurant restaurant ;
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}	
	@OneToMany(mappedBy = "tables" , cascade = CascadeType.ALL)
	private List<ReservTable> reservtables ;
	@JsonIgnore
	public List<ReservTable> getReservtables() {
		return reservtables;
	}
	public void setReservtables(List<ReservTable> reservtables) {
		this.reservtables = reservtables;
	}
	public Tables() {
		super();
	} 
	
	

	
}
