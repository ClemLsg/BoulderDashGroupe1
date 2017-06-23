package model.tile;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BackgroundTest {
	/** the parameter for the constructor */
	int id = 1;
	
	/** the object used for the tests */
	Background bg;

	/**
	 * instantiate a new Background for the tests 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		bg = new Background(id);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * tests if the background is not solid
	 */
	@Test
	public void testGetIsSolid() {
		boolean expected = false;
		assertEquals(expected, bg.getIsSolid());
	}

	/**
	 * tests if the background is not breakable
	 */
	@Test
	public void testGetIsBreakable() {
		boolean expected = false;
		assertEquals(expected, bg.getIsBreakable());
	}

}
