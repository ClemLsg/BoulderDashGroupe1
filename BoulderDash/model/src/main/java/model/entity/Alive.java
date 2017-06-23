package model.entity;

import model.Direction;
import model.IAlive;
import model.IBlock;
import model.IModel;
import model.ITile;

public class Alive implements IAlive{
	private Direction direction;
	private boolean isAlive;
	private int id;
	
	public Alive(int id) {
		this.id = id;
		this.setAlive(true);
	}

	public void Move(Direction direction) {}
	/**
	 * Check a down movement
	 * @param x, y, tile, block, alive
	 * The position and the alive
	 */
	public int checkMovementDOWN(int x, int y, ITile[][] tile, IBlock[][] block, IAlive[][] alive, IModel boulderDashModel){
		int result;
				if(tile[x][y+1] != null && tile[x][y+1].getIsSolid() == true){
					result = 1;
					return result;
				} else if(tile[x][y+1] != null && tile[x][y+1].getIsBreakable() == true){
					tile[x][y+1] = null;
				} else if(block[x][y+1] != null && block[x][y+1].isPickable() == false){
					result = 1;
					return result;
				} else if(alive[x][y+1] != null){
					result = 1;
					return result;
				}
		result = 0;
		return result;
	}
	/**
	 * Check a up movement
	 * @param x, y, tile, block, alive
	 * The position and the alive
	 */
	public int checkMovementUP(int x, int y, ITile[][] tile, IBlock[][] block, IAlive[][] alive, IModel boulderDashModel){
		int result;
		if(tile[x][y-1] != null && tile[x][y-1].getIsSolid() == true){
			result = 1;
			return result;
		} else if(tile[x][y-1] != null && tile[x][y-1].getIsBreakable() == true){
			tile[x][y-1] = null;
		} else if(block[x][y-1] != null && block[x][y-1].isPickable() == false){
			result = 1;
			return result;
		} else if(alive[x][y-1] != null){
			result = 1;
			return result;
		}
		result = 0;
		return result;
	}
	/**
	 * Check a left movement
	 * @param x, y, tile, block, alive
	 * The position and the alive
	 */
	public int checkMovementLEFT(int x, int y, ITile[][] tile, IBlock[][] block, IAlive[][] alive, IModel boulderDashModel){
		int result;
		if(tile[x-1][y] != null && tile[x-1][y].getIsSolid() == true){
			result = 1;
			return result;
		} else if(tile[x-1][y] != null && tile[x-1][y].getIsBreakable() == true){
			tile[x-1][y] = null;
		} else if(alive[x-1][y] != null){
			result = 1;
			return result;
		}
		result = 0;
		return result;
	}
	/**
	 * Check a right movement
	 * @param x, y, tile, block, alive
	 * The position and the alive
	 */
	public int checkMovementRIGHT(int x, int y, ITile[][] tile, IBlock[][] block, IAlive[][] alive, IModel boulderDashModel){
		int result;
		if(tile[x+1][y] != null && tile[x+1][y].getIsSolid() == true){
			result = 1;
			return result;
		} else if(tile[x+1][y] != null && tile[x+1][y].getIsBreakable() == true){
			tile[x+1][y] = null;
		} else if(alive[x+1][y] != null){
			result = 1;
			return result;
		}
		result = 0;
		return result;
	}
	/**
	 * Make an explosion around the alive thing
	 * @param x, y, tile, block, alive
	 * The position and the alive who will explode
	 */
	@Override
	public void explodes(int x, int y, ITile[][] tile, IBlock[][] block, IAlive[][] alive){
		if(tile[x+1][y] != null && tile[x+1][y].getIsSolid() != true){tile[x+1][y] = null;}
		if(tile[x+1][y+1] != null && tile[x+1][y+1].getIsSolid() != true){tile[x+1][y+1] = null;}
		if(tile[x+1][y-1] != null && tile[x+1][y-1].getIsSolid() != true){tile[x+1][y-1] = null;}
		if(tile[x][y+1] != null && tile[x][y+1].getIsSolid() != true){tile[x][y+1] = null;}
		if(tile[x+1][y] != null && tile[x+1][y].getIsSolid() != true){tile[x-1][y+1] = null;}
		if(tile[x-1][y+1] != null && tile[x-1][y+1].getIsSolid() != true){tile[x-1][y] = null;}
		if(tile[x-1][y-1] != null && tile[x-1][y-1].getIsSolid() != true){tile[x-1][y-1] = null;}
		if(tile[x][y-1] != null && tile[x][y-1].getIsSolid() != true){tile[x][y-1] = null;}
		
		if(block[x+1][y] != null){block[x+1][y] = null;}
		if(block[x+1][y+1] != null){block[x+1][y+1] = null;}
		if(block[x+1][y-1] != null){block[x+1][y-1] = null;}
		if(block[x][y+1] != null){block[x][y+1] = null;}
		if(block[x-1][y+1] != null){block[x-1][y+1] = null;}
		if(block[x-1][y] != null){block[x-1][y] = null;}
		if(block[x-1][y-1] != null){block[x-1][y-1] = null;}
		if(block[x][y-1] != null){block[x][y-1] = null;}
		
		if(alive[x+1][y] != null){alive[x+1][y] = null;}
		if(alive[x+1][y+1] != null){alive[x+1][y+1] = null;}
		if(alive[x+1][y-1] != null){alive[x+1][y-1] = null;}
		if(alive[x][y+1] != null){alive[x][y+1] = null;}
		if(alive[x-1][y+1] != null){alive[x-1][y+1] = null;}
		if(alive[x-1][y] != null){alive[x-1][y] = null;}
		if(alive[x-1][y-1] != null){alive[x-1][y-1] = null;}
		if(alive[x][y-1] != null){alive[x][y-1] = null;}
	}
	
	@Override
	public void setDirection(Direction direction) {this.direction = direction;}
	public Direction getDirection() {return this.direction;}	
	@Override
	public boolean isAlive() {return isAlive;}
	@Override
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	@Override
	public int getId() {return id;}	
	@Override
	public void setId(int id) {this.id = id;}
	@Override
	public IAlive[][] getAlive() {return null;}
	@Override
	public void move(Direction direction, int xMax, int yMax,IModel boulderDashModel) {}
	@Override
	public void setAliveTab(IAlive[][] alive) {}
	@Override
	public ITile[][] getTile() {return null;}
	@Override
	public IBlock[][] getBlock() {return null;}
	@Override
	public void setTiles(ITile[][] tiles) {}
	@Override
	public void setBlock(IBlock[][] block) {}

	@Override
	public void moveMobs(int xMax, int yMax, IModel boulderDashModel) {
		
	}
}
