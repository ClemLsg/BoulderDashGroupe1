package model.tile;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MudTest {
	int id = 0;
	
	Mud mud;

	@Before
	public void setUp() throws Exception {
		mud = new Mud(id);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetIsSolid() {
		boolean expected = false;
		assertEquals(expected, mud.getIsSolid());
	}

	@Test
	public void testGetIsBreakable() {
		boolean expected = true;
		assertEquals(expected, mud.getIsBreakable());
	}

}
