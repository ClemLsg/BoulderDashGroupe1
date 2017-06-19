package model.entity;

import model.Position;

public interface IAlive {
	public void Move(Direction direction);
	public void die();
	public void setDirection(Direction direction);
	public Direction getDirection();
	public Position getPosition();
	public void setPosition(Position position);
	public boolean isAlive();
	public void setAlive(boolean isAlive);
}
