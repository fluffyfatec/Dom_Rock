package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

import javax.swing.JOptionPane;
import DTO.ClienteDTO;

public class ClienteDAO {

	Connection conn;
	PreparedStatement pstm;

	public void cadastarCliente(ClienteDTO objClienteDTO) {

		/*String sql = "insert into Cliente (razao_social,cnpj,"
+ " objetivo_negocio, entregavel_min, entregavel_possivel, datahoracadastro) values (?,?,?,?,?,?)";*/

		conn = new ConexaoDAO().conectaBD();

		try {

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, objClienteDTO.getNomeCliente());
			pstm.setString(2, objClienteDTO.getCnpj());
		  /*pstm.setString(3, objClienteDTO.getObjetivoNegocio());
			pstm.setString(4, objClienteDTO.getEntregaMin());
			pstm.setString(5, objClienteDTO.getEntregaPossivel());
	   	 	//Cadastrando Horario
			Date date = new Date();
	   	 	Object param = new java.sql.Timestamp(date.getTime());
	   	 	pstm.setDate(6, (java.sql.Date) param);*/
	   	 	
	   	 	
			pstm.execute();
			pstm.close();

		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "ClienteDAO" + erro);
		}
	}
}
