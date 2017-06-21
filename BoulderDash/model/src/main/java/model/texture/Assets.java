package model.texture;

import java.awt.image.BufferedImage;

public class Assets {
	private static final int width = 16, height =16;
	public static BufferedImage haut, bas, gauche, droite, background, mud, wall, rock, diamond, door, mob1, mob2;
	private static BufferedImage spriteTab[] = new BufferedImage[8];
	
	public Assets(){
		init(1);
	}
	public static void init(int idSkin){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("C:\\Users\\Darkdady\\Documents\\Git\\BoulderDashGroupe1\\BoulderDash\\main\\src\\main\\resources\\player.png"));
		haut = sheet.crop(2*width, 5*height, width, height);
		bas = sheet.crop(0, 5*height, width, height);
		gauche = sheet.crop(3*width, 5*height, width, height);
		droite = sheet.crop(width, 5*height, width, height);
		
		SpriteSheet envi = new SpriteSheet(ImageLoader.loadImage("C:\\Users\\Darkdady\\Documents\\Git\\BoulderDashGroupe1\\BoulderDash\\main\\src\\main\\resources\\block.png"));
		
		background = envi.crop(2*width, (idSkin-1)*4*height, width, height);
		mud = envi.crop(width, (idSkin-1)*4*height, width, height);
		wall = envi.crop(0, (idSkin-1)*4*height, width, height);
		door = envi.crop(6*width, (idSkin-1)*4*height, width, height);
		rock = envi.crop(3*width, (idSkin-1)*4*height, width, height);
		diamond = envi.crop(4*width, (idSkin-1)*4*height, width, height);
		mob1 = envi.crop(9*width, (idSkin-1)*4*height, width, height);
		mob2 = envi.crop(10*width, (idSkin-1)*4*height, width, height);
		
		spriteTab[0]=background;
		spriteTab[1]=door;
		spriteTab[2]=mud;
		spriteTab[3]=mob1;
		spriteTab[4]=wall;
		spriteTab[5]=rock;
		spriteTab[6]=diamond;
		spriteTab[7]=bas;
		
	}

	public static BufferedImage[] getSpriteTab() {
		return spriteTab;
	}
	
	
}
