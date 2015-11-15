package letter;

import content.*;
import exceptions.AmountIsNegativeException;
import exceptions.NotEnoughMoneyException;
import letter.answers.ThanksLetter;
import city.*;

/**
 * I am a promissoryNote I send money
 */

public class PromissoryNote extends LetterWithAnswer {

	protected DoubleContent content;
	protected ThanksLetter answer;

	public PromissoryNote(Inhabitant sender, Inhabitant receiver, Double money) throws AmountIsNegativeException, NotEnoughMoneyException {
		super(sender, receiver);
		//if (money < 0) throw new AmountIsNegativeException();
		//if (sender.getAccount().balance() < (getCost() + money)) throw new NotEnoughMoneyException();  
		DoubleContent content = new DoubleContent(money);
		this.content = content;
	}

	/**
	 * Set the cost of the PromissoryNote.
	 */
	public void setCost() {
		cost = getCost() + 0.01  * content.getContent();
	}
	
	/**
	 * Add the money to the account of the receiver
	 * Subtract the amount of money from the sender
	 */
	public void transferMoney() {
		sender.getAccount().debit(content.getContent());
		receiver.getAccount().credit(content.getContent());
	}

	/**
	 * Create the answer that will be send back to the receiver.
	 */
	public void createAnswer() {
		answer = new ThanksLetter(receiver,sender);
	}
	
	/**
	 * Send the answer that will be set back to the receiver.
	 */
	public void sendAnswer() {
		collectLetter(city, answer);
	}
	
	/**
	 * Create and send the answer.
	 */
	public void doAction(){
		transferMoney();
		createAnswer();
	}

	/**
	 * Return string description of <code>this</code> letter.
	 */	
	public String getDescription () {
		return "promissory note (" + content.getContent() + ")";
	} 

}
