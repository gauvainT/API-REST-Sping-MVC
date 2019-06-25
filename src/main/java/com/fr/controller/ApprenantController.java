package com.fr.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fr.model.Apprenant;
import com.fr.service.ApprenantService;

@Controller
@RequestMapping("/apprenant")
public class ApprenantController {
	
	@Autowired
	private ApprenantService apprenantService;
	
	@GetMapping("/list")
	public String listApprenants(Model model) {
		
		List<Apprenant> listApprenants = apprenantService.findAll();
		model.addAttribute("listeDesApprenants", listApprenants);
		return "list-apprenants";
	}
	
	@PostMapping("/saveApprenant")
	public String saveApprenant(@ModelAttribute("apprenant") Apprenant apprenant ) {
		
		apprenantService.add(apprenant);
		return "redirect:/apprenant/list";
	}
	
	@GetMapping("/deleteApprenant")
	public String deleteApprenant(@RequestParam("apprenantId") long idApprenant ) {
		apprenantService.delete(idApprenant);
		return "redirect:/apprenant/list";
	}
	
	@PostMapping("/updateApprenant")
	public String updateApprenant(@ModelAttribute("apprenant") Apprenant apprenant) { 
		apprenantService.update(apprenant);
		return "redirect:/apprenant/list";
	}
	
	@GetMapping("/catchApprenant")
	public String catchApprenant(@RequestParam("id") Long idApprenant, Model model) {
		List<Apprenant> listeApprenants = apprenantService.findAll();
		model.addAttribute("listeDesApprenants", listeApprenants);
		Apprenant target = apprenantService.findById(idApprenant);
		model.addAttribute("target", target);
		return"list-apprenants";
	}
	
	

}
