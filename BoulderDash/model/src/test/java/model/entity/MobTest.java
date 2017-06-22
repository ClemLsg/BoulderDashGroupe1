package model.entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MobTest {
	int id = 1;
	
	Mob mob;
	Player player;

	@Before
	public void setUp() throws Exception {
		mob = new Mob(id);
		player = new Player(id);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testKill() {
		boolean expected = true;
		assertEquals(expected, player.isAlive());
		mob.kill(player);
		expected = false;
		assertEquals(expected, player.isAlive());
	}

}
