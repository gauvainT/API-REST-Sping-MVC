package com.fr.APIController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fr.model.Specialite;
import com.fr.service.SpecialiteService;

@CrossOrigin( origins = { "http://localhost:8080", "http://localhost:4200", "http://localhost" } )
@RestController
@RequestMapping("apiSpecialite")
public class SpecialiteAPIController {
	
	@Autowired
	private SpecialiteService specialiteService;
	
	@GetMapping("/specialites")
	public List<Specialite> getSpecialites() {
		return specialiteService.findAll();
	}
	
	@GetMapping("/specialite/{id}")
	public Specialite getSpecialite(@PathVariable long id) {
		return specialiteService.findById(id);
	}
	
	@PostMapping(value="/ajoutSpecialite")
	public ResponseEntity addSpecialite(@RequestBody Specialite specialite) {
		specialiteService.add(specialite);
		return new ResponseEntity(specialite, HttpStatus.OK);
	}
	
	@PostMapping("/ajoutSpecialites")
	public ResponseEntity addSpecialites(@RequestBody List<Specialite> specialites) {
		specialiteService.addAll(specialites);;
		return new ResponseEntity(specialites, HttpStatus.OK);
	}
	
	@PutMapping("/updateSpecialite")
	public ResponseEntity updateSpecialite(@RequestBody Specialite specialite) {
		specialiteService.update(specialite);
		return new ResponseEntity(specialite.getIdspecialite(), HttpStatus.OK);
	}
	
	@PutMapping("/updateSpecialites")
	public ResponseEntity updateSpecialites(@RequestBody List<Specialite> specialites) {
		specialiteService.addAll(specialites);
		List<Long> listId= new ArrayList<>();
		for (Specialite specialite : specialites) {
			listId.add(specialite.getIdspecialite());
		}
		return new ResponseEntity(listId, HttpStatus.OK);
	}	
	
	@DeleteMapping("/deleteSpecialite")
	public ResponseEntity deleteSpecialite(@RequestBody Specialite specialite) {
		specialiteService.delete(specialite);
		if(specialiteService.findAll().contains(specialite)) {
			return new ResponseEntity( HttpStatus.NO_CONTENT);
		}
		else{ return new ResponseEntity( HttpStatus.OK);}
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity deleteSpecialite(@PathVariable long id) {
		specialiteService.delete(id);
		if(specialiteService.findAll().contains(specialiteService.findById(id))) {
			return new ResponseEntity( HttpStatus.NO_CONTENT);
		}
		else{ return new ResponseEntity( HttpStatus.OK);}
	}

}
