package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.IBlock;
import model.IAlive;
import model.IModel;
import model.ITile;
import view.gameframe.GameFrame;
import view.gameframe.IGraphicsBuilder;



public class GraphicsBuilder implements IGraphicsBuilder, ImageObserver{
	private BufferedImage texture[];
	private IModel boulderDashModel;
	int count = 0;
	
	public GraphicsBuilder(IModel boulderDashModel) throws SQLException{
		this.boulderDashModel = boulderDashModel;
		
		texture = boulderDashModel.getSpriteTab();
	}
	
	/**
	 * Return the width of the map
	 * @return void
	 */
	public void getGlobalWidth(){
		//return map.getWidth();
		return;
	}
	
	/**
	 * Return the height of the map
	 * @return void
	 */
	public void getGlobalHeight(){
		//return map.getWidth();
		return;
	}
	
	/**
	 * Perform an event
	 * @param graphic, observerImage, x, y, index
	 * 		the graphic library you want to use, the class to print image, the position x of the image, the position y of the image, the index of the texture
	 * @return void
	 */
	public void drawTexture(Graphics graphic, ImageObserver observerImage, int x, int y, int index){
		graphic.drawImage(texture[index],x,y,32,32,this);
	}
	
	/**
	 * Our map drawer
	 * @param graphic, observerImage
	 * 		the graphic library you want to use, the class to print image
	 * @return draw the map
	 * @throws SQLException
	 */
	@Override
	public void applyModelToGraphics(Graphics graphic, ImageObserver observerImage) throws SQLException {
		int x = boulderDashModel.getMapXsize(1);
		int y = boulderDashModel.getMapYsize(1);
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
		if(boulderDashModel.isAlive() == false){
			count ++;
			if(count == 2){
				JOptionPane.showMessageDialog(null, "Game Over !");
				System.exit(0);
			}
		}
		if(boulderDashModel.isHasWon() == true){
			JOptionPane.showMessageDialog(null, "You Won victory is yours ! ;)");
			System.exit(0);
		}
		
	}
	
	/**
	 * Update the screen
	 * @param img, infoflags, x, y, width, height
	 * 		the image we want to update, the flags, position x, position y, width of the image, height of the image
	 * @return a new Map
	 */
	@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		return false;
	}


	
	
}
