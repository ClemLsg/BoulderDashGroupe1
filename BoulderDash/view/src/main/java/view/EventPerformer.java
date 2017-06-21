package view;

import java.awt.event.KeyEvent;

import controller.IController;

//import controller.IOrderPerformer;
import view.gameframe.IEventPerformer;

public class EventPerformer implements IEventPerformer{
	//private final IOrderPerformer orderPerformer;

	public EventPerformer(IController boulderDashController) {
		//this.orderPerformer = orderPerformer;
	}
	
	public void eventPerform(KeyEvent keyCode){
		/*IUserOrder userOrder;
		switch (keyCode) {
			case KeyEvent.VK_UP:
				userOrder = new UserOrder(Order.UP);
				break;
			case KeyEvent.VK_RIGHT:
				userOrder = new UserOrder(Order.RIGHT);
				break;
			case KeyEvent.VK_DOWN:
				userOrder = new UserOrder(Order.DOWN);
				break;
			case KeyEvent.VK_LEFT:
				userOrder = new UserOrder(Order.LEFT);
				break;
			default:
				userOrder = null;
		}
		return userOrder;*/
	}
}
