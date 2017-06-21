package model;



import java.awt.image.BufferedImage;
import java.sql.SQLException;

import model.dao.MapDAO;
import model.texture.Assets;

/**
 * Created by Lesage Clément on 19/06/2017.
 */

public class BoulderDashModel implements IModel{

    public BoulderDashModel(int id) throws SQLException {
    	Assets assets = new Assets(id);
    	MapDAO mapDAO = new MapDAO();
    	Map map = new Map(id);
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
    
}
