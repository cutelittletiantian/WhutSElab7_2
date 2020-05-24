package LiveAndDeath;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MapTest {

	private static Map map = new Map();
	
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
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// 清空原有测试数据
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
	}

	@After
	public void tearDown() throws Exception {
		// 清空原有测试数据
		for(int i = 0; i < map.getLen(); i++) {
			for(int j = 0; j < map.getLen(); j++) {
				map.set(i, j, 0);
			}
		}
	}

	@Test
	public void testGetLen() {
		assertEquals(50, map.getLen());
	}

	@Test
	public void testGetNeighbor() {
		assertEquals(5, map.getNeighbor(1, 7));
		assertEquals(3, map.getNeighbor(2, 7));
		assertEquals(5, map.getNeighbor(47, 7));
		assertEquals(3, map.getNeighbor(48, 7));
		assertEquals(5, map.getNeighbor(7, 47));
		assertEquals(3, map.getNeighbor(7, 48));
		assertEquals(5, map.getNeighbor(7, 1));
		assertEquals(3, map.getNeighbor(7, 2));
		assertEquals(3, map.getNeighbor(0, 7));
		assertEquals(2, map.getNeighbor(49, 7));
		assertEquals(1, map.getNeighbor(7, 49));
		assertEquals(5, map.getNeighbor(7, 0));
		assertEquals(1, map.getNeighbor(49, 49));
		assertEquals(1, map.getNeighbor(0, 0));
		assertEquals(3, map.getNeighbor(49, 0));
		assertEquals(2, map.getNeighbor(0, 49));
	}
}
