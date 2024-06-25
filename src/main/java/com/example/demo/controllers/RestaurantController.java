package com.example.demo.controllers;

import java.nio.file.Files;
import java.nio.file.Path;

import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.models.ResponsableRestau;
import com.example.demo.models.Restaurant;
import com.example.demo.repositery.ResponsableRestauRepo;
import com.example.demo.repositery.RestaurantRepositery;
import com.example.demo.utils.ImageStoarge;

import org.springframework.http.HttpHeaders;
import org.springframework.core.io.Resource;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin("*")
public class RestaurantController {
	
	private final Path rootLocation = Paths.get("upload-images");
	@Autowired
	private RestaurantRepositery  restorepo; 
	@Autowired
	private ResponsableRestauRepo responsablerestorepo ; 
	@Autowired
	private ImageStoarge imageService;
	
	
	@PostMapping("/addresto/{idrespo}")
	public Restaurant addresto(@PathVariable Long idrespo , Restaurant resto , @RequestParam  MultipartFile file ) {
		
		  String images= imageService.CreateNameImage(file);
	        imageService.store(file,images);
	        resto.setPhotomenu(images) ; 
	 	   ResponsableRestau r = this.responsablerestorepo.findById(idrespo).orElse(null) ; 
	     	resto.setResponsablerestau(r) ; 
	  	return this.restorepo.save(resto) ; 
	}
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		Restaurant r = this.restorepo.findById(id).orElse(null) ; 
		this.restorepo.delete(r) ;
	
	}
	
	
	@GetMapping("/findbyrespo/{idrespo}")
	public List<Restaurant> findbyrespo(@PathVariable Long idrespo){
		return this.restorepo.listbyrespo(idrespo) ; 
	}
    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
    	  Resource file = imageService.loadFile(filename);
          return ResponseEntity.ok()
                  .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                  .body(file);
    }
    
    
    @PutMapping("/updateimage/{id}")
    public Restaurant updateImage(@RequestParam("file") MultipartFile file, @PathVariable Long id) {

    	Restaurant a = restorepo.findById(id).orElse(null) ;
        try {
            String fileName = Integer.toString(new Random().nextInt(1000000000));
            String ext = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf('.'), file.getOriginalFilename().length());
            String name = file.getOriginalFilename().substring(0, file.getOriginalFilename().indexOf('.'));
            String original = name + fileName + ext;
            Files.copy(file.getInputStream(), this.rootLocation.resolve(original));
            a.setPhotomenu(original);

        } catch (Exception e) {
            throw new RuntimeException("FAIL Error IMAGE check the back-end server !");
        }

        return restorepo.saveAndFlush(a);

    }
    @PutMapping("/update/{id}")
    public Restaurant updateresto(@PathVariable Long id  , @RequestBody Restaurant resto) {
    	resto.setId(id) ; 
    	Restaurant oldresto = this.restorepo.findById(id).orElse(null) ; 
    	resto.setLibelle(resto.getLibelle()==null?oldresto.getLibelle():resto.getLibelle()) ; 
    	resto.setAdresse(resto.getAdresse()==null?oldresto.getAdresse():resto.getAdresse()) ; 
    	resto.setTypeambiance(resto.getTypeambiance()==null?oldresto.getTypeambiance():resto.getTypeambiance()) ; 
    	resto.setHeureouvert(resto.getHeureouvert()==null?oldresto.getHeureouvert():resto.getHeureouvert()) ; 
    	resto.setHeureclosed(resto.getHeureclosed()==null?oldresto.getHeureouvert():resto.getHeureouvert()) ; 
       	resto.setCapacite(resto.getCapacite()==null?oldresto.getCapacite():resto.getCapacite()) ; 
       	resto.setTypecuisine(resto.getTypecuisine()==null?oldresto.getTypecuisine():resto.getTypecuisine()) ; 
    	resto.setPhotomenu(resto.getPhotomenu()==null?oldresto.getPhotomenu():resto.getPhotomenu()) ; 
    	resto.setResponsablerestau(resto.getResponsablerestau()==null?oldresto.getResponsablerestau():resto.getResponsablerestau()) ; 
    	resto.setTables(resto.getTables()==null?oldresto.getTables():resto.getTables()) ; 
    	
    	return this.restorepo.saveAndFlush(resto) ; 
    }
    
    @GetMapping("/findall")
    public List<Restaurant> findall(){
    	 return restorepo.findAll() ; 
    }
    @GetMapping("/byambiance/{ambiance}")
    public List<Restaurant> findbyambiance(@PathVariable String ambiance){
    	return this.restorepo.listebyambiance(ambiance) ; 
    }
    @GetMapping("/bycuisine/{cuisine}")
    public List<Restaurant> findbycuisine(@PathVariable String cuisine){
    	return this.restorepo.listebycuisine(cuisine) ; 
    }
   
    @GetMapping("/getbyid/{id}")
    public Restaurant getbyid(@PathVariable Long id) {
    	 return this.restorepo.findById(id).orElse(null) ; 
    }
    @GetMapping("/getall")
    public List<Restaurant> getallresto(){
    	return this.restorepo.findAll() ; 
    			}
    
    
    @GetMapping("/getbyadresse/{adresse}")
    public List<Restaurant> getall(@PathVariable String adresse){
    	return this.restorepo.listebyadresse(adresse) ; 
    }
}
