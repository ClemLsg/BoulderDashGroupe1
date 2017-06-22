package model.entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Direction;

public class RockTest {
	int id = 1;
	
	Rock rock;

	@Before
	public void setUp() throws Exception {
		rock = new Rock(id);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetDirection() {
		Direction expected = null;
		assertEquals(expected, rock.getDirection());
	}

	@Test
	public void testIsPickable() {
		boolean expected = false;
		assertEquals(expected, rock.isPickable());
	}

	@Test
	public void testIsMovable() {
		boolean expected = true;
		assertEquals(expected, rock.isMovable());
	}

	@Test
	public void testGetId() {
		int expected = id;
		assertEquals(expected, rock.getId());
	}

}
