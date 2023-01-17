package tg.ipnet.university.tp1;

public class Match {

	private Joueur joueur1;
	private Joueur joueur2;
	private Joueur vainqueur;
	
	public Match(Joueur j1, Joueur j2) {
		this.joueur1 = j1;
		this.joueur2 = j2;
	}

	public Joueur getJoueur1() {
		return joueur1;
	}

	public Joueur getJoueur2() {
		return joueur2;
	}

	public Joueur getVainqueur() {
		return vainqueur;
	}

	public Joueur getVaincu() {
		return joueur1;
	}
	
	public void setVainqueur(Joueur vainqueur) {
		this.vainqueur = vainqueur;
	}
	
}
