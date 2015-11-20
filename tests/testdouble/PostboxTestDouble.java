package testdouble;

import java.util.List;

import city.Postbox;
import letter.Letter;

public class PostboxTestDouble extends Postbox{

	public PostboxTestDouble() {
		super();
	}

	public List<Letter<?>> getLettersCollected(){
		return lettersCollected;
	}
	
	public List<Letter<?>> getLettersToBeDistributed(){
		return lettersToBeDistributed;
	}
	
	public List<Letter<?>> getUrgentLettersCollected() {
		return urgentLettersCollected;
	}
}
