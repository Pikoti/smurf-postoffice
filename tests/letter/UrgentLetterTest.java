package letter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import city.Inhabitant;
import content.TextContent;
import exception.AlreadyUrgentException;

public class UrgentLetterTest extends LetterTest{

	@Override
	public UrgentLetter<SimpleLetter> createLetter(Inhabitant sender, Inhabitant receiver) {
		return new UrgentLetter<SimpleLetter>(new SimpleLetter(sender,receiver,"blabla"));
	}
	
	@Before
	public void before() {
		super.before();
	}

	@Test
	public void testIsUrgent() {
		assertTrue(letter.isUrgent());
	}
	
	@Test
	public void contentOfUrgentSimpleIsText() {
		SimpleLetter simpleLetter = new SimpleLetter(sender, receiver);
		UrgentLetter<SimpleLetter> letter = new UrgentLetter<SimpleLetter>(simpleLetter);
	
	@SuppressWarnings("unused")
		TextContent text = letter.getContent().getContent();
	}
	
	@Test(expected = AlreadyUrgentException.class)
	public void testisUrgent() {
		UrgentLetter<Letter<?>> aletter = new UrgentLetter<Letter<?>>(letter);
		assertTrue(letter.isUrgent());
		aletter.postTo(postbox);
	}

	@Test(expected=AlreadyUrgentException.class)
	public void alreadyUrgentTest() {
		UrgentLetter<SimpleLetter> urg = createLetter(sender,receiver);
		UrgentLetter<UrgentLetter<SimpleLetter>> urgurg = new UrgentLetter<UrgentLetter<SimpleLetter>>(urg);
		urgurg.postTo(postbox);
	}
	
	@Test(expected=AlreadyUrgentException.class)
	public void alreadyUrgentTest2() {
		UrgentLetter<SimpleLetter> urg = createLetter(sender,receiver);
		RegisteredLetter<UrgentLetter<SimpleLetter>> regurg = new RegisteredLetter<UrgentLetter<SimpleLetter>>(urg);
		UrgentLetter<RegisteredLetter<UrgentLetter<SimpleLetter>>> urgurg = new UrgentLetter<RegisteredLetter<UrgentLetter<SimpleLetter>>>(regurg);
		urgurg.postTo(postbox);
	}
	
}
