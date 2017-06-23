package model.entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Mob2Test {
	int id =1;

	/** the objects used for the tests */
	Mob2 mob2;
	Player player;

	/**
	 * instantiate a new Alive
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		player = new Player(id);
		mob2 = new Mob2(id);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * tests if the mob gives diamonds to the player
	 */
	@Test
	public void testGiveDiamonds() {
		int expected = player.getAmountDiamonds() + 1;
		mob2.giveDiamonds(player);
		assertEquals(expected, player.getAmountDiamonds());
	}

}
