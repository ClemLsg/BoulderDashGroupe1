package controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.Order;

public class UserOrderTest {
	/** the order to test */
	Order order = Order.DOWN;
	
	/** the object for the tests */
	UserOrder userOrder;

	/**
	 * instantiate a new UserOrder for the tests
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		userOrder = new UserOrder(order);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * tests if the order is correctly set
	 */
	@Test
	public void testGetOrder() {
		Order expected = order;
		assertEquals(expected, userOrder.getOrder());
	}

}
