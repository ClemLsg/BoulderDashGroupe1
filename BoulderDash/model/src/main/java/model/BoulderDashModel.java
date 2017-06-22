package model;



import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import model.dao.MapDAO;
import model.entity.*;
import model.texture.Assets;
import model.tile.*;

/**
 * Created by Lesage Clément on 19/06/2017.
 */

public class BoulderDashModel extends Observable implements IModel, IBlock, IAlive, ITile{
	
	private IBlock blocks[][] = new Block[getMapXsize(3)][getMapYsize(3)];
	private IAlive alive[][] = new Alive[getMapXsize(3)][getMapYsize(3)];
	private ITile tiles[][] = new Tile[getMapXsize(3)][getMapYsize(3)];
	private IAlive player;
	private Observer observer;
	
	public BoulderDashModel(int id) throws SQLException {
    	
		Assets assets = new Assets(id);
    	MapDAO mapDAO = new MapDAO();
    	Map map = new Map(id);
    	//this.addObserver();
    	int[][] mapcode = getMap();
    	int obj;
    	for (int j = 0; j < getMapYsize(3); j++){
			for ( int i = 0; i < getMapXsize(3); i++){
				obj = mapcode[j][i];
				switch(obj){
				case 0: //background
					tiles[i][j] = new Background(0);
					break;
				case 1: //door
					tiles[i][j]= new Door(1);
					break;
				case 2: //mud
					tiles[i][j] = new Mud(2);
					break;
				case 4: //wall
					tiles[i][j] = new Wall(4);
					break;
				case 5: //rock
					blocks[i][j] = new Rock(5);
					break;
				case 6: //diamond
					blocks[i][j] = new Diamond(6);
					break;
				case 7: //player
					alive[i][j] = new Player(7);
					player = alive[i][j];
					break;
				default :
					tiles[i][j] = null;
					blocks[i][j] = null;
					alive[i][j] = null;
					break;
				}
				//System.out.println(blocks[i][j]);
			}
		}
    }

	@Override
	public BufferedImage[] getSpriteTab() {
		return Assets.getSpriteTab();
	}

	@Override
	public String getMapCode(int id) throws SQLException {
		return MapDAO.getMapCode(id);
	}


	@Override
	public int getMapYsize(int id) throws SQLException{
		return MapDAO.getMapYsize(id);
	}


	@Override
	public int getMapXsize(int id) throws SQLException{
		return MapDAO.getMapXsize(id);
	}


	@Override
	public int[][] getMap() {
		return Map.getMap();
	}

	@Override
	public IBlock[][] getBlock() {
		// TODO Auto-generated method stub
		return blocks;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setId(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IAlive[][] getAlive() {
		// TODO Auto-generated method stub
		return alive;
	}
	
	@Override
	public void setAlive(IAlive[][] alive) {
		this.alive = alive;
	}

	@Override
	public ITile[][] getTile() {
		// TODO Auto-generated method stub
		return tiles;
	}

	@Override
	public boolean isBreak() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setBreak(boolean isBreak) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setAlive(boolean isAlive) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDirection(Direction direction) {
	
		player.setDirection(direction);
	}

	@Override
	public void move(Direction direction, IAlive[][] alive, int xMax, int yMax,IModel boulderDashModel) {
	
		player.move(direction, alive, xMax, yMax, boulderDashModel);
	}
	
	@Override
	public void notifyObservers(){
	}
	
	@Override
	public void setObserver(Observer observer){
		this.observer = observer;
	}

	@Override
	public void setMoved() {
		// TODO Auto-generated method stub
		
	}
}
