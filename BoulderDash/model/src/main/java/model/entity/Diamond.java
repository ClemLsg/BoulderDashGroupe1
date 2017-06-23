package model.entity;

import model.Direction;
import model.IBlock;
import model.IModel;

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
	
	@Override
	public boolean isMovable(){
		return false;
		
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
