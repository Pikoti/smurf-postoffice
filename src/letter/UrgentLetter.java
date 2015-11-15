package letter;

import city.City;
import city.Inhabitant;
import exceptions.AlreadyUrgentException;


/**
 * A besoin du type Generique Letter
 * I am an urgentLetter I am delivered the next day
 */

public class UrgentLetter extends Letter {

	protected Letter letter;

	public UrgentLetter(Inhabitant sender, Inhabitant receiver,Letter letter) throws AlreadyUrgentException {
		super(sender, receiver);
		if (letter.isUrgent()) throw new AlreadyUrgentException();
		this.letter = letter;
	}
	
	/**
	 * Set the cost of urgent letter.
	 */
	public void setCost() {
		cost = 2 * getCost(); 
	}
	
	/**
	 * True if letter is urgent.
	 * @return true if urgent.
	 */
	public boolean isUrgent() {
		return true;	
	}
	
	/**
	 * Add the letter to the collectedLetters of the city. 
	 * @param letter to be collected.
	 * @param city where the urgentLetter is posted.
	 */
	public void collectLetter(City city, UrgentLetter letter) {
		city.getPostbox().addUrgentLettersCollected(letter);
	}
	
	/**
	 * Return string description of <code>this</code> letter.
	 */
	public String getDescription() {
		return "urgent letter";	
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}
}

