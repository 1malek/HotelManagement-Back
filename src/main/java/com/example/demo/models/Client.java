package com.example.demo.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Client extends Users{

	
	
	
	@OneToMany(mappedBy = "client")
	private List<ReservTable> resertables ;
     @JsonIgnore
	public List<ReservTable> getResertables() {
		return resertables;
	}

	public void setResertables(List<ReservTable> resertables) {
		this.resertables = resertables;
	} 
	
	

	@OneToMany(mappedBy = "clientreserv")
	private List<ReserbChambre> reservchambres ;
	@JsonIgnore
	public List<ReserbChambre> getReservchambres() {
		return reservchambres;
	}

	public void setReservchambres(List<ReserbChambre> reservchambres) {
		this.reservchambres = reservchambres;
	}

	public Client() {
		super();
	} 
    
	
	
}