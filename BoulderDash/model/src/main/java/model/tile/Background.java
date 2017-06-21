package model.tile;

public class Background extends Tile{

	public Background(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean getIsSolid(){
		return false;
	}
	
}
