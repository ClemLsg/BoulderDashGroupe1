package model.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Direction;

public class DiamondTest {
	int id = 1;
	
	Diamond diamond;

	@Before
	public void setUp() throws Exception {
		diamond = new Diamond(id);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetDirection() {
		Direction expected = null;
		assertEquals(expected, diamond.getDirection());
	}

	@Test
	public void testIsPickable() {
		boolean expected = true;
		assertEquals(expected, diamond.isPickable());
	}

	@Test
	public void testIsMovable() {
		boolean expected = false;
		assertEquals(expected, diamond.isMovable());
	}

	@Test
	public void testGetId() {
		int expected = id;
		assertEquals(expected, diamond.getId());
	}

	@Test
	public void testIsSolid() {
		boolean expected = true;
		assertEquals(expected, diamond.isSolid());
	}

}
