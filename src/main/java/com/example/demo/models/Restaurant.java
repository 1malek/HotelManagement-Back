package com.example.demo.models;

import java.io.Serializable;

import java.sql.Date;
import java.time.LocalTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

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
public class Restaurant implements Serializable {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id ; 
	private String libelle ; 
	private String adresse ; 
	private String typeambiance ; 
	
	private LocalTime  heureouvert ; 

	private LocalTime heureclosed ;
	private String capacite ; 
	private String typecuisine ; 
	private String photomenu ;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTypeambiance() {
		return typeambiance;
	}
	public void setTypeambiance(String typeambiance) {
		this.typeambiance = typeambiance;
	}
	public LocalTime getHeureouvert() {
		return heureouvert;
	}
	public void setHeureouvert(LocalTime heureouvert) {
		this.heureouvert = heureouvert;
	}
	public LocalTime getHeureclosed() {
		return heureclosed;
	}
	public void setHeureclosed(LocalTime heureclosed) {
		this.heureclosed = heureclosed;
	}
	public String getCapacite() {
		return capacite;
	}
	public void setCapacite(String capacite) {
		this.capacite = capacite;
	}
	public String getTypecuisine() {
		return typecuisine;
	}
	public void setTypecuisine(String typecuisine) {
		this.typecuisine = typecuisine;
	}
	public String getPhotomenu() {
		return photomenu;
	}
	public void setPhotomenu(String photomenu) {
		this.photomenu = photomenu;
	} 
	
	
	@ManyToOne()
 @JoinColumn(name="responsableid")
	  private ResponsableRestau responsablerestau ;
	public ResponsableRestau getResponsablerestau() {
		return responsablerestau;
	}
	public void setResponsablerestau(ResponsableRestau responsablerestau) {
		this.responsablerestau = responsablerestau;
	} 
	
	@OneToMany(mappedBy = "restaurant" , cascade = CascadeType.ALL)
	  private List<Tables> tables  ;
	
	@JsonIgnore
	public List<Tables> getTables() {
		return tables;
	}

	public void setTables(List<Tables> tables) {
		this.tables = tables;
	}
	public Restaurant() {
		super();
	}
	  
	@OneToMany(mappedBy = "restaurants" , cascade = CascadeType.ALL)
	  private List<ReservTable> reservtables ;
	@JsonIgnore
	public List<ReservTable> getReservtables() {
		return reservtables;
	}
	public void setReservtables(List<ReservTable> reservtables) {
		this.reservtables = reservtables;
	} 
	
	  
}
