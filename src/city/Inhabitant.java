package city;

import letter.Letter;

/**
 * I am representing an inhabitant living in a city
 */

public class Inhabitant {

	protected String name;
	protected Account account;

	public Inhabitant(String name) {
		this.name = name;
		this.account = new Account();
	}

	/**
	 * Get account of <code>this<code> inhabitant
	 * @return account of <code>this<code> inhabitant
	 * */
	public Account getAccount() {
		return account;
	}

	/**
	 * Get name of <code>this<code> inhabitant
	 * @return name of <code>this<code> inhabitant
	 * */
	public String getName() {
		return name;
	}

	/**
	 * Pay for a letter
	 * @param letter to pay
	 * */
	public void payLetter(Letter letter) {
		account.debit(letter.getCost());
	}
	
	/**
	 * Return the string name of the inhabitant
	 * @return name the name of the inhabitant
	 */
	public String toString() {
		return getName();
	}
}
