package model.entity;

import model.Direction;
import model.IBlock;
import model.IModel;

public class Rock extends Block{
	private int id;

	public  Rock(int id){
		super(id);
	}

	@Override
	public Direction getDirection() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean isPickable(){
		return false;
	}
	
	@Override
	public boolean isMovable(){
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

	@Override
	public void slide(int i, int j, int yMax, IModel boulderDashModel, boolean pickable) {
		// TODO Auto-generated method stub
		
	}

}


