package com.fr.APIController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fr.model.Apprenant;
import com.fr.model.Formateur;
import com.fr.model.Session;
import com.fr.model.Specialite;
import com.fr.service.FormateurService;

@CrossOrigin( origins = { "http://localhost:8080", "http://localhost:4200", "http://localhost" } )
@RestController
@RequestMapping("apiFormateur")
public class FormateurAPIController {
	
	@Autowired
	private FormateurService formateurService;
	
	@GetMapping("/formateurs")
	public List<Formateur> getFormateurs() {
		return formateurService.findAll();
	}
	
	@GetMapping("/formateur")
	public Formateur getFormateur(@RequestBody long id) {
		return formateurService.findById(id);
	}
	
	@PostMapping(value="/ajoutformateur")
	public ResponseEntity addFormateur(@RequestBody Formateur formateur) {
		formateurService.add(formateur);
		return new ResponseEntity(formateur, HttpStatus.OK);
	}
	
	@PostMapping("/ajoutformateurs")
	public ResponseEntity addFormateurs(@RequestBody List<Formateur> formateurs) {
		formateurService.addAll(formateurs);;
		return new ResponseEntity(formateurs, HttpStatus.OK);
	}
	
	@PutMapping("/updateformateur")
	public ResponseEntity updateFormateur(@RequestBody Formateur formateur) {
		formateurService.update(formateur);
		return new ResponseEntity(formateur.getId(), HttpStatus.OK);
	}
	
	@PutMapping("/updateformateurs")
	public ResponseEntity updateFormateurs(@RequestBody List<Formateur> formateurs) {
		formateurService.addAll(formateurs);
		List<Long> listId= new ArrayList<>();
		for (Formateur formateur : formateurs) {
			listId.add(formateur.getId());
		}
		return new ResponseEntity(listId, HttpStatus.OK);
	}	
	
	@DeleteMapping("/deleteformateur")
	public ResponseEntity deleteFormateur(@RequestBody Formateur formateur) {
		formateurService.delete(formateur);
		if(formateurService.findAll().contains(formateur)) {
			return new ResponseEntity( HttpStatus.NO_CONTENT);
		}
		else{ return new ResponseEntity( HttpStatus.OK);}
	}
	
	@DeleteMapping("/deleteformateurbyid")
	public ResponseEntity deleteFormateur(@RequestBody long id) {
		formateurService.delete(id);
		if(formateurService.findAll().contains(formateurService.findById(id))) {
			return new ResponseEntity( HttpStatus.NO_CONTENT);
		}
		else{ return new ResponseEntity( HttpStatus.OK);}
	}
	
	@PostMapping("/addSession/{idFormateur}")
	public ResponseEntity addSession(@PathVariable Long idFormateur, @RequestBody Session session) {
		Formateur target = formateurService.findById(idFormateur);
		target.setSession(session);
		formateurService.update(target);
		return new ResponseEntity( HttpStatus.OK);
	}
	
	@PostMapping("addSpecialite/{idFormateur}")
	public ResponseEntity addSpecialite(@PathVariable Long idFormateur, @RequestBody Specialite specialite) {
		Formateur target = formateurService.findById(idFormateur);
		target.setSpecialite(specialite);
		formateurService.update(target);
		return new ResponseEntity(HttpStatus.OK);
	}

}
