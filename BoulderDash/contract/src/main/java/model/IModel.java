package model;

import java.awt.image.BufferedImage;
import java.sql.SQLException;


public interface IModel {
	String getMapCode(int id) throws SQLException;
	int getMapYsize(int id)throws SQLException;
	int getMapXsize(int id)throws SQLException;
    BufferedImage[] getSpriteTab();

}
