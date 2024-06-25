package com.example.demo.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class ResponsableHotel extends Users {
	
	

	  @OneToMany(mappedBy = "responsablehotel"  , cascade = CascadeType.ALL)
	  private List<Hotel> hotel;
      @JsonIgnore
	public List<Hotel> getHotel() {
		return hotel;
	}

	public void setHotel(List<Hotel> hotel) {
		this.hotel = hotel;
	}

	public ResponsableHotel() {
		super();
	} 
	  
	  
	  
   

}
