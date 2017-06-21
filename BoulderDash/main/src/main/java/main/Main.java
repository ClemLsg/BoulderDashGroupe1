package main;

import java.sql.SQLException;

import model.Map;
import model.dao.MapDAO;

public abstract class Main {

    public static void main(final String[] args) {
        Map test = null;

        try {
            test = MapDAO.createMap(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for(int j = 0; j < test.getHeight(); j++) {
            for(int i = 0; i < test.getWidth(); i++) {
                System.out.print(test.getMap()[j][i]);
            }
            System.out.println("");
        }

    }

}