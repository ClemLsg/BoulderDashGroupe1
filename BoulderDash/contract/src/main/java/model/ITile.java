package model;

public interface ITile {
	
	//public boolean getIsSolid();

	//public boolean getIsBreakable();
	
	int getId();
	
	ITile[][] getTile();
	
	boolean isBreak();
	
	void setBreak(boolean isBreak);
	
	boolean getIsSolid();
	
	boolean getIsBreakable();

}
