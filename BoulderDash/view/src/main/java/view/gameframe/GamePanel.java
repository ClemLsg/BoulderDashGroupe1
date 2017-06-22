package view.gameframe;

import java.awt.Color;
import java.awt.Graphics;
import java.sql.SQLException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.IModel;
import view.gameframe.IGraphicsBuilder;

public class GamePanel extends JPanel implements Observer{
	private static final long serialVersionUID = -4968076450158743017L;
	private final IGraphicsBuilder graphicsBuilder;
		
	public GamePanel(IGraphicsBuilder graphicsBuilder, IModel boulderDashModel){
		this.graphicsBuilder = graphicsBuilder;
		this.setDoubleBuffered(true);
		System.out.println("Game Panel");
		//obs = new ImageObserver();
		//Graphics graphic = null;
		this.setBackground(Color.GREEN);
		boulderDashModel.setObserver(this);
		//paintComponent(this.getGraphics());
		
	}

	public void perfom(){
		this.validate();
		this.repaint();
	}
	@Override
	public void update(Observable observable, Object obj) {
		this.validate();
		this.repaint();
		
	}
	
	public void paintComponent(Graphics graphic){
		System.out.println("paint");
		System.out.println(graphic);
		
			try {
				this.graphicsBuilder.applyModelToGraphics(graphic, this);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
