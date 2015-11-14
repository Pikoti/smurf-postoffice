package city;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import letter.Letter;
import letter.SimpleLetter;


public class InhabitantTest {

	protected City village;
	protected Inhabitant schtroumpfette;
	protected Inhabitant schtroumpf;
	protected Letter simpleLetter;
	
	@Before
	public void before(){
		village = new City("village des schtroumpfs");
		schtroumpfette = new Inhabitant("Schtroumpfette");
		schtroumpf = new Inhabitant("Schtroumpf farceur");
		simpleLetter = new SimpleLetter(schtroumpfette,schtroumpf, "this is a joke!");
	}
	
	@Test
	public void getNameTest() {
		assertEquals("Schtroumpfette", schtroumpfette.getName());
	} 

	@Test
	public void payForLetterEnoughMoneyTest(){
		schtroumpfette.getAccount().credit(10);
		assertEquals(10,schtroumpfette.getAccount().balance(),0.1);
		simpleLetter.postLetter(village);
		assertEquals(9,schtroumpfette.getAccount().balance(),0.1);
	}
	
	@Test
	public void payForLetterNotEnoughMoneyTest(){
		assertEquals(0,schtroumpfette.getAccount().balance(),0.1);
		simpleLetter.postLetter(village);
		assertEquals(0,schtroumpfette.getAccount().balance(),0.1);
	}
}
