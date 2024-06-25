package com.example.demo.repositery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Chambre;
import com.example.demo.models.Tables;

@Repository
public interface ChambreRepositery extends JpaRepository<Chambre, Long> {
	
	
	 @Query("SELECT m FROM Chambre m where m.hotels.id= ?1 ")
	    List<Chambre> listebyhotel(Long restoid);
	 

}
