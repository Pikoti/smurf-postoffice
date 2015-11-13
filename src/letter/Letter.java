package letter;

import city.*;

/**
 * I am the parent class of all the letters
 */

public abstract class Letter implements Comparable<Letter> {

	protected Inhabitant sender;
	protected Inhabitant receiver;
	protected double cost;
	public City city;
	
	public Letter (Inhabitant sender, Inhabitant receiver) {
		this.sender = sender;
		this.receiver = receiver; 
	}

	/**
	 * Set new cost of a letter
	 * 
	 * @param cost the new cost setting
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	/**
	 * Get the cost of the letter cost by default= 1€
	 */
	public double getCost() {
		return 1;
	}

	/**
	 * Post the letter to the city
	 * 
	 * @param city The city where to post the letter
	 */
	public void postLetter(City city) {
		if (sender.getAccount().balanced() - this.getCost() > 0) {			
			if (this.isUrgent()) {
				city.addUrgentLettersCollected(this);
			} else {
				city.addLettersCollected(this);
			}
		}
	}

	/**
	 * True if letter is urgent (by default false)
	 * 
	 * @return true if urgent
	 */

	public boolean isUrgent() {
		return false;
	}

	/**
	 * True if letter is a registeredLetter (by default false)
	 * 
	 * @return true if registered
	 */
	public boolean isRegisterLetter() {
		return false;
	}

	/**
	 * Create the answer to be sent by receiver (by default do nothing)
	 * */
	public void createAnswer() {
	}

	/**
	 * Send created answer to be sent by receiver (by default do nothing)
	 * */
	public void sendAnswer() {
	}

	/**
	 * Compare lexicographically 2 letters for sorting
	 * 
	 * @return -1 if <code>this<code> letter precedes argument letter
	 * @return 0 if equals
	 * @return 1 if <code>this<code> letter comes after argument letter
	 * */
	public int compareTo(Letter letter) {
		return this.receiver.getName().compareTo(letter.receiver.getName());
	}
	
	public abstract String getDescription();
	
	public String toString () {
		return getDescription() + " from " + sender + " to " + receiver;
	}
}
