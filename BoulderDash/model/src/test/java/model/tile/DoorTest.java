package model.tile;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DoorTest {
	/** the parameter for the constructor */
	int id = 1;
	
	/** the object used for the tests */
	Door door;

	/** instantiate a new door for the tests */
	@Before
	public void setUp() throws Exception {
		door = new Door(id);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * tests if the door is solid
	 */
	@Test
	public void testGetIsSolid() {
		boolean expected = true;
		assertEquals(expected, door.getIsSolid());
	}

	/**
	 * tests if the door is not breakable
	 */
	@Test
	public void testGetIsBreakable() {
		boolean expected = false;
		assertEquals(expected, door.getIsBreakable());
	}

}
