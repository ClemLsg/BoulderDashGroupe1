package view;

import java.sql.SQLException;
import java.util.Observable;
import view.EventPerformer;
import view.gameframe.GameFrame;

import javax.swing.JOptionPane;

import controller.IController;
import model.IModel;

public class BoulderDashView implements IView, Runnable{
	
	private EventPerformer eventPerformer;
	private GraphicsBuilder graphicsBuilder;
	private IController boulderDashController;
	private IModel boulderDashModel;
	
	public BoulderDashView(IController boulderDashController, IModel boulderDashModel, Observable observable) throws SQLException{
		this.boulderDashController= boulderDashController;
		this.boulderDashModel = boulderDashModel;
		EventPerformer eventPerformer = new EventPerformer(boulderDashController);
		//JOptionPane.showMessageDialog(null, "test de méthode");
		
		graphicsBuilder = new GraphicsBuilder(boulderDashModel);
		GameFrame frame = new GameFrame("test", 640,480, eventPerformer, graphicsBuilder);
	}
	
	public void run(){
		
	}

	@Override
	public void displayMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
		
	}

	@Override
	public void closeAll() {
		// TODO Auto-generated method stub
		
	}
}
