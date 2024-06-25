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

import com.example.demo.models.ResponsableHotel;
import com.example.demo.repositery.ResponsableHotelRepo;

@RestController
@RequestMapping("/responsablehotel")
@CrossOrigin("*")
public class ResponsableHotelController {
	
	@Autowired
	private ResponsableHotelRepo responHotelRepo ; 
	
	
	@PostMapping("/create")
	public ResponsableHotel create (@RequestBody ResponsableHotel reshotel ) {
		return responHotelRepo.save(reshotel)	 ; 
		}
	
	@GetMapping("/findall")
	public List<ResponsableHotel> findall(){
		return responHotelRepo.findAll() ; 
	}
	@GetMapping("/getbyid/{id}")
	public ResponsableHotel getbyid(@PathVariable Long id) {
		return this.responHotelRepo.findById(id).orElse(null)  ; 
	}
	@PutMapping("/update/{id}")
	public ResponsableHotel updaterespo (@PathVariable Long id , @RequestBody ResponsableHotel respohotel) {
		respohotel.setId(id) ; 
		ResponsableHotel oldrespo = this.responHotelRepo.findById(id).orElse(null) ;
		respohotel.setNom(respohotel.getNom()==null?oldrespo.getNom():respohotel.getNom()) ; 
		respohotel.setPrenom(respohotel.getPrenom()==null?oldrespo.getPrenom():respohotel.getPrenom()) ; 
		respohotel.setTelephone(respohotel.getTelephone()==null?oldrespo.getTelephone():respohotel.getTelephone()) ;
		respohotel.setEmail(respohotel.getEmail()==null?oldrespo.getEmail():respohotel.getEmail()) ; 
		respohotel.setRole(respohotel.getRole()==null?oldrespo.getRole():respohotel.getRole()) ; 
		respohotel.setMotpasse(respohotel.getMotpasse()==null?oldrespo.getMotpasse():respohotel.getMotpasse()) ;
		respohotel.setHotel(respohotel.getHotel()==null?oldrespo.getHotel():respohotel.getHotel()) ; 
		
		
		
		
		return this.responHotelRepo.saveAndFlush(respohotel) ; 
		}
 
}
