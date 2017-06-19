package model.entity;

import model.Position;

public abstract class Block implements IBlock{
	private Direction direction;
	private Position position;
	private static int SPEED = 2;
	private static int WIDTH = 32;
	private static int HEIGHT = 32;
	
	@Override
	public void crush(Alive alive) {
		alive.setAlive(false);
	}
	@Override
	public void slide(Direction direction) {
		// TODO Auto-generated method stub
	}
	@Override
	public void fall() {
		// TODO Auto-generated method stub

	}
	@Override
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	@Override
	public Direction getDirection() {
		return this.direction;
	}
	
	public boolean isPickable(){
		return false;
		
	}
	public boolean isMovable(){
		return true;
		
	}
	public boolean isSolid(){
		return true;
		
	}
	
}
