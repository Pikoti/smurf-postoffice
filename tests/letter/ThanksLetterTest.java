package letter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import city.Inhabitant;
import letter.answer.ThanksLetter;

public class ThanksLetterTest extends LetterTest {

	@Override
	public ThanksLetter createLetter(Inhabitant sender, Inhabitant receiver) {
		return new ThanksLetter(sender,receiver);
	}
	
	@Before
	public void before() {
		super.before();
	}
	
	@Test
	public void thanksNotNull() {
		assertNotNull(new ThanksLetter(sender,receiver));
	}
}
