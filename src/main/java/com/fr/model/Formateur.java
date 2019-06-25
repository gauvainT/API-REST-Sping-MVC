package com.fr.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Formateur {
	
	private long id;
	
	private String nom;
	private String prenom;
	private int age;
	private long identifiant;
	private float salaire;
	
	private Session session;
	private Specialite specialite;

	
	// Constructeurs
	
	
	public Formateur(long identifiant, String nom, String prenom, int age, float salaire) {
		super();
		this.identifiant = identifiant;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.salaire = salaire;
	}

	public Formateur(long identifiant, String nom, String prenom, int age, float salaire, Session session,
			Specialite specialite) {
		super();
		this.identifiant = identifiant;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.salaire = salaire;
		this.session = session;
		this.specialite = specialite;
	}

	public Formateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	// Getters && Setters	
	@Id
	@GeneratedValue (strategy= GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(long identifiant) {
		this.identifiant = identifiant;
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

	public float getSalaire() {
		return salaire;
	}

	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idsession")
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
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
		return "Formateur [id=" + id + ", identifiant=" + identifiant + ", nom=" + nom + ", prenom=" + prenom + ", age="
				+ age + ", salaire=" + salaire + "]";
	}
	
	
	
	

}
