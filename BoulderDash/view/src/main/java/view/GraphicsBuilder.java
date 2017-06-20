package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Observer;

import model.IModel;
import view.gameframe.IGraphicsBuilder;



public class GraphicsBuilder implements IGraphicsBuilder{
	private BufferedImage texture[];
	private IModel boulderDashModel;
	
	public GraphicsBuilder(IModel boulderDashModel){
		
	}
	
	public void applyModelToGraphics(Graphics graphic, Observer observerImage){
		
	}
	
	public void getGlobalWidth(){
		//return map.getWidth();
		return;
	}
	
	public void getGlobalHeight(){
		//return map.getWidth();
		return;
	}
	
	public void drawAlive(Assets asset[][], Graphics graphic, ImageObserver observer, int x, int y){
		graphic.drawImage(asset[][],x,y,observer);
	}
	
	public void drawBlock(IBlock block, Graphics graphic, ImageObserver observer){
		graphic.drawImage(Block.dessin, x ,y , observer);
	}
	
	public void drawBackground(ITile tile){
		graphic.drawImage(Tile.dessin, x ,y , observer);
	}
}
