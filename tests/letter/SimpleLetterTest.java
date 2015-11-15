package letter;
import static org.junit.Assert.*;

import org.junit.Test;

import content.TextContent;
import letter.SimpleLetter;

public class SimpleLetterTest extends LetterTest{
	
	public SimpleLetter createLetter() {
		return new SimpleLetter(schtroumpfette,schtroumpf, "this is a joke!");
	}

	
	@Test
	public void hasTextContent() {
		assertTrue(createLetter().getContent() instanceof TextContent);
	}
	
	@Test
	public void getCostTest() {
		Letter simpleLetter = new SimpleLetter(schtroumpf,schtroumpfette, "this is a joke!");
		assertEquals(1,simpleLetter.getCost(),0.01);
	}	
}
