package model.entity;

import model.IAlive;
import model.IBlock;
import model.IModel;
import model.ITile;

public class Mob2 extends Mob {
	public Mob2(int id){
		super(id);
		this.setAlive(true);
	}
	 public void giveDiamonds(Player player){
		 int amountDiamonds = player.getAmountDiamonds();
		 player.setAmountDiamonds(amountDiamonds + 1);
	 }
	 
	 @Override
		public void moveMobs(int xMax, int yMax, IModel boulderDashModel){
		}
}
