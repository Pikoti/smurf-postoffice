package city;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import letter.Letter;


/**
 * I am the nevralgic center of collection, sorting and preparation of the letters for distribution.
 */

public class Postbox {

	protected int capacity;
	protected List<Letter> lettersCollected;
	protected List<Letter> lettersToBeDistributed;
	protected List<Letter> urgentLettersCollected;
	
	
	public Postbox() {
		this.capacity = 5;
		this.lettersCollected = new ArrayList<Letter>();
		lettersToBeDistributed = new ArrayList<Letter>();
		this.urgentLettersCollected = new ArrayList<Letter>();
	}	
	
	/**
	 * Set the new list of letters to be posted.
	 */
	protected void setDailyPostbox(List<Letter> lettersOfDay) {
		lettersToBeDistributed.addAll(lettersOfDay);
	}
	
	/**
	 * Add a letter to lettersCollected. 
	 */
	public void addLettersCollected(Letter letter) {
		lettersCollected.add(letter);
	}

	/**
	 * Add a letter to urgentlettersCollected.
	 */
	public void addUrgentLettersCollected(Letter letter) {
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
	 * Clear the list of letters to be distributed.
	 */
	public void clearLettersToBeDistributed() {
		lettersToBeDistributed.clear();
	}

	/**
	 * Send the letters to the daily postbox for delivery.
	 */
	public void sendLetter() {
		int i = 0;
		ArrayList<Letter> sublist = new ArrayList<Letter>();
		while (i++ < capacity && lettersCollected.size() > 0) {
			sublist.add(lettersCollected.remove(0));
		}
		this.setDailyPostbox(urgentLettersCollected);
		this.setDailyPostbox(sublist);
		urgentLettersCollected.clear();
	}
	
	/**
	 * Get an iterator to be able to iterate on lettersToBeDistributed.
	 * @return Iterator<Letter> the iterator.
	 */
	protected Iterator<Letter> getPostboxIterator() {
		Collections.sort(lettersToBeDistributed);
		return lettersToBeDistributed.iterator();
	}
}

