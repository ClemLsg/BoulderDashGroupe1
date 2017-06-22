package model.entity;

import model.Direction;
import model.IAlive;
import model.IModel;

public class Player extends Alive{
	private int score;
	private Direction direction;
	private int amountDiamonds;
	private IAlive[][] alives;
	int count = 0;
	public Player(int id){
		super(id);
		this.setAlive(true);
	}
	
	@Override
	public void setDirection(Direction direction){
		this.direction = direction;
	}
	
	public int getYPlayerPosition(IAlive[][] alive,int x, int y){
		for (int j = 0; j < y; j++){
			for ( int i = 0; i < x; i++){
				if (alive[i][j] instanceof Player){
					//System.out.println("player yi :" + j);
					return j;
					
				}
				}
			}
		return (Integer) null;
	}
	
	public int getXPlayerPosition(IAlive[][] alive,int x, int y){
		for (int j = 0; j < y; j++){
			for ( int i = 0; i < x; i++){
				if (alive[i][j] instanceof Player){
					//System.out.println("player xi :" + i);
					return i;
				}
				}
			}
		return (Integer) null;
	}
	
	@Override
	public void move(Direction direction,int xMax, int yMax, IModel boulderDashModel){
		this.alives = boulderDashModel.getAlive();
		int y = getYPlayerPosition(alives, xMax,yMax);
		System.out.println("player y :" + y);
		int x = getXPlayerPosition(alives,xMax,yMax);
		System.out.println("player x :" + x);
		switch (this.direction){
		case DOWN:
			alives[x][y+1] = new Player(7);
			alives[x][y] = null;
			count++;
			System.out.println(count);
			
			break;
		case UP:
			alives[x][y-1] = new Player(7);
			alives[x][y] = null;
			break;
		case LEFT:
			alives[x-1][y] = new Player(7);
			alives[x][y] = null;
		
			break;
		case RIGHT:
			alives[x+1][y] = new Player(7);
			alives[x][y] = null;
		
			break;
		}
		boulderDashModel.setAliveTab(alives);
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
