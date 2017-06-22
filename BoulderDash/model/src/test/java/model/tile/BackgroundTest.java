package model.tile;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BackgroundTest {
	int id = 1;
	
	Background bg;

	@Before
	public void setUp() throws Exception {
		bg = new Background(id);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetIsSolid() {
		boolean expected = false;
		assertEquals(expected, bg.getIsSolid());
	}

	@Test
	public void testGetIsBreakable() {
		boolean expected = false;
		assertEquals(expected, bg.getIsBreakable());
	}

}
