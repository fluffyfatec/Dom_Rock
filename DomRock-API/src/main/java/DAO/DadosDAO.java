package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import DTO.ClienteDTO;

public class DadosDAO {
	Connection conn;
	PreparedStatement stm;

	
	public void cadastarDados(ClienteDTO objClienteDTO){
		String sql = "INSERT INTO Cliente_Produto (dado_min) values (?)";
		try(Connection conn = new ConexaoDAO().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
			
			stm.setString(1, objClienteDTO.getDadosMin());
		
			stm.execute();	
			stm.close();
			
		}catch (SQLException e) {
			
			throw new RuntimeException(e);
		}
	}
}

