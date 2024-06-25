package com.example.demo.repositery;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.ReservTable;
import com.example.demo.models.Restaurant;
import com.example.demo.models.Tables;

@Repository
public interface TablesRepositery extends JpaRepository<Tables, Long>{
	
	 @Query("SELECT m FROM Tables m where m.restaurant.id= ?1 ")
	    List<Tables> listbyresto(Long restoid);
	 
	 
	 
	 


          
	 @Query("SELECT m FROM Tables m WHERE m.restaurant.id = ?1 AND (DATE(m) NOT IN (SELECT DATE(rt.date) FROM m.reservtables rt) OR m.reservtables IS EMPTY)")
	 List<Tables> getavailable(Long idTable);


}
