package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class teste {

	public Connection conectaBD() {
		
		String url = "jdbc:sqlserver://fluffydomrock.database.windows.net:1433;database=API_Dom_Rock";
		String user = "fluffydomrock";
		String password = "Fluffyapi123";
		
		try {
			
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("deu certo");
			
		} catch (SQLException e) {
			
			System.out.println("deu merda");
		}
		return null;

	}

}
