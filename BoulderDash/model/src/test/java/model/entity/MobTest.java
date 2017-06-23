package model.entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MobTest {
	/** the parameter for the constructor */
	int id = 1;

	/** the objects used for the tests */
	Mob mob;
	Player player;

	/**
	 * instantiate a new Alive
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		mob = new Mob(id);
		player = new Player(id);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * tests if the mob can kill the player
	 */
	@Test
	public void testKill() {
		boolean expected = true;
		assertEquals(expected, player.isAlive());
		mob.kill(player);
		expected = false;
		assertEquals(expected, player.isAlive());
	}

}
