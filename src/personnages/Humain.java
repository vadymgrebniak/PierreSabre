package personnages;

public class Humain {
	protected String nom;
	protected String boissonPrefere;
	protected int quantiteArgent;
	
	public Humain(String nom, String boissonPrefere, int quantiteArgent) {
		super();
		this.nom = nom;
		this.boissonPrefere = boissonPrefere;
		this.quantiteArgent = quantiteArgent;
	}

	public String getNom() {
		return nom;
	}

	public String getBoissonPrefere() {
		return boissonPrefere;
	}

	public int getQuantiteArgent() {
		return quantiteArgent;
	}
	
	public void direBonjour() {
		parler("Bonjour ! Je m'appelle " + nom + " et j'aime boire du " + boissonPrefere + ".");
	}
	
	public void boire() {
		parler("Mmmm, un bon verre de " + boissonPrefere + " ! GLOUPS !");
	}
	
	public void acheter(String bien, int prix) {
		if (quantiteArgent >= prix) {
			parler("J'ai " + quantiteArgent + " sous en poche. Je vais pouvoir m'offrir " + bien + " à " + prix + " sous.");
			perdreArgent(prix);
		}
		else {
			parler("Je n'ai plus que " + quantiteArgent + " sous en poche. Je ne peux même pas m'offrir " + bien + " à " + prix + " sous.");
		}
	}		
	
	protected void parler(String texte) {
		System.out.println("(" + nom + ") - " + texte);
	}
	
	protected void gagnerArgent(int gain) {
		quantiteArgent += gain;
	}
	
	protected void perdreArgent(int perte) {
		quantiteArgent -= perte;
	}
}
