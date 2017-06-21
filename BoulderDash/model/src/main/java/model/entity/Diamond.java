package model.entity;

public class Diamond extends Block{
	private int id;

	public Diamond(int id){
		this.setId(id);
	}
	
	@Override
	public Direction getDirection() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean isPickable(){
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
