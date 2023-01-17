package tg.ipnet.university.tp3;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "joueur")
public class Joueur {
	
	@Id
	@Column(name = "numero_licence")
	private String numeroLicence;
	
	@Column(name = "nom", nullable = false, length = 60)
	private String nom;
	
	@Column(name = "prenom", nullable = false, length = 80)
	private String prenom;
	
	@Column(name = "points", nullable = false)
	private Integer points;

	@OneToMany(mappedBy = "joueur1", fetch = FetchType.LAZY)
	private Set<Match> matchs;
	
	public Joueur() {
		
	}
	
	public String getNumeroLicence() {
		return numeroLicence;
	}

	public void setNumeroLicence(String numeroLicence) {
		this.numeroLicence = numeroLicence;
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

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}
}
