package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.sql.SQLException;


import model.IModel;
import view.gameframe.IGraphicsBuilder;



public class GraphicsBuilder implements IGraphicsBuilder, ImageObserver{
	private BufferedImage texture[];
	private IModel boulderDashModel;
	
	public GraphicsBuilder(IModel boulderDashModel) throws SQLException{
		this.boulderDashModel = boulderDashModel;
		
		texture = boulderDashModel.getSpriteTab();
	}
	
	public void getGlobalWidth(){
		//return map.getWidth();
		return;
	}
	
	public void getGlobalHeight(){
		//return map.getWidth();
		return;
	}
	
	public void drawTexture(Graphics graphic, ImageObserver observerImage, int x, int y, int index){
		//graphic.fillOval(10, 10, 10, 10);
		graphic.drawImage(texture[index],x,y,32,32,this);
		//graphic.fillOval(10, 10, 10, 10);
		System.out.println(graphic);
	}

	@Override
	public void applyModelToGraphics(Graphics graphic, ImageObserver observerImage) throws SQLException {
		int x = boulderDashModel.getMapXsize(1);
		int y = boulderDashModel.getMapYsize(1);
		/*final BufferedImage imageMobile = new BufferedImage(x, y, Transparency.TRANSLUCENT);
		final Graphics graphicsMobile = imageMobile.getGraphics();*/
		for (int j = 0; j < x; j++){
			for ( int i = 0; i < y; i++){
				//System.out.println(j);
				//System.out.println(i);
				drawTexture(graphic, observerImage, j*32, i*32, 1);
			}
		}
		
	}

	@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
