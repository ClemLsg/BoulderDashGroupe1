package controller;

import java.sql.SQLException;

public interface IOrderPerformer {
	
	public void orderPerform(IUserOrder userOrder) throws SQLException;
	}
