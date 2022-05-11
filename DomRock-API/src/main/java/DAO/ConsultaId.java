package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DTO.CadastroDTO;

public class ConsultaId {

	public String getSql_id_cliente() {
		return result_id_cliente;
	}

	Connection conn;
	PreparedStatement stm;
	String result_id_cliente;

	public void consultarID(CadastroDTO objCadastroDTO) {
		String sql_id_cliente = "Select id_cliente from Cliente Where cnpj =" + objCadastroDTO.getCnpj();
		try (Connection conn = new ConexaoDAO().conectaBD();
				PreparedStatement stm = conn.prepareStatement(sql_id_cliente);) {

			Statement stm1 = conn.createStatement();
			ResultSet result_id_cliente = stm1.executeQuery(sql_id_cliente);

			stm.execute();
			stm.close();

		} catch (SQLException e) {

			throw new RuntimeException(e);
		}

	}
}
