package city;

import java.util.ArrayList;
import java.util.List;

import java.util.Iterator;

import letter.Letter;

/**
 * I am a city of inhabitants.
 */

public class City {

	protected String name;
	protected Postbox postbox;
	protected List<Inhabitant> inhabitants;

	
	public City(String name) {
		this.name = name;
		this.inhabitants = new ArrayList<Inhabitant>();
		this.postbox = new Postbox();
	}
	
	/**
	 * Get the postbox of the city.
	 * @return postbox of the city.
	 */
	public Postbox getPostbox(){
		return postbox;
	}
	
	/**
	 * Add an inhabitant to the city.
	 * @param inhabitant the inhabitant to add.
	 */
	public void addInhabitant(Inhabitant inhabitant) {
		inhabitants.add(inhabitant);
	}

	/**
	 * Distribute the letters of the postBox to the inhabitants.
	 */
	public void distributeLetter() {
		Iterator<Letter> it = postbox.getPostboxIterator();
		while (it.hasNext()) {
			Letter letter = it.next();
			Printer.print(letter);
			letter.createAnswer();
			letter.sendAnswer();
		}
		postbox.clearLettersToBeDistributed();
	}

	/**
	 * Send the letters for the daily delivery.
	 */
	public void sendLetter() {
		postbox.sendLetter();
	}
}
