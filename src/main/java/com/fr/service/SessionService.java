package com.fr.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fr.model.Session;
import com.fr.repository.SessionRepository;;

@Component
public class SessionService {
	
	@Autowired
	private SessionRepository sessionRepository;
	
	@Transactional
	public void add(Session session) {
		sessionRepository.save(session);
	}
	
	@Transactional
	public void update(Session session) {
		sessionRepository.save(session);
	}
	
	@Transactional
	public void delete(Session session) {
		sessionRepository.delete(session);
	}
	
	@Transactional
	public void delete(long idSession) {
		sessionRepository.deleteById(idSession);;
	}
	
	@Transactional
	public List<Session> findAll() {
		return sessionRepository.findAll();
	}
	
	@Transactional
	public void addAll(Collection<Session> sessions) {
		for (Session session : sessions) {
			sessionRepository.save(session);
		}
	}

	public Session findById(Long idSession) {
		return sessionRepository.findByIdsession(idSession);
	}

	
	
	
	
	
	
	
	
}