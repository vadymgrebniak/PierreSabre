package personnages;

import java.awt.Window.Type;
import java.util.Random;

public class GrandMere extends Humain {
	private enum TypeHumain {
		humain("habitant"),
		commercant("commerçant"), 
		ronin("ronin");
		
		private String description;
		
		private TypeHumain(String description) {
			this.description = description;
		}
		
		public String getDescripton() {
			return description;
		}
	}
	
	private static final int MAX_NB_CONNAISSANCE = 5;
	private TypeHumain[] types = TypeHumain.values();
	
	public GrandMere(String nom, int argent) {
		super(nom, "tisane", argent);
		memoire = new Humain[MAX_NB_CONNAISSANCE];
	}
	
	public void ragoter() {
		for (Humain personne : memoire) {
			if (personne instanceof Traitre) {
				parler("Je sais que " + personne.getNom() + " est un traître. Petit chenapan !");
			} else {
				parler("Je crois que " + personne.getNom() + " est un " + humainHasard());
			}
		}
	}
	
	@Override
	protected void memoriser(Humain humain) {
		if (nbConnaissance == MAX_NB_CONNAISSANCE) {
			parler("Oh ma tête ! Je ne peux plus retenir le nom d'une personne supplémentaire !");
		} else {
			super.memoriser(humain);
		}
	}
	
	private String humainHasard() {
		Random rand = new Random();
		TypeHumain[] types = TypeHumain.values();
		int tailleTypes = types.length;
		return types[rand.nextInt(tailleTypes)].getDescripton();
	}
	

}
