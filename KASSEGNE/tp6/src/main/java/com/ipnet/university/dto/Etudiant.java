package com.ipnet.university.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "etudiants")
@Data
@AllArgsConstructor
public class Etudiant extends Personne{
    
	@Column(name="adresse", nullable=true)
	private String adresse;
	
	@Column(name="telephone")
	private String telephone;
    
	
    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "departement_id")
    private Departement departement;
    
   
    @ManyToMany(mappedBy = "etudiants", cascade = CascadeType.ALL)
    private Set<Cours> cours;

    public Etudiant() {
    	
    }
    
    public Etudiant(String nom, String prenom, String email, String adresse, String telephone) {
        super(nom, prenom, email);
        this.adresse = adresse;
        this.telephone = telephone;
    }

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Set<Cours> getCours() {
		return cours;
	}

	public void setCours(Set<Cours> cours) {
		this.cours = cours;
	}
     
    
}