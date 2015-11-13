package city;

import java.util.ArrayList;
import java.util.List;

import java.util.Iterator;

import letter.Letter;

/**
 * I am a city of inhabitants
 */

public class City {

	protected String name;
	protected Postbox postbox;
	protected int capacity;
	protected List<Inhabitant> inhabitants;
	protected List<Letter> lettersCollected;
	protected List<Letter> urgentLettersCollected;

	public City(String name) {
		this.name = name;
		this.capacity = 5;
		this.inhabitants = new ArrayList<Inhabitant>();
		this.lettersCollected = new ArrayList<Letter>();
		this.urgentLettersCollected = new ArrayList<Letter>();
		this.postbox = new Postbox();
	}

	public void addInhabitant(Inhabitant inhabitant) {
		inhabitants.add(inhabitant);
	}

	/**
	 * Add a letter to lettersCollected of the city
	 * */
	public void addLettersCollected(Letter letter) {
		lettersCollected.add(letter);
	}

	/**
	 * Add a letter to urgentlettersCollected of the city
	 * */
	public void addUrgentLettersCollected(Letter letter) {
		urgentLettersCollected.add(letter);
	}

	/**
	 * Distribute the letters of the postBox to the inhabitants
	 * */
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
	 * Set the postbox of the day from the collected letters add number of
	 * letter to new post box
	 */
	public void sendLetter() {
		int i = 0;
		ArrayList<Letter> sublist = new ArrayList<Letter>();
		while (i++ < capacity && lettersCollected.size() > 0) {
			sublist.add(lettersCollected.remove(0));
		}
		postbox.setDailyPostbox(urgentLettersCollected);
		postbox.setDailyPostbox(sublist);
		urgentLettersCollected.clear();
	}
}
