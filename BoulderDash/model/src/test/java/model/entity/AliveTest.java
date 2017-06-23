package model.entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AliveTest {
	/** the parameter for the constructor */
	int id = 1;
	
	/** the object used for the tests */
	Alive alive;

	/**
	 * instantiate a new Alive
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		alive = new Alive(id);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * tests if he is alive
	 */
	@Test
	public void testIsAlive() {
		boolean expected = true;
		assertEquals(expected, alive.isAlive());
		alive.die();
		expected = false;
		assertEquals(expected, alive.isAlive());
	}

	/**
	 * tests if his id is correct
	 */
	@Test
	public void testGetId() {
		int expected = id;
		assertEquals(expected, alive.getId());
	}

}
