package letter;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import city.Inhabitant;
import letter.answer.AcknowlegmentOfReceipt;

public class AcknowlegmentOfReceiptTest extends LetterTest {
	

	@Before
	public void before() {
		super.before();
	}
	
	public AcknowlegmentOfReceipt createLetter(Inhabitant sender, Inhabitant receiver) {
		return new AcknowlegmentOfReceipt(sender,receiver);
	}
	
	
	@Test
	public void receiptNotNull() {
		assertNotNull(new AcknowlegmentOfReceipt(sender,receiver));
	}
}

