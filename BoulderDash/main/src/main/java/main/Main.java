package main;

import java.sql.SQLException;

import model.Map;
import model.dao.MapDAO;

public abstract class Main {

    public static void main(final String[] args) {
    	Map test = null;
    	
    	try {
			test = MapDAO.getMap(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}

    	System.out.println("");
    	for(int j = 0; j < test.getHeight(); j++) {
    		for(int i = 0; i < test.getWidth(); i++) {
    			System.out.print(test.getMapCode()[j][i]);
    		}
    		System.out.println("");
    	}
    	
    	System.out.println(test.getWidth());
    	System.out.println(test.getHeight());
    }

}
