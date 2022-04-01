package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ConexaoDAO {
	
	public Connection conectaBD() {
		Connection conn = null;
		
		try {
			String url = "jdbc:sqlserver://fluffydomrock.database.windows.net:1433;database=API_Dom_Rock;user=fluffydomrock@fluffydomrock;password=Fluffyapi123;";
			conn = DriverManager.getConnection(url);
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "ConexaoDao" + erro.getMessage());

		}
		return conn;
		
	}

}