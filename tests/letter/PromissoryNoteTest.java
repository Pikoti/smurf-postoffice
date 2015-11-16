package letter;

import static org.junit.Assert.*;

import org.junit.Test;

import city.Inhabitant;

public class PromissoryNoteTest extends LetterTest {

	public PromissoryNote createLetter(Inhabitant sender, Inhabitant receiver) {
		return new PromissoryNote(sender, receiver, 100.00);
	}

	@Test
	public void costTest() {
		assertEquals(2.00, letter.getCost(), 0.01);
	}

}
