package com.example.demo.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ReservTable implements Serializable {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id ; 
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate  date ; 
	
	
	private LocalTime heurereserv;  ;
	
	
	
	
	public LocalTime getHeurereserv() {
		return heurereserv;
	}
	public void setHeurereserv(LocalTime heurereserv) {
		this.heurereserv = heurereserv;
	}
	public Restaurant getRestaurants() {
		return restaurants;
	}
	public void setRestaurants(Restaurant restaurants) {
		this.restaurants = restaurants;
	}

	private int nbperssonne ; 
	private String nbtable ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getNbperssonne() {
		return nbperssonne;
	}
	public void setNbperssonne(int nbperssonne) {
		this.nbperssonne = nbperssonne;
	}
	public String getNbtable() {
		return nbtable;
	}
	public void setNbtable(String nbtable) {
		this.nbtable = nbtable;
	} 

	@ManyToOne
	 @JoinColumn(name="clientid")
	private Client client ;
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	} 
	
	
	@ManyToOne
	 @JoinColumn(name="tablesid")
	private Tables tables ;
	public Tables getTables() {
		return tables;
	}
	public void setTables(Tables tables) {
		this.tables = tables;
	}
	public ReservTable() {
		super();
	} 
	
	
	@ManyToOne
 @JoinColumn(name="restaurantid")
	private Restaurant restaurants ;
	public Restaurant getRestaurant() {
		return restaurants;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurants = restaurant;
	}
	
	
}
