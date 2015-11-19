package letter;

import city.Postbox;
import letter.Letter;
import letter.answer.AcknowlegmentOfReceipt;

public class RegisteredLetter<L extends Letter> extends LetterDecorator {

	public RegisteredLetter(L letter){
		super(letter);
		this.cost = cost + 15;
	}
	
	public boolean isRegistered() {
		return true;	
	}
	
	public String getDescription () {
		return "registered letter";
	}

	@Override
	public void doAction(Postbox postbox) {
		Letter answer = new AcknowlegmentOfReceipt(this.receiver, this.sender);
		answer.postTo(postbox);
	}
}

