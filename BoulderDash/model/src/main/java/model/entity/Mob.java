package model.entity;

public class Mob extends Alive{
	public Mob(int id) {
		super(id);
	}

	public void kill(Player player){
		player.setAlive(false);
	}
}
