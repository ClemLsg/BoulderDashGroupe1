package model.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Direction;

public class DiamondTest {
	/** the parameter for the constructor */
	int id = 1;

	/** the object used for the tests */
	Diamond diamond;

	/**
	 * instantiate a new Alive
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		diamond = new Diamond(id);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * tests if the diamond doesn't have a direction
	 */
	@Test
	public void testGetDirection() {
		Direction expected = null;
		assertEquals(expected, diamond.getDirection());
	}

	/**
	 * tests if the the diamond is pickable
	 */
	@Test
	public void testIsPickable() {
		boolean expected = true;
		assertEquals(expected, diamond.isPickable());
	}

	/**
	 * tests if the diamond is not movable
	 */
	@Test
	public void testIsMovable() {
		boolean expected = false;
		assertEquals(expected, diamond.isMovable());
	}

	/**
	 * tests if the diamond have the correct id
	 */
	@Test
	public void testGetId() {
		int expected = id;
		assertEquals(expected, diamond.getId());
	}

	/**
	 * tests if the diamond is solid
	 */
	@Test
	public void testIsSolid() {
		boolean expected = true;
		assertEquals(expected, diamond.isSolid());
	}

}
