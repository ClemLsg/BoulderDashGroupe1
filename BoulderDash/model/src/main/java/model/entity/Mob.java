package model.entity;

public class Mob extends Alive{
	public void kill(Player player){
		player.setAlive(false);
	}
}
