import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

public class TestWeapons {
	Weapons thisweapons; 
	@Before
	public void Setup() throws FileNotFoundException {
		thisweapons=new Weapons();
	}
	@Test
	public void testgetweapon() throws Exception {
		assertEquals(50,thisweapons.getweapon("Ak-47"));
	}
}
