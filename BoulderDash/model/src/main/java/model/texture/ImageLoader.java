package model.texture;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
//import javax.imageio.ImageIO;
import javax.imageio.ImageIO;




public class ImageLoader {
	private static Image img;
	public static BufferedImage loadImage(String path){
		/*try {
			return ImageIO.read(ImageLoader.class.getResource(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}*/
		
		try {
		      return (BufferedImage) (img = ImageIO.read(new File(path)));
		      //g.drawImage(img, 0, 0, this);
		      //Pour une image de fond
		      //g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		    } catch (IOException e) {
		      e.printStackTrace();
		      System.exit(1);
		    }                
		return null;
	}
}
