package com.fr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.fr.model.Session;
import com.fr.model.Specialite;



@EnableJpaRepositories
public interface SessionRepository extends JpaRepository<Session, Long>{

	public Session findByIdsession(long searchLong);
	public Session findBySpecialite(Specialite searchSpecialite);
}
