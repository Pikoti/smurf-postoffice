package letter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import city.Inhabitant;
import testdouble.CityTestDouble;
import testdouble.PostboxTestDouble;

public class UrgentLetterTest {

	protected CityTestDouble aCity;
	protected Inhabitant sender;
	protected Inhabitant receiver;
	protected UrgentLetter<RegisteredLetter<SimpleLetter>> usLetter;
	protected PostboxTestDouble postbox;
	protected SimpleLetter sLetter;
	protected RegisteredLetter<SimpleLetter> rLetter;
	
	@Before
	public void before() {
		aCity = new CityTestDouble("Test City");
		sender = new Inhabitant("Sender");
		receiver = new Inhabitant("Receiver");
		aCity.addInhabitant(sender);
		aCity.addInhabitant(receiver);
		sender.getAccount().credit(1000.0);
		receiver.getAccount().credit(1000.0);
		rLetter = new RegisteredLetter<SimpleLetter>(new SimpleLetter(sender, receiver, "A simple letter registered"));
		usLetter = new UrgentLetter<RegisteredLetter<SimpleLetter>>(rLetter);
		postbox = new PostboxTestDouble();
	}
	
	@Test
	public void testGetDescription() {
		assertEquals("urgent letter" + rLetter.getDescription(), usLetter.getDescription());
	}


	@Test
	public void testDoAction() {
		this.usLetter.postTo(postbox);
		this.usLetter.doAction(postbox);
		// Now we did the doAction, a new Letter is posted in the postbox which type is AcknowlegmentOfReceipt
		// We select the 1st letter in the postbox ( which is the AcknowlegmentOfReceipt cause the postbox contains only non urgent letter )
		Letter<?> l = postbox.getLettersCollected().get(0);
		assertEquals("acknowlegment of receipt", l.getDescription());
	}

	@Test
	public void testIsUrgent() {
		assertTrue(usLetter.isUrgent());
	}
}
