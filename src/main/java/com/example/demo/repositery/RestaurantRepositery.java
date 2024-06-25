package com.example.demo.repositery;

import java.util.List;
import org.springframework.data.jpa.repository.Query;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Restaurant;

@Repository
public interface RestaurantRepositery extends JpaRepository<Restaurant, Long> {
	
	 @Query("SELECT m FROM Restaurant m where m.responsablerestau.id = ?1 ")
	    List<Restaurant> listbyrespo(Long respoid);
	 @Query("SELECT m FROM Restaurant m where m.typeambiance = ?1 ")
	    List<Restaurant> listebyambiance(String ambiance);
	 
	 @Query("SELECT m FROM Restaurant m where m.typecuisine = ?1 ")
	    List<Restaurant> listebycuisine(String cuisine);
	 
	 
	 @Query("SELECT m FROM Restaurant m where m.adresse = ?1 ")
	    List<Restaurant> listebyadresse(String adresse);

}
