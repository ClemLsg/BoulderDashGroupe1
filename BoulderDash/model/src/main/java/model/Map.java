package model;

public class Map {
	private static int id;
	private static int width;
	private static int height;
	private static int mapCode[][];
	
	public Map(final int x, final int y, final int[][] map) {
		this.width = x;
		this.height = y;
		this.mapCode = map;
	}
	
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		Map.id = id;
	}
	public static int getWidth() {
		return width;
	}
	public static void setWidth(int width) {
		Map.width = width;
	}
	public static int getHeight() {
		return height;
	}
	public static void setHeight(int height) {
		Map.height = height;
	}
	public static int[][] getMapCode() {
		return mapCode;
	}
	public static void setMapCode(int mapCode[][]) {
		Map.mapCode = mapCode;
	}
	
}
