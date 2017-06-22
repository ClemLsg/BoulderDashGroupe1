package model.tile;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DoorTest {
	int id = 1;
	
	Door door;

	@Before
	public void setUp() throws Exception {
		door = new Door(id);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetIsSolid() {
		boolean expected = true;
		assertEquals(expected, door.getIsSolid());
	}

	@Test
	public void testGetIsBreakable() {
		boolean expected = false;
		assertEquals(expected, door.getIsBreakable());
	}

}
