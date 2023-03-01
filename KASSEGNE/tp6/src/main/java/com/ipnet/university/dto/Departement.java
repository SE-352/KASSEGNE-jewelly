package com.ipnet.university.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity
@Table(name = "departements")
public class Departement extends BaseEntity implements Serializable{
    
	private static final long serialVersionUID = 1L;

	@Column(name="nom", length=60)
	private String nom;
	
	@Column(name="adresseWeb", length=60)
	private String adresseWeb;
    
	
	@OneToMany(mappedBy = "departement",fetch = FetchType.LAZY)
    private Set<Etudiant> etudiants;
    
	
    @ManyToMany(mappedBy="departements", cascade = CascadeType.ALL)
    private Set<Professeur> professeurs; 
    
    
    @ManyToMany(mappedBy="departements", cascade = CascadeType.ALL)
    private Set<Cours> cours; 
    
    public Departement() {
    }
    
    public Set<Cours> getCours() {
		return cours;
	}

	public void setCours(Set<Cours> cours) {
		this.cours = cours;
	}

	public Departement(String nom, String adresseWeb) {
    	this.nom = nom;
    	this.adresseWeb = adresseWeb;
    }

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresseWeb() {
		return adresseWeb;
	}

	public void setAdresseWeb(String adresseWeb) {
		this.adresseWeb = adresseWeb;
	}

	public Set<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(Set<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	public Set<Professeur> getProfesseurs() {
		return professeurs;
	}

	public void setProfesseurs(Set<Professeur> professeurs) {
		this.professeurs = professeurs;
	}
    
    
}