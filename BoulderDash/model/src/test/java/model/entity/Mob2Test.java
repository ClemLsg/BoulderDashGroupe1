package model.entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Mob2Test {
	int id =1;
	
	Mob2 mob2;
	Player player;

	@Before
	public void setUp() throws Exception {
		player = new Player(id);
		mob2 = new Mob2(id);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGiveDiamonds() {
		int expected = player.getAmountDiamonds() + 1;
		mob2.giveDiamonds(player);
		assertEquals(expected, player.getAmountDiamonds());
	}

}
