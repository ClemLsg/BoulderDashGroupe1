package model.entity;

import model.Direction;
import model.IAlive;
import model.IBlock;
import model.IModel;
import model.ITile;
import model.Position;

public class Alive implements IAlive{
	private Direction direction;
	private boolean isAlive;
	private int id;
	
	public Alive(int id) {
		this.id = id;
		this.setAlive(true);
	}

	public void Move(Direction direction) {
	}

	public void die() {
		this.setAlive(false);
	}
	
	@Override
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	public Direction getDirection() {
		return this.direction;
	}
	
	@Override
	public boolean isAlive() {
		return isAlive;
	}

	@Override
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}


	@Override
	public int getId() {
		return id;
	}
	
	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public IAlive[][] getAlive() {
		return null;
	}

	@Override
	public void move(Direction direction, int xMax, int yMax,IModel boulderDashModel) {
	}

	@Override
	public void setAliveTab(IAlive[][] alive) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ITile[][] getTile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IBlock[][] getBlock() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTiles(ITile[][] tiles) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBlock(IBlock[][] block) {
		// TODO Auto-generated method stub
		
	}


	
	
	
	

}
