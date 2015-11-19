package letter;

import city.City;
import city.Inhabitant;
import exception.NotEnoughMoneyException;
import testdouble.InhabitantTestDouble;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public abstract class LetterTest {

	protected City city;
	protected Inhabitant sender;
	protected Inhabitant receiver;
	protected InhabitantTestDouble receiver2;
	protected Letter letter;

	@Before
	public void sendingContext() {
		city = new City("village des schtroumpfs");
		sender = new Inhabitant("Schtroumpfette");
		receiver = new Inhabitant("Schtroumpf farceur");
		letter = createLetter(sender, receiver);
		sender.getAccount().credit(100);
		receiver.getAccount().credit(100);

	}

	public abstract Letter createLetter(Inhabitant sender, Inhabitant receiver);

	@Test
	public void costIsAlwaysPositive() {
		assertTrue(letter.getCost() > 0);
	}

	@Test
	public void postToTest() { 
		double expectedAmount = sender.getAccount().balance() - letter.getCost(); 
		letter.postTo(city.getPostbox());
		assertEquals(expectedAmount, sender.getAccount().balance(), 0.1);
	}

	@Test(expected=NotEnoughMoneyException.class)
	public void postToWhenNotEnoughMoneyTest() {
		sender.getAccount().debit(sender.getAccount().balance());
		assertEquals(0, sender.getAccount().balance(), 0.01);
		letter.postTo(city.getPostbox());
	}
}
