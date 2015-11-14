package city;

import static org.junit.Assert.*;

import java.util.List;

import letter.Letter;
import letter.SimpleLetter;

import org.junit.Before;
import org.junit.Test;

public class PostboxTest {
	
	protected Postbox postbox = new Postbox();
	protected Letter simpleLetter1;
	protected Letter simpleLetter2;
	protected Inhabitant schtroumpfette;
	protected Inhabitant schtroumpf;
	protected List<Letter> list;
	
	@Before
	public void before() {
		simpleLetter1 = new SimpleLetter(schtroumpfette,schtroumpf,"this is a joke!");
		simpleLetter2 = new SimpleLetter(schtroumpf,schtroumpfette,"this is funny!");
	}
	
	@Test
	public void setDailyPostbox() {
		 
	}
	
}
