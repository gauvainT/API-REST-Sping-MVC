package com.fr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.fr.model.Formateur;
import com.fr.model.Session;
import com.fr.model.Specialite;

@EnableJpaRepositories
public interface FormateurRepository extends JpaRepository<Formateur, Long> {
	
	public Formateur findById(long searchLong);
	public Formateur findByIdentifiant(long searchLong);
	public Formateur findBySpecialite(Specialite searchSpecialite);
	public Formateur findBySession(Session searchSession);

}
