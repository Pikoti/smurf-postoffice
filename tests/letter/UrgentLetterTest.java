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
	protected UrgentLetter<SimpleLetter> uLetter;
	protected PostboxTestDouble postbox;
	
	@Before
	public void before() {
		aCity = new CityTestDouble("Test City");
		sender = new Inhabitant("Sender");
		receiver = new Inhabitant("Receiver");
		aCity.addInhabitant(sender);
		aCity.addInhabitant(receiver);
		uLetter = new UrgentLetter<SimpleLetter>(new SimpleLetter(sender, receiver, "A simple letter registered"));
		postbox = (PostboxTestDouble) aCity.getPostbox();
	}
	
	@Test
	public void testGetDescription() {
		assertEquals("urgent letter", uLetter.getDescription());
	}

	@Test
	public void testDoAction() {
		this.uLetter.doAction(postbox);
		Letter l = postbox.getLettersCollected().get(0);
		assertEquals(l.getDescription(), "urgent letter");
	}

	@Test
	public void testIsUrgent() {
		assertTrue(uLetter.isUrgent());
	}
}
