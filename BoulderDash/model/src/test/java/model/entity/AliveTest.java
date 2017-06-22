package model.entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AliveTest {
	int id = 1;
	
	Alive alive;

	@Before
	public void setUp() throws Exception {
		alive = new Alive(id);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsAlive() {
		boolean expected = true;
		assertEquals(expected, alive.isAlive());
		alive.die();
		expected = false;
		assertEquals(expected, alive.isAlive());
	}

	@Test
	public void testGetId() {
		int expected = id;
		assertEquals(expected, alive.getId());
	}

}
