package tg.ipnet.university.tp3;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Match")
public class Match {

	@ManyToOne
	@JoinColumn(name = "joueur_id")
	private Joueur joueur1;
	
	@ManyToOne
	//@JoinColumn(name = "joueur_id")
	private Joueur joueur2;
	
	@ManyToOne
	//@JoinColumn(name = "joueur_id")
	private Joueur vainqueur;
	
	public Match() {
		
	}

}
