package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Users;
import com.example.demo.repositery.UsersRepositery;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UsersController {
	
	@Autowired
	private UsersRepositery userrepo ; 
	
	
	  @PostMapping("/authentification")
	    public ResponseEntity authentification(@RequestBody Users acteur) {
	        Users a = this.userrepo.authentification(acteur.getEmail(), acteur.getMotpasse());
	        if (a == null) {
	            return new ResponseEntity(HttpStatus.BAD_REQUEST);
	        } else {
	            return new ResponseEntity(a, HttpStatus.OK);
	        }
	    }
	  @GetMapping("/findbyid/{id}")
	  public Users getbyid(@PathVariable Long id) {
		  return this.userrepo.findById(id).orElse(null) ; 
	  }


}
