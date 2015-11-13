package content;


/**
 * I am a Content double for a letter (money) 
 */

public class DoubleContent implements Content {
	
	protected double money;
	
	/**
	 * get the amount of money (of a letter)
	 * @return amount of money of the letter
	 */	
	public double getContent() {
		return money;	
	}
	
	/**
	 * set double content of a letter
	 * @param content to set 
	 */
	public void setConten(Double money) {
			this.money = money;
	}
}

