package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Map;

public class MapDAO extends AbstractDAO {
	/*public MapDAO() {
		
	}*/
	/** The sql example by id. */
	private static String sqlGetMapCode   = "{call getMapCode(?)}";

    /** The sql example by name. */
	private static String sqlGetMapXsize = "{call getMapXsize(?)}";

    /** The sql all examples. */
	private static String sqlGetMapYsize   = "{call getMapYsize(?)}";
    
	/**
	 * Create a new Map
	 * @param id
	 * 		the record id in the database
	 * @return a new Map
	 * @throws SQLException
	 */
    public static Map getMap(int id) throws SQLException {
    	int x = getMapXsize(id);
    	int y = getMapYsize(id);
		int map[][] = new int[y][x];
		
		String mapCode = getMapCode(id);
		
        int index = 0, i = 0, j = 0;
        
        while(mapCode.charAt(index) != '9') {
        	if(mapCode.charAt(index) == '8') {
        		j++;
        		index++;
        		i = 0;
        	} else {
        		map[j][i] = Character.getNumericValue(mapCode.charAt(index));
        		i++;
        		index++;
        	}
        }
        
    	return new Map(x, y, map);
    }
    
    /**
     * Gets the map width
     * @param id
     * 		the record id in the database
     * @return the map's width
     * @throws SQLException
     */
    public static int getMapXsize(int id) throws SQLException {
    	final CallableStatement callStatementMapX = prepareCall(sqlGetMapXsize);
    	int x = 0;
        
        callStatementMapX.setInt(1, id);
        if (callStatementMapX.execute()) {
            final ResultSet result = callStatementMapX.getResultSet();
            
            if (result.first()) {
                x = result.getInt(2);
            }
            result.close();
        }
        System.out.println(x);
    	return x;
    }
    
    /**
     * 
     * @param id
     * 		the record id in database
     * @return the map's height
     * @throws SQLException
     */
    public static int getMapYsize(int id) throws SQLException {
    	final CallableStatement callStatementMapY = prepareCall(sqlGetMapYsize);
    	int y = 0;
        
        callStatementMapY.setInt(1, id);
        if (callStatementMapY.execute()) {
            final ResultSet result = callStatementMapY.getResultSet();
            
            if (result.first()) {
                y = result.getInt(2);
            }
            result.close();
        }
        System.out.println(y);
        return y;
    }
    
    /**
     * Gets the map code
     * @param id
     * 		the record id in database
     * @return the map code
     * @throws SQLException
     */
    public static String getMapCode(int id) throws SQLException {
    	final CallableStatement callStatementMapCode = prepareCall(sqlGetMapCode);
    	String mapCode = "";
    	callStatementMapCode.setInt(1, id);
        if (callStatementMapCode.execute()) {
            final ResultSet result = callStatementMapCode.getResultSet();
            
            if (result.first()) {
                mapCode = result.getString(2);
            }
            result.close();
        }
        
        return mapCode;
    }
}