package letter;

import static org.junit.Assert.*;

import org.junit.Test;

public class PromissoryNoteTest extends LetterTest {

	public PromissoryNote createLetter() {
		return new PromissoryNote(schtroumpf,schtroumpfette,100.00);
	}
	
	@Test
	public void costTest() {
		assertEquals(2.00,createLetter().getCost(),0.01);
	}

}
