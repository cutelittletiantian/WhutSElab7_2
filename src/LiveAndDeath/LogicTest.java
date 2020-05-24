package LiveAndDeath;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LogicTest {

	private static Map map = new Map();
	private static Logic logic = new Logic();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		map.init(1);
		
		map.set(0, 6, 1);
		map.set(0, 7, 1);
		map.set(1, 7, 1);
		map.set(1, 8, 1);
		map.set(2, 6, 1);
		map.set(2, 7, 1);
		
		map.set(6, 0, 1);
		map.set(6, 1, 1);
		map.set(7, 1, 1);
		map.set(7, 2, 1);
		map.set(8, 0, 1);
		map.set(8, 1, 1);
		
		map.set(46, 6, 1);
		map.set(46, 7, 1);
		map.set(47, 7, 1);
		map.set(47, 8, 1);
		map.set(48, 6, 1);
		map.set(48, 7, 1);
		
		map.set(6, 46, 1);
		map.set(6, 47, 1);
		map.set(7, 47, 1);
		map.set(7, 48, 1);
		map.set(8, 46, 1);
		map.set(8, 47, 1);
		
		map.set(1, 1, 1);
		map.set(1, 48, 1);
		map.set(1, 49, 1);
		map.set(48, 0, 1);
		map.set(48, 1, 1);
		map.set(48, 49, 1);
		map.set(49, 1, 1);
		
		map.set(21, 20, 1);
		map.set(21, 21, 1);
		map.set(21, 22, 1);
		map.set(21, 24, 1);
		map.set(21, 25, 1);
		map.set(21, 26, 1);
		map.set(22, 25, 1);
		map.set(23, 21, 1);
		map.set(23, 25, 1);
		
		logic.update(map);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		for(int i = 0; i < map.getLen(); i++) {
			for(int j = 0; j < map.getLen(); j++) {
				map.set(i, j, 0);
			}
		}
	}

	@Before
	public void setUp() throws Exception {
		map.init(1);
		
		map.set(0, 6, 1);
		map.set(0, 7, 1);
		map.set(1, 7, 1);
		map.set(1, 8, 1);
		map.set(2, 6, 1);
		map.set(2, 7, 1);
		
		map.set(6, 0, 1);
		map.set(6, 1, 1);
		map.set(7, 1, 1);
		map.set(7, 2, 1);
		map.set(8, 0, 1);
		map.set(8, 1, 1);
		
		map.set(46, 6, 1);
		map.set(46, 7, 1);
		map.set(47, 7, 1);
		map.set(47, 8, 1);
		map.set(48, 6, 1);
		map.set(48, 7, 1);
		
		map.set(6, 46, 1);
		map.set(6, 47, 1);
		map.set(7, 47, 1);
		map.set(7, 48, 1);
		map.set(8, 46, 1);
		map.set(8, 47, 1);
		
		map.set(1, 1, 1);
		map.set(1, 48, 1);
		map.set(1, 49, 1);
		map.set(48, 0, 1);
		map.set(48, 1, 1);
		map.set(48, 49, 1);
		map.set(49, 1, 1);
		
		map.set(21, 20, 1);
		map.set(21, 21, 1);
		map.set(21, 22, 1);
		map.set(21, 24, 1);
		map.set(21, 25, 1);
		map.set(21, 26, 1);
		map.set(22, 25, 1);
		map.set(23, 21, 1);
		map.set(23, 25, 1);
		
		logic.update(map);
	}

	@After
	public void tearDown() throws Exception {
		for(int i = 0; i < map.getLen(); i++) {
			for(int j = 0; j < map.getLen(); j++) {
				map.set(i, j, 0);
			}
		}
	}

	@Test
	public void testUpdate() {
		assertEquals(1, map.get(47, 8));
		assertEquals(1, map.get(49, 0));
		assertEquals(1, map.get(21, 21));
		assertEquals(0, map.get(49, 7));
		assertEquals(0, map.get(23, 25));
		assertEquals(0, map.get(23, 22));
		assertEquals(0, map.get(22, 25));
		assertEquals(0, map.get(22, 21));
	}

}
