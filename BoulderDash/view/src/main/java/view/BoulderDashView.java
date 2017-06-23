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
		
		
		graphicsBuilder = new GraphicsBuilder(boulderDashModel);
		GameFrame frame = new GameFrame("test", 640,480, eventPerformer, graphicsBuilder, boulderDashModel);
	}
	
	public void run(){
		
	}

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
