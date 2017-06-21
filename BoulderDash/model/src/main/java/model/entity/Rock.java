package model.entity;

public class Rock extends Block{
	private int id;

	public  Rock(int id){
		this.setId(id);
	}

	@Override
	public Direction getDirection() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}


