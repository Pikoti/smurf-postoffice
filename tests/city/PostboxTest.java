package city;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import letter.Letter;
import letter.SimpleLetter;
import letter.UrgentLetter;

import org.junit.Before;
import org.junit.Test;

import doubles.OpenPostbox;
import exceptions.AlreadyUrgentException;

public class PostboxTest {
	
	protected Postbox opostbox;
	protected List<Letter> list;
	protected Inhabitant schtroumpf;
	protected Inhabitant cosmoSchtroumpf;
	protected Inhabitant schtroumpfette;
	protected SimpleLetter simpleLetter1;
	protected SimpleLetter simpleLetter2;
	protected SimpleLetter simpleLetter3;
	protected UrgentLetter urgentLetter1;
	
	@Before
	public void before() throws AlreadyUrgentException {
		opostbox = new OpenPostbox();
		list = new ArrayList<Letter>();
		schtroumpf = new Inhabitant("schtroumpf");
		schtroumpfette = new Inhabitant("schtroumpfette");
		cosmoSchtroumpf = new Inhabitant("cosmoSchtroumpf");
		simpleLetter1 = new SimpleLetter(schtroumpf,schtroumpfette,"this is a joke!");
		simpleLetter2 = new SimpleLetter(schtroumpfette,schtroumpf,"this is funny!");
		simpleLetter3 = new SimpleLetter(cosmoSchtroumpf,schtroumpf,"I am on the moon!");
		urgentLetter1 = new UrgentLetter(cosmoSchtroumpf,schtroumpf,simpleLetter3);
		list.add(simpleLetter1);
		list.add(simpleLetter2);
		list.add(simpleLetter3);
		
	}
	
	@Test
	public void setDailyPostbox() {
		 assertTrue(opostbox.lettersToBeDistributed.isEmpty());
		 opostbox.setDailyPostbox(list);
		 assertEquals(3,opostbox.lettersToBeDistributed.size());
		 assertTrue(opostbox.lettersToBeDistributed.contains(simpleLetter1));
		 assertTrue(opostbox.lettersToBeDistributed.contains(simpleLetter2));
		 assertTrue(opostbox.lettersToBeDistributed.contains(simpleLetter3));
	}
	
	@Test
	public void letterToBeDistributedSort() {
		opostbox.setDailyPostbox(list);
		assertEquals(0,opostbox.lettersToBeDistributed.indexOf(simpleLetter1));
		assertEquals(1,opostbox.lettersToBeDistributed.indexOf(simpleLetter2));
		assertEquals(2,opostbox.lettersToBeDistributed.indexOf(simpleLetter3));
		opostbox.sort();
		assertEquals(2,opostbox.lettersToBeDistributed.indexOf(simpleLetter1));
		assertEquals(0,opostbox.lettersToBeDistributed.indexOf(simpleLetter2));
		assertEquals(1,opostbox.lettersToBeDistributed.indexOf(simpleLetter3));
	}
	
	@Test
	public void clearLettersToBeDistributedTest() {
		opostbox.setDailyPostbox(list);
		assertFalse(opostbox.lettersToBeDistributed.isEmpty());
		opostbox.clearLettersToBeDistributed();
		assertTrue(opostbox.lettersToBeDistributed.isEmpty());
	}
	 @Test
	 public void addUrgentLettersCollectedTest() {
		 assertTrue(opostbox.urgentLettersCollected.isEmpty());
		 opostbox.addUrgentLettersCollected(urgentLetter1);
		 assertEquals(1,opostbox.urgentLettersCollected.size());
		 assertTrue(opostbox.urgentLettersCollected.contains(urgentLetter1)); 
	 }
	 
	@Test
	public void sendLetterTest() {
		opostbox.capacity = 2;
		assertEquals(2,opostbox.capacity);
		
		opostbox.lettersCollected.addAll(list);
		assertEquals(3,opostbox.lettersCollected.size());
		
		opostbox.addUrgentLettersCollected(urgentLetter1);	
		opostbox.sendLetter();
		
		assertEquals(3,opostbox.lettersToBeDistributed.size());
		assertEquals(1,opostbox.lettersCollected.size());
		assertTrue(opostbox.lettersToBeDistributed.contains(urgentLetter1));
	}
	
	@Test
	public void iteratorTest() {
		assertNotNull(opostbox.getPostboxIterator());
	}
}
