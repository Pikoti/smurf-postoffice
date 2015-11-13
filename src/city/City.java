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
	 * sort the urgent, add to postbox
	 * count urgent letters
	 * add all urgent
	 * add capacity-cu to postbox
	 * if cu > capacity?
	 * 
	 * 2 listes urgentes et non  urgentes
	 * */
	
	
	/**
	 * Set the postbox of the day from the collected letters
	 * add number of letter to new post box
	 */
	
	public void sendLetter() {
		postbox.setDailyPostbox(lettersCollected.subList(0,nbUrgent));
		postbox.setDailyPostbox(lettersCollected.subList(0,capacity));
		lettersCollected.subList(0,capacity).clear();
	}
	
}

