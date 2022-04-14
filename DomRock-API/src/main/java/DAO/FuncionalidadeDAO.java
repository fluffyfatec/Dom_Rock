package DAO;

import java.sql.*;

import javax.swing.JOptionPane;

import DTO.FuncionalidadeDTO;

public class FuncionalidadeDAO {

	Connection conn;
	PreparedStatement pstm;

	public void cadastrarFuncionalidade(FuncionalidadeDTO objFuncionalidadeDTO) throws SQLException {
		String sql_id_cliente = "SELECT TOP 1 * FROM Cliente ORDER BY id_cliente DESC;";
		Connection conn1 = new ConexaoDAO().conectaBD();
		Statement stm1 = conn1.createStatement();
		ResultSet result_id_cliente = stm1.executeQuery(sql_id_cliente);

		while (result_id_cliente.next()) {
			int id_cliente = result_id_cliente.getInt("id_cliente");

			String sql = "insert into Cliente_Funcionalidade (cf_id_cliente, cf_id_funcionalidade) values (" + id_cliente + ", ?)";

			try (Connection conn = new ConexaoDAO().conectaBD(); PreparedStatement pstm = conn.prepareStatement(sql);) {

				if (objFuncionalidadeDTO.getGeradorRelat() == 1) {
					pstm.setInt(1, objFuncionalidadeDTO.getGeradorRelat());
					pstm.execute();
				}
				if (objFuncionalidadeDTO.getPaineis() == 2) {
					pstm.setInt(1, objFuncionalidadeDTO.getPaineis());
					pstm.execute();
				}
				if (objFuncionalidadeDTO.getBuscaNlp() == 3) {
					pstm.setInt(1, objFuncionalidadeDTO.getBuscaNlp());
					pstm.execute();
				}
				if (objFuncionalidadeDTO.getGeradorData() == 4) {
					pstm.setInt(1, objFuncionalidadeDTO.getGeradorData());
					pstm.execute();
				}

				pstm.close();


			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}


	}
}
	  

