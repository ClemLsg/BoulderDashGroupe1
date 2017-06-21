package view.gameframe;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

import view.GraphicsBuilder;

public class GameFrame extends JFrame implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IEventPerformer eventPerformer; 
	private boolean[] keys;
	
	private JFrame frame;
	private GraphicsBuilder graphicsBuilder;
	public GameFrame(String title, int width, int height, IEventPerformer performer, GraphicsBuilder graphicBuilder){
		keys = new boolean[256];
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		this.graphicsBuilder = graphicBuilder;
		final GamePanel gamePanel = new GamePanel(graphicsBuilder);
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
		keys[k.getKeyCode()] = true;
		
	}

	@Override
	public void keyReleased(KeyEvent k) {
		keys[k.getKeyCode()] = false;
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
