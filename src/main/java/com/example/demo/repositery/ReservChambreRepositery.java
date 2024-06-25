package com.example.demo.repositery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.ReserbChambre;
import com.example.demo.models.ReservTable;

@Repository
public interface ReservChambreRepositery extends JpaRepository<ReserbChambre, Long> {
	
	
	 
@Query("SELECT m FROM ReserbChambre m where m.hotel.responsablehotel.id= ?1 ")
	    List<ReserbChambre> listebyrespo(Long id);




@Query("SELECT m FROM ReserbChambre m where m.clientreserv.id= ?1 ")
	    List<ReserbChambre> listebyclient(Long id);


}
