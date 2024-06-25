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
public class Hotel implements Serializable {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id ; 
    private String libelle ; 
    private String adresse ; 
    private Long nb_etoile ; 
    private String ambiance ; 
    private String capacite ; 
    private Long tarif ;
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
	public Long getNb_etoile() {
		return nb_etoile;
	}
	public void setNb_etoile(Long nb_etoile) {
		this.nb_etoile = nb_etoile;
	}
	public String getAmbiance() {
		return ambiance;
	}
	public void setAmbiance(String ambiance) {
		this.ambiance = ambiance;
	}
	public String getCapacite() {
		return capacite;
	}
	public void setCapacite(String capacite) {
		this.capacite = capacite;
	}
	public Long getTarif() {
		return tarif;
	}
	public void setTarif(Long tarif) {
		this.tarif = tarif;
	} 
    
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
	private List<ImageHotel> images ;
	@JsonIgnore
	public List<ImageHotel> getImages() {
		return images;
	}
	public void setImages(List<ImageHotel> images) {
		this.images = images;
	} 
	
    
	
	@OneToMany(mappedBy = "hotels" , cascade = CascadeType.ALL)
	private List<Chambre> chambres ;
	@JsonIgnore
	public List<Chambre> getChambres() {
		return chambres;
	}
	public void setChambres(List<Chambre> chambres) {
		this.chambres = chambres;
	}
	
	
	@ManyToOne
	 @JoinColumn(name="responsableid")
	private ResponsableHotel responsablehotel ;
	public ResponsableHotel getResponsablehotel() {
		return responsablehotel;
	}
	public void setResponsablehotel(ResponsableHotel responsablehotel) {
		this.responsablehotel = responsablehotel;
	}
	public Hotel() {
		super();
	} 
	
	
	
	@OneToMany(mappedBy = "hotel" , cascade = CascadeType.ALL)
	  private List<ReserbChambre> reservchambre  ;
	@JsonIgnore
	public List<ReserbChambre> getReservchambre() {
		return reservchambre;
	}
	public void setReservchambre(List<ReserbChambre> reservchambre) {
		this.reservchambre = reservchambre;
	}
	
	
    
}
