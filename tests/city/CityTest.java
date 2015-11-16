package city;

import org.junit.Test;

import exception.AmountIsNegativeException;
import exception.NotEnoughMoneyException;
import letter.Letter;
import letter.PromissoryNote;
import letter.SimpleLetter;
import letter.answer.ThanksLetter;
import static org.junit.Assert.*;

import org.junit.Before;

import testdouble.CityTestDouble;

public class CityTest {

	protected CityTestDouble city;
	protected Postbox postbox;
	protected Inhabitant receiver;
	protected Inhabitant sender;
	protected Letter letter;
	protected PromissoryNote prom1;
	protected final double GIFT_AMOUNT = 20.50;

	@Before
	public void before() throws AmountIsNegativeException,
			NotEnoughMoneyException {
		city = new CityTestDouble("village des schtroumpfs");
		postbox = city.getPostbox();
		receiver = new Inhabitant("Schtroumpfette");
		sender = new Inhabitant("Schtroumpf farceur");
		receiver.getAccount().credit(100.00);
		sender.getAccount().credit(100.00);
		prom1 = new PromissoryNote(receiver, sender, GIFT_AMOUNT);
		letter = new SimpleLetter(receiver, sender, "this is a joke!");
	}

	@Test
	public void addHabitantTest() {
		assertTrue(city.getInhabitants().isEmpty());
		city.addInhabitant(sender);
		assertTrue(city.getInhabitants().contains(sender));
	}

	@Test
	public void transferMoneyTest() {
		double previousAmount = sender.getAccount().balance();
		double expectedAmount = previousAmount - prom1.getCost() + GIFT_AMOUNT;
		System.out.println(previousAmount + " " + prom1.getCost());
		city.addInhabitant(sender);
		city.addInhabitant(receiver);
		prom1.postTo(postbox);
		postbox.sendLetter();
		postbox.distributeLetter();
		assertEquals(expectedAmount, sender.getAccount().balance(), 0.01);
		assertEquals(78.295, receiver.getAccount().balance(), 0.01);
	}

	@Test
	public void answerIsCollected() {
		city.addInhabitant(sender);
		city.addInhabitant(receiver);
		prom1.postTo(postbox);
		assertEquals(1, postbox.lettersCollected.size());

		postbox.sendLetter();

		assertTrue(postbox.lettersCollected.isEmpty());
		assertTrue(postbox.lettersToBeDistributed.contains(prom1));

		postbox.distributeLetter();

		assertEquals(0, postbox.lettersToBeDistributed.size());
		assertFalse(postbox.lettersCollected.isEmpty());
		assertTrue(postbox.lettersCollected.get(0) instanceof ThanksLetter);
	}
}
