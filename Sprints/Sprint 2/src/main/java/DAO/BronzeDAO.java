package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import DTO.BronzeDTO;
import DTO.ClienteDTO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BronzeDAO {
    
	BronzeDTO idProduto;
	Connection conn;
	PreparedStatement stm;

	public void cadastarBronze(List<? extends BronzeDTO> bronzes) throws SQLException {



		

			String cadastro = "INSERT INTO Fonte_Dado (id_cliente_produto" + "id_origem_dado," + "id_formato,"
					+ "id_sistema," + "volume," + "frequencia) " + "values (?,?,?,?,?,?,?)";

			try (Connection conn = new ConexaoDAO().conectaBD();
					PreparedStatement stm = conn.prepareStatement(cadastro);) {
				for (BronzeDTO bronze : bronzes) {
					
					
						stm.setInt(2,bronze.getIdOrigem());
						stm.setInt(3,bronze.getIdFormato());
						stm.setInt(4,bronze.getIdSistema());
						stm.setString(5,bronze.getVolume());
						stm.setString(6,bronze.getFormato());
						stm.execute();
					

				}
			} catch (SQLException e) {

				throw new RuntimeException(e);
			}

		}

	}
