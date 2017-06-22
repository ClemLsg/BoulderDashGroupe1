package model;

public interface IAlive {
	//public void Move(Direction direction);
	//public void die();
	//public void setDirection(Direction direction);
	//public Direction getDirection();
	//public Position getPosition();
	//public void setPosition(Position position);
	public boolean isAlive();
	public void setAlive(boolean isAlive);
	public int getId();
	public void setId(int id);
	IAlive[][] getAlive();
	void setDirection(Direction direction);
	void setAlive(IAlive[][] alive);
	void move(Direction direction, IAlive[][] alive, int xMax, int yMax,IModel boulderDashModel);
}
