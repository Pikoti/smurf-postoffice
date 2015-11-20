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
	protected UrgentLetter<SimpleLetter> usLetter;
	protected PostboxTestDouble postbox;
	
	@Before
	public void before() {
		aCity = new CityTestDouble("Test City");
		sender = new Inhabitant("Sender");
		receiver = new Inhabitant("Receiver");
		aCity.addInhabitant(sender);
		aCity.addInhabitant(receiver);
		usLetter = new UrgentLetter<SimpleLetter>(new SimpleLetter(sender, receiver, "A simple letter registered"));
		postbox = new PostboxTestDouble();
	}
	
	@Test
	public void testGetDescription() {
		assertEquals("urgent letter", usLetter.getDescription());
	}

	@Test
	public void testDoAction() {
		this.usLetter.doAction(postbox);
		assertTrue(postbox.getLettersCollected().contains(usLetter));
	}

	@Test
	public void testIsUrgent() {
		assertTrue(usLetter.isUrgent());
	}
}
