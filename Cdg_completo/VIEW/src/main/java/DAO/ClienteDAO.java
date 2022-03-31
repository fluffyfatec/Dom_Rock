package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import DTO.ClienteDTO;

public class ClienteDAO {

	Connection conn;
	PreparedStatement pstm;

	public void cadastarCliente(ClienteDTO objClienteDTO) {

		String sql = "insert into Cliente (cnpj,nm_cliente, nm_setor) values (?,?,?)";

		conn = new ConexaoDAO().conectaBD();

		try {

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, objClienteDTO.getCnpj());
			pstm.setString(2, objClienteDTO.getNomeCliente());
			pstm.setString(3, objClienteDTO.getNomeSetor());
			

			pstm.execute();
			pstm.close();

		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "ClienteDAO" + erro);
		}
	}
}
