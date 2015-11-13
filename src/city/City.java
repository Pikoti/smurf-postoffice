package city;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import letter.Letter;
import letter.NotEnoughMoneyException;


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
	protected List<Letter> urgentLettersCollected;
		
	public City(String name,int capacity) {
		this.name = name;
		this.capacity = capacity;
		this.inhabitants = new ArrayList<Inhabitant>();
		this.lettersCollected = new ArrayList<Letter>();
		this.postbox = new Postbox();
	}

	/**
	 * Get lettersCollected of the city
	 * @return lettersCollected of the city
	 * */
	public List<Letter> getlettersCollected() {
		return lettersCollected;
	}

	/**
	 * Get urgentlettersCollected of the city
	 * @return urgentlettersCollected of the city
	 * */
	public List<Letter> geturgentLettersCollected() {
		return urgentLettersCollected;
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
		postbox.setDailyPostbox(urgentLettersCollected);
		postbox.setDailyPostbox(lettersCollected.subList(0,capacity));
		urgentLettersCollected.clear();
		lettersCollected.subList(0,capacity).clear();
	}
}

