package model.entity;

import model.Direction;
import model.IBlock;
import model.Position;

public abstract class Block implements IBlock{
	private Direction direction;
	private Position position;
	private static int SPEED = 2;
	private static int WIDTH = 32;
	private static int HEIGHT = 32;
	int id;
	
	public Block(int id) {
		this.setId(id);
	}

	public void crush(Alive alive) {
		alive.setAlive(false);
	}
	
	public void slide(Direction direction) {
		// TODO Auto-generated method stub
	}
	
	public void fall() {
		// TODO Auto-generated method stub

	}
	
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
