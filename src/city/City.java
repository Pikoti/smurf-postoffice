package city;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import letter.Letter;


/**
 * I am a city of inhabitants
 */

public class City
{	
	protected String name;
	protected List<Inhabitant> inhabitants;
	protected Postbox postbox;
	protected int capacity;
	protected List<Letter> lettersCollected;
	protected List<Letter> urgentLetters;
	
	
	public City(String name,int capacity) {
		this.name = name;
		this.capacity = capacity;
		this.inhabitants = new ArrayList<Inhabitant>();
		this.lettersCollected = new ArrayList<Letter>();
		this.postbox = new Postbox();
	}
	
	/**
	 * Distribute the letters of the postBox to the inhabitants
	 * */
	public void distributeLetter() {
		for (Letter letter: postbox.getPostbox()) {
			letter.postLetter();
			letter.createAnswer();
			letter.sendAnswer();
		}
		postbox.getPostbox().clear();
	}
	
	/**
	 * Set the postbox of the day from the collected letters
	 * add number of letter to new post box
	 */
	public void sendLetter() {
		postbox.setDailyPostbox(urgentLetters);
		postbox.setDailyPostbox(lettersCollected.subList(0,capacity));
		urgentLetters.clear();
		lettersCollected.subList(0,capacity).clear();
	}
}

