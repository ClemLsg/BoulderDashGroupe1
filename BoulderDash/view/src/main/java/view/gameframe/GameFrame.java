package view.gameframe;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.IModel;
import view.GraphicsBuilder;

public class GameFrame extends JFrame implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IEventPerformer eventPerformer; 
	private boolean[] keys;
	private static GamePanel gamePanel;
	
	private JFrame frame;
	private GraphicsBuilder graphicsBuilder;
	public GameFrame(String title, int width, int height, IEventPerformer performer, GraphicsBuilder graphicBuilder, IModel boulderDashModel){
		keys = new boolean[256];
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.addKeyListener(this);
		this.graphicsBuilder = graphicBuilder;
		this.eventPerformer = performer;
		gamePanel = new GamePanel(graphicsBuilder, boulderDashModel);
		//gamePanel.setBackground(Color.BLUE);
		gamePanel.setDoubleBuffered(true);
		frame.setContentPane(gamePanel);
		//JPanel pan = new JPanel();

	  
	    //pan.setBackground(Color.GREEN);      

	    //frame.setContentPane(pan);          
		frame.setVisible(true);
	}
	
	@Override
	public void keyPressed(KeyEvent k) {
		try {
			this.eventPerformer.eventPerform(k);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent k) {
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public static Observer getObserver() {
		// TODO Auto-generated method stub
		return gamePanel;
	}

}
