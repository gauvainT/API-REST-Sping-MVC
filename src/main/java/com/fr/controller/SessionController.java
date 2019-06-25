package com.fr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fr.model.Session;
import com.fr.model.Specialite;
import com.fr.repository.SessionRepository;
import com.fr.service.SessionService;
import com.fr.service.SpecialiteService;

import javafx.scene.control.SpinnerValueFactory.ListSpinnerValueFactory;

@Controller
@RequestMapping("/session")
public class SessionController {

	@Autowired
	private SessionService sessionService;
	
	@Autowired
	private SpecialiteService specialiteService;
	
	@GetMapping("/list")
	public String listSession(Model model) {
		
		List<Session> listSession = sessionService.findAll();
		model.addAttribute("listeDesSessions", listSession);
		List<Specialite> listSpecialite = specialiteService.findAll();
		model.addAttribute("listeDesSpecialites", listSpecialite);
		return "list-sessions";
	}
	
	@PostMapping("/saveSession")
	public String saveSession(@ModelAttribute("session") Session session, @ModelAttribute("idSpecialite") long idSpecialite) {
		session.setSpecialite(specialiteService.findById(idSpecialite));
		System.err.println("====================================SESSION==============================="+session);
		sessionService.add(session);
		System.err.println("====================================SESSION AJOUTEE==============================="+session);
		return "redirect:/session/list";
	}
	
	@GetMapping("/deleteSession")
	public String deleteSession(@RequestParam("sessionId") long idSession) {
		
		sessionService.delete(idSession);
		return "redirect:/session/list";
	}
	
	@PostMapping("/updateSession")
	public String updateSession(@ModelAttribute("session") Session session) {
		sessionService.update(session);
		return "redirect:/session/list";
	}
	
	@GetMapping("/catchSession")
	public String catchSession(@RequestParam("id") Long idSession ,Model model) {
		
		List<Session> listSession = sessionService.findAll();
		model.addAttribute("listeDesSessions", listSession);
		Session target = sessionService.findById(idSession);
		model.addAttribute("target", target);
		return "list-sessions";
	}
	
	
	
}
