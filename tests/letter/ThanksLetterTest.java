package letter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import city.Inhabitant;
import letter.answer.ThanksLetter;

public class ThanksLetterTest {

	protected Inhabitant sender;
	protected Inhabitant receiver;
	
	@Before
	public void before() {
		sender = new Inhabitant("schtroumpf");
		receiver = new Inhabitant("schtroumpfette");
	}
	
	@Test
	public void thanksNotNull() {
		assertNotNull(new ThanksLetter(sender,receiver));
	}
}
