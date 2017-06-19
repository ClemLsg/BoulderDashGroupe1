package model.tile;

import java.awt.image.BufferedImage;

public class Mud extends Tile{

	public Mud(BufferedImage texture, int id) {
		super(texture, id);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean getIsBreakable() {
		// TODO Auto-generated method stub
		return true;
	}
}
