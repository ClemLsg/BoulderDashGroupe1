package model.entity;

public abstract class Block implements IBlock{
	private static int SPEED = 2;
	private static int WIDTH = 32;
	private static int HEIGHT = 32;
	@Override
	public void crush(Alive alive) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}
	@Override
	public Direction getDirection() {
		// TODO Auto-generated method stub
		return null;
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
