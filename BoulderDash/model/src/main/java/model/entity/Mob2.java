package model.entity;

public class Mob2 extends Mob {
	public Mob2(int id){
		super(id);
		this.setAlive(true);
	}
	 public void giveDiamonds(Player player){
		 int amountDiamonds = player.getAmountDiamonds();
		 player.setAmountDiamonds(amountDiamonds + 1);
	 }
}
