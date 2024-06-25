package com.example.demo.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class ResponsableRestau extends Users {

	
	
	
	  @OneToMany(mappedBy = "responsablerestau" , cascade = CascadeType.ALL)
	  private List<Restaurant> restaurants ;
      @JsonIgnore
	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

	public ResponsableRestau() {
		super();
	} 
	
	

	
	  
	
	
	
	  
}
