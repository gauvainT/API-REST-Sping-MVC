package com.fr.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fr.model.Apprenant;
import com.fr.repository.ApprenantRepository;

@Component
public class ApprenantService {
	
	@Autowired
	private ApprenantRepository apprenantRepository;
	
	@Transactional
	public void add(Apprenant app) {
		apprenantRepository.save(app);
	}
	
	@Transactional
	public void update(Apprenant app) {
		apprenantRepository.save(app);
	}
	
	@Transactional
	public void delete(Apprenant app) {
		apprenantRepository.delete(app);
	}
	
	@Transactional
	public void delete(long id) {
		apprenantRepository.delete(apprenantRepository.findById(id));
	}
	
	@Transactional(readOnly=true)
	public List<Apprenant> findAll(){
		return apprenantRepository.findAll();
	}
	
	@Transactional
	public void addAll(Collection<Apprenant> apprenants) {
		for (Apprenant apprenant : apprenants) {
			apprenantRepository.save(apprenant);
		}
	}
	
	@Transactional
	public Apprenant findById(long id) {
		return apprenantRepository.findById(id);
	}
	
	
	

}
