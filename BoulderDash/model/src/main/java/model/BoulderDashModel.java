package model;



import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dao.MapDAO;
import model.entity.*;
import model.texture.Assets;
import model.tile.*;

/**
 * Created by Lesage Clément on 19/06/2017.
 */

public class BoulderDashModel implements IModel{
	
	private Block blocks[][] = new Block[getMapXsize(3)][getMapYsize(3)];
	private Alive alive[][] = new Alive[getMapXsize(3)][getMapYsize(3)];
	private Tile tiles[][] = new Tile[getMapXsize(3)][getMapYsize(3)];
	
	public BoulderDashModel() throws SQLException {
    	Assets assets = new Assets();
    	MapDAO mapDAO = new MapDAO();
    	Map map = new Map(3);
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
					alive[i][j] = new Player(6);
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

	public Block[][] getBlocks() {
		return blocks;
	}

	public Alive[][] getAlive() {
		return alive;
	}

	public Tile[][] getTiles() {
		return tiles;
	}
}
