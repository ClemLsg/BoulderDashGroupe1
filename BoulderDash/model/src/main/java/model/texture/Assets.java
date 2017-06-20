package model.texture;

import java.awt.image.BufferedImage;

import game.model.ImageLoader;

public class Assets {
	private static final int width = 16, height =16;
	public static BufferedImage haut, bas, gauche, droite, buisson, sol_1, sol_2, sol_3;
	
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/Zelda.png"));
		
		haut = sheet.crop(2*width, 0, width, height);
		bas = sheet.crop(0, 0, 24, 31);
		gauche = sheet.crop(width, 0, width, height);
		droite = sheet.crop(3*width, 0, width, height);
		
		SpriteSheet envi = new SpriteSheet(ImageLoader.loadImage("/textures/LOZ.png"));
		
		buisson = envi.crop(2*width, 0, width, height);
		sol_1 = envi.crop(4*width, 0, width, height);
		sol_2 = envi.crop(4*width, 2*height, width, height);
		sol_3 = envi.crop(4*width, 3*height, width, height);
		
	}
}
