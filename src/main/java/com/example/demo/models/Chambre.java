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
public class Chambre implements Serializable {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id ; 
	private String typelogement ; 
	private Long nblit ; 
	private Long tarif ;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTypelogement() {
		return typelogement;
	}
	public void setTypelogement(String typelogement) {
		this.typelogement = typelogement;
	}
	public Long getNblit() {
		return nblit;
	}
	public void setNblit(Long nblit) {
		this.nblit = nblit;
	}
	public Long getTarif() {
		return tarif;
	}
	public void setTarif(Long tarif) {
		this.tarif = tarif;
	} 
	

	@ManyToOne
 @JoinColumn(name="hotelid")
	private Hotel hotels ;
	public Hotel getHotels() {
		return hotels;
	}
	public void setHotels(Hotel hotels) {
		this.hotels = hotels;
	} 
	
	

	@OneToMany(mappedBy = "chambres", cascade = CascadeType.ALL)
	private List<ReserbChambre> reservchamb ;
	@JsonIgnore
	public List<ReserbChambre> getReservchambres() {
		return reservchamb;
	}

	public void setReservchambres(List<ReserbChambre> reservchambres) {
		this.reservchamb = reservchambres;
	}
	public Chambre() {
		super();
	} 
	
	
}
