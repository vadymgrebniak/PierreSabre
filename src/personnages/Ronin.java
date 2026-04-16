package personnages;

public class Ronin extends Humain {
	int honneur = 1;

	public Ronin(String nom, String boissonPrefere, int quantiteArgent) {
		super(nom, boissonPrefere, quantiteArgent);
	}
	
	public void donner(Commercant beneficiaire) {
		int don = argent / 10;
		parler(beneficiaire.getNom() + " prend ces " + don + " sous.");
		beneficiaire.recevoir(don);
		perdreArgent(don);
	}
	
	public void provoquer(Yakuza adversaire) {
		int force = 2 * honneur;
		
		if (force >= adversaire.getReputation()) {
			parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");
			parler("Je t’ai eu petit yakusa!");
			gagnerArgent(adversaire.perdre());
			gagnerHonneur();
					}
		else {
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
			perdreHonneur();
			adversaire.gagner(argent);
			perdreArgent(argent);
		}
	}
	
	private void gagnerHonneur() {
		honneur++;
	}
	
	private void perdreHonneur() {
		honneur--;
		if (honneur < 0) {
			honneur = 0;
		}
	}
}
