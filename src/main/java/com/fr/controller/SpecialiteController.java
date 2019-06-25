package com.fr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fr.model.Apprenant;
import com.fr.model.Specialite;
import com.fr.service.ApprenantService;
import com.fr.service.SpecialiteService;

@Controller
@RequestMapping("/specialite")
public class SpecialiteController {
	
	@Autowired
	private SpecialiteService specialiteService;
	
	@GetMapping("/list")
	public String listSpecialite(Model model) {
		
		List<Specialite> listSpecialites = specialiteService.findAll();
		model.addAttribute("listeDesSpecialites", listSpecialites);
		return "list-specialites";
	}
	
	@PostMapping("/saveSpecialite")
	public String saveSpecialite(@ModelAttribute("specialite") Specialite specialite ) {
		
		specialiteService.add(specialite);
		return "redirect:/specialite/list";
	}
	
	@GetMapping("/deleteSpecialite")
	public String deleteSpecialite(@RequestParam("specialiteId") long id ) {
		specialiteService.delete(id);
		return "redirect:/specialite/list";
	}
	
	@PostMapping("/updateSpecialite")
	public String updateSpecialite(@ModelAttribute("specialite") Specialite specialite) { 
		specialiteService.update(specialite);
		return "redirect:/specialite/list";
	}
	
	@GetMapping("/catchSpecialite")
	public String catchSpecialite(@RequestParam("idspecialite") Long idSpecialite, Model model) {
		List<Specialite> listSpecialites = specialiteService.findAll();
		model.addAttribute("listeDesSpecialites", listSpecialites);
		Specialite target = specialiteService.findById(idSpecialite);
		model.addAttribute("target", target);
		return"list-specialites";
	}
	

	

}
