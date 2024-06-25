package com.example.demo.repositery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.ReservTable;
import com.example.demo.models.Tables;

@Repository
public interface ReservTableRepositery extends JpaRepository<ReservTable, Long>{
	 @Query("SELECT m FROM ReservTable m where m.client.id= ?1 ")
	    List<ReservTable> listebyclient(Long idclient);
	 
	 
	 
 @Query("SELECT m FROM ReservTable m where m.restaurants.id= ?1 ")
	    List<ReservTable> listebytables(Long idtable);
	 
	 
	 @Query("SELECT m FROM ReservTable m WHERE m.restaurants.id = ?1 AND (DATE(m.date) <> CURRENT_DATE OR m.date IS NULL)")
	 List<ReservTable> getAvailableTables(Long idTable);

	 
 @Query("SELECT m FROM ReservTable m where m.restaurants.responsablerestau.id= ?1 ")
	    List<ReservTable> listereservbyresto(Long id);

}
