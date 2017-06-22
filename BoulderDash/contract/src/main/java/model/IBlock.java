package model;

//import model.entity.Alive;
//import model.entity.Direction;

public interface IBlock {
	/*public void crush(Alive alive);
	public void slide(Direction direction);
	public void fall();
	public void setDirection(Direction direction);
	public Direction getDirection();*/
	IBlock[][] getBlock();
	int getId();
	boolean isPickable();
	boolean isMovable();
}
