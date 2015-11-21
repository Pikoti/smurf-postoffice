package letter;

import exception.NotEnoughMoneyException;

public abstract class LetterDecorator<L extends Letter<?>> extends Letter<L> {
	
	public LetterDecorator(L letter) throws NotEnoughMoneyException {
		super(letter.sender, letter.receiver, letter);
	}

	public boolean isUrgent() {
		return this.content.isUrgent() || false;
	}
	
	public boolean isRegisteredLetter() {
		return this.content.isRegisteredLetter() || false;
	}
}
