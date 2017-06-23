package model.entity;

import java.util.Random;

import model.IAlive;
import model.IBlock;
import model.IModel;
import model.ITile;

public class Mob1 extends Mob {
	
	public Mob1(int id){
		super(id);
		this.setAlive(true);
	}
	 public void givePoints(Player player){
		 int points = player.getScore();
		 player.setScore(points + 1);
	 }
	 
	 @Override
	public void moveMobs(int xMax, int yMax, IModel boulderDashModel){
		 
		}
	 
}
