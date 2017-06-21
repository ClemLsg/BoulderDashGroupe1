package model;

import java.sql.SQLException; 

import model.dao.MapDAO; 

public class Map {
	/** The map id */
	private static int id;
	
	/** the map width */
	private static int width;
	
	/** the map height */
	private static int height;
	
	/** the map Code */
	private static String mapCode;
	
	/** the map */
	private static int[][] map;
	
	/**
	 * Instantiates a new Map
	 * @param x
	 * 		the width of the map
	 * @param y
	 * 		the height of the map
	 * @param mapCode
	 * 		the mapCode of the map
	 */
	public Map(final int x, final int y, final String mapCode) {
		this.width = x;
		this.height = y;
		this.mapCode = mapCode;
		this.map = new int[height][width];
		setMap();
	}
	
	 public Map(int id) throws SQLException { 
		    this.width = MapDAO.getMapXsize(id); 
		    this.height = MapDAO.getMapYsize(id); 
		    this.mapCode = MapDAO.getMapCode(id); 
		    this.map = new int[height][width]; 
		    setMap(); 
		  } 
	
	/**
	 * Gets the view
	 * 
	 * @return the id
	 */
	public static int getId() {
		return id;
	}
	
	/**
	 * Sets the id
	 * @param id
	 * 		the id
	 */
	public static void setId(int id) {
		Map.id = id;
	}
	
	/**
	 * Gets the width
	 * 
	 * @return the width
	 */
	public static int getWidth() {
		return width;
	}
	
	/**
	 * Sets the width
	 * @param width
	 * 		the width
	 */
	public static void setWidth(int width) {
		Map.width = width;
	}
	
	/**
	 * Gets the height
	 * 
	 * @return the height
	 */
	public static int getHeight() {
		return height;
	}
	
	/**
	 * Sets the height
	 * @param height
	 * 		the height
	 */
	public static void setHeight(int height) {
		Map.height = height;
	}
	
	/**
	 * Gets the mapCode
	 * 
	 * @return the mapCode
	 */
	public static String getMapCode() {
		return mapCode;
	}
	
	/**
	 * Sets the mapCode
	 * @param mapCode
	 * 		the mapCode
	 */
	public static void setMapCode(String mapCode) {
		Map.mapCode = mapCode;
	}
	
	/**
	 * Gets the map
	 * 
	 * @return the map
	 */
	public static int[][] getMap() {
		return map;
	}
	
	/**
	 * Convert the mapCode to map
	 */
	private static void setMap() {
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
	}
		
}
