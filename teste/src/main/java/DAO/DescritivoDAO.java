package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import DTO.ClienteDTO;

public class DescritivoDAO {
	Connection conn;
	PreparedStatement stm;

	
	public void cadastrarDescritivo(ClienteDTO objClienteDTO){
		String sql = "INSERT INTO Descritivo (objetivo_negocio," + "entregavel_min," + "entregavel_possivel, id_cliente)" + "values (?,?,?,2)";
		try(Connection conn = new ConexaoDAO().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
			

			stm.setString(1, objClienteDTO.getObjetivoNegocio());
			stm.setString(2, objClienteDTO.getEntregaMin());
			stm.setString(3, objClienteDTO.getEntregaPossivel());
	   	 	
			stm.execute();	
			stm.close();
			
		}catch (SQLException e) {
			
			throw new RuntimeException(e);
		}

	
	}	
}

