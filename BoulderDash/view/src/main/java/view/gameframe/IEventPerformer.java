package view.gameframe;

import java.awt.event.KeyEvent;
import java.sql.SQLException;



public interface IEventPerformer {
	
	public void eventPerform(KeyEvent keyCode) throws SQLException;
	
}
