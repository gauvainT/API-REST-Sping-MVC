package com.fr.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.fr.model.Apprenant;
import com.fr.model.Session;

@EnableJpaRepositories
public interface ApprenantRepository extends JpaRepository<Apprenant, Long>{
	
	public Apprenant findById(long searchLong);
	
	public List<Apprenant> findBySession(Session searchSession);
	
}
