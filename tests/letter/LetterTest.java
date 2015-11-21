package letter;

import city.Inhabitant;
import exception.NotEnoughMoneyException;
import testdouble.CityTestDouble;
import testdouble.InhabitantTestDouble;
import testdouble.PostboxTestDouble;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public abstract class LetterTest {

	protected CityTestDouble city;
	protected PostboxTestDouble postbox;
	protected InhabitantTestDouble sender;
	protected InhabitantTestDouble receiver;
	protected Letter<?> letter;


	
	@Before
	public void before() throws NotEnoughMoneyException{
		city = new CityTestDouble("village des schtroumpfs");
		postbox = new PostboxTestDouble();
		sender = new InhabitantTestDouble("Schtroumpfette");
		receiver = new InhabitantTestDouble("Schtroumpf farceur");
		sender.getAccount().credit(1000);
		receiver.getAccount().credit(1000);
		city.addInhabitant(sender);
		city.addInhabitant(receiver);
		letter = createLetter(sender, receiver);
	}
	
	public abstract Letter<?> createLetter(Inhabitant sender, Inhabitant receiver);

	@Test
	public void costIsAlwaysPositive() {
		assertTrue(letter.getCost() > 0);
	}

	@Test
	public void postToTest() { 
		double expectedAmount = sender.getAccount().balance() - letter.getCost(); 
		letter.postTo(city.getPostbox());
		assertEquals(expectedAmount, sender.getAccount().balance(), 0);
	}

	@Test(expected=NotEnoughMoneyException.class)
	public void postToWhenNotEnoughMoneyTest1() {
		sender.getAccount().debit(sender.getAccount().balance());
		Letter<?> letter2 = createLetter(sender, receiver);
		assertEquals(0, sender.getAccount().balance(), 0);
		letter2.postTo(city.getPostbox());
	}
}
