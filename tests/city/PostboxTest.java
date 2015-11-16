package city;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import letter.*;

import org.junit.Before;
import org.junit.Test;

import testdouble.OpenPostbox;

import exception.AlreadyUrgentException;

public class PostboxTest {

	protected Postbox openPostbox;
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
		openPostbox = new OpenPostbox();
		list = new ArrayList<Letter>();
		schtroumpf = new Inhabitant("schtroumpf");
		schtroumpfette = new Inhabitant("schtroumpfette");
		cosmoSchtroumpf = new Inhabitant("cosmoSchtroumpf");
		simpleLetter1 = new SimpleLetter(schtroumpf, schtroumpfette, "this is a joke!");
		simpleLetter2 = new SimpleLetter(schtroumpfette, schtroumpf, "this is funny!");
		simpleLetter3 = new SimpleLetter(cosmoSchtroumpf, schtroumpf, "I am on the moon!");
		urgentLetter1 = new UrgentLetter(cosmoSchtroumpf, schtroumpf, simpleLetter3);
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
