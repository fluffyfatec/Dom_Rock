package modal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SilverDAO {
	Connection conn;
	PreparedStatement stm;
	ResultSet rs;

	public List<SilverDTO> consultar(String idCliente) throws SQLException {

		List<SilverDTO> tabelaSilver = new ArrayList<>();

		String sql = "SELECT id_fonte_dado, nm_produto, desc_origem, formato, volume, sistema, frequencia FROM view_bronze WHERE id_cliente = ?";

		try (Connection conn = new ConnectionFactory().conectaBD();
				PreparedStatement stm = conn.prepareStatement(sql);) {

			stm.setString(1, idCliente);
			ResultSet resultSet = stm.executeQuery();

			while (resultSet.next()) {

				SilverDTO silver = new SilverDTO();

				silver.setIdFonteDado(resultSet.getString("id_fonte_dado"));
				silver.setNomeProduto(resultSet.getString("nm_produto"));
				silver.setOrigenDado(resultSet.getString("desc_origem"));
				silver.setFormato(resultSet.getString("formato"));
				silver.setVolume(resultSet.getString("volume"));
				silver.setSistema(resultSet.getString("sistema"));
				silver.setFrequencia(resultSet.getString("frequencia"));

				tabelaSilver.add(silver);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return tabelaSilver;

	}

	public SilverDTO cadastrarSilver(String validador, String obrigatorio, String idfontedado) throws SQLException {
		SilverDTO silver = new SilverDTO();
		String sql = "INSERT INTO Validador (desc_regra, obrigatorio, id_fonte_dado) values (?,?,?)";
		try (Connection conn = new ConnectionFactory().conectaBD();
				PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setString(1, validador);
			stm.setString(2, obrigatorio);
			stm.setString(3, idfontedado);
			stm.execute();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return silver;

	}
	public List<SilverDTO> consultarSilver(String IdCliente) throws SQLException {

		List<SilverDTO> tabelasilver = new ArrayList<>();

		String sql = "SELECT id_fonte_dado, nm_produto, desc_origem, formato, volume, sistema, frequencia, desc_regra, obrigatorio, id_validador FROM view_bronze WHERE id_cliente = ?";

		try (Connection conn = new ConnectionFactory().conectaBD();
				PreparedStatement stm = conn.prepareStatement(sql);) {

			stm.setString(1, IdCliente);
			ResultSet resultSet = stm.executeQuery();

			while (resultSet.next()) {

				SilverDTO silver = new SilverDTO();

				silver.setNomeProduto(resultSet.getString("nm_produto"));
				silver.setOrigenDado(resultSet.getString("desc_origem"));
				silver.setFormato(resultSet.getString("formato"));
				silver.setSistema(resultSet.getString("sistema"));
				silver.setVolume(resultSet.getString("volume"));
				silver.setFrequencia(resultSet.getString("frequencia"));
				silver.setIdFonteDado(resultSet.getString("id_fonte_dado"));
				silver.setObrigatorio(resultSet.getString("obrigatorio"));
				silver.setIdSilver(resultSet.getString("id_validador"));
				silver.setValidador(resultSet.getString("desc_regra"));

				tabelasilver.add(silver);
 
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return tabelasilver;

	}
	public void deletar(String idsilver) {
		String sql = "DELETE Validador WHERE id_validador = ?";
		try (Connection conn = new ConnectionFactory().conectaBD();
				PreparedStatement stm = conn.prepareStatement(sql);) {
            
			stm.setString(1, idsilver);
			
		
			stm.execute();
			stm.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public SilverDTO Atualizar(String validador, String obrigatorio, String idSilver) throws SQLException {
		String sql = "Update Validador set desc_regra = ?, obrigatorio = ? Where id_validador = ?";
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
			
			
			stm.setString(1, validador);
			stm.setString(2, obrigatorio);
			stm.setString(3, idSilver);
			stm.execute();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return null;

}

}
