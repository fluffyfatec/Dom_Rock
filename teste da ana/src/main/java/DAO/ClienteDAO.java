package DAO;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import DTO.ClienteDTO;

public class ClienteDAO {

	Connection conn;
	PreparedStatement stm;

	
	public void cadastarCliente(ClienteDTO objClienteDTO){
		String sql = "INSERT INTO Cliente (razao_social,cnpj,objetivo_negocio,entregavel_min,entregavel_possivel) values (?,?,?,?,?)";
		try(Connection conn = new ConexaoDAO().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
			
	   	 	
			stm.setString(1, objClienteDTO.getNomeCliente());
			stm.setString(2, objClienteDTO.getCnpj());
			stm.setString(3, objClienteDTO.getObjetivoNegocio());
			stm.setString(4, objClienteDTO.getEntregaMin());
			stm.setString(5, objClienteDTO.getEntregaPossivel());
	   	 	
			stm.execute();	
			stm.close();
			
		}catch (SQLException e) {
			
			throw new RuntimeException(e);
		}
	}
}
