package letter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import city.Inhabitant;
import letter.answer.ThanksLetter;

public class ThanksLetterTest {

	protected Inhabitant schtroumpfette;
	protected Inhabitant schtroumpf;
	
	@Before
	public void before() {
		schtroumpf = new Inhabitant("schtroumpf");
		schtroumpfette = new Inhabitant("schtroumpfette");
	}
	
	@Test
	public void thanksNotNull() {
		assertNotNull(new ThanksLetter(schtroumpf,schtroumpfette));
	}
}
