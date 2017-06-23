package model;

import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.util.Observer;

import javax.swing.ImageIcon;


public interface IModel extends IBlock, IAlive, ITile {
	String getMapCode(int id) throws SQLException;
	int getMapYsize(int id)throws SQLException;
	int getMapXsize(int id)throws SQLException;
    BufferedImage[] getSpriteTab();
    int[][] getMap();
	void setMoved();
	void notifyObservers();
	void setObserver(Observer observer);
	boolean isHasWon();
	void setHasWon(boolean hasWon);
	int getMapDiamonds();
	ImageIcon getLogo();
	int getIdMap();
}
