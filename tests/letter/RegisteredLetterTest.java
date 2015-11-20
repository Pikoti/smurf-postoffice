package letter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import testdouble.CityTestDouble;
import city.Inhabitant;
import testdouble.PostboxTestDouble;

public class RegisteredLetterTest {

	protected CityTestDouble aCity;
	protected Inhabitant sender;
	protected Inhabitant receiver;
	protected RegisteredLetter<SimpleLetter> rLetter;
	protected PostboxTestDouble postbox;
	
	@Before
	public void before() {
		aCity = new CityTestDouble("Test City");
		sender = new Inhabitant("Sender");
		receiver = new Inhabitant("Receiver");
		sender.getAccount().credit(1000.0);
		receiver.getAccount().credit(1000.0);
		aCity.addInhabitant(sender);
		aCity.addInhabitant(receiver);
		rLetter = new RegisteredLetter<SimpleLetter>(new SimpleLetter(sender, receiver, "A simple letter registered"));
		postbox = new PostboxTestDouble();
	}
	
	@Test
	public void testGetDescription() {
		assertSame("registered letter", this.rLetter.getDescription());
	}

	@Test
	public void testDoAction() {
		this.rLetter.doAction(postbox);
		// We're supposing the AcknowlegmentOfReceiptLetter is sent
		assertEquals(false ,postbox.getLettersCollected().isEmpty());
		// Reading the description to confirm it's an acknowlegment of receipt
		Letter<?> l = postbox.getLettersCollected().get(0);
		assertEquals(l.getDescription(), "acknowlegment of receipt");
	}

	@Test
	public void testRegisteredLetter() {
		assertEquals(this.sender, this.rLetter.sender);
		assertEquals(this.receiver, this.rLetter.receiver);
	}

	@Test
	public void testIsRegistered() {
		assertTrue(this.rLetter.isRegistered());
	}

	@Test
	public void testGetCost() {
		assertEquals(16.0, this.rLetter.getCost(), 0.1);
	}
}
