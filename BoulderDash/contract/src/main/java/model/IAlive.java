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
	ITile[][] getTile();
	IBlock[][] getBlock();
	void setDirection(Direction direction);
	void move(Direction direction, int xMax, int yMax,IModel boulderDashModel);
	void setAliveTab(IAlive[][] alive);
	void setTiles(ITile[][] tiles);
	void setBlock(IBlock[][] block);
}
