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

import com.example.demo.models.Chambre;
import com.example.demo.models.Hotel;
import com.example.demo.repositery.ChambreRepositery;
import com.example.demo.repositery.HotelRepositery;



@RestController
@RequestMapping(path="/chambre")
@CrossOrigin("*")
public class ChambreController {
	@Autowired 
	private ChambreRepositery chambrerepo ; 
	@Autowired
	private HotelRepositery hotelrepo ; 
	
	
	@GetMapping("/getbyhotel/{id}")
	public List<Chambre> getbyhotels(@PathVariable Long id){
		 return this.chambrerepo.listebyhotel(id) ; 
	}
	
	@PostMapping("/create/{idhotels}")
	public Chambre createhotel(@PathVariable Long idhotels , @RequestBody Chambre chambre) {
		
		Hotel h = hotelrepo.findById(idhotels).orElse(null) ; 
		chambre.setHotels(h) ; 
		return chambrerepo.save(chambre) ; 
	}
	
	@DeleteMapping("/delete/{id}")
	public void dellete(@PathVariable Long id) {
		Chambre b = chambrerepo.findById(id).orElse(null) ; 
		chambrerepo.delete(b) ; 
	}
	
	@PutMapping("/modifier/{id}")
	public Chambre modifierchambre (@PathVariable Long id , @RequestBody Chambre chambre) {
		Chambre oldchambre = chambrerepo.findById(id).orElse(null) ; 
		chambre.setId(id) ; 
		chambre.setNblit(chambre.getNblit()==null?oldchambre.getNblit():chambre.getNblit()) ; 
	chambre.setHotels(chambre.getHotels()==null?oldchambre.getHotels():chambre.getHotels()) ; 
		chambre.setReservchambres(chambre.getReservchambres()==null?oldchambre.getReservchambres():chambre.getReservchambres()) ; 
		chambre.setTarif(chambre.getTarif()==null?oldchambre.getTarif():chambre.getTarif()) ; 
		chambre.setTypelogement(chambre.getTypelogement()==null?oldchambre.getTypelogement():chambre.getTypelogement()) ; 
		return chambrerepo.saveAndFlush(chambre) ; 
		
	}
	@GetMapping("/getbyid/{id}")
	public Chambre getbyid(@PathVariable Long id) {
		return this.chambrerepo.findById(id).orElse(null) ; 
				}

}
