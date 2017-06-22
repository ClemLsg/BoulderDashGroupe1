package model;

import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.util.Observer;


public interface IModel extends IBlock, IAlive, ITile {
	String getMapCode(int id) throws SQLException;
	int getMapYsize(int id)throws SQLException;
	int getMapXsize(int id)throws SQLException;
    BufferedImage[] getSpriteTab();
    int[][] getMap();
	void setMoved();
	void notifyObservers();
	void setObserver(Observer observer);
    
}
