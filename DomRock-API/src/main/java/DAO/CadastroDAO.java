package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import DTO.CadastroDTO;

public class CadastroDAO {
	
	Connection conn;
	PreparedStatement stm;
	
	public void cadastroCliente(CadastroDTO objcadastroDTO){
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
			
			stm.setString(1, objcadastroDTO.getNomeCliente());
			stm.setString(2, objcadastroDTO.getCnpj());
			stm.setString(3, objcadastroDTO.getNomeSetor());
			stm.setString(4, date);
	   	 	
			stm.execute();	
			stm.close();
			
		}catch (SQLException e) {
			
		}
	}
}
