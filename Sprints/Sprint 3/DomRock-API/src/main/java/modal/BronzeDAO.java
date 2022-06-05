package modal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import controller.CrudAtivacaoController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BronzeDAO {

	Connection conn;
	PreparedStatement stm;

	public BronzeDTO cadastrorBronze(String nomeFormato, String nomeFrequencia, String nomeOrigem, String nomeSistema,
			String volume, String nomeProduto, String IdCliente) {
		BronzeDTO bronze = new BronzeDTO();
		try (Connection conn = new ConnectionFactory().conectaBD()) {
			stm = conn.prepareStatement(
					"INSERT INTO Fonte_dado(volume , frequencia , id_cliente_produto, id_origem_dado, id_formato, id_sistema)"
							+ "VALUES( ? , ? , SELECT cp.id_cliente_produto FROM Cliente_Produto cp"
							+ "		INNER JOIN Produto prod" + "		ON prod.id_produto = cp.id_produto"
							+ "		WHERE cp.id_cliente = ?" + "		AND prod.nm_produto = ?)" + "		,"
							+ "		(SELECT id_origem_dado FROM Origem_dado od" + "		WHERE od.desc_origem = ?)"
							+ "		," + "		(SELECT fmt.id_formato FROM Formato fmt"
							+ "		WHERE fmt.formato = ?)" + "		," + "		(SELECT sis.id_sistema FROM Sistema sis"
							+ "		WHERE sis.sistema = ?)" + "	  )");

			stm.setString(1, volume);
			stm.setString(2, nomeFrequencia);
			stm.setString(3, IdCliente);
			stm.setString(4, nomeProduto);
			stm.setString(5, nomeOrigem);
			stm.setString(6, nomeFormato);
			stm.setString(7, nomeSistema);
			stm.execute();
			stm.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return bronze;
	}

	public List<BronzeDTO> consultar(String IdCliente) throws SQLException {

		List<BronzeDTO> tabelabronze = new ArrayList<>();

		String sql = "SELECT nm_produto,desc_origem,formato,sistema,volume,frequencia,id_fonte_dado FROM view_bronze WHERE id_cliente = ?";

		try (Connection conn = new ConnectionFactory().conectaBD();
				PreparedStatement stm = conn.prepareStatement(sql);) {

			stm.setString(1, IdCliente);
			ResultSet resultSet = stm.executeQuery();

			while (resultSet.next()) {

				BronzeDTO bronze = new BronzeDTO();

				bronze.setNomeProduto(resultSet.getString("nm_produto"));
				bronze.setOrigenDado(resultSet.getString("desc_origem"));
				bronze.setFormato(resultSet.getString("formato"));
				bronze.setSistema(resultSet.getString("sistema"));
				bronze.setVolume(resultSet.getString("volume"));
				bronze.setFrequencia(resultSet.getString("frequencia"));
				bronze.setIdFonteDado(resultSet.getString("id_fonte_dado"));

				tabelabronze.add(bronze);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return tabelabronze;

	}

	public void deletar(String idfontedado) {
		String sql = "DELETE Fonte_dado WHERE id_fonte_dado = ?";
		try (Connection conn = new ConnectionFactory().conectaBD();
				PreparedStatement stm = conn.prepareStatement(sql);) {
            
			stm.setString(1, idfontedado);
			
		
			stm.execute();
			stm.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}