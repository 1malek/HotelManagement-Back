package com.example.demo.models;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ReserbChambre implements Serializable {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id ; 
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date datedebut ; 
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date datefin ; 
	private int dureesejour ; 
	private int nbpersonne ; 
	private int nbchambre ;
	private int somme ; 
	
	public int getSomme() {
		return somme;
	}
	public void setSomme(int somme) {
		this.somme = somme;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDatedebut() {
		return datedebut;
	}
	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}
	public Date getDatefin() {
		return datefin;
	}
	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}
	public int getDureesejour() {
		return dureesejour;
	}
	public void setDureesejour(int dureesejour) {
		this.dureesejour = dureesejour;
	}
	public int getNbpersonne() {
		return nbpersonne;
	}
	public void setNbpersonne(int nbpersonne) {
		this.nbpersonne = nbpersonne;
	}
	public int getNbchambre() {
		return nbchambre;
	}
	public void setNbchambre(int nbchambre) {
		this.nbchambre = nbchambre;
	} 
	
	@ManyToOne
	 @JoinColumn(name="clientid")
		private Client clientreserv ;

	public Client getClientreserv() {
		return clientreserv;
	}
	public void setClientreserv(Client clientreserv) {
		this.clientreserv = clientreserv;
	}

	@ManyToOne
	 @JoinColumn(name="chambreid")
	private Chambre chambres ;
	public Chambre getChambres() {
		return chambres;
	}
	public void setChambres(Chambre chambres) {
		this.chambres = chambres;
	}
	public ReserbChambre() {
		super();
	} 
	
	
	
	
	@ManyToOne
	 @JoinColumn(name="hotelid")
		private Hotel hotel ;
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	

	
	
	
	
	
	
}
