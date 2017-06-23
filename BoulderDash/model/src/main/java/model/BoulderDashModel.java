package model;

import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javax.swing.ImageIcon;

import model.dao.MapDAO;
import model.entity.*;
import model.texture.Assets;
import model.tile.*;

/**
 * Created by Lesage Clément on 19/06/2017.
 */

public class BoulderDashModel extends Observable implements IModel, IBlock, IAlive, ITile{
	
	private IBlock[][] blocks = new Block[getMapXsize(1)][getMapYsize(1)];
	private IAlive[][] alive = new Alive[getMapXsize(1)][getMapYsize(1)];
	private ITile[][] tiles = new Tile[getMapXsize(1)][getMapYsize(1)];
	private IAlive player;
	private IBlock rock;
	private Observer observer;
	private boolean isAlive = true;
	private boolean hasWon = false;
	private int mapDiamonds = 0;
	private ImageIcon logo;
	
	public BoulderDashModel(int id) throws SQLException {
		logo = new ImageIcon("C:\\Users\\Darkdady\\Documents\\Git\\BoulderDashGroupe1\\BoulderDash\\main\\src\\main\\resources\\boulder-dash-logo.png");
    	
		new Assets(id);
    	new MapDAO();
    	new Map(id);
    	int[][] mapcode = getMap();
    	int obj;
    	for (int j = 0; j < getMapYsize(1); j++){
			for ( int i = 0; i < getMapXsize(1); i++){
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
				case 3: //mob
					Random rand = new Random();
					 int randomNum = rand.nextInt((1 - 0) + 1) + 0;
					 switch(randomNum){
					 case 0 :
						 alive[i][j] = new Mob1(3);
						 break;
					 case 1 :
						 alive[i][j] = new Mob2(8);
						 break;
					 }
					break;
				case 4: //wall
					tiles[i][j] = new Wall(4);
					break;
				case 5: //rock
					blocks[i][j] = new Rock(5);
					break;
				case 6: //diamond
					blocks[i][j] = new Diamond(6);
					this.setMapDiamonds(this.getMapDiamonds()+1);
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
			}
		}
    }
	@Override
	public BufferedImage[] getSpriteTab() {return Assets.getSpriteTab();}
	@Override
	public String getMapCode(int id) throws SQLException {return MapDAO.getMapCode(id);}
	@Override
	public int getMapYsize(int id) throws SQLException{return MapDAO.getMapYsize(id);}
	@Override
	public int getMapXsize(int id) throws SQLException{return MapDAO.getMapXsize(id);}
	@Override
	public int[][] getMap() {return Map.getMap();}
	@Override
	public IBlock[][] getBlock() {return blocks;}
	@Override
	public int getId() {return 0;}
	@Override
	public void setId(int id) {}
	@Override
	public IAlive[][] getAlive() {return alive;}
	@Override
	public void setAliveTab(IAlive[][] alive) {this.alive = alive;}
	@Override
	public ITile[][] getTile() {return tiles;}
	@Override
	public void setTiles(ITile[][] tiles) {this.tiles = tiles;}
	@Override
	public boolean isBreak() {return false;}
	@Override
	public void setBreak(boolean isBreak) {}
	@Override
	public boolean isAlive() {return isAlive;}
	@Override
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	@Override
	public void setDirection(Direction direction) {
	
		player.setDirection(direction);
	}
	@Override
	public void move(Direction direction, int xMax, int yMax,IModel boulderDashModel) {
	
		player.move(direction, xMax, yMax, this);
	}	
	@Override
	public void notifyObservers(){
		observer.update(this, alive);
		observer.update(this, tiles);
		observer.update(this, blocks);
	}
	@Override
	public void setObserver(Observer observer){this.observer = observer;}
	@Override
	public void setMoved() {}
	@Override
	public void setBlock(IBlock[][] block) {this.blocks = block;}
	@Override
	public boolean getIsSolid() {return false;}
	@Override
	public boolean getIsBreakable() {return false;}
	@Override
	public boolean isPickable() {return false;}
	@Override
	public boolean isMovable() {return false;}
	@Override
	public void fall(int x, int y, int Ymax, IModel boulderDashModel, boolean pickable) {}
	@Override
	public void explodes(int x, int y, ITile[][] tile, IBlock[][] block, IAlive[][] alive) {}
	@Override
	public void slide(int i, int j, int yMax, IModel boulderDashModel, boolean pickable) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean isHasWon() {
		return hasWon;
	}
	@Override
	public void setHasWon(boolean hasWon) {
		this.hasWon = hasWon;
	}
	public int getMapDiamonds() {
		return mapDiamonds;
	}
	public void setMapDiamonds(int mapDiamonds) {
		this.mapDiamonds = mapDiamonds;
	}
	@Override
	public ImageIcon getLogo() {
		return logo;
	}
}
