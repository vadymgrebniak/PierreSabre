package personnages;

public class Humain {
	protected String nom;
	protected String boissonFavorite;
	protected int argent;
	protected Humain[] memoire = new Humain[30];
	protected int nbConnaissance = 0;
	
	public Humain(String nom, String boissonPrefere, int argent) {
		super();
		this.nom = nom;
		this.boissonFavorite = boissonPrefere;
		this.argent = argent;
	}

	public String getNom() {
		return nom;
	}

	public String getBoissonPrefere() {
		return boissonFavorite;
	}

	public int getArgent() {
		return argent;
	}
	
	public void direBonjour() {
		parler("Bonjour ! Je m'appelle " + nom + " et j'aime boire du " + boissonFavorite + ".");
	}
	
	public void boire() {
		parler("Mmmm, un bon verre de " + boissonFavorite + " ! GLOUPS !");
	}
	
	public void acheter(String bien, int prix) {
		if (argent >= prix) {
			parler("J'ai " + argent + " sous en poche. Je vais pouvoir m'offrir " + bien + " à " + prix + " sous.");
			perdreArgent(prix);
		}
		else {
			parler("Je n'ai plus que " + argent + " sous en poche. Je ne peux même pas m'offrir " + bien + " à " + prix + " sous.");
		}
	}		
	
	public void faireConnaissance(Humain humain) {
		direBonjour();
		humain.repondre(this);
		memoriser(humain);
	}
	
	public void listerConnaissance() {
		StringBuilder phrase = new StringBuilder();
		phrase.append("Je connais beaucoup de monde dont : ");
		for (int i = 0; i < nbConnaissance; i++) {
			phrase.append(memoire[i].getNom());
			
			if (i != nbConnaissance - 1) {
				phrase.append(", ");
			}
		}
		parler(phrase.toString());
	}
	
	protected void parler(String texte) {
		System.out.println("(" + nom + ") - " + texte);
	}
	
	protected void gagnerArgent(int gain) {
		argent += gain;
	}
	
	protected void perdreArgent(int perte) {
		argent -= perte;
		if (argent < 0) {
			argent = 0;
		}
	}
	
	private void memoriser(Humain humain) {
		if (nbConnaissance < memoire.length) {
			memoire[nbConnaissance] = humain;
			nbConnaissance++;
		}
		else if (memoire.length >= 1) {
			for (int i = 1; i < nbConnaissance; i++) {
				memoire[i-1] = memoire[i];
			}
			memoire[nbConnaissance - 1] = humain;
		}
	}
	
	private void repondre(Humain humain) {
		direBonjour();
		memoriser(humain);
	}
}
