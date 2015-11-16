package letter;

import city.Inhabitant;
import city.Postbox;
import exception.AlreadyUrgentException;

/**
 * A besoin du type Generique Letter I am an urgentLetter I am delivered the
 * next day
 */

public class UrgentLetter extends Letter {

	protected Letter letter;

	public UrgentLetter(Inhabitant sender, Inhabitant receiver, Letter letter) throws AlreadyUrgentException {
		super(sender, receiver);
		if (letter.isUrgent()) {
			throw new AlreadyUrgentException();
		}
		this.letter = letter;
		cost = 2 * getCost();
	}

	/**
	 * @see Letter
	 */
	public boolean isUrgent() {
		return true;
	}

	/**
	 * @see Letter
	 */
	public void addTo(Postbox postbox) {
		postbox.addUrgentLettersCollected(this);
	}

	/**
	 * Return string description of <code>this</code> letter.
	 */
	public String getDescription() {
		return "urgent letter";
	}

	@Override
	public void doAction(Postbox postbox) {
		// TODO Auto-generated method stub

	}
}
