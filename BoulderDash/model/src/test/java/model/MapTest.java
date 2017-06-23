package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MapTest {
	
	static Map map;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		map = new Map(1, 4, 1, "000089");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Instantiates a new Map for the test
	 * @throws Exception
	 * 		throws Exception if error during runtime
	 */
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * test if map id is greater or equals to 1.
	 */
	@Test
	public void testGetId() {
		//this.map.setId(1);
		assert this.map.getId() >= 1: "Error: id should be >= 1";
	}

	/**
	 * test if map width is greater or equals to 0.
	 */
	@Test
	public void testGetWidth() {
		assert this.map.getWidth() >= 0: "Error: width should be >= 0";
	}

	/**
	 * test if map height is greater or equals to 0.
	 */
	@Test
	public void testGetHeight() {
		assert this.map.getHeight() >= 0: "Error: height should be >= 0";
	}

	/**
	 * test if the mapCode has a correct length.
	 */
	@Test
	public void testGetMapCode() {
		assert (this.map.getMapCode().length() == this.map.getHeight() * this.map.getWidth() + this.map.getHeight()) || (this.map.getMapCode().length() == this.map.getHeight() * this.map.getWidth() + this.map.getHeight() + 1): "Error: incorrect mapCode";
	}

}
