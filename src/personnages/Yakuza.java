package personnages;

public class Yakuza extends Humain {
	private String clan;
	private int reputation = 0;

	public Yakuza(String nom, String boissonPrefere, int quantiteArgent, String clan) {
		super(nom, boissonPrefere, quantiteArgent);
		this.clan = clan;
	}

	public void extorquer(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		parler(victime.getNom() + ", si tu tiens à la vie donne moi ta bourse !");
		int argentPique = victime.seFaireExtorquer();
		gagnerArgent(argentPique);
		reputation++;
		parler("J’ai piqué les " + argentPique + " sous de " + victime.getNom() + ", ce qui me fait " + quantiteArgent
				+ " sous dans ma poche. Hi ! Hi !");
	}
}
