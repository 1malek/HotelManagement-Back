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

import com.example.demo.models.Hotel;
import com.example.demo.models.ResponsableHotel;
import com.example.demo.repositery.HotelRepositery;
import com.example.demo.repositery.ResponsableHotelRepo;

@RestController
@RequestMapping("/hotel")
@CrossOrigin("*")
public class HotelController {
	@Autowired
	private HotelRepositery hotelrepo ; 
	@Autowired
	private ResponsableHotelRepo respoHotRepo ; 
	 @PostMapping("/create/{idresponsable}")
    private Hotel create (@PathVariable Long idresponsable , @RequestBody Hotel hotel) {
    	
    	ResponsableHotel r = respoHotRepo.findById(idresponsable).orElse(null) ; 
    	hotel.setResponsablehotel(r) ; 
    	return hotelrepo.save(hotel) ; 
    }
    @DeleteMapping("/delete/{id}")
    public void deletehotel(@PathVariable Long id) {
    	Hotel h = this.hotelrepo.findById(id).orElse(null) ; 
    	hotelrepo.delete(h) ; 
    }
    @GetMapping("/getbyrespo/{id}")
    public List<Hotel> getbyresto(@PathVariable Long id){
    	return  this.hotelrepo.listbyrespo(id) ; 
    }
    @PutMapping("/update/{idhotel}")
    public Hotel updatehotel(@PathVariable Long idhotel ,@RequestBody Hotel hotel ) {
    	hotel.setId(idhotel)  ; 
    	Hotel oldhotel = this.hotelrepo.findById(idhotel).orElse(null) ; 
    	hotel.setLibelle(hotel.getLibelle()==null?oldhotel.getLibelle():hotel.getLibelle()) ; 
    	hotel.setAdresse(hotel.getAdresse()==null?oldhotel.getAdresse():hotel.getAdresse()) ; 
     	hotel.setAmbiance(hotel.getAmbiance()==null?oldhotel.getAmbiance():hotel.getAmbiance()) ;
     	hotel.setCapacite(hotel.getCapacite()==null?oldhotel.getCapacite():hotel.getCapacite()) ;
     	hotel.setChambres(hotel.getChambres()==null?oldhotel.getChambres():hotel.getChambres()) ;
     	hotel.setImages(hotel.getImages()==null?oldhotel.getImages():hotel.getImages()) ;
     	hotel.setNb_etoile(hotel.getNb_etoile()==null?oldhotel.getNb_etoile():hotel.getNb_etoile()) ;
     	hotel.setResponsablehotel(hotel.getResponsablehotel()==null?oldhotel.getResponsablehotel():hotel.getResponsablehotel()) ;
     	hotel.setTarif(hotel.getTarif()==null?oldhotel.getTarif():hotel.getTarif()) ;

    	return hotelrepo.saveAndFlush(hotel) ; 
    }
  
    @GetMapping("/byambiance/{ambiance}")
    public List<Hotel> getbyambiance(@PathVariable String ambiance){
    	return this.hotelrepo.listebyambiance(ambiance) ; 
    }
    @GetMapping("/byetoile/{etoile}")
    public List<Hotel> getbyetoile(@PathVariable Long etoile){
    	return this.hotelrepo.listebyetoile(etoile) ; 
    }
    @GetMapping("/byadresse/{adresse}")
    public List<Hotel> getbyetoile(@PathVariable String adresse){
    	return this.hotelrepo.listebyadresse(adresse) ; 
    }
    @GetMapping("/getall")
    public List<Hotel> getallhotel(){
    	return this.hotelrepo.findAll() ; 
    }
  
}
