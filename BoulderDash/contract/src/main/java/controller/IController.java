package controller;

import java.sql.SQLException;
/**
 * <h1>The Interface IController.</h1>
 * 
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IController {

	void orderPerform(IUserOrder userOrder)  throws SQLException ;
	
	IUserOrder[] getUserOrder();

}
