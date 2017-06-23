package model.tile;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TileTest {
	/** the parameter for the constructor */
	int id = 1;
	
	/** the object used for the tests */
	Tile tile;

	/**
	 * instantiate a new Tile for the tests 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		tile = new Tile(id);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * tests if the tile is solid
	 */
	@Test
	public void testGetIsSolid() {
		boolean expected = true;
		assertEquals(expected, tile.getIsSolid());
	}

	/**
	 * tests if the tile is not breakable
	 */
	@Test
	public void testGetIsBreakable() {
		boolean expected = false;
		assertEquals(expected, tile.getIsBreakable());
	}

	/**
	 * tests if the id is between 0 and 7
	 */
	@Test
	public void testGetId() {
		int expected = id;
		assertEquals(expected, tile.getId());
		assert (tile.getId() >= 0) && (tile.getId() <= 7) : "Error: id out of range";
	}

}
