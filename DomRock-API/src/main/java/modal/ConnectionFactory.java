package modal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection conectaBD() throws SQLException {
		
        String connectionUrl = "jdbc:sqlserver://fluffydomrock.database.windows.net:1433;databaseName=API_Dom_Rock;user=fluffydomrock;password=Fluffyapi123";


        Connection con = DriverManager.getConnection(connectionUrl);

        return con;
        }
	}





