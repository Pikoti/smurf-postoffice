package letter;

import city.*;

/**
 * I am the parent class of all the letters.
 */

public abstract class Letter implements Comparable<Letter> {

	protected Inhabitant sender;
	protected Inhabitant receiver;
	protected double cost;
	protected City city;
	
	
	public abstract String getDescription();	
	public abstract void doAction();

	public Letter (Inhabitant sender, Inhabitant receiver) {
		this.sender = sender;
		this.receiver = receiver;
		city = new City("village");
		cost = 1;
	}
	
	/**
	 * Get the city of letter.
	 * @return city the city of <code>this</code>
	 */
	public City getCity() {
		return city;
	}
	
	/**
	 * Set new cost of a letter.
	 * @param cost the new cost setting.
	 */
	public void setCost() {
		this.cost = 1;
	}
	
	/**
	 * Get the cost of the letter cost by default= 1.
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * Add the letter to the collectedLetters of the city. 
	 * @param letter to be collected.
	 * @param city where the letter is posted.
	 */
	public void collectLetter(City city, Letter letter) {
		city.getPostbox().addLettersCollected(letter);
	}
	
	/**
	 * Post the letter to the postbox of the city.
	 * @param city The city where to post the letter.
	 */
	public void postLetter(City city) {
		if (sender.getAccount().balance() - this.getCost() > 0) {
			sender.payLetter(this);
			collectLetter(city,this);
		}
	}

	/**
	 * True if letter is urgent (by default false).
	 * @return true if urgent.
	 */
	public boolean isUrgent() {
		return false;
	}

	/**
	 * True if letter is a registeredLetter (by default false).
	 * @return true if registered.
	 */
	public boolean isRegisterLetter() {
		return false;
	}

	/**
	 * Compare lexicographically 2 letters for sorting.
	 * @return -1 if <code>this<code> letter precedes argument letter.
	 * @return 0 if equals.
	 * @return 1 if <code>this<code> letter comes after argument letter.
	 */
	public int compareTo(Letter letter) {
		return this.receiver.getName().compareTo(letter.receiver.getName());
	}
	/**
	 * Get the delivery process of a letter toString.
	 * @return string description of letter delivery process.
	 */
	public String toString () {
		return getDescription() + " from " + sender + " to " + receiver;
	}
}
