package city;

import java.util.Random;
import city.City;
import letter.*;

public class MainRandom {

	public static City city;
	public static Random rn = new Random(139245678);
	public static Letter<?> letter;

	// @formatter:off
	private static String[] names = { 
		"bricoleur", "arrogant", "chançard", "à lunettes", "boudeur", "patient", "calme", "volant", "fonçeur", "gourmand", 
		"habile", "musicien", "grognon", "poète", "paysan", "prudent", "boulanger", "paresseux", "prétentieux", "amoureux", 
		"distrait", "forgeron", "menuisier", "bûcheron", "plombier", "farceur", "penseur", "méfiant", "batailleur", "peureux", 
		"colérique", "charitable", "frileux", "coquet", "rêveur", "admiratif", "costaud", "sale", "bavard", "patineur", 
		"courageux", "tailleur", "sculpteur", "gêné", "inquiet", "bêta", "cuisinier", "patissier", "enjoué", "impatient", 
		"facteur", "magicien", "mollasson", "nature", "tambour", "cloueur", "exotique", "peintre", "mineur", "astronome", 
		"archéologue", "maladroit", "volant", "voyageur", "météo", "patineur", "apprenti", "pêcheur", "veilleur", 
		"observateur", "attentif", "susceptible", "inattentif", "naïf", "malade", "médecin", "persévérant", "prudent", 
		"ramoneur", "ingrat", "courtois", "original", "hésitant", "propositeur", "chétif", "fêteur", "charpentier", 
		"cordonnier", "éleveur", "ouvrier", "meunier", "missionnaire", "imprudent", "timide", "égoïste", "distributeur", 
		"énervé", "exaspéré", "reflet", "sauvage", "Schtroumpfette", "bébé", "robot", "vieux", "Grand Schtroumpf", "Sassette" 
	};
	// @formatter:on

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int i, j, nLetters;
		city = new City("village des Schtroumpfs");
		Postbox postbox = city.getPostbox();

		for (i = 0; i < names.length; i++) {
			String name = "Schtroumpf " + names[i];
			double balance = 1000 * (rn.nextInt(5) + 1);
			city.addInhabitant(new Inhabitant(name, balance));
		}
		for (i = 0; i < 6; i++) {
			nLetters = rn.nextInt(50);
			for (j = 0; j < nLetters; j++) {
				letter = getRandomLetter();
				// System.out.println("sender " + sender.getName());
				// System.out.println("receiver" + receiver.getName());
				letter.postTo(postbox);
				// System.out.println("typeletter  " + letter.getDescription());
			}
			System.out.println("NOMBRE DE LETTRES " + j);
			Printer.print("Day " + (i + 1));
			postbox.sendLetter();
			postbox.distributeLetter();
			System.out.println("LETTERS COLL  " + postbox.numberOfLettersCollected());
			System.out.println("LETTERS LEFT  " + postbox.numberOfLettersToBeDistributed());
		}

		postbox.sendLetter();
		while (postbox.hasLettersToBeDistributed() && i < 100) {
			postbox.distributeLetter();
			postbox.sendLetter();
			System.out.println("LETTERS COLL  " + postbox.numberOfLettersCollected());
			System.out.println("LETTERS LEFT  " + postbox.numberOfLettersToBeDistributed());
			Printer.print("Day " + (i + 1));
			i++;
		}
	}

	public static Inhabitant getRandomInhabitant() {
		return city.getInhabitant(rn.nextInt(city.getNumberInhabitants()));
	}

	public static Letter<?> getRandomLetter() {
		Inhabitant receiver = getRandomInhabitant();
		Inhabitant sender = getRandomInhabitant();
		switch (rn.nextInt(2)) {
			case 0:
				return new UrgentLetter<SimpleLetter>(new SimpleLetter(sender, receiver, "blabla"));
			default:
				return new SimpleLetter(sender, receiver, "salut " + receiver + " ici " + sender + "!");
		}
	}
}