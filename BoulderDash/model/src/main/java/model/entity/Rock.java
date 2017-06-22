package model.entity;

import model.Direction;
import model.IBlock;

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


