package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.sql.SQLException;

import model.IBlock;
import model.IAlive;
import model.IModel;
import model.ITile;
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
		graphic.drawImage(texture[index],x,y,32,32,this);
	}

	@Override
	public void applyModelToGraphics(Graphics graphic, ImageObserver observerImage) throws SQLException {
		int x = boulderDashModel.getMapXsize(3);
		int y = boulderDashModel.getMapYsize(3);
		IBlock block[][] = boulderDashModel.getBlock();
		IAlive alive[][] = boulderDashModel.getAlive();
		ITile tile[][] = boulderDashModel.getTile();
		for (int j = 0; j < x; j++){
			for ( int i = 0; i < y; i++){
				drawTexture(graphic, observerImage, j*32, i*32, 0 );
				if(block[j][i] != null){
					int id = block[j][i].getId();
					drawTexture(graphic, observerImage, j*32, i*32, id );
				}
				
				if(tile[j][i] != null && tile[j][i].isBreak() == false){
					int id = tile[j][i].getId();
					drawTexture(graphic, observerImage, j*32, i*32, id );
				}
				
				if(alive[j][i] != null && alive[j][i].isAlive() == true){
					System.out.println("j : " + j + " , i : " + i);
					int id = alive[j][i].getId();
					drawTexture(graphic, observerImage, j*32, i*32, id );
				}
			}
		}
		
	}

	@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		return false;
	}


	
	
}
