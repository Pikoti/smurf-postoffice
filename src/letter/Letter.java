package letter;

import content.Content;
import city.*;

/**
 * I am the parent class of all the letters.
 */

public abstract class Letter<C extends Content> implements Comparable<Letter<?>>, Content {

	protected C content;
	protected Inhabitant sender;
	protected Inhabitant receiver;
	protected double cost = 1;

	public abstract String getDescription();

	public void doAction(Postbox postbox) {}

	public Letter(Inhabitant sender, Inhabitant receiver) {
		this.sender = sender;
		this.receiver = receiver;
	}

	public Letter(Inhabitant sender, Inhabitant receiver, C content) {
		this(sender, receiver);
		this.content = content;
	}

	/**
	 * Get the content of <code>this</code> letter.
	 * @return content of the letter.
	 */
	public C getContent() {
		return content;
	}
	
	
	/**
	 * Set content
	 */
	public void setContent(C content) {
		this.content = content;
	}

	/**
	 * Get the cost of the letter cost by default= 1.
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * Add the letter to the collectedLetters of the postbox.
	 * 
	 * @param postbox Postbox in which the letter is posted.
	 */
	protected void addTo(Postbox postbox) {
		postbox.addLettersCollected(this);
	}

	/**
	 * Post the letter to the postbox of the city.
	 * 
	 * @param postbox The postbox in which to post the letter.
	 */
	public void postTo(Postbox postbox) {
		if (sender.getAccount().balance() - this.getCost() > 0) {
			sender.payLetter(this);
			this.addTo(postbox);
		}
	}

	/**
	 * True if letter is urgent (by default false).
	 * 
	 * @return true if urgent.
	 */
	public boolean isUrgent() {
		return false;
	}

	/**
	 * True if letter is a registeredLetter (by default false).
	 * 
	 * @return true if registered.
	 */
	public boolean isRegisteredLetter() {
		return false;
	}

	/**
	 * Compare lexicographically 2 letters for sorting.
	 * 
	 * @return -1 if <code>this<code> letter precedes argument letter.
	 * @return 0 if equals.
	 * @return 1 if <code>this<code> letter comes after argument letter.
	 */
	public int compareTo(Letter<?> letter) {
		return this.receiver.getName().compareTo(letter.receiver.getName());
	}

	/**
	 * Get the delivery process of a letter toString.
	 * 
	 * @return string description of letter delivery process.
	 */
	public String toString() {
		return getDescription() + " from " + sender + " to " + receiver;
	}
}
