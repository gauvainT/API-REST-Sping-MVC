package com.fr.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Session {
	
	private long idsession;
	private Date date_debut;
	private Date date_fin;
	private String lieu;
	private Specialite specialite;
	
	
	// Constructeurs
	public Session(Date date_debut, Date date_fin, String lieu, Specialite specialite) {
		super();
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.specialite = specialite;
		this.lieu = lieu;
	}
	public Session() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public Session(Date date_debut, Date date_fin, String lieu) {
		super();
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.lieu = lieu;
	}
	// Getters && Setters
	@Id
	@GeneratedValue (strategy= GenerationType.AUTO)
	public long getIdsession() {
		return idsession;
	}
	public void setIdsession(long id_session) {
		this.idsession = id_session;
	}
	public Date getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}
	public Date getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idspecialite")
	public Specialite getSpecialite() {
		return specialite;
	}
	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}
	
	// toString
	@Override
	public String toString() {
		return "Session [id=" + idsession + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", lieu=" + lieu
				+ "]";
	}
	
	

	
	
	

}
