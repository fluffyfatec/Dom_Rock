package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import DTO.ClienteDTO;

public class ClienteDAO {

	Connection conn;
	PreparedStatement stm;

	
	public void cadastarCliente(ClienteDTO objClienteDTO){
		String sql = "INSERT INTO Cliente (objetivo_negocio,"
										+ "entregavel_min,"
										+ "entregavel_possivel,"
										+ "datahora_cadastro,"
										+ "datahora_atualizacao) "
					+ "values (?,?,?,?,?,?,?,?)";
		try(Connection conn = new ConexaoDAO().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
			
			// Puxando a data e hora e formatando
			Calendar cal = Calendar.getInstance();  
			java.sql.Timestamp timestamp = new java.sql.Timestamp(cal.getTimeInMillis());
			String date = new SimpleDateFormat("MM/dd/yyyy HH:mm").format(timestamp);
			
			stm.setString(1, objClienteDTO.getObjetivoNegocio());
			stm.setString(2, objClienteDTO.getEntregaMin());
			stm.setString(3, objClienteDTO.getEntregaPossivel());
			stm.setString(4, date);
			stm.setString(5, date);
	   	 	
			stm.execute();	
			stm.close();
			
		}catch (SQLException e) {
			

		}
	}
}
