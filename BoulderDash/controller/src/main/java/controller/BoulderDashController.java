package controller;


import java.sql.SQLException;
import java.util.ArrayList;

import model.Direction;
import model.IAlive;
import model.IModel;
import view.IView;
import view.IViewSystem;

public class BoulderDashController implements IOrderPerformer, IController{
	private IModel boulderDashModel;
	private IViewSystem	viewSystem;
	private IUserOrder userOrder[] = new IUserOrder[4];
	
	public BoulderDashController(IModel boulderDashModel){
		this.boulderDashModel = boulderDashModel;
		userOrder[0] = new UserOrder(Order.UP);
		userOrder[1] = new UserOrder(Order.RIGHT);
		userOrder[2] = new UserOrder(Order.LEFT);
		userOrder[3] = new UserOrder(Order.DOWN);
	}
	
	@Override
	public void orderPerform(IUserOrder userOrder) throws SQLException {
		Direction direction;
		switch (userOrder.getOrder()) {
		case UP:
			direction = Direction.UP;
			break;
		case RIGHT:
			direction = Direction.RIGHT;
			break;
		case DOWN:
			direction = Direction.DOWN;
			break;
		case LEFT:
			direction = Direction.LEFT;
			break;
		default:
			direction = null;
		}
		System.out.println(direction);
		int x = boulderDashModel.getMapXsize(1);
		int y = boulderDashModel.getMapYsize(1);
		boulderDashModel.setDirection(direction);
		boulderDashModel.move(direction ,x,  y,boulderDashModel);
	}


	@Override
	public void play() {
		this.gameLoop();
		//this.viewSystem.displayMessage("Game Over !");
		//this.viewSystem.closeAll();
		
	}
	
	private void gameLoop() {
		while (boulderDashModel.isAlive() == true) {
			try {
				Thread.sleep(30);
			} catch (final InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
			
			//boulderDashModel.setMoved();
	}
	}
	
	/*public synchronized void setViewSystem(final IViewSystem viewSystem) {
			this.viewSystem = viewSystem;
		}*/

	@Override
	public synchronized void setViewSystem(IView boulderDashView) {
		this.viewSystem = viewSystem;
		
	}
	
	@Override
	public IUserOrder[] getUserOrder() {
		return userOrder;
	}
}
