package letter;

import city.Postbox;
import exception.AlreadyUrgentException;

/**
 * I am an urgentLetter I am delivered the next day
 */

public class UrgentLetter extends LetterDecorator {

	public UrgentLetter(Letter letter) throws AlreadyUrgentException {
		super(letter);
		if (letter.isUrgent()) {
			throw new AlreadyUrgentException();
		}
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
		this.letter.doAction(postbox);
	}
}
