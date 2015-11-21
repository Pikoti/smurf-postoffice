package city;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import letter.Letter;
import letter.SimpleLetter;

public class InhabitantTest {

	protected City city;
	protected Inhabitant sender;
	protected Inhabitant receiver;
	protected Letter<?> simpleLetter;

	@Before
	public void before() {
		city = new City("village des schtroumpfs");
		sender = new Inhabitant("Schtroumpfette");
		receiver = new Inhabitant("Schtroumpf farceur");
		sender.getAccount().credit(1000);
		receiver.getAccount().credit(1000);
		simpleLetter = new SimpleLetter(sender, receiver, "this is a joke!");
	}

	@Test
	public void getNameTest() {
		assertEquals("Schtroumpfette", sender.getName());
	}

	@Test
	public void payLetterTest() {
		assertEquals(1000, sender.getAccount().balance(),0);
		sender.payLetter(simpleLetter);
		assertEquals(999, sender.getAccount().balance(), 0);
	}
	
	@Test
	public void equalsTest() {
		Object o = new Inhabitant("Schtroumpfette");
		assertTrue(sender.equals(o));
		assertFalse(sender.equals(receiver));
	}
}
