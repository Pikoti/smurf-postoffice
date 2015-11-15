package content;


/**
 * I am a Content double for a letter (money) 
 */

public class DoubleContent implements Content {
	
	protected double money;
	
	public DoubleContent (double money) {
		this.money = money;
	}
	
	/**
	 * Get the amount of money (of a letter).
	 * @return amount of money of the letter.
	 */	
	public double getContent() {
		return money;	
	}
	
	/**
	 * Set double content of a letter.
	 * @param content to set.
	 */
	public void setContent(Double money) {
			this.money = money;
	}
}

