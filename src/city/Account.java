package city;

/**
 * I am a bank account of an inhabitant
 */

public class Account {

	protected double amount;

	public Account() {
		this(0);
	}

	public Account(double amount) {
		this.amount = amount;
	}

	/**
	 * Subtract money from <code>this<code> account
	 * 
	 * @param cost to subtract from amount
	 * @return final amount of <code>this<code> account
	 */
	public double debit(double cost) {
		return amount -= cost;
	}

	/**
	 * Add money to <code>this<code> account
	 * 
	 * @param profit to add to amount
	 * @return final amount of <code>this<code> account
	 */
	public double credit(double profit) {
		return amount += profit;
	}

	/**
	 * get amount of <code>this<code> account
	 * 
	 * @return final amount of <code>this<code> account
	 */
	public double balanced() {
		return amount;
	}
}
