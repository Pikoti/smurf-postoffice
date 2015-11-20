package letter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import city.Inhabitant;
import testdouble.CityTestDouble;
import testdouble.PostboxTestDouble;

public class PromissoryNoteTest {

	protected CityTestDouble aCity;
	protected Inhabitant sender;
	protected Inhabitant receiver;
	protected PromissoryNote pLetter;
	protected PostboxTestDouble postbox;
	
	public PromissoryNote createLetter(Inhabitant sender, Inhabitant receiver) {
		return new PromissoryNote(sender, receiver, 100.0);
	}
	
	@Before
	public void before() {
		aCity = new CityTestDouble("Test City");
		sender = new Inhabitant("Sender");
		receiver = new Inhabitant("Receiver");
		sender.getAccount().credit(1000.0);
		receiver.getAccount().credit(1000.0);
		aCity.addInhabitant(sender);
		aCity.addInhabitant(receiver);
		pLetter = new PromissoryNote(sender, receiver, 100.0);
		postbox = new PostboxTestDouble();
	}
	
	@Test
	public void testGetDescription() {
		System.out.println("promissory note (" + pLetter.content.getValue() + ")");
		System.out.println(pLetter.getDescription());
		assertEquals("promissory note (" + pLetter.content.getValue() + ")", pLetter.getDescription());
	}

	@Test
	public void testDoAction() {
		this.pLetter.doAction(postbox);
		// We're supposing the AcknowlegmentOfReceiptLetter is sent
		assertFalse(postbox.getLettersCollected().isEmpty());
		// Reading the description to confirm it's an acknowlegment of receipt
		Letter<?> l = postbox.getLettersCollected().get(0);
		assertEquals(l.getDescription(), "thanks letter");
	}

	@Test
	public void testTransfertMoney() {
		// doAction execute the money transfert between sender and receiver
		pLetter.doAction(postbox);
		System.out.println(receiver.getAccount().balance());
		// we took 1099 as value to compare cause the receiver sent an acknowlegment of receipt to the sender
		assertEquals(1099.0, receiver.getAccount().balance(), 0.1);
	}

	@Test
	public void testGetCost() {
		assertEquals(1+(0.01*pLetter.content.getValue()), pLetter.getCost(), 0.1);
	}

}
