package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Admin;
import com.example.demo.models.ResponsableRestau;
import com.example.demo.repositery.ResponsableRestauRepo;

@RestController
@RequestMapping("/responsableresto")
@CrossOrigin("*")
public class ResponsableRestoController {
	
	
	@Autowired
	private ResponsableRestauRepo responrestoRepo ; 
	
	
	@PostMapping("/create")
	public ResponsableRestau create(@RequestBody ResponsableRestau resporesto) {
		return responrestoRepo.save(resporesto) ; 
	}
	
	@GetMapping("/findall")
	public List<ResponsableRestau> findall(){
		return responrestoRepo.findAll() ; 
	}
	@GetMapping("/findbyid/{id}")
	public ResponsableRestau getbyid(@PathVariable Long id) {
		return this.responrestoRepo.findById(id).orElse(null) ; 
	}
	
	@PutMapping("/update/{id}")
	public ResponsableRestau update(@PathVariable Long id ,@RequestBody ResponsableRestau resporestau) {
		
		resporestau.setId(id) ; 
		
		ResponsableRestau oldrespo = responrestoRepo.findById(id).orElse(null) ; 
	
		resporestau.setNom(resporestau.getNom()==null?oldrespo.getNom():resporestau.getNom()) ; 
		resporestau.setPrenom(resporestau.getPrenom()==null?oldrespo.getPrenom():resporestau.getPrenom()) ; 
		resporestau.setTelephone(resporestau.getTelephone()==null?oldrespo.getTelephone():resporestau.getTelephone()) ;
		resporestau.setEmail(resporestau.getEmail()==null?oldrespo.getEmail():resporestau.getEmail()) ; 
		resporestau.setRole(resporestau.getRole()==null?oldrespo.getRole():resporestau.getRole()) ; 
		resporestau.setMotpasse(resporestau.getMotpasse()==null?oldrespo.getMotpasse():resporestau.getMotpasse()) ; 
		resporestau.setRestaurants(resporestau.getRestaurants()==null?oldrespo.getRestaurants():resporestau.getRestaurants()) ;
		return responrestoRepo.saveAndFlush(resporestau) ; 
	}
}
