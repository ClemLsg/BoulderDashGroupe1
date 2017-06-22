package model.entity;

import model.Direction;
import model.IAlive;
import model.IModel;

public class Player extends Alive{
	private int score;
	private Direction direction;
	private int amountDiamonds;
	public Player(int id){
		super(id);
		this.setAlive(true);
	}
	
	@Override
	public void setDirection(Direction direction){
		this.direction = direction;
	}
	
	public int getYPlayerPosition(IAlive alive[][],int x, int y){
		for (int j = 0; j < x; j++){
			for ( int i = 0; i < y; i++){
				if (alive[j][i] instanceof Player){
					return j;
				}
				}
			}
		return (Integer) null;
	}
	
	public int getXPlayerPosition(IAlive[][] alive,int x, int y){
		for (int j = 0; j < x; j++){
			for ( int i = 0; i < y; i++){
				if (alive[j][i] instanceof Player){
					return i;
				}
				}
			}
		return (Integer) null;
	}
	
	@Override
	public void move(Direction direction,IAlive[][] alive,int xMax, int yMax, IModel boulderDashModel){
		int y = getYPlayerPosition(alive, xMax,yMax);
		System.out.println("player y :" + y);
		int x = getXPlayerPosition(alive,xMax,yMax);
		System.out.println("player x :" + x);
		switch (this.direction){
		case UP:
			alive[x][y+1] = alive[x][y];
			alive[x][y] = null;
			break;
		case DOWN:
			alive[x][y-1] = alive[x][y];
			alive[x][y] = null;
			break;
		case LEFT:
			alive[x-1][y] = alive[x][y];
			alive[x][y] = null;
			break;
		case RIGHT:
			alive[x+1][y] = alive[x][y];
			alive[x][y] = null;
			break;
		}
		boulderDashModel.setAlive(alive);
		boulderDashModel.notifyObservers();
	} 
	
	public void dig(Direction direction){
		
	}
	
	public void push(Direction direction){
		
	}
	
	public void pickUp(){
		
	}
	
	public void leave(){
		
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getAmountDiamonds() {
		return amountDiamonds;
	}

	public void setAmountDiamonds(int amountDiamonds) {
		this.amountDiamonds = amountDiamonds;
	}
}
