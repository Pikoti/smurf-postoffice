package city;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import letter.Letter;


/**
 * I am a postbox in a city my letters are to be distributed
 */

public class Postbox {

	protected List<Letter> lettersToBeDistributed;
	
	public Postbox() {
		lettersToBeDistributed = new ArrayList<Letter>();
	}

	/**
	 * Get the sorted list of letters to be posted
	 * @return lettersToBeDistributed
	 */
	protected Iterator<Letter> getPostboxIterator() {
		//Collections.sort(lettersToBeDistributed);
		return lettersToBeDistributed.iterator();
	}
	
	public void clearLettersToBeDistributed() {
		lettersToBeDistributed.clear();
	}
	
	/**
	 * Set the new list of letters to be posted
	 */
	protected void setDailyPostbox(List<Letter> lettersOfDay) {
		lettersToBeDistributed.addAll(lettersOfDay);
	}
	
	/**
	 * sort lettersToBeDistributed by inhabitant
	 * */
	protected void sort() {
		Collections.sort(lettersToBeDistributed);
	}
}

