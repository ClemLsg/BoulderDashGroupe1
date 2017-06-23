package model.entity;

import model.Direction;
import model.IAlive;
import model.IBlock;
import model.IModel;
import model.ITile;

public abstract class Block implements IBlock{
	private Direction direction;
	int id;
	
	private IBlock[][] block;

	
	public Block(int id) {
		this.setId(id);
	}
	
	@Override
	public void fall(int x, int yx, int Ymax, IModel boulderDashModel, boolean pickable){
		Thread thread = new Thread(){
			private IAlive[][] alives;
			private ITile[][] tile;
			private IBlock[][] block;
			private int y = yx;
			public void run(){
				this.alives = boulderDashModel.getAlive();
				this.tile = boulderDashModel.getTile();
				this.block = boulderDashModel.getBlock();
				while(block[x][y+1] == null && tile[x][y+1] == null){
					System.out.println("FALL");
					if(pickable == true){
						block[x][y+1] = new Diamond(6);
					} else {
						block[x][y+1] = new Rock(5);
					}
					if(alives[x][y+1] != null){
						alives[x][y+1].setAlive(false);
						alives[x][y+1].explodes(x, y+1, tile, block, alives);
						if(alives[x][y+1] instanceof Player){
							boulderDashModel.setAlive(false);
						}
						alives[x][y+1] = null;
					}
					block[x][y] = null;
					y++;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					boulderDashModel.setBlock(block);
					boulderDashModel.notifyObservers();
				}
			}
		};
		thread.start();
		
	}
	
	public void slide(int x, int y, int Ymax, IModel boulderDashModel, Direction direction){
		boulderDashModel.getAlive();
		boulderDashModel.getTile();
		this.block = boulderDashModel.getBlock();
		switch(direction){
		case LEFT :
			if(block[x][y].isPickable() == true){
				block[x+1][y] = new Diamond(6);
			} else {
				block[x+1][y] = new Rock(5);
			}
			block[x][y] = null;
			break;
		case RIGHT :
			if(block[x][y].isPickable() == true){
				block[x-1][y] = new Diamond(6);
			} else {
				block[x-1][y] = new Rock(5);
			}
			block[x][y] = null;
			break;
		default:
			break;
		}
		boulderDashModel.setBlock(block);
		boulderDashModel.notifyObservers();
	}
	
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	
	public Direction getDirection() {
		return this.direction;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
