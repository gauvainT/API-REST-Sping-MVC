package com.fr.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fr.model.Specialite;
import com.fr.repository.SpecialiteRepository;

@Component
public class SpecialiteService {
	
	@Autowired
	private SpecialiteRepository specialiteRepository;
	
	@Transactional
	public void add(Specialite specialite) {
		specialiteRepository.save(specialite);
	}
	
	@Transactional
	public void update(Specialite specialite) {
		specialiteRepository.save(specialite);
	}
	
	@Transactional
	public void delete(Specialite specialite) {
		specialiteRepository.delete(specialite);
	}
	
	@Transactional
	public void delete(long id) {
		// TODO Auto-generated method stub
		specialiteRepository.deleteById(id);
	}
	
	@Transactional
	public List<Specialite> findAll() {
		return specialiteRepository.findAll();
	}
	
	@Transactional
	public void addAll(Collection<Specialite> specialites) {
		for (Specialite specialite : specialites) {
			specialiteRepository.save(specialite);
		}
	}

	public Specialite findById(Long idSpecialite) {
		// TODO Auto-generated method stub
		return specialiteRepository.findByIdspecialite(idSpecialite);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
