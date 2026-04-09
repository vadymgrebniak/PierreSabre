package personnages;

public class Commercant extends Humain {
	
	public Commercant(String nom, String boissonPrefere, int quantiteArgent) {
		super(nom, boissonPrefere, quantiteArgent);
		
	}
	
	public void seFaireExtorquer() {
		perdreArgent(quantiteArgent);
		parler("J’ai tout perdu! Le monde est trop injuste...");
	}
	
	public void recevoir(int argent) {
		gagnerArgent(argent);
		parler(argent + " sous ! Je te remercie généreux donateur!");
	}
}
