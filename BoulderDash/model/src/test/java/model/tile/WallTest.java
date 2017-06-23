package model.tile;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WallTest {
	/** the parameter for the constructor */
	int id = 1;
	
	/** the object used for the tests */
	Wall wall;

	/** 
	 * instantiate a new Wall for the tests
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		wall = new Wall(id);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * tests if the wall is solid
	 */
	@Test
	public void testGetIsSolid() {
		boolean expected = true;
		assertEquals(expected, wall.getIsSolid());
	}

	/**
	 * tests is the wall is not breakable
	 */
	@Test
	public void testGetIsBreakable() {
		boolean expected = false;
		assertEquals(expected, wall.getIsBreakable());
	}

}
