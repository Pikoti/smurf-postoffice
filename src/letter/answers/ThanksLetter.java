package letter.answers;
import city.*;
import letter.SimpleLetter;


/**
 * I am a thanks letter send after reception of money.
 */

public class ThanksLetter extends SimpleLetter {

	public ThanksLetter(Inhabitant sender, Inhabitant receiver){
		super(sender, receiver, "Thanks for the money!");
	}
	
	public String getDescription () {
		return "thanks letter";
	}
}

