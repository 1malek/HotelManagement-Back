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

import com.example.demo.models.Chambre;
import com.example.demo.models.Client;
import com.example.demo.models.Hotel;
import com.example.demo.models.ReserbChambre;
import com.example.demo.repositery.ChambreRepositery;
import com.example.demo.repositery.ClientRepositery;
import com.example.demo.repositery.HotelRepositery;
import com.example.demo.repositery.ReservChambreRepositery;

@RestController
@RequestMapping("/reservChambre")
@CrossOrigin("*")
public class ReservChambreController {
	@Autowired
	private ReservChambreRepositery reserchambrerepo ; 
	@Autowired
	private ClientRepositery clientrepo ; 
	@Autowired
	private HotelRepositery hotelrepo ; 
	@Autowired 
	private ChambreRepositery chambrerepo ; 
	
	
	
	@PostMapping("/create/{idclilent}/{idchambre}/{idhotel}")
	public ReserbChambre create(@PathVariable Long idclilent, @PathVariable Long idchambre , @PathVariable Long idhotel  , @RequestBody ReserbChambre reservation ) {
		Client c = this.clientrepo.findById(idclilent).orElse(null) ; 
		reservation.setClientreserv(c) ; 
		Chambre chambre= this.chambrerepo.findById(idchambre).orElse(null) ; 
		reservation.setChambres(chambre) ; 
		Hotel h = this.hotelrepo.findById(idhotel).orElse(null) ; 
		reservation.setHotel(h) ; 	
		return reserchambrerepo.save(reservation) ; 
	}
	@GetMapping("/getbyid/{id}")
	public ReserbChambre getbyid (@PathVariable Long id) {
		return this.reserchambrerepo.findById(id).orElse(null) ; 
	}
	@GetMapping("/byrespo/{id}")
	public List<ReserbChambre> getttbyerespo(@PathVariable Long id){
		return this.reserchambrerepo.listebyrespo(id) ; 
	}
	
	
	@GetMapping("/byclient/{id}")
	public List<ReserbChambre> byyclient(@PathVariable Long id){
		return this.reserchambrerepo.listebyclient(id) ; 
	}
	@GetMapping("/getall")
	public List<ReserbChambre> getall(){
		return this.reserchambrerepo.findAll() ; 
	}
	@PutMapping("/update/{id}")
	public ReserbChambre update(@PathVariable Long id , @RequestBody ReserbChambre reserchambre) {
		reserchambre.setId(id) ; 
		ReserbChambre oldreserv = this.reserchambrerepo.findById(id).orElse(null) ; 
		reserchambre.setChambres(reserchambre.getChambres()==null?oldreserv.getChambres(): reserchambre.getChambres()) ; 
		reserchambre.setDatedebut(reserchambre.getDatedebut()==null?oldreserv.getDatedebut(): reserchambre.getDatedebut()) ; 
		reserchambre.setDatefin(reserchambre.getDatefin()==null?oldreserv.getDatefin(): reserchambre.getDatefin()) ; 
		reserchambre.setDureesejour(reserchambre.getDureesejour()==0?oldreserv.getDureesejour(): reserchambre.getDureesejour()) ; 
		reserchambre.setNbpersonne(reserchambre.getNbpersonne()==0?oldreserv.getNbpersonne(): reserchambre.getNbpersonne()) ; 
		reserchambre.setNbchambre(reserchambre.getNbchambre()==0?oldreserv.getNbchambre(): reserchambre.getNbchambre()) ; 
		reserchambre.setSomme(reserchambre.getSomme()==0?oldreserv.getSomme(): reserchambre.getSomme()) ; 
		reserchambre.setClientreserv(reserchambre.getClientreserv()==null?oldreserv.getClientreserv(): reserchambre.getClientreserv()) ; 
		reserchambre.setHotel(reserchambre.getHotel()==null?oldreserv.getHotel(): reserchambre.getHotel()) ; 
		return this.reserchambrerepo.saveAndFlush(reserchambre) ; 
	}
	
	

}
