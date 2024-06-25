package com.example.demo.repositery;




import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.ImageHotel;


@Repository
public interface ImageRepositery extends JpaRepository<ImageHotel, Long> {
	
	
	 
     @Query("SELECT m FROM ImageHotel m where m.hotel.id= ?1 ")
	    List<ImageHotel> listebyhotel(Long id);
	
	

}
