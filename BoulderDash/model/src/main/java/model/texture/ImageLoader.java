package model.texture;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;




public class ImageLoader {
	
	/**
	 * Cut a part of an image
	 */
	public static BufferedImage loadImage(String path){	
		try {
		      return (BufferedImage) (ImageIO.read(new File(path)));
		    } catch (IOException e) {
		      e.printStackTrace();
		      System.exit(1);
		    }                
		return null;
	}
}
