package DAO;
import java.sql.*;

/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;*/

public class teste1 {
    public static void main(String[] args) {

        // Create a variable for the connection string.
        String connectionUrl = "jdbc:sqlserver://fluffydomrock.database.windows.net:1433;databaseName=API_Dom_Rock;user=fluffydomrock;password=Fluffyapi123";

        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
            // TESTE DE INSERT NO BANCO
        	//String SQL = "INSERT INTO Cliente(razao_social, cnpj, segmento, objetivo_negocio, entregavel_min, entregavel_possivel, datahora_cadastro, datahora_atualizacao) VALUES ('ITITITIT', 12345678912453, 'Atacado/Varejo', 'Objetivo do Negócio Sim', 'Minimamente entregavel talvez', 'Possivelmente entregarei isso', '06/04/2022', '06/04/2022');";
            
        	String SQL = "";
        	ResultSet rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            //while (rs.next()) {
            //    System.out.println(rs.getString("id_cliente"));
            //}
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}