package view;

import java.sql.SQLException;
import java.util.Observable;
import java.util.Observer;

import view.EventPerformer;
import view.gameframe.GameFrame;
import view.gameframe.GamePanel;

import javax.swing.JOptionPane;

import controller.IController;
import controller.IOrderPerformer;
import model.IModel;

public class BoulderDashView implements IView, Runnable{
	
	private EventPerformer eventPerformer;
	private GraphicsBuilder graphicsBuilder;
	private IController boulderDashController;
	private IModel boulderDashModel;
	
	public BoulderDashView(IController boulderDashController, IModel boulderDashModel) throws SQLException{
		this.boulderDashController= boulderDashController;
		this.boulderDashModel = boulderDashModel;
		EventPerformer eventPerformer = new EventPerformer(boulderDashController);
		//JOptionPane.showMessageDialog(null, "test de méthode");
		
		graphicsBuilder = new GraphicsBuilder(boulderDashModel);
		GameFrame frame = new GameFrame("Boulder Dash", boulderDashModel.getMapXsize(1)*32,(boulderDashModel.getMapYsize(1)+1)*32, eventPerformer, graphicsBuilder, boulderDashModel);
		
	}
	
	public void run(){
		
	}
	
	/**
	 * Display a message
	 * @param message
	 * 		the message you want to display
	 * @return void
	 */
	@Override
	public void displayMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
		
	}

	@Override
	public void closeAll() {
		
	}
	
	@Override
	public Observer getObserver(){
		return GameFrame.getObserver();
		
	}
}
