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

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ProdutoDAO {
	ConnectionFactory conn = new ConnectionFactory();
	PreparedStatement stm;
	ResultSet rs;
	
	public ProdutoDTO produtodadominimo(String produto, String dadominimo) {
		String sql = "UPDATE Produto SET dado_min = ? WHERE nm_produto = ?";
		ProdutoDTO objprodutoDTO = new ProdutoDTO();
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){		
			stm.setString(1, dadominimo);
			stm.setString(2, produto);
			stm.execute();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return objprodutoDTO;
	}
	
	public ProdutoDTO consultadadominimo(String produto) {
		String sql = "SELECT dado_min FROM Produto WHERE nm_produto = ?";
		ProdutoDTO objprodutoDTO = new ProdutoDTO();
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){	
			stm.setString(1, produto); rs = stm.executeQuery();
			if(rs.next())
			objprodutoDTO.setDadoMinimo(rs.getString("dado_min"));		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return objprodutoDTO;
	}
}
