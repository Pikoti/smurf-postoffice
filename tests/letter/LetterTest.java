package letter;

import city.City;
import city.Inhabitant;

public abstract class LetterTest {

	protected City village;
	protected Inhabitant schtroumpfette;
	protected Inhabitant schtroumpf;
	
	public void sendingContext(){
		village = new City("village des schtroumpfs");
		schtroumpfette = new Inhabitant("Schtroumpfette");
		schtroumpf = new Inhabitant("Schtroumpf farceur");
	}
	
	
}
