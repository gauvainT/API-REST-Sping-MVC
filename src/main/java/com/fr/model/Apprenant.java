package com.fr.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Apprenant {
	
	private long id;
	private long idPoleEmploi;
	private String nom;
	private String prenom;
	private int age;
	private float indemnite;
	private String diplome;
	
	private Session session;
	
	
	// Constructeur
	public Apprenant(long id_pole_emploi, String nom, String prenom, int age, float indemnite, String diplome) {
		super();
		this.idPoleEmploi = id_pole_emploi;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.indemnite = indemnite;
		this.diplome = diplome;
	}
	
	public Apprenant(long id_pole_emploi, String nom, String prenom, int age, float indemnite, String diplome,
			Session session) {
		super();
		this.idPoleEmploi = id_pole_emploi;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.indemnite = indemnite;
		this.diplome = diplome;
		this.session = session;
	}

	public Apprenant() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	// Getters && Setters
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdPoleEmploi() {
		return idPoleEmploi;
	}

	public void setIdPoleEmploi(long id_pole_emploi) {
		this.idPoleEmploi = id_pole_emploi;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getIndemnite() {
		return indemnite;
	}

	public void setIndemnite(float indemnite) {
		this.indemnite = indemnite;
	}

	public String getDiplome() {
		return diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idsession")
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	// toString
	@Override
	public String toString() {
		return "Apprenant [id=" + id + ", id_pole_emploi=" + idPoleEmploi + ", nom=" + nom + ", prenom=" + prenom
				+ ", age=" + age + ", indemnite=" + indemnite + ", diplome=" + diplome + "]";
	}
	
	
	
	

}
