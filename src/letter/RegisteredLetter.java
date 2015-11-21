package letter;

import city.Postbox;
import exception.AlreadyRegisteredException;
import exception.NotEnoughMoneyException;
import letter.Letter;
import letter.answer.AcknowlegmentOfReceipt;

public class RegisteredLetter<L extends Letter<?>> extends LetterDecorator<L> {

	public RegisteredLetter(L letter) throws NotEnoughMoneyException, AlreadyRegisteredException {
		super(letter);
		this.cost = cost + 15.0;
		if (letter.isRegisteredLetter()) {
			throw new AlreadyRegisteredException();
		}
	}
	
	public boolean isRegisteredLetter() {
		return true;	
	}
	
	public String getDescription () {
		return "registered letter";
	}

	@Override
	public void doAction(Postbox postbox) {
		AcknowlegmentOfReceipt answer = new AcknowlegmentOfReceipt(this.receiver, this.sender);
		answer.postTo(postbox);
	}
}

