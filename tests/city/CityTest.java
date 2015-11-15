package city;

import org.junit.Test;

import doubles.OpenCity;
import exceptions.AmountIsNegativeException;
import exceptions.NotEnoughMoneyException;
import letter.Letter;
import letter.PromissoryNote;
import letter.SimpleLetter;
import static org.junit.Assert.*;

import org.junit.Before;

public class CityTest {
	
	protected OpenCity village;
	protected Inhabitant schtroumpfette;
	protected Inhabitant schtroumpf;
	protected Letter letter;
	protected PromissoryNote prom1;
	
	@Before
	public void before () throws AmountIsNegativeException, NotEnoughMoneyException {
		village = new OpenCity("village des schtroumpfs");
		schtroumpfette = new Inhabitant("Schtroumpfette");
		schtroumpf = new Inhabitant("Schtroumpf farceur");
		schtroumpfette.getAccount().credit(100.00);
		schtroumpf.getAccount().credit(100.00);
		prom1 = new PromissoryNote(schtroumpfette,schtroumpf, 20.5);
		letter = new SimpleLetter(schtroumpfette,schtroumpf,"this is a joke!");
	}
	
	@Test
	public void addHabitantTest() {
		assertTrue(village.getInhabitants().isEmpty());
		village.addInhabitant(schtroumpf);
		assertTrue(village.getInhabitants().contains(schtroumpf));
	}
	
	@Test
	public void answerIsCollectedAndSent() {
		village.addInhabitant(schtroumpf);
		village.addInhabitant(schtroumpfette);
		prom1.postLetter(village);
		assertEquals(1,village.getPostbox().lettersCollected.size());
		
		village.sendLetter();
		
		assertTrue(village.getPostbox().lettersCollected.isEmpty());
		assertTrue(village.getPostbox().lettersToBeDistributed.contains(prom1));
		
		village.distributeLetter();
		
		assertEquals(0,village.getPostbox().lettersToBeDistributed.size());
		assertFalse(village.getPostbox().lettersCollected.isEmpty());
		
	}
	
	@Test
	public void transferMoneyTest() {
		village.addInhabitant(schtroumpf);
		village.addInhabitant(schtroumpfette);
		prom1.postLetter(village);
		village.sendLetter();
		village.distributeLetter();
		assertEquals(120.5, schtroumpf.getAccount().balance(),0.01);
		assertEquals(78.295, schtroumpfette.getAccount().balance(),0.01);
		
	}
	
	
	
}
