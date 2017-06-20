package view.gameframe;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import jpu2016.gameframe.IGraphicsBuilder;
import view.GraphicsBuilder;

public class GamePanel extends JPanel implements Observer{
	private Observable observable;
	private final GraphicsBuilder graphicsBuilder;
		
	public GamePanel(GraphicsBuilder graphicsBuilder){
		this.graphicsBuilder = graphicsBuilder;
		this.setDoubleBuffered(true);
	}
	
	@Override
	public void update(Observable observable, Object obj) {
		// TODO Auto-generated method stub
		
	}
	
	public void paintComponent(Graphics graphic){
		this.graphicsBuilder.applyModelToGraphic(graphic, this);
	}

}
