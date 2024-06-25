package com.example.demo.repositery;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Users;

@Repository
public interface UsersRepositery extends JpaRepository<Users, Long>{

	
	  @Query("SELECT auth FROM Users auth where auth.email = ?1 and auth.motpasse = ?2 ")
	    Users authentification(String email, String password);
}
