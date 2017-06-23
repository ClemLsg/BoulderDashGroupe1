package view.gameframe;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GamePanelTest {
	
	GamePanel gp;

	@Before
	public void setUp() throws Exception {
		gp = new GamePanel();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetObserver() {
		assertNotNull(gp.getObserver());
	}

}
