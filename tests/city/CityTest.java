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
	protected Letter<?> letter;
	protected PromissoryNote prom1;
	protected final double GIFT_AMOUNT = 20.5;

	@Before
	public void before() throws AmountIsNegativeException,
			NotEnoughMoneyException {
		city = new CityTestDouble("village des schtroumpfs");
		postbox = city.getPostbox();
		receiver = new Inhabitant("Schtroumpfette");
		sender = new Inhabitant("Schtroumpf farceur");
		receiver.getAccount().credit(100.0);
		sender.getAccount().credit(100.0);
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
		// Sender est celui qui recoit la promissory note donc il recoit le gift et envoi un remerciement donc c'est letter.getCost et pas prom1.getCost
		double previousAmount = sender.getAccount().balance();
		double expectedAmount = (previousAmount - letter.getCost()) + GIFT_AMOUNT;
		city.addInhabitant(sender);
		city.addInhabitant(receiver);
		prom1.postTo(postbox);
		postbox.sendLetter();
		postbox.distributeLetter();
		assertEquals(expectedAmount, sender.getAccount().balance(), 0.01);
		assertEquals(78.295, receiver.getAccount().balance(), 0.001);
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
