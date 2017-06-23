package model.entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Direction;

public class RockTest {
	/** the parameter for the constructor */
	int id = 1;

	/** the object used for the tests */
	Rock rock;

	/**
	 * instantiate a new Alive
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		rock = new Rock(id);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * tests if the rock doesn't have a direction
	 */
	@Test
	public void testGetDirection() {
		Direction expected = null;
		assertEquals(expected, rock.getDirection());
	}

	/**
	 * tests if the rock is not pickable
	 */
	@Test
	public void testIsPickable() {
		boolean expected = false;
		assertEquals(expected, rock.isPickable());
	}

	/**
	 * tests if the rock is movable
	 */
	@Test
	public void testIsMovable() {
		boolean expected = true;
		assertEquals(expected, rock.isMovable());
	}

	/**
	 * tests if the id is correct
	 */
	@Test
	public void testGetId() {
		int expected = id;
		assertEquals(expected, rock.getId());
	}

}
