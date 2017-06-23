package model.entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Mob1Test {
	/** the parameter for the constructor */
	int id = 1;

	/** the objects used for the tests */
	Mob1 mob1;
	Player player;

	/**
	 * instantiate a new Alive
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		mob1 = new Mob1(id);
		player = new Player(id);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * tests if the mob gives points to the player
	 */
	@Test
	public void testGivePoints() {
		int expected = player.getScore() + 1;
		mob1.givePoints(player);
		assertEquals(expected, player.getScore());
	}

}
