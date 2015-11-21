package letter.answer;
import city.*;
import letter.SimpleLetter;


/**
 *I am an letter sent  at reception of a letter by the receiver
 */

public class AcknowlegmentOfReceipt extends SimpleLetter {
	public AcknowlegmentOfReceipt(Inhabitant sender, Inhabitant receiver){
		super(sender, receiver, " I received your letter !" );
	}
	
	public String getDescription () {
		return " acknowlegment of receipt " + "(" + content.getValue() + ")";
	}
}

