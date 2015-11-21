package city;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import letter.*;
import org.junit.Before;
import org.junit.Test;

import testdouble.PostboxTestDouble;

import exception.AlreadyUrgentException;

public class PostboxTest {

	protected PostboxTestDouble postbox;
	protected List<Letter<?>> list;
	protected Inhabitant habitant1;
	protected Inhabitant habitant2;
	protected Inhabitant habitant3;
	protected SimpleLetter simpleLetter1;
	protected SimpleLetter simpleLetter2;
	protected SimpleLetter simpleLetter3;
	protected UrgentLetter<SimpleLetter> urgentLetter1;

	@Before
	public void before() throws AlreadyUrgentException {
		postbox = new PostboxTestDouble();
		list = new ArrayList<Letter<?>>();
		habitant1 = new Inhabitant("schtroumpf");
		habitant3 = new Inhabitant("schtroumpfette");
		habitant2 = new Inhabitant("cosmoSchtroumpf");
		habitant1.getAccount().credit(1000);
		habitant2.getAccount().credit(1000);
		habitant3.getAccount().credit(1000);
		simpleLetter1 = new SimpleLetter(habitant1, habitant3, "this is a joke!");
		simpleLetter2 = new SimpleLetter(habitant3, habitant1, "this is funny!");
		simpleLetter3 = new SimpleLetter(habitant2, habitant1, "I am on the moon!");
		urgentLetter1 = new UrgentLetter<SimpleLetter>(simpleLetter3);
		list.add(simpleLetter1);
		list.add(simpleLetter2);
		list.add(simpleLetter3);

	}

	@Test
	public void setDailyPostbox() {
		assertTrue(postbox.lettersToBeDistributed.isEmpty());
		postbox.setDailyPostbox(list);
		assertEquals(3, postbox.lettersToBeDistributed.size());
		assertTrue(postbox.lettersToBeDistributed.contains(simpleLetter1));
		assertTrue(postbox.lettersToBeDistributed.contains(simpleLetter2));
		assertTrue(postbox.lettersToBeDistributed.contains(simpleLetter3));
	}

	@Test
	public void letterToBeDistributedSort() {
		postbox.setDailyPostbox(list);
		assertEquals(0, postbox.lettersToBeDistributed.indexOf(simpleLetter1));
		assertEquals(1, postbox.lettersToBeDistributed.indexOf(simpleLetter2));
		assertEquals(2, postbox.lettersToBeDistributed.indexOf(simpleLetter3));
		postbox.sort();
		assertEquals(2, postbox.lettersToBeDistributed.indexOf(simpleLetter1));
		assertEquals(0, postbox.lettersToBeDistributed.indexOf(simpleLetter2));
		assertEquals(1, postbox.lettersToBeDistributed.indexOf(simpleLetter3));
	}

	@Test
	public void addUrgentLettersCollectedTest() {
		assertTrue(postbox.urgentLettersCollected.isEmpty());
		postbox.addUrgentLettersCollected(urgentLetter1);
		assertEquals(1, postbox.urgentLettersCollected.size());
		assertTrue(postbox.urgentLettersCollected.contains(urgentLetter1));
	}
	
	@Test
	public void addLettersCollectedTest() {
		assertTrue(postbox.lettersCollected.isEmpty());
		postbox.addLettersCollected(simpleLetter1);
		assertEquals(1, postbox.lettersCollected.size());
		assertTrue(postbox.lettersCollected.contains(simpleLetter1));
	}

	@Test
	public void sendLetterTest() {
		postbox.capacity = 2;
		assertEquals(2, postbox.capacity);
		postbox.lettersCollected.addAll(list);
		assertEquals(3, postbox.lettersCollected.size());
		postbox.addUrgentLettersCollected(urgentLetter1);
		postbox.sendLetter();
		assertEquals(3, postbox.lettersToBeDistributed.size());
		assertEquals(1, postbox.lettersCollected.size());
		assertTrue(postbox.lettersToBeDistributed.contains(urgentLetter1));
	}
	
	@Test
	public void distributeLetterTest() {
		simpleLetter1.postTo(postbox);
		assertEquals(1, postbox.lettersCollected.size());
		postbox.sendLetter();
		assertTrue(postbox.lettersCollected.isEmpty());
		assertTrue(postbox.lettersToBeDistributed.contains(simpleLetter1));
		postbox.distributeLetter();
		postbox.receiveLetter();
		assertEquals(0, postbox.lettersToBeDistributed.size());
	}

	@Test
	public void hasLettersToBeDistributedTest() {
		assertFalse(postbox.hasLettersToBeDistributed());
		simpleLetter1.postTo(postbox);
		postbox.sendLetter();
		assertTrue(postbox.hasLettersToBeDistributed());
	}

	@Test
	public void numberOfLettersToBeDistributedTest() {
		int n = postbox.numberOfLettersToBeDistributed();
		assertEquals(0,n);
		simpleLetter1.postTo(postbox);
		postbox.sendLetter();
		n = postbox.numberOfLettersToBeDistributed();
		assertEquals(1,n);
	}

	@Test
	public void numberOfCollectedTest() {
		int n = postbox.numberOfLettersCollected();
		assertEquals(0,n);
		simpleLetter1.postTo(postbox);
		n = postbox.numberOfLettersCollected();
		assertEquals(1,n);
	}
	
	@Test
	public void numberOfUrgentCollectedTest() {
		int n = postbox.numberOfUrgentLettersCollected();
		assertEquals(0,n);
		urgentLetter1.postTo(postbox);
		n = postbox.numberOfUrgentLettersCollected();
		assertEquals(1,n);
	}
	
	
}
