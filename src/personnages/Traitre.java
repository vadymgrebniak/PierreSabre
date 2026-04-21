package personnages;

import java.util.Random;

public class Traitre extends Samourai {
	private static final int MAX_NIVEAU_POUR_RANCONNER = 3;
	private int niveauTraitrise = 0;
	
	public Traitre(String seigneur, String nom, String boissonPrefere, int argent) {
		super(seigneur, nom, boissonPrefere, argent);
	}

	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mais je suis un traître et mon niveau de traîtrise est : " + niveauTraitrise + ". Chut !");
	}
	
	public void ranconner(Commercant commercant) {
		if (niveauTraitrise < MAX_NIVEAU_POUR_RANCONNER) {
			int argentRanconner = commercant.getArgent() * 2 / 10;
			
			commercant.perdreArgent(argentRanconner);
			gagnerArgent(argentRanconner);
			augmenterNiveauTraitrise();
			
			parler("Si tu veux ma protection contre les Yakuzas, il va falloir payer ! "
					+ "Donne-moi " + argentRanconner + " sous ou gare à toi !");
			commercant.parler("Tout de suite grand " + getNom() + ".");
		}
		else {
			parler("Mince, je ne peux plus rançonner personne sinon un samouraï "
					+ "risque de me démasquer !");
		}
	}
	
	public void faireLeGentil() {
		if (nbConnaissance < 1) {
			parler("Je ne peux faire ami avec personne car je ne connais personne ! Snif.");
		}
		else {
			Random rand = new Random();
			Humain ami = memoire[rand.nextInt(nbConnaissance)];
			int don = argent / 20;
			String nomAmi = ami.getNom();
			
			parler("Il faut absolument remonter ma cote de confiance. Je vais faire ami ami avec " + nomAmi + ".");
			parler("Bonjour l'ami ! Je voudrais vous aider en vous donnant " + don + " sous.");
			
			ami.gagnerArgent(don);
			perdreArgent(don);
			
			ami.parler("Merci " + getNom() + ". Vous êtes quelqu'un de bien.");
			diminuerNiveauTraitrise();
		}
	}
	
	private void augmenterNiveauTraitrise() {
		niveauTraitrise++;
	}
	
	private void diminuerNiveauTraitrise() {
		niveauTraitrise--;
		if (niveauTraitrise < 0) {
			niveauTraitrise = 0;
		}
	}
 
}
