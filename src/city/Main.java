package city;

import java.util.ArrayList;

import letter.Letter;
import letter.SimpleLetter;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Inhabitant pluto = new Inhabitant("pluto");
		Inhabitant mickey = new Inhabitant("mickey");
		Inhabitant minnie = new Inhabitant("minnie");
		Inhabitant donald = new Inhabitant("donald");
		Inhabitant picsou = new Inhabitant("picsou");
		Inhabitant riri = new Inhabitant("riri");
		Inhabitant fifi = new Inhabitant("fifi");
		Inhabitant loulou = new Inhabitant("loulou");

		City disneyLand = new City("disney land");
		Postbox postbox = disneyLand.getPostbox();

		ArrayList<Inhabitant[]> couples = new ArrayList<Inhabitant[]>();
		couples.add(new Inhabitant[] { pluto, mickey });
		couples.add(new Inhabitant[] { mickey, minnie });
		couples.add(new Inhabitant[] { mickey, pluto });
		couples.add(new Inhabitant[] { minnie, mickey });
		couples.add(new Inhabitant[] { donald, picsou });
		couples.add(new Inhabitant[] { riri, fifi });
		couples.add(new Inhabitant[] { fifi, picsou });
		couples.add(new Inhabitant[] { mickey, loulou });
		
		for (Inhabitant[] couple : couples) {
			addLettersCollected(disneyLand, couple[0], couple[1]);
		}

		Printer.print("Day 1");
		postbox.sendLetter();
		postbox.distributeLetter();
		Printer.print("Day 2");
		postbox.sendLetter();
		postbox.distributeLetter();

	}

	public static void addLettersCollected(City city, Inhabitant sender,
			Inhabitant receiver) {
		city.getPostbox().addLettersCollected(createSimpleLetter(sender, receiver));
	}

	public static Letter createSimpleLetter(Inhabitant sender,
			Inhabitant receiver) {
		return new SimpleLetter(sender, receiver, "salut " + receiver + " ici "
				+ sender + "!");
	}
}
