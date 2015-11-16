package letter;

import static org.junit.Assert.*;

import org.junit.Test;

import city.Inhabitant;

import content.TextContent;
import letter.SimpleLetter;

public class SimpleLetterTest extends LetterTest {

	public SimpleLetter createLetter(Inhabitant sender, Inhabitant receiver) {
		return new SimpleLetter(sender, receiver, "this is a joke!");
	}

	@Test
	public void hasTextContent() { 
		assertTrue(((SimpleLetter)letter).getContent() instanceof TextContent);
	}

	@Test
	public void getCostTest() {
		assertEquals(1, letter.getCost(), 0.01);
	}
}
