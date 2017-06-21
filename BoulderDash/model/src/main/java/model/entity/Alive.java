package model.entity;

import model.IAlive;
import model.Position;

public class Alive implements IAlive{
	private Direction direction;
	private Position position;
	private boolean isAlive;
	private static int SPEED = 3;
	private static int WIDTH = 32;
	private static int HEIGHT = 32;
	private int id;
	
	public Alive(int id) {
		this.id = id;
		this.setAlive(true);
	}

	public void Move(Direction direction) {
		switch (direction){
		case RIGHT :
			this.position.setX(this.position.getX() + Alive.getSPEED());
			break;
		case LEFT:
			this.position.setX(this.position.getX() - Alive.getSPEED());
			break;
		case UP :
			this.position.setY(this.position.getY() - Alive.getSPEED());
			break;
		case DOWN:
			this.position.setY(this.position.getY() + Alive.getSPEED());
			break;
		}
	}

	public void die() {
		this.setAlive(false);
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Direction getDirection() {
		return this.direction;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public static int getSPEED() {
		return SPEED;
	}

	public static void setSPEED(int sPEED) {
		SPEED = sPEED;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public IAlive[][] getAlive() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}
