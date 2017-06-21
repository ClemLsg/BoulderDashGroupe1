package model.tile;

import model.ITile;

public class Tile implements ITile{
	public static Tile tile[];
	private boolean isBreak;
	private TileType tileType;
	private int id; 
	
	public Tile(int id){
		this.setId(id);
		this.setBreak(false);
	}

	public boolean getIsSolid() {
		// TODO Auto-generated method stub
		return true;
	}

	
	public boolean getIsBreakable() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public ITile[][] getTile() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isBreak() {
		return isBreak;
	}

	public void setBreak(boolean isBreak) {
		this.isBreak = isBreak;
	}


	
}
