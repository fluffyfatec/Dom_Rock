package DAO;

import java.sql.*;

import DTO.ClienteDTO;
import DTO.ProdutoDTO;

import com.example.view.HelloController;
import javafx.fxml.FXML;

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

			String sql = "INSERT INTO Cliente_Produto (cp_id_cliente, dado_min, cp_id_produto) values ("
						+ id_cliente + ", ?, ?)";
				try (Connection conn = new ConexaoDAO().conectaBD();
						PreparedStatement pstm = conn.prepareStatement(sql);) {

					if (objProdutoDTO.getCheckvox() == 1) {
						pstm.setString(1, objProdutoDTO.getVox());
						pstm.setInt(2, objProdutoDTO.getCheckvox());
						pstm.execute();
					}
					if (objProdutoDTO.getCheckmarketing() == 2) {
						pstm.setString(1, objProdutoDTO.getMarketingPlanning());
						pstm.setInt(2, objProdutoDTO.getCheckmarketing());
						pstm.execute();
					}
					if (objProdutoDTO.getChecksales() == 3) {
						pstm.setString(1, objProdutoDTO.getSalesDistribution());
						pstm.setInt(2, objProdutoDTO.getChecksales());
						pstm.execute();
					}
					if (objProdutoDTO.getCheckpricing() == 4) {
						pstm.setString(1, objProdutoDTO.getPricing());
						pstm.setInt(2, objProdutoDTO.getCheckpricing());
						pstm.execute();
					}
					if (objProdutoDTO.getCheckoptimization() == 5) {
						pstm.setString(1, objProdutoDTO.getOptimization());
						pstm.setInt(2, objProdutoDTO.getCheckoptimization());
						pstm.execute();
					}
					if (objProdutoDTO.getCheckmatching() == 6) {
						pstm.setString(1, objProdutoDTO.getMatchingRisk());
						pstm.setInt(2, objProdutoDTO.getCheckmatching());
						pstm.execute();
					}

					pstm.close();

				} catch (SQLException e) {

					throw new RuntimeException(e);
				}
			}

		}

}
