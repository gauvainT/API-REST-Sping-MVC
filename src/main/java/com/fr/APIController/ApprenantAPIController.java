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

import com.fr.controller.Dto;
import com.fr.model.Apprenant;
import com.fr.model.Session;
import com.fr.model.modelDto.ApprenantDto;
import com.fr.repository.ApprenantRepository;
import com.fr.service.ApprenantService;
import com.fr.service.SessionService;
@CrossOrigin( origins = { "http://localhost:8080", "http://localhost:4200", "http://localhost" } )
@RestController
@RequestMapping("apiApprenant")
public class ApprenantAPIController {
	
	@Autowired
	private ApprenantService apprenantService;
	
	@Autowired
	private SessionService sessionService;
	
	@Autowired
	private ApprenantRepository apprenantRepository;
	
	@GetMapping("/apprenants")
    @Dto(ApprenantDto.class)
	public List<Apprenant> getApprenants() {
		return apprenantRepository.findAll();
	}
	
	@GetMapping("/apprenant/{id}")
	public Apprenant getApprenant(@PathVariable long id) {
		return apprenantService.findById(id);
	}
	
	@PostMapping(value="/ajoutApprenant")
	public ResponseEntity addApprenant(@RequestBody Apprenant apprenant) {
		apprenantService.add(apprenant);
		return new ResponseEntity(apprenant, HttpStatus.OK);
	}
	
	@PostMapping("/ajoutApprenants")
	public ResponseEntity addApprenants(@RequestBody List<Apprenant> apprenants) {
		apprenantService.addAll(apprenants);;
		return new ResponseEntity(apprenants, HttpStatus.OK);
	}
	
	@PutMapping("/updateApprenant")
	public ResponseEntity updateApprenant(@RequestBody Apprenant apprenant) {
		apprenantService.update(apprenant);
		return new ResponseEntity(apprenant.getId(), HttpStatus.OK);
	}
	
	@PutMapping("/updateApprenants")
	public ResponseEntity updateApprenants(@RequestBody List<Apprenant> apprenants) {
		apprenantService.addAll(apprenants);
		List<Long> listId= new ArrayList<>();
		for (Apprenant apprenant : apprenants) {
			listId.add(apprenant.getId());
		}
		return new ResponseEntity(listId, HttpStatus.OK);
	}
	
	@PostMapping("/addSessionApprenant/{idApprenant}")
	public ResponseEntity addSession(@PathVariable Long idApprenant, @RequestBody Session session) {
		Apprenant target = apprenantService.findById(idApprenant);
		target.setSession(session);
		apprenantService.update(target);
		return new ResponseEntity( HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteApprenant")
	public ResponseEntity deleteApprenant(@RequestBody Apprenant apprenant) {
		apprenantService.delete(apprenant);
		if(apprenantService.findAll().contains(apprenant)) {
			return new ResponseEntity( HttpStatus.NO_CONTENT);
		}
		else{ return new ResponseEntity( HttpStatus.OK);}
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity deleteApprenant(@PathVariable long id) {
		apprenantService.delete(id);
		if(apprenantService.findAll().contains(apprenantService.findById(id))) {
			return new ResponseEntity( HttpStatus.NO_CONTENT);
		}
		else{ return new ResponseEntity( HttpStatus.OK);}
	}
	


}
