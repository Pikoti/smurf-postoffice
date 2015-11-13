package city;

import letter.Letter;


/**
 * I am representing an inhabitant living in a city
 */

public class Inhabitant
{
	
	protected String name;
	protected Account account;
	protected City city;
	protected int numberOfLetterSent;

	public Inhabitant(String name, Account account, City city) {
		this.name = name;
		this.account = new Account();
		this.city = city;
	}
	
	/**
	 * Get name of <code>this<code> inhabitant
	 * @return name of <code>this<code> inhabitant
	 * */
	public String name() {
		return name;
	}

	/**
	 * Pay for a letter
	 * @param letter to pay
	 * */
	public void payLetter(Letter letter) {		
		 account.debit(letter.getCost());
	}
}

