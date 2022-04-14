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

			String sql = "INSERT INTO Cliente_Produto (cp_id_cliente, cp_id_produto, dado_min) values ("
						+id_cliente+", ?, ?)";
				try (Connection conn = new ConexaoDAO().conectaBD();
						PreparedStatement pstm = conn.prepareStatement(sql);) {

					if (objProdutoDTO.getCheckvox() == 1) {
						pstm.setString(2, objProdutoDTO.getVox());
						pstm.setInt(1, objProdutoDTO.getCheckvox());
						pstm.execute();
					}
					if (objProdutoDTO.getCheckmarketing() == 2) {
						pstm.setString(2, objProdutoDTO.getMarketingPlanning());
						pstm.setInt(1, objProdutoDTO.getCheckmarketing());
						pstm.execute();
					}
					if (objProdutoDTO.getChecksales() == 3) {
						pstm.setString(2, objProdutoDTO.getSalesDistribution());
						pstm.setInt(1, objProdutoDTO.getChecksales());
						pstm.execute();
					}
					if (objProdutoDTO.getCheckpricing() == 4) {
						pstm.setString(2, objProdutoDTO.getPricing());
						pstm.setInt(1, objProdutoDTO.getCheckpricing());
						pstm.execute();
					}
					if (objProdutoDTO.getCheckoptimization() == 5) {
						pstm.setString(2, objProdutoDTO.getOptimization());
						pstm.setInt(1, objProdutoDTO.getCheckoptimization());
						pstm.execute();
					}
					if (objProdutoDTO.getCheckmatching() == 6) {
						pstm.setString(2, objProdutoDTO.getMatchingRisk());
						pstm.setInt(1, objProdutoDTO.getCheckmatching());
						pstm.execute();
					}

					pstm.close();

				} catch (SQLException e) {

					throw new RuntimeException(e);
				}
			}

		}

}
