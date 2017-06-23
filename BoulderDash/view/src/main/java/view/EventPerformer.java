package view;

import java.awt.event.KeyEvent;
import java.sql.SQLException;

import controller.IController;
import controller.IUserOrder;
import view.gameframe.IEventPerformer;

class EventPerformer implements IEventPerformer {
	private final IController boulderDashController;

	public EventPerformer(final IController boulderDashController) {
		this.boulderDashController = boulderDashController;
	}
	
	/**
	 * Perform an event
	 * @param keyCode
	 * 		the code of the key your just press
	 * @return void
	 */
	@Override
	public void eventPerform(final KeyEvent keyCode) throws SQLException {
		final IUserOrder userOrder = this.keyCodeToUserOrder(keyCode.getKeyCode());
		if (userOrder != null) {
			//System.out.println(userOrder);
			this.boulderDashController.orderPerform(userOrder);
		}
	}
	
	/**
	 * Gets the User Order and adds the code
	 * @param keyCode
	 * 		the code of the key your just press
	 * @return void
	 */
	private IUserOrder keyCodeToUserOrder(final int keyCode) {
		IUserOrder[] userOrder = boulderDashController.getUserOrder();
		
		switch (keyCode) {
			case KeyEvent.VK_UP:
				return userOrder[0];
			case KeyEvent.VK_RIGHT:
				return userOrder[1];
			case KeyEvent.VK_DOWN:
				return userOrder[3];
			case KeyEvent.VK_LEFT:
				return userOrder[2];
		}
		return null;
	}
}
