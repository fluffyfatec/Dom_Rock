package modal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class GoldDAO {
	
	Connection con;
	PreparedStatement stm;
	ResultSet rs;
	
	public void cadastrarOperacoes(GoldDTO gold) {
			
		String sql = "INSERT INTO Gold (operacao, descritivo_operacao) values (?,?)";
		
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
					
			String operacao = gold.getOperacao();
			
			switch (operacao) {
				case "Matching":
					stm.setString(1, "Matching");
					stm.setString(2, gold.getStrMatching());
					break;
				case "Serie Temporal":
					stm.setString(1, "Série Temporal");
					stm.setString(2, gold.getStrSerie());
					break;
				case "Join":
					stm.setString(1, "Join");
					stm.setString(2, gold.getStrJoin());
					break;
				case "Agregacao":
					stm.setString(1, "Agregação");
					stm.setString(2, gold.getStrAgregacao());
					break;
			}
			
			stm.execute();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
}
