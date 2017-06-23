package view;

import static org.junit.Assert.*;

import java.awt.event.KeyEvent;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.IController;
import controller.IUserOrder;

public class EventPerformerTest {
	
	IController controller;
	EventPerformer eventPerformer;
	KeyEvent keyCode;

	@Before
	public void setUp() throws Exception {
		eventPerformer = new EventPerformer(controller);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test (expected = SQLException.class)
	public void testEventPerform() throws SQLException {
		eventPerformer.eventPerform(keyCode);
	}

	@Test
	public void testKeyCodeToUserOrder() {
		IUserOrder expected = controller.getUserOrder()[0];
		assertEquals(expected, eventPerformer.keyCodeToUserOrder(keyCode.VK_UP));
	}

}
