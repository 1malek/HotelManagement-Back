package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Admin;
import com.example.demo.repositery.AdminRepositery;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(path="/admin")
@CrossOrigin("*")
public class AdminController {
	@Autowired
	private AdminRepositery adminrepo ; 
	
	
	@GetMapping("/findall")
	public List<Admin>  findall(){
		return this.adminrepo.findAll() ; 
	}
	@GetMapping("/findbyid/{id}")
	public Admin findbyid(@PathVariable Long id  ) {
		return adminrepo.findById(id).orElse(null) ;
	}

	@PostMapping("/save")
	public Admin save(@RequestBody Admin a) {
		return this.adminrepo.save(a) ; 
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		Admin a = adminrepo.findById(id).orElse(null) ;
		this.adminrepo.delete(a) ;
		
	}
	
	@PutMapping("/update/{id}")
	public Admin update(@PathVariable Long id , @RequestBody Admin admin) {
	
		admin.setId(id) ; 
		Admin oldadmin = this.adminrepo.findById(id).orElse(null) ;
		admin.setNom(admin.getNom()==null?oldadmin.getNom():admin.getNom()) ; 
		admin.setPrenom(admin.getPrenom()==null?oldadmin.getPrenom():admin.getPrenom()) ; 
		admin.setTelephone(admin.getTelephone()==null?oldadmin.getTelephone():admin.getTelephone()) ;
		admin.setEmail(admin.getEmail()==null?oldadmin.getEmail():admin.getEmail()) ; 
		admin.setRole(admin.getRole()==null?oldadmin.getRole():admin.getRole()) ; 
		admin.setMotpasse(admin.getMotpasse()==null?oldadmin.getMotpasse():admin.getMotpasse()) ; 
		
		
		
		return this.adminrepo.saveAndFlush(admin) ; 
	}
}
