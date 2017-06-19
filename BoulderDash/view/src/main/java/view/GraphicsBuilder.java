package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Observer;

//import view.gameframe.IGraphicsBuilder;

public class GraphicsBuilder /*implements IGraphicsBuilder*/{
	private BufferedImage texture[];
	//private BoulderDashModel boulderDashModel;
	
	public GraphicsBuilder(/*IBoulderDashModel boulderDashModel*/){
		
	}
	
	public void applyModelToGraphics(Graphics graphic, Observer observerImage){
		
	}
	
	public int getGlobalWidth(){
		//return map.getWidth();
		return (Integer) null;
	}
	
	public int getGlobalHeight(){
		//return map.getWidth();
		return (Integer) null;
	}
	
	public void drawAlive(/*IAlive alive, Graphics graphic, ImageObserver observer*/){
		graphic.drawImage(Alive.dessin,x,y,observer);
	}
	
	public void drawBlock(/*IBlock block, Graphics graphic, ImageObserver observer*/){
		graphic.drawImage(Block.dessin, x ,y , observer);
	}
	
	public void drawBackground(/*ITile tile*/){
		graphic.drawImage(Tile.dessin, x ,y , observer);
	}
}
