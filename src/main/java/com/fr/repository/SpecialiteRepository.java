package com.fr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


import com.fr.model.Specialite;

@EnableJpaRepositories
public interface SpecialiteRepository extends JpaRepository<Specialite, Long>{

	public Specialite findByIdspecialite(long searchLong);
}
