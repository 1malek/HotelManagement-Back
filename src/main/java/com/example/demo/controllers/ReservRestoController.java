package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Client;
import com.example.demo.models.ReserbChambre;
import com.example.demo.models.ReservTable;
import com.example.demo.models.Restaurant;
import com.example.demo.models.Tables;
import com.example.demo.repositery.ClientRepositery;
import com.example.demo.repositery.ReservTableRepositery;
import com.example.demo.repositery.RestaurantRepositery;
import com.example.demo.repositery.TablesRepositery;

@RestController
@RequestMapping("/reservresto")
@CrossOrigin("*")
public class ReservRestoController {
	@Autowired
	private ReservTableRepositery reservtablerepo ; 
	@Autowired
	private ClientRepositery clientrepo ; 
	@Autowired
	private TablesRepositery tablerepo ; 
	@Autowired 
	private RestaurantRepositery resRepositery ; 
	@PostMapping("/save/{idclient}/{idtable}/{idresto}")
	public ReservTable savereserv(@PathVariable Long idclient  , @PathVariable Long idtable, @PathVariable Long idresto ,  @RequestBody ReservTable resvt) {
		
		Restaurant res = this.resRepositery.findById(idresto).orElse(null) ; 
		resvt.setRestaurant(res) ; 
		Client c = this.clientrepo.findById(idclient).orElse(null) ; 
		resvt.setClient(c) ; 
		Tables t = this.tablerepo.findById(idtable).orElse(null) ; 
		resvt.setTables(t) ; 
		return this.reservtablerepo.save(resvt) ; 
	}
	@DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
    	
    	ReservTable r = this.reservtablerepo.findById(id).orElse(null) ; 
    	this.reservtablerepo.delete(r) ; 
    }
 @GetMapping("/getbyclient/{idclient}")
    public List<ReservTable> findbyclient ( @PathVariable Long idclient){
    	return this.reservtablerepo.listebyclient(idclient) ; 
    }
   @GetMapping("/getbytable/{idtables}")
    public List<ReservTable> findbytable ( @PathVariable Long idtables){
    	return this.reservtablerepo.listebytables(idtables) ; 
    }
   @GetMapping("/availabletables/{id}")
    public List<ReservTable> getAvailableTables(@PathVariable Long id) {
        return reservtablerepo.getAvailableTables(id);
    }
    @GetMapping("/byrestaurant/{restaurantId}")
    public ResponseEntity<List<ReservTable>> byrestauranttwo(@PathVariable Long restaurantId) {
        List<ReservTable> reservations = reservtablerepo.listereservbyresto(restaurantId);
        return ResponseEntity.ok(reservations);
    }
    @GetMapping("/getall")
    public List<ReservTable> getall(){
    	return this.reservtablerepo.findAll() ; 
    }

}
