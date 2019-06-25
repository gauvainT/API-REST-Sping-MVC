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

import com.fr.model.Session;
import com.fr.model.Specialite;
import com.fr.service.SessionService;

@CrossOrigin( origins = { "http://localhost:8080", "http://localhost:4200", "http://localhost" } )
@RestController
@RequestMapping("apiSession")
public class SessionAPIController {

	@Autowired
	private SessionService sessionService;
	
	@GetMapping("/sessions")
	public List<Session> getSessions() {
		return sessionService.findAll();
	}
	
	@GetMapping("/session/{id}")
	public Session getSession(@PathVariable long id) {
		return sessionService.findById(id);
	}
	
	@PostMapping(value="/ajoutSession")
	public ResponseEntity addSession(@RequestBody Session session) {
		sessionService.add(session);
		return new ResponseEntity(session, HttpStatus.OK);
	}
	
	@PostMapping("/ajoutSessions")
	public ResponseEntity addSessions(@RequestBody List<Session> sessions) {
		sessionService.addAll(sessions);;
		return new ResponseEntity(sessions, HttpStatus.OK);
	}
	
	@PutMapping("/updateSession")
	public ResponseEntity updateSession(@RequestBody Session session) {
		sessionService.update(session);
		return new ResponseEntity(session.getIdsession(), HttpStatus.OK);
	}
	
	@PutMapping("/updateSessions")
	public ResponseEntity updateSessions(@RequestBody List<Session> sessions) {
		sessionService.addAll(sessions);
		List<Long> listId= new ArrayList<>();
		for (Session session : sessions) {
			listId.add(session.getIdsession());
		}
		return new ResponseEntity(listId, HttpStatus.OK);
	}	
	
	@DeleteMapping("/deleteSessions")
	public ResponseEntity deleteSession(@RequestBody Session session) {
		sessionService.delete(session);
		if(sessionService.findAll().contains(session)) {
			return new ResponseEntity( HttpStatus.NO_CONTENT);
		}
		else{ return new ResponseEntity( HttpStatus.OK);}
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity deleteSession(@PathVariable long id) {
		sessionService.delete(id);
		if(sessionService.findAll().contains(sessionService.findById(id))) {
			return new ResponseEntity( HttpStatus.NO_CONTENT);
		}
		else{ return new ResponseEntity( HttpStatus.OK);}
	}
	
	@PostMapping("addSpecialiteSession/{idSession}")
	public ResponseEntity addSpecialite(@PathVariable Long idSession, @RequestBody Specialite specialite) {
		Session target = sessionService.findById(idSession);
		target.setSpecialite(specialite);
		sessionService.update(target);
		return new ResponseEntity(HttpStatus.OK);
	}
}
