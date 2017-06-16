package view.gameframe;

import java.awt.Graphics;
import java.util.Observer;

public interface IGraphicsBuilder {
	
	public void getGlobalWidth();
	public void getGlobalHeight();
	public void applyModelToGraphics(Graphics graphic, Observer observerImage);
	
}
