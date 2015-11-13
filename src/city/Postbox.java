package city;
import java.util.ArrayList;
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
	 * Get the list of letters to be posted
	 * @return lettersToBeDistributed
	 */
	protected List<Letter> getPostbox() {
		return lettersToBeDistributed;
	}
	
	/**
	 * Set the day list of letters to be posted
	 */
	protected void setDailyPostbox(List<Letter> lettersOfDay) {
		lettersToBeDistributed.addAll(lettersOfDay);
	}
	
	/**
	 * sort by inhabitant
	 * */
	protected void sort() {
		
	}
}

