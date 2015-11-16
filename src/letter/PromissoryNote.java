package letter;

import letter.answer.ThanksLetter;
import content.*;
import city.*;
import exception.AmountIsNegativeException;
import exception.NotEnoughMoneyException;

/**
 * I am a promissoryNote I send money.
 */

public class PromissoryNote extends Letter {

	protected DoubleContent content;

	public PromissoryNote(Inhabitant sender, Inhabitant receiver, Double money) throws NotEnoughMoneyException, AmountIsNegativeException {
		super(sender, receiver);
		if (money < 0) throw new AmountIsNegativeException();
		if (sender.getAccount().balance() < (getCost() + money)) throw new NotEnoughMoneyException();
		this.content = new DoubleContent(money);
		this.cost = cost + (0.01 * content.getValue());
	}

	/**
	 * Add the money to the account of the receiver. Subtract the amount of
	 * money from the sender.
	 */
	public void transfertMoney() {
		sender.getAccount().debit(content.getValue());
		receiver.getAccount().credit(content.getValue());
	}

	/**
	 * Transfer money, create and send the answer.
	 */
	public void doAction(Postbox postbox) {
		Letter answer = new ThanksLetter(receiver, sender);
		answer.postTo(postbox);
		transfertMoney();
	}

	/**
	 * Return string description of <code>this</code> letter.
	 */
	public String getDescription() {
		return "promissory note (" + content.getValue() + ")";
	}

}
