package model.tile;

import java.awt.image.BufferedImage;

public class Tile implements ITile{
	public static Tile tile[];
	private TileType tileType; 
	
	public Tile(BufferedImage texture, int id){
		
	}

	@Override
	public boolean getIsSolid() {
		// TODO Auto-generated method stub
		return true;
	}

	
	@Override
	public boolean getIsBreakable() {
		// TODO Auto-generated method stub
		return false;
	}


	
}
