package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Example;
import model.Map;

public class MapDAO extends AbstractDAO {
	
	public MapDAO() {
		
	}
	/** The sql example by id. */
	private static String sqlGetMapCode   = "{call getMapCode(?)}";

    /** The sql example by name. */
	private static String sqlGetMapXsize = "{call getMapXsize(?)}";

    /** The sql all examples. */
	private static String sqlGetMapYsize   = "{call getMapYsize(?)}";
    
    public static Map getMap(int id) throws SQLException {
    	final CallableStatement callStatementMapX = prepareCall(sqlGetMapXsize);
    	String mapCode = "";
    	int x = 0, y = 0;
        
        /* Retrive MapX */
        callStatementMapX.setInt(1, id);
        if (callStatementMapX.execute()) {
            final ResultSet result = callStatementMapX.getResultSet();
            
            if (result.first()) {
                x = result.getInt(2);
            }
            result.close();
        }

    	final CallableStatement callStatementMapY = prepareCall(sqlGetMapYsize);
        /* Retrive MapY */
        callStatementMapY.setInt(1, id);
        if (callStatementMapY.execute()) {
            final ResultSet result = callStatementMapY.getResultSet();
            
            if (result.first()) {
                y = result.getInt(2);
            }
            result.close();
        }
        
		int map[][] = new int[y][x];

    	final CallableStatement callStatementMapCode = prepareCall(sqlGetMapCode);
        /* Retrive MapCode */
    	callStatementMapCode.setInt(1, id);
        if (callStatementMapCode.execute()) {
            final ResultSet result = callStatementMapCode.getResultSet();
            
            if (result.first()) {
                mapCode = result.getString(2);
            }
            result.close();
        }
        int index = 0, i = 0, j = 0;
        
        while(mapCode.charAt(index) != '9') {
        	if(mapCode.charAt(index) == '8') {
        		j++;
        		index++;
        		i = 0;
        	} else {
        		map[j][i] = mapCode.charAt(index);
        		i++;
        		index++;
        	}
        }
    	
    	return new Map(x, y, map);
    }
    
    
    public static int[][] getMapCode(int id) throws SQLException {
    	final CallableStatement callStatement = prepareCall(sqlGetMapCode);
    	String mapCode;
    	int map[][] = {{0,0,0,0}, {0,0,0,0}};
        
        callStatement.setInt(1, id);
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();
            
            if (result.first()) {
                mapCode = result.getString(2);
            }
            result.close();
        }
        
    	
    	return map;
    }

}
