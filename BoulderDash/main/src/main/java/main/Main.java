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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	System.out.println(test.getWidth());
    }

}
