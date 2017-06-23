package model.entity;

import model.IAlive;
import model.IBlock;
import model.IModel;
import model.ITile;

public class Mob extends Alive implements IAlive{
	
	public Mob(int id) {
		super(id);
	}

	public void kill(Player player){
		player.setAlive(false);
	}
	
	@Override
	public void moveMobs(int xMax, int yMax, IModel boulderDashModel){
		
	}
	
}
