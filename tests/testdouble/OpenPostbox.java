package testdouble;

import java.util.List;

import city.Postbox;
import letter.Letter;

public class OpenPostbox extends Postbox{

	public OpenPostbox() {
		super();
	}

	public List<Letter> getLettersCollected(){
		return lettersCollected;
	}
	
	public List<Letter> getLettersToBeDistributed(){
		return lettersToBeDistributed;
	}
	
	public List<Letter> getUrgentLettersCollected() {
		return urgentLettersCollected;
	}
}
