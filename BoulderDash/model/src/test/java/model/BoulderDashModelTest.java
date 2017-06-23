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

	@Test (expected = SQLException.class)
	public void testGetMapCode() throws SQLException  {
		assert (this.bdm.getMapCode(id).length() == this.bdm.getMapXsize(id) * this.bdm.getMapYsize(id) + this.bdm.getMapYsize(id)) || (this.bdm.getMapCode(id).length() == this.bdm.getMapYsize(id) * this.bdm.getMapXsize(id) + this.bdm.getMapYsize(id) + 1): "Error: incorrect mapCode";
	}

	@Test (expected = SQLException.class)
	public void testGetMapYsize() throws SQLException {
		assert bdm.getMapXsize(this.id) >= 0 : "Error, width can't be < 0";
	}

	@Test (expected = SQLException.class)
	public void testGetMapXsize() throws SQLException {
		assert bdm.getMapXsize(this.id) >= 0 : "Error, width can't be < 0";
	}

	@Test
	public void testGetMap() {
		int[][] unexpected = null;
		assert bdm.getMap() != unexpected : "Error: Map is null";
	}

	@Test
	public void testGetId() {
		int expected = id;
		assertEquals(expected, bdm.getId());
		assert (bdm.getId() >= 0) && (bdm.getId() <= 7) : "Error: id out of range";
	}

	@Test
	public void testIsBreak() {
		boolean expected = false;
		assertEquals(expected, bdm.isBreak());
	}

	@Test
	public void testIsAlive() {
		boolean expected = false;
		assertEquals(expected, bdm.isAlive());
	}

	@Test
	public void testGetIsSolid() {
		boolean expected = false;
		assertEquals(expected, bdm.getIsSolid());
	}

	@Test
	public void testGetIsBreakable() {
		boolean expected = false;
		assertEquals(expected, bdm.getIsBreakable());
	}

	@Test
	public void testIsPickable() {
		boolean expected = false;
		assertEquals(expected, bdm.isPickable());
	}

	@Test
	public void testIsMovable() {
		boolean expected = false;
		assertEquals(expected, bdm.isMovable());
	}

}
