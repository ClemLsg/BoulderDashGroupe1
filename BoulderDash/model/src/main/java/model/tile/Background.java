package model.tile;

import java.awt.image.BufferedImage;

public class Background extends Tile{

	public Background(BufferedImage texture, int id) {
		super(texture, id);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean getIsSolid(){
		return false;
	}
	
}
