package main;

import java.sql.SQLException;

import controller.BoulderDashController;
import view.BoulderDashView;

import controller.IController;
import model.BoulderDashModel;
import model.IModel;
import model.dao.MapDAO;
import view.IView;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Groupe 1
 * @version 1.0
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     * @throws SQLException 
     */
    public static void main(final String[] args) throws SQLException {
    	IModel boulderDashModel = new BoulderDashModel(3);
    	IController boulderDashController = new  BoulderDashController(boulderDashModel);
    	IView boulderDashView = new BoulderDashView(boulderDashController, boulderDashModel, null);
    	

       
    }

}
