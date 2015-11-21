package letter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import city.Inhabitant;
import content.DoubleContent;
import exception.AmountIsNegativeException;
import letter.answer.ThanksLetter;

public class PromissoryNoteTest extends LetterTest{
	
	protected final double GIFT_AMOUNT = 100;
	
	@Before
	public void before() {
		super.before();
	}

	public PromissoryNote createLetter(Inhabitant sender, Inhabitant receiver) {
		return new PromissoryNote(sender, receiver, GIFT_AMOUNT);
	}
	
	
	@Test
	public void testGetDescription() {
		assertEquals("promissory note (" + ((DoubleContent) letter.content).getValue() + ")", letter.getDescription());
	}

	@Test
	public void testDoAction() {
		this.letter.doAction(postbox);
		// We're supposing the AcknowlegmentOfReceiptLetter is sent
		assertFalse(postbox.getLettersCollected().isEmpty());
		// Reading the description to confirm it's an acknowlegment of receipt
		Letter<?> l = postbox.getLettersCollected().get(0);
		assertTrue(l instanceof ThanksLetter);
	}

	@Test
	public void testTransfertMoney() {
		// doAction execute the money transfert between sender and receiver
		letter.doAction(postbox);
		System.out.println(receiver.getAccount().balance());
		// we took 1099 as value to compare cause the receiver sent an acknowlegment of receipt to the sender
		assertEquals(1099.0, receiver.getAccount().balance(), 0.1);
	}

	@Test
	public void testGetCost() {
		assertEquals(((DoubleContent) letter.content).getValue() * 0.01 + 1, letter.getCost(), 0.1);
	}
	
	@Test(expected=AmountIsNegativeException.class)
	public void avoidNegativeAmountException() {
		PromissoryNote prom = new PromissoryNote(sender, receiver, -5.0);
		prom.postTo(city.getPostbox());
	}
}
