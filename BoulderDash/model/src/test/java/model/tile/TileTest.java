package model.tile;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TileTest {
	int id = 1;
	
	Tile tile;

	@Before
	public void setUp() throws Exception {
		tile = new Tile(id);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetIsSolid() {
		boolean expected = true;
		assertEquals(expected, tile.getIsSolid());
	}

	@Test
	public void testGetIsBreakable() {
		boolean expected = false;
		assertEquals(expected, tile.getIsBreakable());
	}

	@Test
	public void testGetId() {
		int expected = id;
		assertEquals(expected, tile.getId());
		assert (tile.getId() >= 0) && (tile.getId() <= 7) : "Error: id out of range";
	}

}
