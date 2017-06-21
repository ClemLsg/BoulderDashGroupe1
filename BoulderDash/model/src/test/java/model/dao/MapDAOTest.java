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

	@Before
	public void setUp() throws Exception {
		this.id = 1;
		mapDAO = new MapDAO();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateMap() throws SQLException {
		assert id >= 1 : "Error: id can't be < 1";
		testGetMapXsize();
		testGetMapYsize();
		testGetMapCode();
	}

	@Test
	public void testGetMapXsize() throws SQLException {
		System.out.println(MapDAO.getMapXsize(this.id));
		assert MapDAO.getMapXsize(this.id) >= 0 : "Error, width can't be < 0";
	}

	@Test
	public void testGetMapYsize() throws SQLException {
		assert MapDAO.getMapYsize(id) >= 0 : "Error, height can't be < 0";
	}

	@Test
	public void testGetMapCode() throws SQLException {
		assert (this.mapDAO.getMapCode(id).length() == this.mapDAO.getMapXsize(id) * this.mapDAO.getMapYsize(id) + this.mapDAO.getMapYsize(id)) || (this.mapDAO.getMapCode(id).length() == this.mapDAO.getMapYsize(id) * this.mapDAO.getMapXsize(id) + this.mapDAO.getMapYsize(id) + 1): "Error: incorrect mapCode";
	}

}
