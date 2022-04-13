package DAO;

import java.sql.*;


import DTO.ClienteDTO;
import com.example.view.HelloController;
import javafx.fxml.FXML;

public class DadosDAO {
	Connection conn;
	PreparedStatement stm;


	public void cadastarDados(ClienteDTO objClienteDTO) throws SQLException {

		String sql_id_cliente = "SELECT TOP 1 * FROM Cliente ORDER BY id_cliente DESC;";
		Connection conn1 = new ConexaoDAO().conectaBD();
		Statement stm1 = conn1.createStatement();
		ResultSet result_id_cliente = stm1.executeQuery(sql_id_cliente);
		while (result_id_cliente.next()) {
			int id_cliente = result_id_cliente.getInt("id_cliente");

			String sql = "INSERT INTO Cliente_Produto (cp_id_cliente, dado_min, cp_id_produto) values ("+id_cliente+", ?, 1)";
			try(Connection conn = new ConexaoDAO().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){

				stm.setString(1, objClienteDTO.getDadosMin());

				stm.execute();
				stm.close();

			}catch (SQLException e) {

				throw new RuntimeException(e);
			}
		}

	}
}

