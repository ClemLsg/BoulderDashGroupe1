package model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.dao.MapDAO;

public class BoulderDashModelTest {
	int id = 1;
	
	BoulderDashModel bdm;

	@Before
	public void setUp() throws Exception {
		bdm = new BoulderDashModel(id);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * tests if the MapCode has a correct length
	 * @throws SQLException
	 * 		throws SQLException if an error occurs when retrieving datas from the database
	 */
	@Test
	public void testGetMapCode() throws SQLException  {
		assert (this.bdm.getMapCode(id).length() == this.bdm.getMapXsize(id) * this.bdm.getMapYsize(id) + this.bdm.getMapYsize(id)) || (this.bdm.getMapCode(id).length() == this.bdm.getMapYsize(id) * this.bdm.getMapXsize(id) + this.bdm.getMapYsize(id) + 1): "Error: incorrect mapCode";
	}

	/**
	 * tests if the height of the map is not negative
	 * @throws SQLException
	 * 		throws SQLException if an error occurs when retrieving datas from the database
	 */
	@Test
	public void testGetMapYsize() throws SQLException {
		assert bdm.getMapXsize(this.id) >= 0 : "Error, width can't be < 0";
	}

	/**
	 * tests if the width of the map is not negative
	 * @throws SQLException
	 * 		throws SQLException if an error occurs when retrieving data from the database
	 */
	@Test
	public void testGetMapXsize() throws SQLException {
		assert bdm.getMapXsize(this.id) >= 0 : "Error, width can't be < 0";
	}

	/**
	 * gets the map
	 */
	@Test
	public void testGetMap() {
		int[][] unexpected = null;
		assert bdm.getMap() != unexpected : "Error: Map is null";
	}

	/**
	 * tests if the BoulderDashModel is not break
	 */
	@Test
	public void testIsBreak() {
		boolean expected = false;
		assertEquals(expected, bdm.isBreak());
	}

	/**
	 * tests if the BoulderDashModel is not alive
	 */
	@Test
	public void testIsAlive() {
		boolean expected = false;
		assertEquals(expected, bdm.isAlive());
	}

	/**
	 * tests if the BoulderDashModel is not solid
	 */
	@Test
	public void testGetIsSolid() {
		boolean expected = false;
		assertEquals(expected, bdm.getIsSolid());
	}

	/**
	 * tests if the BoulderDashModel is not breakable 
	 */
	@Test
	public void testGetIsBreakable() {
		boolean expected = false;
		assertEquals(expected, bdm.getIsBreakable());
	}

	/**
	 * tests if the BoulderDashModel is not pickable
	 */
	@Test
	public void testIsPickable() {
		boolean expected = false;
		assertEquals(expected, bdm.isPickable());
	}

	/**
	 * tests if the BoulderDashModel is not movable
	 */
	@Test
	public void testIsMovable() {
		boolean expected = false;
		assertEquals(expected, bdm.isMovable());
	}

}
