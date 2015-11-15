package letter;

import city.City;
import city.Inhabitant;
import static org.junit.Assert.*;
import org.junit.Test;

public abstract class LetterTest {

	protected City village;
	protected Inhabitant schtroumpfette;
	protected Inhabitant schtroumpf;
	
	public void sendingContext(){
		village = new City("village des schtroumpfs");
		schtroumpfette = new Inhabitant("Schtroumpfette");
		schtroumpf = new Inhabitant("Schtroumpf farceur");		
		schtroumpfette.getAccount().credit(100);		
		schtroumpf.getAccount().credit(100);

	}
	
	public abstract Letter createLetter();
	
	@Test
	public void costIsAlwaysPositive() {
		assertTrue(createLetter().getCost() > 0);
	}
	
}
