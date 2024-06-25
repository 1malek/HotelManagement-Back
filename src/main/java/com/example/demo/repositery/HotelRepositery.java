package com.example.demo.repositery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Hotel;
import com.example.demo.models.ImageHotel;
import com.example.demo.models.Restaurant;

@Repository
public interface HotelRepositery extends JpaRepository<Hotel, Long>{
	@Query("SELECT m FROM Hotel m where m.responsablehotel.id = ?1 ")
    List<Hotel> listbyrespo(Long respoid);
	 
	 @Query("SELECT m FROM Hotel m where m.ambiance = ?1 ")
	    List<Hotel> listebyambiance(String ambiance);
	 
	 @Query("SELECT m FROM Hotel m where m.nb_etoile = ?1 ")
	    List<Hotel> listebyetoile(Long nbetoile);
	 
	 
	 @Query("SELECT m FROM Hotel m where m.adresse = ?1 ")
	    List<Hotel> listebyadresse(String adresse);
	 
	 
	 
	 
	
}
