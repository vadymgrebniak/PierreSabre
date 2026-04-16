package personnages;

public class Yakuza extends Humain {
	private String clan;
	private int reputation = 0;

	public Yakuza(String nom, String boissonPrefere, int quantiteArgent, String clan) {
		super(nom, boissonPrefere, quantiteArgent);
		this.clan = clan;
	}
	
	public int getReputation() {
		return reputation;
	}

	public void extorquer(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		parler(victime.getNom() + ", si tu tiens à la vie donne moi ta bourse !");
		int argentPique = victime.seFaireExtorquer();
		gagnerArgent(argentPique);
		gagnerReputation();
		parler("J’ai piqué les " + argentPique + " sous de " + victime.getNom() + ", ce qui me fait " + argent
				+ " sous dans ma poche. Hi ! Hi !");
	}
	
	public void gagner(int gain) {
		gagnerArgent(gain);
		gagnerReputation();
		parler("Ce ronin pensait vraiment battre " + nom + " du clan de " + clan 
				+ " ? Je l'ai dépouillé de ses " + gain + " sous.");
	}
	
	public int perdre() {
		int perte = argent;
		perdreArgent(argent);
		perdreReputation();
		parler("J'ai perdu mon duel et mes " + perte + " sous, snif... J'ai déshonoré le clan de " + clan + ".");
		return perte;
	}
	
	private void gagnerReputation() {
		reputation++;
	}
	
	private void perdreReputation() {
		reputation--;
		if (reputation < 0) {
			reputation = 0;
		}
	}
	
}
