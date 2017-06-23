package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Map;

public class MapDAO extends AbstractDAO {
	
	/** The sql get Map Code */
	private static String sqlGetMapCode   = "{call getMapCode(?)}";

    /** The sql get Map X size. */
	private static String sqlGetMapXsize = "{call getMapXsize(?)}";

    /** The sql get Map Y size. */
	private static String sqlGetMapYsize   = "{call getMapYsize(?)}";
    
	/**
	 * Create a new Map
	 * @param id
	 * 		the record id in the database
	 * @return a new Map
	 * @throws SQLException
	 * 		throws SQLException if there is an error during database access
	 */
    public static Map getMap(int id) throws SQLException {
    	int x = getMapXsize(id);
    	int y = getMapYsize(id);
		String mapCode = getMapCode(id);
        
    	return new Map(id, x, y, mapCode);
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