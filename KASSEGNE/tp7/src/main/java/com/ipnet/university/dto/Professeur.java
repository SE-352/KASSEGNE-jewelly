package com.ipnet.university.dto;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "professeurs")
@Data
@AllArgsConstructor
public class Professeur extends Personne{
	
    @Column(name = "grade", nullable = true)
    private String grade;
    
   
    @ManyToMany()
    @JoinTable(name = "dispenses", 
            joinColumns = @JoinColumn(name = "professeur_id"),
            inverseJoinColumns = @JoinColumn(name = "cours_id")
    )
    private Set<Cours> cours;
    
    
    @ManyToMany()
    @JoinTable(name = "interventions", 
            joinColumns = @JoinColumn(name = "professeur_id"),
            inverseJoinColumns = @JoinColumn(name = "departement_id")
    )
    private Set<Departement> departements;
    
	public Professeur() {
		
	}

	public Professeur(String nom, String prenom, String email, String grade, Set<Cours> cours, Set<Departement> departements) {
        super(nom, prenom, email);
        this.grade = grade;
        this.cours = cours;
        this.departements = departements;
        }

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Set<Cours> getCours() {
		return cours;
	}

	public void setCours(Set<Cours> cours) {
		this.cours = cours;
	}

	public Set<Departement> getDepartements() {
		return departements;
	}

	public void setDepartements(Set<Departement> departements) {
		this.departements = departements;
	}
          
}