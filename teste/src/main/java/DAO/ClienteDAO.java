package DAO;


import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import DTO.ClienteDTO;
import javafx.collections.ObservableList;

public class ClienteDAO {

	Connection conn;
	PreparedStatement stm;

	
	public void cadastarCliente(ClienteDTO objClienteDTO){
		String sql = "INSERT INTO Cliente (razao_social,"
										+ "cnpj,"	
										+ "segmento,"
										+ "datahora_cadastro) "
					+ "values (?,?,?,?)";
		try(Connection conn = new ConexaoDAO().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
			
			// Puxando a data e hora e formatando
			Calendar cal = Calendar.getInstance();  
			java.sql.Timestamp timestamp = new java.sql.Timestamp(cal.getTimeInMillis());
			String date = new SimpleDateFormat("MM/dd/yyyy HH:mm").format(timestamp);
			
			stm.setString(1, objClienteDTO.getNomeCliente());
			stm.setString(2, objClienteDTO.getCnpj());
			stm.setString(3, objClienteDTO.getNomeSetor());
			stm.setString(4, date);

	   	 	
			stm.execute();	
			stm.close();
			
		}catch (SQLException e) {
			
			throw new RuntimeException(e);
		}

	}
}
