package modal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SilverDAO {
	Connection con;
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
				System.out.println(resultSet.getString("id_fonte_dado"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return tabelaSilver;

	}
}
