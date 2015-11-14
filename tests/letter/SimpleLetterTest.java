package letter;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import letter.SimpleLetter;

public class SimpleLetterTest extends LetterTest{
	
	protected SimpleLetter simpleLetter;
	
	@Before
	public void before() {
		simpleLetter = new SimpleLetter(schtroumpfette,schtroumpf, "this is a joke!");
	}
	
	@Test
	public void getCostTest() {
		assertEquals(1,simpleLetter.getCost(),0.01);
	}
}
