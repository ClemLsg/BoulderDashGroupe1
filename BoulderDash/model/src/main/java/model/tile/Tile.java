package model.tile;

public class Tile implements ITile{
	public static Tile tile[];
	private TileType tileType;
	private int id; 
	
	public Tile(int id){
		this.setId(id);
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	
}
