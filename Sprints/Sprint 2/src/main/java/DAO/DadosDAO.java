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
		
			String sql = "INSERT INTO Cliente_Produto (id_produto, dado_min, id_cliente) values (?, ?, ?)";
			try (Connection conn = new ConexaoDAO().conectaBD(); PreparedStatement pstm = conn.prepareStatement(sql);) {

				if (objProdutoDTO.getCheckvox() == 1) {
					pstm.setString(2, objProdutoDTO.getVox());
					pstm.setInt(1, objProdutoDTO.getCheckvox());
					pstm.setString(3, objProdutoDTO.getIdCliente());
					pstm.execute();
				}
				if (objProdutoDTO.getCheckmarketing() == 2) {
					pstm.setString(2, objProdutoDTO.getMarketingPlanning());
					pstm.setInt(1, objProdutoDTO.getCheckmarketing());
					pstm.setString(3, objProdutoDTO.getIdCliente());
					pstm.execute();
				}
				if (objProdutoDTO.getChecksales() == 3) {
					pstm.setString(2, objProdutoDTO.getSalesDistribution());
					pstm.setInt(1, objProdutoDTO.getChecksales());
					pstm.setString(3, objProdutoDTO.getIdCliente());
					pstm.execute();
				}
				if (objProdutoDTO.getCheckpricing() == 4) {
					pstm.setString(2, objProdutoDTO.getPricing());
					pstm.setInt(1, objProdutoDTO.getCheckpricing());
					pstm.setString(3, objProdutoDTO.getIdCliente());
					pstm.execute();
				}
				if (objProdutoDTO.getCheckoptimization() == 5) {
					pstm.setString(2, objProdutoDTO.getOptimization());
					pstm.setInt(1, objProdutoDTO.getCheckoptimization());
					pstm.setString(3, objProdutoDTO.getIdCliente());
					pstm.execute();
				}
				if (objProdutoDTO.getCheckmatching() == 6) {
					pstm.setString(2, objProdutoDTO.getMatchingRisk());
					pstm.setInt(1, objProdutoDTO.getCheckmatching());
					pstm.setString(3, objProdutoDTO.getIdCliente());
					pstm.execute();
				}

				pstm.close();

			} catch (SQLException e) {

				throw new RuntimeException(e);
			}
		}

	}
