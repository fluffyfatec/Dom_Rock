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
			
		String sql = "EXEC proc_Cad_Gold_Silver @oparacao = ?, @desc_operacao = ? , @idcliente = ?";
		
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
					
			stm.setString(1, gold.getOperacao());
		    stm.setString(2, gold.getDescritivo());
		    stm.setString(3, gold.getIdCliente());
			stm.execute();
			stm.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public GoldDTO consultaGold(String IdCliente) {
		String sql = "SELECT DISTINCT id_gold, operacao, descritivo_operacao FROM view_bronze WHERE id_cliente = ?";
		GoldDTO  gold = new	GoldDTO();
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){	
			stm.setString(1, IdCliente); 
			rs = stm.executeQuery();
			if(rs.next())
				
				gold.setIdGold(rs.getString("id_gold"));
				gold.setOperacao(rs.getString("operacao"));
				gold.setDescritivo(rs.getString("descritivo_operacao"));	
			    
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return gold;
	}
	public void Atualizar(GoldDTO gold) throws SQLException {
		String sql = "UPDATE Gold SET operacao = ?, descritivo_operacao = ? WHERE id_gold = ?";
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
				
			stm.setString(1, gold.getOperacao());
			stm.setString(2, gold.getDescritivo());
		    stm.setString(3, gold.getIdGold());
			stm.execute();
			stm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		

}
}
