import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

public class TestPlayeData {
	PlayerData thisdata;
	@Before
	public void setup() throws FileNotFoundException {
		thisdata = new PlayerData();
	}
	
	@Test
	public void testeverything() throws Exception{
		thisdata.addPlayer("DK");
		//duplicates should be ignored
		thisdata.addPlayer("DK");
		thisdata.addPlayer("oof");
		thisdata.addPlayer("hi");
		try {
			thisdata.levelup("DK",4);
			fail();
		}
		catch(Exception ex) {
			//nothingness
		}
		try {
			thisdata.levelup("123123", 1);
			fail();
		}
		catch(Exception ex) {
			//nothingness
		}
		thisdata.levelup("hi", 3);
		thisdata.levelup("DK", 2);
		thisdata.levelup("DK", 2);
		thisdata.levelup("DK", 3);
		//should add 2 to 2nd stat each time and 1 to 1st and 3rd each time	
		}
}
