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

	protected Postbox openPostbox;
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
		openPostbox = new PostboxTestDouble();
		list = new ArrayList<Letter<?>>();
		habitant1 = new Inhabitant("schtroumpf");
		habitant3 = new Inhabitant("schtroumpfette");
		habitant2 = new Inhabitant("cosmoSchtroumpf");
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
		assertTrue(openPostbox.lettersToBeDistributed.isEmpty());
		openPostbox.setDailyPostbox(list);
		assertEquals(3, openPostbox.lettersToBeDistributed.size());
		assertTrue(openPostbox.lettersToBeDistributed.contains(simpleLetter1));
		assertTrue(openPostbox.lettersToBeDistributed.contains(simpleLetter2));
		assertTrue(openPostbox.lettersToBeDistributed.contains(simpleLetter3));
	}

	@Test
	public void letterToBeDistributedSort() {
		openPostbox.setDailyPostbox(list);
		assertEquals(0, openPostbox.lettersToBeDistributed.indexOf(simpleLetter1));
		assertEquals(1, openPostbox.lettersToBeDistributed.indexOf(simpleLetter2));
		assertEquals(2, openPostbox.lettersToBeDistributed.indexOf(simpleLetter3));
		openPostbox.sort();
		assertEquals(2, openPostbox.lettersToBeDistributed.indexOf(simpleLetter1));
		assertEquals(0, openPostbox.lettersToBeDistributed.indexOf(simpleLetter2));
		assertEquals(1, openPostbox.lettersToBeDistributed.indexOf(simpleLetter3));
	}

	@Test
	public void addUrgentLettersCollectedTest() {
		assertTrue(openPostbox.urgentLettersCollected.isEmpty());
		openPostbox.addUrgentLettersCollected(urgentLetter1);
		assertEquals(1, openPostbox.urgentLettersCollected.size());
		assertTrue(openPostbox.urgentLettersCollected.contains(urgentLetter1));
	}

	@Test
	public void sendLetterTest() {
		openPostbox.capacity = 2;
		assertEquals(2, openPostbox.capacity);

		openPostbox.lettersCollected.addAll(list);
		assertEquals(3, openPostbox.lettersCollected.size());

		openPostbox.addUrgentLettersCollected(urgentLetter1);
		openPostbox.sendLetter();

		assertEquals(3, openPostbox.lettersToBeDistributed.size());
		assertEquals(1, openPostbox.lettersCollected.size());
		assertTrue(openPostbox.lettersToBeDistributed.contains(urgentLetter1));
	}
}
