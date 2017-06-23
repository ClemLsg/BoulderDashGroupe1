package model.dao;

import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MapDAOTest {
	
	int id = -1;
	
	MapDAO mapDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Instantiate a new MapDAO for the test.
	 * @throws Exception
	 * 		throws Exception if there is an error during runtime
	 */
	@Before
	public void setUp() throws Exception {
		this.id = 1;
		mapDAO = new MapDAO();
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * tests if the id is upper or equals to 1 and tests the other methods.
	 * @throws SQLException
	 * 		throws SQLException if there is an error during database access
	 */
	@Test
	public void testCreateMap() throws SQLException {
		assert id >= 1 : "Error: id can't be < 1";
		testGetMapXsize();
		testGetMapYsize();
		testGetMapCode();
	}

	/**
	 * checks that the width isn't negative.
	 * @throws SQLException
	 * 		throws SQLException if there is an error during database access
	 */
	@Test (expected = SQLException.class)
	public void testGetMapXsize() throws SQLException {
		assert MapDAO.getMapXsize(this.id) >= 0 : "Error, width can't be < 0";
	}

	/**
	 * checks that the height isn't negative.
	 * @throws SQLException
	 * 		throws SQLException if there is an error during database access
	 */
	@Test (expected = SQLException.class)
	public void testGetMapYsize() throws SQLException {
		assert MapDAO.getMapYsize(id) >= 0 : "Error, height can't be < 0";
	}

	/**
	 * checks that the mapCode has a correct length.
	 * @throws SQLException
	 * 		throws SQLException if there is an error during database access
	 */
	@Test (expected = SQLException.class)
	public void testGetMapCode() throws SQLException {
		assert (this.mapDAO.getMapCode(id).length() == this.mapDAO.getMapXsize(id) * this.mapDAO.getMapYsize(id) + this.mapDAO.getMapYsize(id)) || (this.mapDAO.getMapCode(id).length() == this.mapDAO.getMapYsize(id) * this.mapDAO.getMapXsize(id) + this.mapDAO.getMapYsize(id) + 1): "Error: incorrect mapCode";
	}

}
