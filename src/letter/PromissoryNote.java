package letter;

import content.*;
import city.*;

/**
 * I am a promissoryNote I send money.
 */

public class PromissoryNote extends Letter{

	protected DoubleContent content;

	public PromissoryNote(Inhabitant sender, Inhabitant receiver, Double money) {
		super(sender, receiver);
		//if (money < 0) throw new AmountIsNegativeException();
		//if (sender.getAccount().balance() < (getCost() + money)) throw new NotEnoughMoneyException();  
		DoubleContent content = new DoubleContent(money);
		this.content = content;
		setCost();
	}

	/**
	 * Set the cost of the PromissoryNote.
	 */
	public void setCost() {
		cost =  getCost()+ (0.01  * content.getContent());
	}
	
	/**
	 * Add the money to the account of the receiver.
	 * Subtract the amount of money from the sender.
	 */
	public void transfertMoney() {
		sender.getAccount().debit(content.getContent());
		receiver.getAccount().credit(content.getContent());
	}

	/**
	 * Send the answer that will be sent back to the receiver.
	 *quelque soit la m�thode employ�e BUUUUUUUUUUUUUUUUG! :-/ XD
	 */
	public void sendAnswer() {
		//Letter answer = (Letter) new ThanksLetter(receiver,sender);

	}
	
	/**
	 * Transfer money, create and send the answer.
	 */
	public void doAction(){
		//sendAnswer();
		transfertMoney();
	}

	/**
	 * Return string description of <code>this</code> letter.
	 */	
	public String getDescription () {
		return "promissory note (" + content.getContent() + ")";
	}

}
