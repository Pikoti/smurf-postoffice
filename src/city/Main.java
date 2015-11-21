package city;
import java.util.Random;
import city.City;
import exception.AlreadyRegisteredException;
import exception.AlreadyUrgentException;
import exception.AmountIsNegativeException;
import exception.NotEnoughMoneyException;
import letter.*;

public class Main {

	public static City city;
	public static Random rn = new Random(System.currentTimeMillis());
	public static Letter<?> letter;
	
	// @formatter:off
	private static String[] names = { 
		"bricoleur", "arrogant", "chancard", "a lunettes", "boudeur", "patient", "calme", "volant",
		"fonceur", "gourmand", "habile", "musicien", "grognon", "poete", "paysan", "prudent", 
		"boulanger", "paresseux", "pretentieux", "amoureux", "distrait", "forgeron", "menuisier",
		"bucheron", "plombier", "farceur", "penseur", "mefiant", "batailleur", "peureux", "colerique",
		"charitable", "frileux", "coquet", "reveur", "admiratif", "costaud", "sale", "bavard", "patineur", 
		"courageux", "tailleur", "sculpteur", "gene", "inquiet", "beta", "cuisinier", "patissier", "enjoue",
		"impatient", "facteur", "magicien", "mollasson", "nature", "tambour", "cloueur", "exotique", "peintre", 
		"mineur", "astronome", "archeologue", "maladroit", "volant", "voyageur", "meteo", "patineur",
		"apprenti", "pecheur", "veilleur", "observateur", "attentif", "susceptible", "inattentif", "naif",
		"malade","medecin","perseverant", "prudent", "ramoneur", "ingrat", "courtois", "original", "hesitant",
		"propositeur","chetif", "facteur", "charpentier", "cordonnier", "eleveur", "ouvrier", "meunier", 
		"missionnaire","imprudent", "timide","egoiste", "distributeur", "enerve", "exaspere", "reflet", 
		"sauvage", "Schtroumpfette", "bebe", "robot", "vieux","Grand Schtroumpf", "Sassette" 
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
			nLetters = rn.nextInt(70);
			for (j = 0; j < nLetters; j++) {
				try {
				letter = getRandomLetter();
				} catch(NotEnoughMoneyException e) {
					Printer.print(letter.getSender() + " had not enough money to send " + letter);
				} catch(AlreadyUrgentException e) {
					Printer.print(letter + "is already urgent");
				} catch(AlreadyRegisteredException e) {
					Printer.print(letter + "is already registered");
				} catch(AmountIsNegativeException e) {
					Printer.print(letter.getSender() + " tried to steal money from " 
				                  + letter.getReceiver());
				}
				letter.postTo(postbox);
			}
			Printer.print(".................................................................");
			Printer.print("Day " + (i + 1));
			postbox.sendLetter();
			postbox.distributeLetter();
			Printer.print("\n");
		}
		postbox.sendLetter();
		while (postbox.hasLettersToBeDistributed()) {
			postbox.distributeLetter();
			postbox.sendLetter();
			Printer.print("................................................................\n");
			Printer.print("Day " + (i + 1));
			i++;
		}
		i++;
		postbox.sendLetter();
		postbox.distributeLetter();
	}

	public static Inhabitant getRandomInhabitant() {
		return city.getInhabitant(rn.nextInt(city.getNumberInhabitants()));
	}

	public static Letter<?> getRandomLetter() {
		Inhabitant receiver = getRandomInhabitant();
		Inhabitant sender = getRandomInhabitant();
		switch (rn.nextInt(4)) {
		case 3:
			return new RegisteredLetter<SimpleLetter>(new SimpleLetter(sender, receiver, "La La La!"));
		case 2:
			return new PromissoryNote(sender, receiver, (double) Math.ceil(127 * rn.nextDouble()));
		case 1:
			return new UrgentLetter<SimpleLetter>(new SimpleLetter(sender, receiver, "La La La !"));
			default:
				return new SimpleLetter(sender, receiver, "salut " + receiver + " ici " + sender + "!");
		}
	}
}