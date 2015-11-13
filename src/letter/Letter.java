package letter;
import city.*;


/**
 * I am the parent class of all the letters
 */

public abstract class Letter implements Comparable <Letter>{

	protected Inhabitant sender;
	protected Inhabitant receiver;
	protected double cost;
	public City city;

	public abstract void createLetter();
	
	/**
	 * Set new cost of a letter
	 * @param cost  the new cost setting
	 */
	
	public void setCost(double cost) {
		this.cost = cost; 
	}
	
	/**
	 * Get the cost of the letter
	 */
	
	public double getCost() {
		return 1;	
	}
	
	/**
	 * Post the letter to the city
	 */
	
	public void postLetter() {

	}
	
	/**
	 * True if letter is urgent
	 * @return true if urgent
	 */
	
	public boolean isUrgent() {
		return false;	
	}

	/**
	 * True if letter is a registerLetter
	 * @return true if registered
	 */

	public boolean isRegisterLetter() {
		return false;	
	}
	
	/**
	 * Create answer to be sent by receiver
	 * by default do nothing
	 * */
	public void createAnswer() {}
	

	/**
	 * Send created answer to be sent by receiver
	 * by default do nothing
	 * */
	public void sendAnswer() {}
	
	
	/**
	 * compare 2 letters
	 * */
	public int compareTo(Letter letter) {
		return 1;
	}
	
}

