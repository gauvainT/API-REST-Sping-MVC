package com.fr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Specialite {
	
	private long idspecialite;
	private String intitule;
	
	
	// Construteurs
	public Specialite(long id, String specialite) {
		super();
		this.idspecialite = id;
		this.intitule = specialite;
	}
	public Specialite(String specialite) {
		super();
		this.intitule = specialite;
	}
	public Specialite() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	// Getters && Setters 
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	public long getIdspecialite() {
		return idspecialite;
	}
	public void setIdspecialite(long id) {
		this.idspecialite = id;
	}
	
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String specialite) {
		this.intitule = specialite;
	}
	
	
	// toString
	@Override
	public String toString() {
		return "Specialite [id=" + idspecialite + ", intitule=" + intitule + "]";
	}
	
	
	

}
