package model;

public interface IMap {
	public int getId();
	public void setId(int id);
	public int getWidth();
	public void setWidth(int width);
	public int getHeight();
	public void setHeight(int height);
	public int[][] getMapCode();
	public void setMapCode(int mapCode[][]);
	
}
