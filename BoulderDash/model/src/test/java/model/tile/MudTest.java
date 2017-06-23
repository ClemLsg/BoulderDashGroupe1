package model.tile;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MudTest {
	/** the parameter for the constructor */
	int id = 0;
	
	/** the object for the tests */
	Mud mud;

	/** instantiate a new Mud fr the tests */
	@Before
	public void setUp() throws Exception {
		mud = new Mud(id);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * tests if the mud is solid
	 */
	@Test
	public void testGetIsSolid() {
		boolean expected = false;
		assertEquals(expected, mud.getIsSolid());
	}

	/**
	 * tests if the mud is breakable
	 */
	@Test
	public void testGetIsBreakable() {
		boolean expected = true;
		assertEquals(expected, mud.getIsBreakable());
	}

}
