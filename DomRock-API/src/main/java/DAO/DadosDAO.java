package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DTO.ProdutoDTO;

public class DadosDAO {
	Connection conn;
	PreparedStatement stm;


	public void cadastrarDados(ProdutoDTO objProdutoDTO) throws SQLException {
		String sql_id_cliente = "SELECT TOP 1 * FROM Cliente ORDER BY id_cliente DESC;";
		Connection conn1 = new ConexaoDAO().conectaBD();
		Statement stm1 = conn1.createStatement();
		ResultSet result_id_cliente = stm1.executeQuery(sql_id_cliente);
			
		while (result_id_cliente.next()) {
			int id_cliente = result_id_cliente.getInt("id_cliente");

			String sql = "INSERT INTO Cliente_Produto (id_cliente, id_produto, dado_min) values ("
						+id_cliente+", ?, ?)";
				try (Connection conn = new ConexaoDAO().conectaBD();
						PreparedStatement pstm = conn.prepareStatement(sql);) {

					if (objProdutoDTO.getIdProduto() == 1) {
						pstm.setString(2, objProdutoDTO.getIdProduto1());
						pstm.setInt(1, objProdutoDTO.getIdProduto());
						pstm.execute();
					}

					pstm.close();

				} catch (SQLException e) {

					throw new RuntimeException(e);
				}
			}

		}

}

