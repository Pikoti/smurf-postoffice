package letter;

import static org.junit.Assert.*;

import org.junit.Test;
import city.Inhabitant;
import exception.AlreadyRegisteredException;
import letter.answer.AcknowlegmentOfReceipt;

public class RegisteredLetterTest extends LetterTest{

	@Override
	public RegisteredLetter<SimpleLetter> createLetter(Inhabitant sender, Inhabitant receiver) {
		return new RegisteredLetter<SimpleLetter>(new SimpleLetter(sender,receiver,"blablatest"));
	}
	
	@Test
	public void testGetDescription() {
		assertSame("registered letter", letter.getDescription());
	}

	@Test
	public void testDoAction() {
		letter.doAction(postbox);
		// We're supposing the AcknowlegmentOfReceiptLetter is sent
		assertEquals(false ,postbox.getLettersCollected().isEmpty());
		// Reading the description to confirm it's an acknowlegment of receipt
		Letter<?> l = postbox.getLettersCollected().get(0);
		assertTrue(l instanceof AcknowlegmentOfReceipt);
	}

	@Test
	public void testRegisteredLetter() {
		assertEquals(sender, letter.sender);
		assertEquals(receiver, letter.receiver);
	}

	@Test
	public void testIsRegistered() {
		assertTrue(letter.isRegisteredLetter());
	}

	@Test
	public void testGetCost() {
		assertEquals(16.0, this.letter.getCost(), 0);
	}
	
	@Test
	public void sendReceiptTest() {
		assertEquals(0,receiver.getNbLetterSent());
		letter.doAction(postbox);
		assertEquals(0, receiver.getNbLetterSent());;
	}
	
	@Test(expected=AlreadyRegisteredException.class)
	public void alreadyRegisteredTest() {
		RegisteredLetter<SimpleLetter> reg = createLetter(sender,receiver);
		RegisteredLetter<RegisteredLetter<SimpleLetter>> regreg = new RegisteredLetter<RegisteredLetter<SimpleLetter>>(reg);
		regreg.postTo(postbox);
	}

	@Test(expected=AlreadyRegisteredException.class)
	public void alreadyRegisterTest2() {
		RegisteredLetter<SimpleLetter> reg = createLetter(sender,receiver);
		UrgentLetter<RegisteredLetter<SimpleLetter>> urgreg = new UrgentLetter<RegisteredLetter<SimpleLetter>>(reg);
		RegisteredLetter<UrgentLetter<RegisteredLetter<SimpleLetter>>> regurreg = new RegisteredLetter<UrgentLetter<RegisteredLetter<SimpleLetter>>>(urgreg);
		regurreg.postTo(postbox);
	}
}
