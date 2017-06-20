package model.entity;

public class Mob1 extends Mob {
	public Mob1(int id){
		this.setAlive(true);
	}
	 public void givePoints(Player player){
		 int points = player.getScore();
		 player.setScore(points + 1);
	 }
}
