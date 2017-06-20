package view;

import java.util.Observable;
import view.EventPerformer;
import view.gameframe.GameFrame;

import javax.swing.JOptionPane;

public class BoulderDashView /*implements IView, Runnable*/{
	
	private EventPerformer eventPerformer;
	private GraphicsBuilder graphicsBuilder;
	
	public BoulderDashView(/*IOrderPerformer orderPerformer, IBoulderDashModel boulderDashModel, Observable observable*/){
		EventPerformer eventPerformer = new EventPerformer(/*orderPerformer*/);
		JOptionPane.showMessageDialog(null, "test de méthode");
		GameFrame frame = new GameFrame("test", 640,480);
		graphicsBuilder = new GraphicsBuilder(/*boulderDashModel*/);
	}
	
	public void run(){
		
	}

	/*@Override
	public void closeAll() {
		// TODO Auto-generated method stub
		
	}

	@Override*/
	public void displayMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
		
	}
}
