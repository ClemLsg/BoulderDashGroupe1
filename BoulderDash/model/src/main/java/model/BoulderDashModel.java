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
	
	private IBlock[][] blocks;
	private IAlive[][] alive;
	private ITile[][] tiles;
	private IAlive player;
	private IAlive mob;
	private Observer observer;
	private boolean isAlive = true;
	private boolean hasWon = false;
	private int mapDiamonds = 0;
	private ImageIcon logo;
	private int idMap;
	
	
	
	public BoulderDashModel(int id) throws SQLException {
		logo = new ImageIcon("C:\\Users\\anton\\Documents\\GitHub\\Boulder2\\BoulderDash\\main\\src\\main\\resources\\boulder-dash-logo.png");
    	
		this.setIdMap(id);
		blocks = new Block[getMapXsize(id)][getMapYsize(id)];
		alive = new Alive[getMapXsize(id)][getMapYsize(id)];
		tiles = new Tile[getMapXsize(id)][getMapYsize(id)];
		new Assets(id);
    	new MapDAO();
    	new Map(id);
    	int[][] mapcode = getMap();
    	int obj;
    	for (int j = 0; j < getMapYsize(id); j++){
			for ( int i = 0; i < getMapXsize(id); i++){
				obj = mapcode[j][i];
				switch(obj){
				case 0: //background
					tiles[i][j] = null;
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
						 setMob(alive[i][j]);
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
	@Override
	public int getIdMap() {
		return idMap;
	}
	public void setIdMap(int idMap) {
		this.idMap = idMap;
	}
	@Override
	public void moveMobs(int xMax, int yMax, IModel boulderDashModel) {
		System.out.println("Mob1");
		IAlive[][] alive = boulderDashModel.getAlive();
		ITile[][] tile = boulderDashModel.getTile();
		IBlock[][] block = boulderDashModel.getBlock();
		 for (int j = 0; j < yMax; j++){
				for (int i = 0; i < xMax; i++){
					if(alive[i][j] != null && alive[i][j] instanceof Mob1){
						Random rand = new Random();
						 int randomNum = rand.nextInt((3 - 0) + 3) + 0;
						 switch(randomNum){
						 case 0 : // UP
							 if(tile[i][j-1] == null && block[i][j-1] == null){
							 if (alive[i][j-1] != null && alive[i][j-1] instanceof Player){
									alive[i][j-1].setAlive(false);
									alive[i][j-1].explodes(i, j-1, tile, block, alive);
									this.setAlive(false);
									alive[i][j-1] = null;
									boulderDashModel.setAliveTab(alive);
									boulderDashModel.notifyObservers();
								 } else {
									 alive[i][j-1] = new Mob1(3);
									 alive[i][j] = null; 
								 }
							 } 
							break;
						 case 1 : // DOWN
							 if(tile[i][j+1] == null && block[i][j+1] == null){
								 if (alive[i][j+1] != null && alive[i][j+1] instanceof Player){
									 alive[i][j+1].setAlive(false);
										alive[i][j+1].explodes(i, j+1, tile, block, alive);
										this.setAlive(false);
										alive[i][j+1] = null;
										boulderDashModel.setAliveTab(alive);
										boulderDashModel.notifyObservers();
								 } else {
									 alive[i][j+1] = new Mob1(3);
									 alive[i][j] = null;
								 }
							 } 
							break;
						 case 2 : // LEFT
							 if(tile[i-1][j] == null && block[i-1][j] == null){
								 if (alive[i-1][j] != null && alive[i-1][j] instanceof Player){
									 alive[i-1][j].setAlive(false);
										alive[i-1][j].explodes(i-1, j, tile, block, alive);
										this.setAlive(false);
										alive[i-1][j] = null;
										boulderDashModel.setAliveTab(alive);
										boulderDashModel.notifyObservers();
								 } else {
									 alive[i-1][j] = new Mob1(3);
									 alive[i][j] = null;
								 }
							 } 
							break;
						 case 3 : // RIGHT
							 if(tile[i+1][j] == null && block[i+1][j] == null){
								 if (alive[i+1][j] != null && alive[i+1][j] instanceof Player){
									 alive[i+1][j].setAlive(false);
										alive[i+1][j].explodes(i+1, j, tile, block, alive);
										this.setAlive(false);
										alive[i+1][j] = null;
										boulderDashModel.setAliveTab(alive);
										boulderDashModel.notifyObservers();
								 } else {
									 alive[i+1][j] = new Mob1(3);
									 alive[i][j] = null;
								 }
							 }
							break;
						 }
					}
				}
			}
	}
	public IAlive getMob() {
		return mob;
	}
	public void setMob(IAlive mob) {
		this.mob = mob;
	}
}
