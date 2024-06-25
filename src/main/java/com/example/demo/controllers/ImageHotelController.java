package com.example.demo.controllers;

import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
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

import com.example.demo.models.Hotel;
import com.example.demo.models.ImageHotel;
import com.example.demo.models.Users;
import com.example.demo.repositery.HotelRepositery;
import com.example.demo.repositery.ImageRepositery;
import com.example.demo.utils.ImageStoarge;

@RestController
@RequestMapping("/imagehotel")
@CrossOrigin("*")
public class ImageHotelController {
	
	@Autowired
	private ImageRepositery imgrepo ; 
	
	@Autowired
	private HotelRepositery hotelrepo ; 
	@Autowired
	private ImageStoarge imageService;
	
	   private final Path rootLocation = Paths.get("upload-images");
	
	
	@PostMapping("/createimage/{idhotel}")
	public ImageHotel create ( @RequestParam  MultipartFile file , @PathVariable Long idhotel ,  ImageHotel image ) {
		Hotel h = hotelrepo.findById(idhotel).orElse(null) ; 
		 String images= imageService.CreateNameImage(file);
	        imageService.store(file,images);
	        image.setImage(images) ; 
	        image.setHotel(h) ; 
	        
	        return imgrepo.save(image)   ; 
	        
	        
		
	}
	
	@GetMapping("/getbyid/{id}")
	public Hotel getbyid(@PathVariable Long id) {
		return hotelrepo.findById(id).orElse(null) ; 
	}

	   @PutMapping("/updateimage/{id}")
	    public ImageHotel updateImage(@RequestParam("file") MultipartFile file, @PathVariable Long id) {

	        ImageHotel a = imgrepo.findById(id).orElse(null) ;
	        try {
	            String fileName = Integer.toString(new Random().nextInt(1000000000));
	            String ext = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf('.'), file.getOriginalFilename().length());
	            String name = file.getOriginalFilename().substring(0, file.getOriginalFilename().indexOf('.'));
	            String original = name + fileName + ext;
	            Files.copy(file.getInputStream(), this.rootLocation.resolve(original));
	            a.setImage(original);

	        } catch (Exception e) {
	            throw new RuntimeException("FAIL Error IMAGE check the back-end server !");
	        }

	        return imgrepo.saveAndFlush(a);

	    }
	   
	   
	   
	   
	   @GetMapping("/getonebyhotel/{id}")
	    public   ImageHotel  getonebyhotel(@PathVariable Long id){  
		   List<ImageHotel> images = imgrepo.listebyhotel(id);;
	        return images.isEmpty() ? null : images.get(0);   
	   }
	   
	   
	   
	   @GetMapping("/getallbyhotel/{id}")
	    public     List<ImageHotel>  getall(@PathVariable Long id){  
		
	        return    imgrepo.listebyhotel(id) ;  
	   }
	   
	   @DeleteMapping("/delete/{id}")
	   public void delte(@PathVariable Long id) {
		   ImageHotel imgh = this.imgrepo.findById(id).orElse(null) ; 
		   imgrepo.delete(imgh) ; 
	   }
	 
	   
	
	

}

