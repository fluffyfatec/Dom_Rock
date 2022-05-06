package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import DTO.ClienteDTO;
import DTO.ProdutoAtivacaoDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProdutoAtivacaoDAO {
	
	private ObservableList<ProdutoAtivacaoDTO> produtoList = FXCollections.observableArrayList();
	
	Connection conn;
	PreparedStatement stm;

	public void cadastarBronze(ProdutoAtivacaoDTO produtoAtivacaoDTO) throws SQLException {

		String sql_id_cliente = "SELECT TOP 1 * FROM Cliente ORDER BY id_cliente DESC;";
		Connection conn1 = new ConexaoDAO().conectaBD();
		Statement stm1 = conn1.createStatement();
		ResultSet result_id_cliente = stm1.executeQuery(sql_id_cliente);

		while (result_id_cliente.next()) {
			produtoList.add(produtoAtivacaoDTO);
			System.out.println(produtoList);
			int id_cliente = result_id_cliente.getInt("id_cliente");

			String cadastro = "INSERT INTO Fonte_Dado (id_cliente,id_produto," + "id_origem_dado,"
					+ "id_formato," + "id_sistema," + "volume," + "frequencia) " + "values ( "+ id_cliente + ",?,?,?,?,?,?)";
			
			try (Connection conn = new ConexaoDAO().conectaBD();
					PreparedStatement stm = conn.prepareStatement(cadastro);) {
				
				if (produtoAtivacaoDTO.getCheckvox() == 1) {
					
					
					stm.setInt(1, produtoAtivacaoDTO.getCheckvox());
					stm.setInt(2, produtoAtivacaoDTO.getIdOrigem());
					stm.setInt(3, produtoAtivacaoDTO.getIdFormato());
					stm.setInt(4, produtoAtivacaoDTO.getIdSistema());
					stm.setString(5, produtoAtivacaoDTO.getVolume());
					stm.setString(6, produtoAtivacaoDTO.getFormato());
					stm.execute();
					stm.close();
				}
				if (produtoAtivacaoDTO.getCheckmarketing() == 2) {
					
					stm.setInt(1, produtoAtivacaoDTO.getCheckmarketing());
					stm.setInt(2, produtoAtivacaoDTO.getIdOrigem());
					stm.setInt(3, produtoAtivacaoDTO.getIdFormato());
					stm.setInt(4, produtoAtivacaoDTO.getIdSistema());
					stm.setString(5, produtoAtivacaoDTO.getVolume());
					stm.setString(6, produtoAtivacaoDTO.getFormato());
					stm.execute();
					stm.close();
				}
				if (produtoAtivacaoDTO.getChecksales() == 3) {
					
					stm.setInt(1, produtoAtivacaoDTO.getChecksales());
					stm.setInt(2, produtoAtivacaoDTO.getIdOrigem());
					stm.setInt(3, produtoAtivacaoDTO.getIdFormato());
					stm.setInt(4, produtoAtivacaoDTO.getIdSistema());
					stm.setString(5, produtoAtivacaoDTO.getVolume());
					stm.setString(6, produtoAtivacaoDTO.getFormato());
					stm.execute();
					stm.close();
				}
				if (produtoAtivacaoDTO.getCheckpricing() == 4) {
					
					stm.setInt(1, produtoAtivacaoDTO.getCheckpricing());
					stm.setInt(2, produtoAtivacaoDTO.getIdOrigem());
					stm.setInt(3, produtoAtivacaoDTO.getIdFormato());
					stm.setInt(4, produtoAtivacaoDTO.getIdSistema());
					stm.setString(5, produtoAtivacaoDTO.getVolume());
					stm.setString(6, produtoAtivacaoDTO.getFormato());
					stm.execute();
					stm.close();
				}
				if (produtoAtivacaoDTO.getCheckoptimization() == 5) {
					
					stm.setInt(1, produtoAtivacaoDTO.getCheckoptimization());
					stm.setInt(2, produtoAtivacaoDTO.getIdOrigem());
					stm.setInt(3, produtoAtivacaoDTO.getIdFormato());
					stm.setInt(4, produtoAtivacaoDTO.getIdSistema());
					stm.setString(5, produtoAtivacaoDTO.getVolume());
					stm.setString(6, produtoAtivacaoDTO.getFormato());
					stm.execute();
					stm.close();
				}
				if (produtoAtivacaoDTO.getCheckmatching() == 6) {
					
					stm.setInt(1, produtoAtivacaoDTO.getCheckmatching());
					stm.setInt(2, produtoAtivacaoDTO.getIdOrigem());
					stm.setInt(3, produtoAtivacaoDTO.getIdFormato());
					stm.setInt(4, produtoAtivacaoDTO.getIdSistema());
					stm.setString(5, produtoAtivacaoDTO.getVolume());
					stm.setString(6, produtoAtivacaoDTO.getFormato());
					stm.execute();
					stm.close();
				}

			} catch (SQLException e) {

				throw new RuntimeException(e);
			}
		}
	}

}
