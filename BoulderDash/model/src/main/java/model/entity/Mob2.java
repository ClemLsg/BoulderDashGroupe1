package model.entity;

import model.IModel;


public class Mob2 extends Mob {
	public Mob2(int id){
		super(id);
		this.setAlive(true);
	}
	/**
	 * Give diamond to a player
	 * @param player
	 * The player that we want to give diamond
	 */
	 public void giveDiamonds(Player player){
		 int amountDiamonds = player.getAmountDiamonds();
		 player.setAmountDiamonds(amountDiamonds + 1);
	 }
	 
	 @Override
		public void moveMobs(int xMax, int yMax, IModel boulderDashModel){
		}
}
