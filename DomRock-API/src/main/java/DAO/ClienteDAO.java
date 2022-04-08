package DAO;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.JOptionPane;
import DTO.ClienteDTO;

public class ClienteDAO {

	Connection conn;
	PreparedStatement stm;

	
	public void cadastarCliente(ClienteDTO objClienteDTO) {

		//String sql = "insert into Cliente (razao_social,cnpj) values (?,?)";

		conn = new ConexaoDAO().conectaBD();

		try {

			String SQL = "insert into Cliente (razao_social,cnpj) values (?,?)";
			
			stm = conn.prepareStatement(SQL);
			stm.setString(1, objClienteDTO.getNomeCliente());
			stm.setString(2, objClienteDTO.getCnpj());
		  /*pstm.setString(3, objClienteDTO.getObjetivoNegocio());
			pstm.setString(4, objClienteDTO.getEntregaMin());
			pstm.setString(5, objClienteDTO.getEntregaPossivel());
	   	 	//Cadastrando Horario
			Date date = new Date();
	   	 	Object param = new java.sql.Timestamp(date.getTime());
	   	 	pstm.setDate(6, (java.sql.Date) param);*/
	   	 	
			ResultSet rs = stm.executeQuery(SQL);

		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "ClienteDAO" + erro);
		}
	}
}
