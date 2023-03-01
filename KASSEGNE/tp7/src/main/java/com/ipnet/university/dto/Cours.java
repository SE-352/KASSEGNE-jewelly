package com.ipnet.university.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity
@Table(name = "cours")
public class Cours extends BaseEntity implements Serializable{
     
	private static final long serialVersionUID = 1L;
	
	@Column(name = "intitule", length = 60, nullable = false, unique = true)
    private String intitule;   
	
    @Column(name = "date_creation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    
    
    @ManyToMany()
    @JoinTable(name = "inscriptions",
            joinColumns = @JoinColumn(name = "cours_id"),
            inverseJoinColumns = @JoinColumn(name = "etudiant_id")
    )
    private Set<Etudiant> etudiants;
    
   
    @ManyToMany(mappedBy="cours", cascade = CascadeType.ALL)
    private Set<Professeur> professeurs; 
    
   
    @ManyToMany()
    @JoinTable(name = "comportes", 
            joinColumns = @JoinColumn(name = "cours_id"),
            inverseJoinColumns = @JoinColumn(name = "departement_id")
    )
    private Set<Departement> departements;

	public Cours() {
    }
	
	public Cours(String intitule, Date dateCreation, Set<Professeur> professeurs) {
		this.intitule = intitule;
		this.dateCreation = dateCreation;
		this.professeurs = professeurs;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
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
	
	public Set<Departement> getDepartements() {
		return departements;
	}

	public void setDepartements(Set<Departement> departements) {
		this.departements = departements;
	}
    
}
