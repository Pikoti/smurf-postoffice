package city;

import org.junit.Test;

import letter.Letter;
import letter.PromissoryNote;
import static org.junit.Assert.*;

import org.junit.Before;

import testdouble.CityTestDouble;

public class CityTest {

	protected CityTestDouble city;
	protected Inhabitant sender;
	protected Inhabitant receiver;
	protected Letter<?> letter;
	protected PromissoryNote prom1;
	

	@Before
	public void before() {
		city = new CityTestDouble("village des schtroumpfs");
		receiver = new Inhabitant("Schtroumpfette");
		sender = new Inhabitant("Schtroumpf farceur");
	}

	@Test
	public void addInhHabitantTest() {
		assertTrue(city.getInhabitants().isEmpty());
		city.addInhabitant(sender);
		assertTrue(city.getInhabitants().contains(sender));
	}

	@Test
	public void getInhabitantTest() {
		assertTrue(city.getInhabitants().isEmpty());
		city.addInhabitant(sender);
		assertEquals(sender,city.getInhabitant(0));
	}

	@Test
	public void getNumberInhabitantTest() {
		int n = city.getNumberInhabitants();
		assertEquals(0,n);
		city.addInhabitant(sender);
		n = city.getNumberInhabitants();
		assertEquals(1,n);
	}
}
