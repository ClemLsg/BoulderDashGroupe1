package controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.Order;

public class UserOrderTest {
	Order order = Order.DOWN;
	
	UserOrder userOrder;

	@Before
	public void setUp() throws Exception {
		userOrder = new UserOrder(order);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetOrder() {
		Order expected = order;
		assertEquals(expected, userOrder.getOrder());
	}

}
