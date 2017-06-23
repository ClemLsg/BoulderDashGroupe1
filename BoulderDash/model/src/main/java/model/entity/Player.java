package model.entity;

import model.Direction;
import model.IAlive;
import model.IBlock;
import model.IModel;
import model.ITile;
import model.tile.Door;

public class Player extends Alive{
	private int score = 0;
	private Direction direction;
	private int amountDiamonds = 0;
	private IAlive[][] alives;
	private ITile[][] tile;
	private IBlock[][] block;
	
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
					return j;
					
				}
				}
			}
		return 0;
	}
	
	public int getXPlayerPosition(IAlive[][] alive,int x, int y){
		for (int j = 0; j < y; j++){
			for ( int i = 0; i < x; i++){
				if (alive[i][j] instanceof Player){
					return i;
				}
				}
			}
		return 0;
	}
	
	@Override
	public void move(Direction direction,int xMax, int yMax, IModel boulderDashModel){
		this.alives = boulderDashModel.getAlive();
		this.tile = boulderDashModel.getTile();
		this.block = boulderDashModel.getBlock();
		int y = getYPlayerPosition(alives, xMax,yMax);
		int x = getXPlayerPosition(alives,xMax,yMax);
		switch (this.direction){
		case DOWN:
			if (checkMovementDOWN(x, y, tile, block, alives, boulderDashModel) == 1){break;}
			if(block[x][y+1] != null && block[x][y+1].isPickable() == true){
				block[x][y+1] = null;
				this.setAmountDiamonds(this.getAmountDiamonds()+1);
			}
			if(block[x][y-1] != null){
				block[x][y-1].fall(x, y-1, yMax, boulderDashModel, block[x][y-1].isPickable());
			}
			if(tile[x][y+1] instanceof Door && this.getAmountDiamonds() == boulderDashModel.getMapDiamonds()){
				alives[x][y].setAlive(false);
				alives[x][y] = null;
				boulderDashModel.setHasWon(true);
			} else {
				alives[x][y+1] = new Player(7);
				alives[x][y] = null;
			}
			break;
		case UP:
			if (checkMovementUP(x, y, tile, block, alives, boulderDashModel) == 1){break;}
			if(block[x][y-1] != null && block[x][y-1].isPickable() == true){
				block[x][y-1] = null;
				this.setAmountDiamonds(this.getAmountDiamonds()+1);
			}
			if(tile[x][y-1] instanceof Door && this.getAmountDiamonds() == boulderDashModel.getMapDiamonds()){
				alives[x][y].setAlive(false);
				alives[x][y] = null;
				boulderDashModel.setHasWon(true);
			} else {
				alives[x][y-1] = new Player(7);
				alives[x][y] = null;
			}
			break;
		case LEFT:
			if (checkMovementLEFT(x, y, tile, block, alives, boulderDashModel) == 1){break;}
			if(block[x-1][y] != null && block[x-1][y].isPickable() == true){
				block[x-1][y] = null;
				this.setAmountDiamonds(this.getAmountDiamonds()+1);
			} else if(block[x-1][y] != null && block[x-1][y].isMovable() == true){
				if(tile[x-2][y] == null && block[x-2][y] == null){
					block[x-2][y] = new Rock(5);
					block[x-1][y] = null;
				} else {
					break;
				}
			}
			if(block[x][y-1] != null){
				block[x][y-1].fall(x, y-1, yMax, boulderDashModel, block[x][y-1].isPickable());
			}
			if(tile[x-1][y] instanceof Door && this.getAmountDiamonds() == boulderDashModel.getMapDiamonds()){
				alives[x][y].setAlive(false);
				alives[x][y] = null;
				boulderDashModel.setHasWon(true);
			} else {
				alives[x-1][y] = new Player(7);
				alives[x][y] = null;
			}
			break;
		case RIGHT:
			if (checkMovementRIGHT(x, y, tile, block, alives, boulderDashModel) == 1){break;}
			if(block[x+1][y] != null && block[x+1][y].isPickable() == true){
				block[x+1][y] = null;
				this.setAmountDiamonds(this.getAmountDiamonds()+1);
			} else if(block[x+1][y] != null && block[x+1][y].isMovable() == true){
				if(tile[x+2][y] == null && block[x+2][y] == null){
					block[x+2][y] = new Rock(5);
					block[x+1][y] = null;
				} else {
					break;
				}
			}
			if(block[x][y-1] != null){
				block[x][y-1].fall(x, y-1, yMax, boulderDashModel, block[x][y-1].isPickable());
			}
			if(tile[x+1][y] instanceof Door && this.getAmountDiamonds() == boulderDashModel.getMapDiamonds()){
				alives[x][y].setAlive(false);
				alives[x][y] = null;
				boulderDashModel.setHasWon(true);
			} else {
				alives[x+1][y] = new Player(7);
				alives[x][y] = null;
			}
			break;
		}
		boulderDashModel.setAliveTab(alives);
		boulderDashModel.setTiles(tile);
		boulderDashModel.setBlock(block);
		boulderDashModel.notifyObservers();
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
