package model.texture;

import java.awt.image.BufferedImage;

public class Assets {
	private static final int width = 16, height =16;
	public static BufferedImage haut, bas, gauche, droite, background, mud, wall, rock, diamond, door, mob1Haut, mob1Bas, mob1Gauche, mob1Droite, mob2Haut, mob2Bas, mob2Gauche, mob2Droite;
	private BufferedImage spriteTab[];
	
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage(""));
		
		haut = sheet.crop(2*width, 0, width, height);
		bas = sheet.crop(0, 0, 24, 31);
		gauche = sheet.crop(width, 0, width, height);
		droite = sheet.crop(3*width, 0, width, height);
		
		SpriteSheet envi = new SpriteSheet(ImageLoader.loadImage(""));
		
		background = envi.crop(2*width, 0, width, height);
		mud = envi.crop(4*width, 0, width, height);
		wall = envi.crop(4*width, 2*height, width, height);
		rock = envi.crop(4*width, 3*height, width, height);
		
	}
}
