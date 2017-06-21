package view.gameframe;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.sql.SQLException;
import java.util.Observer;

public interface IGraphicsBuilder {
	
	public void getGlobalWidth();
	public void getGlobalHeight();
	public void applyModelToGraphics(Graphics graphic, ImageObserver observerImage) throws SQLException ;
	
}
