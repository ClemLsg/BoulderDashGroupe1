package model.tile;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WallTest {
	int id = 1;
	
	Wall wall;

	@Before
	public void setUp() throws Exception {
		wall = new Wall(id);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetIsSolid() {
		boolean expected = true;
		assertEquals(expected, wall.getIsSolid());
	}

	@Test
	public void testGetIsBreakable() {
		boolean expected = false;
		assertEquals(expected, wall.getIsBreakable());
	}

}
