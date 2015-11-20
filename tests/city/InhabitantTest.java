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
		simpleLetter = new SimpleLetter(sender, receiver, "this is a joke!");
	}

	@Test
	public void getNameTest() {
		assertEquals("Schtroumpfette", sender.getName());
	}

	@Test
	public void payLetterTest() {
		sender.getAccount().credit(10);
		assertEquals(10, sender.getAccount().balance(), 0.1);
		sender.payLetter(simpleLetter);
		assertEquals(9, sender.getAccount().balance(), 0.1);
	}
}
