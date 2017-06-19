package model.entity;

import model.Position;

public class Alive implements IAlive {
	private Direction direction;
	private Position position;
	private boolean isAlive;
	private static int SPEED = 3;
	private static int WIDTH = 32;
	private static int HEIGHT = 32;
	
	
	@Override
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

	@Override
	public void die() {
		this.setAlive(false);
	}

	@Override
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	@Override
	public Direction getDirection() {
		return this.direction;
	}
	
	@Override
	public Position getPosition() {
		return position;
	}

	@Override
	public void setPosition(Position position) {
		this.position = position;
	}

	@Override
	public boolean isAlive() {
		return isAlive;
	}

	@Override
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public static int getSPEED() {
		return SPEED;
	}

	public static void setSPEED(int sPEED) {
		SPEED = sPEED;
	}
	
	
	
	

}
