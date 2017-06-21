package model.entity;

import model.IBlock;

public class Diamond extends Block{
	private int id;

	public Diamond(int id){
		super(id);
	}
	
	@Override
	public Direction getDirection() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean isPickable(){
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public IBlock[][] getBlock() {
		// TODO Auto-generated method stub
		return null;
	}

}
