package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Restaurant;
import com.example.demo.models.Tables;
import com.example.demo.repositery.RestaurantRepositery;
import com.example.demo.repositery.TablesRepositery;

import jakarta.persistence.Table;

@RestController
@RequestMapping("/table")
@CrossOrigin("*")

public class TablesController {
	
	@Autowired
	private TablesRepositery tablesrepo ; 
	
	@Autowired
	private RestaurantRepositery restorepo ; 
	
	
	
	@PostMapping("/add/{idresto}")
	public Tables createtable(@PathVariable Long  idresto , @RequestBody Tables t) {
		Restaurant r = this.restorepo.findById(idresto).orElse(null) ; 
		t.setRestaurant(r) ; 
		
		return this.tablesrepo.save(t) ; 
	}
	
	@GetMapping("/byresto/{idresto}")
	public List<Tables> findbyresto(@PathVariable Long idresto ) {
		return this.tablesrepo.listbyresto(idresto) ; 
	}
	
	@DeleteMapping("/delete/{id}")
	public void delte(@PathVariable Long id) {
		
		Tables t = this.tablesrepo.findById(id).orElse(null) ; 
		this.tablesrepo.delete(t) ; 
	
		
	}
	@PutMapping("/modifier/{id}")
	public Tables modifier(@PathVariable Long id , @RequestBody Tables table) {
		table.setId(id) ; 
		Tables oldtable = this.tablesrepo.findById(id).orElse(null) ; 
		table.setNbchaise(table.getNbchaise()==null?oldtable.getNbchaise():table.getNbchaise()) ; 
		
		table.setRestaurant(table.getRestaurant()==null?oldtable.getRestaurant():table.getRestaurant()) ; 
		table.setReservtables(table.getReservtables()==null?oldtable.getReservtables():table.getReservtables()) ; 
		table.setNom(table.getNom()==null?oldtable.getNom():table.getNom()) ; 
		
		return this.tablesrepo.saveAndFlush(table) ; 
		
	}
	@GetMapping("/getbyid/{id}")
	public Tables getbyid(@PathVariable Long id) {
	return 	this.tablesrepo.findById(id).orElse(null)  ; 
	}

	@GetMapping("/getavailable/{id}")
	public List< Tables> getavalaible(@PathVariable Long id){
		 return  this.tablesrepo.getavailable(id) ; 
	}
}
