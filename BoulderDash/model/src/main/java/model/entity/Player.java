package model.entity;

public class Player extends Alive{
	public int score;
	public int amountDiamonds;
	public Player(int id){
		super(id);
		this.setAlive(true);
	}
	
	public void dig(Direction direction){
		
	}
	
	public void push(Direction direction){
		
	}
	
	public void pickUp(){
		
	}
	
	public void leave(){
		
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getAmountDiamonds() {
		return amountDiamonds;
	}

	public void setAmountDiamonds(int amountDiamonds) {
		this.amountDiamonds = amountDiamonds;
	}
}
