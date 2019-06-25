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

import com.fr.model.Formateur;
import com.fr.service.FormateurService;

@Controller
@RequestMapping("/formateur")
public class FormateurController {
	
	@Autowired
	private FormateurService formateurService;
	
	@GetMapping("/list")
	public String listFormateurs(Model model) {
		
		List<Formateur> listFormateurs = formateurService.findAll();
		model.addAttribute("listeDesFormateurs", listFormateurs);
		return "list-formateurs";
	}
	
	@PostMapping("/saveFormateur")
	public String saveFormateur(@ModelAttribute("formateur") Formateur formateur) {
		formateurService.add(formateur);
		return "redirect:/formateur/list";
	}
	
	@GetMapping("/deleteFormateur")
	public String deleteFormateur(@RequestParam("formateurId") long idFormateur) {
		formateurService.delete(idFormateur);
		return "redirect:/formateur/list";
	}
	
	@PostMapping("/updateFormateur")
	public String updateFormateur(@ModelAttribute("formateur") Formateur formateur) {
		formateurService.update(formateur);
		return "redirect:/formateur/list";
	}
	
	@GetMapping("/catchFormateur")
	public String catchFormateur(@RequestParam("id") Long idFormateur, Model model) {
		List<Formateur> listFormateurs = formateurService.findAll();
		model.addAttribute("listeDesFormateurs", listFormateurs);
		Formateur target = formateurService.findById(idFormateur);
		model.addAttribute("target", target);
		return "list-formateurs";
	}

}
