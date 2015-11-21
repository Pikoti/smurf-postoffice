package content;


/**
 * I am a Content double for a letter (money).
 */

public class DoubleContent implements Content {
	
	protected double value;
	
	public DoubleContent (double value) {
		this.value = value;
	}
	
	/**
	 * Get the amount of money (of a letter).
	 * @return amount of money of the letter.
	 */	
	public double getValue() {
		return value;	
	}
	
	/**
	 * Set double content of a letter.
	 * @param value to set.
	 */
	public void setValue(Double value) {
			this.value = value;
	}

	/**
	 * Get description of <code>this</code> content
	 * @return description of the content
	 */
	public String getDescription() {
		return "money content" ;
	}
}

