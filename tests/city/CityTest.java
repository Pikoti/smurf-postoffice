package city;

import org.junit.Test;

import doubles.OpenCity;
import letter.Letter;
import letter.SimpleLetter;

import static org.junit.Assert.*;

import org.junit.Before;

public class CityTest {
	
	protected OpenCity village;
	protected Inhabitant schtroumpfette;
	protected Inhabitant schtroumpf;
	protected Letter letter;
	
	@Before
	public void before () {
		village = new OpenCity("village des schtroumpfs");
		schtroumpfette = new Inhabitant("Schtroumpfette");
		schtroumpf = new Inhabitant("Schtroumpf farceur");
		letter = new SimpleLetter(schtroumpfette,schtroumpf,"this is a joke!");
	}
	
	@Test
	public void addHabitantTest() {
		assertTrue(village.getInhabitants().isEmpty());
		village.addInhabitant(schtroumpf);
		assertTrue(village.getInhabitants().contains(schtroumpf));
	}	
}
