package city;
import java.util.*;
import letter.*;


/**
 * I am the nevralgic center of collect, sort and preparation of the letters for distribution.
 */

public class Postbox {

	protected int capacity;
	protected List<Letter<?>> lettersCollected;
	protected List<Letter<?>> lettersToBeDistributed;
	protected List<Letter<?>> urgentLettersCollected;
	
	
	public Postbox() {
		capacity = 15;
		lettersCollected = new ArrayList<Letter<?>>();
		lettersToBeDistributed = new ArrayList<Letter<?>>();
		urgentLettersCollected = new ArrayList<Letter<?>>();
	}	
	
	/**
	 * Set the new list of letters to be posted.
	 */
	protected void setDailyPostbox(List<Letter<?>> lettersOfDay) {
		lettersToBeDistributed.addAll(lettersOfDay);
	}
	
	/**
	 * Add a letter to lettersCollected. 
	 */
	public void addLettersCollected(Letter<?> letter) {
		lettersCollected.add(letter);
	}

	/**
	 * Add an urgent letter to urgentlettersCollected.
	 */
	public void addUrgentLettersCollected(UrgentLetter<?> letter) {
		urgentLettersCollected.add(letter);
	}

	/**
	 * Sort the lettersToBeDistributed by inhabitant for the delivery.
	 * (group by inhabitant).
	 */
	protected void sort() {
		Collections.sort(lettersToBeDistributed);
	}

	/**
	 * Distribute the letters of the postBox to the inhabitants.
	 */
	public void distributeLetter() {
		sort();
		for (Letter<?> letter : lettersToBeDistributed) {
			Printer.printMailing(letter);
			letter.doAction(this);
		}
	}

	/**
	 * Send the letters to the daily postbox for the new day delivery.
	 */
	public void sendLetter() {
		int i = 0;
		ArrayList<Letter<?>> sublist = new ArrayList<Letter<?>>();
		receiveLetter();
		while (i++ < capacity && lettersCollected.size() > 0) {
			sublist.add(lettersCollected.remove(0));
		}
		setDailyPostbox(urgentLettersCollected);
		setDailyPostbox(sublist);
		urgentLettersCollected.clear();
	}

	/**
	 * Print the reception of the letters,
	 *  clear (previous day) letters to be distributed 
	 */
	public void receiveLetter() {
		sort();
		for (Letter<?> letter : lettersToBeDistributed) {
			Printer.printReception(letter);
		}
		lettersToBeDistributed.clear();
	}
	
	
	/**
	 * Tells if there are letters to be distributed
	 * @return true if there are letters to be distributed
	 */
	public boolean hasLettersToBeDistributed() {
		return !lettersToBeDistributed.isEmpty();
	}
	
	/**
	 * Tells if there how many letters need to be distributed
	 * @return number of letters to be distributed
	 */
	public int numberOfLettersToBeDistributed() {
		return lettersToBeDistributed.size();
	}
	
	/**
	 * Tells if there how many non letters are collected
	 * @return number of letters collected
	 */	
	public int numberOfLettersCollected() {
		return lettersCollected.size();
	}
	/**
	 * Tells if there how many non letters are collected
	 * @return number of letters collected
	 */	
	public int numberOfUrgentLettersCollected() {
		return urgentLettersCollected.size();
	}
}


