package controller;

import model.IModel;
import view.IView;

public class BoulderDashController implements IOrderPerformer, IController{
	private IModel boulderDashModel;
	public BoulderDashController(IModel boulderDashModel){
		this.boulderDashModel = boulderDashModel;
	}
	
	@Override
	public void orderPerform(UserOrder userOrder) {
		// TODO Auto-generated method stub
		
	}
	
	public void play(){
		
	}
	
	public void setView(IView view){
		
	}
	
	public void tick(){
		
	}
	
}
