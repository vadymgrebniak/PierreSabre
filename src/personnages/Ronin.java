package personnages;

public class Ronin extends Humain {
	int honneur = 1;

	public Ronin(String nom, String boissonPrefere, int quantiteArgent) {
		super(nom, boissonPrefere, quantiteArgent);
	}
	
	public void donner(Commercant beneficiaire) {
		int don = quantiteArgent / 10;
		parler(beneficiaire.getNom() + " prend ces " + don + " sous.");
		beneficiaire.recevoir(don);
		perdreArgent(don);
	}
}
