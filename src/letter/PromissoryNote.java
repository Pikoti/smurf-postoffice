package letter;

import letter.answer.ThanksLetter;
import content.*;
import city.*;
import exception.AmountIsNegativeException;
import exception.NotEnoughMoneyException;

/**
 * I am a promissoryNote I send money.
 */

public class PromissoryNote extends Letter<DoubleContent> {

	public PromissoryNote(Inhabitant sender, Inhabitant receiver, Double money) throws NotEnoughMoneyException, AmountIsNegativeException {
		super(sender, receiver, new DoubleContent(money));
		this.cost = Math.ceil(cost + (0.01 * content.getValue()));
		if (money < 0) throw new AmountIsNegativeException();
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
	 * Description of the transfer money
	 * @return string description of the transfer
	 */
	public String transfertDescription() {
		return " + " + content.getValue() + " are credited from " + receiver.getName() + 
				" account whose balance is now " + receiver.getAccount().balance() + "\n" + 
				" - " +  content.getValue() + " are debited from " + sender.getName() + 
				" account whose balance is now " + sender.getAccount().balance() + "\n";
	}
	
	/**
	 * Transfer money, create and send the answer.
	 */
	public void doAction(Postbox postbox) {
		ThanksLetter answer = new ThanksLetter(receiver, sender);
		answer.postTo(postbox);
		transfertMoney();
		Printer.print(transfertDescription());
	}

	/**
	 * Return string description of <code>this</code> letter.
	 * @Return string description of <code>this</code> letter.
	 */
	public String getDescription() {
		return "promissory note (" + content.getValue() + ")";
	}
}
