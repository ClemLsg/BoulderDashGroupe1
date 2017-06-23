package view;

import java.sql.SQLException;
import java.util.Observer;
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
	private GameFrame frame;
	
	public BoulderDashView(IController boulderDashController, IModel boulderDashModel) throws SQLException{
		this.setBoulderDashController(boulderDashController);
		this.setBoulderDashModel(boulderDashModel);
		EventPerformer eventPerformer = new EventPerformer(boulderDashController);
		graphicsBuilder = new GraphicsBuilder(boulderDashModel);
		setFrame(new GameFrame("Boulder Dash", boulderDashModel.getMapXsize(boulderDashModel.getIdMap())*32,(boulderDashModel.getMapYsize(boulderDashModel.getIdMap())+1)*32, eventPerformer, graphicsBuilder, boulderDashModel));
		
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

	public EventPerformer getEventPerformer() {
		return eventPerformer;
	}

	public void setEventPerformer(EventPerformer eventPerformer) {
		this.eventPerformer = eventPerformer;
	}

	public IController getBoulderDashController() {
		return boulderDashController;
	}

	public void setBoulderDashController(IController boulderDashController) {
		this.boulderDashController = boulderDashController;
	}

	public IModel getBoulderDashModel() {
		return boulderDashModel;
	}

	public void setBoulderDashModel(IModel boulderDashModel) {
		this.boulderDashModel = boulderDashModel;
	}

	public GameFrame getFrame() {
		return frame;
	}

	public void setFrame(GameFrame frame) {
		this.frame = frame;
	}
}
