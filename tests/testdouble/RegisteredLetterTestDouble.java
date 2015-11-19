package testdouble;

import city.Postbox;
import letter.Letter;
import letter.RegisteredLetter;

public class RegisteredLetterTestDouble<L extends Letter> extends RegisteredLetter<L> {
	
	public RegisteredLetterTestDouble(L letter) {
		super(letter);
	}
	
	@Override
	public void postTo(Postbox postbox){
		super.postTo(postbox);
		
	}

}
