package view.gameframe;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import view.GraphicsBuilder;

public class GamePanel extends JPanel implements Observer{
	private Observable observable;
		
	public GamePanel(GraphicsBuilder graphicsBuilder){
		
	}
	
	@Override
	public void update(Observable observable, Object obj) {
		// TODO Auto-generated method stub
		
	}
	
	public void paintComponent(Graphics graphic){
		
	}

}
