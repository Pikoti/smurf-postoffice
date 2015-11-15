package city;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import letter.Letter;
import letter.SimpleLetter;

import org.junit.Before;
import org.junit.Test;

public class PostboxTest {
	
	protected Postbox opostbox;
	protected List<Letter> list;
	protected Inhabitant schtroumpf;
	protected Inhabitant cosmoSchtroumpf;
	protected Inhabitant schtroumpfette;
	protected Letter simpleLetter1;
	protected Letter simpleLetter2;
	protected Letter simpleLetter3;
	
	@Before
	public void before() {
		opostbox = new OpenPostbox();
		list = new ArrayList<Letter>();
		schtroumpf = new Inhabitant("schtroumpf");
		schtroumpfette = new Inhabitant("schtroumpfette");
		cosmoSchtroumpf = new Inhabitant("cosmoSchtroumpf");
		simpleLetter1 = new SimpleLetter(schtroumpf,schtroumpfette,"this is a joke!");
		simpleLetter2 = new SimpleLetter(schtroumpfette,schtroumpf,"this is funny!");
		simpleLetter3 = new SimpleLetter(cosmoSchtroumpf,schtroumpf,"I am on the moon!");
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
	public void sendLetterTest() {
		opostbox.capacity = 2;
		assertEquals(2,opostbox.capacity);
		opostbox.lettersCollected.addAll(list);
		assertEquals(3,opostbox.lettersCollected.size());
		opostbox.sendLetter();
		assertEquals(2,opostbox.lettersToBeDistributed.size());
		assertEquals(1,opostbox.lettersCollected.size());
	}
	
	@Test
	public void iteratorTest() {
		assertNotNull(opostbox.getPostboxIterator());
	}
}
